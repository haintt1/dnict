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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnPham_CongTacVienLocalService}.
 *
 * @author dnict
 * @see AnPham_CongTacVienLocalService
 * @generated
 */
public class AnPham_CongTacVienLocalServiceWrapper
	implements AnPham_CongTacVienLocalService,
			   ServiceWrapper<AnPham_CongTacVienLocalService> {

	public AnPham_CongTacVienLocalServiceWrapper(
		AnPham_CongTacVienLocalService anPham_CongTacVienLocalService) {

		_anPham_CongTacVienLocalService = anPham_CongTacVienLocalService;
	}

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
	@Override
	public qlanphamdb.model.AnPham_CongTacVien addAnPham_CongTacVien(
		qlanphamdb.model.AnPham_CongTacVien anPham_CongTacVien) {

		return _anPham_CongTacVienLocalService.addAnPham_CongTacVien(
			anPham_CongTacVien);
	}

	/**
	 * Creates a new an pham_ cong tac vien with the primary key. Does not add the an pham_ cong tac vien to the database.
	 *
	 * @param id the primary key for the new an pham_ cong tac vien
	 * @return the new an pham_ cong tac vien
	 */
	@Override
	public qlanphamdb.model.AnPham_CongTacVien createAnPham_CongTacVien(
		long id) {

		return _anPham_CongTacVienLocalService.createAnPham_CongTacVien(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_CongTacVienLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public qlanphamdb.model.AnPham_CongTacVien deleteAnPham_CongTacVien(
		qlanphamdb.model.AnPham_CongTacVien anPham_CongTacVien) {

		return _anPham_CongTacVienLocalService.deleteAnPham_CongTacVien(
			anPham_CongTacVien);
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
	@Override
	public qlanphamdb.model.AnPham_CongTacVien deleteAnPham_CongTacVien(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_CongTacVienLocalService.deleteAnPham_CongTacVien(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_CongTacVienLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _anPham_CongTacVienLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _anPham_CongTacVienLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _anPham_CongTacVienLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _anPham_CongTacVienLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _anPham_CongTacVienLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _anPham_CongTacVienLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public qlanphamdb.model.AnPham_CongTacVien fetchAnPham_CongTacVien(
		long id) {

		return _anPham_CongTacVienLocalService.fetchAnPham_CongTacVien(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _anPham_CongTacVienLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the an pham_ cong tac vien with the primary key.
	 *
	 * @param id the primary key of the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien
	 * @throws PortalException if a an pham_ cong tac vien with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.AnPham_CongTacVien getAnPham_CongTacVien(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_CongTacVienLocalService.getAnPham_CongTacVien(id);
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
	@Override
	public java.util.List<qlanphamdb.model.AnPham_CongTacVien>
		getAnPham_CongTacViens(int start, int end) {

		return _anPham_CongTacVienLocalService.getAnPham_CongTacViens(
			start, end);
	}

	/**
	 * Returns the number of an pham_ cong tac viens.
	 *
	 * @return the number of an pham_ cong tac viens
	 */
	@Override
	public int getAnPham_CongTacViensCount() {
		return _anPham_CongTacVienLocalService.getAnPham_CongTacViensCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _anPham_CongTacVienLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _anPham_CongTacVienLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_CongTacVienLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public qlanphamdb.model.AnPham_CongTacVien updateAnPham_CongTacVien(
		qlanphamdb.model.AnPham_CongTacVien anPham_CongTacVien) {

		return _anPham_CongTacVienLocalService.updateAnPham_CongTacVien(
			anPham_CongTacVien);
	}

	@Override
	public AnPham_CongTacVienLocalService getWrappedService() {
		return _anPham_CongTacVienLocalService;
	}

	@Override
	public void setWrappedService(
		AnPham_CongTacVienLocalService anPham_CongTacVienLocalService) {

		_anPham_CongTacVienLocalService = anPham_CongTacVienLocalService;
	}

	private AnPham_CongTacVienLocalService _anPham_CongTacVienLocalService;

}