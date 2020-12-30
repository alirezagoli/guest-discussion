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

import ir.ac.iut.sccportal.guestdiscussion.model.Title;

import java.util.List;

/**
 * The persistence utility for the title service. This utility wraps {@link TitlePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alireza
 * @see TitlePersistence
 * @see TitlePersistenceImpl
 * @generated
 */
public class TitleUtil {
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
	public static void clearCache(Title title) {
		getPersistence().clearCache(title);
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
	public static List<Title> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Title> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Title> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Title update(Title title) throws SystemException {
		return getPersistence().update(title);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Title update(Title title, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(title, serviceContext);
	}

	/**
	* Returns all the titles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Title> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the titles where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.TitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of titles
	* @param end the upper bound of the range of titles (not inclusive)
	* @return the range of matching titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Title> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the titles where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.TitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of titles
	* @param end the upper bound of the range of titles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Title> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first title in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching title
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a matching title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.Title findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first title in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching title, or <code>null</code> if a matching title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.Title fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last title in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching title
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a matching title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.Title findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last title in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching title, or <code>null</code> if a matching title could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.Title fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the titles before and after the current title in the ordered set where companyId = &#63;.
	*
	* @param titleId the primary key of the current title
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next title
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.Title[] findByCompanyId_PrevAndNext(
		long titleId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(titleId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the titles where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of titles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching titles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Caches the title in the entity cache if it is enabled.
	*
	* @param title the title
	*/
	public static void cacheResult(
		ir.ac.iut.sccportal.guestdiscussion.model.Title title) {
		getPersistence().cacheResult(title);
	}

	/**
	* Caches the titles in the entity cache if it is enabled.
	*
	* @param titles the titles
	*/
	public static void cacheResult(
		java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Title> titles) {
		getPersistence().cacheResult(titles);
	}

	/**
	* Creates a new title with the primary key. Does not add the title to the database.
	*
	* @param titleId the primary key for the new title
	* @return the new title
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.Title create(
		long titleId) {
		return getPersistence().create(titleId);
	}

	/**
	* Removes the title with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param titleId the primary key of the title
	* @return the title that was removed
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.Title remove(
		long titleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException {
		return getPersistence().remove(titleId);
	}

	public static ir.ac.iut.sccportal.guestdiscussion.model.Title updateImpl(
		ir.ac.iut.sccportal.guestdiscussion.model.Title title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(title);
	}

	/**
	* Returns the title with the primary key or throws a {@link ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException} if it could not be found.
	*
	* @param titleId the primary key of the title
	* @return the title
	* @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.Title findByPrimaryKey(
		long titleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException {
		return getPersistence().findByPrimaryKey(titleId);
	}

	/**
	* Returns the title with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param titleId the primary key of the title
	* @return the title, or <code>null</code> if a title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ir.ac.iut.sccportal.guestdiscussion.model.Title fetchByPrimaryKey(
		long titleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(titleId);
	}

	/**
	* Returns all the titles.
	*
	* @return the titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Title> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the titles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.TitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titles
	* @param end the upper bound of the range of titles (not inclusive)
	* @return the range of titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Title> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the titles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.TitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titles
	* @param end the upper bound of the range of titles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.Title> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the titles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of titles.
	*
	* @return the number of titles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TitlePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TitlePersistence)PortletBeanLocatorUtil.locate(ir.ac.iut.sccportal.guestdiscussion.service.ClpSerializer.getServletContextName(),
					TitlePersistence.class.getName());

			ReferenceRegistry.registerReference(TitleUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TitlePersistence persistence) {
	}

	private static TitlePersistence _persistence;
}