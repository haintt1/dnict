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
 * Provides a wrapper for {@link News_roleLocalService}.
 *
 * @author dnict
 * @see News_roleLocalService
 * @generated
 */
public class News_roleLocalServiceWrapper
	implements News_roleLocalService, ServiceWrapper<News_roleLocalService> {

	public News_roleLocalServiceWrapper(
		News_roleLocalService news_roleLocalService) {

		_news_roleLocalService = news_roleLocalService;
	}

	/**
	 * Adds the news_role to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_roleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_role the news_role
	 * @return the news_role that was added
	 */
	@Override
	public vn.dnict.tintuc.model.News_role addNews_role(
		vn.dnict.tintuc.model.News_role news_role) {

		return _news_roleLocalService.addNews_role(news_role);
	}

	/**
	 * Creates a new news_role with the primary key. Does not add the news_role to the database.
	 *
	 * @param id the primary key for the new news_role
	 * @return the new news_role
	 */
	@Override
	public vn.dnict.tintuc.model.News_role createNews_role(long id) {
		return _news_roleLocalService.createNews_role(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_roleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the news_role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_roleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the news_role
	 * @return the news_role that was removed
	 * @throws PortalException if a news_role with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_role deleteNews_role(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_roleLocalService.deleteNews_role(id);
	}

	/**
	 * Deletes the news_role from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_roleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_role the news_role
	 * @return the news_role that was removed
	 */
	@Override
	public vn.dnict.tintuc.model.News_role deleteNews_role(
		vn.dnict.tintuc.model.News_role news_role) {

		return _news_roleLocalService.deleteNews_role(news_role);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_roleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _news_roleLocalService.dynamicQuery();
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

		return _news_roleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_roleModelImpl</code>.
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

		return _news_roleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_roleModelImpl</code>.
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

		return _news_roleLocalService.dynamicQuery(
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

		return _news_roleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _news_roleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.tintuc.model.News_role fetchNews_role(long id) {
		return _news_roleLocalService.fetchNews_role(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _news_roleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _news_roleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the news_role with the primary key.
	 *
	 * @param id the primary key of the news_role
	 * @return the news_role
	 * @throws PortalException if a news_role with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_role getNews_role(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_roleLocalService.getNews_role(id);
	}

	/**
	 * Returns a range of all the news_roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_roleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_roles
	 * @param end the upper bound of the range of news_roles (not inclusive)
	 * @return the range of news_roles
	 */
	@Override
	public java.util.List<vn.dnict.tintuc.model.News_role> getNews_roles(
		int start, int end) {

		return _news_roleLocalService.getNews_roles(start, end);
	}

	/**
	 * Returns the number of news_roles.
	 *
	 * @return the number of news_roles
	 */
	@Override
	public int getNews_rolesCount() {
		return _news_roleLocalService.getNews_rolesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _news_roleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_roleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the news_role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_roleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_role the news_role
	 * @return the news_role that was updated
	 */
	@Override
	public vn.dnict.tintuc.model.News_role updateNews_role(
		vn.dnict.tintuc.model.News_role news_role) {

		return _news_roleLocalService.updateNews_role(news_role);
	}

	@Override
	public News_roleLocalService getWrappedService() {
		return _news_roleLocalService;
	}

	@Override
	public void setWrappedService(News_roleLocalService news_roleLocalService) {
		_news_roleLocalService = news_roleLocalService;
	}

	private News_roleLocalService _news_roleLocalService;

}