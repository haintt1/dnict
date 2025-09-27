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

package vn.dnict.tintuc.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.tintuc.exception.NoSuchNews_ArticleException;
import vn.dnict.tintuc.model.News_Article;

/**
 * The persistence interface for the news_ article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_ArticleUtil
 * @generated
 */
@ProviderType
public interface News_ArticlePersistence extends BasePersistence<News_Article> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link News_ArticleUtil} to access the news_ article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the news_ article in the entity cache if it is enabled.
	 *
	 * @param news_Article the news_ article
	 */
	public void cacheResult(News_Article news_Article);

	/**
	 * Caches the news_ articles in the entity cache if it is enabled.
	 *
	 * @param news_Articles the news_ articles
	 */
	public void cacheResult(java.util.List<News_Article> news_Articles);

	/**
	 * Creates a new news_ article with the primary key. Does not add the news_ article to the database.
	 *
	 * @param id the primary key for the new news_ article
	 * @return the new news_ article
	 */
	public News_Article create(long id);

	/**
	 * Removes the news_ article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ article
	 * @return the news_ article that was removed
	 * @throws NoSuchNews_ArticleException if a news_ article with the primary key could not be found
	 */
	public News_Article remove(long id) throws NoSuchNews_ArticleException;

	public News_Article updateImpl(News_Article news_Article);

	/**
	 * Returns the news_ article with the primary key or throws a <code>NoSuchNews_ArticleException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ article
	 * @return the news_ article
	 * @throws NoSuchNews_ArticleException if a news_ article with the primary key could not be found
	 */
	public News_Article findByPrimaryKey(long id)
		throws NoSuchNews_ArticleException;

	/**
	 * Returns the news_ article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ article
	 * @return the news_ article, or <code>null</code> if a news_ article with the primary key could not be found
	 */
	public News_Article fetchByPrimaryKey(long id);

	/**
	 * Returns all the news_ articles.
	 *
	 * @return the news_ articles
	 */
	public java.util.List<News_Article> findAll();

	/**
	 * Returns a range of all the news_ articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ articles
	 * @param end the upper bound of the range of news_ articles (not inclusive)
	 * @return the range of news_ articles
	 */
	public java.util.List<News_Article> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the news_ articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ articles
	 * @param end the upper bound of the range of news_ articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ articles
	 */
	public java.util.List<News_Article> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Article>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news_ articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ articles
	 * @param end the upper bound of the range of news_ articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ articles
	 */
	public java.util.List<News_Article> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Article>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the news_ articles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of news_ articles.
	 *
	 * @return the number of news_ articles
	 */
	public int countAll();

}