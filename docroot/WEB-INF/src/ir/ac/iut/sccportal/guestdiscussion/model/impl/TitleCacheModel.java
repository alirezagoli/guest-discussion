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

import ir.ac.iut.sccportal.guestdiscussion.model.Title;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Title in entity cache.
 *
 * @author Alireza
 * @see Title
 * @generated
 */
public class TitleCacheModel implements CacheModel<Title>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{titleId=");
		sb.append(titleId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", titleText=");
		sb.append(titleText);
		sb.append(", newCommentDraft=");
		sb.append(newCommentDraft);
		sb.append(", answerCommentDraft=");
		sb.append(answerCommentDraft);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Title toEntityModel() {
		TitleImpl titleImpl = new TitleImpl();

		titleImpl.setTitleId(titleId);
		titleImpl.setGroupId(groupId);
		titleImpl.setCompanyId(companyId);
		titleImpl.setUserId(userId);

		if (userName == null) {
			titleImpl.setUserName(StringPool.BLANK);
		}
		else {
			titleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			titleImpl.setCreateDate(null);
		}
		else {
			titleImpl.setCreateDate(new Date(createDate));
		}

		if (titleText == null) {
			titleImpl.setTitleText(StringPool.BLANK);
		}
		else {
			titleImpl.setTitleText(titleText);
		}

		if (newCommentDraft == null) {
			titleImpl.setNewCommentDraft(StringPool.BLANK);
		}
		else {
			titleImpl.setNewCommentDraft(newCommentDraft);
		}

		if (answerCommentDraft == null) {
			titleImpl.setAnswerCommentDraft(StringPool.BLANK);
		}
		else {
			titleImpl.setAnswerCommentDraft(answerCommentDraft);
		}

		titleImpl.resetOriginalValues();

		return titleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		titleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		titleText = objectInput.readUTF();
		newCommentDraft = objectInput.readUTF();
		answerCommentDraft = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(titleId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		if (titleText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(titleText);
		}

		if (newCommentDraft == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(newCommentDraft);
		}

		if (answerCommentDraft == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answerCommentDraft);
		}
	}

	public long titleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public String titleText;
	public String newCommentDraft;
	public String answerCommentDraft;
}