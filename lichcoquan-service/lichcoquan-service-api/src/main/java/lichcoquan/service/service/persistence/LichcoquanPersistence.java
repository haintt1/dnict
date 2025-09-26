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

import lichcoquan.service.exception.NoSuchLichcoquanException;
import lichcoquan.service.model.Lichcoquan;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lichcoquan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see LichcoquanUtil
 * @generated
 */
@ProviderType
public interface LichcoquanPersistence extends BasePersistence<Lichcoquan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LichcoquanUtil} to access the lichcoquan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the lichcoquan in the entity cache if it is enabled.
	 *
	 * @param lichcoquan the lichcoquan
	 */
	public void cacheResult(Lichcoquan lichcoquan);

	/**
	 * Caches the lichcoquans in the entity cache if it is enabled.
	 *
	 * @param lichcoquans the lichcoquans
	 */
	public void cacheResult(java.util.List<Lichcoquan> lichcoquans);

	/**
	 * Creates a new lichcoquan with the primary key. Does not add the lichcoquan to the database.
	 *
	 * @param lichCongtacId the primary key for the new lichcoquan
	 * @return the new lichcoquan
	 */
	public Lichcoquan create(long lichCongtacId);

	/**
	 * Removes the lichcoquan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongtacId the primary key of the lichcoquan
	 * @return the lichcoquan that was removed
	 * @throws NoSuchLichcoquanException if a lichcoquan with the primary key could not be found
	 */
	public Lichcoquan remove(long lichCongtacId)
		throws NoSuchLichcoquanException;

	public Lichcoquan updateImpl(Lichcoquan lichcoquan);

	/**
	 * Returns the lichcoquan with the primary key or throws a <code>NoSuchLichcoquanException</code> if it could not be found.
	 *
	 * @param lichCongtacId the primary key of the lichcoquan
	 * @return the lichcoquan
	 * @throws NoSuchLichcoquanException if a lichcoquan with the primary key could not be found
	 */
	public Lichcoquan findByPrimaryKey(long lichCongtacId)
		throws NoSuchLichcoquanException;

	/**
	 * Returns the lichcoquan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichCongtacId the primary key of the lichcoquan
	 * @return the lichcoquan, or <code>null</code> if a lichcoquan with the primary key could not be found
	 */
	public Lichcoquan fetchByPrimaryKey(long lichCongtacId);

	/**
	 * Returns all the lichcoquans.
	 *
	 * @return the lichcoquans
	 */
	public java.util.List<Lichcoquan> findAll();

	/**
	 * Returns a range of all the lichcoquans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichcoquanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lichcoquans
	 * @param end the upper bound of the range of lichcoquans (not inclusive)
	 * @return the range of lichcoquans
	 */
	public java.util.List<Lichcoquan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lichcoquans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichcoquanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lichcoquans
	 * @param end the upper bound of the range of lichcoquans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lichcoquans
	 */
	public java.util.List<Lichcoquan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lichcoquan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lichcoquans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichcoquanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lichcoquans
	 * @param end the upper bound of the range of lichcoquans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lichcoquans
	 */
	public java.util.List<Lichcoquan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lichcoquan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lichcoquans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lichcoquans.
	 *
	 * @return the number of lichcoquans
	 */
	public int countAll();

}