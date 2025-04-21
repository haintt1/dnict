/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence;

import cms.quanlyvideo.exception.NoSuchChuDeException;
import cms.quanlyvideo.model.ChuDe;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the chu de service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChuDeUtil
 * @generated
 */
@ProviderType
public interface ChuDePersistence extends BasePersistence<ChuDe> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChuDeUtil} to access the chu de persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the chu des where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching chu des
	 */
	public java.util.List<ChuDe> findByten(String ten);

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
	public java.util.List<ChuDe> findByten(String ten, int start, int end);

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
	public java.util.List<ChuDe> findByten(
		String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDe>
			orderByComparator);

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
	public java.util.List<ChuDe> findByten(
		String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDe>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de
	 * @throws NoSuchChuDeException if a matching chu de could not be found
	 */
	public ChuDe findByten_First(
			String ten,
			com.liferay.portal.kernel.util.OrderByComparator<ChuDe>
				orderByComparator)
		throws NoSuchChuDeException;

	/**
	 * Returns the first chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de, or <code>null</code> if a matching chu de could not be found
	 */
	public ChuDe fetchByten_First(
		String ten,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDe>
			orderByComparator);

	/**
	 * Returns the last chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de
	 * @throws NoSuchChuDeException if a matching chu de could not be found
	 */
	public ChuDe findByten_Last(
			String ten,
			com.liferay.portal.kernel.util.OrderByComparator<ChuDe>
				orderByComparator)
		throws NoSuchChuDeException;

	/**
	 * Returns the last chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de, or <code>null</code> if a matching chu de could not be found
	 */
	public ChuDe fetchByten_Last(
		String ten,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDe>
			orderByComparator);

	/**
	 * Returns the chu des before and after the current chu de in the ordered set where ten = &#63;.
	 *
	 * @param id the primary key of the current chu de
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chu de
	 * @throws NoSuchChuDeException if a chu de with the primary key could not be found
	 */
	public ChuDe[] findByten_PrevAndNext(
			long id, String ten,
			com.liferay.portal.kernel.util.OrderByComparator<ChuDe>
				orderByComparator)
		throws NoSuchChuDeException;

	/**
	 * Removes all the chu des where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	public void removeByten(String ten);

	/**
	 * Returns the number of chu des where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching chu des
	 */
	public int countByten(String ten);

	/**
	 * Caches the chu de in the entity cache if it is enabled.
	 *
	 * @param chuDe the chu de
	 */
	public void cacheResult(ChuDe chuDe);

	/**
	 * Caches the chu des in the entity cache if it is enabled.
	 *
	 * @param chuDes the chu des
	 */
	public void cacheResult(java.util.List<ChuDe> chuDes);

	/**
	 * Creates a new chu de with the primary key. Does not add the chu de to the database.
	 *
	 * @param id the primary key for the new chu de
	 * @return the new chu de
	 */
	public ChuDe create(long id);

	/**
	 * Removes the chu de with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chu de
	 * @return the chu de that was removed
	 * @throws NoSuchChuDeException if a chu de with the primary key could not be found
	 */
	public ChuDe remove(long id) throws NoSuchChuDeException;

	public ChuDe updateImpl(ChuDe chuDe);

	/**
	 * Returns the chu de with the primary key or throws a <code>NoSuchChuDeException</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de
	 * @return the chu de
	 * @throws NoSuchChuDeException if a chu de with the primary key could not be found
	 */
	public ChuDe findByPrimaryKey(long id) throws NoSuchChuDeException;

	/**
	 * Returns the chu de with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de
	 * @return the chu de, or <code>null</code> if a chu de with the primary key could not be found
	 */
	public ChuDe fetchByPrimaryKey(long id);

	/**
	 * Returns all the chu des.
	 *
	 * @return the chu des
	 */
	public java.util.List<ChuDe> findAll();

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
	public java.util.List<ChuDe> findAll(int start, int end);

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
	public java.util.List<ChuDe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDe>
			orderByComparator);

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
	public java.util.List<ChuDe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDe>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the chu des from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of chu des.
	 *
	 * @return the number of chu des
	 */
	public int countAll();

}