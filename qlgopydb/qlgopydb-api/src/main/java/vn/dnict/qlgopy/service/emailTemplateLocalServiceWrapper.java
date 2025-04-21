/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link emailTemplateLocalService}.
 *
 * @author dnict
 * @see emailTemplateLocalService
 * @generated
 */
public class emailTemplateLocalServiceWrapper
	implements emailTemplateLocalService,
			   ServiceWrapper<emailTemplateLocalService> {

	public emailTemplateLocalServiceWrapper(
		emailTemplateLocalService emailTemplateLocalService) {

		_emailTemplateLocalService = emailTemplateLocalService;
	}

	/**
	 * Adds the email template to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect emailTemplateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailTemplate the email template
	 * @return the email template that was added
	 */
	@Override
	public vn.dnict.qlgopy.model.emailTemplate addemailTemplate(
		vn.dnict.qlgopy.model.emailTemplate emailTemplate) {

		return _emailTemplateLocalService.addemailTemplate(emailTemplate);
	}

	/**
	 * Creates a new email template with the primary key. Does not add the email template to the database.
	 *
	 * @param id the primary key for the new email template
	 * @return the new email template
	 */
	@Override
	public vn.dnict.qlgopy.model.emailTemplate createemailTemplate(long id) {
		return _emailTemplateLocalService.createemailTemplate(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailTemplateLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the email template from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect emailTemplateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailTemplate the email template
	 * @return the email template that was removed
	 */
	@Override
	public vn.dnict.qlgopy.model.emailTemplate deleteemailTemplate(
		vn.dnict.qlgopy.model.emailTemplate emailTemplate) {

		return _emailTemplateLocalService.deleteemailTemplate(emailTemplate);
	}

	/**
	 * Deletes the email template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect emailTemplateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the email template
	 * @return the email template that was removed
	 * @throws PortalException if a email template with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlgopy.model.emailTemplate deleteemailTemplate(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailTemplateLocalService.deleteemailTemplate(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailTemplateLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emailTemplateLocalService.dynamicQuery();
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

		return _emailTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.emailTemplateModelImpl</code>.
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

		return _emailTemplateLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.emailTemplateModelImpl</code>.
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

		return _emailTemplateLocalService.dynamicQuery(
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

		return _emailTemplateLocalService.dynamicQueryCount(dynamicQuery);
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

		return _emailTemplateLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.qlgopy.model.emailTemplate fetchemailTemplate(long id) {
		return _emailTemplateLocalService.fetchemailTemplate(id);
	}

	@Override
	public java.util.List<vn.dnict.qlgopy.model.emailTemplate> findByloai(
		int loai) {

		return _emailTemplateLocalService.findByloai(loai);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _emailTemplateLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the email template with the primary key.
	 *
	 * @param id the primary key of the email template
	 * @return the email template
	 * @throws PortalException if a email template with the primary key could not be found
	 */
	@Override
	public vn.dnict.qlgopy.model.emailTemplate getemailTemplate(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailTemplateLocalService.getemailTemplate(id);
	}

	/**
	 * Returns a range of all the email templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.qlgopy.model.impl.emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @return the range of email templates
	 */
	@Override
	public java.util.List<vn.dnict.qlgopy.model.emailTemplate>
		getemailTemplates(int start, int end) {

		return _emailTemplateLocalService.getemailTemplates(start, end);
	}

	/**
	 * Returns the number of email templates.
	 *
	 * @return the number of email templates
	 */
	@Override
	public int getemailTemplatesCount() {
		return _emailTemplateLocalService.getemailTemplatesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _emailTemplateLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _emailTemplateLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emailTemplateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the email template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect emailTemplateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emailTemplate the email template
	 * @return the email template that was updated
	 */
	@Override
	public vn.dnict.qlgopy.model.emailTemplate updateemailTemplate(
		vn.dnict.qlgopy.model.emailTemplate emailTemplate) {

		return _emailTemplateLocalService.updateemailTemplate(emailTemplate);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _emailTemplateLocalService.getBasePersistence();
	}

	@Override
	public emailTemplateLocalService getWrappedService() {
		return _emailTemplateLocalService;
	}

	@Override
	public void setWrappedService(
		emailTemplateLocalService emailTemplateLocalService) {

		_emailTemplateLocalService = emailTemplateLocalService;
	}

	private emailTemplateLocalService _emailTemplateLocalService;

}