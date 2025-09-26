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
 * The extended model interface for the News_AttachFile service. Represents a row in the &quot;cw_News_AttachFile&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see News_AttachFileModel
 * @generated
 */
@ImplementationClassName("vn.dnict.tintuc.model.impl.News_AttachFileImpl")
@ProviderType
public interface News_AttachFile extends News_AttachFileModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>vn.dnict.tintuc.model.impl.News_AttachFileImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<News_AttachFile, Long> ID_ACCESSOR =
		new Accessor<News_AttachFile, Long>() {

			@Override
			public Long get(News_AttachFile news_AttachFile) {
				return news_AttachFile.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<News_AttachFile> getTypeClass() {
				return News_AttachFile.class;
			}

		};

}