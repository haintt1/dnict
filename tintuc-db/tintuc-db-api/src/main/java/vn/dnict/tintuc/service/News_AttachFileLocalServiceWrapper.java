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
 * Provides a wrapper for {@link News_AttachFileLocalService}.
 *
 * @author dnict
 * @see News_AttachFileLocalService
 * @generated
 */
public class News_AttachFileLocalServiceWrapper
	implements News_AttachFileLocalService,
			   ServiceWrapper<News_AttachFileLocalService> {

	public News_AttachFileLocalServiceWrapper(
		News_AttachFileLocalService news_AttachFileLocalService) {

		_news_AttachFileLocalService = news_AttachFileLocalService;
	}

	/**
	 * Adds the news_ attach file to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_AttachFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_AttachFile the news_ attach file
	 * @return the news_ attach file that was added
	 */
	@Override
	public vn.dnict.tintuc.model.News_AttachFile addNews_AttachFile(
		vn.dnict.tintuc.model.News_AttachFile news_AttachFile) {

		return _news_AttachFileLocalService.addNews_AttachFile(news_AttachFile);
	}

	/**
	 * Creates a new news_ attach file with the primary key. Does not add the news_ attach file to the database.
	 *
	 * @param id the primary key for the new news_ attach file
	 * @return the new news_ attach file
	 */
	@Override
	public vn.dnict.tintuc.model.News_AttachFile createNews_AttachFile(
		long id) {

		return _news_AttachFileLocalService.createNews_AttachFile(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_AttachFileLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the news_ attach file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_AttachFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the news_ attach file
	 * @return the news_ attach file that was removed
	 * @throws PortalException if a news_ attach file with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_AttachFile deleteNews_AttachFile(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_AttachFileLocalService.deleteNews_AttachFile(id);
	}

	/**
	 * Deletes the news_ attach file from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_AttachFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_AttachFile the news_ attach file
	 * @return the news_ attach file that was removed
	 */
	@Override
	public vn.dnict.tintuc.model.News_AttachFile deleteNews_AttachFile(
		vn.dnict.tintuc.model.News_AttachFile news_AttachFile) {

		return _news_AttachFileLocalService.deleteNews_AttachFile(
			news_AttachFile);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_AttachFileLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _news_AttachFileLocalService.dynamicQuery();
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

		return _news_AttachFileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_AttachFileModelImpl</code>.
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

		return _news_AttachFileLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_AttachFileModelImpl</code>.
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

		return _news_AttachFileLocalService.dynamicQuery(
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

		return _news_AttachFileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _news_AttachFileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public vn.dnict.tintuc.model.News_AttachFile fetchNews_AttachFile(long id) {
		return _news_AttachFileLocalService.fetchNews_AttachFile(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _news_AttachFileLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _news_AttachFileLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the news_ attach file with the primary key.
	 *
	 * @param id the primary key of the news_ attach file
	 * @return the news_ attach file
	 * @throws PortalException if a news_ attach file with the primary key could not be found
	 */
	@Override
	public vn.dnict.tintuc.model.News_AttachFile getNews_AttachFile(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_AttachFileLocalService.getNews_AttachFile(id);
	}

	/**
	 * Returns a range of all the news_ attach files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>vn.dnict.tintuc.model.impl.News_AttachFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ attach files
	 * @param end the upper bound of the range of news_ attach files (not inclusive)
	 * @return the range of news_ attach files
	 */
	@Override
	public java.util.List<vn.dnict.tintuc.model.News_AttachFile>
		getNews_AttachFiles(int start, int end) {

		return _news_AttachFileLocalService.getNews_AttachFiles(start, end);
	}

	/**
	 * Returns the number of news_ attach files.
	 *
	 * @return the number of news_ attach files
	 */
	@Override
	public int getNews_AttachFilesCount() {
		return _news_AttachFileLocalService.getNews_AttachFilesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _news_AttachFileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _news_AttachFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the news_ attach file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect News_AttachFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param news_AttachFile the news_ attach file
	 * @return the news_ attach file that was updated
	 */
	@Override
	public vn.dnict.tintuc.model.News_AttachFile updateNews_AttachFile(
		vn.dnict.tintuc.model.News_AttachFile news_AttachFile) {

		return _news_AttachFileLocalService.updateNews_AttachFile(
			news_AttachFile);
	}

	@Override
	public News_AttachFileLocalService getWrappedService() {
		return _news_AttachFileLocalService;
	}

	@Override
	public void setWrappedService(
		News_AttachFileLocalService news_AttachFileLocalService) {

		_news_AttachFileLocalService = news_AttachFileLocalService;
	}

	private News_AttachFileLocalService _news_AttachFileLocalService;

}