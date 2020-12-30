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

package ir.ac.iut.sccportal.guestdiscussion.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PortletTitle in entity cache.
 *
 * @author Alireza
 * @see PortletTitle
 * @generated
 */
public class PortletTitleCacheModel implements CacheModel<PortletTitle>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{portletId=");
		sb.append(portletId);
		sb.append(", titleId=");
		sb.append(titleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PortletTitle toEntityModel() {
		PortletTitleImpl portletTitleImpl = new PortletTitleImpl();

		if (portletId == null) {
			portletTitleImpl.setPortletId(StringPool.BLANK);
		}
		else {
			portletTitleImpl.setPortletId(portletId);
		}

		portletTitleImpl.setTitleId(titleId);

		portletTitleImpl.resetOriginalValues();

		return portletTitleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		portletId = objectInput.readUTF();
		titleId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (portletId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletId);
		}

		objectOutput.writeLong(titleId);
	}

	public String portletId;
	public long titleId;
}