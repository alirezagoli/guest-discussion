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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ir.ac.iut.sccportal.guestdiscussion.service.ClpSerializer;
import ir.ac.iut.sccportal.guestdiscussion.service.PortletTitleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alireza
 */
public class PortletTitleClp extends BaseModelImpl<PortletTitle>
	implements PortletTitle {
	public PortletTitleClp() {
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
	public String getPrimaryKey() {
		return _portletId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setPortletId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _portletId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
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

	@Override
	public String getPortletId() {
		return _portletId;
	}

	@Override
	public void setPortletId(String portletId) {
		_portletId = portletId;

		if (_portletTitleRemoteModel != null) {
			try {
				Class<?> clazz = _portletTitleRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletId", String.class);

				method.invoke(_portletTitleRemoteModel, portletId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTitleId() {
		return _titleId;
	}

	@Override
	public void setTitleId(long titleId) {
		_titleId = titleId;

		if (_portletTitleRemoteModel != null) {
			try {
				Class<?> clazz = _portletTitleRemoteModel.getClass();

				Method method = clazz.getMethod("setTitleId", long.class);

				method.invoke(_portletTitleRemoteModel, titleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPortletTitleRemoteModel() {
		return _portletTitleRemoteModel;
	}

	public void setPortletTitleRemoteModel(BaseModel<?> portletTitleRemoteModel) {
		_portletTitleRemoteModel = portletTitleRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _portletTitleRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_portletTitleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PortletTitleLocalServiceUtil.addPortletTitle(this);
		}
		else {
			PortletTitleLocalServiceUtil.updatePortletTitle(this);
		}
	}

	@Override
	public PortletTitle toEscapedModel() {
		return (PortletTitle)ProxyUtil.newProxyInstance(PortletTitle.class.getClassLoader(),
			new Class[] { PortletTitle.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortletTitleClp clone = new PortletTitleClp();

		clone.setPortletId(getPortletId());
		clone.setTitleId(getTitleId());

		return clone;
	}

	@Override
	public int compareTo(PortletTitle portletTitle) {
		String primaryKey = portletTitle.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortletTitleClp)) {
			return false;
		}

		PortletTitleClp portletTitle = (PortletTitleClp)obj;

		String primaryKey = portletTitle.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{portletId=");
		sb.append(getPortletId());
		sb.append(", titleId=");
		sb.append(getTitleId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleId</column-name><column-value><![CDATA[");
		sb.append(getTitleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _portletId;
	private long _titleId;
	private BaseModel<?> _portletTitleRemoteModel;
	private Class<?> _clpSerializerClass = ir.ac.iut.sccportal.guestdiscussion.service.ClpSerializer.class;
}