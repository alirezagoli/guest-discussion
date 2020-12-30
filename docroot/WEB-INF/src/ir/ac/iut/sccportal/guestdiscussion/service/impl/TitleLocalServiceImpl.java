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

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;

import ir.ac.iut.sccportal.guestdiscussion.model.Title;
import ir.ac.iut.sccportal.guestdiscussion.service.base.TitleLocalServiceBaseImpl;

/**
 * The implementation of the title local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ir.ac.iut.sccportal.guestdiscussion.service.TitleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Alireza
 * @see ir.ac.iut.sccportal.guestdiscussion.service.base.TitleLocalServiceBaseImpl
 * @see ir.ac.iut.sccportal.guestdiscussion.service.TitleLocalServiceUtil
 */
public class TitleLocalServiceImpl extends TitleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link ir.ac.iut.sccportal.guestdiscussion.service.TitleLocalServiceUtil} to access the title local service.
	 */
	
	public Title addTitle(long groupId, long companyId, long userId, String userName, String titleText) throws SystemException, NoSuchUserException
	{
		Title title=titlePersistence.create(0);
		title.setGroupId(groupId);
		title.setCompanyId(companyId);
		title.setUserId(userId);
		title.setUserName(userName);
		title.setCreateDate(new Date());
		title.setTitleText(titleText);
		
		return super.addTitle(title);
		
	}
	
	public List<Title> getTitlesByCompanyId (long companyId) throws SystemException {
	    return titlePersistence.findByCompanyId(companyId);
	}
	
	
}