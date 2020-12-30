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

import ir.ac.iut.sccportal.guestdiscussion.service.ClpSerializer;
import ir.ac.iut.sccportal.guestdiscussion.service.CommentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alireza
 */
public class CommentClp extends BaseModelImpl<Comment> implements Comment {
	public CommentClp() {
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
	public long getPrimaryKey() {
		return _commentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getCommentId() {
		return _commentId;
	}

	@Override
	public void setCommentId(long commentId) {
		_commentId = commentId;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setCommentId", long.class);

				method.invoke(_commentRemoteModel, commentId);
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

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_commentRemoteModel, groupId);
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

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_commentRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_commentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_commentRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParentName() {
		return _parentName;
	}

	@Override
	public void setParentName(String parentName) {
		_parentName = parentName;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setParentName", String.class);

				method.invoke(_commentRemoteModel, parentName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCommentText() {
		return _commentText;
	}

	@Override
	public void setCommentText(String commentText) {
		_commentText = commentText;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setCommentText", String.class);

				method.invoke(_commentRemoteModel, commentText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGuestName() {
		return _guestName;
	}

	@Override
	public void setGuestName(String guestName) {
		_guestName = guestName;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setGuestName", String.class);

				method.invoke(_commentRemoteModel, guestName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGuestEmailAddress() {
		return _guestEmailAddress;
	}

	@Override
	public void setGuestEmailAddress(String guestEmailAddress) {
		_guestEmailAddress = guestEmailAddress;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setGuestEmailAddress",
						String.class);

				method.invoke(_commentRemoteModel, guestEmailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGuestEmailNotification() {
		return _guestEmailNotification;
	}

	@Override
	public boolean isGuestEmailNotification() {
		return _guestEmailNotification;
	}

	@Override
	public void setGuestEmailNotification(boolean guestEmailNotification) {
		_guestEmailNotification = guestEmailNotification;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setGuestEmailNotification",
						boolean.class);

				method.invoke(_commentRemoteModel, guestEmailNotification);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLikeCount() {
		return _likeCount;
	}

	@Override
	public void setLikeCount(long likeCount) {
		_likeCount = likeCount;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setLikeCount", long.class);

				method.invoke(_commentRemoteModel, likeCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDislikeCount() {
		return _dislikeCount;
	}

	@Override
	public void setDislikeCount(long dislikeCount) {
		_dislikeCount = dislikeCount;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setDislikeCount", long.class);

				method.invoke(_commentRemoteModel, dislikeCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTitleId() {
		return _titleId;
	}

	@Override
	public void setTitleId(long titleId) {
		_titleId = titleId;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setTitleId", long.class);

				method.invoke(_commentRemoteModel, titleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getVerified() {
		return _verified;
	}

	@Override
	public boolean isVerified() {
		return _verified;
	}

	@Override
	public void setVerified(boolean verified) {
		_verified = verified;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setVerified", boolean.class);

				method.invoke(_commentRemoteModel, verified);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasAnswer() {
		return _hasAnswer;
	}

	@Override
	public boolean isHasAnswer() {
		return _hasAnswer;
	}

	@Override
	public void setHasAnswer(boolean hasAnswer) {
		_hasAnswer = hasAnswer;

		if (_commentRemoteModel != null) {
			try {
				Class<?> clazz = _commentRemoteModel.getClass();

				Method method = clazz.getMethod("setHasAnswer", boolean.class);

				method.invoke(_commentRemoteModel, hasAnswer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCommentRemoteModel() {
		return _commentRemoteModel;
	}

	public void setCommentRemoteModel(BaseModel<?> commentRemoteModel) {
		_commentRemoteModel = commentRemoteModel;
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

		Class<?> remoteModelClass = _commentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_commentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CommentLocalServiceUtil.addComment(this);
		}
		else {
			CommentLocalServiceUtil.updateComment(this);
		}
	}

	@Override
	public Comment toEscapedModel() {
		return (Comment)ProxyUtil.newProxyInstance(Comment.class.getClassLoader(),
			new Class[] { Comment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CommentClp clone = new CommentClp();

		clone.setCommentId(getCommentId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setModifiedDate(getModifiedDate());
		clone.setParentId(getParentId());
		clone.setParentName(getParentName());
		clone.setCommentText(getCommentText());
		clone.setGuestName(getGuestName());
		clone.setGuestEmailAddress(getGuestEmailAddress());
		clone.setGuestEmailNotification(getGuestEmailNotification());
		clone.setLikeCount(getLikeCount());
		clone.setDislikeCount(getDislikeCount());
		clone.setTitleId(getTitleId());
		clone.setVerified(getVerified());
		clone.setHasAnswer(getHasAnswer());

		return clone;
	}

	@Override
	public int compareTo(Comment comment) {
		int value = 0;

		if (getCommentId() < comment.getCommentId()) {
			value = -1;
		}
		else if (getCommentId() > comment.getCommentId()) {
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

		if (!(obj instanceof CommentClp)) {
			return false;
		}

		CommentClp comment = (CommentClp)obj;

		long primaryKey = comment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{commentId=");
		sb.append(getCommentId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", parentName=");
		sb.append(getParentName());
		sb.append(", commentText=");
		sb.append(getCommentText());
		sb.append(", guestName=");
		sb.append(getGuestName());
		sb.append(", guestEmailAddress=");
		sb.append(getGuestEmailAddress());
		sb.append(", guestEmailNotification=");
		sb.append(getGuestEmailNotification());
		sb.append(", likeCount=");
		sb.append(getLikeCount());
		sb.append(", dislikeCount=");
		sb.append(getDislikeCount());
		sb.append(", titleId=");
		sb.append(getTitleId());
		sb.append(", verified=");
		sb.append(getVerified());
		sb.append(", hasAnswer=");
		sb.append(getHasAnswer());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("ir.ac.iut.sccportal.guestdiscussion.model.Comment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commentId</column-name><column-value><![CDATA[");
		sb.append(getCommentId());
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
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentName</column-name><column-value><![CDATA[");
		sb.append(getParentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commentText</column-name><column-value><![CDATA[");
		sb.append(getCommentText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guestName</column-name><column-value><![CDATA[");
		sb.append(getGuestName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guestEmailAddress</column-name><column-value><![CDATA[");
		sb.append(getGuestEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guestEmailNotification</column-name><column-value><![CDATA[");
		sb.append(getGuestEmailNotification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>likeCount</column-name><column-value><![CDATA[");
		sb.append(getLikeCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dislikeCount</column-name><column-value><![CDATA[");
		sb.append(getDislikeCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleId</column-name><column-value><![CDATA[");
		sb.append(getTitleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>verified</column-name><column-value><![CDATA[");
		sb.append(getVerified());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasAnswer</column-name><column-value><![CDATA[");
		sb.append(getHasAnswer());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _commentRemoteModel;
	private Class<?> _clpSerializerClass = ir.ac.iut.sccportal.guestdiscussion.service.ClpSerializer.class;
}