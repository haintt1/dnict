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
 * Provides a wrapper for {@link CoquanbanhanhLocalService}.
 *
 * @author BinhNT
 * @see CoquanbanhanhLocalService
 * @generated
 */
public class CoquanbanhanhLocalServiceWrapper
	implements CoquanbanhanhLocalService,
			   ServiceWrapper<CoquanbanhanhLocalService> {

	public CoquanbanhanhLocalServiceWrapper(
		CoquanbanhanhLocalService coquanbanhanhLocalService) {

		_coquanbanhanhLocalService = coquanbanhanhLocalService;
	}

	/**
	 * Adds the coquanbanhanh to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoquanbanhanhLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coquanbanhanh the coquanbanhanh
	 * @return the coquanbanhanh that was added
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Coquanbanhanh addCoquanbanhanh(
		vn.dnict.vanbanphapquy.model.Coquanbanhanh coquanbanhanh) {

		return _coquanbanhanhLocalService.addCoquanbanhanh(coquanbanhanh);
	}

	/**
	 * Creates a new coquanbanhanh with the primary key. Does not add the coquanbanhanh to the database.
	 *
	 * @param id the primary key for the new coquanbanhanh
	 * @return the new coquanbanhanh
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Coquanbanhanh createCoquanbanhanh(
		long id) {

		return _coquanbanhanhLocalService.createCoquanbanhanh(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coquanbanhanhLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the coquanbanhanh from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoquanbanhanhLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coquanbanhanh the coquanbanhanh
	 * @return the coquanbanhanh that was removed
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Coquanbanhanh deleteCoquanbanhanh(
		vn.dnict.vanbanphapquy.model.Coquanbanhanh coquanbanhanh) {

		return _coquanbanhanhLocalService.deleteCoquanbanhanh(coquanbanhanh);
	}

	/**
	 * Deletes the coquanbanhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoquanbanhanhLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the coquanbanhanh
	 * @return the coquanbanhanh that was removed
	 * @throws PortalException if a coquanbanhanh with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Coquanbanhanh deleteCoquanbanhanh(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coquanbanhanhLocalService.deleteCoquanbanhanh(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coquanbanhanhLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _coquanbanhanhLocalService.dynamicQuery();
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

		return _coquanbanhanhLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.CoquanbanhanhModelImpl</code>.
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

		return _coquanbanhanhLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.CoquanbanhanhModelImpl</code>.
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

		return _coquanbanhanhLocalService.dynamicQuery(
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

		return _coquanbanhanhLocalService.dynamicQueryCount(dynamicQuery);
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

		return _coquanbanhanhLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.vanbanphapquy.model.Coquanbanhanh fetchCoquanbanhanh(
		long id) {

		return _coquanbanhanhLocalService.fetchCoquanbanhanh(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _coquanbanhanhLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the coquanbanhanh with the primary key.
	 *
	 * @param id the primary key of the coquanbanhanh
	 * @return the coquanbanhanh
	 * @throws PortalException if a coquanbanhanh with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Coquanbanhanh getCoquanbanhanh(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coquanbanhanhLocalService.getCoquanbanhanh(id);
	}

	/**
	 * Returns a range of all the coquanbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @return the range of coquanbanhanhs
	 */
	@Override
	public java.util.List<vn.dnict.vanbanphapquy.model.Coquanbanhanh>
		getCoquanbanhanhs(int start, int end) {

		return _coquanbanhanhLocalService.getCoquanbanhanhs(start, end);
	}

	/**
	 * Returns the number of coquanbanhanhs.
	 *
	 * @return the number of coquanbanhanhs
	 */
	@Override
	public int getCoquanbanhanhsCount() {
		return _coquanbanhanhLocalService.getCoquanbanhanhsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _coquanbanhanhLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _coquanbanhanhLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coquanbanhanhLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the coquanbanhanh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoquanbanhanhLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coquanbanhanh the coquanbanhanh
	 * @return the coquanbanhanh that was updated
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Coquanbanhanh updateCoquanbanhanh(
		vn.dnict.vanbanphapquy.model.Coquanbanhanh coquanbanhanh) {

		return _coquanbanhanhLocalService.updateCoquanbanhanh(coquanbanhanh);
	}

	@Override
	public CoquanbanhanhLocalService getWrappedService() {
		return _coquanbanhanhLocalService;
	}

	@Override
	public void setWrappedService(
		CoquanbanhanhLocalService coquanbanhanhLocalService) {

		_coquanbanhanhLocalService = coquanbanhanhLocalService;
	}

	private CoquanbanhanhLocalService _coquanbanhanhLocalService;

}