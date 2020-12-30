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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ir.ac.iut.sccportal.guestdiscussion.model.Comment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Comment in entity cache.
 *
 * @author Alireza
 * @see Comment
 * @generated
 */
public class CommentCacheModel implements CacheModel<Comment>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{commentId=");
		sb.append(commentId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", parentName=");
		sb.append(parentName);
		sb.append(", commentText=");
		sb.append(commentText);
		sb.append(", guestName=");
		sb.append(guestName);
		sb.append(", guestEmailAddress=");
		sb.append(guestEmailAddress);
		sb.append(", guestEmailNotification=");
		sb.append(guestEmailNotification);
		sb.append(", likeCount=");
		sb.append(likeCount);
		sb.append(", dislikeCount=");
		sb.append(dislikeCount);
		sb.append(", titleId=");
		sb.append(titleId);
		sb.append(", verified=");
		sb.append(verified);
		sb.append(", hasAnswer=");
		sb.append(hasAnswer);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Comment toEntityModel() {
		CommentImpl commentImpl = new CommentImpl();

		commentImpl.setCommentId(commentId);
		commentImpl.setGroupId(groupId);
		commentImpl.setCompanyId(companyId);

		if (modifiedDate == Long.MIN_VALUE) {
			commentImpl.setModifiedDate(null);
		}
		else {
			commentImpl.setModifiedDate(new Date(modifiedDate));
		}

		commentImpl.setParentId(parentId);

		if (parentName == null) {
			commentImpl.setParentName(StringPool.BLANK);
		}
		else {
			commentImpl.setParentName(parentName);
		}

		if (commentText == null) {
			commentImpl.setCommentText(StringPool.BLANK);
		}
		else {
			commentImpl.setCommentText(commentText);
		}

		if (guestName == null) {
			commentImpl.setGuestName(StringPool.BLANK);
		}
		else {
			commentImpl.setGuestName(guestName);
		}

		if (guestEmailAddress == null) {
			commentImpl.setGuestEmailAddress(StringPool.BLANK);
		}
		else {
			commentImpl.setGuestEmailAddress(guestEmailAddress);
		}

		commentImpl.setGuestEmailNotification(guestEmailNotification);
		commentImpl.setLikeCount(likeCount);
		commentImpl.setDislikeCount(dislikeCount);
		commentImpl.setTitleId(titleId);
		commentImpl.setVerified(verified);
		commentImpl.setHasAnswer(hasAnswer);

		commentImpl.resetOriginalValues();

		return commentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		commentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		parentId = objectInput.readLong();
		parentName = objectInput.readUTF();
		commentText = objectInput.readUTF();
		guestName = objectInput.readUTF();
		guestEmailAddress = objectInput.readUTF();
		guestEmailNotification = objectInput.readBoolean();
		likeCount = objectInput.readLong();
		dislikeCount = objectInput.readLong();
		titleId = objectInput.readLong();
		verified = objectInput.readBoolean();
		hasAnswer = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(commentId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(parentId);

		if (parentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(parentName);
		}

		if (commentText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(commentText);
		}

		if (guestName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(guestName);
		}

		if (guestEmailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(guestEmailAddress);
		}

		objectOutput.writeBoolean(guestEmailNotification);
		objectOutput.writeLong(likeCount);
		objectOutput.writeLong(dislikeCount);
		objectOutput.writeLong(titleId);
		objectOutput.writeBoolean(verified);
		objectOutput.writeBoolean(hasAnswer);
	}

	public long commentId;
	public long groupId;
	public long companyId;
	public long modifiedDate;
	public long parentId;
	public String parentName;
	public String commentText;
	public String guestName;
	public String guestEmailAddress;
	public boolean guestEmailNotification;
	public long likeCount;
	public long dislikeCount;
	public long titleId;
	public boolean verified;
	public boolean hasAnswer;
}