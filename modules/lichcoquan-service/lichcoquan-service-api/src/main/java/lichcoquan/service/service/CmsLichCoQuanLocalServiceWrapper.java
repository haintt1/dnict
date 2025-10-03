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
 * Provides a wrapper for {@link CmsLichCoQuanLocalService}.
 *
 * @author BinhNT
 * @see CmsLichCoQuanLocalService
 * @generated
 */
public class CmsLichCoQuanLocalServiceWrapper
	implements CmsLichCoQuanLocalService,
			   ServiceWrapper<CmsLichCoQuanLocalService> {

	public CmsLichCoQuanLocalServiceWrapper(
		CmsLichCoQuanLocalService cmsLichCoQuanLocalService) {

		_cmsLichCoQuanLocalService = cmsLichCoQuanLocalService;
	}

	/**
	 * Adds the cms lich co quan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CmsLichCoQuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cmsLichCoQuan the cms lich co quan
	 * @return the cms lich co quan that was added
	 */
	@Override
	public lichcoquan.service.model.CmsLichCoQuan addCmsLichCoQuan(
		lichcoquan.service.model.CmsLichCoQuan cmsLichCoQuan) {

		return _cmsLichCoQuanLocalService.addCmsLichCoQuan(cmsLichCoQuan);
	}

	/**
	 * Creates a new cms lich co quan with the primary key. Does not add the cms lich co quan to the database.
	 *
	 * @param lichCongtacId the primary key for the new cms lich co quan
	 * @return the new cms lich co quan
	 */
	@Override
	public lichcoquan.service.model.CmsLichCoQuan createCmsLichCoQuan(
		long lichCongtacId) {

		return _cmsLichCoQuanLocalService.createCmsLichCoQuan(lichCongtacId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cmsLichCoQuanLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the cms lich co quan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CmsLichCoQuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cmsLichCoQuan the cms lich co quan
	 * @return the cms lich co quan that was removed
	 */
	@Override
	public lichcoquan.service.model.CmsLichCoQuan deleteCmsLichCoQuan(
		lichcoquan.service.model.CmsLichCoQuan cmsLichCoQuan) {

		return _cmsLichCoQuanLocalService.deleteCmsLichCoQuan(cmsLichCoQuan);
	}

	/**
	 * Deletes the cms lich co quan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CmsLichCoQuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lichCongtacId the primary key of the cms lich co quan
	 * @return the cms lich co quan that was removed
	 * @throws PortalException if a cms lich co quan with the primary key could not be found
	 */
	@Override
	public lichcoquan.service.model.CmsLichCoQuan deleteCmsLichCoQuan(
			long lichCongtacId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cmsLichCoQuanLocalService.deleteCmsLichCoQuan(lichCongtacId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cmsLichCoQuanLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cmsLichCoQuanLocalService.dynamicQuery();
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

		return _cmsLichCoQuanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>lichcoquan.service.model.impl.CmsLichCoQuanModelImpl</code>.
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

		return _cmsLichCoQuanLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>lichcoquan.service.model.impl.CmsLichCoQuanModelImpl</code>.
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

		return _cmsLichCoQuanLocalService.dynamicQuery(
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

		return _cmsLichCoQuanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cmsLichCoQuanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public lichcoquan.service.model.CmsLichCoQuan fetchCmsLichCoQuan(
		long lichCongtacId) {

		return _cmsLichCoQuanLocalService.fetchCmsLichCoQuan(lichCongtacId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cmsLichCoQuanLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cms lich co quan with the primary key.
	 *
	 * @param lichCongtacId the primary key of the cms lich co quan
	 * @return the cms lich co quan
	 * @throws PortalException if a cms lich co quan with the primary key could not be found
	 */
	@Override
	public lichcoquan.service.model.CmsLichCoQuan getCmsLichCoQuan(
			long lichCongtacId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cmsLichCoQuanLocalService.getCmsLichCoQuan(lichCongtacId);
	}

	/**
	 * Returns a range of all the cms lich co quans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>lichcoquan.service.model.impl.CmsLichCoQuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cms lich co quans
	 * @param end the upper bound of the range of cms lich co quans (not inclusive)
	 * @return the range of cms lich co quans
	 */
	@Override
	public java.util.List<lichcoquan.service.model.CmsLichCoQuan>
		getCmsLichCoQuans(int start, int end) {

		return _cmsLichCoQuanLocalService.getCmsLichCoQuans(start, end);
	}

	/**
	 * Returns the number of cms lich co quans.
	 *
	 * @return the number of cms lich co quans
	 */
	@Override
	public int getCmsLichCoQuansCount() {
		return _cmsLichCoQuanLocalService.getCmsLichCoQuansCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cmsLichCoQuanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cmsLichCoQuanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cmsLichCoQuanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cms lich co quan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CmsLichCoQuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cmsLichCoQuan the cms lich co quan
	 * @return the cms lich co quan that was updated
	 */
	@Override
	public lichcoquan.service.model.CmsLichCoQuan updateCmsLichCoQuan(
		lichcoquan.service.model.CmsLichCoQuan cmsLichCoQuan) {

		return _cmsLichCoQuanLocalService.updateCmsLichCoQuan(cmsLichCoQuan);
	}

	@Override
	public CmsLichCoQuanLocalService getWrappedService() {
		return _cmsLichCoQuanLocalService;
	}

	@Override
	public void setWrappedService(
		CmsLichCoQuanLocalService cmsLichCoQuanLocalService) {

		_cmsLichCoQuanLocalService = cmsLichCoQuanLocalService;
	}

	private CmsLichCoQuanLocalService _cmsLichCoQuanLocalService;

}