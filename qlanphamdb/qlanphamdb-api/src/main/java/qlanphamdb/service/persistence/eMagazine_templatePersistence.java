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

package qlanphamdb.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import qlanphamdb.exception.NoSucheMagazine_templateException;

import qlanphamdb.model.eMagazine_template;

/**
 * The persistence interface for the e magazine_template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see eMagazine_templateUtil
 * @generated
 */
@ProviderType
public interface eMagazine_templatePersistence
	extends BasePersistence<eMagazine_template> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link eMagazine_templateUtil} to access the e magazine_template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the e magazine_template in the entity cache if it is enabled.
	 *
	 * @param eMagazine_template the e magazine_template
	 */
	public void cacheResult(eMagazine_template eMagazine_template);

	/**
	 * Caches the e magazine_templates in the entity cache if it is enabled.
	 *
	 * @param eMagazine_templates the e magazine_templates
	 */
	public void cacheResult(
		java.util.List<eMagazine_template> eMagazine_templates);

	/**
	 * Creates a new e magazine_template with the primary key. Does not add the e magazine_template to the database.
	 *
	 * @param id the primary key for the new e magazine_template
	 * @return the new e magazine_template
	 */
	public eMagazine_template create(long id);

	/**
	 * Removes the e magazine_template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the e magazine_template
	 * @return the e magazine_template that was removed
	 * @throws NoSucheMagazine_templateException if a e magazine_template with the primary key could not be found
	 */
	public eMagazine_template remove(long id)
		throws NoSucheMagazine_templateException;

	public eMagazine_template updateImpl(eMagazine_template eMagazine_template);

	/**
	 * Returns the e magazine_template with the primary key or throws a <code>NoSucheMagazine_templateException</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine_template
	 * @return the e magazine_template
	 * @throws NoSucheMagazine_templateException if a e magazine_template with the primary key could not be found
	 */
	public eMagazine_template findByPrimaryKey(long id)
		throws NoSucheMagazine_templateException;

	/**
	 * Returns the e magazine_template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine_template
	 * @return the e magazine_template, or <code>null</code> if a e magazine_template with the primary key could not be found
	 */
	public eMagazine_template fetchByPrimaryKey(long id);

	/**
	 * Returns all the e magazine_templates.
	 *
	 * @return the e magazine_templates
	 */
	public java.util.List<eMagazine_template> findAll();

	/**
	 * Returns a range of all the e magazine_templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_templateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_templates
	 * @param end the upper bound of the range of e magazine_templates (not inclusive)
	 * @return the range of e magazine_templates
	 */
	public java.util.List<eMagazine_template> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the e magazine_templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_templateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_templates
	 * @param end the upper bound of the range of e magazine_templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e magazine_templates
	 */
	public java.util.List<eMagazine_template> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<eMagazine_template>
			orderByComparator);

	/**
	 * Returns an ordered range of all the e magazine_templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_templateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_templates
	 * @param end the upper bound of the range of e magazine_templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of e magazine_templates
	 */
	public java.util.List<eMagazine_template> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<eMagazine_template>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the e magazine_templates from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of e magazine_templates.
	 *
	 * @return the number of e magazine_templates
	 */
	public int countAll();

}