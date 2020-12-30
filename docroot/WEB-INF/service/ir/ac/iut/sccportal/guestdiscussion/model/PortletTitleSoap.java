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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ir.ac.iut.sccportal.guestdiscussion.service.http.PortletTitleServiceSoap}.
 *
 * @author Alireza
 * @see ir.ac.iut.sccportal.guestdiscussion.service.http.PortletTitleServiceSoap
 * @generated
 */
public class PortletTitleSoap implements Serializable {
	public static PortletTitleSoap toSoapModel(PortletTitle model) {
		PortletTitleSoap soapModel = new PortletTitleSoap();

		soapModel.setPortletId(model.getPortletId());
		soapModel.setTitleId(model.getTitleId());

		return soapModel;
	}

	public static PortletTitleSoap[] toSoapModels(PortletTitle[] models) {
		PortletTitleSoap[] soapModels = new PortletTitleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortletTitleSoap[][] toSoapModels(PortletTitle[][] models) {
		PortletTitleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortletTitleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortletTitleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortletTitleSoap[] toSoapModels(List<PortletTitle> models) {
		List<PortletTitleSoap> soapModels = new ArrayList<PortletTitleSoap>(models.size());

		for (PortletTitle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortletTitleSoap[soapModels.size()]);
	}

	public PortletTitleSoap() {
	}

	public String getPrimaryKey() {
		return _portletId;
	}

	public void setPrimaryKey(String pk) {
		setPortletId(pk);
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public long getTitleId() {
		return _titleId;
	}

	public void setTitleId(long titleId) {
		_titleId = titleId;
	}

	private String _portletId;
	private long _titleId;
}