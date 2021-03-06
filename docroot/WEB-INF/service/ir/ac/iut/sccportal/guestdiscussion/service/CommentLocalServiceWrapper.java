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

package ir.ac.iut.sccportal.guestdiscussion.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommentLocalService}.
 *
 * @author Alireza
 * @see CommentLocalService
 * @generated
 */
public class CommentLocalServiceWrapper implements CommentLocalService,
	ServiceWrapper<CommentLocalService> {
	public CommentLocalServiceWrapper(CommentLocalService commentLocalService) {
		_commentLocalService = commentLocalService;
	}

	/**
	* Adds the comment to the database. Also notifies the appropriate model listeners.
	*
	* @param comment the comment
	* @return the comment that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment addComment(
		ir.ac.iut.sccportal.guestdiscussion.model.Comment comment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.addComment(comment);
	}

	/**
	* Creates a new comment with the primary key. Does not add the comment to the database.
	*
	* @param commentId the primary key for the new comment
	* @return the new comment
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment createComment(
		long commentId) {
		return _commentLocalService.createComment(commentId);
	}

	/**
	* Deletes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commentId the primary key of the comment
	* @return the comment that was removed
	* @throws PortalException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment deleteComment(
		long commentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.deleteComment(commentId);
	}

	/**
	* Deletes the comment from the database. Also notifies the appropriate model listeners.
	*
	* @param comment the comment
	* @return the comment that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment deleteComment(
		ir.ac.iut.sccportal.guestdiscussion.model.Comment comment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.deleteComment(comment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment fetchComment(
		long commentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.fetchComment(commentId);
	}

	/**
	* Returns the comment with the primary key.
	*
	* @param commentId the primary key of the comment
	* @return the comment
	* @throws PortalException if a comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment getComment(
		long commentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.getComment(commentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> getComments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.getComments(start, end);
	}

	/**
	* Returns the number of comments.
	*
	* @return the number of comments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCommentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.getCommentsCount();
	}

	/**
	* Updates the comment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param comment the comment
	* @return the comment that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment updateComment(
		ir.ac.iut.sccportal.guestdiscussion.model.Comment comment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.updateComment(comment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _commentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_commentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _commentLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.Comment addComment(
		long groupId, long companyId, java.util.Date modifiedDate,
		long parentId, java.lang.String commentText,
		java.lang.String guestName, long likeCount, long titleId,
		boolean verified, boolean hasChild, java.lang.String parentName,
		java.lang.String guestEmailAddress, boolean guestEmailNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.addComment(groupId, companyId,
			modifiedDate, parentId, commentText, guestName, likeCount, titleId,
			verified, hasChild, parentName, guestEmailAddress,
			guestEmailNotification);
	}

	@Override
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> getCommentsByParentId_TitleId_Verified(
		long parentId, long titleId, boolean verified)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.getCommentsByParentId_TitleId_Verified(parentId,
			titleId, verified);
	}

	@Override
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> getCommentsByTitleId_Verified(
		long titleId, boolean verified)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.getCommentsByTitleId_Verified(titleId,
			verified);
	}

	@Override
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Comment> getCommentsByTitleId(
		long titleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commentLocalService.getCommentsByTitleId(titleId);
	}

	@Override
	public void deleteCommentsByTitleId(long titleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_commentLocalService.deleteCommentsByTitleId(titleId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CommentLocalService getWrappedCommentLocalService() {
		return _commentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCommentLocalService(
		CommentLocalService commentLocalService) {
		_commentLocalService = commentLocalService;
	}

	@Override
	public CommentLocalService getWrappedService() {
		return _commentLocalService;
	}

	@Override
	public void setWrappedService(CommentLocalService commentLocalService) {
		_commentLocalService = commentLocalService;
	}

	private CommentLocalService _commentLocalService;
}