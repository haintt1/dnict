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

import qlanphamdb.exception.NoSuchAnPham_CongTacVienException;

import qlanphamdb.model.AnPham_CongTacVien;

/**
 * The persistence interface for the an pham_ cong tac vien service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see AnPham_CongTacVienUtil
 * @generated
 */
@ProviderType
public interface AnPham_CongTacVienPersistence
	extends BasePersistence<AnPham_CongTacVien> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnPham_CongTacVienUtil} to access the an pham_ cong tac vien persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the an pham_ cong tac vien in the entity cache if it is enabled.
	 *
	 * @param anPham_CongTacVien the an pham_ cong tac vien
	 */
	public void cacheResult(AnPham_CongTacVien anPham_CongTacVien);

	/**
	 * Caches the an pham_ cong tac viens in the entity cache if it is enabled.
	 *
	 * @param anPham_CongTacViens the an pham_ cong tac viens
	 */
	public void cacheResult(
		java.util.List<AnPham_CongTacVien> anPham_CongTacViens);

	/**
	 * Creates a new an pham_ cong tac vien with the primary key. Does not add the an pham_ cong tac vien to the database.
	 *
	 * @param id the primary key for the new an pham_ cong tac vien
	 * @return the new an pham_ cong tac vien
	 */
	public AnPham_CongTacVien create(long id);

	/**
	 * Removes the an pham_ cong tac vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien that was removed
	 * @throws NoSuchAnPham_CongTacVienException if a an pham_ cong tac vien with the primary key could not be found
	 */
	public AnPham_CongTacVien remove(long id)
		throws NoSuchAnPham_CongTacVienException;

	public AnPham_CongTacVien updateImpl(AnPham_CongTacVien anPham_CongTacVien);

	/**
	 * Returns the an pham_ cong tac vien with the primary key or throws a <code>NoSuchAnPham_CongTacVienException</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien
	 * @throws NoSuchAnPham_CongTacVienException if a an pham_ cong tac vien with the primary key could not be found
	 */
	public AnPham_CongTacVien findByPrimaryKey(long id)
		throws NoSuchAnPham_CongTacVienException;

	/**
	 * Returns the an pham_ cong tac vien with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien, or <code>null</code> if a an pham_ cong tac vien with the primary key could not be found
	 */
	public AnPham_CongTacVien fetchByPrimaryKey(long id);

	/**
	 * Returns all the an pham_ cong tac viens.
	 *
	 * @return the an pham_ cong tac viens
	 */
	public java.util.List<AnPham_CongTacVien> findAll();

	/**
	 * Returns a range of all the an pham_ cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_CongTacVienModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ cong tac viens
	 * @param end the upper bound of the range of an pham_ cong tac viens (not inclusive)
	 * @return the range of an pham_ cong tac viens
	 */
	public java.util.List<AnPham_CongTacVien> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the an pham_ cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_CongTacVienModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ cong tac viens
	 * @param end the upper bound of the range of an pham_ cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of an pham_ cong tac viens
	 */
	public java.util.List<AnPham_CongTacVien> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnPham_CongTacVien>
			orderByComparator);

	/**
	 * Returns an ordered range of all the an pham_ cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_CongTacVienModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ cong tac viens
	 * @param end the upper bound of the range of an pham_ cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of an pham_ cong tac viens
	 */
	public java.util.List<AnPham_CongTacVien> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnPham_CongTacVien>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the an pham_ cong tac viens from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of an pham_ cong tac viens.
	 *
	 * @return the number of an pham_ cong tac viens
	 */
	public int countAll();

}