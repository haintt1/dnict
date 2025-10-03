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
 * Provides a wrapper for {@link News_TypeLocalService}.
 *
 * @author dnict
 * @see News_TypeLocalService
 * @generated
 */
public class News_TypeLocalServiceWrapper
	implements News_TypeLocalService, ServiceWrapper<News_TypeLocalService> {

	public News_TypeLocalServiceWrapper(
		News_TypeLocalService news_TypeLocalService) {

		_news_TypeLocalService = news_TypeLocalService;
	}

	/**
	 * Adds the news_ type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_TypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Type the news_ type
	 * @return the news_ type that was added
	 */
	@Override
	public vn.dnict.tintuc.model.News_Type addNews_Type(
		vn.dnict.tintuc.model.News_Type news_Type) {

		return _news_TypeLocalService.addNews_Type(news_Type);
	}

	/**
	 * Creates a new news_ type with the primary key. Does not add the news_ type to the database.
	 *
	 * @param id the primary key for the new news_ type
	 * @return the new news_ type
	 */
	@Override
	public vn.dnict.tintuc.model.News_Type createNews_Type(long id) {
		return _news_TypeLocalService.createNews_Type(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_TypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the news_ type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_TypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the news_ type
	 * @return the news_ type that was removed
	 * @throws PortalException if a news_ type with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Type deleteNews_Type(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_TypeLocalService.deleteNews_Type(id);
	}

	/**
	 * Deletes the news_ type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_TypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Type the news_ type
	 * @return the news_ type that was removed
	 */
	@Override
	public vn.dnict.tintuc.model.News_Type deleteNews_Type(
		vn.dnict.tintuc.model.News_Type news_Type) {

		return _news_TypeLocalService.deleteNews_Type(news_Type);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_TypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _news_TypeLocalService.dynamicQuery();
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

		return _news_TypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_TypeModelImpl</code>.
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

		return _news_TypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_TypeModelImpl</code>.
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

		return _news_TypeLocalService.dynamicQuery(
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

		return _news_TypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _news_TypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.tintuc.model.News_Type fetchNews_Type(long id) {
		return _news_TypeLocalService.fetchNews_Type(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _news_TypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _news_TypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the news_ type with the primary key.
	 *
	 * @param id the primary key of the news_ type
	 * @return the news_ type
	 * @throws PortalException if a news_ type with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Type getNews_Type(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_TypeLocalService.getNews_Type(id);
	}

	/**
	 * Returns a range of all the news_ types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_TypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ types
	 * @param end the upper bound of the range of news_ types (not inclusive)
	 * @return the range of news_ types
	 */
	@Override
	public java.util.List<vn.dnict.tintuc.model.News_Type> getNews_Types(
		int start, int end) {

		return _news_TypeLocalService.getNews_Types(start, end);
	}

	/**
	 * Returns the number of news_ types.
	 *
	 * @return the number of news_ types
	 */
	@Override
	public int getNews_TypesCount() {
		return _news_TypeLocalService.getNews_TypesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _news_TypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_TypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the news_ type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_TypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Type the news_ type
	 * @return the news_ type that was updated
	 */
	@Override
	public vn.dnict.tintuc.model.News_Type updateNews_Type(
		vn.dnict.tintuc.model.News_Type news_Type) {

		return _news_TypeLocalService.updateNews_Type(news_Type);
	}

	@Override
	public News_TypeLocalService getWrappedService() {
		return _news_TypeLocalService;
	}

	@Override
	public void setWrappedService(News_TypeLocalService news_TypeLocalService) {
		_news_TypeLocalService = news_TypeLocalService;
	}

	private News_TypeLocalService _news_TypeLocalService;

}