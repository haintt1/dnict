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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import lichcoquan.service.model.CmsLichCoQuan;

/**
 * Provides the local service utility for CmsLichCoQuan. This utility wraps
 * <code>lichcoquan.service.service.impl.CmsLichCoQuanLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BinhNT
 * @see CmsLichCoQuanLocalService
 * @generated
 */
public class CmsLichCoQuanLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>lichcoquan.service.service.impl.CmsLichCoQuanLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static CmsLichCoQuan addCmsLichCoQuan(CmsLichCoQuan cmsLichCoQuan) {
		return getService().addCmsLichCoQuan(cmsLichCoQuan);
	}

	/**
	 * Creates a new cms lich co quan with the primary key. Does not add the cms lich co quan to the database.
	 *
	 * @param lichCongtacId the primary key for the new cms lich co quan
	 * @return the new cms lich co quan
	 */
	public static CmsLichCoQuan createCmsLichCoQuan(long lichCongtacId) {
		return getService().createCmsLichCoQuan(lichCongtacId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static CmsLichCoQuan deleteCmsLichCoQuan(
		CmsLichCoQuan cmsLichCoQuan) {

		return getService().deleteCmsLichCoQuan(cmsLichCoQuan);
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
	public static CmsLichCoQuan deleteCmsLichCoQuan(long lichCongtacId)
		throws PortalException {

		return getService().deleteCmsLichCoQuan(lichCongtacId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CmsLichCoQuan fetchCmsLichCoQuan(long lichCongtacId) {
		return getService().fetchCmsLichCoQuan(lichCongtacId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cms lich co quan with the primary key.
	 *
	 * @param lichCongtacId the primary key of the cms lich co quan
	 * @return the cms lich co quan
	 * @throws PortalException if a cms lich co quan with the primary key could not be found
	 */
	public static CmsLichCoQuan getCmsLichCoQuan(long lichCongtacId)
		throws PortalException {

		return getService().getCmsLichCoQuan(lichCongtacId);
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
	public static List<CmsLichCoQuan> getCmsLichCoQuans(int start, int end) {
		return getService().getCmsLichCoQuans(start, end);
	}

	/**
	 * Returns the number of cms lich co quans.
	 *
	 * @return the number of cms lich co quans
	 */
	public static int getCmsLichCoQuansCount() {
		return getService().getCmsLichCoQuansCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static CmsLichCoQuan updateCmsLichCoQuan(
		CmsLichCoQuan cmsLichCoQuan) {

		return getService().updateCmsLichCoQuan(cmsLichCoQuan);
	}

	public static CmsLichCoQuanLocalService getService() {
		return _service;
	}

	private static volatile CmsLichCoQuanLocalService _service;

}