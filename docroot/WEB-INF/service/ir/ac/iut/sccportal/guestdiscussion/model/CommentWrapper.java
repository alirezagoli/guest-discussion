/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ir.ac.iut.sccportal.guestdiscussion.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Comment}.
 * </p>
 *
 * @author Alireza
 * @see Comment
 * @generated
 */
public class CommentWrapper implements Comment, ModelWrapper<Comment> {
	public CommentWrapper(Comment comment) {
		_comment = comment;
	}

	@Override
	public Class<?> getModelClass() {
		return Comment.class;
	}

	@Override
	public String getModelClassName() {
		return Comment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commentId", getCommentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("parentId", getParentId());
		attributes.put("parentName", getParentName());
		attributes.put("commentText", getCommentText());
		attributes.put("guestName", getGuestName());
		attributes.put("guestEmailAddress", getGuestEmailAddress());
		attributes.put("guestEmailNotification", getGuestEmailNotification());
		attributes.put("likeCount", getLikeCount());
		attributes.put("dislikeCount", getDislikeCount());
		attributes.put("titleId", getTitleId());
		attributes.put("verified", getVerified());
		attributes.put("hasAnswer", getHasAnswer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commentId = (Long)attributes.get("commentId");

		if (commentId != null) {
			setCommentId(commentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String parentName = (String)attributes.get("parentName");

		if (parentName != null) {
			setParentName(parentName);
		}

		String commentText = (String)attributes.get("commentText");

		if (commentText != null) {
			setCommentText(commentText);
		}

		String guestName = (String)attributes.get("guestName");

		if (guestName != null) {
			setGuestName(guestName);
		}

		String guestEmailAddress = (String)attributes.get("guestEmailAddress");

		if (guestEmailAddress != null) {
			setGuestEmailAddress(guestEmailAddress);
		}

		Boolean guestEmailNotification = (Boolean)attributes.get(
				"guestEmailNotification");

		if (guestEmailNotification != null) {
			setGuestEmailNotification(guestEmailNotification);
		}

		Long likeCount = (Long)attributes.get("likeCount");

		if (likeCount != null) {
			setLikeCount(likeCount);
		}

		Long dislikeCount = (Long)attributes.get("dislikeCount");

		if (dislikeCount != null) {
			setDislikeCount(dislikeCount);
		}

		Long titleId = (Long)attributes.get("titleId");

		if (titleId != null) {
			setTitleId(titleId);
		}

		Boolean verified = (Boolean)attributes.get("verified");

		if (verified != null) {
			setVerified(verified);
		}

		Boolean hasAnswer = (Boolean)attributes.get("hasAnswer");

		if (hasAnswer != null) {
			setHasAnswer(hasAnswer);
		}
	}

	/**
	* Returns the primary key of this comment.
	*
	* @return the primary key of this comment
	*/
	@Override
	public long getPrimaryKey() {
		return _comment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this comment.
	*
	* @param primaryKey the primary key of this comment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_comment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the comment ID of this comment.
	*
	* @return the comment ID of this comment
	*/
	@Override
	public long getCommentId() {
		return _comment.getCommentId();
	}

	/**
	* Sets the comment ID of this comment.
	*
	* @param commentId the comment ID of this comment
	*/
	@Override
	public void setCommentId(long commentId) {
		_comment.setCommentId(commentId);
	}

	/**
	* Returns the group ID of this comment.
	*
	* @return the group ID of this comment
	*/
	@Override
	public long getGroupId() {
		return _comment.getGroupId();
	}

	/**
	* Sets the group ID of this comment.
	*
	* @param groupId the group ID of this comment
	*/
	@Override
	public void setGroupId(long groupId) {
		_comment.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this comment.
	*
	* @return the company ID of this comment
	*/
	@Override
	public long getCompanyId() {
		return _comment.getCompanyId();
	}

	/**
	* Sets the company ID of this comment.
	*
	* @param companyId the company ID of this comment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_comment.setCompanyId(companyId);
	}

	/**
	* Returns the modified date of this comment.
	*
	* @return the modified date of this comment
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _comment.getModifiedDate();
	}

	/**
	* Sets the modified date of this comment.
	*
	* @param modifiedDate the modified date of this comment
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_comment.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the parent ID of this comment.
	*
	* @return the parent ID of this comment
	*/
	@Override
	public long getParentId() {
		return _comment.getParentId();
	}

	/**
	* Sets the parent ID of this comment.
	*
	* @param parentId the parent ID of this comment
	*/
	@Override
	public void setParentId(long parentId) {
		_comment.setParentId(parentId);
	}

	/**
	* Returns the parent name of this comment.
	*
	* @return the parent name of this comment
	*/
	@Override
	public java.lang.String getParentName() {
		return _comment.getParentName();
	}

	/**
	* Sets the parent name of this comment.
	*
	* @param parentName the parent name of this comment
	*/
	@Override
	public void setParentName(java.lang.String parentName) {
		_comment.setParentName(parentName);
	}

	/**
	* Returns the comment text of this comment.
	*
	* @return the comment text of this comment
	*/
	@Override
	public java.lang.String getCommentText() {
		return _comment.getCommentText();
	}

	/**
	* Sets the comment text of this comment.
	*
	* @param commentText the comment text of this comment
	*/
	@Override
	public void setCommentText(java.lang.String commentText) {
		_comment.setCommentText(commentText);
	}

	/**
	* Returns the guest name of this comment.
	*
	* @return the guest name of this comment
	*/
	@Override
	public java.lang.String getGuestName() {
		return _comment.getGuestName();
	}

	/**
	* Sets the guest name of this comment.
	*
	* @param guestName the guest name of this comment
	*/
	@Override
	public void setGuestName(java.lang.String guestName) {
		_comment.setGuestName(guestName);
	}

	/**
	* Returns the guest email address of this comment.
	*
	* @return the guest email address of this comment
	*/
	@Override
	public java.lang.String getGuestEmailAddress() {
		return _comment.getGuestEmailAddress();
	}

	/**
	* Sets the guest email address of this comment.
	*
	* @param guestEmailAddress the guest email address of this comment
	*/
	@Override
	public void setGuestEmailAddress(java.lang.String guestEmailAddress) {
		_comment.setGuestEmailAddress(guestEmailAddress);
	}

	/**
	* Returns the guest email notification of this comment.
	*
	* @return the guest email notification of this comment
	*/
	@Override
	public boolean getGuestEmailNotification() {
		return _comment.getGuestEmailNotification();
	}

	/**
	* Returns <code>true</code> if this comment is guest email notification.
	*
	* @return <code>true</code> if this comment is guest email notification; <code>false</code> otherwise
	*/
	@Override
	public boolean isGuestEmailNotification() {
		return _comment.isGuestEmailNotification();
	}

	/**
	* Sets whether this comment is guest email notification.
	*
	* @param guestEmailNotification the guest email notification of this comment
	*/
	@Override
	public void setGuestEmailNotification(boolean guestEmailNotification) {
		_comment.setGuestEmailNotification(guestEmailNotification);
	}

	/**
	* Returns the like count of this comment.
	*
	* @return the like count of this comment
	*/
	@Override
	public long getLikeCount() {
		return _comment.getLikeCount();
	}

	/**
	* Sets the like count of this comment.
	*
	* @param likeCount the like count of this comment
	*/
	@Override
	public void setLikeCount(long likeCount) {
		_comment.setLikeCount(likeCount);
	}

	/**
	* Returns the dislike count of this comment.
	*
	* @return the dislike count of this comment
	*/
	@Override
	public long getDislikeCount() {
		return _comment.getDislikeCount();
	}

	/**
	* Sets the dislike count of this comment.
	*
	* @param dislikeCount the dislike count of this comment
	*/
	@Override
	public void setDislikeCount(long dislikeCount) {
		_comment.setDislikeCount(dislikeCount);
	}

	/**
	* Returns the title ID of this comment.
	*
	* @return the title ID of this comment
	*/
	@Override
	public long getTitleId() {
		return _comment.getTitleId();
	}

	/**
	* Sets the title ID of this comment.
	*
	* @param titleId the title ID of this comment
	*/
	@Override
	public void setTitleId(long titleId) {
		_comment.setTitleId(titleId);
	}

	/**
	* Returns the verified of this comment.
	*
	* @return the verified of this comment
	*/
	@Override
	public boolean getVerified() {
		return _comment.getVerified();
	}

	/**
	* Returns <code>true</code> if this comment is verified.
	*
	* @return <code>true</code> if this comment is verified; <code>false</code> otherwise
	*/
	@Override
	public boolean isVerified() {
		return _comment.isVerified();
	}

	/**
	* Sets whether this comment is verified.
	*
	* @param verified the verified of this comment
	*/
	@Override
	public void setVerified(boolean verified) {
		_comment.setVerified(verified);
	}

	/**
	* Returns the has answer of this comment.
	*
	* @return the has answer of this comment
	*/
	@Override
	public boolean getHasAnswer() {
		return _comment.getHasAnswer();
	}

	/**
	* Returns <code>true</code> if this comment is has answer.
	*
	* @return <code>true</code> if this comment is has answer; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasAnswer() {
		return _comment.isHasAnswer();
	}

	/**
	* Sets whether this comment is has answer.
	*
	* @param hasAnswer the has answer of this comment
	*/
	@Override
	public void setHasAnswer(boolean hasAnswer) {
		_comment.setHasAnswer(hasAnswer);
	}

	@Override
	public boolean isNew() {
		return _comment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_comment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _comment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_comment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _comment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _comment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_comment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _comment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_comment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_comment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_comment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CommentWrapper((Comment)_comment.clone());
	}

	@Override
	public int compareTo(
		ir.ac.iut.sccportal.guestdiscussion.model.Comment comment) {
		return _comment.compareTo(comment);
	}

	@Override
	public int hashCode() {
		return _comment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ir.ac.iut.sccportal.guestdiscussion.model.Comment> toCacheModel() {
		return _comment.toCacheModel();
	}

	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment toEscapedModel() {
		return new CommentWrapper(_comment.toEscapedModel());
	}

	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment toUnescapedModel() {
		return new CommentWrapper(_comment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _comment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _comment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_comment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommentWrapper)) {
			return false;
		}

		CommentWrapper commentWrapper = (CommentWrapper)obj;

		if (Validator.equals(_comment, commentWrapper._comment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Comment getWrappedComment() {
		return _comment;
	}

	@Override
	public Comment getWrappedModel() {
		return _comment;
	}

	@Override
	public void resetOriginalValues() {
		_comment.resetOriginalValues();
	}

	private Comment _comment;
}