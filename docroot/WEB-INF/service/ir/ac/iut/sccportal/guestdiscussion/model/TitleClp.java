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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import ir.ac.iut.sccportal.guestdiscussion.service.ClpSerializer;
import ir.ac.iut.sccportal.guestdiscussion.service.TitleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alireza
 */
public class TitleClp extends BaseModelImpl<Title> implements Title {
	public TitleClp() {
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
	public long getPrimaryKey() {
		return _titleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTitleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _titleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getTitleId() {
		return _titleId;
	}

	@Override
	public void setTitleId(long titleId) {
		_titleId = titleId;

		if (_titleRemoteModel != null) {
			try {
				Class<?> clazz = _titleRemoteModel.getClass();

				Method method = clazz.getMethod("setTitleId", long.class);

				method.invoke(_titleRemoteModel, titleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_titleRemoteModel != null) {
			try {
				Class<?> clazz = _titleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_titleRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_titleRemoteModel != null) {
			try {
				Class<?> clazz = _titleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_titleRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_titleRemoteModel != null) {
			try {
				Class<?> clazz = _titleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_titleRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_titleRemoteModel != null) {
			try {
				Class<?> clazz = _titleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_titleRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_titleRemoteModel != null) {
			try {
				Class<?> clazz = _titleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_titleRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitleText() {
		return _titleText;
	}

	@Override
	public void setTitleText(String titleText) {
		_titleText = titleText;

		if (_titleRemoteModel != null) {
			try {
				Class<?> clazz = _titleRemoteModel.getClass();

				Method method = clazz.getMethod("setTitleText", String.class);

				method.invoke(_titleRemoteModel, titleText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNewCommentDraft() {
		return _newCommentDraft;
	}

	@Override
	public void setNewCommentDraft(String newCommentDraft) {
		_newCommentDraft = newCommentDraft;

		if (_titleRemoteModel != null) {
			try {
				Class<?> clazz = _titleRemoteModel.getClass();

				Method method = clazz.getMethod("setNewCommentDraft",
						String.class);

				method.invoke(_titleRemoteModel, newCommentDraft);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswerCommentDraft() {
		return _answerCommentDraft;
	}

	@Override
	public void setAnswerCommentDraft(String answerCommentDraft) {
		_answerCommentDraft = answerCommentDraft;

		if (_titleRemoteModel != null) {
			try {
				Class<?> clazz = _titleRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerCommentDraft",
						String.class);

				method.invoke(_titleRemoteModel, answerCommentDraft);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTitleRemoteModel() {
		return _titleRemoteModel;
	}

	public void setTitleRemoteModel(BaseModel<?> titleRemoteModel) {
		_titleRemoteModel = titleRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _titleRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_titleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TitleLocalServiceUtil.addTitle(this);
		}
		else {
			TitleLocalServiceUtil.updateTitle(this);
		}
	}

	@Override
	public Title toEscapedModel() {
		return (Title)ProxyUtil.newProxyInstance(Title.class.getClassLoader(),
			new Class[] { Title.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TitleClp clone = new TitleClp();

		clone.setTitleId(getTitleId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setTitleText(getTitleText());
		clone.setNewCommentDraft(getNewCommentDraft());
		clone.setAnswerCommentDraft(getAnswerCommentDraft());

		return clone;
	}

	@Override
	public int compareTo(Title title) {
		int value = 0;

		if (getTitleId() < title.getTitleId()) {
			value = -1;
		}
		else if (getTitleId() > title.getTitleId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TitleClp)) {
			return false;
		}

		TitleClp title = (TitleClp)obj;

		long primaryKey = title.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{titleId=");
		sb.append(getTitleId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", titleText=");
		sb.append(getTitleText());
		sb.append(", newCommentDraft=");
		sb.append(getNewCommentDraft());
		sb.append(", answerCommentDraft=");
		sb.append(getAnswerCommentDraft());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("ir.ac.iut.sccportal.guestdiscussion.model.Title");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>titleId</column-name><column-value><![CDATA[");
		sb.append(getTitleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleText</column-name><column-value><![CDATA[");
		sb.append(getTitleText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newCommentDraft</column-name><column-value><![CDATA[");
		sb.append(getNewCommentDraft());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerCommentDraft</column-name><column-value><![CDATA[");
		sb.append(getAnswerCommentDraft());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _titleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private String _titleText;
	private String _newCommentDraft;
	private String _answerCommentDraft;
	private BaseModel<?> _titleRemoteModel;
	private Class<?> _clpSerializerClass = ir.ac.iut.sccportal.guestdiscussion.service.ClpSerializer.class;
}