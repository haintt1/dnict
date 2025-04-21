/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence;

import cms.quanlyvideo.model.ChuDe;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the chu de service. This utility wraps <code>cms.quanlyvideo.service.persistence.impl.ChuDePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChuDePersistence
 * @generated
 */
public class ChuDeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ChuDe chuDe) {
		getPersistence().clearCache(chuDe);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ChuDe> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChuDe> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChuDe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChuDe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ChuDe> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ChuDe update(ChuDe chuDe) {
		return getPersistence().update(chuDe);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ChuDe update(ChuDe chuDe, ServiceContext serviceContext) {
		return getPersistence().update(chuDe, serviceContext);
	}

	/**
	 * Returns all the chu des where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching chu des
	 */
	public static List<ChuDe> findByten(String ten) {
		return getPersistence().findByten(ten);
	}

	/**
	 * Returns a range of all the chu des where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @return the range of matching chu des
	 */
	public static List<ChuDe> findByten(String ten, int start, int end) {
		return getPersistence().findByten(ten, start, end);
	}

	/**
	 * Returns an ordered range of all the chu des where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chu des
	 */
	public static List<ChuDe> findByten(
		String ten, int start, int end,
		OrderByComparator<ChuDe> orderByComparator) {

		return getPersistence().findByten(ten, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chu des where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chu des
	 */
	public static List<ChuDe> findByten(
		String ten, int start, int end,
		OrderByComparator<ChuDe> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByten(
			ten, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de
	 * @throws NoSuchChuDeException if a matching chu de could not be found
	 */
	public static ChuDe findByten_First(
			String ten, OrderByComparator<ChuDe> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchChuDeException {

		return getPersistence().findByten_First(ten, orderByComparator);
	}

	/**
	 * Returns the first chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de, or <code>null</code> if a matching chu de could not be found
	 */
	public static ChuDe fetchByten_First(
		String ten, OrderByComparator<ChuDe> orderByComparator) {

		return getPersistence().fetchByten_First(ten, orderByComparator);
	}

	/**
	 * Returns the last chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de
	 * @throws NoSuchChuDeException if a matching chu de could not be found
	 */
	public static ChuDe findByten_Last(
			String ten, OrderByComparator<ChuDe> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchChuDeException {

		return getPersistence().findByten_Last(ten, orderByComparator);
	}

	/**
	 * Returns the last chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de, or <code>null</code> if a matching chu de could not be found
	 */
	public static ChuDe fetchByten_Last(
		String ten, OrderByComparator<ChuDe> orderByComparator) {

		return getPersistence().fetchByten_Last(ten, orderByComparator);
	}

	/**
	 * Returns the chu des before and after the current chu de in the ordered set where ten = &#63;.
	 *
	 * @param id the primary key of the current chu de
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chu de
	 * @throws NoSuchChuDeException if a chu de with the primary key could not be found
	 */
	public static ChuDe[] findByten_PrevAndNext(
			long id, String ten, OrderByComparator<ChuDe> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchChuDeException {

		return getPersistence().findByten_PrevAndNext(
			id, ten, orderByComparator);
	}

	/**
	 * Removes all the chu des where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	public static void removeByten(String ten) {
		getPersistence().removeByten(ten);
	}

	/**
	 * Returns the number of chu des where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching chu des
	 */
	public static int countByten(String ten) {
		return getPersistence().countByten(ten);
	}

	/**
	 * Caches the chu de in the entity cache if it is enabled.
	 *
	 * @param chuDe the chu de
	 */
	public static void cacheResult(ChuDe chuDe) {
		getPersistence().cacheResult(chuDe);
	}

	/**
	 * Caches the chu des in the entity cache if it is enabled.
	 *
	 * @param chuDes the chu des
	 */
	public static void cacheResult(List<ChuDe> chuDes) {
		getPersistence().cacheResult(chuDes);
	}

	/**
	 * Creates a new chu de with the primary key. Does not add the chu de to the database.
	 *
	 * @param id the primary key for the new chu de
	 * @return the new chu de
	 */
	public static ChuDe create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the chu de with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chu de
	 * @return the chu de that was removed
	 * @throws NoSuchChuDeException if a chu de with the primary key could not be found
	 */
	public static ChuDe remove(long id)
		throws cms.quanlyvideo.exception.NoSuchChuDeException {

		return getPersistence().remove(id);
	}

	public static ChuDe updateImpl(ChuDe chuDe) {
		return getPersistence().updateImpl(chuDe);
	}

	/**
	 * Returns the chu de with the primary key or throws a <code>NoSuchChuDeException</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de
	 * @return the chu de
	 * @throws NoSuchChuDeException if a chu de with the primary key could not be found
	 */
	public static ChuDe findByPrimaryKey(long id)
		throws cms.quanlyvideo.exception.NoSuchChuDeException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the chu de with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de
	 * @return the chu de, or <code>null</code> if a chu de with the primary key could not be found
	 */
	public static ChuDe fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the chu des.
	 *
	 * @return the chu des
	 */
	public static List<ChuDe> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the chu des.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @return the range of chu des
	 */
	public static List<ChuDe> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the chu des.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chu des
	 */
	public static List<ChuDe> findAll(
		int start, int end, OrderByComparator<ChuDe> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chu des.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chu des
	 */
	public static List<ChuDe> findAll(
		int start, int end, OrderByComparator<ChuDe> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the chu des from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of chu des.
	 *
	 * @return the number of chu des
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChuDePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ChuDePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ChuDePersistence _persistence;

}