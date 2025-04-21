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
 * Provides a wrapper for {@link eMagazine_LogsLocalService}.
 *
 * @author dnict
 * @see eMagazine_LogsLocalService
 * @generated
 */
public class eMagazine_LogsLocalServiceWrapper
	implements eMagazine_LogsLocalService,
			   ServiceWrapper<eMagazine_LogsLocalService> {

	public eMagazine_LogsLocalServiceWrapper(
		eMagazine_LogsLocalService eMagazine_LogsLocalService) {

		_eMagazine_LogsLocalService = eMagazine_LogsLocalService;
	}

	/**
	 * Adds the e magazine_ logs to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_LogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine_Logs the e magazine_ logs
	 * @return the e magazine_ logs that was added
	 */
	@Override
	public qlanphamdb.model.eMagazine_Logs addeMagazine_Logs(
		qlanphamdb.model.eMagazine_Logs eMagazine_Logs) {

		return _eMagazine_LogsLocalService.addeMagazine_Logs(eMagazine_Logs);
	}

	/**
	 * Creates a new e magazine_ logs with the primary key. Does not add the e magazine_ logs to the database.
	 *
	 * @param id the primary key for the new e magazine_ logs
	 * @return the new e magazine_ logs
	 */
	@Override
	public qlanphamdb.model.eMagazine_Logs createeMagazine_Logs(long id) {
		return _eMagazine_LogsLocalService.createeMagazine_Logs(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_LogsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the e magazine_ logs from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_LogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine_Logs the e magazine_ logs
	 * @return the e magazine_ logs that was removed
	 */
	@Override
	public qlanphamdb.model.eMagazine_Logs deleteeMagazine_Logs(
		qlanphamdb.model.eMagazine_Logs eMagazine_Logs) {

		return _eMagazine_LogsLocalService.deleteeMagazine_Logs(eMagazine_Logs);
	}

	/**
	 * Deletes the e magazine_ logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_LogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the e magazine_ logs
	 * @return the e magazine_ logs that was removed
	 * @throws PortalException if a e magazine_ logs with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.eMagazine_Logs deleteeMagazine_Logs(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_LogsLocalService.deleteeMagazine_Logs(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_LogsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eMagazine_LogsLocalService.dynamicQuery();
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

		return _eMagazine_LogsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazine_LogsModelImpl</code>.
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

		return _eMagazine_LogsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazine_LogsModelImpl</code>.
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

		return _eMagazine_LogsLocalService.dynamicQuery(
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

		return _eMagazine_LogsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _eMagazine_LogsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public qlanphamdb.model.eMagazine_Logs fetcheMagazine_Logs(long id) {
		return _eMagazine_LogsLocalService.fetcheMagazine_Logs(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eMagazine_LogsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the e magazine_ logs with the primary key.
	 *
	 * @param id the primary key of the e magazine_ logs
	 * @return the e magazine_ logs
	 * @throws PortalException if a e magazine_ logs with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.eMagazine_Logs geteMagazine_Logs(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_LogsLocalService.geteMagazine_Logs(id);
	}

	/**
	 * Returns a range of all the e magazine_ logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazine_LogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_ logses
	 * @param end the upper bound of the range of e magazine_ logses (not inclusive)
	 * @return the range of e magazine_ logses
	 */
	@Override
	public java.util.List<qlanphamdb.model.eMagazine_Logs> geteMagazine_Logses(
		int start, int end) {

		return _eMagazine_LogsLocalService.geteMagazine_Logses(start, end);
	}

	/**
	 * Returns the number of e magazine_ logses.
	 *
	 * @return the number of e magazine_ logses
	 */
	@Override
	public int geteMagazine_LogsesCount() {
		return _eMagazine_LogsLocalService.geteMagazine_LogsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eMagazine_LogsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eMagazine_LogsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_LogsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the e magazine_ logs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_LogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine_Logs the e magazine_ logs
	 * @return the e magazine_ logs that was updated
	 */
	@Override
	public qlanphamdb.model.eMagazine_Logs updateeMagazine_Logs(
		qlanphamdb.model.eMagazine_Logs eMagazine_Logs) {

		return _eMagazine_LogsLocalService.updateeMagazine_Logs(eMagazine_Logs);
	}

	@Override
	public eMagazine_LogsLocalService getWrappedService() {
		return _eMagazine_LogsLocalService;
	}

	@Override
	public void setWrappedService(
		eMagazine_LogsLocalService eMagazine_LogsLocalService) {

		_eMagazine_LogsLocalService = eMagazine_LogsLocalService;
	}

	private eMagazine_LogsLocalService _eMagazine_LogsLocalService;

}