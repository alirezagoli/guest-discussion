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

package ir.ac.iut.sccportal.guestdiscussion.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import ir.ac.iut.sccportal.guestdiscussion.model.Comment;
import ir.ac.iut.sccportal.guestdiscussion.model.CommentModel;
import ir.ac.iut.sccportal.guestdiscussion.model.CommentSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Comment service. Represents a row in the &quot;GDP_Comment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ir.ac.iut.sccportal.guestdiscussion.model.CommentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommentImpl}.
 * </p>
 *
 * @author Alireza
 * @see CommentImpl
 * @see ir.ac.iut.sccportal.guestdiscussion.model.Comment
 * @see ir.ac.iut.sccportal.guestdiscussion.model.CommentModel
 * @generated
 */
@JSON(strict = true)
public class CommentModelImpl extends BaseModelImpl<Comment>
	implements CommentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a comment model instance should use the {@link ir.ac.iut.sccportal.guestdiscussion.model.Comment} interface instead.
	 */
	public static final String TABLE_NAME = "GDP_Comment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "commentId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "parentId", Types.BIGINT },
			{ "parentName", Types.VARCHAR },
			{ "commentText", Types.VARCHAR },
			{ "guestName", Types.VARCHAR },
			{ "guestEmailAddress", Types.VARCHAR },
			{ "guestEmailNotification", Types.BOOLEAN },
			{ "likeCount", Types.BIGINT },
			{ "dislikeCount", Types.BIGINT },
			{ "titleId", Types.BIGINT },
			{ "verified", Types.BOOLEAN },
			{ "hasAnswer", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table GDP_Comment (commentId LONG not null primary key IDENTITY,groupId LONG,companyId LONG,modifiedDate DATE null,parentId LONG,parentName VARCHAR(75) null,commentText TEXT null,guestName VARCHAR(75) null,guestEmailAddress VARCHAR(75) null,guestEmailNotification BOOLEAN,likeCount LONG,dislikeCount LONG,titleId LONG,verified BOOLEAN,hasAnswer BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table GDP_Comment";
	public static final String ORDER_BY_JPQL = " ORDER BY comment.commentId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY GDP_Comment.commentId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.ir.ac.iut.sccportal.guestdiscussion.model.Comment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.ir.ac.iut.sccportal.guestdiscussion.model.Comment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.ir.ac.iut.sccportal.guestdiscussion.model.Comment"),
			true);
	public static long PARENTID_COLUMN_BITMASK = 1L;
	public static long TITLEID_COLUMN_BITMASK = 2L;
	public static long VERIFIED_COLUMN_BITMASK = 4L;
	public static long COMMENTID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Comment toModel(CommentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Comment model = new CommentImpl();

		model.setCommentId(soapModel.getCommentId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setParentId(soapModel.getParentId());
		model.setParentName(soapModel.getParentName());
		model.setCommentText(soapModel.getCommentText());
		model.setGuestName(soapModel.getGuestName());
		model.setGuestEmailAddress(soapModel.getGuestEmailAddress());
		model.setGuestEmailNotification(soapModel.getGuestEmailNotification());
		model.setLikeCount(soapModel.getLikeCount());
		model.setDislikeCount(soapModel.getDislikeCount());
		model.setTitleId(soapModel.getTitleId());
		model.setVerified(soapModel.getVerified());
		model.setHasAnswer(soapModel.getHasAnswer());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Comment> toModels(CommentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Comment> models = new ArrayList<Comment>(soapModels.length);

		for (CommentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.ir.ac.iut.sccportal.guestdiscussion.model.Comment"));

	public CommentModelImpl() {
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

	@JSON
	@Override
	public long getCommentId() {
		return _commentId;
	}

	@Override
	public void setCommentId(long commentId) {
		_columnBitmask = -1L;

		_commentId = commentId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_columnBitmask |= PARENTID_COLUMN_BITMASK;

		if (!_setOriginalParentId) {
			_setOriginalParentId = true;

			_originalParentId = _parentId;
		}

		_parentId = parentId;
	}

	public long getOriginalParentId() {
		return _originalParentId;
	}

	@JSON
	@Override
	public String getParentName() {
		if (_parentName == null) {
			return StringPool.BLANK;
		}
		else {
			return _parentName;
		}
	}

	@Override
	public void setParentName(String parentName) {
		_parentName = parentName;
	}

	@JSON
	@Override
	public String getCommentText() {
		if (_commentText == null) {
			return StringPool.BLANK;
		}
		else {
			return _commentText;
		}
	}

	@Override
	public void setCommentText(String commentText) {
		_commentText = commentText;
	}

	@JSON
	@Override
	public String getGuestName() {
		if (_guestName == null) {
			return StringPool.BLANK;
		}
		else {
			return _guestName;
		}
	}

	@Override
	public void setGuestName(String guestName) {
		_guestName = guestName;
	}

	@JSON
	@Override
	public String getGuestEmailAddress() {
		if (_guestEmailAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _guestEmailAddress;
		}
	}

	@Override
	public void setGuestEmailAddress(String guestEmailAddress) {
		_guestEmailAddress = guestEmailAddress;
	}

	@JSON
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
	}

	@JSON
	@Override
	public long getLikeCount() {
		return _likeCount;
	}

	@Override
	public void setLikeCount(long likeCount) {
		_likeCount = likeCount;
	}

	@JSON
	@Override
	public long getDislikeCount() {
		return _dislikeCount;
	}

	@Override
	public void setDislikeCount(long dislikeCount) {
		_dislikeCount = dislikeCount;
	}

	@JSON
	@Override
	public long getTitleId() {
		return _titleId;
	}

	@Override
	public void setTitleId(long titleId) {
		_columnBitmask |= TITLEID_COLUMN_BITMASK;

		if (!_setOriginalTitleId) {
			_setOriginalTitleId = true;

			_originalTitleId = _titleId;
		}

		_titleId = titleId;
	}

	public long getOriginalTitleId() {
		return _originalTitleId;
	}

	@JSON
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
		_columnBitmask |= VERIFIED_COLUMN_BITMASK;

		if (!_setOriginalVerified) {
			_setOriginalVerified = true;

			_originalVerified = _verified;
		}

		_verified = verified;
	}

	public boolean getOriginalVerified() {
		return _originalVerified;
	}

	@JSON
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
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Comment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Comment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Comment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommentImpl commentImpl = new CommentImpl();

		commentImpl.setCommentId(getCommentId());
		commentImpl.setGroupId(getGroupId());
		commentImpl.setCompanyId(getCompanyId());
		commentImpl.setModifiedDate(getModifiedDate());
		commentImpl.setParentId(getParentId());
		commentImpl.setParentName(getParentName());
		commentImpl.setCommentText(getCommentText());
		commentImpl.setGuestName(getGuestName());
		commentImpl.setGuestEmailAddress(getGuestEmailAddress());
		commentImpl.setGuestEmailNotification(getGuestEmailNotification());
		commentImpl.setLikeCount(getLikeCount());
		commentImpl.setDislikeCount(getDislikeCount());
		commentImpl.setTitleId(getTitleId());
		commentImpl.setVerified(getVerified());
		commentImpl.setHasAnswer(getHasAnswer());

		commentImpl.resetOriginalValues();

		return commentImpl;
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

		if (!(obj instanceof Comment)) {
			return false;
		}

		Comment comment = (Comment)obj;

		long primaryKey = comment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CommentModelImpl commentModelImpl = this;

		commentModelImpl._originalParentId = commentModelImpl._parentId;

		commentModelImpl._setOriginalParentId = false;

		commentModelImpl._originalTitleId = commentModelImpl._titleId;

		commentModelImpl._setOriginalTitleId = false;

		commentModelImpl._originalVerified = commentModelImpl._verified;

		commentModelImpl._setOriginalVerified = false;

		commentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Comment> toCacheModel() {
		CommentCacheModel commentCacheModel = new CommentCacheModel();

		commentCacheModel.commentId = getCommentId();

		commentCacheModel.groupId = getGroupId();

		commentCacheModel.companyId = getCompanyId();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commentCacheModel.parentId = getParentId();

		commentCacheModel.parentName = getParentName();

		String parentName = commentCacheModel.parentName;

		if ((parentName != null) && (parentName.length() == 0)) {
			commentCacheModel.parentName = null;
		}

		commentCacheModel.commentText = getCommentText();

		String commentText = commentCacheModel.commentText;

		if ((commentText != null) && (commentText.length() == 0)) {
			commentCacheModel.commentText = null;
		}

		commentCacheModel.guestName = getGuestName();

		String guestName = commentCacheModel.guestName;

		if ((guestName != null) && (guestName.length() == 0)) {
			commentCacheModel.guestName = null;
		}

		commentCacheModel.guestEmailAddress = getGuestEmailAddress();

		String guestEmailAddress = commentCacheModel.guestEmailAddress;

		if ((guestEmailAddress != null) && (guestEmailAddress.length() == 0)) {
			commentCacheModel.guestEmailAddress = null;
		}

		commentCacheModel.guestEmailNotification = getGuestEmailNotification();

		commentCacheModel.likeCount = getLikeCount();

		commentCacheModel.dislikeCount = getDislikeCount();

		commentCacheModel.titleId = getTitleId();

		commentCacheModel.verified = getVerified();

		commentCacheModel.hasAnswer = getHasAnswer();

		return commentCacheModel;
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

	private static ClassLoader _classLoader = Comment.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Comment.class
		};
	private long _commentId;
	private long _groupId;
	private long _companyId;
	private Date _modifiedDate;
	private long _parentId;
	private long _originalParentId;
	private boolean _setOriginalParentId;
	private String _parentName;
	private String _commentText;
	private String _guestName;
	private String _guestEmailAddress;
	private boolean _guestEmailNotification;
	private long _likeCount;
	private long _dislikeCount;
	private long _titleId;
	private long _originalTitleId;
	private boolean _setOriginalTitleId;
	private boolean _verified;
	private boolean _originalVerified;
	private boolean _setOriginalVerified;
	private boolean _hasAnswer;
	private long _columnBitmask;
	private Comment _escapedModel;
}