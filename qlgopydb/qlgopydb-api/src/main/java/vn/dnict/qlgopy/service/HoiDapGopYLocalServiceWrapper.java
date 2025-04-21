/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link HoiDapGopYLocalService}.
 *
 * @author dnict
 * @see HoiDapGopYLocalService
 * @generated
 */
public class HoiDapGopYLocalServiceWrapper
	implements HoiDapGopYLocalService, ServiceWrapper<HoiDapGopYLocalService> {

	public HoiDapGopYLocalServiceWrapper(
		HoiDapGopYLocalService hoiDapGopYLocalService) {

		_hoiDapGopYLocalService = hoiDapGopYLocalService;
	}

	/**
	 * Adds the hoi dap gop y to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HoiDapGopYLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hoiDapGopY the hoi dap gop y
	 * @return the hoi dap gop y that was added
	 */
	@Override
	public vn.dnict.qlgopy.model.HoiDapGopY addHoiDapGopY(
		vn.dnict.qlgopy.model.HoiDapGopY hoiDapGopY) {

		return _hoiDapGopYLocalService.addHoiDapGopY(hoiDapGopY);
	}

	/**
	 * Creates a new hoi dap gop y with the primary key. Does not add the hoi dap gop y to the database.
	 *
	 * @param id the primary key for the new hoi dap gop y
	 * @return the new hoi dap gop y
	 */
	@Override
	public vn.dnict.qlgopy.model.HoiDapGopY createHoiDapGopY(long id) {
		return _hoiDapGopYLocalService.createHoiDapGopY(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hoiDapGopYLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the hoi dap gop y from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HoiDapGopYLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hoiDapGopY the hoi dap gop y
	 * @return the hoi dap gop y that was removed
	 */
	@Override
	public vn.dnict.qlgopy.model.HoiDapGopY deleteHoiDapGopY(
		vn.dnict.qlgopy.model.HoiDapGopY hoiDapGopY) {

		return _hoiDapGopYLocalService.deleteHoiDapGopY(hoiDapGopY);
	}

	/**
	 * Deletes the hoi dap gop y with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HoiDapGopYLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the hoi dap gop y
	 * @return the hoi dap gop y that was removed
	 * @throws PortalException if a hoi dap gop y with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlgopy.model.HoiDapGopY deleteHoiDapGopY(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hoiDapGopYLocalService.deleteHoiDapGopY(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hoiDapGopYLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _hoiDapGopYLocalService.dynamicQuery();
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

		return _hoiDapGopYLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.HoiDapGopYModelImpl</code>.
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

		return _hoiDapGopYLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.HoiDapGopYModelImpl</code>.
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

		return _hoiDapGopYLocalService.dynamicQuery(
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

		return _hoiDapGopYLocalService.dynamicQueryCount(dynamicQuery);
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

		return _hoiDapGopYLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.qlgopy.model.HoiDapGopY fetchHoiDapGopY(long id) {
		return _hoiDapGopYLocalService.fetchHoiDapGopY(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _hoiDapGopYLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the hoi dap gop y with the primary key.
	 *
	 * @param id the primary key of the hoi dap gop y
	 * @return the hoi dap gop y
	 * @throws PortalException if a hoi dap gop y with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlgopy.model.HoiDapGopY getHoiDapGopY(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hoiDapGopYLocalService.getHoiDapGopY(id);
	}

	/**
	 * Returns a range of all the hoi dap gop ies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.HoiDapGopYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hoi dap gop ies
	 * @param end the upper bound of the range of hoi dap gop ies (not inclusive)
	 * @return the range of hoi dap gop ies
	 */
	@Override
	public java.util.List<vn.dnict.qlgopy.model.HoiDapGopY> getHoiDapGopYs(
		int start, int end) {

		return _hoiDapGopYLocalService.getHoiDapGopYs(start, end);
	}

	/**
	 * Returns the number of hoi dap gop ies.
	 *
	 * @return the number of hoi dap gop ies
	 */
	@Override
	public int getHoiDapGopYsCount() {
		return _hoiDapGopYLocalService.getHoiDapGopYsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _hoiDapGopYLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _hoiDapGopYLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hoiDapGopYLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the hoi dap gop y in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HoiDapGopYLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hoiDapGopY the hoi dap gop y
	 * @return the hoi dap gop y that was updated
	 */
	@Override
	public vn.dnict.qlgopy.model.HoiDapGopY updateHoiDapGopY(
		vn.dnict.qlgopy.model.HoiDapGopY hoiDapGopY) {

		return _hoiDapGopYLocalService.updateHoiDapGopY(hoiDapGopY);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _hoiDapGopYLocalService.getBasePersistence();
	}

	@Override
	public HoiDapGopYLocalService getWrappedService() {
		return _hoiDapGopYLocalService;
	}

	@Override
	public void setWrappedService(
		HoiDapGopYLocalService hoiDapGopYLocalService) {

		_hoiDapGopYLocalService = hoiDapGopYLocalService;
	}

	private HoiDapGopYLocalService _hoiDapGopYLocalService;

}