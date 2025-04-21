/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ToChucLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ToChucLocalService
 * @generated
 */
public class ToChucLocalServiceWrapper
	implements ServiceWrapper<ToChucLocalService>, ToChucLocalService {

	public ToChucLocalServiceWrapper(ToChucLocalService toChucLocalService) {
		_toChucLocalService = toChucLocalService;
	}

	/**
	 * Adds the to chuc to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ToChucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param toChuc the to chuc
	 * @return the to chuc that was added
	 */
	@Override
	public com.contact.model.ToChuc addToChuc(com.contact.model.ToChuc toChuc) {
		return _toChucLocalService.addToChuc(toChuc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _toChucLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new to chuc with the primary key. Does not add the to chuc to the database.
	 *
	 * @param tochucId the primary key for the new to chuc
	 * @return the new to chuc
	 */
	@Override
	public com.contact.model.ToChuc createToChuc(long tochucId) {
		return _toChucLocalService.createToChuc(tochucId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _toChucLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the to chuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ToChucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tochucId the primary key of the to chuc
	 * @return the to chuc that was removed
	 * @throws PortalException if a to chuc with the primary key could not be found
	 */
	@Override
	public com.contact.model.ToChuc deleteToChuc(long tochucId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _toChucLocalService.deleteToChuc(tochucId);
	}

	/**
	 * Deletes the to chuc from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ToChucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param toChuc the to chuc
	 * @return the to chuc that was removed
	 */
	@Override
	public com.contact.model.ToChuc deleteToChuc(
		com.contact.model.ToChuc toChuc) {

		return _toChucLocalService.deleteToChuc(toChuc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _toChucLocalService.dynamicQuery();
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

		return _toChucLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.contact.model.impl.ToChucModelImpl</code>.
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

		return _toChucLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.contact.model.impl.ToChucModelImpl</code>.
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

		return _toChucLocalService.dynamicQuery(
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

		return _toChucLocalService.dynamicQueryCount(dynamicQuery);
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

		return _toChucLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.contact.model.ToChuc fetchToChuc(long tochucId) {
		return _toChucLocalService.fetchToChuc(tochucId);
	}

	@Override
	public java.util.List<com.contact.model.ToChuc> findByTen(String ten) {
		return _toChucLocalService.findByTen(ten);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _toChucLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _toChucLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _toChucLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _toChucLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the to chuc with the primary key.
	 *
	 * @param tochucId the primary key of the to chuc
	 * @return the to chuc
	 * @throws PortalException if a to chuc with the primary key could not be found
	 */
	@Override
	public com.contact.model.ToChuc getToChuc(long tochucId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _toChucLocalService.getToChuc(tochucId);
	}

	/**
	 * Returns a range of all the to chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.contact.model.impl.ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @return the range of to chucs
	 */
	@Override
	public java.util.List<com.contact.model.ToChuc> getToChucs(
		int start, int end) {

		return _toChucLocalService.getToChucs(start, end);
	}

	@Override
	public java.util.List<com.contact.model.ToChuc> getToChucs(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.contact.model.ToChuc> comparator) {

		return _toChucLocalService.getToChucs(start, end, comparator);
	}

	/**
	 * Returns the number of to chucs.
	 *
	 * @return the number of to chucs
	 */
	@Override
	public int getToChucsCount() {
		return _toChucLocalService.getToChucsCount();
	}

	/**
	 * Updates the to chuc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ToChucLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param toChuc the to chuc
	 * @return the to chuc that was updated
	 */
	@Override
	public com.contact.model.ToChuc updateToChuc(
		com.contact.model.ToChuc toChuc) {

		return _toChucLocalService.updateToChuc(toChuc);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _toChucLocalService.getBasePersistence();
	}

	@Override
	public ToChucLocalService getWrappedService() {
		return _toChucLocalService;
	}

	@Override
	public void setWrappedService(ToChucLocalService toChucLocalService) {
		_toChucLocalService = toChucLocalService;
	}

	private ToChucLocalService _toChucLocalService;

}