/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PhongBanLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhongBanLocalService
 * @generated
 */
public class PhongBanLocalServiceWrapper
	implements PhongBanLocalService, ServiceWrapper<PhongBanLocalService> {

	public PhongBanLocalServiceWrapper(
		PhongBanLocalService phongBanLocalService) {

		_phongBanLocalService = phongBanLocalService;
	}

	/**
	 * Adds the phong ban to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhongBanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phongBan the phong ban
	 * @return the phong ban that was added
	 */
	@Override
	public com.contact.model.PhongBan addPhongBan(
		com.contact.model.PhongBan phongBan) {

		return _phongBanLocalService.addPhongBan(phongBan);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phongBanLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new phong ban with the primary key. Does not add the phong ban to the database.
	 *
	 * @param phongbanId the primary key for the new phong ban
	 * @return the new phong ban
	 */
	@Override
	public com.contact.model.PhongBan createPhongBan(long phongbanId) {
		return _phongBanLocalService.createPhongBan(phongbanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phongBanLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the phong ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhongBanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phongbanId the primary key of the phong ban
	 * @return the phong ban that was removed
	 * @throws PortalException if a phong ban with the primary key could not be found
	 */
	@Override
	public com.contact.model.PhongBan deletePhongBan(long phongbanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phongBanLocalService.deletePhongBan(phongbanId);
	}

	/**
	 * Deletes the phong ban from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhongBanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phongBan the phong ban
	 * @return the phong ban that was removed
	 */
	@Override
	public com.contact.model.PhongBan deletePhongBan(
		com.contact.model.PhongBan phongBan) {

		return _phongBanLocalService.deletePhongBan(phongBan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phongBanLocalService.dynamicQuery();
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

		return _phongBanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.contact.model.impl.PhongBanModelImpl</code>.
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

		return _phongBanLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.contact.model.impl.PhongBanModelImpl</code>.
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

		return _phongBanLocalService.dynamicQuery(
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

		return _phongBanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _phongBanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.contact.model.PhongBan fetchPhongBan(long phongbanId) {
		return _phongBanLocalService.fetchPhongBan(phongbanId);
	}

	@Override
	public java.util.List<com.contact.model.PhongBan> findByTen(String ten) {
		return _phongBanLocalService.findByTen(ten);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _phongBanLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _phongBanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phongBanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phongBanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the phong ban with the primary key.
	 *
	 * @param phongbanId the primary key of the phong ban
	 * @return the phong ban
	 * @throws PortalException if a phong ban with the primary key could not be found
	 */
	@Override
	public com.contact.model.PhongBan getPhongBan(long phongbanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phongBanLocalService.getPhongBan(phongbanId);
	}

	/**
	 * Returns a range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.contact.model.impl.PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of phong bans
	 */
	@Override
	public java.util.List<com.contact.model.PhongBan> getPhongBans(
		int start, int end) {

		return _phongBanLocalService.getPhongBans(start, end);
	}

	@Override
	public java.util.List<com.contact.model.PhongBan> getPhongBans(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.contact.model.PhongBan> comparator) {

		return _phongBanLocalService.getPhongBans(start, end, comparator);
	}

	/**
	 * Returns the number of phong bans.
	 *
	 * @return the number of phong bans
	 */
	@Override
	public int getPhongBansCount() {
		return _phongBanLocalService.getPhongBansCount();
	}

	/**
	 * Updates the phong ban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhongBanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phongBan the phong ban
	 * @return the phong ban that was updated
	 */
	@Override
	public com.contact.model.PhongBan updatePhongBan(
		com.contact.model.PhongBan phongBan) {

		return _phongBanLocalService.updatePhongBan(phongBan);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _phongBanLocalService.getBasePersistence();
	}

	@Override
	public PhongBanLocalService getWrappedService() {
		return _phongBanLocalService;
	}

	@Override
	public void setWrappedService(PhongBanLocalService phongBanLocalService) {
		_phongBanLocalService = phongBanLocalService;
	}

	private PhongBanLocalService _phongBanLocalService;

}