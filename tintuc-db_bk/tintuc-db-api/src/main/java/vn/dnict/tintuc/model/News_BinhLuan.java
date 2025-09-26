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

package vn.dnict.tintuc.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the News_BinhLuan service. Represents a row in the &quot;cw_News_BinhLuan&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see News_BinhLuanModel
 * @generated
 */
@ImplementationClassName("vn.dnict.tintuc.model.impl.News_BinhLuanImpl")
@ProviderType
public interface News_BinhLuan extends News_BinhLuanModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>vn.dnict.tintuc.model.impl.News_BinhLuanImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<News_BinhLuan, Long> ID_ACCESSOR =
		new Accessor<News_BinhLuan, Long>() {

			@Override
			public Long get(News_BinhLuan news_BinhLuan) {
				return news_BinhLuan.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<News_BinhLuan> getTypeClass() {
				return News_BinhLuan.class;
			}

		};

}