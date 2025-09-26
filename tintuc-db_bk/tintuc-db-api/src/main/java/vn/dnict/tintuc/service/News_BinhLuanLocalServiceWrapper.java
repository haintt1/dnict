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
 * Provides a wrapper for {@link News_BinhLuanLocalService}.
 *
 * @author dnict
 * @see News_BinhLuanLocalService
 * @generated
 */
public class News_BinhLuanLocalServiceWrapper
	implements News_BinhLuanLocalService,
			   ServiceWrapper<News_BinhLuanLocalService> {

	public News_BinhLuanLocalServiceWrapper(
		News_BinhLuanLocalService news_BinhLuanLocalService) {

		_news_BinhLuanLocalService = news_BinhLuanLocalService;
	}

	/**
	 * Adds the news_ binh luan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_BinhLuan the news_ binh luan
	 * @return the news_ binh luan that was added
	 */
	@Override
	public vn.dnict.tintuc.model.News_BinhLuan addNews_BinhLuan(
		vn.dnict.tintuc.model.News_BinhLuan news_BinhLuan) {

		return _news_BinhLuanLocalService.addNews_BinhLuan(news_BinhLuan);
	}

	/**
	 * Creates a new news_ binh luan with the primary key. Does not add the news_ binh luan to the database.
	 *
	 * @param id the primary key for the new news_ binh luan
	 * @return the new news_ binh luan
	 */
	@Override
	public vn.dnict.tintuc.model.News_BinhLuan createNews_BinhLuan(long id) {
		return _news_BinhLuanLocalService.createNews_BinhLuan(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_BinhLuanLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the news_ binh luan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the news_ binh luan
	 * @return the news_ binh luan that was removed
	 * @throws PortalException if a news_ binh luan with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_BinhLuan deleteNews_BinhLuan(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_BinhLuanLocalService.deleteNews_BinhLuan(id);
	}

	/**
	 * Deletes the news_ binh luan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_BinhLuan the news_ binh luan
	 * @return the news_ binh luan that was removed
	 */
	@Override
	public vn.dnict.tintuc.model.News_BinhLuan deleteNews_BinhLuan(
		vn.dnict.tintuc.model.News_BinhLuan news_BinhLuan) {

		return _news_BinhLuanLocalService.deleteNews_BinhLuan(news_BinhLuan);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_BinhLuanLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _news_BinhLuanLocalService.dynamicQuery();
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

		return _news_BinhLuanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_BinhLuanModelImpl</code>.
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

		return _news_BinhLuanLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_BinhLuanModelImpl</code>.
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

		return _news_BinhLuanLocalService.dynamicQuery(
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

		return _news_BinhLuanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _news_BinhLuanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.tintuc.model.News_BinhLuan fetchNews_BinhLuan(long id) {
		return _news_BinhLuanLocalService.fetchNews_BinhLuan(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _news_BinhLuanLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _news_BinhLuanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the news_ binh luan with the primary key.
	 *
	 * @param id the primary key of the news_ binh luan
	 * @return the news_ binh luan
	 * @throws PortalException if a news_ binh luan with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_BinhLuan getNews_BinhLuan(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_BinhLuanLocalService.getNews_BinhLuan(id);
	}

	/**
	 * Returns a range of all the news_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ binh luans
	 * @param end the upper bound of the range of news_ binh luans (not inclusive)
	 * @return the range of news_ binh luans
	 */
	@Override
	public java.util.List<vn.dnict.tintuc.model.News_BinhLuan>
		getNews_BinhLuans(int start, int end) {

		return _news_BinhLuanLocalService.getNews_BinhLuans(start, end);
	}

	/**
	 * Returns the number of news_ binh luans.
	 *
	 * @return the number of news_ binh luans
	 */
	@Override
	public int getNews_BinhLuansCount() {
		return _news_BinhLuanLocalService.getNews_BinhLuansCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _news_BinhLuanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_BinhLuanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the news_ binh luan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_BinhLuanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_BinhLuan the news_ binh luan
	 * @return the news_ binh luan that was updated
	 */
	@Override
	public vn.dnict.tintuc.model.News_BinhLuan updateNews_BinhLuan(
		vn.dnict.tintuc.model.News_BinhLuan news_BinhLuan) {

		return _news_BinhLuanLocalService.updateNews_BinhLuan(news_BinhLuan);
	}

	@Override
	public News_BinhLuanLocalService getWrappedService() {
		return _news_BinhLuanLocalService;
	}

	@Override
	public void setWrappedService(
		News_BinhLuanLocalService news_BinhLuanLocalService) {

		_news_BinhLuanLocalService = news_BinhLuanLocalService;
	}

	private News_BinhLuanLocalService _news_BinhLuanLocalService;

}