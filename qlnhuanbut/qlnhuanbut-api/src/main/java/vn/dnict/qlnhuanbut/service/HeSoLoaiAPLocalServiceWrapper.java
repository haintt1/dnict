/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link HeSoLoaiAPLocalService}.
 *
 * @author dnict
 * @see HeSoLoaiAPLocalService
 * @generated
 */
public class HeSoLoaiAPLocalServiceWrapper
	implements HeSoLoaiAPLocalService, ServiceWrapper<HeSoLoaiAPLocalService> {

	public HeSoLoaiAPLocalServiceWrapper(
		HeSoLoaiAPLocalService heSoLoaiAPLocalService) {

		_heSoLoaiAPLocalService = heSoLoaiAPLocalService;
	}

	/**
	 * Adds the he so loai ap to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HeSoLoaiAPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param heSoLoaiAP the he so loai ap
	 * @return the he so loai ap that was added
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoLoaiAP addHeSoLoaiAP(
		vn.dnict.qlnhuanbut.model.HeSoLoaiAP heSoLoaiAP) {

		return _heSoLoaiAPLocalService.addHeSoLoaiAP(heSoLoaiAP);
	}

	/**
	 * Creates a new he so loai ap with the primary key. Does not add the he so loai ap to the database.
	 *
	 * @param id the primary key for the new he so loai ap
	 * @return the new he so loai ap
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoLoaiAP createHeSoLoaiAP(long id) {
		return _heSoLoaiAPLocalService.createHeSoLoaiAP(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _heSoLoaiAPLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the he so loai ap from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HeSoLoaiAPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param heSoLoaiAP the he so loai ap
	 * @return the he so loai ap that was removed
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoLoaiAP deleteHeSoLoaiAP(
		vn.dnict.qlnhuanbut.model.HeSoLoaiAP heSoLoaiAP) {

		return _heSoLoaiAPLocalService.deleteHeSoLoaiAP(heSoLoaiAP);
	}

	/**
	 * Deletes the he so loai ap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HeSoLoaiAPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the he so loai ap
	 * @return the he so loai ap that was removed
	 * @throws PortalException if a he so loai ap with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoLoaiAP deleteHeSoLoaiAP(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _heSoLoaiAPLocalService.deleteHeSoLoaiAP(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _heSoLoaiAPLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _heSoLoaiAPLocalService.dynamicQuery();
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

		return _heSoLoaiAPLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.HeSoLoaiAPModelImpl</code>.
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

		return _heSoLoaiAPLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.HeSoLoaiAPModelImpl</code>.
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

		return _heSoLoaiAPLocalService.dynamicQuery(
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

		return _heSoLoaiAPLocalService.dynamicQueryCount(dynamicQuery);
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

		return _heSoLoaiAPLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.qlnhuanbut.model.HeSoLoaiAP fetchHeSoLoaiAP(long id) {
		return _heSoLoaiAPLocalService.fetchHeSoLoaiAP(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _heSoLoaiAPLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the he so loai ap with the primary key.
	 *
	 * @param id the primary key of the he so loai ap
	 * @return the he so loai ap
	 * @throws PortalException if a he so loai ap with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoLoaiAP getHeSoLoaiAP(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _heSoLoaiAPLocalService.getHeSoLoaiAP(id);
	}

	/**
	 * Returns a range of all the he so loai aps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.HeSoLoaiAPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so loai aps
	 * @param end the upper bound of the range of he so loai aps (not inclusive)
	 * @return the range of he so loai aps
	 */
	@Override
	public java.util.List<vn.dnict.qlnhuanbut.model.HeSoLoaiAP> getHeSoLoaiAPs(
		int start, int end) {

		return _heSoLoaiAPLocalService.getHeSoLoaiAPs(start, end);
	}

	/**
	 * Returns the number of he so loai aps.
	 *
	 * @return the number of he so loai aps
	 */
	@Override
	public int getHeSoLoaiAPsCount() {
		return _heSoLoaiAPLocalService.getHeSoLoaiAPsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _heSoLoaiAPLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _heSoLoaiAPLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _heSoLoaiAPLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the he so loai ap in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HeSoLoaiAPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param heSoLoaiAP the he so loai ap
	 * @return the he so loai ap that was updated
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoLoaiAP updateHeSoLoaiAP(
		vn.dnict.qlnhuanbut.model.HeSoLoaiAP heSoLoaiAP) {

		return _heSoLoaiAPLocalService.updateHeSoLoaiAP(heSoLoaiAP);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _heSoLoaiAPLocalService.getBasePersistence();
	}

	@Override
	public HeSoLoaiAPLocalService getWrappedService() {
		return _heSoLoaiAPLocalService;
	}

	@Override
	public void setWrappedService(
		HeSoLoaiAPLocalService heSoLoaiAPLocalService) {

		_heSoLoaiAPLocalService = heSoLoaiAPLocalService;
	}

	private HeSoLoaiAPLocalService _heSoLoaiAPLocalService;

}