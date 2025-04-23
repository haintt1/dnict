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

package qlanphamdb.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import qlanphamdb.exception.NoSuchAnPham_BinhLuanException;

import qlanphamdb.model.AnPham_BinhLuan;

/**
 * The persistence interface for the an pham_ binh luan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see AnPham_BinhLuanUtil
 * @generated
 */
@ProviderType
public interface AnPham_BinhLuanPersistence
	extends BasePersistence<AnPham_BinhLuan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnPham_BinhLuanUtil} to access the an pham_ binh luan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the an pham_ binh luan in the entity cache if it is enabled.
	 *
	 * @param anPham_BinhLuan the an pham_ binh luan
	 */
	public void cacheResult(AnPham_BinhLuan anPham_BinhLuan);

	/**
	 * Caches the an pham_ binh luans in the entity cache if it is enabled.
	 *
	 * @param anPham_BinhLuans the an pham_ binh luans
	 */
	public void cacheResult(java.util.List<AnPham_BinhLuan> anPham_BinhLuans);

	/**
	 * Creates a new an pham_ binh luan with the primary key. Does not add the an pham_ binh luan to the database.
	 *
	 * @param id the primary key for the new an pham_ binh luan
	 * @return the new an pham_ binh luan
	 */
	public AnPham_BinhLuan create(long id);

	/**
	 * Removes the an pham_ binh luan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the an pham_ binh luan
	 * @return the an pham_ binh luan that was removed
	 * @throws NoSuchAnPham_BinhLuanException if a an pham_ binh luan with the primary key could not be found
	 */
	public AnPham_BinhLuan remove(long id)
		throws NoSuchAnPham_BinhLuanException;

	public AnPham_BinhLuan updateImpl(AnPham_BinhLuan anPham_BinhLuan);

	/**
	 * Returns the an pham_ binh luan with the primary key or throws a <code>NoSuchAnPham_BinhLuanException</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ binh luan
	 * @return the an pham_ binh luan
	 * @throws NoSuchAnPham_BinhLuanException if a an pham_ binh luan with the primary key could not be found
	 */
	public AnPham_BinhLuan findByPrimaryKey(long id)
		throws NoSuchAnPham_BinhLuanException;

	/**
	 * Returns the an pham_ binh luan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ binh luan
	 * @return the an pham_ binh luan, or <code>null</code> if a an pham_ binh luan with the primary key could not be found
	 */
	public AnPham_BinhLuan fetchByPrimaryKey(long id);

	/**
	 * Returns all the an pham_ binh luans.
	 *
	 * @return the an pham_ binh luans
	 */
	public java.util.List<AnPham_BinhLuan> findAll();

	/**
	 * Returns a range of all the an pham_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ binh luans
	 * @param end the upper bound of the range of an pham_ binh luans (not inclusive)
	 * @return the range of an pham_ binh luans
	 */
	public java.util.List<AnPham_BinhLuan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the an pham_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ binh luans
	 * @param end the upper bound of the range of an pham_ binh luans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of an pham_ binh luans
	 */
	public java.util.List<AnPham_BinhLuan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnPham_BinhLuan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the an pham_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ binh luans
	 * @param end the upper bound of the range of an pham_ binh luans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of an pham_ binh luans
	 */
	public java.util.List<AnPham_BinhLuan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnPham_BinhLuan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the an pham_ binh luans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of an pham_ binh luans.
	 *
	 * @return the number of an pham_ binh luans
	 */
	public int countAll();

}