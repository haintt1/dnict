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
 * Provides a wrapper for {@link LoaivanbanLocalService}.
 *
 * @author BinhNT
 * @see LoaivanbanLocalService
 * @generated
 */
public class LoaivanbanLocalServiceWrapper
	implements LoaivanbanLocalService, ServiceWrapper<LoaivanbanLocalService> {

	public LoaivanbanLocalServiceWrapper(
		LoaivanbanLocalService loaivanbanLocalService) {

		_loaivanbanLocalService = loaivanbanLocalService;
	}

	/**
	 * Adds the loaivanban to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoaivanbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loaivanban the loaivanban
	 * @return the loaivanban that was added
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Loaivanban addLoaivanban(
		vn.dnict.vanbanphapquy.model.Loaivanban loaivanban) {

		return _loaivanbanLocalService.addLoaivanban(loaivanban);
	}

	/**
	 * Creates a new loaivanban with the primary key. Does not add the loaivanban to the database.
	 *
	 * @param id the primary key for the new loaivanban
	 * @return the new loaivanban
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Loaivanban createLoaivanban(long id) {
		return _loaivanbanLocalService.createLoaivanban(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loaivanbanLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the loaivanban from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoaivanbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loaivanban the loaivanban
	 * @return the loaivanban that was removed
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Loaivanban deleteLoaivanban(
		vn.dnict.vanbanphapquy.model.Loaivanban loaivanban) {

		return _loaivanbanLocalService.deleteLoaivanban(loaivanban);
	}

	/**
	 * Deletes the loaivanban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoaivanbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the loaivanban
	 * @return the loaivanban that was removed
	 * @throws PortalException if a loaivanban with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Loaivanban deleteLoaivanban(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loaivanbanLocalService.deleteLoaivanban(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loaivanbanLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _loaivanbanLocalService.dynamicQuery();
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

		return _loaivanbanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.LoaivanbanModelImpl</code>.
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

		return _loaivanbanLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.LoaivanbanModelImpl</code>.
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

		return _loaivanbanLocalService.dynamicQuery(
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

		return _loaivanbanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _loaivanbanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.vanbanphapquy.model.Loaivanban fetchLoaivanban(long id) {
		return _loaivanbanLocalService.fetchLoaivanban(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _loaivanbanLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _loaivanbanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the loaivanban with the primary key.
	 *
	 * @param id the primary key of the loaivanban
	 * @return the loaivanban
	 * @throws PortalException if a loaivanban with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Loaivanban getLoaivanban(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loaivanbanLocalService.getLoaivanban(id);
	}

	/**
	 * Returns a range of all the loaivanbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.LoaivanbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loaivanbans
	 * @param end the upper bound of the range of loaivanbans (not inclusive)
	 * @return the range of loaivanbans
	 */
	@Override
	public java.util.List<vn.dnict.vanbanphapquy.model.Loaivanban>
		getLoaivanbans(int start, int end) {

		return _loaivanbanLocalService.getLoaivanbans(start, end);
	}

	/**
	 * Returns the number of loaivanbans.
	 *
	 * @return the number of loaivanbans
	 */
	@Override
	public int getLoaivanbansCount() {
		return _loaivanbanLocalService.getLoaivanbansCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _loaivanbanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loaivanbanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the loaivanban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoaivanbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loaivanban the loaivanban
	 * @return the loaivanban that was updated
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Loaivanban updateLoaivanban(
		vn.dnict.vanbanphapquy.model.Loaivanban loaivanban) {

		return _loaivanbanLocalService.updateLoaivanban(loaivanban);
	}

	@Override
	public LoaivanbanLocalService getWrappedService() {
		return _loaivanbanLocalService;
	}

	@Override
	public void setWrappedService(
		LoaivanbanLocalService loaivanbanLocalService) {

		_loaivanbanLocalService = loaivanbanLocalService;
	}

	private LoaivanbanLocalService _loaivanbanLocalService;

}