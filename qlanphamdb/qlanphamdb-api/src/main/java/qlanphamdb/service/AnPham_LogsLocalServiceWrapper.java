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
 * Provides a wrapper for {@link AnPham_LogsLocalService}.
 *
 * @author dnict
 * @see AnPham_LogsLocalService
 * @generated
 */
public class AnPham_LogsLocalServiceWrapper
	implements AnPham_LogsLocalService,
			   ServiceWrapper<AnPham_LogsLocalService> {

	public AnPham_LogsLocalServiceWrapper(
		AnPham_LogsLocalService anPham_LogsLocalService) {

		_anPham_LogsLocalService = anPham_LogsLocalService;
	}

	/**
	 * Adds the an pham_ logs to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_LogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_Logs the an pham_ logs
	 * @return the an pham_ logs that was added
	 */
	@Override
	public qlanphamdb.model.AnPham_Logs addAnPham_Logs(
		qlanphamdb.model.AnPham_Logs anPham_Logs) {

		return _anPham_LogsLocalService.addAnPham_Logs(anPham_Logs);
	}

	/**
	 * Creates a new an pham_ logs with the primary key. Does not add the an pham_ logs to the database.
	 *
	 * @param id the primary key for the new an pham_ logs
	 * @return the new an pham_ logs
	 */
	@Override
	public qlanphamdb.model.AnPham_Logs createAnPham_Logs(long id) {
		return _anPham_LogsLocalService.createAnPham_Logs(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_LogsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the an pham_ logs from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_LogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_Logs the an pham_ logs
	 * @return the an pham_ logs that was removed
	 */
	@Override
	public qlanphamdb.model.AnPham_Logs deleteAnPham_Logs(
		qlanphamdb.model.AnPham_Logs anPham_Logs) {

		return _anPham_LogsLocalService.deleteAnPham_Logs(anPham_Logs);
	}

	/**
	 * Deletes the an pham_ logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_LogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the an pham_ logs
	 * @return the an pham_ logs that was removed
	 * @throws PortalException if a an pham_ logs with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.AnPham_Logs deleteAnPham_Logs(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_LogsLocalService.deleteAnPham_Logs(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_LogsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _anPham_LogsLocalService.dynamicQuery();
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

		return _anPham_LogsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_LogsModelImpl</code>.
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

		return _anPham_LogsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_LogsModelImpl</code>.
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

		return _anPham_LogsLocalService.dynamicQuery(
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

		return _anPham_LogsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _anPham_LogsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public qlanphamdb.model.AnPham_Logs fetchAnPham_Logs(long id) {
		return _anPham_LogsLocalService.fetchAnPham_Logs(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _anPham_LogsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the an pham_ logs with the primary key.
	 *
	 * @param id the primary key of the an pham_ logs
	 * @return the an pham_ logs
	 * @throws PortalException if a an pham_ logs with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.AnPham_Logs getAnPham_Logs(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_LogsLocalService.getAnPham_Logs(id);
	}

	/**
	 * Returns a range of all the an pham_ logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_LogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ logses
	 * @param end the upper bound of the range of an pham_ logses (not inclusive)
	 * @return the range of an pham_ logses
	 */
	@Override
	public java.util.List<qlanphamdb.model.AnPham_Logs> getAnPham_Logses(
		int start, int end) {

		return _anPham_LogsLocalService.getAnPham_Logses(start, end);
	}

	/**
	 * Returns the number of an pham_ logses.
	 *
	 * @return the number of an pham_ logses
	 */
	@Override
	public int getAnPham_LogsesCount() {
		return _anPham_LogsLocalService.getAnPham_LogsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _anPham_LogsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _anPham_LogsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_LogsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the an pham_ logs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_LogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_Logs the an pham_ logs
	 * @return the an pham_ logs that was updated
	 */
	@Override
	public qlanphamdb.model.AnPham_Logs updateAnPham_Logs(
		qlanphamdb.model.AnPham_Logs anPham_Logs) {

		return _anPham_LogsLocalService.updateAnPham_Logs(anPham_Logs);
	}

	@Override
	public AnPham_LogsLocalService getWrappedService() {
		return _anPham_LogsLocalService;
	}

	@Override
	public void setWrappedService(
		AnPham_LogsLocalService anPham_LogsLocalService) {

		_anPham_LogsLocalService = anPham_LogsLocalService;
	}

	private AnPham_LogsLocalService _anPham_LogsLocalService;

}