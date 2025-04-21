/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.qlgopy.exception.NoSuchemailTemplateException;
import vn.dnict.qlgopy.model.emailTemplate;

/**
 * The persistence interface for the email template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see emailTemplateUtil
 * @generated
 */
@ProviderType
public interface emailTemplatePersistence
	extends BasePersistence<emailTemplate> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link emailTemplateUtil} to access the email template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the email templates where loai = &#63;.
	 *
	 * @param loai the loai
	 * @return the matching email templates
	 */
	public java.util.List<emailTemplate> findByloai(int loai);

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
	public java.util.List<emailTemplate> findByloai(
		int loai, int start, int end);

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
	public java.util.List<emailTemplate> findByloai(
		int loai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<emailTemplate>
			orderByComparator);

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
	public java.util.List<emailTemplate> findByloai(
		int loai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<emailTemplate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email template
	 * @throws NoSuchemailTemplateException if a matching email template could not be found
	 */
	public emailTemplate findByloai_First(
			int loai,
			com.liferay.portal.kernel.util.OrderByComparator<emailTemplate>
				orderByComparator)
		throws NoSuchemailTemplateException;

	/**
	 * Returns the first email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email template, or <code>null</code> if a matching email template could not be found
	 */
	public emailTemplate fetchByloai_First(
		int loai,
		com.liferay.portal.kernel.util.OrderByComparator<emailTemplate>
			orderByComparator);

	/**
	 * Returns the last email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email template
	 * @throws NoSuchemailTemplateException if a matching email template could not be found
	 */
	public emailTemplate findByloai_Last(
			int loai,
			com.liferay.portal.kernel.util.OrderByComparator<emailTemplate>
				orderByComparator)
		throws NoSuchemailTemplateException;

	/**
	 * Returns the last email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email template, or <code>null</code> if a matching email template could not be found
	 */
	public emailTemplate fetchByloai_Last(
		int loai,
		com.liferay.portal.kernel.util.OrderByComparator<emailTemplate>
			orderByComparator);

	/**
	 * Returns the email templates before and after the current email template in the ordered set where loai = &#63;.
	 *
	 * @param id the primary key of the current email template
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email template
	 * @throws NoSuchemailTemplateException if a email template with the primary key could not be found
	 */
	public emailTemplate[] findByloai_PrevAndNext(
			long id, int loai,
			com.liferay.portal.kernel.util.OrderByComparator<emailTemplate>
				orderByComparator)
		throws NoSuchemailTemplateException;

	/**
	 * Removes all the email templates where loai = &#63; from the database.
	 *
	 * @param loai the loai
	 */
	public void removeByloai(int loai);

	/**
	 * Returns the number of email templates where loai = &#63;.
	 *
	 * @param loai the loai
	 * @return the number of matching email templates
	 */
	public int countByloai(int loai);

	/**
	 * Caches the email template in the entity cache if it is enabled.
	 *
	 * @param emailTemplate the email template
	 */
	public void cacheResult(emailTemplate emailTemplate);

	/**
	 * Caches the email templates in the entity cache if it is enabled.
	 *
	 * @param emailTemplates the email templates
	 */
	public void cacheResult(java.util.List<emailTemplate> emailTemplates);

	/**
	 * Creates a new email template with the primary key. Does not add the email template to the database.
	 *
	 * @param id the primary key for the new email template
	 * @return the new email template
	 */
	public emailTemplate create(long id);

	/**
	 * Removes the email template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email template
	 * @return the email template that was removed
	 * @throws NoSuchemailTemplateException if a email template with the primary key could not be found
	 */
	public emailTemplate remove(long id) throws NoSuchemailTemplateException;

	public emailTemplate updateImpl(emailTemplate emailTemplate);

	/**
	 * Returns the email template with the primary key or throws a <code>NoSuchemailTemplateException</code> if it could not be found.
	 *
	 * @param id the primary key of the email template
	 * @return the email template
	 * @throws NoSuchemailTemplateException if a email template with the primary key could not be found
	 */
	public emailTemplate findByPrimaryKey(long id)
		throws NoSuchemailTemplateException;

	/**
	 * Returns the email template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the email template
	 * @return the email template, or <code>null</code> if a email template with the primary key could not be found
	 */
	public emailTemplate fetchByPrimaryKey(long id);

	/**
	 * Returns all the email templates.
	 *
	 * @return the email templates
	 */
	public java.util.List<emailTemplate> findAll();

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
	public java.util.List<emailTemplate> findAll(int start, int end);

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
	public java.util.List<emailTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<emailTemplate>
			orderByComparator);

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
	public java.util.List<emailTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<emailTemplate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the email templates from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of email templates.
	 *
	 * @return the number of email templates
	 */
	public int countAll();

}