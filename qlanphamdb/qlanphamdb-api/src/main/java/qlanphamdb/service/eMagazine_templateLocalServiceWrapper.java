/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package qlanphamdb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link eMagazine_templateLocalService}.
 *
 * @author dnict
 * @see eMagazine_templateLocalService
 * @generated
 */
public class eMagazine_templateLocalServiceWrapper
	implements eMagazine_templateLocalService,
			   ServiceWrapper<eMagazine_templateLocalService> {

	public eMagazine_templateLocalServiceWrapper(
		eMagazine_templateLocalService eMagazine_templateLocalService) {

		_eMagazine_templateLocalService = eMagazine_templateLocalService;
	}

	/**
	 * Adds the e magazine_template to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_templateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine_template the e magazine_template
	 * @return the e magazine_template that was added
	 */
	@Override
	public qlanphamdb.model.eMagazine_template addeMagazine_template(
		qlanphamdb.model.eMagazine_template eMagazine_template) {

		return _eMagazine_templateLocalService.addeMagazine_template(
			eMagazine_template);
	}

	/**
	 * Creates a new e magazine_template with the primary key. Does not add the e magazine_template to the database.
	 *
	 * @param id the primary key for the new e magazine_template
	 * @return the new e magazine_template
	 */
	@Override
	public qlanphamdb.model.eMagazine_template createeMagazine_template(
		long id) {

		return _eMagazine_templateLocalService.createeMagazine_template(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_templateLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the e magazine_template from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_templateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine_template the e magazine_template
	 * @return the e magazine_template that was removed
	 */
	@Override
	public qlanphamdb.model.eMagazine_template deleteeMagazine_template(
		qlanphamdb.model.eMagazine_template eMagazine_template) {

		return _eMagazine_templateLocalService.deleteeMagazine_template(
			eMagazine_template);
	}

	/**
	 * Deletes the e magazine_template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_templateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the e magazine_template
	 * @return the e magazine_template that was removed
	 * @throws PortalException if a e magazine_template with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.eMagazine_template deleteeMagazine_template(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_templateLocalService.deleteeMagazine_template(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_templateLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eMagazine_templateLocalService.dynamicQuery();
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

		return _eMagazine_templateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazine_templateModelImpl</code>.
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

		return _eMagazine_templateLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazine_templateModelImpl</code>.
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

		return _eMagazine_templateLocalService.dynamicQuery(
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

		return _eMagazine_templateLocalService.dynamicQueryCount(dynamicQuery);
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

		return _eMagazine_templateLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public qlanphamdb.model.eMagazine_template fetcheMagazine_template(
		long id) {

		return _eMagazine_templateLocalService.fetcheMagazine_template(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eMagazine_templateLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the e magazine_template with the primary key.
	 *
	 * @param id the primary key of the e magazine_template
	 * @return the e magazine_template
	 * @throws PortalException if a e magazine_template with the primary key could not be found
	 */
	@Override
	public qlanphamdb.model.eMagazine_template geteMagazine_template(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_templateLocalService.geteMagazine_template(id);
	}

	/**
	 * Returns a range of all the e magazine_templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>qlanphamdb.model.impl.eMagazine_templateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_templates
	 * @param end the upper bound of the range of e magazine_templates (not inclusive)
	 * @return the range of e magazine_templates
	 */
	@Override
	public java.util.List<qlanphamdb.model.eMagazine_template>
		geteMagazine_templates(int start, int end) {

		return _eMagazine_templateLocalService.geteMagazine_templates(
			start, end);
	}

	/**
	 * Returns the number of e magazine_templates.
	 *
	 * @return the number of e magazine_templates
	 */
	@Override
	public int geteMagazine_templatesCount() {
		return _eMagazine_templateLocalService.geteMagazine_templatesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eMagazine_templateLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eMagazine_templateLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eMagazine_templateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the e magazine_template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect eMagazine_templateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eMagazine_template the e magazine_template
	 * @return the e magazine_template that was updated
	 */
	@Override
	public qlanphamdb.model.eMagazine_template updateeMagazine_template(
		qlanphamdb.model.eMagazine_template eMagazine_template) {

		return _eMagazine_templateLocalService.updateeMagazine_template(
			eMagazine_template);
	}

	@Override
	public eMagazine_templateLocalService getWrappedService() {
		return _eMagazine_templateLocalService;
	}

	@Override
	public void setWrappedService(
		eMagazine_templateLocalService eMagazine_templateLocalService) {

		_eMagazine_templateLocalService = eMagazine_templateLocalService;
	}

	private eMagazine_templateLocalService _eMagazine_templateLocalService;

}