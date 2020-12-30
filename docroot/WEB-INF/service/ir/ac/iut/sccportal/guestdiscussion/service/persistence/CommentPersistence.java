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

package ir.ac.iut.sccportal.guestdiscussion.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ir.ac.iut.sccportal.guestdiscussion.model.Comment;

/**
 * The persistence interface for the comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alireza
 * @see CommentPersistenceImpl
 * @see CommentUtil
 * @generated
 */
public interface CommentPersistence extends BasePersistence<Comment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommentUtil} to access the comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the comments where parentId = &#63; and titleId = &#63; and verified = &#63;.
	*
	* @param parentId the parent ID
	* @param titleId the title ID
	* @param verified the verified
	* @return the matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findByParentId_TitleId_Verified(
		long parentId, long titleId, boolean verified)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the comments where parentId = &#63; and titleId = &#63; and verified = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param titleId the title ID
	* @param verified the verified
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @return the range of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findByParentId_TitleId_Verified(
		long parentId, long titleId, boolean verified, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the comments where parentId = &#63; and titleId = &#63; and verified = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param titleId the title ID
	* @param verified the verified
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findByParentId_TitleId_Verified(
		long parentId, long titleId, boolean verified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first comment in the ordered set where parentId = &#63; and titleId = &#63; and verified = &#63;.
	*
	* @param parentId the parent ID
	* @param titleId the title ID
	* @param verified the verified
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment findByParentId_TitleId_Verified_First(
		long parentId, long titleId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;

	/**
	* Returns the first comment in the ordered set where parentId = &#63; and titleId = &#63; and verified = &#63;.
	*
	* @param parentId the parent ID
	* @param titleId the title ID
	* @param verified the verified
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment, or <code>null</code> if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment fetchByParentId_TitleId_Verified_First(
		long parentId, long titleId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last comment in the ordered set where parentId = &#63; and titleId = &#63; and verified = &#63;.
	*
	* @param parentId the parent ID
	* @param titleId the title ID
	* @param verified the verified
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment findByParentId_TitleId_Verified_Last(
		long parentId, long titleId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;

	/**
	* Returns the last comment in the ordered set where parentId = &#63; and titleId = &#63; and verified = &#63;.
	*
	* @param parentId the parent ID
	* @param titleId the title ID
	* @param verified the verified
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment, or <code>null</code> if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment fetchByParentId_TitleId_Verified_Last(
		long parentId, long titleId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the comments before and after the current comment in the ordered set where parentId = &#63; and titleId = &#63; and verified = &#63;.
	*
	* @param commentId the primary key of the current comment
	* @param parentId the parent ID
	* @param titleId the title ID
	* @param verified the verified
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment[] findByParentId_TitleId_Verified_PrevAndNext(
		long commentId, long parentId, long titleId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;

	/**
	* Removes all the comments where parentId = &#63; and titleId = &#63; and verified = &#63; from the database.
	*
	* @param parentId the parent ID
	* @param titleId the title ID
	* @param verified the verified
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentId_TitleId_Verified(long parentId, long titleId,
		boolean verified)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of comments where parentId = &#63; and titleId = &#63; and verified = &#63;.
	*
	* @param parentId the parent ID
	* @param titleId the title ID
	* @param verified the verified
	* @return the number of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentId_TitleId_Verified(long parentId, long titleId,
		boolean verified)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the comments where titleId = &#63; and verified = &#63;.
	*
	* @param titleId the title ID
	* @param verified the verified
	* @return the matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findByTitleId_Virified(
		long titleId, boolean verified)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the comments where titleId = &#63; and verified = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titleId the title ID
	* @param verified the verified
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @return the range of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findByTitleId_Virified(
		long titleId, boolean verified, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the comments where titleId = &#63; and verified = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titleId the title ID
	* @param verified the verified
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findByTitleId_Virified(
		long titleId, boolean verified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first comment in the ordered set where titleId = &#63; and verified = &#63;.
	*
	* @param titleId the title ID
	* @param verified the verified
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment findByTitleId_Virified_First(
		long titleId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;

	/**
	* Returns the first comment in the ordered set where titleId = &#63; and verified = &#63;.
	*
	* @param titleId the title ID
	* @param verified the verified
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment, or <code>null</code> if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment fetchByTitleId_Virified_First(
		long titleId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last comment in the ordered set where titleId = &#63; and verified = &#63;.
	*
	* @param titleId the title ID
	* @param verified the verified
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment findByTitleId_Virified_Last(
		long titleId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;

	/**
	* Returns the last comment in the ordered set where titleId = &#63; and verified = &#63;.
	*
	* @param titleId the title ID
	* @param verified the verified
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment, or <code>null</code> if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment fetchByTitleId_Virified_Last(
		long titleId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the comments before and after the current comment in the ordered set where titleId = &#63; and verified = &#63;.
	*
	* @param commentId the primary key of the current comment
	* @param titleId the title ID
	* @param verified the verified
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment[] findByTitleId_Virified_PrevAndNext(
		long commentId, long titleId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;

	/**
	* Removes all the comments where titleId = &#63; and verified = &#63; from the database.
	*
	* @param titleId the title ID
	* @param verified the verified
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitleId_Virified(long titleId, boolean verified)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of comments where titleId = &#63; and verified = &#63;.
	*
	* @param titleId the title ID
	* @param verified the verified
	* @return the number of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitleId_Virified(long titleId, boolean verified)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the comments where titleId = &#63;.
	*
	* @param titleId the title ID
	* @return the matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findByTitleId(
		long titleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the comments where titleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titleId the title ID
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @return the range of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findByTitleId(
		long titleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the comments where titleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titleId the title ID
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findByTitleId(
		long titleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first comment in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment findByTitleId_First(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;

	/**
	* Returns the first comment in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment, or <code>null</code> if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment fetchByTitleId_First(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last comment in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment findByTitleId_Last(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;

	/**
	* Returns the last comment in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment, or <code>null</code> if a matching comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment fetchByTitleId_Last(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the comments before and after the current comment in the ordered set where titleId = &#63;.
	*
	* @param commentId the primary key of the current comment
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment[] findByTitleId_PrevAndNext(
		long commentId, long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;

	/**
	* Removes all the comments where titleId = &#63; from the database.
	*
	* @param titleId the title ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitleId(long titleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of comments where titleId = &#63;.
	*
	* @param titleId the title ID
	* @return the number of matching comments
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitleId(long titleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the comment in the entity cache if it is enabled.
	*
	* @param comment the comment
	*/
	public void cacheResult(
		ir.ac.iut.sccportal.guestdiscussion.model.Comment comment);

	/**
	* Caches the comments in the entity cache if it is enabled.
	*
	* @param comments the comments
	*/
	public void cacheResult(
		java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> comments);

	/**
	* Creates a new comment with the primary key. Does not add the comment to the database.
	*
	* @param commentId the primary key for the new comment
	* @return the new comment
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment create(
		long commentId);

	/**
	* Removes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commentId the primary key of the comment
	* @return the comment that was removed
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment remove(
		long commentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;

	public ir.ac.iut.sccportal.guestdiscussion.model.Comment updateImpl(
		ir.ac.iut.sccportal.guestdiscussion.model.Comment comment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the comment with the primary key or throws a {@link ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException} if it could not be found.
	*
	* @param commentId the primary key of the comment
	* @return the comment
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment findByPrimaryKey(
		long commentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;

	/**
	* Returns the comment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commentId the primary key of the comment
	* @return the comment, or <code>null</code> if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment fetchByPrimaryKey(
		long commentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the comments.
	*
	* @return the comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the comments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @return the range of comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the comments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of comments
	* @param end the upper bound of the range of comments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the comments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of comments.
	*
	* @return the number of comments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}