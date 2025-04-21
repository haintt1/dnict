/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link DinhMucLocalService}.
 *
 * @author dnict
 * @see DinhMucLocalService
 * @generated
 */
public class DinhMucLocalServiceWrapper
	implements DinhMucLocalService, ServiceWrapper<DinhMucLocalService> {

	public DinhMucLocalServiceWrapper(DinhMucLocalService dinhMucLocalService) {
		_dinhMucLocalService = dinhMucLocalService;
	}

	/**
	 * Adds the dinh muc to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DinhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dinhMuc the dinh muc
	 * @return the dinh muc that was added
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.DinhMuc addDinhMuc(
		vn.dnict.qlnhuanbut.model.DinhMuc dinhMuc) {

		return _dinhMucLocalService.addDinhMuc(dinhMuc);
	}

	/**
	 * Creates a new dinh muc with the primary key. Does not add the dinh muc to the database.
	 *
	 * @param id the primary key for the new dinh muc
	 * @return the new dinh muc
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.DinhMuc createDinhMuc(long id) {
		return _dinhMucLocalService.createDinhMuc(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dinhMucLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dinh muc from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DinhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dinhMuc the dinh muc
	 * @return the dinh muc that was removed
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.DinhMuc deleteDinhMuc(
		vn.dnict.qlnhuanbut.model.DinhMuc dinhMuc) {

		return _dinhMucLocalService.deleteDinhMuc(dinhMuc);
	}

	/**
	 * Deletes the dinh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DinhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dinh muc
	 * @return the dinh muc that was removed
	 * @throws PortalException if a dinh muc with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.DinhMuc deleteDinhMuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dinhMucLocalService.deleteDinhMuc(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dinhMucLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dinhMucLocalService.dynamicQuery();
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

		return _dinhMucLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.DinhMucModelImpl</code>.
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

		return _dinhMucLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.DinhMucModelImpl</code>.
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

		return _dinhMucLocalService.dynamicQuery(
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

		return _dinhMucLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dinhMucLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.dnict.qlnhuanbut.model.DinhMuc fetchDinhMuc(long id) {
		return _dinhMucLocalService.fetchDinhMuc(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dinhMucLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dinh muc with the primary key.
	 *
	 * @param id the primary key of the dinh muc
	 * @return the dinh muc
	 * @throws PortalException if a dinh muc with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.DinhMuc getDinhMuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dinhMucLocalService.getDinhMuc(id);
	}

	/**
	 * Returns a range of all the dinh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlnhuanbut.model.impl.DinhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinh mucs
	 * @param end the upper bound of the range of dinh mucs (not inclusive)
	 * @return the range of dinh mucs
	 */
	@Override
	public java.util.List<vn.dnict.qlnhuanbut.model.DinhMuc> getDinhMucs(
		int start, int end) {

		return _dinhMucLocalService.getDinhMucs(start, end);
	}

	/**
	 * Returns the number of dinh mucs.
	 *
	 * @return the number of dinh mucs
	 */
	@Override
	public int getDinhMucsCount() {
		return _dinhMucLocalService.getDinhMucsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dinhMucLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dinhMucLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dinhMucLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dinh muc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DinhMucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dinhMuc the dinh muc
	 * @return the dinh muc that was updated
	 */
	@Override
	public vn.dnict.qlnhuanbut.model.DinhMuc updateDinhMuc(
		vn.dnict.qlnhuanbut.model.DinhMuc dinhMuc) {

		return _dinhMucLocalService.updateDinhMuc(dinhMuc);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _dinhMucLocalService.getBasePersistence();
	}

	@Override
	public DinhMucLocalService getWrappedService() {
		return _dinhMucLocalService;
	}

	@Override
	public void setWrappedService(DinhMucLocalService dinhMucLocalService) {
		_dinhMucLocalService = dinhMucLocalService;
	}

	private DinhMucLocalService _dinhMucLocalService;

}