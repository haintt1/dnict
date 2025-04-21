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
 * Provides a wrapper for {@link AnPham_ActivityLocalService}.
 *
 * @author dnict
 * @see AnPham_ActivityLocalService
 * @generated
 */
public class AnPham_ActivityLocalServiceWrapper
	implements AnPham_ActivityLocalService,
			   ServiceWrapper<AnPham_ActivityLocalService> {

	public AnPham_ActivityLocalServiceWrapper(
		AnPham_ActivityLocalService anPham_ActivityLocalService) {

		_anPham_ActivityLocalService = anPham_ActivityLocalService;
	}

	/**
	 * Adds the an pham_ activity to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_Activity the an pham_ activity
	 * @return the an pham_ activity that was added
	 */
	@Override
	public qlanphamdb.model.AnPham_Activity addAnPham_Activity(
		qlanphamdb.model.AnPham_Activity anPham_Activity) {

		return _anPham_ActivityLocalService.addAnPham_Activity(anPham_Activity);
	}

	/**
	 * Creates a new an pham_ activity with the primary key. Does not add the an pham_ activity to the database.
	 *
	 * @param id the primary key for the new an pham_ activity
	 * @return the new an pham_ activity
	 */
	@Override
	public qlanphamdb.model.AnPham_Activity createAnPham_Activity(long id) {
		return _anPham_ActivityLocalService.createAnPham_Activity(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_ActivityLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the an pham_ activity from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_Activity the an pham_ activity
	 * @return the an pham_ activity that was removed
	 */
	@Override
	public qlanphamdb.model.AnPham_Activity deleteAnPham_Activity(
		qlanphamdb.model.AnPham_Activity anPham_Activity) {

		return _anPham_ActivityLocalService.deleteAnPham_Activity(
			anPham_Activity);
	}

	/**
	 * Deletes the an pham_ activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the an pham_ activity
	 * @return the an pham_ activity that was removed
	 * @throws PortalException if a an pham_ activity with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.AnPham_Activity deleteAnPham_Activity(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_ActivityLocalService.deleteAnPham_Activity(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_ActivityLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _anPham_ActivityLocalService.dynamicQuery();
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

		return _anPham_ActivityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_ActivityModelImpl</code>.
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

		return _anPham_ActivityLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_ActivityModelImpl</code>.
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

		return _anPham_ActivityLocalService.dynamicQuery(
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

		return _anPham_ActivityLocalService.dynamicQueryCount(dynamicQuery);
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

		return _anPham_ActivityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public qlanphamdb.model.AnPham_Activity fetchAnPham_Activity(long id) {
		return _anPham_ActivityLocalService.fetchAnPham_Activity(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _anPham_ActivityLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the an pham_ activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ activities
	 * @param end the upper bound of the range of an pham_ activities (not inclusive)
	 * @return the range of an pham_ activities
	 */
	@Override
	public java.util.List<qlanphamdb.model.AnPham_Activity>
		getAnPham_Activities(int start, int end) {

		return _anPham_ActivityLocalService.getAnPham_Activities(start, end);
	}

	/**
	 * Returns the number of an pham_ activities.
	 *
	 * @return the number of an pham_ activities
	 */
	@Override
	public int getAnPham_ActivitiesCount() {
		return _anPham_ActivityLocalService.getAnPham_ActivitiesCount();
	}

	/**
	 * Returns the an pham_ activity with the primary key.
	 *
	 * @param id the primary key of the an pham_ activity
	 * @return the an pham_ activity
	 * @throws PortalException if a an pham_ activity with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.AnPham_Activity getAnPham_Activity(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_ActivityLocalService.getAnPham_Activity(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _anPham_ActivityLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _anPham_ActivityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_ActivityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the an pham_ activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_Activity the an pham_ activity
	 * @return the an pham_ activity that was updated
	 */
	@Override
	public qlanphamdb.model.AnPham_Activity updateAnPham_Activity(
		qlanphamdb.model.AnPham_Activity anPham_Activity) {

		return _anPham_ActivityLocalService.updateAnPham_Activity(
			anPham_Activity);
	}

	@Override
	public AnPham_ActivityLocalService getWrappedService() {
		return _anPham_ActivityLocalService;
	}

	@Override
	public void setWrappedService(
		AnPham_ActivityLocalService anPham_ActivityLocalService) {

		_anPham_ActivityLocalService = anPham_ActivityLocalService;
	}

	private AnPham_ActivityLocalService _anPham_ActivityLocalService;

}