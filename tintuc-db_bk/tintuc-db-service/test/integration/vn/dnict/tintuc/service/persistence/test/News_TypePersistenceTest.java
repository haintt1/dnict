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

import vn.dnict.tintuc.exception.NoSuchNews_TypeException;
import vn.dnict.tintuc.model.News_Type;
import vn.dnict.tintuc.service.News_TypeLocalServiceUtil;
import vn.dnict.tintuc.service.persistence.News_TypePersistence;
import vn.dnict.tintuc.service.persistence.News_TypeUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class News_TypePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.tintuc.service"));

	@Before
	public void setUp() {
		_persistence = News_TypeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<News_Type> iterator = _news_Types.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Type news_Type = _persistence.create(pk);

		Assert.assertNotNull(news_Type);

		Assert.assertEquals(news_Type.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		News_Type newNews_Type = addNews_Type();

		_persistence.remove(newNews_Type);

		News_Type existingNews_Type = _persistence.fetchByPrimaryKey(
			newNews_Type.getPrimaryKey());

		Assert.assertNull(existingNews_Type);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNews_Type();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Type newNews_Type = _persistence.create(pk);

		newNews_Type.setCompanyId(RandomTestUtil.nextLong());

		newNews_Type.setGroupId(RandomTestUtil.nextLong());

		newNews_Type.setName(RandomTestUtil.randomString());

		newNews_Type.setLanguage(RandomTestUtil.randomString());

		newNews_Type.setStatus(RandomTestUtil.nextInt());

		newNews_Type.setOrders(RandomTestUtil.nextInt());

		newNews_Type.setDelete_status(RandomTestUtil.nextInt());

		_news_Types.add(_persistence.update(newNews_Type));

		News_Type existingNews_Type = _persistence.findByPrimaryKey(
			newNews_Type.getPrimaryKey());

		Assert.assertEquals(existingNews_Type.getId(), newNews_Type.getId());
		Assert.assertEquals(
			existingNews_Type.getCompanyId(), newNews_Type.getCompanyId());
		Assert.assertEquals(
			existingNews_Type.getGroupId(), newNews_Type.getGroupId());
		Assert.assertEquals(
			existingNews_Type.getName(), newNews_Type.getName());
		Assert.assertEquals(
			existingNews_Type.getLanguage(), newNews_Type.getLanguage());
		Assert.assertEquals(
			existingNews_Type.getStatus(), newNews_Type.getStatus());
		Assert.assertEquals(
			existingNews_Type.getOrders(), newNews_Type.getOrders());
		Assert.assertEquals(
			existingNews_Type.getDelete_status(),
			newNews_Type.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		News_Type newNews_Type = addNews_Type();

		News_Type existingNews_Type = _persistence.findByPrimaryKey(
			newNews_Type.getPrimaryKey());

		Assert.assertEquals(existingNews_Type, newNews_Type);
	}

	@Test(expected = NoSuchNews_TypeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<News_Type> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_News_Type", "id", true, "companyId", true, "groupId", true,
			"name", true, "language", true, "status", true, "orders", true,
			"delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		News_Type newNews_Type = addNews_Type();

		News_Type existingNews_Type = _persistence.fetchByPrimaryKey(
			newNews_Type.getPrimaryKey());

		Assert.assertEquals(existingNews_Type, newNews_Type);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Type missingNews_Type = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNews_Type);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		News_Type newNews_Type1 = addNews_Type();
		News_Type newNews_Type2 = addNews_Type();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Type1.getPrimaryKey());
		primaryKeys.add(newNews_Type2.getPrimaryKey());

		Map<Serializable, News_Type> news_Types =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, news_Types.size());
		Assert.assertEquals(
			newNews_Type1, news_Types.get(newNews_Type1.getPrimaryKey()));
		Assert.assertEquals(
			newNews_Type2, news_Types.get(newNews_Type2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, News_Type> news_Types =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Types.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		News_Type newNews_Type = addNews_Type();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Type.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, News_Type> news_Types =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Types.size());
		Assert.assertEquals(
			newNews_Type, news_Types.get(newNews_Type.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, News_Type> news_Types =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Types.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		News_Type newNews_Type = addNews_Type();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Type.getPrimaryKey());

		Map<Serializable, News_Type> news_Types =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Types.size());
		Assert.assertEquals(
			newNews_Type, news_Types.get(newNews_Type.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			News_TypeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<News_Type>() {

				@Override
				public void performAction(News_Type news_Type) {
					Assert.assertNotNull(news_Type);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		News_Type newNews_Type = addNews_Type();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Type.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNews_Type.getId()));

		List<News_Type> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		News_Type existingNews_Type = result.get(0);

		Assert.assertEquals(existingNews_Type, newNews_Type);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Type.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<News_Type> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		News_Type newNews_Type = addNews_Type();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Type.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNews_Type.getId();

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
			News_Type.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected News_Type addNews_Type() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Type news_Type = _persistence.create(pk);

		news_Type.setCompanyId(RandomTestUtil.nextLong());

		news_Type.setGroupId(RandomTestUtil.nextLong());

		news_Type.setName(RandomTestUtil.randomString());

		news_Type.setLanguage(RandomTestUtil.randomString());

		news_Type.setStatus(RandomTestUtil.nextInt());

		news_Type.setOrders(RandomTestUtil.nextInt());

		news_Type.setDelete_status(RandomTestUtil.nextInt());

		_news_Types.add(_persistence.update(news_Type));

		return news_Type;
	}

	private List<News_Type> _news_Types = new ArrayList<News_Type>();
	private News_TypePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}