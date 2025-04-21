/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link NhomKHLocalService}.
 *
 * @author dnict
 * @see NhomKHLocalService
 * @generated
 */
public class NhomKHLocalServiceWrapper
	implements NhomKHLocalService, ServiceWrapper<NhomKHLocalService> {

	public NhomKHLocalServiceWrapper(NhomKHLocalService nhomKHLocalService) {
		_nhomKHLocalService = nhomKHLocalService;
	}

	/**
	 * Adds the nhom kh to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NhomKHLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param nhomKH the nhom kh
	 * @return the nhom kh that was added
	 */
	@Override
	public vn.dnict.qlquangcao.model.NhomKH addNhomKH(
		vn.dnict.qlquangcao.model.NhomKH nhomKH) {

		return _nhomKHLocalService.addNhomKH(nhomKH);
	}

	/**
	 * Creates a new nhom kh with the primary key. Does not add the nhom kh to the database.
	 *
	 * @param id the primary key for the new nhom kh
	 * @return the new nhom kh
	 */
	@Override
	public vn.dnict.qlquangcao.model.NhomKH createNhomKH(long id) {
		return _nhomKHLocalService.createNhomKH(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nhomKHLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the nhom kh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NhomKHLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the nhom kh
	 * @return the nhom kh that was removed
	 * @throws PortalException if a nhom kh with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlquangcao.model.NhomKH deleteNhomKH(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nhomKHLocalService.deleteNhomKH(id);
	}

	/**
	 * Deletes the nhom kh from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NhomKHLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param nhomKH the nhom kh
	 * @return the nhom kh that was removed
	 */
	@Override
	public vn.dnict.qlquangcao.model.NhomKH deleteNhomKH(
		vn.dnict.qlquangcao.model.NhomKH nhomKH) {

		return _nhomKHLocalService.deleteNhomKH(nhomKH);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nhomKHLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _nhomKHLocalService.dynamicQuery();
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

		return _nhomKHLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.NhomKHModelImpl</code>.
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

		return _nhomKHLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.NhomKHModelImpl</code>.
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

		return _nhomKHLocalService.dynamicQuery(
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

		return _nhomKHLocalService.dynamicQueryCount(dynamicQuery);
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

		return _nhomKHLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.dnict.qlquangcao.model.NhomKH fetchNhomKH(long id) {
		return _nhomKHLocalService.fetchNhomKH(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _nhomKHLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _nhomKHLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the nhom kh with the primary key.
	 *
	 * @param id the primary key of the nhom kh
	 * @return the nhom kh
	 * @throws PortalException if a nhom kh with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlquangcao.model.NhomKH getNhomKH(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nhomKHLocalService.getNhomKH(id);
	}

	/**
	 * Returns a range of all the nhom khs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.NhomKHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhom khs
	 * @param end the upper bound of the range of nhom khs (not inclusive)
	 * @return the range of nhom khs
	 */
	@Override
	public java.util.List<vn.dnict.qlquangcao.model.NhomKH> getNhomKHs(
		int start, int end) {

		return _nhomKHLocalService.getNhomKHs(start, end);
	}

	/**
	 * Returns the number of nhom khs.
	 *
	 * @return the number of nhom khs
	 */
	@Override
	public int getNhomKHsCount() {
		return _nhomKHLocalService.getNhomKHsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _nhomKHLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nhomKHLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the nhom kh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NhomKHLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param nhomKH the nhom kh
	 * @return the nhom kh that was updated
	 */
	@Override
	public vn.dnict.qlquangcao.model.NhomKH updateNhomKH(
		vn.dnict.qlquangcao.model.NhomKH nhomKH) {

		return _nhomKHLocalService.updateNhomKH(nhomKH);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _nhomKHLocalService.getBasePersistence();
	}

	@Override
	public NhomKHLocalService getWrappedService() {
		return _nhomKHLocalService;
	}

	@Override
	public void setWrappedService(NhomKHLocalService nhomKHLocalService) {
		_nhomKHLocalService = nhomKHLocalService;
	}

	private NhomKHLocalService _nhomKHLocalService;

}