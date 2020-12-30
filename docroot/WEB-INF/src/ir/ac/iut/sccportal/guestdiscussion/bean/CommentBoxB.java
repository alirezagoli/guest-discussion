package ir.ac.iut.sccportal.guestdiscussion.bean;

import ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle;
import ir.ac.iut.sccportal.guestdiscussion.model.Title;
import ir.ac.iut.sccportal.guestdiscussion.service.CommentLocalServiceUtil;
import ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleLocalServiceUtil;
import ir.ac.iut.sccportal.guestdiscussion.service.TitleLocalServiceUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.application.ProjectStage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.net.ssl.HttpsURLConnection;
import javax.portlet.PortletRequest;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;

@ManagedBean(name = "commentBoxB")
@ViewScoped
public class CommentBoxB extends UINamingContainer {

	public static final String RESOURCE_BUNDLE = "Language";

	private String currentUserAvatarUrl;
	private String currentUserUsername;
	private String guestName;
	private String new_comment_editor_text;
	private List<Comment> comments;
	private Boolean canEditAll;
	private Boolean canDeleteAll;
	private long commentCount;
	private long commentsPerPage;
	private long currentPage;
	private String edit_comment_editor_text;
	private String answer_comment_editor_text;
	private Boolean enableLiveFeatures;
	private String contextID;
	private String discussionTitle;
	private long titleId;
	private String guestEmailAddress;
	private boolean guestEmailNotification;
	private boolean administratorFeatures;

	private TreeNode reversedTree;
	private String currentLocale;
	private String portalEmailAddress;

	// simulation functions

	private void loadAnswerComments(Comment parentComment) {
		try {
			List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> answerCommentList = CommentLocalServiceUtil
					.getCommentsByParentId_TitleId_Verified(
							parentComment.getId(), titleId, true);
			parentComment.setAnswers(new ArrayList<Comment>());
			for (int i = 0; i < answerCommentList.size(); i++) {
				Comment answerComment = new Comment();
				answerComment.setId(answerCommentList.get(i).getCommentId());
				answerComment.setComment_text(answerCommentList.get(i)
						.getCommentText());
				answerComment.setGuestName(answerCommentList.get(i)
						.getGuestName());
				answerComment.setModification_time(answerCommentList.get(i)
						.getModifiedDate());
				answerComment.setLikecount(answerCommentList.get(i)
						.getLikeCount());
				answerComment.setDislikeCount(answerCommentList.get(i)
						.getDislikeCount());
				answerComment.setParent(parentComment);
				answerComment.setHasAnswer(answerCommentList.get(i)
						.getHasAnswer());
				if (answerCommentList.get(i).getHasAnswer() == true) {
					loadAnswerComments(answerComment);
				}
				parentComment.getAnswers().add(answerComment);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadRootComments() {
		/*
		 * comments = dbSimulator.getRootComments((currentPage - 1L)
		 * commentsPerPage, commentsPerPage); commentCount =
		 * dbSimulator.getRootCommentCount();
		 */
		try {
			List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> rootCommentList = CommentLocalServiceUtil
					.getCommentsByParentId_TitleId_Verified(-1, titleId, true);
			comments = new ArrayList<Comment>();

			for (int i = 0; i < rootCommentList.size(); i++) {
				Comment rootComment = new Comment();
				rootComment.setId(rootCommentList.get(i).getCommentId());
				rootComment.setComment_text(rootCommentList.get(i)
						.getCommentText());
				rootComment.setGuestName(rootCommentList.get(i).getGuestName());
				rootComment.setModification_time(rootCommentList.get(i)
						.getModifiedDate());
				rootComment.setLikecount(rootCommentList.get(i).getLikeCount());
				rootComment.setDislikeCount(rootCommentList.get(i)
						.getDislikeCount());
				rootComment.setParent(null);
				rootComment.setHasAnswer(rootCommentList.get(i).getHasAnswer());
				if (rootCommentList.get(i).getHasAnswer() == true) {
					loadAnswerComments(rootComment);
				}

				comments.add(rootComment);

			}
			commentCount = rootCommentList.size();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {

		try {
			Map<String, String[]> serverPortletPreferencesMap;
			serverPortletPreferencesMap = PrefsPropsUtil.getPreferences()
					.getMap();
			portalEmailAddress = serverPortletPreferencesMap
					.get(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER)[0];
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String lower = "abcdefghigklmnopqrstuvwxyz";
		String upper = lower.toUpperCase();
		String alphabets = lower + upper;
		final int N = alphabets.length();
		Random r = new Random();
		int randomNumber1 = r.nextInt(N);
		int randomNumber2 = r.nextInt(N);
		String firstPart = alphabets
				.substring(randomNumber1, randomNumber1 + 1);
		String secondPart = alphabets.substring(randomNumber2,
				randomNumber2 + 1);
		String randomId = firstPart + secondPart;
		setId(randomId);
		currentUserAvatarUrl = "../resources/images/default_avatar.png";
		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();

		currentLocale = liferayFacesContext.getLocale().getLanguage();
		administratorFeatures = false;
		try {
			PortletTitle portletTitle = PortletTitleLocalServiceUtil
					.fetchPortletTitle(liferayFacesContext
							.getPortletInstanceId());
			if (portletTitle != null) {
				titleId = portletTitle.getTitleId();
				Title title = TitleLocalServiceUtil.getTitle(titleId);
				discussionTitle = title.getTitleText();
				for (int i = 0; i < liferayFacesContext.getUser().getRoles()
						.size(); i++) {
					if (liferayFacesContext.getUser().getRoles().get(i)
							.getName().equals("Administrator")) {
						Title currentTitle = TitleLocalServiceUtil
								.getTitle(titleId);
						new_comment_editor_text = currentTitle
								.getNewCommentDraft();
						answer_comment_editor_text = currentTitle
								.getAnswerCommentDraft();
						administratorFeatures = true;

						break;
					}
				}

			} else {
				titleId = -1;
				if (liferayFacesContext.getLocale().getLanguage() == "en") {
					discussionTitle = "No Title";

				} else {
					discussionTitle = "بدون موضوع";
				}

			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (liferayFacesContext.getLocale().getLanguage() == "en") {
			currentUserUsername = "Please enter your comment in area below";

		} else {
			currentUserUsername = "لطفا نظرات خود را در کادر متنی زیر وارد کنید";
		}
		enableLiveFeatures = false;

		// simulation codes
		commentsPerPage = 30L;
		currentPage = 1L;

		if (titleId != -1) {
			loadRootComments();

		} else {
			comments = new ArrayList<Comment>();
			commentCount = 0;
		}

	}

	// helping functions

	public void addErrorMessage(String summary, String id) {
		FacesContext.getCurrentInstance().addMessage(id,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, null, summary));
	}

	public void addInfoMessage(String summary, String id) {
		FacesContext.getCurrentInstance().addMessage(id,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, summary));
	}

	private void _generateTree(TreeNode tn, Comment comment) {
		TreeNode node0 = new DefaultTreeNode(new Pair<Boolean, Comment>(false,
				comment), tn);
		node0.setExpanded(true);

		// Add dummy child
		new DefaultTreeNode(new Pair<Boolean, Comment>(true, comment), node0);

		List<Comment> comments = comment.getAnswers();

		for (int i = comments.size() - 1; i >= 0; i--) {
			_generateTree(node0, comments.get(i));
		}
	}

	private void initTree() {
		if (reversedTree == null) {
			reversedTree = new DefaultTreeNode("Root", null);

			List<Comment> comments = getComments();

			for (int i = comments.size() - 1; i >= 0; i--) {
				_generateTree(reversedTree, comments.get(i));
			}
		}
	}

	private static String mapToJSON(ResourceBundle bundle) {
		String json = "{";
		String iterator = "";

		for (String k : bundle.keySet()) {
			json += iterator + "\"" + k + "\"" + ":" + "\""
					+ bundle.getString(k) + "\"";
			iterator = ",";
		}

		json += "}";

		return json;
	}

	private Comment _createComment(String text) {
		Comment comment = new Comment();
		comment.setComment_text(text);
		comment.setModification_time(new Date());
		if (guestName != null && guestName != "") {
			comment.setGuestName(guestName);
		} else {
			LiferayFacesContext liferayFacesContext = LiferayFacesContext
					.getInstance();
			if (liferayFacesContext.getLocale().getLanguage() == "en") {
				comment.setGuestName("Anonymous");

			} else {
				comment.setGuestName("ناشناس");
			}
		}

		return comment;
	}

	public void addNode(Comment comment, TreeNode parent) {
		TreeNode node0 = new DefaultTreeNode(new Pair<Boolean, Comment>(false,
				comment), parent);
		node0.setExpanded(true);

		// Add dummy child
		new DefaultTreeNode(new Pair<Boolean, Comment>(true, comment), node0);
	}

	public static void log(String msg) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		if (ctx.isProjectStage(ProjectStage.Development)) {
			Logger.getLogger("CommentBox").info(msg);
		}
	}

	/*
	 * public void push(String msg) { if (!getEnableLiveFeatures()) { return; }
	 * 
	 * log("push: " + msg);
	 * 
	 * PushContext pushContext = PushContextFactory.getDefault()
	 * .getPushContext(); pushContext.push( "/commentboxpush-" +
	 * this.getClientId() + "-" + this.getContextID(), msg); }
	 */

	private void _getCommentsAsList(List<Comment> comments,
			List<Comment> commentsAsList) {
		for (Comment comment : comments) {
			commentsAsList.add(comment);
			_getCommentsAsList(comment.getAnswers(), commentsAsList);
		}
	}

	private List<Comment> getCommentsAsList() {
		List<Comment> result = new ArrayList<Comment>();
		_getCommentsAsList(getComments(), result);
		return result;
	}

	private Comment findCommentByID(long id) {
		List<Comment> commentsAsList = getCommentsAsList();

		for (Comment comment : commentsAsList) {
			if (comment.getId() == (id)) {
				return comment;
			}
		}

		return null;
	}

	private void _getTreeAsList(List<TreeNode> children,
			List<TreeNode> nodesAsList) {
		for (TreeNode node : children) {
			nodesAsList.add(node);
			_getTreeAsList(node.getChildren(), nodesAsList);
		}
	}

	private List<TreeNode> getTreeAsList() {
		List<TreeNode> result = new ArrayList<TreeNode>();
		_getTreeAsList(reversedTree.getChildren(), result);
		return result;
	}

	@SuppressWarnings("unchecked")
	private TreeNode findByComment(Comment comment) {
		List<TreeNode> treeAsList = getTreeAsList();

		for (TreeNode treeNode : treeAsList) {
			Pair<Boolean, Comment> wrapper = (Pair<Boolean, Comment>) treeNode
					.getData();

			if (wrapper.getRight().equals(comment)) {
				return treeNode;
			}
		}

		return null;
	}

	private boolean verifyRecaptcha(String gRecaptchaResponse) {

		if (administratorFeatures == true) {
			return true;
		}

		URL obj;
		String secret = "";
		try {

			obj = new URL("https://www.google.com/recaptcha/api/siteverify");
			HttpsURLConnection connection = (HttpsURLConnection) obj
					.openConnection();
			connection.setRequestMethod("POST");

			String postParams = "secret=" + secret + "&response="
					+ gRecaptchaResponse;

			connection.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JsonReader jsonReader = Json.createReader(new StringReader(response
					.toString()));
			JsonObject jsonObject = jsonReader.readObject();
			jsonReader.close();

			return jsonObject.getBoolean("success");

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public boolean validateEmail(String emailAddress) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern;
		pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher;
		matcher = pattern.matcher(emailAddress);
		return matcher.matches();
	}

	public void sendMail(String ReceiverEmailAddress, String replierName) {
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;

		if (portalEmailAddress != null && portalEmailAddress != "") {
			try {
				fromAddress = new InternetAddress(portalEmailAddress);
				toAddress = new InternetAddress(ReceiverEmailAddress);
				MailMessage mailMessage = new MailMessage();
				mailMessage.setTo(toAddress);
				mailMessage.setFrom(fromAddress);

				if (currentLocale == "en") {
					mailMessage.setSubject("New reply from discussion \""
							+ discussionTitle + "\"");
					mailMessage.setBody(replierName
							+ " has sent a new reply to your comment.");
				} else {
					mailMessage.setSubject("پاسخ جدید از بحث \""
							+ discussionTitle + "\"");
					mailMessage.setBody(replierName
							+ " پاسخ جدیدی به پیام شما داده است.");

				}

				MailServiceUtil.sendEmail(mailMessage);
			} catch (AddressException e) {
				e.printStackTrace();
			}
		}
	}

	// in XHTML functions
	public static String cid(UIComponent component) {
		FacesContext context = FacesContext.getCurrentInstance();
		return component.getClientId(context);
	}

	public void createComment() {

		if ((guestEmailAddress == "" && guestEmailNotification == false)
				|| (validateEmail(guestEmailAddress) == true)) {

			if (titleId != -1 && new_comment_editor_text.length() != 0) {

				log("createComment");

				FacesContext facesContext = FacesContext.getCurrentInstance();
				ExternalContext externalContext = facesContext
						.getExternalContext();
				PortletRequest portletRequest = (PortletRequest) externalContext
						.getRequest();
				String gRecaptchaResponse = portletRequest
						.getParameter("g-recaptcha-response");

				if (verifyRecaptcha(gRecaptchaResponse) == true) {
					boolean insertComment = false;

					List<Comment> comments = getComments();
					Comment comment = _createComment(new_comment_editor_text);

					LiferayFacesContext liferayFacesContext = LiferayFacesContext
							.getInstance();
					ir.ac.iut.sccportal.guestdiscussion.model.Comment databaseComment = null;
					try {
						if (guestName != null && guestName != "") {
							databaseComment = CommentLocalServiceUtil
									.addComment(liferayFacesContext
											.getScopeGroupId(),
											liferayFacesContext.getCompanyId(),
											new Date(), -1,
											new_comment_editor_text, guestName,
											0, titleId, administratorFeatures,
											false, "-", guestEmailAddress,
											guestEmailNotification);
						}

						else {
							if (liferayFacesContext.getLocale().getLanguage() == "en") {
								databaseComment = CommentLocalServiceUtil
										.addComment(liferayFacesContext
												.getScopeGroupId(),
												liferayFacesContext
														.getCompanyId(),
												new Date(), -1,
												new_comment_editor_text,
												"Anonymous", 0, titleId,
												administratorFeatures, false,
												"-", guestEmailAddress,
												guestEmailNotification);

							} else {
								databaseComment = CommentLocalServiceUtil
										.addComment(liferayFacesContext
												.getScopeGroupId(),
												liferayFacesContext
														.getCompanyId(),
												new Date(), -1,
												new_comment_editor_text,
												"ناشناس", 0, titleId,
												administratorFeatures, false,
												"-", guestEmailAddress,
												guestEmailNotification);
							}

						}

						if (administratorFeatures == true) {
							comment.setId(databaseComment.getCommentId());
							comments.add(0, comment);
							addNode(comment, this.reversedTree);
							Title currentTitle = TitleLocalServiceUtil
									.getTitle(titleId);
							currentTitle.setNewCommentDraft("");
							TitleLocalServiceUtil.updateTitle(currentTitle);
							new_comment_editor_text = "";

							if (liferayFacesContext.getLocale().getLanguage() == "en") {
								addInfoMessage(
										"Your Comment recevied successfully!",
										"newcomment");

							} else {

								addInfoMessage("پیام شما با موفقیت دریافت شد!",
										"newcomment");
							}

						}

						else {

							if (liferayFacesContext.getLocale().getLanguage() == "en") {
								addInfoMessage(
										"Your Comment recevied successfully and will be shown after verification!",
										"newcomment");

							} else {

								addInfoMessage(
										"پیام شما با موفقیت دریافت شد و پس از تایید نمایش داده خواهد شد!",
										"newcomment");
							}

						}

						insertComment = true;
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Throwable e) {
						if (liferayFacesContext.getLocale().getLanguage() == "en") {
							addErrorMessage(
									"Your comment is too long (maximum 8000 character)!",
									"newcomment");

						} else {

							addErrorMessage(
									"پیام شما طولانی است (حداکثر طول پیام 8000 کاراکتر)!",
									"newcomment");
						}
					}

					// onCreateComment simulation codes
					/*
					 * if (1==1) { dbSimulator.createComment(comment);
					 * insertComment = true; }
					 */

					if (insertComment) {
						// comment.setId(databaseComment.getCommentId());
						// comments.add(0, comment);
						// addNode(comment, this.reversedTree);
					}
				}

				else {
					if (currentLocale == "en") {
						addErrorMessage(
								"The security challenge has not sloved correctly!",
								"newcomment");

					} else {

						addErrorMessage("چالش امنیتی به درستی حل نشده است!",
								"newcomment");
					}
				}
			}

			else if (new_comment_editor_text.length() == 0) {

				if (currentLocale == "en") {
					addErrorMessage("The comment text is empty!", "newcomment");

				} else {

					addErrorMessage("متن پیام خالی است!", "newcomment");
				}
			} else {

				if (currentLocale == "en") {
					addErrorMessage("You should choose a topic first!",
							"newcomment");

				} else {

					addErrorMessage("ابتدا یک موضوع باید انتخاب شود!",
							"newcomment");
				}

			}
		} else {
			if (currentLocale == "en") {
				addErrorMessage("The email address is not valid!", "newcomment");

			} else {

				addErrorMessage("آدرس ایمیل به درستی وارد نشده است!",
						"newcomment");
			}
		}

	}

	public void fetchNewComments() {
		log("fetchNewComments");

		// onFetchNewComments simulation code
		if (1 == 1) {
			loadRootComments();
		}

		this.reversedTree = null;
		initTree();
	}

	public void likeComment(Comment comment) {
		log("likeComment");

		comment.setLikecount(comment.getLikecount() + 1);

		try {
			ir.ac.iut.sccportal.guestdiscussion.model.Comment databaseComment = CommentLocalServiceUtil
					.getComment(comment.getId());
			databaseComment.setLikeCount(databaseComment.getLikeCount() + 1);
			CommentLocalServiceUtil.updateComment(databaseComment);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// onLikeComment simulation code
		/*
		 * if (1 == 1) { dbSimulator.likeComment(comment); }
		 */
	}

	public void dislikeComment(Comment comment) {
		log("likeComment");

		comment.setDislikeCount(comment.getDislikeCount() + 1);

		try {
			ir.ac.iut.sccportal.guestdiscussion.model.Comment databaseComment = CommentLocalServiceUtil
					.getComment(comment.getId());
			databaseComment
					.setDislikeCount(databaseComment.getDislikeCount() + 1);
			CommentLocalServiceUtil.updateComment(databaseComment);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// onLikeComment simulation code
		/*
		 * if (1 == 1) { dbSimulator.likeComment(comment); }
		 */
	}

	public void answerComment() {

		if ((guestEmailAddress == "" && guestEmailNotification == false)
				|| (validateEmail(guestEmailAddress) == true)) {

			if (answer_comment_editor_text.length() != 0) {

				log("answerComment");

				FacesContext facesContext = FacesContext.getCurrentInstance();
				ExternalContext externalContext = facesContext
						.getExternalContext();
				PortletRequest portletRequest = (PortletRequest) externalContext
						.getRequest();
				String gRecaptchaResponse = portletRequest
						.getParameter("g-recaptcha-response");

				if (verifyRecaptcha(gRecaptchaResponse) == true) {

					Map<String, String> params = FacesContext
							.getCurrentInstance().getExternalContext()
							.getRequestParameterMap();
					String answerID = params.get("currentAnswerComment");

					boolean insertComment = false;

					Comment parent = findCommentByID(Long.parseLong(answerID));

					Comment comment = _createComment(answer_comment_editor_text);
					comment.setParent(parent);

					LiferayFacesContext liferayFacesContext = LiferayFacesContext
							.getInstance();

					ir.ac.iut.sccportal.guestdiscussion.model.Comment newDatabaseComment = null;

					try {

						if (guestName != null && guestName != "") {
							newDatabaseComment = CommentLocalServiceUtil
									.addComment(liferayFacesContext
											.getHostGroupId(),
											liferayFacesContext.getCompanyId(),
											new Date(), parent.getId(),
											answer_comment_editor_text,
											guestName, 0, titleId,
											administratorFeatures, false,
											parent.getGuestName(),
											guestEmailAddress,
											guestEmailNotification);
						}

						else {
							if (liferayFacesContext.getLocale().getLanguage() == "en") {

								newDatabaseComment = CommentLocalServiceUtil
										.addComment(liferayFacesContext
												.getHostGroupId(),
												liferayFacesContext
														.getCompanyId(),
												new Date(), parent.getId(),
												answer_comment_editor_text,
												"Anonymous", 0, titleId,
												administratorFeatures, false,
												parent.getGuestName(),
												guestEmailAddress,
												guestEmailNotification);

							} else {
								newDatabaseComment = CommentLocalServiceUtil
										.addComment(liferayFacesContext
												.getHostGroupId(),
												liferayFacesContext
														.getCompanyId(),
												new Date(), parent.getId(),
												answer_comment_editor_text,
												"ناشناس", 0, titleId,
												administratorFeatures, false,
												parent.getGuestName(),
												guestEmailAddress,
												guestEmailNotification);

							}

						}

						if (parent.isHasAnswer() == false) {
							ir.ac.iut.sccportal.guestdiscussion.model.Comment databaseComment = CommentLocalServiceUtil
									.getComment(parent.getId());
							databaseComment.setHasAnswer(true);
							CommentLocalServiceUtil
									.updateComment(databaseComment);
						}

						if (administratorFeatures == true) {
							comment.setId(newDatabaseComment.getCommentId());
							comment.getParent().getAnswers().add(0, comment);
							addNode(comment, findByComment(comment.getParent()));

							Title currentTitle = TitleLocalServiceUtil
									.getTitle(titleId);
							currentTitle.setAnswerCommentDraft("");
							TitleLocalServiceUtil.updateTitle(currentTitle);
							answer_comment_editor_text = "";

							ir.ac.iut.sccportal.guestdiscussion.model.Comment databaseParentComment = CommentLocalServiceUtil
									.getComment(parent.getId());
							if (databaseParentComment.getGuestEmailNotification() == true) {
								sendMail(databaseParentComment.getGuestEmailAddress(),newDatabaseComment.getGuestName());
							}

							if (liferayFacesContext.getLocale().getLanguage() == "en") {
								addInfoMessage(
										"Your Answer recevied successfully!",
										"newanswer");

							} else {

								addInfoMessage("پاسخ شما با موفقیت دریافت شد!",
										"newanswer");
							}
						}

						else {

							if (liferayFacesContext.getLocale().getLanguage() == "en") {
								addInfoMessage(
										"Your Answer recevied successfully and will be shown after verification!",
										"newanswer");

							} else {

								addInfoMessage(
										"پاسخ شما با موفقیت دریافت شد و پس از تایید نمایش داده خواهد شد!",
										"newanswer");
							}
						}
						insertComment = true;
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Throwable e) {
						if (liferayFacesContext.getLocale().getLanguage() == "en") {
							addErrorMessage(
									"Your comment is too long (maximum 8000 character)!",
									"newanswer");

						} else {

							addErrorMessage(
									"پاسخ شما طولانی است (حداکثر طول پاسخ 8000 کاراکتر)!",
									"newanswer");
						}
					}

					// onCreateAnswer simulation code
					/*
					 * if (1 == 1) {
					 * dbSimulator.createAnswer(comment.getParent(), comment);
					 * insertComment = true; }
					 */

					if (insertComment) {
						// comment.setId(newDatabaseComment.getCommentId());
						// comment.getParent().getAnswers().add(0, comment);
						// addNode(comment, findByComment(comment.getParent()));

					}
				} else {
					if (currentLocale == "en") {
						addErrorMessage(
								"The security challenge has not sloved correctly!",
								"newanswer");

					} else {

						addErrorMessage("چالش امنیتی به درستی حل نشده است!",
								"newanswer");
					}
				}

			} else {

				if (currentLocale == "en") {
					addErrorMessage("The answer text is empty!", "newanswer");

				} else {

					addErrorMessage("متن پاسخ خالی است!", "newanswer");
				}
			}
		} else {
			if (currentLocale == "en") {
				addErrorMessage("The email address is not valid!", "newanswer");

			} else {

				addErrorMessage("آدرس ایمیل به درستی وارد نشده است!",
						"newanswer");
			}
		}
	}

	public void saveNewCommentDraft() {
		try {
			Title currentTitle = TitleLocalServiceUtil.getTitle(titleId);
			currentTitle.setNewCommentDraft(new_comment_editor_text);
			TitleLocalServiceUtil.updateTitle(currentTitle);

			if (currentLocale == "en") {
				addInfoMessage("Your draft is saved successfully!", "newanswer");

			} else {

				addInfoMessage("پیش نویس شما با موفقیت ذخیره شد!", "newcomment");
			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saveAnswerCommentDraft() {
		try {
			Title currentTitle = TitleLocalServiceUtil.getTitle(titleId);
			currentTitle.setAnswerCommentDraft(answer_comment_editor_text);
			TitleLocalServiceUtil.updateTitle(currentTitle);

			if (currentLocale == "en") {
				addInfoMessage("Your draft has been saved successfully!",
						"newanswer");

			} else {

				addInfoMessage("پیش نویس شما با موفقیت ذخیره شد!", "newanswer");
			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void pageChange(Long page) {
		FacesContext ctx = FacesContext.getCurrentInstance();

		ValueExpression valueExpression = this
				.getValueExpression("currentPage");

		if (valueExpression != null) {
			valueExpression.setValue(ctx.getELContext(), page);
		}

		// onPageChange simulation code
		if (1 == 1) {
			loadRootComments();
		}

		this.reversedTree = null;
		initTree();
	}

	public void onUserType() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String answerID = params.get("currentAnswerComment");

	}

	public void fetchNewAnswers() {
		log("fetchNewAnswers");

		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String answerID = params.get("currentAnswerComment");

		this.findCommentByID(Long.parseLong(answerID)).setAnswers(null);
		loadAnswerComments(this.findCommentByID(Long.parseLong(answerID)));

		// onFetchNewAnswers simulation code
		/*
		 * if (1 == 1) {
		 * this.findCommentByID(Long.parseLong(answerID)).setAnswers(
		 * dbSimulator.getAnswers(this.findCommentByID(Long
		 * .parseLong(answerID)))); }
		 */
		this.reversedTree = null;
		initTree();
	}

	public String getCurrentUserAvatarUrl() {
		return currentUserAvatarUrl;
	}

	public void setCurrentUserAvatarUrl(String currentUserAvatarUrl) {
		this.currentUserAvatarUrl = currentUserAvatarUrl;
	}

	public String getCurrentUserUsername() {
		return currentUserUsername;
	}

	public void setCurrentUserUsername(String currentUserUsername) {
		this.currentUserUsername = currentUserUsername;
	}

	public String getNew_comment_editor_text() {
		return new_comment_editor_text;
	}

	public void setNew_comment_editor_text(String new_comment_editor_text) {
		this.new_comment_editor_text = new_comment_editor_text;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public TreeNode getTree() {
		initTree();
		return this.reversedTree;
	}

	public void setTree(TreeNode tree) {
		this.reversedTree = tree;
	}

	public Boolean getCanEditAll() {
		return canEditAll;
	}

	public void setCanEditAll(Boolean canEditAll) {
		this.canEditAll = canEditAll;
	}

	public Boolean getCanDeleteAll() {
		return canDeleteAll;
	}

	public void setCanDeleteAll(Boolean canDeleteAll) {
		this.canDeleteAll = canDeleteAll;
	}

	public long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}

	public long getCommentsPerPage() {
		return commentsPerPage;
	}

	public void setCommentsPerPage(long commentsPerPage) {
		this.commentsPerPage = commentsPerPage;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public Long getLastPage() {
		return (long) Math.ceil((double) this.getCommentCount()
				/ (double) this.getCommentsPerPage());
	}

	public String getEdit_comment_editor_text() {
		return edit_comment_editor_text;
	}

	public void setEdit_comment_editor_text(String edit_comment_editor_text) {
		this.edit_comment_editor_text = edit_comment_editor_text;
	}

	public String getAnswer_comment_editor_text() {
		return answer_comment_editor_text;
	}

	public void setAnswer_comment_editor_text(String answer_comment_editor_text) {
		this.answer_comment_editor_text = answer_comment_editor_text;
	}

	public Boolean getEnableLiveFeatures() {
		return enableLiveFeatures;
	}

	public void setEnableLiveFeatures(Boolean enableLiveFeatures) {
		this.enableLiveFeatures = enableLiveFeatures;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public String getMessageBundleAsJSON() {
		return mapToJSON(this.getCustomMessageBundle());
	}

	public ResourceBundle getCustomMessageBundle() {
		return ResourceBundle.getBundle(RESOURCE_BUNDLE, FacesContext
				.getCurrentInstance().getViewRoot().getLocale());
	}

	public String getDiscussionTitle() {
		return discussionTitle;
	}

	public void setDiscussionTitle(String discussionTitle) {
		this.discussionTitle = discussionTitle;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getCurrentLocale() {
		return currentLocale;
	}

	public void setCurrentLocale(String currentLocale) {
		this.currentLocale = currentLocale;
	}

	public String getGuestEmailAddress() {
		return guestEmailAddress;
	}

	public void setGuestEmailAddress(String guestEmailAddress) {
		this.guestEmailAddress = guestEmailAddress;
	}

	public boolean isGuestEmailNotification() {
		return guestEmailNotification;
	}

	public void setGuestEmailNotification(boolean guestEmailNotification) {
		this.guestEmailNotification = guestEmailNotification;
	}

	public boolean isAdministratorFeatures() {
		return administratorFeatures;
	}

	public void setAdministratorFeatures(boolean administratorFeatures) {
		this.administratorFeatures = administratorFeatures;
	}

	public long getTitleId() {
		return titleId;
	}

	public void setTitleId(long titleId) {
		this.titleId = titleId;
	}

}
