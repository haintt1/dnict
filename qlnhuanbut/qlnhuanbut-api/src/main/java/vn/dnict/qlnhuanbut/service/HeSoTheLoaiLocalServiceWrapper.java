/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link HeSoTheLoaiLocalService}.
 *
 * @author dnict
 * @see HeSoTheLoaiLocalService
 * @generated
 */
public class HeSoTheLoaiLocalServiceWrapper
	implements HeSoTheLoaiLocalService,
			   ServiceWrapper<HeSoTheLoaiLocalService> {

	public HeSoTheLoaiLocalServiceWrapper(
		HeSoTheLoaiLocalService heSoTheLoaiLocalService) {

		_heSoTheLoaiLocalService = heSoTheLoaiLocalService;
	}

	/**
	 * Adds the he so the loai to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HeSoTheLoaiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param heSoTheLoai the he so the loai
	 * @return the he so the loai that was added
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoTheLoai addHeSoTheLoai(
		vn.dnict.qlnhuanbut.model.HeSoTheLoai heSoTheLoai) {

		return _heSoTheLoaiLocalService.addHeSoTheLoai(heSoTheLoai);
	}

	/**
	 * Creates a new he so the loai with the primary key. Does not add the he so the loai to the database.
	 *
	 * @param id the primary key for the new he so the loai
	 * @return the new he so the loai
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoTheLoai createHeSoTheLoai(long id) {
		return _heSoTheLoaiLocalService.createHeSoTheLoai(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _heSoTheLoaiLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the he so the loai from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HeSoTheLoaiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param heSoTheLoai the he so the loai
	 * @return the he so the loai that was removed
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoTheLoai deleteHeSoTheLoai(
		vn.dnict.qlnhuanbut.model.HeSoTheLoai heSoTheLoai) {

		return _heSoTheLoaiLocalService.deleteHeSoTheLoai(heSoTheLoai);
	}

	/**
	 * Deletes the he so the loai with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HeSoTheLoaiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the he so the loai
	 * @return the he so the loai that was removed
	 * @throws PortalException if a he so the loai with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoTheLoai deleteHeSoTheLoai(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _heSoTheLoaiLocalService.deleteHeSoTheLoai(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _heSoTheLoaiLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _heSoTheLoaiLocalService.dynamicQuery();
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

		return _heSoTheLoaiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.HeSoTheLoaiModelImpl</code>.
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

		return _heSoTheLoaiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.HeSoTheLoaiModelImpl</code>.
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

		return _heSoTheLoaiLocalService.dynamicQuery(
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

		return _heSoTheLoaiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _heSoTheLoaiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.qlnhuanbut.model.HeSoTheLoai fetchHeSoTheLoai(long id) {
		return _heSoTheLoaiLocalService.fetchHeSoTheLoai(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _heSoTheLoaiLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the he so the loai with the primary key.
	 *
	 * @param id the primary key of the he so the loai
	 * @return the he so the loai
	 * @throws PortalException if a he so the loai with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoTheLoai getHeSoTheLoai(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _heSoTheLoaiLocalService.getHeSoTheLoai(id);
	}

	/**
	 * Returns a range of all the he so the loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.HeSoTheLoaiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so the loais
	 * @param end the upper bound of the range of he so the loais (not inclusive)
	 * @return the range of he so the loais
	 */
	@Override
	public java.util.List<vn.dnict.qlnhuanbut.model.HeSoTheLoai>
		getHeSoTheLoais(int start, int end) {

		return _heSoTheLoaiLocalService.getHeSoTheLoais(start, end);
	}

	/**
	 * Returns the number of he so the loais.
	 *
	 * @return the number of he so the loais
	 */
	@Override
	public int getHeSoTheLoaisCount() {
		return _heSoTheLoaiLocalService.getHeSoTheLoaisCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _heSoTheLoaiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _heSoTheLoaiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _heSoTheLoaiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the he so the loai in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HeSoTheLoaiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param heSoTheLoai the he so the loai
	 * @return the he so the loai that was updated
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.HeSoTheLoai updateHeSoTheLoai(
		vn.dnict.qlnhuanbut.model.HeSoTheLoai heSoTheLoai) {

		return _heSoTheLoaiLocalService.updateHeSoTheLoai(heSoTheLoai);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _heSoTheLoaiLocalService.getBasePersistence();
	}

	@Override
	public HeSoTheLoaiLocalService getWrappedService() {
		return _heSoTheLoaiLocalService;
	}

	@Override
	public void setWrappedService(
		HeSoTheLoaiLocalService heSoTheLoaiLocalService) {

		_heSoTheLoaiLocalService = heSoTheLoaiLocalService;
	}

	private HeSoTheLoaiLocalService _heSoTheLoaiLocalService;

}