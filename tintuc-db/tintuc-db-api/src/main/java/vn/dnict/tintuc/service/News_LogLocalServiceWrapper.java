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
 * Provides a wrapper for {@link News_LogLocalService}.
 *
 * @author dnict
 * @see News_LogLocalService
 * @generated
 */
public class News_LogLocalServiceWrapper
	implements News_LogLocalService, ServiceWrapper<News_LogLocalService> {

	public News_LogLocalServiceWrapper(
		News_LogLocalService news_LogLocalService) {

		_news_LogLocalService = news_LogLocalService;
	}

	/**
	 * Adds the news_ log to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_LogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Log the news_ log
	 * @return the news_ log that was added
	 */
	@Override
	public vn.dnict.tintuc.model.News_Log addNews_Log(
		vn.dnict.tintuc.model.News_Log news_Log) {

		return _news_LogLocalService.addNews_Log(news_Log);
	}

	/**
	 * Creates a new news_ log with the primary key. Does not add the news_ log to the database.
	 *
	 * @param id the primary key for the new news_ log
	 * @return the new news_ log
	 */
	@Override
	public vn.dnict.tintuc.model.News_Log createNews_Log(long id) {
		return _news_LogLocalService.createNews_Log(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_LogLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the news_ log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_LogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the news_ log
	 * @return the news_ log that was removed
	 * @throws PortalException if a news_ log with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Log deleteNews_Log(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_LogLocalService.deleteNews_Log(id);
	}

	/**
	 * Deletes the news_ log from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_LogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Log the news_ log
	 * @return the news_ log that was removed
	 */
	@Override
	public vn.dnict.tintuc.model.News_Log deleteNews_Log(
		vn.dnict.tintuc.model.News_Log news_Log) {

		return _news_LogLocalService.deleteNews_Log(news_Log);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_LogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _news_LogLocalService.dynamicQuery();
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

		return _news_LogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_LogModelImpl</code>.
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

		return _news_LogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_LogModelImpl</code>.
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

		return _news_LogLocalService.dynamicQuery(
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

		return _news_LogLocalService.dynamicQueryCount(dynamicQuery);
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

		return _news_LogLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.tintuc.model.News_Log fetchNews_Log(long id) {
		return _news_LogLocalService.fetchNews_Log(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _news_LogLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _news_LogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the news_ log with the primary key.
	 *
	 * @param id the primary key of the news_ log
	 * @return the news_ log
	 * @throws PortalException if a news_ log with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_Log getNews_Log(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_LogLocalService.getNews_Log(id);
	}

	/**
	 * Returns a range of all the news_ logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_LogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ logs
	 * @param end the upper bound of the range of news_ logs (not inclusive)
	 * @return the range of news_ logs
	 */
	@Override
	public java.util.List<vn.dnict.tintuc.model.News_Log> getNews_Logs(
		int start, int end) {

		return _news_LogLocalService.getNews_Logs(start, end);
	}

	/**
	 * Returns the number of news_ logs.
	 *
	 * @return the number of news_ logs
	 */
	@Override
	public int getNews_LogsCount() {
		return _news_LogLocalService.getNews_LogsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _news_LogLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_LogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the news_ log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_LogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_Log the news_ log
	 * @return the news_ log that was updated
	 */
	@Override
	public vn.dnict.tintuc.model.News_Log updateNews_Log(
		vn.dnict.tintuc.model.News_Log news_Log) {

		return _news_LogLocalService.updateNews_Log(news_Log);
	}

	@Override
	public News_LogLocalService getWrappedService() {
		return _news_LogLocalService;
	}

	@Override
	public void setWrappedService(News_LogLocalService news_LogLocalService) {
		_news_LogLocalService = news_LogLocalService;
	}

	private News_LogLocalService _news_LogLocalService;

}