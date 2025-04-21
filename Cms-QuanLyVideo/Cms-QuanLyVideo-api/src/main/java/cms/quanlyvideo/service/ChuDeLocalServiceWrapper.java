/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ChuDeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChuDeLocalService
 * @generated
 */
public class ChuDeLocalServiceWrapper
	implements ChuDeLocalService, ServiceWrapper<ChuDeLocalService> {

	public ChuDeLocalServiceWrapper(ChuDeLocalService chuDeLocalService) {
		_chuDeLocalService = chuDeLocalService;
	}

	/**
	 * Adds the chu de to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChuDeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chuDe the chu de
	 * @return the chu de that was added
	 */
	@Override
	public cms.quanlyvideo.model.ChuDe addChuDe(
		cms.quanlyvideo.model.ChuDe chuDe) {

		return _chuDeLocalService.addChuDe(chuDe);
	}

	/**
	 * Creates a new chu de with the primary key. Does not add the chu de to the database.
	 *
	 * @param id the primary key for the new chu de
	 * @return the new chu de
	 */
	@Override
	public cms.quanlyvideo.model.ChuDe createChuDe(long id) {
		return _chuDeLocalService.createChuDe(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chuDeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the chu de from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChuDeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chuDe the chu de
	 * @return the chu de that was removed
	 */
	@Override
	public cms.quanlyvideo.model.ChuDe deleteChuDe(
		cms.quanlyvideo.model.ChuDe chuDe) {

		return _chuDeLocalService.deleteChuDe(chuDe);
	}

	/**
	 * Deletes the chu de with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChuDeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the chu de
	 * @return the chu de that was removed
	 * @throws PortalException if a chu de with the primary key could not be found
	 */
	@Override
	public cms.quanlyvideo.model.ChuDe deleteChuDe(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chuDeLocalService.deleteChuDe(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chuDeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _chuDeLocalService.dynamicQuery();
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

		return _chuDeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cms.quanlyvideo.model.impl.ChuDeModelImpl</code>.
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

		return _chuDeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cms.quanlyvideo.model.impl.ChuDeModelImpl</code>.
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

		return _chuDeLocalService.dynamicQuery(
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

		return _chuDeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _chuDeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cms.quanlyvideo.model.ChuDe fetchChuDe(long id) {
		return _chuDeLocalService.fetchChuDe(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _chuDeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the chu de with the primary key.
	 *
	 * @param id the primary key of the chu de
	 * @return the chu de
	 * @throws PortalException if a chu de with the primary key could not be found
	 */
	@Override
	public cms.quanlyvideo.model.ChuDe getChuDe(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chuDeLocalService.getChuDe(id);
	}

	/**
	 * Returns a range of all the chu des.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cms.quanlyvideo.model.impl.ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @return the range of chu des
	 */
	@Override
	public java.util.List<cms.quanlyvideo.model.ChuDe> getChuDes(
		int start, int end) {

		return _chuDeLocalService.getChuDes(start, end);
	}

	/**
	 * Returns the number of chu des.
	 *
	 * @return the number of chu des
	 */
	@Override
	public int getChuDesCount() {
		return _chuDeLocalService.getChuDesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _chuDeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chuDeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chuDeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the chu de in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChuDeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chuDe the chu de
	 * @return the chu de that was updated
	 */
	@Override
	public cms.quanlyvideo.model.ChuDe updateChuDe(
		cms.quanlyvideo.model.ChuDe chuDe) {

		return _chuDeLocalService.updateChuDe(chuDe);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _chuDeLocalService.getBasePersistence();
	}

	@Override
	public ChuDeLocalService getWrappedService() {
		return _chuDeLocalService;
	}

	@Override
	public void setWrappedService(ChuDeLocalService chuDeLocalService) {
		_chuDeLocalService = chuDeLocalService;
	}

	private ChuDeLocalService _chuDeLocalService;

}