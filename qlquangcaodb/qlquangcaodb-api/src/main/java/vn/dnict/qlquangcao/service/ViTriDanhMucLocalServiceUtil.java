/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import vn.dnict.qlquangcao.model.ViTriDanhMuc;

/**
 * Provides the local service utility for ViTriDanhMuc. This utility wraps
 * <code>vn.dnict.qlquangcao.service.impl.ViTriDanhMucLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author dnict
 * @see ViTriDanhMucLocalService
 * @generated
 */
public class ViTriDanhMucLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>vn.dnict.qlquangcao.service.impl.ViTriDanhMucLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the vi tri danh muc to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViTriDanhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param viTriDanhMuc the vi tri danh muc
	 * @return the vi tri danh muc that was added
	 */
	public static ViTriDanhMuc addViTriDanhMuc(ViTriDanhMuc viTriDanhMuc) {
		return getService().addViTriDanhMuc(viTriDanhMuc);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new vi tri danh muc with the primary key. Does not add the vi tri danh muc to the database.
	 *
	 * @param id the primary key for the new vi tri danh muc
	 * @return the new vi tri danh muc
	 */
	public static ViTriDanhMuc createViTriDanhMuc(long id) {
		return getService().createViTriDanhMuc(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vi tri danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViTriDanhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc that was removed
	 * @throws PortalException if a vi tri danh muc with the primary key could not be found
	 */
	public static ViTriDanhMuc deleteViTriDanhMuc(long id)
		throws PortalException {

		return getService().deleteViTriDanhMuc(id);
	}

	/**
	 * Deletes the vi tri danh muc from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViTriDanhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param viTriDanhMuc the vi tri danh muc
	 * @return the vi tri danh muc that was removed
	 */
	public static ViTriDanhMuc deleteViTriDanhMuc(ViTriDanhMuc viTriDanhMuc) {
		return getService().deleteViTriDanhMuc(viTriDanhMuc);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.ViTriDanhMucModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.ViTriDanhMucModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ViTriDanhMuc fetchViTriDanhMuc(long id) {
		return getService().fetchViTriDanhMuc(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vi tri danh muc with the primary key.
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc
	 * @throws PortalException if a vi tri danh muc with the primary key could not be found
	 */
	public static ViTriDanhMuc getViTriDanhMuc(long id) throws PortalException {
		return getService().getViTriDanhMuc(id);
	}

	/**
	 * Returns a range of all the vi tri danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.ViTriDanhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vi tri danh mucs
	 * @param end the upper bound of the range of vi tri danh mucs (not inclusive)
	 * @return the range of vi tri danh mucs
	 */
	public static List<ViTriDanhMuc> getViTriDanhMucs(int start, int end) {
		return getService().getViTriDanhMucs(start, end);
	}

	/**
	 * Returns the number of vi tri danh mucs.
	 *
	 * @return the number of vi tri danh mucs
	 */
	public static int getViTriDanhMucsCount() {
		return getService().getViTriDanhMucsCount();
	}

	/**
	 * Updates the vi tri danh muc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViTriDanhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param viTriDanhMuc the vi tri danh muc
	 * @return the vi tri danh muc that was updated
	 */
	public static ViTriDanhMuc updateViTriDanhMuc(ViTriDanhMuc viTriDanhMuc) {
		return getService().updateViTriDanhMuc(viTriDanhMuc);
	}

	public static ViTriDanhMucLocalService getService() {
		return _service;
	}

	public static void setService(ViTriDanhMucLocalService service) {
		_service = service;
	}

	private static volatile ViTriDanhMucLocalService _service;

}