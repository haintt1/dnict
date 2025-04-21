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
 * Provides a wrapper for {@link eMagazineLocalService}.
 *
 * @author dnict
 * @see eMagazineLocalService
 * @generated
 */
public class eMagazineLocalServiceWrapper
	implements eMagazineLocalService, ServiceWrapper<eMagazineLocalService> {

	public eMagazineLocalServiceWrapper(
		eMagazineLocalService eMagazineLocalService) {

		_eMagazineLocalService = eMagazineLocalService;
	}

	/**
	 * Adds the e magazine to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine the e magazine
	 * @return the e magazine that was added
	 */
	@Override
	public qlanphamdb.model.eMagazine addeMagazine(
		qlanphamdb.model.eMagazine eMagazine) {

		return _eMagazineLocalService.addeMagazine(eMagazine);
	}

	/**
	 * Creates a new e magazine with the primary key. Does not add the e magazine to the database.
	 *
	 * @param id the primary key for the new e magazine
	 * @return the new e magazine
	 */
	@Override
	public qlanphamdb.model.eMagazine createeMagazine(long id) {
		return _eMagazineLocalService.createeMagazine(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazineLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the e magazine from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine the e magazine
	 * @return the e magazine that was removed
	 */
	@Override
	public qlanphamdb.model.eMagazine deleteeMagazine(
		qlanphamdb.model.eMagazine eMagazine) {

		return _eMagazineLocalService.deleteeMagazine(eMagazine);
	}

	/**
	 * Deletes the e magazine with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the e magazine
	 * @return the e magazine that was removed
	 * @throws PortalException if a e magazine with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.eMagazine deleteeMagazine(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazineLocalService.deleteeMagazine(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazineLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eMagazineLocalService.dynamicQuery();
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

		return _eMagazineLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazineModelImpl</code>.
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

		return _eMagazineLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazineModelImpl</code>.
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

		return _eMagazineLocalService.dynamicQuery(
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

		return _eMagazineLocalService.dynamicQueryCount(dynamicQuery);
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

		return _eMagazineLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public qlanphamdb.model.eMagazine fetcheMagazine(long id) {
		return _eMagazineLocalService.fetcheMagazine(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eMagazineLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the e magazine with the primary key.
	 *
	 * @param id the primary key of the e magazine
	 * @return the e magazine
	 * @throws PortalException if a e magazine with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.eMagazine geteMagazine(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazineLocalService.geteMagazine(id);
	}

	/**
	 * Returns a range of all the e magazines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazines
	 * @param end the upper bound of the range of e magazines (not inclusive)
	 * @return the range of e magazines
	 */
	@Override
	public java.util.List<qlanphamdb.model.eMagazine> geteMagazines(
		int start, int end) {

		return _eMagazineLocalService.geteMagazines(start, end);
	}

	/**
	 * Returns the number of e magazines.
	 *
	 * @return the number of e magazines
	 */
	@Override
	public int geteMagazinesCount() {
		return _eMagazineLocalService.geteMagazinesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eMagazineLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eMagazineLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazineLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the e magazine in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine the e magazine
	 * @return the e magazine that was updated
	 */
	@Override
	public qlanphamdb.model.eMagazine updateeMagazine(
		qlanphamdb.model.eMagazine eMagazine) {

		return _eMagazineLocalService.updateeMagazine(eMagazine);
	}

	@Override
	public eMagazineLocalService getWrappedService() {
		return _eMagazineLocalService;
	}

	@Override
	public void setWrappedService(eMagazineLocalService eMagazineLocalService) {
		_eMagazineLocalService = eMagazineLocalService;
	}

	private eMagazineLocalService _eMagazineLocalService;

}