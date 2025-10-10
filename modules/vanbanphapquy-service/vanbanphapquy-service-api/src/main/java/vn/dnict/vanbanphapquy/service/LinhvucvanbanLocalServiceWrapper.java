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
 * Provides a wrapper for {@link LinhvucvanbanLocalService}.
 *
 * @author BinhNT
 * @see LinhvucvanbanLocalService
 * @generated
 */
public class LinhvucvanbanLocalServiceWrapper
	implements LinhvucvanbanLocalService,
			   ServiceWrapper<LinhvucvanbanLocalService> {

	public LinhvucvanbanLocalServiceWrapper(
		LinhvucvanbanLocalService linhvucvanbanLocalService) {

		_linhvucvanbanLocalService = linhvucvanbanLocalService;
	}

	/**
	 * Adds the linhvucvanban to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinhvucvanbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linhvucvanban the linhvucvanban
	 * @return the linhvucvanban that was added
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Linhvucvanban addLinhvucvanban(
		vn.dnict.vanbanphapquy.model.Linhvucvanban linhvucvanban) {

		return _linhvucvanbanLocalService.addLinhvucvanban(linhvucvanban);
	}

	/**
	 * Creates a new linhvucvanban with the primary key. Does not add the linhvucvanban to the database.
	 *
	 * @param id the primary key for the new linhvucvanban
	 * @return the new linhvucvanban
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Linhvucvanban createLinhvucvanban(
		long id) {

		return _linhvucvanbanLocalService.createLinhvucvanban(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linhvucvanbanLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the linhvucvanban from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinhvucvanbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linhvucvanban the linhvucvanban
	 * @return the linhvucvanban that was removed
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Linhvucvanban deleteLinhvucvanban(
		vn.dnict.vanbanphapquy.model.Linhvucvanban linhvucvanban) {

		return _linhvucvanbanLocalService.deleteLinhvucvanban(linhvucvanban);
	}

	/**
	 * Deletes the linhvucvanban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinhvucvanbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the linhvucvanban
	 * @return the linhvucvanban that was removed
	 * @throws PortalException if a linhvucvanban with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Linhvucvanban deleteLinhvucvanban(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linhvucvanbanLocalService.deleteLinhvucvanban(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linhvucvanbanLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _linhvucvanbanLocalService.dynamicQuery();
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

		return _linhvucvanbanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.LinhvucvanbanModelImpl</code>.
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

		return _linhvucvanbanLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.LinhvucvanbanModelImpl</code>.
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

		return _linhvucvanbanLocalService.dynamicQuery(
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

		return _linhvucvanbanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _linhvucvanbanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.vanbanphapquy.model.Linhvucvanban fetchLinhvucvanban(
		long id) {

		return _linhvucvanbanLocalService.fetchLinhvucvanban(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _linhvucvanbanLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _linhvucvanbanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the linhvucvanban with the primary key.
	 *
	 * @param id the primary key of the linhvucvanban
	 * @return the linhvucvanban
	 * @throws PortalException if a linhvucvanban with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Linhvucvanban getLinhvucvanban(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linhvucvanbanLocalService.getLinhvucvanban(id);
	}

	/**
	 * Returns a range of all the linhvucvanbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @return the range of linhvucvanbans
	 */
	@Override
	public java.util.List<vn.dnict.vanbanphapquy.model.Linhvucvanban>
		getLinhvucvanbans(int start, int end) {

		return _linhvucvanbanLocalService.getLinhvucvanbans(start, end);
	}

	/**
	 * Returns the number of linhvucvanbans.
	 *
	 * @return the number of linhvucvanbans
	 */
	@Override
	public int getLinhvucvanbansCount() {
		return _linhvucvanbanLocalService.getLinhvucvanbansCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _linhvucvanbanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linhvucvanbanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the linhvucvanban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LinhvucvanbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param linhvucvanban the linhvucvanban
	 * @return the linhvucvanban that was updated
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.Linhvucvanban updateLinhvucvanban(
		vn.dnict.vanbanphapquy.model.Linhvucvanban linhvucvanban) {

		return _linhvucvanbanLocalService.updateLinhvucvanban(linhvucvanban);
	}

	@Override
	public LinhvucvanbanLocalService getWrappedService() {
		return _linhvucvanbanLocalService;
	}

	@Override
	public void setWrappedService(
		LinhvucvanbanLocalService linhvucvanbanLocalService) {

		_linhvucvanbanLocalService = linhvucvanbanLocalService;
	}

	private LinhvucvanbanLocalService _linhvucvanbanLocalService;

}