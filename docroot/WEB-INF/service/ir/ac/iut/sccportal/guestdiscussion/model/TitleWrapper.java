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
 * This class is a wrapper for {@link Title}.
 * </p>
 *
 * @author Alireza
 * @see Title
 * @generated
 */
public class TitleWrapper implements Title, ModelWrapper<Title> {
	public TitleWrapper(Title title) {
		_title = title;
	}

	@Override
	public Class<?> getModelClass() {
		return Title.class;
	}

	@Override
	public String getModelClassName() {
		return Title.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("titleId", getTitleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("titleText", getTitleText());
		attributes.put("newCommentDraft", getNewCommentDraft());
		attributes.put("answerCommentDraft", getAnswerCommentDraft());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long titleId = (Long)attributes.get("titleId");

		if (titleId != null) {
			setTitleId(titleId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String titleText = (String)attributes.get("titleText");

		if (titleText != null) {
			setTitleText(titleText);
		}

		String newCommentDraft = (String)attributes.get("newCommentDraft");

		if (newCommentDraft != null) {
			setNewCommentDraft(newCommentDraft);
		}

		String answerCommentDraft = (String)attributes.get("answerCommentDraft");

		if (answerCommentDraft != null) {
			setAnswerCommentDraft(answerCommentDraft);
		}
	}

	/**
	* Returns the primary key of this title.
	*
	* @return the primary key of this title
	*/
	@Override
	public long getPrimaryKey() {
		return _title.getPrimaryKey();
	}

	/**
	* Sets the primary key of this title.
	*
	* @param primaryKey the primary key of this title
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_title.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the title ID of this title.
	*
	* @return the title ID of this title
	*/
	@Override
	public long getTitleId() {
		return _title.getTitleId();
	}

	/**
	* Sets the title ID of this title.
	*
	* @param titleId the title ID of this title
	*/
	@Override
	public void setTitleId(long titleId) {
		_title.setTitleId(titleId);
	}

	/**
	* Returns the group ID of this title.
	*
	* @return the group ID of this title
	*/
	@Override
	public long getGroupId() {
		return _title.getGroupId();
	}

	/**
	* Sets the group ID of this title.
	*
	* @param groupId the group ID of this title
	*/
	@Override
	public void setGroupId(long groupId) {
		_title.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this title.
	*
	* @return the company ID of this title
	*/
	@Override
	public long getCompanyId() {
		return _title.getCompanyId();
	}

	/**
	* Sets the company ID of this title.
	*
	* @param companyId the company ID of this title
	*/
	@Override
	public void setCompanyId(long companyId) {
		_title.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this title.
	*
	* @return the user ID of this title
	*/
	@Override
	public long getUserId() {
		return _title.getUserId();
	}

	/**
	* Sets the user ID of this title.
	*
	* @param userId the user ID of this title
	*/
	@Override
	public void setUserId(long userId) {
		_title.setUserId(userId);
	}

	/**
	* Returns the user uuid of this title.
	*
	* @return the user uuid of this title
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _title.getUserUuid();
	}

	/**
	* Sets the user uuid of this title.
	*
	* @param userUuid the user uuid of this title
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_title.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this title.
	*
	* @return the user name of this title
	*/
	@Override
	public java.lang.String getUserName() {
		return _title.getUserName();
	}

	/**
	* Sets the user name of this title.
	*
	* @param userName the user name of this title
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_title.setUserName(userName);
	}

	/**
	* Returns the create date of this title.
	*
	* @return the create date of this title
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _title.getCreateDate();
	}

	/**
	* Sets the create date of this title.
	*
	* @param createDate the create date of this title
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_title.setCreateDate(createDate);
	}

	/**
	* Returns the title text of this title.
	*
	* @return the title text of this title
	*/
	@Override
	public java.lang.String getTitleText() {
		return _title.getTitleText();
	}

	/**
	* Sets the title text of this title.
	*
	* @param titleText the title text of this title
	*/
	@Override
	public void setTitleText(java.lang.String titleText) {
		_title.setTitleText(titleText);
	}

	/**
	* Returns the new comment draft of this title.
	*
	* @return the new comment draft of this title
	*/
	@Override
	public java.lang.String getNewCommentDraft() {
		return _title.getNewCommentDraft();
	}

	/**
	* Sets the new comment draft of this title.
	*
	* @param newCommentDraft the new comment draft of this title
	*/
	@Override
	public void setNewCommentDraft(java.lang.String newCommentDraft) {
		_title.setNewCommentDraft(newCommentDraft);
	}

	/**
	* Returns the answer comment draft of this title.
	*
	* @return the answer comment draft of this title
	*/
	@Override
	public java.lang.String getAnswerCommentDraft() {
		return _title.getAnswerCommentDraft();
	}

	/**
	* Sets the answer comment draft of this title.
	*
	* @param answerCommentDraft the answer comment draft of this title
	*/
	@Override
	public void setAnswerCommentDraft(java.lang.String answerCommentDraft) {
		_title.setAnswerCommentDraft(answerCommentDraft);
	}

	@Override
	public boolean isNew() {
		return _title.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_title.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _title.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_title.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _title.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _title.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_title.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _title.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_title.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_title.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_title.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TitleWrapper((Title)_title.clone());
	}

	@Override
	public int compareTo(ir.ac.iut.sccportal.guestdiscussion.model.Title title) {
		return _title.compareTo(title);
	}

	@Override
	public int hashCode() {
		return _title.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ir.ac.iut.sccportal.guestdiscussion.model.Title> toCacheModel() {
		return _title.toCacheModel();
	}

	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Title toEscapedModel() {
		return new TitleWrapper(_title.toEscapedModel());
	}

	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Title toUnescapedModel() {
		return new TitleWrapper(_title.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _title.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _title.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_title.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TitleWrapper)) {
			return false;
		}

		TitleWrapper titleWrapper = (TitleWrapper)obj;

		if (Validator.equals(_title, titleWrapper._title)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Title getWrappedTitle() {
		return _title;
	}

	@Override
	public Title getWrappedModel() {
		return _title;
	}

	@Override
	public void resetOriginalValues() {
		_title.resetOriginalValues();
	}

	private Title _title;
}