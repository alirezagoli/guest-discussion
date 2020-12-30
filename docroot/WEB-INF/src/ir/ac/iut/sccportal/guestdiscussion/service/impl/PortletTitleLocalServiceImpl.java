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

import com.liferay.portal.kernel.exception.SystemException;

import ir.ac.iut.sccportal.guestdiscussion.service.base.PortletTitleLocalServiceBaseImpl;

/**
 * The implementation of the portlet title local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Alireza
 * @see ir.ac.iut.sccportal.guestdiscussion.service.base.PortletTitleLocalServiceBaseImpl
 * @see ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleLocalServiceUtil
 */
public class PortletTitleLocalServiceImpl
	extends PortletTitleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleLocalServiceUtil} to access the portlet title local service.
	 */
	
	public void deletePortletTitleByTitleId (long titleId) throws SystemException  {
	     portletTitlePersistence.removeByTitleId(titleId);
	}
}