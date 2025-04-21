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
 * Provides a wrapper for {@link News_ArticleLocalService}.
 *
 * @author dnict
 * @see News_ArticleLocalService
 * @generated
 */
public class News_ArticleLocalServiceWrapper
	implements News_ArticleLocalService,
			   ServiceWrapper<News_ArticleLocalService> {

	public News_ArticleLocalServiceWrapper(
		News_ArticleLocalService news_ArticleLocalService) {

		_news_ArticleLocalService = news_ArticleLocalService;
	}

	/**
	 * Adds the news_ article to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_ArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Article the news_ article
	 * @return the news_ article that was added
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article addNews_Article(
		vn.dnict.tintuc.model.News_Article news_Article) {

		return _news_ArticleLocalService.addNews_Article(news_Article);
	}

	/**
	 * Creates a new news_ article with the primary key. Does not add the news_ article to the database.
	 *
	 * @param id the primary key for the new news_ article
	 * @return the new news_ article
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article createNews_Article(long id) {
		return _news_ArticleLocalService.createNews_Article(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_ArticleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the news_ article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_ArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the news_ article
	 * @return the news_ article that was removed
	 * @throws PortalException if a news_ article with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article deleteNews_Article(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_ArticleLocalService.deleteNews_Article(id);
	}

	/**
	 * Deletes the news_ article from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_ArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Article the news_ article
	 * @return the news_ article that was removed
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article deleteNews_Article(
		vn.dnict.tintuc.model.News_Article news_Article) {

		return _news_ArticleLocalService.deleteNews_Article(news_Article);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_ArticleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _news_ArticleLocalService.dynamicQuery();
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

		return _news_ArticleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_ArticleModelImpl</code>.
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

		return _news_ArticleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_ArticleModelImpl</code>.
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

		return _news_ArticleLocalService.dynamicQuery(
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

		return _news_ArticleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _news_ArticleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.tintuc.model.News_Article fetchNews_Article(long id) {
		return _news_ArticleLocalService.fetchNews_Article(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _news_ArticleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _news_ArticleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the news_ article with the primary key.
	 *
	 * @param id the primary key of the news_ article
	 * @return the news_ article
	 * @throws PortalException if a news_ article with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article getNews_Article(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_ArticleLocalService.getNews_Article(id);
	}

	/**
	 * Returns a range of all the news_ articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ articles
	 * @param end the upper bound of the range of news_ articles (not inclusive)
	 * @return the range of news_ articles
	 */
	@Override
	public java.util.List<vn.dnict.tintuc.model.News_Article> getNews_Articles(
		int start, int end) {

		return _news_ArticleLocalService.getNews_Articles(start, end);
	}

	/**
	 * Returns the number of news_ articles.
	 *
	 * @return the number of news_ articles
	 */
	@Override
	public int getNews_ArticlesCount() {
		return _news_ArticleLocalService.getNews_ArticlesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _news_ArticleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_ArticleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the news_ article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_ArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Article the news_ article
	 * @return the news_ article that was updated
	 */
	@Override
	public vn.dnict.tintuc.model.News_Article updateNews_Article(
		vn.dnict.tintuc.model.News_Article news_Article) {

		return _news_ArticleLocalService.updateNews_Article(news_Article);
	}

	@Override
	public News_ArticleLocalService getWrappedService() {
		return _news_ArticleLocalService;
	}

	@Override
	public void setWrappedService(
		News_ArticleLocalService news_ArticleLocalService) {

		_news_ArticleLocalService = news_ArticleLocalService;
	}

	private News_ArticleLocalService _news_ArticleLocalService;

}