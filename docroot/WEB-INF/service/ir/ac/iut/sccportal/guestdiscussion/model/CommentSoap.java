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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ir.ac.iut.sccportal.guestdiscussion.service.http.CommentServiceSoap}.
 *
 * @author Alireza
 * @see ir.ac.iut.sccportal.guestdiscussion.service.http.CommentServiceSoap
 * @generated
 */
public class CommentSoap implements Serializable {
	public static CommentSoap toSoapModel(Comment model) {
		CommentSoap soapModel = new CommentSoap();

		soapModel.setCommentId(model.getCommentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setParentId(model.getParentId());
		soapModel.setParentName(model.getParentName());
		soapModel.setCommentText(model.getCommentText());
		soapModel.setGuestName(model.getGuestName());
		soapModel.setGuestEmailAddress(model.getGuestEmailAddress());
		soapModel.setGuestEmailNotification(model.getGuestEmailNotification());
		soapModel.setLikeCount(model.getLikeCount());
		soapModel.setDislikeCount(model.getDislikeCount());
		soapModel.setTitleId(model.getTitleId());
		soapModel.setVerified(model.getVerified());
		soapModel.setHasAnswer(model.getHasAnswer());

		return soapModel;
	}

	public static CommentSoap[] toSoapModels(Comment[] models) {
		CommentSoap[] soapModels = new CommentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommentSoap[][] toSoapModels(Comment[][] models) {
		CommentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CommentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CommentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommentSoap[] toSoapModels(List<Comment> models) {
		List<CommentSoap> soapModels = new ArrayList<CommentSoap>(models.size());

		for (Comment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CommentSoap[soapModels.size()]);
	}

	public CommentSoap() {
	}

	public long getPrimaryKey() {
		return _commentId;
	}

	public void setPrimaryKey(long pk) {
		setCommentId(pk);
	}

	public long getCommentId() {
		return _commentId;
	}

	public void setCommentId(long commentId) {
		_commentId = commentId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getParentName() {
		return _parentName;
	}

	public void setParentName(String parentName) {
		_parentName = parentName;
	}

	public String getCommentText() {
		return _commentText;
	}

	public void setCommentText(String commentText) {
		_commentText = commentText;
	}

	public String getGuestName() {
		return _guestName;
	}

	public void setGuestName(String guestName) {
		_guestName = guestName;
	}

	public String getGuestEmailAddress() {
		return _guestEmailAddress;
	}

	public void setGuestEmailAddress(String guestEmailAddress) {
		_guestEmailAddress = guestEmailAddress;
	}

	public boolean getGuestEmailNotification() {
		return _guestEmailNotification;
	}

	public boolean isGuestEmailNotification() {
		return _guestEmailNotification;
	}

	public void setGuestEmailNotification(boolean guestEmailNotification) {
		_guestEmailNotification = guestEmailNotification;
	}

	public long getLikeCount() {
		return _likeCount;
	}

	public void setLikeCount(long likeCount) {
		_likeCount = likeCount;
	}

	public long getDislikeCount() {
		return _dislikeCount;
	}

	public void setDislikeCount(long dislikeCount) {
		_dislikeCount = dislikeCount;
	}

	public long getTitleId() {
		return _titleId;
	}

	public void setTitleId(long titleId) {
		_titleId = titleId;
	}

	public boolean getVerified() {
		return _verified;
	}

	public boolean isVerified() {
		return _verified;
	}

	public void setVerified(boolean verified) {
		_verified = verified;
	}

	public boolean getHasAnswer() {
		return _hasAnswer;
	}

	public boolean isHasAnswer() {
		return _hasAnswer;
	}

	public void setHasAnswer(boolean hasAnswer) {
		_hasAnswer = hasAnswer;
	}

	private long _commentId;
	private long _groupId;
	private long _companyId;
	private Date _modifiedDate;
	private long _parentId;
	private String _parentName;
	private String _commentText;
	private String _guestName;
	private String _guestEmailAddress;
	private boolean _guestEmailNotification;
	private long _likeCount;
	private long _dislikeCount;
	private long _titleId;
	private boolean _verified;
	private boolean _hasAnswer;
}