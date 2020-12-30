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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ir.ac.iut.sccportal.guestdiscussion.model.Comment;
import ir.ac.iut.sccportal.guestdiscussion.service.CommentLocalServiceUtil;

/**
 * @author Alireza
 * @generated
 */
public abstract class CommentActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public CommentActionableDynamicQuery() throws SystemException {
		setBaseLocalService(CommentLocalServiceUtil.getService());
		setClass(Comment.class);

		setClassLoader(ir.ac.iut.sccportal.guestdiscussion.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("commentId");
	}
}