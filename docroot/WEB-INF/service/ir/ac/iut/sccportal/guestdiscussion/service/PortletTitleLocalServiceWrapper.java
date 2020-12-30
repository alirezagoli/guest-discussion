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
 * Provides a wrapper for {@link PortletTitleLocalService}.
 *
 * @author Alireza
 * @see PortletTitleLocalService
 * @generated
 */
public class PortletTitleLocalServiceWrapper implements PortletTitleLocalService,
	ServiceWrapper<PortletTitleLocalService> {
	public PortletTitleLocalServiceWrapper(
		PortletTitleLocalService portletTitleLocalService) {
		_portletTitleLocalService = portletTitleLocalService;
	}

	/**
	* Adds the portlet title to the database. Also notifies the appropriate model listeners.
	*
	* @param portletTitle the portlet title
	* @return the portlet title that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle addPortletTitle(
		ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle portletTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletTitleLocalService.addPortletTitle(portletTitle);
	}

	/**
	* Creates a new portlet title with the primary key. Does not add the portlet title to the database.
	*
	* @param portletId the primary key for the new portlet title
	* @return the new portlet title
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle createPortletTitle(
		java.lang.String portletId) {
		return _portletTitleLocalService.createPortletTitle(portletId);
	}

	/**
	* Deletes the portlet title with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portletId the primary key of the portlet title
	* @return the portlet title that was removed
	* @throws PortalException if a portlet title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle deletePortletTitle(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletTitleLocalService.deletePortletTitle(portletId);
	}

	/**
	* Deletes the portlet title from the database. Also notifies the appropriate model listeners.
	*
	* @param portletTitle the portlet title
	* @return the portlet title that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle deletePortletTitle(
		ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle portletTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletTitleLocalService.deletePortletTitle(portletTitle);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _portletTitleLocalService.dynamicQuery();
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
		return _portletTitleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _portletTitleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _portletTitleLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _portletTitleLocalService.dynamicQueryCount(dynamicQuery);
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
		return _portletTitleLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle fetchPortletTitle(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletTitleLocalService.fetchPortletTitle(portletId);
	}

	/**
	* Returns the portlet title with the primary key.
	*
	* @param portletId the primary key of the portlet title
	* @return the portlet title
	* @throws PortalException if a portlet title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle getPortletTitle(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletTitleLocalService.getPortletTitle(portletId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletTitleLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> getPortletTitles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletTitleLocalService.getPortletTitles(start, end);
	}

	/**
	* Returns the number of portlet titles.
	*
	* @return the number of portlet titles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPortletTitlesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletTitleLocalService.getPortletTitlesCount();
	}

	/**
	* Updates the portlet title in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portletTitle the portlet title
	* @return the portlet title that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle updatePortletTitle(
		ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle portletTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletTitleLocalService.updatePortletTitle(portletTitle);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _portletTitleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_portletTitleLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _portletTitleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void deletePortletTitleByTitleId(long titleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_portletTitleLocalService.deletePortletTitleByTitleId(titleId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PortletTitleLocalService getWrappedPortletTitleLocalService() {
		return _portletTitleLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPortletTitleLocalService(
		PortletTitleLocalService portletTitleLocalService) {
		_portletTitleLocalService = portletTitleLocalService;
	}

	@Override
	public PortletTitleLocalService getWrappedService() {
		return _portletTitleLocalService;
	}

	@Override
	public void setWrappedService(
		PortletTitleLocalService portletTitleLocalService) {
		_portletTitleLocalService = portletTitleLocalService;
	}

	private PortletTitleLocalService _portletTitleLocalService;
}