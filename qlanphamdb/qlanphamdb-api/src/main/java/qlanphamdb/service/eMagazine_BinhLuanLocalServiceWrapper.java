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
 * Provides a wrapper for {@link eMagazine_BinhLuanLocalService}.
 *
 * @author dnict
 * @see eMagazine_BinhLuanLocalService
 * @generated
 */
public class eMagazine_BinhLuanLocalServiceWrapper
	implements eMagazine_BinhLuanLocalService,
			   ServiceWrapper<eMagazine_BinhLuanLocalService> {

	public eMagazine_BinhLuanLocalServiceWrapper(
		eMagazine_BinhLuanLocalService eMagazine_BinhLuanLocalService) {

		_eMagazine_BinhLuanLocalService = eMagazine_BinhLuanLocalService;
	}

	/**
	 * Adds the e magazine_ binh luan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine_BinhLuan the e magazine_ binh luan
	 * @return the e magazine_ binh luan that was added
	 */
	@Override
	public qlanphamdb.model.eMagazine_BinhLuan addeMagazine_BinhLuan(
		qlanphamdb.model.eMagazine_BinhLuan eMagazine_BinhLuan) {

		return _eMagazine_BinhLuanLocalService.addeMagazine_BinhLuan(
			eMagazine_BinhLuan);
	}

	/**
	 * Creates a new e magazine_ binh luan with the primary key. Does not add the e magazine_ binh luan to the database.
	 *
	 * @param id the primary key for the new e magazine_ binh luan
	 * @return the new e magazine_ binh luan
	 */
	@Override
	public qlanphamdb.model.eMagazine_BinhLuan createeMagazine_BinhLuan(
		long id) {

		return _eMagazine_BinhLuanLocalService.createeMagazine_BinhLuan(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_BinhLuanLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the e magazine_ binh luan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine_BinhLuan the e magazine_ binh luan
	 * @return the e magazine_ binh luan that was removed
	 */
	@Override
	public qlanphamdb.model.eMagazine_BinhLuan deleteeMagazine_BinhLuan(
		qlanphamdb.model.eMagazine_BinhLuan eMagazine_BinhLuan) {

		return _eMagazine_BinhLuanLocalService.deleteeMagazine_BinhLuan(
			eMagazine_BinhLuan);
	}

	/**
	 * Deletes the e magazine_ binh luan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the e magazine_ binh luan
	 * @return the e magazine_ binh luan that was removed
	 * @throws PortalException if a e magazine_ binh luan with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.eMagazine_BinhLuan deleteeMagazine_BinhLuan(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_BinhLuanLocalService.deleteeMagazine_BinhLuan(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_BinhLuanLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eMagazine_BinhLuanLocalService.dynamicQuery();
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

		return _eMagazine_BinhLuanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazine_BinhLuanModelImpl</code>.
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

		return _eMagazine_BinhLuanLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazine_BinhLuanModelImpl</code>.
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

		return _eMagazine_BinhLuanLocalService.dynamicQuery(
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

		return _eMagazine_BinhLuanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _eMagazine_BinhLuanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public qlanphamdb.model.eMagazine_BinhLuan fetcheMagazine_BinhLuan(
		long id) {

		return _eMagazine_BinhLuanLocalService.fetcheMagazine_BinhLuan(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eMagazine_BinhLuanLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the e magazine_ binh luan with the primary key.
	 *
	 * @param id the primary key of the e magazine_ binh luan
	 * @return the e magazine_ binh luan
	 * @throws PortalException if a e magazine_ binh luan with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.eMagazine_BinhLuan geteMagazine_BinhLuan(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_BinhLuanLocalService.geteMagazine_BinhLuan(id);
	}

	/**
	 * Returns a range of all the e magazine_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazine_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_ binh luans
	 * @param end the upper bound of the range of e magazine_ binh luans (not inclusive)
	 * @return the range of e magazine_ binh luans
	 */
	@Override
	public java.util.List<qlanphamdb.model.eMagazine_BinhLuan>
		geteMagazine_BinhLuans(int start, int end) {

		return _eMagazine_BinhLuanLocalService.geteMagazine_BinhLuans(
			start, end);
	}

	/**
	 * Returns the number of e magazine_ binh luans.
	 *
	 * @return the number of e magazine_ binh luans
	 */
	@Override
	public int geteMagazine_BinhLuansCount() {
		return _eMagazine_BinhLuanLocalService.geteMagazine_BinhLuansCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eMagazine_BinhLuanLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eMagazine_BinhLuanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_BinhLuanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the e magazine_ binh luan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine_BinhLuan the e magazine_ binh luan
	 * @return the e magazine_ binh luan that was updated
	 */
	@Override
	public qlanphamdb.model.eMagazine_BinhLuan updateeMagazine_BinhLuan(
		qlanphamdb.model.eMagazine_BinhLuan eMagazine_BinhLuan) {

		return _eMagazine_BinhLuanLocalService.updateeMagazine_BinhLuan(
			eMagazine_BinhLuan);
	}

	@Override
	public eMagazine_BinhLuanLocalService getWrappedService() {
		return _eMagazine_BinhLuanLocalService;
	}

	@Override
	public void setWrappedService(
		eMagazine_BinhLuanLocalService eMagazine_BinhLuanLocalService) {

		_eMagazine_BinhLuanLocalService = eMagazine_BinhLuanLocalService;
	}

	private eMagazine_BinhLuanLocalService _eMagazine_BinhLuanLocalService;

}