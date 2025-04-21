/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link GopY_DinhKemLocalService}.
 *
 * @author dnict
 * @see GopY_DinhKemLocalService
 * @generated
 */
public class GopY_DinhKemLocalServiceWrapper
	implements GopY_DinhKemLocalService,
			   ServiceWrapper<GopY_DinhKemLocalService> {

	public GopY_DinhKemLocalServiceWrapper(
		GopY_DinhKemLocalService gopY_DinhKemLocalService) {

		_gopY_DinhKemLocalService = gopY_DinhKemLocalService;
	}

	/**
	 * Adds the gop y_ dinh kem to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GopY_DinhKemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gopY_DinhKem the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was added
	 */
	@Override
	public vn.dnict.qlgopy.model.GopY_DinhKem addGopY_DinhKem(
		vn.dnict.qlgopy.model.GopY_DinhKem gopY_DinhKem) {

		return _gopY_DinhKemLocalService.addGopY_DinhKem(gopY_DinhKem);
	}

	/**
	 * Creates a new gop y_ dinh kem with the primary key. Does not add the gop y_ dinh kem to the database.
	 *
	 * @param id the primary key for the new gop y_ dinh kem
	 * @return the new gop y_ dinh kem
	 */
	@Override
	public vn.dnict.qlgopy.model.GopY_DinhKem createGopY_DinhKem(long id) {
		return _gopY_DinhKemLocalService.createGopY_DinhKem(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gopY_DinhKemLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the gop y_ dinh kem from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GopY_DinhKemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gopY_DinhKem the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was removed
	 */
	@Override
	public vn.dnict.qlgopy.model.GopY_DinhKem deleteGopY_DinhKem(
		vn.dnict.qlgopy.model.GopY_DinhKem gopY_DinhKem) {

		return _gopY_DinhKemLocalService.deleteGopY_DinhKem(gopY_DinhKem);
	}

	/**
	 * Deletes the gop y_ dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GopY_DinhKemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was removed
	 * @throws PortalException if a gop y_ dinh kem with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlgopy.model.GopY_DinhKem deleteGopY_DinhKem(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gopY_DinhKemLocalService.deleteGopY_DinhKem(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gopY_DinhKemLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gopY_DinhKemLocalService.dynamicQuery();
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

		return _gopY_DinhKemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.GopY_DinhKemModelImpl</code>.
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

		return _gopY_DinhKemLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.GopY_DinhKemModelImpl</code>.
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

		return _gopY_DinhKemLocalService.dynamicQuery(
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

		return _gopY_DinhKemLocalService.dynamicQueryCount(dynamicQuery);
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

		return _gopY_DinhKemLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.qlgopy.model.GopY_DinhKem fetchGopY_DinhKem(long id) {
		return _gopY_DinhKemLocalService.fetchGopY_DinhKem(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gopY_DinhKemLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the gop y_ dinh kem with the primary key.
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem
	 * @throws PortalException if a gop y_ dinh kem with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlgopy.model.GopY_DinhKem getGopY_DinhKem(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gopY_DinhKemLocalService.getGopY_DinhKem(id);
	}

	/**
	 * Returns a range of all the gop y_ dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.GopY_DinhKemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gop y_ dinh kems
	 * @param end the upper bound of the range of gop y_ dinh kems (not inclusive)
	 * @return the range of gop y_ dinh kems
	 */
	@Override
	public java.util.List<vn.dnict.qlgopy.model.GopY_DinhKem> getGopY_DinhKems(
		int start, int end) {

		return _gopY_DinhKemLocalService.getGopY_DinhKems(start, end);
	}

	/**
	 * Returns the number of gop y_ dinh kems.
	 *
	 * @return the number of gop y_ dinh kems
	 */
	@Override
	public int getGopY_DinhKemsCount() {
		return _gopY_DinhKemLocalService.getGopY_DinhKemsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gopY_DinhKemLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gopY_DinhKemLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gopY_DinhKemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the gop y_ dinh kem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GopY_DinhKemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gopY_DinhKem the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was updated
	 */
	@Override
	public vn.dnict.qlgopy.model.GopY_DinhKem updateGopY_DinhKem(
		vn.dnict.qlgopy.model.GopY_DinhKem gopY_DinhKem) {

		return _gopY_DinhKemLocalService.updateGopY_DinhKem(gopY_DinhKem);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _gopY_DinhKemLocalService.getBasePersistence();
	}

	@Override
	public GopY_DinhKemLocalService getWrappedService() {
		return _gopY_DinhKemLocalService;
	}

	@Override
	public void setWrappedService(
		GopY_DinhKemLocalService gopY_DinhKemLocalService) {

		_gopY_DinhKemLocalService = gopY_DinhKemLocalService;
	}

	private GopY_DinhKemLocalService _gopY_DinhKemLocalService;

}