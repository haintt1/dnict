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

import vn.dnict.tintuc.exception.NoSuchNews_CategoriesException;
import vn.dnict.tintuc.model.News_Categories;
import vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil;
import vn.dnict.tintuc.service.persistence.News_CategoriesPersistence;
import vn.dnict.tintuc.service.persistence.News_CategoriesUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class News_CategoriesPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.tintuc.service"));

	@Before
	public void setUp() {
		_persistence = News_CategoriesUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<News_Categories> iterator = _news_Categorieses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Categories news_Categories = _persistence.create(pk);

		Assert.assertNotNull(news_Categories);

		Assert.assertEquals(news_Categories.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		News_Categories newNews_Categories = addNews_Categories();

		_persistence.remove(newNews_Categories);

		News_Categories existingNews_Categories =
			_persistence.fetchByPrimaryKey(newNews_Categories.getPrimaryKey());

		Assert.assertNull(existingNews_Categories);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNews_Categories();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Categories newNews_Categories = _persistence.create(pk);

		newNews_Categories.setCompanyId(RandomTestUtil.nextLong());

		newNews_Categories.setGroupId(RandomTestUtil.nextLong());

		newNews_Categories.setName(RandomTestUtil.randomString());

		newNews_Categories.setLanguage(RandomTestUtil.randomString());

		newNews_Categories.setStatus(RandomTestUtil.nextInt());

		newNews_Categories.setOrders(RandomTestUtil.nextInt());

		newNews_Categories.setIdlibcat(RandomTestUtil.nextLong());

		newNews_Categories.setDelete_status(RandomTestUtil.nextInt());

		_news_Categorieses.add(_persistence.update(newNews_Categories));

		News_Categories existingNews_Categories = _persistence.findByPrimaryKey(
			newNews_Categories.getPrimaryKey());

		Assert.assertEquals(
			existingNews_Categories.getId(), newNews_Categories.getId());
		Assert.assertEquals(
			existingNews_Categories.getCompanyId(),
			newNews_Categories.getCompanyId());
		Assert.assertEquals(
			existingNews_Categories.getGroupId(),
			newNews_Categories.getGroupId());
		Assert.assertEquals(
			existingNews_Categories.getName(), newNews_Categories.getName());
		Assert.assertEquals(
			existingNews_Categories.getLanguage(),
			newNews_Categories.getLanguage());
		Assert.assertEquals(
			existingNews_Categories.getStatus(),
			newNews_Categories.getStatus());
		Assert.assertEquals(
			existingNews_Categories.getOrders(),
			newNews_Categories.getOrders());
		Assert.assertEquals(
			existingNews_Categories.getIdlibcat(),
			newNews_Categories.getIdlibcat());
		Assert.assertEquals(
			existingNews_Categories.getDelete_status(),
			newNews_Categories.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		News_Categories newNews_Categories = addNews_Categories();

		News_Categories existingNews_Categories = _persistence.findByPrimaryKey(
			newNews_Categories.getPrimaryKey());

		Assert.assertEquals(existingNews_Categories, newNews_Categories);
	}

	@Test(expected = NoSuchNews_CategoriesException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<News_Categories> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_News_Categories", "id", true, "companyId", true, "groupId",
			true, "name", true, "language", true, "status", true, "orders",
			true, "idlibcat", true, "delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		News_Categories newNews_Categories = addNews_Categories();

		News_Categories existingNews_Categories =
			_persistence.fetchByPrimaryKey(newNews_Categories.getPrimaryKey());

		Assert.assertEquals(existingNews_Categories, newNews_Categories);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Categories missingNews_Categories = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingNews_Categories);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		News_Categories newNews_Categories1 = addNews_Categories();
		News_Categories newNews_Categories2 = addNews_Categories();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Categories1.getPrimaryKey());
		primaryKeys.add(newNews_Categories2.getPrimaryKey());

		Map<Serializable, News_Categories> news_Categorieses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, news_Categorieses.size());
		Assert.assertEquals(
			newNews_Categories1,
			news_Categorieses.get(newNews_Categories1.getPrimaryKey()));
		Assert.assertEquals(
			newNews_Categories2,
			news_Categorieses.get(newNews_Categories2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, News_Categories> news_Categorieses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Categorieses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		News_Categories newNews_Categories = addNews_Categories();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Categories.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, News_Categories> news_Categorieses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Categorieses.size());
		Assert.assertEquals(
			newNews_Categories,
			news_Categorieses.get(newNews_Categories.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, News_Categories> news_Categorieses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Categorieses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		News_Categories newNews_Categories = addNews_Categories();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Categories.getPrimaryKey());

		Map<Serializable, News_Categories> news_Categorieses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Categorieses.size());
		Assert.assertEquals(
			newNews_Categories,
			news_Categorieses.get(newNews_Categories.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			News_CategoriesLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<News_Categories>() {

				@Override
				public void performAction(News_Categories news_Categories) {
					Assert.assertNotNull(news_Categories);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		News_Categories newNews_Categories = addNews_Categories();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Categories.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNews_Categories.getId()));

		List<News_Categories> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		News_Categories existingNews_Categories = result.get(0);

		Assert.assertEquals(existingNews_Categories, newNews_Categories);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Categories.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<News_Categories> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		News_Categories newNews_Categories = addNews_Categories();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Categories.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNews_Categories.getId();

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
			News_Categories.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected News_Categories addNews_Categories() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Categories news_Categories = _persistence.create(pk);

		news_Categories.setCompanyId(RandomTestUtil.nextLong());

		news_Categories.setGroupId(RandomTestUtil.nextLong());

		news_Categories.setName(RandomTestUtil.randomString());

		news_Categories.setLanguage(RandomTestUtil.randomString());

		news_Categories.setStatus(RandomTestUtil.nextInt());

		news_Categories.setOrders(RandomTestUtil.nextInt());

		news_Categories.setIdlibcat(RandomTestUtil.nextLong());

		news_Categories.setDelete_status(RandomTestUtil.nextInt());

		_news_Categorieses.add(_persistence.update(news_Categories));

		return news_Categories;
	}

	private List<News_Categories> _news_Categorieses =
		new ArrayList<News_Categories>();
	private News_CategoriesPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}