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
 * Provides a wrapper for {@link News_Article2CategoryLocalService}.
 *
 * @author dnict
 * @see News_Article2CategoryLocalService
 * @generated
 */
public class News_Article2CategoryLocalServiceWrapper
	implements News_Article2CategoryLocalService,
			   ServiceWrapper<News_Article2CategoryLocalService> {

	public News_Article2CategoryLocalServiceWrapper(
		News_Article2CategoryLocalService news_Article2CategoryLocalService) {

		_news_Article2CategoryLocalService = news_Article2CategoryLocalService;
	}

	/**
	 * Adds the news_ article2 category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_Article2CategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Article2Category the news_ article2 category
	 * @return the news_ article2 category that was added
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article2Category addNews_Article2Category(
		vn.dnict.tintuc.model.News_Article2Category news_Article2Category) {

		return _news_Article2CategoryLocalService.addNews_Article2Category(
			news_Article2Category);
	}

	/**
	 * Creates a new news_ article2 category with the primary key. Does not add the news_ article2 category to the database.
	 *
	 * @param id the primary key for the new news_ article2 category
	 * @return the new news_ article2 category
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article2Category
		createNews_Article2Category(long id) {

		return _news_Article2CategoryLocalService.createNews_Article2Category(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_Article2CategoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the news_ article2 category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_Article2CategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the news_ article2 category
	 * @return the news_ article2 category that was removed
	 * @throws PortalException if a news_ article2 category with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article2Category
			deleteNews_Article2Category(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_Article2CategoryLocalService.deleteNews_Article2Category(
			id);
	}

	/**
	 * Deletes the news_ article2 category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_Article2CategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Article2Category the news_ article2 category
	 * @return the news_ article2 category that was removed
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article2Category
		deleteNews_Article2Category(
			vn.dnict.tintuc.model.News_Article2Category news_Article2Category) {

		return _news_Article2CategoryLocalService.deleteNews_Article2Category(
			news_Article2Category);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_Article2CategoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _news_Article2CategoryLocalService.dynamicQuery();
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

		return _news_Article2CategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_Article2CategoryModelImpl</code>.
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

		return _news_Article2CategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_Article2CategoryModelImpl</code>.
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

		return _news_Article2CategoryLocalService.dynamicQuery(
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

		return _news_Article2CategoryLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _news_Article2CategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.tintuc.model.News_Article2Category
		fetchNews_Article2Category(long id) {

		return _news_Article2CategoryLocalService.fetchNews_Article2Category(
			id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _news_Article2CategoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _news_Article2CategoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the news_ article2 categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_Article2CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ article2 categories
	 * @param end the upper bound of the range of news_ article2 categories (not inclusive)
	 * @return the range of news_ article2 categories
	 */
	@Override
	public java.util.List<vn.dnict.tintuc.model.News_Article2Category>
		getNews_Article2Categories(int start, int end) {

		return _news_Article2CategoryLocalService.getNews_Article2Categories(
			start, end);
	}

	/**
	 * Returns the number of news_ article2 categories.
	 *
	 * @return the number of news_ article2 categories
	 */
	@Override
	public int getNews_Article2CategoriesCount() {
		return _news_Article2CategoryLocalService.
			getNews_Article2CategoriesCount();
	}

	/**
	 * Returns the news_ article2 category with the primary key.
	 *
	 * @param id the primary key of the news_ article2 category
	 * @return the news_ article2 category
	 * @throws PortalException if a news_ article2 category with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article2Category getNews_Article2Category(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_Article2CategoryLocalService.getNews_Article2Category(id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _news_Article2CategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_Article2CategoryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the news_ article2 category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_Article2CategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Article2Category the news_ article2 category
	 * @return the news_ article2 category that was updated
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article2Category
		updateNews_Article2Category(
			vn.dnict.tintuc.model.News_Article2Category news_Article2Category) {

		return _news_Article2CategoryLocalService.updateNews_Article2Category(
			news_Article2Category);
	}

	@Override
	public News_Article2CategoryLocalService getWrappedService() {
		return _news_Article2CategoryLocalService;
	}

	@Override
	public void setWrappedService(
		News_Article2CategoryLocalService news_Article2CategoryLocalService) {

		_news_Article2CategoryLocalService = news_Article2CategoryLocalService;
	}

	private News_Article2CategoryLocalService
		_news_Article2CategoryLocalService;

}