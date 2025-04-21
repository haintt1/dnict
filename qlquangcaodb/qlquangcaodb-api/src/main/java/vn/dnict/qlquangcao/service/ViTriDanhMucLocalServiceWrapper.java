/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ViTriDanhMucLocalService}.
 *
 * @author dnict
 * @see ViTriDanhMucLocalService
 * @generated
 */
public class ViTriDanhMucLocalServiceWrapper
	implements ServiceWrapper<ViTriDanhMucLocalService>,
			   ViTriDanhMucLocalService {

	public ViTriDanhMucLocalServiceWrapper(
		ViTriDanhMucLocalService viTriDanhMucLocalService) {

		_viTriDanhMucLocalService = viTriDanhMucLocalService;
	}

	/**
	 * Adds the vi tri danh muc to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViTriDanhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param viTriDanhMuc the vi tri danh muc
	 * @return the vi tri danh muc that was added
	 */
	@Override
	public vn.dnict.qlquangcao.model.ViTriDanhMuc addViTriDanhMuc(
		vn.dnict.qlquangcao.model.ViTriDanhMuc viTriDanhMuc) {

		return _viTriDanhMucLocalService.addViTriDanhMuc(viTriDanhMuc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viTriDanhMucLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new vi tri danh muc with the primary key. Does not add the vi tri danh muc to the database.
	 *
	 * @param id the primary key for the new vi tri danh muc
	 * @return the new vi tri danh muc
	 */
	@Override
	public vn.dnict.qlquangcao.model.ViTriDanhMuc createViTriDanhMuc(long id) {
		return _viTriDanhMucLocalService.createViTriDanhMuc(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viTriDanhMucLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vi tri danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViTriDanhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc that was removed
	 * @throws PortalException if a vi tri danh muc with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlquangcao.model.ViTriDanhMuc deleteViTriDanhMuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viTriDanhMucLocalService.deleteViTriDanhMuc(id);
	}

	/**
	 * Deletes the vi tri danh muc from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViTriDanhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param viTriDanhMuc the vi tri danh muc
	 * @return the vi tri danh muc that was removed
	 */
	@Override
	public vn.dnict.qlquangcao.model.ViTriDanhMuc deleteViTriDanhMuc(
		vn.dnict.qlquangcao.model.ViTriDanhMuc viTriDanhMuc) {

		return _viTriDanhMucLocalService.deleteViTriDanhMuc(viTriDanhMuc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _viTriDanhMucLocalService.dynamicQuery();
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

		return _viTriDanhMucLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.ViTriDanhMucModelImpl</code>.
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

		return _viTriDanhMucLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.ViTriDanhMucModelImpl</code>.
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

		return _viTriDanhMucLocalService.dynamicQuery(
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

		return _viTriDanhMucLocalService.dynamicQueryCount(dynamicQuery);
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

		return _viTriDanhMucLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.qlquangcao.model.ViTriDanhMuc fetchViTriDanhMuc(long id) {
		return _viTriDanhMucLocalService.fetchViTriDanhMuc(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _viTriDanhMucLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _viTriDanhMucLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _viTriDanhMucLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viTriDanhMucLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vi tri danh muc with the primary key.
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc
	 * @throws PortalException if a vi tri danh muc with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlquangcao.model.ViTriDanhMuc getViTriDanhMuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viTriDanhMucLocalService.getViTriDanhMuc(id);
	}

	/**
	 * Returns a range of all the vi tri danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.ViTriDanhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vi tri danh mucs
	 * @param end the upper bound of the range of vi tri danh mucs (not inclusive)
	 * @return the range of vi tri danh mucs
	 */
	@Override
	public java.util.List<vn.dnict.qlquangcao.model.ViTriDanhMuc>
		getViTriDanhMucs(int start, int end) {

		return _viTriDanhMucLocalService.getViTriDanhMucs(start, end);
	}

	/**
	 * Returns the number of vi tri danh mucs.
	 *
	 * @return the number of vi tri danh mucs
	 */
	@Override
	public int getViTriDanhMucsCount() {
		return _viTriDanhMucLocalService.getViTriDanhMucsCount();
	}

	/**
	 * Updates the vi tri danh muc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViTriDanhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param viTriDanhMuc the vi tri danh muc
	 * @return the vi tri danh muc that was updated
	 */
	@Override
	public vn.dnict.qlquangcao.model.ViTriDanhMuc updateViTriDanhMuc(
		vn.dnict.qlquangcao.model.ViTriDanhMuc viTriDanhMuc) {

		return _viTriDanhMucLocalService.updateViTriDanhMuc(viTriDanhMuc);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _viTriDanhMucLocalService.getBasePersistence();
	}

	@Override
	public ViTriDanhMucLocalService getWrappedService() {
		return _viTriDanhMucLocalService;
	}

	@Override
	public void setWrappedService(
		ViTriDanhMucLocalService viTriDanhMucLocalService) {

		_viTriDanhMucLocalService = viTriDanhMucLocalService;
	}

	private ViTriDanhMucLocalService _viTriDanhMucLocalService;

}