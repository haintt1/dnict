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
 * Provides a wrapper for {@link AnPham_DinhKemFileLocalService}.
 *
 * @author dnict
 * @see AnPham_DinhKemFileLocalService
 * @generated
 */
public class AnPham_DinhKemFileLocalServiceWrapper
	implements AnPham_DinhKemFileLocalService,
			   ServiceWrapper<AnPham_DinhKemFileLocalService> {

	public AnPham_DinhKemFileLocalServiceWrapper(
		AnPham_DinhKemFileLocalService anPham_DinhKemFileLocalService) {

		_anPham_DinhKemFileLocalService = anPham_DinhKemFileLocalService;
	}

	/**
	 * Adds the an pham_ dinh kem file to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_DinhKemFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_DinhKemFile the an pham_ dinh kem file
	 * @return the an pham_ dinh kem file that was added
	 */
	@Override
	public qlanphamdb.model.AnPham_DinhKemFile addAnPham_DinhKemFile(
		qlanphamdb.model.AnPham_DinhKemFile anPham_DinhKemFile) {

		return _anPham_DinhKemFileLocalService.addAnPham_DinhKemFile(
			anPham_DinhKemFile);
	}

	/**
	 * Creates a new an pham_ dinh kem file with the primary key. Does not add the an pham_ dinh kem file to the database.
	 *
	 * @param id the primary key for the new an pham_ dinh kem file
	 * @return the new an pham_ dinh kem file
	 */
	@Override
	public qlanphamdb.model.AnPham_DinhKemFile createAnPham_DinhKemFile(
		long id) {

		return _anPham_DinhKemFileLocalService.createAnPham_DinhKemFile(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_DinhKemFileLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the an pham_ dinh kem file from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_DinhKemFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_DinhKemFile the an pham_ dinh kem file
	 * @return the an pham_ dinh kem file that was removed
	 */
	@Override
	public qlanphamdb.model.AnPham_DinhKemFile deleteAnPham_DinhKemFile(
		qlanphamdb.model.AnPham_DinhKemFile anPham_DinhKemFile) {

		return _anPham_DinhKemFileLocalService.deleteAnPham_DinhKemFile(
			anPham_DinhKemFile);
	}

	/**
	 * Deletes the an pham_ dinh kem file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_DinhKemFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the an pham_ dinh kem file
	 * @return the an pham_ dinh kem file that was removed
	 * @throws PortalException if a an pham_ dinh kem file with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.AnPham_DinhKemFile deleteAnPham_DinhKemFile(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_DinhKemFileLocalService.deleteAnPham_DinhKemFile(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_DinhKemFileLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _anPham_DinhKemFileLocalService.dynamicQuery();
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

		return _anPham_DinhKemFileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_DinhKemFileModelImpl</code>.
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

		return _anPham_DinhKemFileLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_DinhKemFileModelImpl</code>.
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

		return _anPham_DinhKemFileLocalService.dynamicQuery(
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

		return _anPham_DinhKemFileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _anPham_DinhKemFileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public qlanphamdb.model.AnPham_DinhKemFile fetchAnPham_DinhKemFile(
		long id) {

		return _anPham_DinhKemFileLocalService.fetchAnPham_DinhKemFile(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _anPham_DinhKemFileLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the an pham_ dinh kem file with the primary key.
	 *
	 * @param id the primary key of the an pham_ dinh kem file
	 * @return the an pham_ dinh kem file
	 * @throws PortalException if a an pham_ dinh kem file with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.AnPham_DinhKemFile getAnPham_DinhKemFile(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_DinhKemFileLocalService.getAnPham_DinhKemFile(id);
	}

	/**
	 * Returns a range of all the an pham_ dinh kem files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_DinhKemFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ dinh kem files
	 * @param end the upper bound of the range of an pham_ dinh kem files (not inclusive)
	 * @return the range of an pham_ dinh kem files
	 */
	@Override
	public java.util.List<qlanphamdb.model.AnPham_DinhKemFile>
		getAnPham_DinhKemFiles(int start, int end) {

		return _anPham_DinhKemFileLocalService.getAnPham_DinhKemFiles(
			start, end);
	}

	/**
	 * Returns the number of an pham_ dinh kem files.
	 *
	 * @return the number of an pham_ dinh kem files
	 */
	@Override
	public int getAnPham_DinhKemFilesCount() {
		return _anPham_DinhKemFileLocalService.getAnPham_DinhKemFilesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _anPham_DinhKemFileLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _anPham_DinhKemFileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_DinhKemFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the an pham_ dinh kem file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_DinhKemFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_DinhKemFile the an pham_ dinh kem file
	 * @return the an pham_ dinh kem file that was updated
	 */
	@Override
	public qlanphamdb.model.AnPham_DinhKemFile updateAnPham_DinhKemFile(
		qlanphamdb.model.AnPham_DinhKemFile anPham_DinhKemFile) {

		return _anPham_DinhKemFileLocalService.updateAnPham_DinhKemFile(
			anPham_DinhKemFile);
	}

	@Override
	public AnPham_DinhKemFileLocalService getWrappedService() {
		return _anPham_DinhKemFileLocalService;
	}

	@Override
	public void setWrappedService(
		AnPham_DinhKemFileLocalService anPham_DinhKemFileLocalService) {

		_anPham_DinhKemFileLocalService = anPham_DinhKemFileLocalService;
	}

	private AnPham_DinhKemFileLocalService _anPham_DinhKemFileLocalService;

}