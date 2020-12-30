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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle;

import java.util.List;

/**
 * The persistence utility for the portlet title service. This utility wraps {@link PortletTitlePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alireza
 * @see PortletTitlePersistence
 * @see PortletTitlePersistenceImpl
 * @generated
 */
public class PortletTitleUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(PortletTitle portletTitle) {
		getPersistence().clearCache(portletTitle);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PortletTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortletTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortletTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PortletTitle update(PortletTitle portletTitle)
		throws SystemException {
		return getPersistence().update(portletTitle);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PortletTitle update(PortletTitle portletTitle,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(portletTitle, serviceContext);
	}

	/**
	* Returns all the portlet titles where titleId = &#63;.
	*
	* @param titleId the title ID
	* @return the matching portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findByTitleId(
		long titleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitleId(titleId);
	}

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
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findByTitleId(
		long titleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitleId(titleId, start, end);
	}

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
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findByTitleId(
		long titleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitleId(titleId, start, end, orderByComparator);
	}

	/**
	* Returns the first portlet title in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet title
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a matching portlet title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle findByTitleId_First(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException {
		return getPersistence().findByTitleId_First(titleId, orderByComparator);
	}

	/**
	* Returns the first portlet title in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet title, or <code>null</code> if a matching portlet title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle fetchByTitleId_First(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitleId_First(titleId, orderByComparator);
	}

	/**
	* Returns the last portlet title in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet title
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a matching portlet title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle findByTitleId_Last(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException {
		return getPersistence().findByTitleId_Last(titleId, orderByComparator);
	}

	/**
	* Returns the last portlet title in the ordered set where titleId = &#63;.
	*
	* @param titleId the title ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet title, or <code>null</code> if a matching portlet title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle fetchByTitleId_Last(
		long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitleId_Last(titleId, orderByComparator);
	}

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
	public static ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle[] findByTitleId_PrevAndNext(
		java.lang.String portletId, long titleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException {
		return getPersistence()
				   .findByTitleId_PrevAndNext(portletId, titleId,
			orderByComparator);
	}

	/**
	* Removes all the portlet titles where titleId = &#63; from the database.
	*
	* @param titleId the title ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitleId(long titleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitleId(titleId);
	}

	/**
	* Returns the number of portlet titles where titleId = &#63;.
	*
	* @param titleId the title ID
	* @return the number of matching portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitleId(long titleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitleId(titleId);
	}

	/**
	* Caches the portlet title in the entity cache if it is enabled.
	*
	* @param portletTitle the portlet title
	*/
	public static void cacheResult(
		ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle portletTitle) {
		getPersistence().cacheResult(portletTitle);
	}

	/**
	* Caches the portlet titles in the entity cache if it is enabled.
	*
	* @param portletTitles the portlet titles
	*/
	public static void cacheResult(
		java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> portletTitles) {
		getPersistence().cacheResult(portletTitles);
	}

	/**
	* Creates a new portlet title with the primary key. Does not add the portlet title to the database.
	*
	* @param portletId the primary key for the new portlet title
	* @return the new portlet title
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle create(
		java.lang.String portletId) {
		return getPersistence().create(portletId);
	}

	/**
	* Removes the portlet title with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portletId the primary key of the portlet title
	* @return the portlet title that was removed
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a portlet title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle remove(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException {
		return getPersistence().remove(portletId);
	}

	public static ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle updateImpl(
		ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle portletTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(portletTitle);
	}

	/**
	* Returns the portlet title with the primary key or throws a {@link ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException} if it could not be found.
	*
	* @param portletId the primary key of the portlet title
	* @return the portlet title
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a portlet title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle findByPrimaryKey(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException {
		return getPersistence().findByPrimaryKey(portletId);
	}

	/**
	* Returns the portlet title with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portletId the primary key of the portlet title
	* @return the portlet title, or <code>null</code> if a portlet title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle fetchByPrimaryKey(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(portletId);
	}

	/**
	* Returns all the portlet titles.
	*
	* @return the portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the portlet titles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of portlet titles.
	*
	* @return the number of portlet titles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PortletTitlePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PortletTitlePersistence)PortletBeanLocatorUtil.locate(ir.ac.iut.sccportal.guestdiscussion.service.ClpSerializer.getServletContextName(),
					PortletTitlePersistence.class.getName());

			ReferenceRegistry.registerReference(PortletTitleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PortletTitlePersistence persistence) {
	}

	private static PortletTitlePersistence _persistence;
}