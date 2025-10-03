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
 * Provides a wrapper for {@link News_CategoriesLocalService}.
 *
 * @author dnict
 * @see News_CategoriesLocalService
 * @generated
 */
public class News_CategoriesLocalServiceWrapper
	implements News_CategoriesLocalService,
			   ServiceWrapper<News_CategoriesLocalService> {

	public News_CategoriesLocalServiceWrapper(
		News_CategoriesLocalService news_CategoriesLocalService) {

		_news_CategoriesLocalService = news_CategoriesLocalService;
	}

	/**
	 * Adds the news_ categories to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_CategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Categories the news_ categories
	 * @return the news_ categories that was added
	 */
	@Override
	public vn.dnict.tintuc.model.News_Categories addNews_Categories(
		vn.dnict.tintuc.model.News_Categories news_Categories) {

		return _news_CategoriesLocalService.addNews_Categories(news_Categories);
	}

	/**
	 * Creates a new news_ categories with the primary key. Does not add the news_ categories to the database.
	 *
	 * @param id the primary key for the new news_ categories
	 * @return the new news_ categories
	 */
	@Override
	public vn.dnict.tintuc.model.News_Categories createNews_Categories(
		long id) {

		return _news_CategoriesLocalService.createNews_Categories(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_CategoriesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the news_ categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_CategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the news_ categories
	 * @return the news_ categories that was removed
	 * @throws PortalException if a news_ categories with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Categories deleteNews_Categories(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_CategoriesLocalService.deleteNews_Categories(id);
	}

	/**
	 * Deletes the news_ categories from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_CategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Categories the news_ categories
	 * @return the news_ categories that was removed
	 */
	@Override
	public vn.dnict.tintuc.model.News_Categories deleteNews_Categories(
		vn.dnict.tintuc.model.News_Categories news_Categories) {

		return _news_CategoriesLocalService.deleteNews_Categories(
			news_Categories);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_CategoriesLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _news_CategoriesLocalService.dynamicQuery();
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

		return _news_CategoriesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_CategoriesModelImpl</code>.
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

		return _news_CategoriesLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_CategoriesModelImpl</code>.
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

		return _news_CategoriesLocalService.dynamicQuery(
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

		return _news_CategoriesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _news_CategoriesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.tintuc.model.News_Categories fetchNews_Categories(long id) {
		return _news_CategoriesLocalService.fetchNews_Categories(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _news_CategoriesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _news_CategoriesLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the news_ categories with the primary key.
	 *
	 * @param id the primary key of the news_ categories
	 * @return the news_ categories
	 * @throws PortalException if a news_ categories with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Categories getNews_Categories(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_CategoriesLocalService.getNews_Categories(id);
	}

	/**
	 * Returns a range of all the news_ categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_CategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ categorieses
	 * @param end the upper bound of the range of news_ categorieses (not inclusive)
	 * @return the range of news_ categorieses
	 */
	@Override
	public java.util.List<vn.dnict.tintuc.model.News_Categories>
		getNews_Categorieses(int start, int end) {

		return _news_CategoriesLocalService.getNews_Categorieses(start, end);
	}

	/**
	 * Returns the number of news_ categorieses.
	 *
	 * @return the number of news_ categorieses
	 */
	@Override
	public int getNews_CategoriesesCount() {
		return _news_CategoriesLocalService.getNews_CategoriesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _news_CategoriesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_CategoriesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the news_ categories in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_CategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Categories the news_ categories
	 * @return the news_ categories that was updated
	 */
	@Override
	public vn.dnict.tintuc.model.News_Categories updateNews_Categories(
		vn.dnict.tintuc.model.News_Categories news_Categories) {

		return _news_CategoriesLocalService.updateNews_Categories(
			news_Categories);
	}

	@Override
	public News_CategoriesLocalService getWrappedService() {
		return _news_CategoriesLocalService;
	}

	@Override
	public void setWrappedService(
		News_CategoriesLocalService news_CategoriesLocalService) {

		_news_CategoriesLocalService = news_CategoriesLocalService;
	}

	private News_CategoriesLocalService _news_CategoriesLocalService;

}