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
 * Provides a wrapper for {@link VanbanphapquyLocalService}.
 *
 * @author BinhNT
 * @see VanbanphapquyLocalService
 * @generated
 */
public class VanbanphapquyLocalServiceWrapper
	implements ServiceWrapper<VanbanphapquyLocalService>,
			   VanbanphapquyLocalService {

	public VanbanphapquyLocalServiceWrapper(
		VanbanphapquyLocalService vanbanphapquyLocalService) {

		_vanbanphapquyLocalService = vanbanphapquyLocalService;
	}

	/**
	 * Adds the vanbanphapquy to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VanbanphapquyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vanbanphapquy the vanbanphapquy
	 * @return the vanbanphapquy that was added
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Vanbanphapquy addVanbanphapquy(
		vn.dnict.vanbanphapquy.model.Vanbanphapquy vanbanphapquy) {

		return _vanbanphapquyLocalService.addVanbanphapquy(vanbanphapquy);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vanbanphapquyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new vanbanphapquy with the primary key. Does not add the vanbanphapquy to the database.
	 *
	 * @param id the primary key for the new vanbanphapquy
	 * @return the new vanbanphapquy
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Vanbanphapquy createVanbanphapquy(
		long id) {

		return _vanbanphapquyLocalService.createVanbanphapquy(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vanbanphapquyLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vanbanphapquy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VanbanphapquyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the vanbanphapquy
	 * @return the vanbanphapquy that was removed
	 * @throws PortalException if a vanbanphapquy with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Vanbanphapquy deleteVanbanphapquy(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vanbanphapquyLocalService.deleteVanbanphapquy(id);
	}

	/**
	 * Deletes the vanbanphapquy from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VanbanphapquyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vanbanphapquy the vanbanphapquy
	 * @return the vanbanphapquy that was removed
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Vanbanphapquy deleteVanbanphapquy(
		vn.dnict.vanbanphapquy.model.Vanbanphapquy vanbanphapquy) {

		return _vanbanphapquyLocalService.deleteVanbanphapquy(vanbanphapquy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vanbanphapquyLocalService.dynamicQuery();
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

		return _vanbanphapquyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.VanbanphapquyModelImpl</code>.
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

		return _vanbanphapquyLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.VanbanphapquyModelImpl</code>.
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

		return _vanbanphapquyLocalService.dynamicQuery(
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

		return _vanbanphapquyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _vanbanphapquyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.vanbanphapquy.model.Vanbanphapquy fetchVanbanphapquy(
		long id) {

		return _vanbanphapquyLocalService.fetchVanbanphapquy(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _vanbanphapquyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _vanbanphapquyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _vanbanphapquyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vanbanphapquyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vanbanphapquy with the primary key.
	 *
	 * @param id the primary key of the vanbanphapquy
	 * @return the vanbanphapquy
	 * @throws PortalException if a vanbanphapquy with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Vanbanphapquy getVanbanphapquy(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vanbanphapquyLocalService.getVanbanphapquy(id);
	}

	/**
	 * Returns a range of all the vanbanphapquys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @return the range of vanbanphapquys
	 */
	@Override
	public java.util.List<vn.dnict.vanbanphapquy.model.Vanbanphapquy>
		getVanbanphapquys(int start, int end) {

		return _vanbanphapquyLocalService.getVanbanphapquys(start, end);
	}

	/**
	 * Returns the number of vanbanphapquys.
	 *
	 * @return the number of vanbanphapquys
	 */
	@Override
	public int getVanbanphapquysCount() {
		return _vanbanphapquyLocalService.getVanbanphapquysCount();
	}

	/**
	 * Updates the vanbanphapquy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VanbanphapquyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vanbanphapquy the vanbanphapquy
	 * @return the vanbanphapquy that was updated
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Vanbanphapquy updateVanbanphapquy(
		vn.dnict.vanbanphapquy.model.Vanbanphapquy vanbanphapquy) {

		return _vanbanphapquyLocalService.updateVanbanphapquy(vanbanphapquy);
	}

	@Override
	public VanbanphapquyLocalService getWrappedService() {
		return _vanbanphapquyLocalService;
	}

	@Override
	public void setWrappedService(
		VanbanphapquyLocalService vanbanphapquyLocalService) {

		_vanbanphapquyLocalService = vanbanphapquyLocalService;
	}

	private VanbanphapquyLocalService _vanbanphapquyLocalService;

}