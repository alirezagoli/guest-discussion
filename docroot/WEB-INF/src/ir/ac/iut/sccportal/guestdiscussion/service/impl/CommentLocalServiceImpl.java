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

package ir.ac.iut.sccportal.guestdiscussion.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import ir.ac.iut.sccportal.guestdiscussion.model.Comment;
import ir.ac.iut.sccportal.guestdiscussion.service.base.CommentLocalServiceBaseImpl;

/**
 * The implementation of the comment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link ir.ac.iut.sccportal.guestdiscussion.service.CommentLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Alireza
 * @see ir.ac.iut.sccportal.guestdiscussion.service.base.CommentLocalServiceBaseImpl
 * @see ir.ac.iut.sccportal.guestdiscussion.service.CommentLocalServiceUtil
 */
public class CommentLocalServiceImpl extends CommentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * ir.ac.iut.sccportal.guestdiscussion.service.CommentLocalServiceUtil} to
	 * access the comment local service.
	 */

	public Comment addComment(long groupId, long companyId, Date modifiedDate,
			long parentId, String commentText, String guestName,
			long likeCount, long titleId, boolean verified, boolean hasChild, String parentName, String guestEmailAddress, boolean guestEmailNotification)
			throws SystemException {

		Comment comment = commentPersistence.create(0);

		comment.setGroupId(groupId);
		comment.setCompanyId(companyId);
		comment.setModifiedDate(modifiedDate);
		comment.setParentId(parentId);
		comment.setCommentText(commentText);
		comment.setGuestName(guestName);
		comment.setLikeCount(likeCount);
		comment.setTitleId(titleId);
		comment.setVerified(verified);
		comment.setHasAnswer(hasChild);
		comment.setParentName(parentName);
		comment.setGuestEmailAddress(guestEmailAddress);
		comment.setGuestEmailNotification(guestEmailNotification);

		return super.addComment(comment);

	}
	
	public List<Comment> getCommentsByParentId_TitleId_Verified (long parentId, long titleId, boolean verified) throws SystemException  {
	    return commentPersistence.findByParentId_TitleId_Verified(parentId, titleId, verified);
	}
	
	public List<Comment> getCommentsByTitleId_Verified (long titleId, boolean verified) throws SystemException  {
	    return commentPersistence.findByTitleId_Virified(titleId, verified);
	}
	
	public List<Comment> getCommentsByTitleId (long titleId) throws SystemException  {
	    return commentPersistence.findByTitleId(titleId);
	}
	
	public void deleteCommentsByTitleId (long titleId) throws SystemException  {
	     commentPersistence.removeByTitleId(titleId);
	}

}