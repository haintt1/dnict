/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CanBoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CanBoLocalService
 * @generated
 */
public class CanBoLocalServiceWrapper
	implements CanBoLocalService, ServiceWrapper<CanBoLocalService> {

	public CanBoLocalServiceWrapper(CanBoLocalService canBoLocalService) {
		_canBoLocalService = canBoLocalService;
	}

	/**
	 * Adds the can bo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CanBoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param canBo the can bo
	 * @return the can bo that was added
	 */
	@Override
	public com.contact.model.CanBo addCanBo(com.contact.model.CanBo canBo) {
		return _canBoLocalService.addCanBo(canBo);
	}

	/**
	 * Creates a new can bo with the primary key. Does not add the can bo to the database.
	 *
	 * @param canboId the primary key for the new can bo
	 * @return the new can bo
	 */
	@Override
	public com.contact.model.CanBo createCanBo(long canboId) {
		return _canBoLocalService.createCanBo(canboId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _canBoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the can bo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CanBoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param canBo the can bo
	 * @return the can bo that was removed
	 */
	@Override
	public com.contact.model.CanBo deleteCanBo(com.contact.model.CanBo canBo) {
		return _canBoLocalService.deleteCanBo(canBo);
	}

	/**
	 * Deletes the can bo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CanBoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param canboId the primary key of the can bo
	 * @return the can bo that was removed
	 * @throws PortalException if a can bo with the primary key could not be found
	 */
	@Override
	public com.contact.model.CanBo deleteCanBo(long canboId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _canBoLocalService.deleteCanBo(canboId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _canBoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _canBoLocalService.dynamicQuery();
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

		return _canBoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.contact.model.impl.CanBoModelImpl</code>.
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

		return _canBoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.contact.model.impl.CanBoModelImpl</code>.
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

		return _canBoLocalService.dynamicQuery(
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

		return _canBoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _canBoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.contact.model.CanBo fetchCanBo(long canboId) {
		return _canBoLocalService.fetchCanBo(canboId);
	}

	@Override
	public java.util.List<com.contact.model.CanBo> findByten(String ten) {
		return _canBoLocalService.findByten(ten);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _canBoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the can bo with the primary key.
	 *
	 * @param canboId the primary key of the can bo
	 * @return the can bo
	 * @throws PortalException if a can bo with the primary key could not be found
	 */
	@Override
	public com.contact.model.CanBo getCanBo(long canboId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _canBoLocalService.getCanBo(canboId);
	}

	/**
	 * Returns a range of all the can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.contact.model.impl.CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @return the range of can bos
	 */
	@Override
	public java.util.List<com.contact.model.CanBo> getCanBos(
		int start, int end) {

		return _canBoLocalService.getCanBos(start, end);
	}

	@Override
	public java.util.List<com.contact.model.CanBo> getCanBos(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.contact.model.CanBo> comparator) {

		return _canBoLocalService.getCanBos(start, end, comparator);
	}

	/**
	 * Returns the number of can bos.
	 *
	 * @return the number of can bos
	 */
	@Override
	public int getCanBosCount() {
		return _canBoLocalService.getCanBosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _canBoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _canBoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _canBoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the can bo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CanBoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param canBo the can bo
	 * @return the can bo that was updated
	 */
	@Override
	public com.contact.model.CanBo updateCanBo(com.contact.model.CanBo canBo) {
		return _canBoLocalService.updateCanBo(canBo);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _canBoLocalService.getBasePersistence();
	}

	@Override
	public CanBoLocalService getWrappedService() {
		return _canBoLocalService;
	}

	@Override
	public void setWrappedService(CanBoLocalService canBoLocalService) {
		_canBoLocalService = canBoLocalService;
	}

	private CanBoLocalService _canBoLocalService;

}