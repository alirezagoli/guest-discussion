package ir.ac.iut.sccportal.guestdiscussion.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ir.ac.iut.sccportal.guestdiscussion.model.Comment;
import ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle;
import ir.ac.iut.sccportal.guestdiscussion.model.Title;
import ir.ac.iut.sccportal.guestdiscussion.service.CommentLocalServiceUtil;
import ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleLocalServiceUtil;
import ir.ac.iut.sccportal.guestdiscussion.service.TitleLocalServiceUtil;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.primefaces.component.panel.Panel;
import org.primefaces.event.RowEditEvent;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;

@ManagedBean(name = "configB")
@ViewScoped
public class ConfigB {

	private String newTitleText;
	private List<Title> titleList;
	private Title selectedTitle;

	List<Comment> unVerifiedCommentList;
	private Comment selectedComment;

	private String portletId;
	private String currentLocale;
	private String portalEmailAddress;

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

		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		currentLocale = liferayFacesContext.getLocale().getLanguage();
		portletId = liferayFacesContext.getPortletInstanceId();
		try {
			titleList = new ArrayList<Title>(
					TitleLocalServiceUtil
							.getTitlesByCompanyId(liferayFacesContext
									.getCompanyId()));

			PortletTitle portletTitle = PortletTitleLocalServiceUtil
					.fetchPortletTitle(portletId);
			if (portletTitle != null) {
				for (int i = 0; i < titleList.size(); i++) {
					if (titleList.get(i).getTitleId() == portletTitle
							.getTitleId()) {
						selectedTitle = titleList.get(i);
						break;
					}
				}

				unVerifiedCommentList = new ArrayList<Comment>(
						CommentLocalServiceUtil
								.getCommentsByTitleId(portletTitle.getTitleId()));
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addNewTitle() {

		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		try {
			TitleLocalServiceUtil.addTitle(liferayFacesContext
					.getScopeGroupId(), liferayFacesContext.getCompanyId(),
					liferayFacesContext.getUserId(), liferayFacesContext
							.getUser().getFullName(), newTitleText);

			titleList = new ArrayList<Title>(
					TitleLocalServiceUtil
							.getTitlesByCompanyId(liferayFacesContext
									.getCompanyId()));

			PortletTitle portletTitle = PortletTitleLocalServiceUtil
					.fetchPortletTitle(portletId);

			if (portletTitle != null) {
				for (int i = 0; i < titleList.size(); i++) {
					if (titleList.get(i).getTitleId() == portletTitle
							.getTitleId()) {
						selectedTitle = titleList.get(i);
						break;
					}
				}
			}

		} catch (NoSuchUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		newTitleText = "";

	}

	public void selectTitle() {

		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();

		/*
		 * PortletTitle portletTitle = PortletTitleLocalServiceUtil
		 * .createPortletTitle(portletId);
		 * portletTitle.setTitleId(Long.parseLong(selectedTitle));
		 */

		try {
			PortletTitle portletTitle = PortletTitleLocalServiceUtil
					.fetchPortletTitle(portletId);
			if (portletTitle != null) {
				portletTitle.setTitleId(selectedTitle.getTitleId());
				PortletTitleLocalServiceUtil.updatePortletTitle(portletTitle);
			} else {
				portletTitle = PortletTitleLocalServiceUtil
						.createPortletTitle(portletId);
				portletTitle.setTitleId(selectedTitle.getTitleId());
				PortletTitleLocalServiceUtil.addPortletTitle(portletTitle);
			}

			if (liferayFacesContext.getLocale().getLanguage() == "en") {
				addInfoMessage("Title has been chosen successfully!",
						"savebutton");

			} else {

				addInfoMessage("موضوع با موفقیت انتخاب شد!", "savebutton");
			}

			unVerifiedCommentList = new ArrayList<Comment>(
					CommentLocalServiceUtil.getCommentsByTitleId(selectedTitle
							.getTitleId()));

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onRowEdit(RowEditEvent event) {
		// FacesMessage msg = new FacesMessage("Place Edited", ((Place)
		// event.getObject()).getName());
		// FacesContext.getCurrentInstance().addMessage(null, msg);
		Title title = (Title) event.getObject();
		try {
			TitleLocalServiceUtil.updateTitle(title);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onRowCancel(RowEditEvent event) {
		// FacesMessage msg = new FacesMessage("Edit Cancelled", ((Place)
		// event.getObject()).getName());
		// FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void deleteTitle() {
		try {
			CommentLocalServiceUtil.deleteCommentsByTitleId(selectedTitle
					.getTitleId());
			PortletTitleLocalServiceUtil
					.deletePortletTitleByTitleId(selectedTitle.getTitleId());
			TitleLocalServiceUtil.deleteTitle(selectedTitle);
			titleList.remove(selectedTitle);

			PortletTitle portletTitle = PortletTitleLocalServiceUtil
					.fetchPortletTitle(portletId);

			if (portletTitle != null) {
				for (int i = 0; i < titleList.size(); i++) {
					if (titleList.get(i).getTitleId() == portletTitle
							.getTitleId()) {
						selectedTitle = titleList.get(i);
						break;
					}
				}
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void verifyComment() {
		if (selectedComment.getVerified() == false) {
			selectedComment.setVerified(true);
			if (selectedComment.getParentId() != -1) {
				for (int i = 0; i < unVerifiedCommentList.size(); i++) {
					if (unVerifiedCommentList.get(i).getCommentId() == selectedComment
							.getParentId()) {
						if (unVerifiedCommentList.get(i)
								.getGuestEmailNotification() == true) {
							sendMail(unVerifiedCommentList.get(i)
									.getGuestEmailAddress(),
									selectedComment.getGuestName());
						}
						break;
					}
				}
			}
		} else {
			selectedComment.setVerified(false);
		}
		try {
			CommentLocalServiceUtil.updateComment(selectedComment);
			selectedComment = null;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteComment() {
		try {
			CommentLocalServiceUtil.deleteComment(selectedComment);
			unVerifiedCommentList.remove(selectedComment);
			selectedComment = null;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addInfoMessage(String summary, String id) {
		FacesContext.getCurrentInstance().addMessage(id,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, summary));
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
							+ selectedTitle.getTitleText() + "\"");
					mailMessage.setBody(replierName
							+ " has sent a new reply to your comment.");
				} else {
					mailMessage.setSubject("پاسخ جدید از بحث \""
							+ selectedTitle.getTitleText() + "\"");
					mailMessage.setBody(replierName
							+ " پاسخ جدیدی به پیام شما داده است.");

				}

				MailServiceUtil.sendEmail(mailMessage);
			} catch (AddressException e) {
				e.printStackTrace();
			}
		}
	}

	public String getNewTitleText() {
		return newTitleText;
	}

	public void setNewTitleText(String newTitleText) {
		this.newTitleText = newTitleText;
	}

	public List<Title> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<Title> titleList) {
		this.titleList = titleList;
	}

	public Title getSelectedTitle() {
		return selectedTitle;
	}

	public void setSelectedTitle(Title selectedTitle) {
		this.selectedTitle = selectedTitle;
	}

	public String getPortletId() {
		return portletId;
	}

	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}

	public String getCurrentLocale() {
		return currentLocale;
	}

	public void setCurrentLocale(String currentLocale) {
		this.currentLocale = currentLocale;
	}

	public List<Comment> getUnVerifiedCommentList() {
		return unVerifiedCommentList;
	}

	public void setUnVerifiedCommentList(List<Comment> unVerifiedCommentList) {
		this.unVerifiedCommentList = unVerifiedCommentList;
	}

	public Comment getSelectedComment() {
		return selectedComment;
	}

	public void setSelectedComment(Comment selectedComment) {
		this.selectedComment = selectedComment;
	}

}
