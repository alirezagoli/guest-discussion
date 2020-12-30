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

import ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle;

/**
 * The persistence interface for the portlet title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alireza
 * @see PortletTitlePersistenceImpl
 * @see PortletTitleUtil
 * @generated
 */
public interface PortletTitlePersistence extends BasePersistence<PortletTitle> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PortletTitleUtil} to access the portlet title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the portlet titles where titleId = &#63;.
	*
	* @param titleId the title ID
	* @return the matching portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findByTitleId(
		long titleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the portlet titles where titleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titleId the title ID
	* @param start the lower bound of the range of portlet titles
	* @param end the upper bound of the range of portlet titles (not inclusive)
	* @return the range of matching portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findByTitleId(
		long titleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the portlet titles where titleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titleId the title ID
	* @param start the lower bound of the range of portlet titles
	* @param end the upper bound of the range of portlet titles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findByTitleId(
		long titleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portlet title in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet title
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a matching portlet title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle findByTitleId_First(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException;

	/**
	* Returns the first portlet title in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet title, or <code>null</code> if a matching portlet title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle fetchByTitleId_First(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portlet title in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet title
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a matching portlet title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle findByTitleId_Last(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException;

	/**
	* Returns the last portlet title in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet title, or <code>null</code> if a matching portlet title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle fetchByTitleId_Last(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portlet titles before and after the current portlet title in the ordered set where titleId = &#63;.
	*
	* @param portletId the primary key of the current portlet title
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet title
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a portlet title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle[] findByTitleId_PrevAndNext(
		java.lang.String portletId, long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException;

	/**
	* Removes all the portlet titles where titleId = &#63; from the database.
	*
	* @param titleId the title ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitleId(long titleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portlet titles where titleId = &#63;.
	*
	* @param titleId the title ID
	* @return the number of matching portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitleId(long titleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the portlet title in the entity cache if it is enabled.
	*
	* @param portletTitle the portlet title
	*/
	public void cacheResult(
		ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle portletTitle);

	/**
	* Caches the portlet titles in the entity cache if it is enabled.
	*
	* @param portletTitles the portlet titles
	*/
	public void cacheResult(
		java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> portletTitles);

	/**
	* Creates a new portlet title with the primary key. Does not add the portlet title to the database.
	*
	* @param portletId the primary key for the new portlet title
	* @return the new portlet title
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle create(
		java.lang.String portletId);

	/**
	* Removes the portlet title with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portletId the primary key of the portlet title
	* @return the portlet title that was removed
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a portlet title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle remove(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException;

	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle updateImpl(
		ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle portletTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portlet title with the primary key or throws a {@link ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException} if it could not be found.
	*
	* @param portletId the primary key of the portlet title
	* @return the portlet title
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a portlet title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle findByPrimaryKey(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException;

	/**
	* Returns the portlet title with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portletId the primary key of the portlet title
	* @return the portlet title, or <code>null</code> if a portlet title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle fetchByPrimaryKey(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portlet titles.
	*
	* @return the portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the portlet titles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of portlet titles
	* @param end the upper bound of the range of portlet titles (not inclusive)
	* @return the range of portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the portlet titles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of portlet titles
	* @param end the upper bound of the range of portlet titles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portlet titles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portlet titles.
	*
	* @return the number of portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}