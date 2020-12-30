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

package ir.ac.iut.sccportal.guestdiscussion.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PortletTitle}.
 * </p>
 *
 * @author Alireza
 * @see PortletTitle
 * @generated
 */
public class PortletTitleWrapper implements PortletTitle,
	ModelWrapper<PortletTitle> {
	public PortletTitleWrapper(PortletTitle portletTitle) {
		_portletTitle = portletTitle;
	}

	@Override
	public Class<?> getModelClass() {
		return PortletTitle.class;
	}

	@Override
	public String getModelClassName() {
		return PortletTitle.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("portletId", getPortletId());
		attributes.put("titleId", getTitleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		Long titleId = (Long)attributes.get("titleId");

		if (titleId != null) {
			setTitleId(titleId);
		}
	}

	/**
	* Returns the primary key of this portlet title.
	*
	* @return the primary key of this portlet title
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _portletTitle.getPrimaryKey();
	}

	/**
	* Sets the primary key of this portlet title.
	*
	* @param primaryKey the primary key of this portlet title
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_portletTitle.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the portlet ID of this portlet title.
	*
	* @return the portlet ID of this portlet title
	*/
	@Override
	public java.lang.String getPortletId() {
		return _portletTitle.getPortletId();
	}

	/**
	* Sets the portlet ID of this portlet title.
	*
	* @param portletId the portlet ID of this portlet title
	*/
	@Override
	public void setPortletId(java.lang.String portletId) {
		_portletTitle.setPortletId(portletId);
	}

	/**
	* Returns the title ID of this portlet title.
	*
	* @return the title ID of this portlet title
	*/
	@Override
	public long getTitleId() {
		return _portletTitle.getTitleId();
	}

	/**
	* Sets the title ID of this portlet title.
	*
	* @param titleId the title ID of this portlet title
	*/
	@Override
	public void setTitleId(long titleId) {
		_portletTitle.setTitleId(titleId);
	}

	@Override
	public boolean isNew() {
		return _portletTitle.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_portletTitle.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _portletTitle.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_portletTitle.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _portletTitle.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _portletTitle.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portletTitle.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portletTitle.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_portletTitle.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_portletTitle.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portletTitle.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortletTitleWrapper((PortletTitle)_portletTitle.clone());
	}

	@Override
	public int compareTo(
		ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle portletTitle) {
		return _portletTitle.compareTo(portletTitle);
	}

	@Override
	public int hashCode() {
		return _portletTitle.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle> toCacheModel() {
		return _portletTitle.toCacheModel();
	}

	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle toEscapedModel() {
		return new PortletTitleWrapper(_portletTitle.toEscapedModel());
	}

	@Override
	public ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle toUnescapedModel() {
		return new PortletTitleWrapper(_portletTitle.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portletTitle.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _portletTitle.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portletTitle.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortletTitleWrapper)) {
			return false;
		}

		PortletTitleWrapper portletTitleWrapper = (PortletTitleWrapper)obj;

		if (Validator.equals(_portletTitle, portletTitleWrapper._portletTitle)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PortletTitle getWrappedPortletTitle() {
		return _portletTitle;
	}

	@Override
	public PortletTitle getWrappedModel() {
		return _portletTitle;
	}

	@Override
	public void resetOriginalValues() {
		_portletTitle.resetOriginalValues();
	}

	private PortletTitle _portletTitle;
}