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

package qlanphamdb.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import qlanphamdb.model.AnPham_CongTacVien;

/**
 * Provides the local service utility for AnPham_CongTacVien. This utility wraps
 * <code>qlanphamdb.service.impl.AnPham_CongTacVienLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author dnict
 * @see AnPham_CongTacVienLocalService
 * @generated
 */
public class AnPham_CongTacVienLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>qlanphamdb.service.impl.AnPham_CongTacVienLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the an pham_ cong tac vien to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_CongTacVienLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_CongTacVien the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien that was added
	 */
	public static AnPham_CongTacVien addAnPham_CongTacVien(
		AnPham_CongTacVien anPham_CongTacVien) {

		return getService().addAnPham_CongTacVien(anPham_CongTacVien);
	}

	/**
	 * Creates a new an pham_ cong tac vien with the primary key. Does not add the an pham_ cong tac vien to the database.
	 *
	 * @param id the primary key for the new an pham_ cong tac vien
	 * @return the new an pham_ cong tac vien
	 */
	public static AnPham_CongTacVien createAnPham_CongTacVien(long id) {
		return getService().createAnPham_CongTacVien(id);
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
	 * Deletes the an pham_ cong tac vien from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_CongTacVienLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_CongTacVien the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien that was removed
	 */
	public static AnPham_CongTacVien deleteAnPham_CongTacVien(
		AnPham_CongTacVien anPham_CongTacVien) {

		return getService().deleteAnPham_CongTacVien(anPham_CongTacVien);
	}

	/**
	 * Deletes the an pham_ cong tac vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_CongTacVienLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien that was removed
	 * @throws PortalException if a an pham_ cong tac vien with the primary key could not be found
	 */
	public static AnPham_CongTacVien deleteAnPham_CongTacVien(long id)
		throws PortalException {

		return getService().deleteAnPham_CongTacVien(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_CongTacVienModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_CongTacVienModelImpl</code>.
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

	public static AnPham_CongTacVien fetchAnPham_CongTacVien(long id) {
		return getService().fetchAnPham_CongTacVien(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the an pham_ cong tac vien with the primary key.
	 *
	 * @param id the primary key of the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien
	 * @throws PortalException if a an pham_ cong tac vien with the primary key could not be found
	 */
	public static AnPham_CongTacVien getAnPham_CongTacVien(long id)
		throws PortalException {

		return getService().getAnPham_CongTacVien(id);
	}

	/**
	 * Returns a range of all the an pham_ cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_CongTacVienModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ cong tac viens
	 * @param end the upper bound of the range of an pham_ cong tac viens (not inclusive)
	 * @return the range of an pham_ cong tac viens
	 */
	public static List<AnPham_CongTacVien> getAnPham_CongTacViens(
		int start, int end) {

		return getService().getAnPham_CongTacViens(start, end);
	}

	/**
	 * Returns the number of an pham_ cong tac viens.
	 *
	 * @return the number of an pham_ cong tac viens
	 */
	public static int getAnPham_CongTacViensCount() {
		return getService().getAnPham_CongTacViensCount();
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
	 * Updates the an pham_ cong tac vien in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_CongTacVienLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_CongTacVien the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien that was updated
	 */
	public static AnPham_CongTacVien updateAnPham_CongTacVien(
		AnPham_CongTacVien anPham_CongTacVien) {

		return getService().updateAnPham_CongTacVien(anPham_CongTacVien);
	}

	public static AnPham_CongTacVienLocalService getService() {
		return _service;
	}

	private static volatile AnPham_CongTacVienLocalService _service;

}