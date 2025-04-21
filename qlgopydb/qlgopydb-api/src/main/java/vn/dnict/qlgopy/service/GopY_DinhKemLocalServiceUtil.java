/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import vn.dnict.qlgopy.model.GopY_DinhKem;

/**
 * Provides the local service utility for GopY_DinhKem. This utility wraps
 * <code>vn.dnict.qlgopy.service.impl.GopY_DinhKemLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author dnict
 * @see GopY_DinhKemLocalService
 * @generated
 */
public class GopY_DinhKemLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>vn.dnict.qlgopy.service.impl.GopY_DinhKemLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the gop y_ dinh kem to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GopY_DinhKemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gopY_DinhKem the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was added
	 */
	public static GopY_DinhKem addGopY_DinhKem(GopY_DinhKem gopY_DinhKem) {
		return getService().addGopY_DinhKem(gopY_DinhKem);
	}

	/**
	 * Creates a new gop y_ dinh kem with the primary key. Does not add the gop y_ dinh kem to the database.
	 *
	 * @param id the primary key for the new gop y_ dinh kem
	 * @return the new gop y_ dinh kem
	 */
	public static GopY_DinhKem createGopY_DinhKem(long id) {
		return getService().createGopY_DinhKem(id);
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
	 * Deletes the gop y_ dinh kem from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GopY_DinhKemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gopY_DinhKem the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was removed
	 */
	public static GopY_DinhKem deleteGopY_DinhKem(GopY_DinhKem gopY_DinhKem) {
		return getService().deleteGopY_DinhKem(gopY_DinhKem);
	}

	/**
	 * Deletes the gop y_ dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GopY_DinhKemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was removed
	 * @throws PortalException if a gop y_ dinh kem with the primary key could not be found
	 */
	public static GopY_DinhKem deleteGopY_DinhKem(long id)
		throws PortalException {

		return getService().deleteGopY_DinhKem(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.GopY_DinhKemModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.GopY_DinhKemModelImpl</code>.
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

	public static GopY_DinhKem fetchGopY_DinhKem(long id) {
		return getService().fetchGopY_DinhKem(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the gop y_ dinh kem with the primary key.
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem
	 * @throws PortalException if a gop y_ dinh kem with the primary key could not be found
	 */
	public static GopY_DinhKem getGopY_DinhKem(long id) throws PortalException {
		return getService().getGopY_DinhKem(id);
	}

	/**
	 * Returns a range of all the gop y_ dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.GopY_DinhKemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gop y_ dinh kems
	 * @param end the upper bound of the range of gop y_ dinh kems (not inclusive)
	 * @return the range of gop y_ dinh kems
	 */
	public static List<GopY_DinhKem> getGopY_DinhKems(int start, int end) {
		return getService().getGopY_DinhKems(start, end);
	}

	/**
	 * Returns the number of gop y_ dinh kems.
	 *
	 * @return the number of gop y_ dinh kems
	 */
	public static int getGopY_DinhKemsCount() {
		return getService().getGopY_DinhKemsCount();
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
	 * Updates the gop y_ dinh kem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GopY_DinhKemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gopY_DinhKem the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was updated
	 */
	public static GopY_DinhKem updateGopY_DinhKem(GopY_DinhKem gopY_DinhKem) {
		return getService().updateGopY_DinhKem(gopY_DinhKem);
	}

	public static GopY_DinhKemLocalService getService() {
		return _service;
	}

	public static void setService(GopY_DinhKemLocalService service) {
		_service = service;
	}

	private static volatile GopY_DinhKemLocalService _service;

}