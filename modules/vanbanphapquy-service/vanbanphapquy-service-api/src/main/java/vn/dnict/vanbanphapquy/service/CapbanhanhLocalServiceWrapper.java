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

package vn.dnict.vanbanphapquy.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CapbanhanhLocalService}.
 *
 * @author BinhNT
 * @see CapbanhanhLocalService
 * @generated
 */
public class CapbanhanhLocalServiceWrapper
	implements CapbanhanhLocalService, ServiceWrapper<CapbanhanhLocalService> {

	public CapbanhanhLocalServiceWrapper(
		CapbanhanhLocalService capbanhanhLocalService) {

		_capbanhanhLocalService = capbanhanhLocalService;
	}

	/**
	 * Adds the capbanhanh to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CapbanhanhLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param capbanhanh the capbanhanh
	 * @return the capbanhanh that was added
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Capbanhanh addCapbanhanh(
		vn.dnict.vanbanphapquy.model.Capbanhanh capbanhanh) {

		return _capbanhanhLocalService.addCapbanhanh(capbanhanh);
	}

	/**
	 * Creates a new capbanhanh with the primary key. Does not add the capbanhanh to the database.
	 *
	 * @param id the primary key for the new capbanhanh
	 * @return the new capbanhanh
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Capbanhanh createCapbanhanh(long id) {
		return _capbanhanhLocalService.createCapbanhanh(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _capbanhanhLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the capbanhanh from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CapbanhanhLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param capbanhanh the capbanhanh
	 * @return the capbanhanh that was removed
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Capbanhanh deleteCapbanhanh(
		vn.dnict.vanbanphapquy.model.Capbanhanh capbanhanh) {

		return _capbanhanhLocalService.deleteCapbanhanh(capbanhanh);
	}

	/**
	 * Deletes the capbanhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CapbanhanhLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the capbanhanh
	 * @return the capbanhanh that was removed
	 * @throws PortalException if a capbanhanh with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Capbanhanh deleteCapbanhanh(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _capbanhanhLocalService.deleteCapbanhanh(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _capbanhanhLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _capbanhanhLocalService.dynamicQuery();
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

		return _capbanhanhLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.CapbanhanhModelImpl</code>.
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

		return _capbanhanhLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.CapbanhanhModelImpl</code>.
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

		return _capbanhanhLocalService.dynamicQuery(
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

		return _capbanhanhLocalService.dynamicQueryCount(dynamicQuery);
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

		return _capbanhanhLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.vanbanphapquy.model.Capbanhanh fetchCapbanhanh(long id) {
		return _capbanhanhLocalService.fetchCapbanhanh(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _capbanhanhLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the capbanhanh with the primary key.
	 *
	 * @param id the primary key of the capbanhanh
	 * @return the capbanhanh
	 * @throws PortalException if a capbanhanh with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Capbanhanh getCapbanhanh(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _capbanhanhLocalService.getCapbanhanh(id);
	}

	/**
	 * Returns a range of all the capbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @return the range of capbanhanhs
	 */
	@Override
	public java.util.List<vn.dnict.vanbanphapquy.model.Capbanhanh>
		getCapbanhanhs(int start, int end) {

		return _capbanhanhLocalService.getCapbanhanhs(start, end);
	}

	/**
	 * Returns the number of capbanhanhs.
	 *
	 * @return the number of capbanhanhs
	 */
	@Override
	public int getCapbanhanhsCount() {
		return _capbanhanhLocalService.getCapbanhanhsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _capbanhanhLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _capbanhanhLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _capbanhanhLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the capbanhanh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CapbanhanhLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param capbanhanh the capbanhanh
	 * @return the capbanhanh that was updated
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Capbanhanh updateCapbanhanh(
		vn.dnict.vanbanphapquy.model.Capbanhanh capbanhanh) {

		return _capbanhanhLocalService.updateCapbanhanh(capbanhanh);
	}

	@Override
	public CapbanhanhLocalService getWrappedService() {
		return _capbanhanhLocalService;
	}

	@Override
	public void setWrappedService(
		CapbanhanhLocalService capbanhanhLocalService) {

		_capbanhanhLocalService = capbanhanhLocalService;
	}

	private CapbanhanhLocalService _capbanhanhLocalService;

}