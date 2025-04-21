/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link DemoDBLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DemoDBLocalService
 * @generated
 */
public class DemoDBLocalServiceWrapper
	implements DemoDBLocalService, ServiceWrapper<DemoDBLocalService> {

	public DemoDBLocalServiceWrapper(DemoDBLocalService demoDBLocalService) {
		_demoDBLocalService = demoDBLocalService;
	}

	/**
	 * Adds the demo db to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DemoDBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param demoDB the demo db
	 * @return the demo db that was added
	 */
	@Override
	public com.demo.model.DemoDB addDemoDB(com.demo.model.DemoDB demoDB) {
		return _demoDBLocalService.addDemoDB(demoDB);
	}

	/**
	 * Creates a new demo db with the primary key. Does not add the demo db to the database.
	 *
	 * @param id the primary key for the new demo db
	 * @return the new demo db
	 */
	@Override
	public com.demo.model.DemoDB createDemoDB(long id) {
		return _demoDBLocalService.createDemoDB(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _demoDBLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the demo db from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DemoDBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param demoDB the demo db
	 * @return the demo db that was removed
	 */
	@Override
	public com.demo.model.DemoDB deleteDemoDB(com.demo.model.DemoDB demoDB) {
		return _demoDBLocalService.deleteDemoDB(demoDB);
	}

	/**
	 * Deletes the demo db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DemoDBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the demo db
	 * @return the demo db that was removed
	 * @throws PortalException if a demo db with the primary key could not be found
	 */
	@Override
	public com.demo.model.DemoDB deleteDemoDB(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _demoDBLocalService.deleteDemoDB(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _demoDBLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _demoDBLocalService.dynamicQuery();
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

		return _demoDBLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.demo.model.impl.DemoDBModelImpl</code>.
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

		return _demoDBLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.demo.model.impl.DemoDBModelImpl</code>.
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

		return _demoDBLocalService.dynamicQuery(
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

		return _demoDBLocalService.dynamicQueryCount(dynamicQuery);
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

		return _demoDBLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.demo.model.DemoDB fetchDemoDB(long id) {
		return _demoDBLocalService.fetchDemoDB(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _demoDBLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the demo db with the primary key.
	 *
	 * @param id the primary key of the demo db
	 * @return the demo db
	 * @throws PortalException if a demo db with the primary key could not be found
	 */
	@Override
	public com.demo.model.DemoDB getDemoDB(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _demoDBLocalService.getDemoDB(id);
	}

	/**
	 * Returns a range of all the demo dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.demo.model.impl.DemoDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of demo dbs
	 * @param end the upper bound of the range of demo dbs (not inclusive)
	 * @return the range of demo dbs
	 */
	@Override
	public java.util.List<com.demo.model.DemoDB> getDemoDBs(
		int start, int end) {

		return _demoDBLocalService.getDemoDBs(start, end);
	}

	/**
	 * Returns the number of demo dbs.
	 *
	 * @return the number of demo dbs
	 */
	@Override
	public int getDemoDBsCount() {
		return _demoDBLocalService.getDemoDBsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _demoDBLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _demoDBLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _demoDBLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the demo db in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DemoDBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param demoDB the demo db
	 * @return the demo db that was updated
	 */
	@Override
	public com.demo.model.DemoDB updateDemoDB(com.demo.model.DemoDB demoDB) {
		return _demoDBLocalService.updateDemoDB(demoDB);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _demoDBLocalService.getBasePersistence();
	}

	@Override
	public DemoDBLocalService getWrappedService() {
		return _demoDBLocalService;
	}

	@Override
	public void setWrappedService(DemoDBLocalService demoDBLocalService) {
		_demoDBLocalService = demoDBLocalService;
	}

	private DemoDBLocalService _demoDBLocalService;

}