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

package lichcoquan.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LichcoquanLocalService}.
 *
 * @author BinhNT
 * @see LichcoquanLocalService
 * @generated
 */
public class LichcoquanLocalServiceWrapper
	implements LichcoquanLocalService, ServiceWrapper<LichcoquanLocalService> {

	public LichcoquanLocalServiceWrapper(
		LichcoquanLocalService lichcoquanLocalService) {

		_lichcoquanLocalService = lichcoquanLocalService;
	}

	/**
	 * Adds the lichcoquan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LichcoquanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lichcoquan the lichcoquan
	 * @return the lichcoquan that was added
	 */
	@Override
	public lichcoquan.service.model.Lichcoquan addLichcoquan(
		lichcoquan.service.model.Lichcoquan lichcoquan) {

		return _lichcoquanLocalService.addLichcoquan(lichcoquan);
	}

	/**
	 * Creates a new lichcoquan with the primary key. Does not add the lichcoquan to the database.
	 *
	 * @param lichCongtacId the primary key for the new lichcoquan
	 * @return the new lichcoquan
	 */
	@Override
	public lichcoquan.service.model.Lichcoquan createLichcoquan(
		long lichCongtacId) {

		return _lichcoquanLocalService.createLichcoquan(lichCongtacId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichcoquanLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the lichcoquan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LichcoquanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lichcoquan the lichcoquan
	 * @return the lichcoquan that was removed
	 */
	@Override
	public lichcoquan.service.model.Lichcoquan deleteLichcoquan(
		lichcoquan.service.model.Lichcoquan lichcoquan) {

		return _lichcoquanLocalService.deleteLichcoquan(lichcoquan);
	}

	/**
	 * Deletes the lichcoquan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LichcoquanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lichCongtacId the primary key of the lichcoquan
	 * @return the lichcoquan that was removed
	 * @throws PortalException if a lichcoquan with the primary key could not be found
	 */
	@Override
	public lichcoquan.service.model.Lichcoquan deleteLichcoquan(
			long lichCongtacId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichcoquanLocalService.deleteLichcoquan(lichCongtacId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichcoquanLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lichcoquanLocalService.dynamicQuery();
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

		return _lichcoquanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>lichcoquan.service.model.impl.LichcoquanModelImpl</code>.
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

		return _lichcoquanLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>lichcoquan.service.model.impl.LichcoquanModelImpl</code>.
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

		return _lichcoquanLocalService.dynamicQuery(
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

		return _lichcoquanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lichcoquanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public lichcoquan.service.model.Lichcoquan fetchLichcoquan(
		long lichCongtacId) {

		return _lichcoquanLocalService.fetchLichcoquan(lichCongtacId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lichcoquanLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lichcoquanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lichcoquan with the primary key.
	 *
	 * @param lichCongtacId the primary key of the lichcoquan
	 * @return the lichcoquan
	 * @throws PortalException if a lichcoquan with the primary key could not be found
	 */
	@Override
	public lichcoquan.service.model.Lichcoquan getLichcoquan(long lichCongtacId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichcoquanLocalService.getLichcoquan(lichCongtacId);
	}

	/**
	 * Returns a range of all the lichcoquans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>lichcoquan.service.model.impl.LichcoquanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lichcoquans
	 * @param end the upper bound of the range of lichcoquans (not inclusive)
	 * @return the range of lichcoquans
	 */
	@Override
	public java.util.List<lichcoquan.service.model.Lichcoquan> getLichcoquans(
		int start, int end) {

		return _lichcoquanLocalService.getLichcoquans(start, end);
	}

	/**
	 * Returns the number of lichcoquans.
	 *
	 * @return the number of lichcoquans
	 */
	@Override
	public int getLichcoquansCount() {
		return _lichcoquanLocalService.getLichcoquansCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lichcoquanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichcoquanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the lichcoquan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LichcoquanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lichcoquan the lichcoquan
	 * @return the lichcoquan that was updated
	 */
	@Override
	public lichcoquan.service.model.Lichcoquan updateLichcoquan(
		lichcoquan.service.model.Lichcoquan lichcoquan) {

		return _lichcoquanLocalService.updateLichcoquan(lichcoquan);
	}

	@Override
	public LichcoquanLocalService getWrappedService() {
		return _lichcoquanLocalService;
	}

	@Override
	public void setWrappedService(
		LichcoquanLocalService lichcoquanLocalService) {

		_lichcoquanLocalService = lichcoquanLocalService;
	}

	private LichcoquanLocalService _lichcoquanLocalService;

}