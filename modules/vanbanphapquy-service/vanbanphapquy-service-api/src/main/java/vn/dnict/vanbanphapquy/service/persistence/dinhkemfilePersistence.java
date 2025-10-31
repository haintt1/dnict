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

package vn.dnict.vanbanphapquy.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.vanbanphapquy.exception.NoSuchdinhkemfileException;
import vn.dnict.vanbanphapquy.model.dinhkemfile;

/**
 * The persistence interface for the dinhkemfile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see dinhkemfileUtil
 * @generated
 */
@ProviderType
public interface dinhkemfilePersistence extends BasePersistence<dinhkemfile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link dinhkemfileUtil} to access the dinhkemfile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dinhkemfiles where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @return the matching dinhkemfiles
	 */
	public java.util.List<dinhkemfile> findByObjectId(long ObjectId);

	/**
	 * Returns a range of all the dinhkemfiles where ObjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param ObjectId the object ID
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @return the range of matching dinhkemfiles
	 */
	public java.util.List<dinhkemfile> findByObjectId(
		long ObjectId, int start, int end);

	/**
	 * Returns an ordered range of all the dinhkemfiles where ObjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param ObjectId the object ID
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dinhkemfiles
	 */
	public java.util.List<dinhkemfile> findByObjectId(
		long ObjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dinhkemfile>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dinhkemfiles where ObjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param ObjectId the object ID
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dinhkemfiles
	 */
	public java.util.List<dinhkemfile> findByObjectId(
		long ObjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dinhkemfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dinhkemfile in the ordered set where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dinhkemfile
	 * @throws NoSuchdinhkemfileException if a matching dinhkemfile could not be found
	 */
	public dinhkemfile findByObjectId_First(
			long ObjectId,
			com.liferay.portal.kernel.util.OrderByComparator<dinhkemfile>
				orderByComparator)
		throws NoSuchdinhkemfileException;

	/**
	 * Returns the first dinhkemfile in the ordered set where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dinhkemfile, or <code>null</code> if a matching dinhkemfile could not be found
	 */
	public dinhkemfile fetchByObjectId_First(
		long ObjectId,
		com.liferay.portal.kernel.util.OrderByComparator<dinhkemfile>
			orderByComparator);

	/**
	 * Returns the last dinhkemfile in the ordered set where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dinhkemfile
	 * @throws NoSuchdinhkemfileException if a matching dinhkemfile could not be found
	 */
	public dinhkemfile findByObjectId_Last(
			long ObjectId,
			com.liferay.portal.kernel.util.OrderByComparator<dinhkemfile>
				orderByComparator)
		throws NoSuchdinhkemfileException;

	/**
	 * Returns the last dinhkemfile in the ordered set where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dinhkemfile, or <code>null</code> if a matching dinhkemfile could not be found
	 */
	public dinhkemfile fetchByObjectId_Last(
		long ObjectId,
		com.liferay.portal.kernel.util.OrderByComparator<dinhkemfile>
			orderByComparator);

	/**
	 * Returns the dinhkemfiles before and after the current dinhkemfile in the ordered set where ObjectId = &#63;.
	 *
	 * @param id the primary key of the current dinhkemfile
	 * @param ObjectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dinhkemfile
	 * @throws NoSuchdinhkemfileException if a dinhkemfile with the primary key could not be found
	 */
	public dinhkemfile[] findByObjectId_PrevAndNext(
			long id, long ObjectId,
			com.liferay.portal.kernel.util.OrderByComparator<dinhkemfile>
				orderByComparator)
		throws NoSuchdinhkemfileException;

	/**
	 * Removes all the dinhkemfiles where ObjectId = &#63; from the database.
	 *
	 * @param ObjectId the object ID
	 */
	public void removeByObjectId(long ObjectId);

	/**
	 * Returns the number of dinhkemfiles where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @return the number of matching dinhkemfiles
	 */
	public int countByObjectId(long ObjectId);

	/**
	 * Caches the dinhkemfile in the entity cache if it is enabled.
	 *
	 * @param dinhkemfile the dinhkemfile
	 */
	public void cacheResult(dinhkemfile dinhkemfile);

	/**
	 * Caches the dinhkemfiles in the entity cache if it is enabled.
	 *
	 * @param dinhkemfiles the dinhkemfiles
	 */
	public void cacheResult(java.util.List<dinhkemfile> dinhkemfiles);

	/**
	 * Creates a new dinhkemfile with the primary key. Does not add the dinhkemfile to the database.
	 *
	 * @param id the primary key for the new dinhkemfile
	 * @return the new dinhkemfile
	 */
	public dinhkemfile create(long id);

	/**
	 * Removes the dinhkemfile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dinhkemfile
	 * @return the dinhkemfile that was removed
	 * @throws NoSuchdinhkemfileException if a dinhkemfile with the primary key could not be found
	 */
	public dinhkemfile remove(long id) throws NoSuchdinhkemfileException;

	public dinhkemfile updateImpl(dinhkemfile dinhkemfile);

	/**
	 * Returns the dinhkemfile with the primary key or throws a <code>NoSuchdinhkemfileException</code> if it could not be found.
	 *
	 * @param id the primary key of the dinhkemfile
	 * @return the dinhkemfile
	 * @throws NoSuchdinhkemfileException if a dinhkemfile with the primary key could not be found
	 */
	public dinhkemfile findByPrimaryKey(long id)
		throws NoSuchdinhkemfileException;

	/**
	 * Returns the dinhkemfile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dinhkemfile
	 * @return the dinhkemfile, or <code>null</code> if a dinhkemfile with the primary key could not be found
	 */
	public dinhkemfile fetchByPrimaryKey(long id);

	/**
	 * Returns all the dinhkemfiles.
	 *
	 * @return the dinhkemfiles
	 */
	public java.util.List<dinhkemfile> findAll();

	/**
	 * Returns a range of all the dinhkemfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @return the range of dinhkemfiles
	 */
	public java.util.List<dinhkemfile> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dinhkemfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dinhkemfiles
	 */
	public java.util.List<dinhkemfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dinhkemfile>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dinhkemfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dinhkemfiles
	 */
	public java.util.List<dinhkemfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dinhkemfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dinhkemfiles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dinhkemfiles.
	 *
	 * @return the number of dinhkemfiles
	 */
	public int countAll();

}