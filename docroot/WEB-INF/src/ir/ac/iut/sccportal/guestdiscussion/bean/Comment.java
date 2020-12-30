
package ir.ac.iut.sccportal.guestdiscussion.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment implements Serializable{
	private static final long serialVersionUID = -7901024765095281401L;
	
	private long id;
	private String comment_text;
	private String guestName;
	private Date modification_time;
	private long likecount;
	private long dislikeCount;
	private Comment parent;
	private List<Comment> answers = new ArrayList<Comment>();
	private boolean hasAnswer;
	
	private Object tag;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	
	
	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public Date getModification_time() {
		return modification_time;
	}

	public void setModification_time(Date modification_time) {
		this.modification_time = modification_time;
	}

	public long getLikecount() {
		return likecount;
	}

	public void setLikecount(long likecount) {
		this.likecount = likecount;
	}

	public Object getTag() {
		return tag;
	}

	public void setTag(Object tag) {
		this.tag = tag;
	}

	public List<Comment> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Comment> answers) {
		this.answers = answers;
	}

	public Comment getParent() {
		return parent;
	}

	public void setParent(Comment parent) {
		this.parent = parent;
	}
	
		
	public boolean isHasAnswer() {
		return hasAnswer;
	}

	public void setHasAnswer(boolean hasAnswer) {
		this.hasAnswer = hasAnswer;
	}
	
	

	public long getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(long dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Comment) {
			Comment other = (Comment)obj;
		
			return this.getId()==(other.getId());
		}
		
		return false;
	}
}