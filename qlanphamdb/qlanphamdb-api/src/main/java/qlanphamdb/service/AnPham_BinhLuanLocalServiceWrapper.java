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
 * Provides a wrapper for {@link AnPham_BinhLuanLocalService}.
 *
 * @author dnict
 * @see AnPham_BinhLuanLocalService
 * @generated
 */
public class AnPham_BinhLuanLocalServiceWrapper
	implements AnPham_BinhLuanLocalService,
			   ServiceWrapper<AnPham_BinhLuanLocalService> {

	public AnPham_BinhLuanLocalServiceWrapper(
		AnPham_BinhLuanLocalService anPham_BinhLuanLocalService) {

		_anPham_BinhLuanLocalService = anPham_BinhLuanLocalService;
	}

	/**
	 * Adds the an pham_ binh luan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_BinhLuan the an pham_ binh luan
	 * @return the an pham_ binh luan that was added
	 */
	@Override
	public qlanphamdb.model.AnPham_BinhLuan addAnPham_BinhLuan(
		qlanphamdb.model.AnPham_BinhLuan anPham_BinhLuan) {

		return _anPham_BinhLuanLocalService.addAnPham_BinhLuan(anPham_BinhLuan);
	}

	/**
	 * Creates a new an pham_ binh luan with the primary key. Does not add the an pham_ binh luan to the database.
	 *
	 * @param id the primary key for the new an pham_ binh luan
	 * @return the new an pham_ binh luan
	 */
	@Override
	public qlanphamdb.model.AnPham_BinhLuan createAnPham_BinhLuan(long id) {
		return _anPham_BinhLuanLocalService.createAnPham_BinhLuan(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_BinhLuanLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the an pham_ binh luan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_BinhLuan the an pham_ binh luan
	 * @return the an pham_ binh luan that was removed
	 */
	@Override
	public qlanphamdb.model.AnPham_BinhLuan deleteAnPham_BinhLuan(
		qlanphamdb.model.AnPham_BinhLuan anPham_BinhLuan) {

		return _anPham_BinhLuanLocalService.deleteAnPham_BinhLuan(
			anPham_BinhLuan);
	}

	/**
	 * Deletes the an pham_ binh luan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the an pham_ binh luan
	 * @return the an pham_ binh luan that was removed
	 * @throws PortalException if a an pham_ binh luan with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.AnPham_BinhLuan deleteAnPham_BinhLuan(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_BinhLuanLocalService.deleteAnPham_BinhLuan(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_BinhLuanLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _anPham_BinhLuanLocalService.dynamicQuery();
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

		return _anPham_BinhLuanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_BinhLuanModelImpl</code>.
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

		return _anPham_BinhLuanLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_BinhLuanModelImpl</code>.
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

		return _anPham_BinhLuanLocalService.dynamicQuery(
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

		return _anPham_BinhLuanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _anPham_BinhLuanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public qlanphamdb.model.AnPham_BinhLuan fetchAnPham_BinhLuan(long id) {
		return _anPham_BinhLuanLocalService.fetchAnPham_BinhLuan(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _anPham_BinhLuanLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the an pham_ binh luan with the primary key.
	 *
	 * @param id the primary key of the an pham_ binh luan
	 * @return the an pham_ binh luan
	 * @throws PortalException if a an pham_ binh luan with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.AnPham_BinhLuan getAnPham_BinhLuan(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_BinhLuanLocalService.getAnPham_BinhLuan(id);
	}

	/**
	 * Returns a range of all the an pham_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.AnPham_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ binh luans
	 * @param end the upper bound of the range of an pham_ binh luans (not inclusive)
	 * @return the range of an pham_ binh luans
	 */
	@Override
	public java.util.List<qlanphamdb.model.AnPham_BinhLuan> getAnPham_BinhLuans(
		int start, int end) {

		return _anPham_BinhLuanLocalService.getAnPham_BinhLuans(start, end);
	}

	/**
	 * Returns the number of an pham_ binh luans.
	 *
	 * @return the number of an pham_ binh luans
	 */
	@Override
	public int getAnPham_BinhLuansCount() {
		return _anPham_BinhLuanLocalService.getAnPham_BinhLuansCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _anPham_BinhLuanLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _anPham_BinhLuanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _anPham_BinhLuanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the an pham_ binh luan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnPham_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param anPham_BinhLuan the an pham_ binh luan
	 * @return the an pham_ binh luan that was updated
	 */
	@Override
	public qlanphamdb.model.AnPham_BinhLuan updateAnPham_BinhLuan(
		qlanphamdb.model.AnPham_BinhLuan anPham_BinhLuan) {

		return _anPham_BinhLuanLocalService.updateAnPham_BinhLuan(
			anPham_BinhLuan);
	}

	@Override
	public AnPham_BinhLuanLocalService getWrappedService() {
		return _anPham_BinhLuanLocalService;
	}

	@Override
	public void setWrappedService(
		AnPham_BinhLuanLocalService anPham_BinhLuanLocalService) {

		_anPham_BinhLuanLocalService = anPham_BinhLuanLocalService;
	}

	private AnPham_BinhLuanLocalService _anPham_BinhLuanLocalService;

}