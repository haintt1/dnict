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
 * Provides a wrapper for {@link dinhkemfileLocalService}.
 *
 * @author BinhNT
 * @see dinhkemfileLocalService
 * @generated
 */
public class dinhkemfileLocalServiceWrapper
	implements dinhkemfileLocalService,
			   ServiceWrapper<dinhkemfileLocalService> {

	public dinhkemfileLocalServiceWrapper(
		dinhkemfileLocalService dinhkemfileLocalService) {

		_dinhkemfileLocalService = dinhkemfileLocalService;
	}

	/**
	 * Adds the dinhkemfile to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dinhkemfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dinhkemfile the dinhkemfile
	 * @return the dinhkemfile that was added
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.dinhkemfile adddinhkemfile(
		vn.dnict.vanbanphapquy.model.dinhkemfile dinhkemfile) {

		return _dinhkemfileLocalService.adddinhkemfile(dinhkemfile);
	}

	/**
	 * Creates a new dinhkemfile with the primary key. Does not add the dinhkemfile to the database.
	 *
	 * @param id the primary key for the new dinhkemfile
	 * @return the new dinhkemfile
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.dinhkemfile createdinhkemfile(long id) {
		return _dinhkemfileLocalService.createdinhkemfile(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dinhkemfileLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dinhkemfile from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dinhkemfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dinhkemfile the dinhkemfile
	 * @return the dinhkemfile that was removed
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.dinhkemfile deletedinhkemfile(
		vn.dnict.vanbanphapquy.model.dinhkemfile dinhkemfile) {

		return _dinhkemfileLocalService.deletedinhkemfile(dinhkemfile);
	}

	/**
	 * Deletes the dinhkemfile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dinhkemfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dinhkemfile
	 * @return the dinhkemfile that was removed
	 * @throws PortalException if a dinhkemfile with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.dinhkemfile deletedinhkemfile(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dinhkemfileLocalService.deletedinhkemfile(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dinhkemfileLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dinhkemfileLocalService.dynamicQuery();
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

		return _dinhkemfileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.dinhkemfileModelImpl</code>.
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

		return _dinhkemfileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.dinhkemfileModelImpl</code>.
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

		return _dinhkemfileLocalService.dynamicQuery(
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

		return _dinhkemfileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dinhkemfileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.vanbanphapquy.model.dinhkemfile fetchdinhkemfile(long id) {
		return _dinhkemfileLocalService.fetchdinhkemfile(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dinhkemfileLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dinhkemfile with the primary key.
	 *
	 * @param id the primary key of the dinhkemfile
	 * @return the dinhkemfile
	 * @throws PortalException if a dinhkemfile with the primary key could not be found
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.dinhkemfile getdinhkemfile(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dinhkemfileLocalService.getdinhkemfile(id);
	}

	/**
	 * Returns a range of all the dinhkemfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.vanbanphapquy.model.impl.dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @return the range of dinhkemfiles
	 */
	@Override
	public java.util.List<vn.dnict.vanbanphapquy.model.dinhkemfile>
		getdinhkemfiles(int start, int end) {

		return _dinhkemfileLocalService.getdinhkemfiles(start, end);
	}

	/**
	 * Returns the number of dinhkemfiles.
	 *
	 * @return the number of dinhkemfiles
	 */
	@Override
	public int getdinhkemfilesCount() {
		return _dinhkemfileLocalService.getdinhkemfilesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dinhkemfileLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<vn.dnict.vanbanphapquy.model.dinhkemfile> getObjectId(
		long objectId) {

		return _dinhkemfileLocalService.getObjectId(objectId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dinhkemfileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dinhkemfileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dinhkemfile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dinhkemfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dinhkemfile the dinhkemfile
	 * @return the dinhkemfile that was updated
	 */
	@Override
	public vn.dnict.vanbanphapquy.model.dinhkemfile updatedinhkemfile(
		vn.dnict.vanbanphapquy.model.dinhkemfile dinhkemfile) {

		return _dinhkemfileLocalService.updatedinhkemfile(dinhkemfile);
	}

	@Override
	public dinhkemfileLocalService getWrappedService() {
		return _dinhkemfileLocalService;
	}

	@Override
	public void setWrappedService(
		dinhkemfileLocalService dinhkemfileLocalService) {

		_dinhkemfileLocalService = dinhkemfileLocalService;
	}

	private dinhkemfileLocalService _dinhkemfileLocalService;

}