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

package vn.dnict.tintuc.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link News_SubcategoriesLocalService}.
 *
 * @author dnict
 * @see News_SubcategoriesLocalService
 * @generated
 */
public class News_SubcategoriesLocalServiceWrapper
	implements News_SubcategoriesLocalService,
			   ServiceWrapper<News_SubcategoriesLocalService> {

	public News_SubcategoriesLocalServiceWrapper(
		News_SubcategoriesLocalService news_SubcategoriesLocalService) {

		_news_SubcategoriesLocalService = news_SubcategoriesLocalService;
	}

	/**
	 * Adds the news_ subcategories to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_SubcategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Subcategories the news_ subcategories
	 * @return the news_ subcategories that was added
	 */
	@Override
	public vn.dnict.tintuc.model.News_Subcategories addNews_Subcategories(
		vn.dnict.tintuc.model.News_Subcategories news_Subcategories) {

		return _news_SubcategoriesLocalService.addNews_Subcategories(
			news_Subcategories);
	}

	/**
	 * Creates a new news_ subcategories with the primary key. Does not add the news_ subcategories to the database.
	 *
	 * @param id the primary key for the new news_ subcategories
	 * @return the new news_ subcategories
	 */
	@Override
	public vn.dnict.tintuc.model.News_Subcategories createNews_Subcategories(
		long id) {

		return _news_SubcategoriesLocalService.createNews_Subcategories(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_SubcategoriesLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the news_ subcategories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_SubcategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the news_ subcategories
	 * @return the news_ subcategories that was removed
	 * @throws PortalException if a news_ subcategories with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Subcategories deleteNews_Subcategories(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_SubcategoriesLocalService.deleteNews_Subcategories(id);
	}

	/**
	 * Deletes the news_ subcategories from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_SubcategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Subcategories the news_ subcategories
	 * @return the news_ subcategories that was removed
	 */
	@Override
	public vn.dnict.tintuc.model.News_Subcategories deleteNews_Subcategories(
		vn.dnict.tintuc.model.News_Subcategories news_Subcategories) {

		return _news_SubcategoriesLocalService.deleteNews_Subcategories(
			news_Subcategories);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_SubcategoriesLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _news_SubcategoriesLocalService.dynamicQuery();
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

		return _news_SubcategoriesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_SubcategoriesModelImpl</code>.
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

		return _news_SubcategoriesLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_SubcategoriesModelImpl</code>.
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

		return _news_SubcategoriesLocalService.dynamicQuery(
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

		return _news_SubcategoriesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _news_SubcategoriesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.tintuc.model.News_Subcategories fetchNews_Subcategories(
		long id) {

		return _news_SubcategoriesLocalService.fetchNews_Subcategories(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _news_SubcategoriesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _news_SubcategoriesLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the news_ subcategories with the primary key.
	 *
	 * @param id the primary key of the news_ subcategories
	 * @return the news_ subcategories
	 * @throws PortalException if a news_ subcategories with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Subcategories getNews_Subcategories(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_SubcategoriesLocalService.getNews_Subcategories(id);
	}

	/**
	 * Returns a range of all the news_ subcategorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_SubcategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ subcategorieses
	 * @param end the upper bound of the range of news_ subcategorieses (not inclusive)
	 * @return the range of news_ subcategorieses
	 */
	@Override
	public java.util.List<vn.dnict.tintuc.model.News_Subcategories>
		getNews_Subcategorieses(int start, int end) {

		return _news_SubcategoriesLocalService.getNews_Subcategorieses(
			start, end);
	}

	/**
	 * Returns the number of news_ subcategorieses.
	 *
	 * @return the number of news_ subcategorieses
	 */
	@Override
	public int getNews_SubcategoriesesCount() {
		return _news_SubcategoriesLocalService.getNews_SubcategoriesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _news_SubcategoriesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_SubcategoriesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the news_ subcategories in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_SubcategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Subcategories the news_ subcategories
	 * @return the news_ subcategories that was updated
	 */
	@Override
	public vn.dnict.tintuc.model.News_Subcategories updateNews_Subcategories(
		vn.dnict.tintuc.model.News_Subcategories news_Subcategories) {

		return _news_SubcategoriesLocalService.updateNews_Subcategories(
			news_Subcategories);
	}

	@Override
	public News_SubcategoriesLocalService getWrappedService() {
		return _news_SubcategoriesLocalService;
	}

	@Override
	public void setWrappedService(
		News_SubcategoriesLocalService news_SubcategoriesLocalService) {

		_news_SubcategoriesLocalService = news_SubcategoriesLocalService;
	}

	private News_SubcategoriesLocalService _news_SubcategoriesLocalService;

}