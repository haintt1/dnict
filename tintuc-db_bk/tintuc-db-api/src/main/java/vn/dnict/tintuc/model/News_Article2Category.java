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
 * The extended model interface for the News_Article2Category service. Represents a row in the &quot;cw_News_Article2Category&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see News_Article2CategoryModel
 * @generated
 */
@ImplementationClassName("vn.dnict.tintuc.model.impl.News_Article2CategoryImpl")
@ProviderType
public interface News_Article2Category
	extends News_Article2CategoryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>vn.dnict.tintuc.model.impl.News_Article2CategoryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<News_Article2Category, Long> ID_ACCESSOR =
		new Accessor<News_Article2Category, Long>() {

			@Override
			public Long get(News_Article2Category news_Article2Category) {
				return news_Article2Category.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<News_Article2Category> getTypeClass() {
				return News_Article2Category.class;
			}

		};

}