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
 * This class is used by SOAP remote services, specifically {@link ir.ac.iut.sccportal.guestdiscussion.service.http.TitleServiceSoap}.
 *
 * @author Alireza
 * @see ir.ac.iut.sccportal.guestdiscussion.service.http.TitleServiceSoap
 * @generated
 */
public class TitleSoap implements Serializable {
	public static TitleSoap toSoapModel(Title model) {
		TitleSoap soapModel = new TitleSoap();

		soapModel.setTitleId(model.getTitleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setTitleText(model.getTitleText());
		soapModel.setNewCommentDraft(model.getNewCommentDraft());
		soapModel.setAnswerCommentDraft(model.getAnswerCommentDraft());

		return soapModel;
	}

	public static TitleSoap[] toSoapModels(Title[] models) {
		TitleSoap[] soapModels = new TitleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TitleSoap[][] toSoapModels(Title[][] models) {
		TitleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TitleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TitleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TitleSoap[] toSoapModels(List<Title> models) {
		List<TitleSoap> soapModels = new ArrayList<TitleSoap>(models.size());

		for (Title model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TitleSoap[soapModels.size()]);
	}

	public TitleSoap() {
	}

	public long getPrimaryKey() {
		return _titleId;
	}

	public void setPrimaryKey(long pk) {
		setTitleId(pk);
	}

	public long getTitleId() {
		return _titleId;
	}

	public void setTitleId(long titleId) {
		_titleId = titleId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getTitleText() {
		return _titleText;
	}

	public void setTitleText(String titleText) {
		_titleText = titleText;
	}

	public String getNewCommentDraft() {
		return _newCommentDraft;
	}

	public void setNewCommentDraft(String newCommentDraft) {
		_newCommentDraft = newCommentDraft;
	}

	public String getAnswerCommentDraft() {
		return _answerCommentDraft;
	}

	public void setAnswerCommentDraft(String answerCommentDraft) {
		_answerCommentDraft = answerCommentDraft;
	}

	private long _titleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private String _titleText;
	private String _newCommentDraft;
	private String _answerCommentDraft;
}