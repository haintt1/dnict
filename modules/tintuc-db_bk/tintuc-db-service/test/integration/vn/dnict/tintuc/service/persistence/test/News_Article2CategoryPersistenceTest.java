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

package vn.dnict.tintuc.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import vn.dnict.tintuc.exception.NoSuchNews_Article2CategoryException;
import vn.dnict.tintuc.model.News_Article2Category;
import vn.dnict.tintuc.service.News_Article2CategoryLocalServiceUtil;
import vn.dnict.tintuc.service.persistence.News_Article2CategoryPersistence;
import vn.dnict.tintuc.service.persistence.News_Article2CategoryUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class News_Article2CategoryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.tintuc.service"));

	@Before
	public void setUp() {
		_persistence = News_Article2CategoryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<News_Article2Category> iterator =
			_news_Article2Categories.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Article2Category news_Article2Category = _persistence.create(pk);

		Assert.assertNotNull(news_Article2Category);

		Assert.assertEquals(news_Article2Category.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		News_Article2Category newNews_Article2Category =
			addNews_Article2Category();

		_persistence.remove(newNews_Article2Category);

		News_Article2Category existingNews_Article2Category =
			_persistence.fetchByPrimaryKey(
				newNews_Article2Category.getPrimaryKey());

		Assert.assertNull(existingNews_Article2Category);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNews_Article2Category();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Article2Category newNews_Article2Category = _persistence.create(
			pk);

		newNews_Article2Category.setCompanyId(RandomTestUtil.nextLong());

		newNews_Article2Category.setGroupId(RandomTestUtil.nextLong());

		newNews_Article2Category.setNewcategoryId(RandomTestUtil.nextLong());

		newNews_Article2Category.setNewarticleId(RandomTestUtil.nextLong());

		_news_Article2Categories.add(
			_persistence.update(newNews_Article2Category));

		News_Article2Category existingNews_Article2Category =
			_persistence.findByPrimaryKey(
				newNews_Article2Category.getPrimaryKey());

		Assert.assertEquals(
			existingNews_Article2Category.getId(),
			newNews_Article2Category.getId());
		Assert.assertEquals(
			existingNews_Article2Category.getCompanyId(),
			newNews_Article2Category.getCompanyId());
		Assert.assertEquals(
			existingNews_Article2Category.getGroupId(),
			newNews_Article2Category.getGroupId());
		Assert.assertEquals(
			existingNews_Article2Category.getNewcategoryId(),
			newNews_Article2Category.getNewcategoryId());
		Assert.assertEquals(
			existingNews_Article2Category.getNewarticleId(),
			newNews_Article2Category.getNewarticleId());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		News_Article2Category newNews_Article2Category =
			addNews_Article2Category();

		News_Article2Category existingNews_Article2Category =
			_persistence.findByPrimaryKey(
				newNews_Article2Category.getPrimaryKey());

		Assert.assertEquals(
			existingNews_Article2Category, newNews_Article2Category);
	}

	@Test(expected = NoSuchNews_Article2CategoryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<News_Article2Category> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_News_Article2Category", "id", true, "companyId", true,
			"groupId", true, "newcategoryId", true, "newarticleId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		News_Article2Category newNews_Article2Category =
			addNews_Article2Category();

		News_Article2Category existingNews_Article2Category =
			_persistence.fetchByPrimaryKey(
				newNews_Article2Category.getPrimaryKey());

		Assert.assertEquals(
			existingNews_Article2Category, newNews_Article2Category);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Article2Category missingNews_Article2Category =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNews_Article2Category);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		News_Article2Category newNews_Article2Category1 =
			addNews_Article2Category();
		News_Article2Category newNews_Article2Category2 =
			addNews_Article2Category();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Article2Category1.getPrimaryKey());
		primaryKeys.add(newNews_Article2Category2.getPrimaryKey());

		Map<Serializable, News_Article2Category> news_Article2Categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, news_Article2Categories.size());
		Assert.assertEquals(
			newNews_Article2Category1,
			news_Article2Categories.get(
				newNews_Article2Category1.getPrimaryKey()));
		Assert.assertEquals(
			newNews_Article2Category2,
			news_Article2Categories.get(
				newNews_Article2Category2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, News_Article2Category> news_Article2Categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Article2Categories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		News_Article2Category newNews_Article2Category =
			addNews_Article2Category();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Article2Category.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, News_Article2Category> news_Article2Categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Article2Categories.size());
		Assert.assertEquals(
			newNews_Article2Category,
			news_Article2Categories.get(
				newNews_Article2Category.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, News_Article2Category> news_Article2Categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Article2Categories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		News_Article2Category newNews_Article2Category =
			addNews_Article2Category();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Article2Category.getPrimaryKey());

		Map<Serializable, News_Article2Category> news_Article2Categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Article2Categories.size());
		Assert.assertEquals(
			newNews_Article2Category,
			news_Article2Categories.get(
				newNews_Article2Category.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			News_Article2CategoryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<News_Article2Category>() {

				@Override
				public void performAction(
					News_Article2Category news_Article2Category) {

					Assert.assertNotNull(news_Article2Category);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		News_Article2Category newNews_Article2Category =
			addNews_Article2Category();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Article2Category.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNews_Article2Category.getId()));

		List<News_Article2Category> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		News_Article2Category existingNews_Article2Category = result.get(0);

		Assert.assertEquals(
			existingNews_Article2Category, newNews_Article2Category);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Article2Category.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<News_Article2Category> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		News_Article2Category newNews_Article2Category =
			addNews_Article2Category();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Article2Category.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNews_Article2Category.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Article2Category.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected News_Article2Category addNews_Article2Category()
		throws Exception {

		long pk = RandomTestUtil.nextLong();

		News_Article2Category news_Article2Category = _persistence.create(pk);

		news_Article2Category.setCompanyId(RandomTestUtil.nextLong());

		news_Article2Category.setGroupId(RandomTestUtil.nextLong());

		news_Article2Category.setNewcategoryId(RandomTestUtil.nextLong());

		news_Article2Category.setNewarticleId(RandomTestUtil.nextLong());

		_news_Article2Categories.add(
			_persistence.update(news_Article2Category));

		return news_Article2Category;
	}

	private List<News_Article2Category> _news_Article2Categories =
		new ArrayList<News_Article2Category>();
	private News_Article2CategoryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}