/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import vn.dnict.qlgopy.model.emailTemplate;

/**
 * The persistence utility for the email template service. This utility wraps <code>vn.dnict.qlgopy.service.persistence.impl.emailTemplatePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see emailTemplatePersistence
 * @generated
 */
public class emailTemplateUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(emailTemplate emailTemplate) {
		getPersistence().clearCache(emailTemplate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, emailTemplate> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<emailTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<emailTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<emailTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<emailTemplate> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static emailTemplate update(emailTemplate emailTemplate) {
		return getPersistence().update(emailTemplate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static emailTemplate update(
		emailTemplate emailTemplate, ServiceContext serviceContext) {

		return getPersistence().update(emailTemplate, serviceContext);
	}

	/**
	 * Returns all the email templates where loai = &#63;.
	 *
	 * @param loai the loai
	 * @return the matching email templates
	 */
	public static List<emailTemplate> findByloai(int loai) {
		return getPersistence().findByloai(loai);
	}

	/**
	 * Returns a range of all the email templates where loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param loai the loai
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @return the range of matching email templates
	 */
	public static List<emailTemplate> findByloai(int loai, int start, int end) {
		return getPersistence().findByloai(loai, start, end);
	}

	/**
	 * Returns an ordered range of all the email templates where loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param loai the loai
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching email templates
	 */
	public static List<emailTemplate> findByloai(
		int loai, int start, int end,
		OrderByComparator<emailTemplate> orderByComparator) {

		return getPersistence().findByloai(loai, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the email templates where loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param loai the loai
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching email templates
	 */
	public static List<emailTemplate> findByloai(
		int loai, int start, int end,
		OrderByComparator<emailTemplate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByloai(
			loai, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email template
	 * @throws NoSuchemailTemplateException if a matching email template could not be found
	 */
	public static emailTemplate findByloai_First(
			int loai, OrderByComparator<emailTemplate> orderByComparator)
		throws vn.dnict.qlgopy.exception.NoSuchemailTemplateException {

		return getPersistence().findByloai_First(loai, orderByComparator);
	}

	/**
	 * Returns the first email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email template, or <code>null</code> if a matching email template could not be found
	 */
	public static emailTemplate fetchByloai_First(
		int loai, OrderByComparator<emailTemplate> orderByComparator) {

		return getPersistence().fetchByloai_First(loai, orderByComparator);
	}

	/**
	 * Returns the last email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email template
	 * @throws NoSuchemailTemplateException if a matching email template could not be found
	 */
	public static emailTemplate findByloai_Last(
			int loai, OrderByComparator<emailTemplate> orderByComparator)
		throws vn.dnict.qlgopy.exception.NoSuchemailTemplateException {

		return getPersistence().findByloai_Last(loai, orderByComparator);
	}

	/**
	 * Returns the last email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email template, or <code>null</code> if a matching email template could not be found
	 */
	public static emailTemplate fetchByloai_Last(
		int loai, OrderByComparator<emailTemplate> orderByComparator) {

		return getPersistence().fetchByloai_Last(loai, orderByComparator);
	}

	/**
	 * Returns the email templates before and after the current email template in the ordered set where loai = &#63;.
	 *
	 * @param id the primary key of the current email template
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email template
	 * @throws NoSuchemailTemplateException if a email template with the primary key could not be found
	 */
	public static emailTemplate[] findByloai_PrevAndNext(
			long id, int loai,
			OrderByComparator<emailTemplate> orderByComparator)
		throws vn.dnict.qlgopy.exception.NoSuchemailTemplateException {

		return getPersistence().findByloai_PrevAndNext(
			id, loai, orderByComparator);
	}

	/**
	 * Removes all the email templates where loai = &#63; from the database.
	 *
	 * @param loai the loai
	 */
	public static void removeByloai(int loai) {
		getPersistence().removeByloai(loai);
	}

	/**
	 * Returns the number of email templates where loai = &#63;.
	 *
	 * @param loai the loai
	 * @return the number of matching email templates
	 */
	public static int countByloai(int loai) {
		return getPersistence().countByloai(loai);
	}

	/**
	 * Caches the email template in the entity cache if it is enabled.
	 *
	 * @param emailTemplate the email template
	 */
	public static void cacheResult(emailTemplate emailTemplate) {
		getPersistence().cacheResult(emailTemplate);
	}

	/**
	 * Caches the email templates in the entity cache if it is enabled.
	 *
	 * @param emailTemplates the email templates
	 */
	public static void cacheResult(List<emailTemplate> emailTemplates) {
		getPersistence().cacheResult(emailTemplates);
	}

	/**
	 * Creates a new email template with the primary key. Does not add the email template to the database.
	 *
	 * @param id the primary key for the new email template
	 * @return the new email template
	 */
	public static emailTemplate create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the email template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email template
	 * @return the email template that was removed
	 * @throws NoSuchemailTemplateException if a email template with the primary key could not be found
	 */
	public static emailTemplate remove(long id)
		throws vn.dnict.qlgopy.exception.NoSuchemailTemplateException {

		return getPersistence().remove(id);
	}

	public static emailTemplate updateImpl(emailTemplate emailTemplate) {
		return getPersistence().updateImpl(emailTemplate);
	}

	/**
	 * Returns the email template with the primary key or throws a <code>NoSuchemailTemplateException</code> if it could not be found.
	 *
	 * @param id the primary key of the email template
	 * @return the email template
	 * @throws NoSuchemailTemplateException if a email template with the primary key could not be found
	 */
	public static emailTemplate findByPrimaryKey(long id)
		throws vn.dnict.qlgopy.exception.NoSuchemailTemplateException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the email template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the email template
	 * @return the email template, or <code>null</code> if a email template with the primary key could not be found
	 */
	public static emailTemplate fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the email templates.
	 *
	 * @return the email templates
	 */
	public static List<emailTemplate> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the email templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @return the range of email templates
	 */
	public static List<emailTemplate> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the email templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of email templates
	 */
	public static List<emailTemplate> findAll(
		int start, int end,
		OrderByComparator<emailTemplate> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the email templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of email templates
	 */
	public static List<emailTemplate> findAll(
		int start, int end, OrderByComparator<emailTemplate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the email templates from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of email templates.
	 *
	 * @return the number of email templates
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static emailTemplatePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(emailTemplatePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile emailTemplatePersistence _persistence;

}