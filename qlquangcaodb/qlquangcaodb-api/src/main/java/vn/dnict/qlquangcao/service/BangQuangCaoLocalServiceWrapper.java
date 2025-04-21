/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BangQuangCaoLocalService}.
 *
 * @author dnict
 * @see BangQuangCaoLocalService
 * @generated
 */
public class BangQuangCaoLocalServiceWrapper
	implements BangQuangCaoLocalService,
			   ServiceWrapper<BangQuangCaoLocalService> {

	public BangQuangCaoLocalServiceWrapper(
		BangQuangCaoLocalService bangQuangCaoLocalService) {

		_bangQuangCaoLocalService = bangQuangCaoLocalService;
	}

	/**
	 * Adds the bang quang cao to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BangQuangCaoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bangQuangCao the bang quang cao
	 * @return the bang quang cao that was added
	 */
	@Override
	public vn.dnict.qlquangcao.model.BangQuangCao addBangQuangCao(
		vn.dnict.qlquangcao.model.BangQuangCao bangQuangCao) {

		return _bangQuangCaoLocalService.addBangQuangCao(bangQuangCao);
	}

	/**
	 * Creates a new bang quang cao with the primary key. Does not add the bang quang cao to the database.
	 *
	 * @param id the primary key for the new bang quang cao
	 * @return the new bang quang cao
	 */
	@Override
	public vn.dnict.qlquangcao.model.BangQuangCao createBangQuangCao(long id) {
		return _bangQuangCaoLocalService.createBangQuangCao(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bangQuangCaoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the bang quang cao from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BangQuangCaoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bangQuangCao the bang quang cao
	 * @return the bang quang cao that was removed
	 */
	@Override
	public vn.dnict.qlquangcao.model.BangQuangCao deleteBangQuangCao(
		vn.dnict.qlquangcao.model.BangQuangCao bangQuangCao) {

		return _bangQuangCaoLocalService.deleteBangQuangCao(bangQuangCao);
	}

	/**
	 * Deletes the bang quang cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BangQuangCaoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the bang quang cao
	 * @return the bang quang cao that was removed
	 * @throws PortalException if a bang quang cao with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlquangcao.model.BangQuangCao deleteBangQuangCao(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bangQuangCaoLocalService.deleteBangQuangCao(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bangQuangCaoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bangQuangCaoLocalService.dynamicQuery();
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

		return _bangQuangCaoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.BangQuangCaoModelImpl</code>.
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

		return _bangQuangCaoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.BangQuangCaoModelImpl</code>.
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

		return _bangQuangCaoLocalService.dynamicQuery(
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

		return _bangQuangCaoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bangQuangCaoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.qlquangcao.model.BangQuangCao fetchBangQuangCao(long id) {
		return _bangQuangCaoLocalService.fetchBangQuangCao(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bangQuangCaoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the bang quang cao with the primary key.
	 *
	 * @param id the primary key of the bang quang cao
	 * @return the bang quang cao
	 * @throws PortalException if a bang quang cao with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlquangcao.model.BangQuangCao getBangQuangCao(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bangQuangCaoLocalService.getBangQuangCao(id);
	}

	/**
	 * Returns a range of all the bang quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlquangcao.model.impl.BangQuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bang quang caos
	 * @param end the upper bound of the range of bang quang caos (not inclusive)
	 * @return the range of bang quang caos
	 */
	@Override
	public java.util.List<vn.dnict.qlquangcao.model.BangQuangCao>
		getBangQuangCaos(int start, int end) {

		return _bangQuangCaoLocalService.getBangQuangCaos(start, end);
	}

	/**
	 * Returns the number of bang quang caos.
	 *
	 * @return the number of bang quang caos
	 */
	@Override
	public int getBangQuangCaosCount() {
		return _bangQuangCaoLocalService.getBangQuangCaosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bangQuangCaoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bangQuangCaoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bangQuangCaoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the bang quang cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BangQuangCaoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bangQuangCao the bang quang cao
	 * @return the bang quang cao that was updated
	 */
	@Override
	public vn.dnict.qlquangcao.model.BangQuangCao updateBangQuangCao(
		vn.dnict.qlquangcao.model.BangQuangCao bangQuangCao) {

		return _bangQuangCaoLocalService.updateBangQuangCao(bangQuangCao);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bangQuangCaoLocalService.getBasePersistence();
	}

	@Override
	public BangQuangCaoLocalService getWrappedService() {
		return _bangQuangCaoLocalService;
	}

	@Override
	public void setWrappedService(
		BangQuangCaoLocalService bangQuangCaoLocalService) {

		_bangQuangCaoLocalService = bangQuangCaoLocalService;
	}

	private BangQuangCaoLocalService _bangQuangCaoLocalService;

}