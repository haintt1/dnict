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
 * Provides a wrapper for {@link News_NguonTinLocalService}.
 *
 * @author dnict
 * @see News_NguonTinLocalService
 * @generated
 */
public class News_NguonTinLocalServiceWrapper
	implements News_NguonTinLocalService,
			   ServiceWrapper<News_NguonTinLocalService> {

	public News_NguonTinLocalServiceWrapper(
		News_NguonTinLocalService news_NguonTinLocalService) {

		_news_NguonTinLocalService = news_NguonTinLocalService;
	}

	/**
	 * Adds the news_ nguon tin to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_NguonTinLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_NguonTin the news_ nguon tin
	 * @return the news_ nguon tin that was added
	 */
	@Override
	public vn.dnict.tintuc.model.News_NguonTin addNews_NguonTin(
		vn.dnict.tintuc.model.News_NguonTin news_NguonTin) {

		return _news_NguonTinLocalService.addNews_NguonTin(news_NguonTin);
	}

	/**
	 * Creates a new news_ nguon tin with the primary key. Does not add the news_ nguon tin to the database.
	 *
	 * @param id the primary key for the new news_ nguon tin
	 * @return the new news_ nguon tin
	 */
	@Override
	public vn.dnict.tintuc.model.News_NguonTin createNews_NguonTin(long id) {
		return _news_NguonTinLocalService.createNews_NguonTin(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_NguonTinLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the news_ nguon tin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_NguonTinLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the news_ nguon tin
	 * @return the news_ nguon tin that was removed
	 * @throws PortalException if a news_ nguon tin with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_NguonTin deleteNews_NguonTin(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_NguonTinLocalService.deleteNews_NguonTin(id);
	}

	/**
	 * Deletes the news_ nguon tin from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_NguonTinLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_NguonTin the news_ nguon tin
	 * @return the news_ nguon tin that was removed
	 */
	@Override
	public vn.dnict.tintuc.model.News_NguonTin deleteNews_NguonTin(
		vn.dnict.tintuc.model.News_NguonTin news_NguonTin) {

		return _news_NguonTinLocalService.deleteNews_NguonTin(news_NguonTin);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_NguonTinLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _news_NguonTinLocalService.dynamicQuery();
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

		return _news_NguonTinLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_NguonTinModelImpl</code>.
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

		return _news_NguonTinLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_NguonTinModelImpl</code>.
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

		return _news_NguonTinLocalService.dynamicQuery(
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

		return _news_NguonTinLocalService.dynamicQueryCount(dynamicQuery);
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

		return _news_NguonTinLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.tintuc.model.News_NguonTin fetchNews_NguonTin(long id) {
		return _news_NguonTinLocalService.fetchNews_NguonTin(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _news_NguonTinLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _news_NguonTinLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the news_ nguon tin with the primary key.
	 *
	 * @param id the primary key of the news_ nguon tin
	 * @return the news_ nguon tin
	 * @throws PortalException if a news_ nguon tin with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_NguonTin getNews_NguonTin(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_NguonTinLocalService.getNews_NguonTin(id);
	}

	/**
	 * Returns a range of all the news_ nguon tins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_NguonTinModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ nguon tins
	 * @param end the upper bound of the range of news_ nguon tins (not inclusive)
	 * @return the range of news_ nguon tins
	 */
	@Override
	public java.util.List<vn.dnict.tintuc.model.News_NguonTin>
		getNews_NguonTins(int start, int end) {

		return _news_NguonTinLocalService.getNews_NguonTins(start, end);
	}

	/**
	 * Returns the number of news_ nguon tins.
	 *
	 * @return the number of news_ nguon tins
	 */
	@Override
	public int getNews_NguonTinsCount() {
		return _news_NguonTinLocalService.getNews_NguonTinsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _news_NguonTinLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_NguonTinLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the news_ nguon tin in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_NguonTinLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_NguonTin the news_ nguon tin
	 * @return the news_ nguon tin that was updated
	 */
	@Override
	public vn.dnict.tintuc.model.News_NguonTin updateNews_NguonTin(
		vn.dnict.tintuc.model.News_NguonTin news_NguonTin) {

		return _news_NguonTinLocalService.updateNews_NguonTin(news_NguonTin);
	}

	@Override
	public News_NguonTinLocalService getWrappedService() {
		return _news_NguonTinLocalService;
	}

	@Override
	public void setWrappedService(
		News_NguonTinLocalService news_NguonTinLocalService) {

		_news_NguonTinLocalService = news_NguonTinLocalService;
	}

	private News_NguonTinLocalService _news_NguonTinLocalService;

}