/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ThongKeNBLocalService}.
 *
 * @author dnict
 * @see ThongKeNBLocalService
 * @generated
 */
public class ThongKeNBLocalServiceWrapper
	implements ServiceWrapper<ThongKeNBLocalService>, ThongKeNBLocalService {

	public ThongKeNBLocalServiceWrapper(
		ThongKeNBLocalService thongKeNBLocalService) {

		_thongKeNBLocalService = thongKeNBLocalService;
	}

	/**
	 * Adds the thong ke nb to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThongKeNBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param thongKeNB the thong ke nb
	 * @return the thong ke nb that was added
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.ThongKeNB addThongKeNB(
		vn.dnict.qlnhuanbut.model.ThongKeNB thongKeNB) {

		return _thongKeNBLocalService.addThongKeNB(thongKeNB);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongKeNBLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new thong ke nb with the primary key. Does not add the thong ke nb to the database.
	 *
	 * @param id the primary key for the new thong ke nb
	 * @return the new thong ke nb
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.ThongKeNB createThongKeNB(long id) {
		return _thongKeNBLocalService.createThongKeNB(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongKeNBLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the thong ke nb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThongKeNBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the thong ke nb
	 * @return the thong ke nb that was removed
	 * @throws PortalException if a thong ke nb with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.ThongKeNB deleteThongKeNB(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongKeNBLocalService.deleteThongKeNB(id);
	}

	/**
	 * Deletes the thong ke nb from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThongKeNBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param thongKeNB the thong ke nb
	 * @return the thong ke nb that was removed
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.ThongKeNB deleteThongKeNB(
		vn.dnict.qlnhuanbut.model.ThongKeNB thongKeNB) {

		return _thongKeNBLocalService.deleteThongKeNB(thongKeNB);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _thongKeNBLocalService.dynamicQuery();
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

		return _thongKeNBLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.ThongKeNBModelImpl</code>.
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

		return _thongKeNBLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.ThongKeNBModelImpl</code>.
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

		return _thongKeNBLocalService.dynamicQuery(
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

		return _thongKeNBLocalService.dynamicQueryCount(dynamicQuery);
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

		return _thongKeNBLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.qlnhuanbut.model.ThongKeNB fetchThongKeNB(long id) {
		return _thongKeNBLocalService.fetchThongKeNB(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _thongKeNBLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _thongKeNBLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _thongKeNBLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongKeNBLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the thong ke nb with the primary key.
	 *
	 * @param id the primary key of the thong ke nb
	 * @return the thong ke nb
	 * @throws PortalException if a thong ke nb with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.ThongKeNB getThongKeNB(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongKeNBLocalService.getThongKeNB(id);
	}

	/**
	 * Returns a range of all the thong ke nbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.ThongKeNBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong ke nbs
	 * @param end the upper bound of the range of thong ke nbs (not inclusive)
	 * @return the range of thong ke nbs
	 */
	@Override
	public java.util.List<vn.dnict.qlnhuanbut.model.ThongKeNB> getThongKeNBs(
		int start, int end) {

		return _thongKeNBLocalService.getThongKeNBs(start, end);
	}

	/**
	 * Returns the number of thong ke nbs.
	 *
	 * @return the number of thong ke nbs
	 */
	@Override
	public int getThongKeNBsCount() {
		return _thongKeNBLocalService.getThongKeNBsCount();
	}

	/**
	 * Updates the thong ke nb in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThongKeNBLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param thongKeNB the thong ke nb
	 * @return the thong ke nb that was updated
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.ThongKeNB updateThongKeNB(
		vn.dnict.qlnhuanbut.model.ThongKeNB thongKeNB) {

		return _thongKeNBLocalService.updateThongKeNB(thongKeNB);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _thongKeNBLocalService.getBasePersistence();
	}

	@Override
	public ThongKeNBLocalService getWrappedService() {
		return _thongKeNBLocalService;
	}

	@Override
	public void setWrappedService(ThongKeNBLocalService thongKeNBLocalService) {
		_thongKeNBLocalService = thongKeNBLocalService;
	}

	private ThongKeNBLocalService _thongKeNBLocalService;

}