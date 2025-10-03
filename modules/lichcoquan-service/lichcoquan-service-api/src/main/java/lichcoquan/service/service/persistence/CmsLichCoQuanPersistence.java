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

package lichcoquan.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import lichcoquan.service.exception.NoSuchCmsLichCoQuanException;
import lichcoquan.service.model.CmsLichCoQuan;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cms lich co quan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see CmsLichCoQuanUtil
 * @generated
 */
@ProviderType
public interface CmsLichCoQuanPersistence
	extends BasePersistence<CmsLichCoQuan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CmsLichCoQuanUtil} to access the cms lich co quan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the cms lich co quan in the entity cache if it is enabled.
	 *
	 * @param cmsLichCoQuan the cms lich co quan
	 */
	public void cacheResult(CmsLichCoQuan cmsLichCoQuan);

	/**
	 * Caches the cms lich co quans in the entity cache if it is enabled.
	 *
	 * @param cmsLichCoQuans the cms lich co quans
	 */
	public void cacheResult(java.util.List<CmsLichCoQuan> cmsLichCoQuans);

	/**
	 * Creates a new cms lich co quan with the primary key. Does not add the cms lich co quan to the database.
	 *
	 * @param lichCongtacId the primary key for the new cms lich co quan
	 * @return the new cms lich co quan
	 */
	public CmsLichCoQuan create(long lichCongtacId);

	/**
	 * Removes the cms lich co quan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongtacId the primary key of the cms lich co quan
	 * @return the cms lich co quan that was removed
	 * @throws NoSuchCmsLichCoQuanException if a cms lich co quan with the primary key could not be found
	 */
	public CmsLichCoQuan remove(long lichCongtacId)
		throws NoSuchCmsLichCoQuanException;

	public CmsLichCoQuan updateImpl(CmsLichCoQuan cmsLichCoQuan);

	/**
	 * Returns the cms lich co quan with the primary key or throws a <code>NoSuchCmsLichCoQuanException</code> if it could not be found.
	 *
	 * @param lichCongtacId the primary key of the cms lich co quan
	 * @return the cms lich co quan
	 * @throws NoSuchCmsLichCoQuanException if a cms lich co quan with the primary key could not be found
	 */
	public CmsLichCoQuan findByPrimaryKey(long lichCongtacId)
		throws NoSuchCmsLichCoQuanException;

	/**
	 * Returns the cms lich co quan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichCongtacId the primary key of the cms lich co quan
	 * @return the cms lich co quan, or <code>null</code> if a cms lich co quan with the primary key could not be found
	 */
	public CmsLichCoQuan fetchByPrimaryKey(long lichCongtacId);

	/**
	 * Returns all the cms lich co quans.
	 *
	 * @return the cms lich co quans
	 */
	public java.util.List<CmsLichCoQuan> findAll();

	/**
	 * Returns a range of all the cms lich co quans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CmsLichCoQuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cms lich co quans
	 * @param end the upper bound of the range of cms lich co quans (not inclusive)
	 * @return the range of cms lich co quans
	 */
	public java.util.List<CmsLichCoQuan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cms lich co quans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CmsLichCoQuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cms lich co quans
	 * @param end the upper bound of the range of cms lich co quans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cms lich co quans
	 */
	public java.util.List<CmsLichCoQuan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CmsLichCoQuan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cms lich co quans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CmsLichCoQuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cms lich co quans
	 * @param end the upper bound of the range of cms lich co quans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cms lich co quans
	 */
	public java.util.List<CmsLichCoQuan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CmsLichCoQuan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cms lich co quans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cms lich co quans.
	 *
	 * @return the number of cms lich co quans
	 */
	public int countAll();

}