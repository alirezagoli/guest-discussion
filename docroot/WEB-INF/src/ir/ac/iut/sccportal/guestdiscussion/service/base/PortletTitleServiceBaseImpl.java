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

package ir.ac.iut.sccportal.guestdiscussion.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle;
import ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleService;
import ir.ac.iut.sccportal.guestdiscussion.service.persistence.CommentPersistence;
import ir.ac.iut.sccportal.guestdiscussion.service.persistence.PortletTitlePersistence;
import ir.ac.iut.sccportal.guestdiscussion.service.persistence.TitlePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the portlet title remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link ir.ac.iut.sccportal.guestdiscussion.service.impl.PortletTitleServiceImpl}.
 * </p>
 *
 * @author Alireza
 * @see ir.ac.iut.sccportal.guestdiscussion.service.impl.PortletTitleServiceImpl
 * @see ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleServiceUtil
 * @generated
 */
public abstract class PortletTitleServiceBaseImpl extends BaseServiceImpl
	implements PortletTitleService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleServiceUtil} to access the portlet title remote service.
	 */

	/**
	 * Returns the comment local service.
	 *
	 * @return the comment local service
	 */
	public ir.ac.iut.sccportal.guestdiscussion.service.CommentLocalService getCommentLocalService() {
		return commentLocalService;
	}

	/**
	 * Sets the comment local service.
	 *
	 * @param commentLocalService the comment local service
	 */
	public void setCommentLocalService(
		ir.ac.iut.sccportal.guestdiscussion.service.CommentLocalService commentLocalService) {
		this.commentLocalService = commentLocalService;
	}

	/**
	 * Returns the comment remote service.
	 *
	 * @return the comment remote service
	 */
	public ir.ac.iut.sccportal.guestdiscussion.service.CommentService getCommentService() {
		return commentService;
	}

	/**
	 * Sets the comment remote service.
	 *
	 * @param commentService the comment remote service
	 */
	public void setCommentService(
		ir.ac.iut.sccportal.guestdiscussion.service.CommentService commentService) {
		this.commentService = commentService;
	}

	/**
	 * Returns the comment persistence.
	 *
	 * @return the comment persistence
	 */
	public CommentPersistence getCommentPersistence() {
		return commentPersistence;
	}

	/**
	 * Sets the comment persistence.
	 *
	 * @param commentPersistence the comment persistence
	 */
	public void setCommentPersistence(CommentPersistence commentPersistence) {
		this.commentPersistence = commentPersistence;
	}

	/**
	 * Returns the portlet title local service.
	 *
	 * @return the portlet title local service
	 */
	public ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleLocalService getPortletTitleLocalService() {
		return portletTitleLocalService;
	}

	/**
	 * Sets the portlet title local service.
	 *
	 * @param portletTitleLocalService the portlet title local service
	 */
	public void setPortletTitleLocalService(
		ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleLocalService portletTitleLocalService) {
		this.portletTitleLocalService = portletTitleLocalService;
	}

	/**
	 * Returns the portlet title remote service.
	 *
	 * @return the portlet title remote service
	 */
	public ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleService getPortletTitleService() {
		return portletTitleService;
	}

	/**
	 * Sets the portlet title remote service.
	 *
	 * @param portletTitleService the portlet title remote service
	 */
	public void setPortletTitleService(
		ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleService portletTitleService) {
		this.portletTitleService = portletTitleService;
	}

	/**
	 * Returns the portlet title persistence.
	 *
	 * @return the portlet title persistence
	 */
	public PortletTitlePersistence getPortletTitlePersistence() {
		return portletTitlePersistence;
	}

	/**
	 * Sets the portlet title persistence.
	 *
	 * @param portletTitlePersistence the portlet title persistence
	 */
	public void setPortletTitlePersistence(
		PortletTitlePersistence portletTitlePersistence) {
		this.portletTitlePersistence = portletTitlePersistence;
	}

	/**
	 * Returns the title local service.
	 *
	 * @return the title local service
	 */
	public ir.ac.iut.sccportal.guestdiscussion.service.TitleLocalService getTitleLocalService() {
		return titleLocalService;
	}

	/**
	 * Sets the title local service.
	 *
	 * @param titleLocalService the title local service
	 */
	public void setTitleLocalService(
		ir.ac.iut.sccportal.guestdiscussion.service.TitleLocalService titleLocalService) {
		this.titleLocalService = titleLocalService;
	}

	/**
	 * Returns the title remote service.
	 *
	 * @return the title remote service
	 */
	public ir.ac.iut.sccportal.guestdiscussion.service.TitleService getTitleService() {
		return titleService;
	}

	/**
	 * Sets the title remote service.
	 *
	 * @param titleService the title remote service
	 */
	public void setTitleService(
		ir.ac.iut.sccportal.guestdiscussion.service.TitleService titleService) {
		this.titleService = titleService;
	}

	/**
	 * Returns the title persistence.
	 *
	 * @return the title persistence
	 */
	public TitlePersistence getTitlePersistence() {
		return titlePersistence;
	}

	/**
	 * Sets the title persistence.
	 *
	 * @param titlePersistence the title persistence
	 */
	public void setTitlePersistence(TitlePersistence titlePersistence) {
		this.titlePersistence = titlePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return PortletTitle.class;
	}

	protected String getModelClassName() {
		return PortletTitle.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = portletTitlePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ir.ac.iut.sccportal.guestdiscussion.service.CommentLocalService.class)
	protected ir.ac.iut.sccportal.guestdiscussion.service.CommentLocalService commentLocalService;
	@BeanReference(type = ir.ac.iut.sccportal.guestdiscussion.service.CommentService.class)
	protected ir.ac.iut.sccportal.guestdiscussion.service.CommentService commentService;
	@BeanReference(type = CommentPersistence.class)
	protected CommentPersistence commentPersistence;
	@BeanReference(type = ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleLocalService.class)
	protected ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleLocalService portletTitleLocalService;
	@BeanReference(type = ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleService.class)
	protected ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleService portletTitleService;
	@BeanReference(type = PortletTitlePersistence.class)
	protected PortletTitlePersistence portletTitlePersistence;
	@BeanReference(type = ir.ac.iut.sccportal.guestdiscussion.service.TitleLocalService.class)
	protected ir.ac.iut.sccportal.guestdiscussion.service.TitleLocalService titleLocalService;
	@BeanReference(type = ir.ac.iut.sccportal.guestdiscussion.service.TitleService.class)
	protected ir.ac.iut.sccportal.guestdiscussion.service.TitleService titleService;
	@BeanReference(type = TitlePersistence.class)
	protected TitlePersistence titlePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private PortletTitleServiceClpInvoker _clpInvoker = new PortletTitleServiceClpInvoker();
}