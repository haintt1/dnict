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

import vn.dnict.tintuc.exception.NoSuchNews_NguonTinException;
import vn.dnict.tintuc.model.News_NguonTin;
import vn.dnict.tintuc.service.News_NguonTinLocalServiceUtil;
import vn.dnict.tintuc.service.persistence.News_NguonTinPersistence;
import vn.dnict.tintuc.service.persistence.News_NguonTinUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class News_NguonTinPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.tintuc.service"));

	@Before
	public void setUp() {
		_persistence = News_NguonTinUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<News_NguonTin> iterator = _news_NguonTins.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_NguonTin news_NguonTin = _persistence.create(pk);

		Assert.assertNotNull(news_NguonTin);

		Assert.assertEquals(news_NguonTin.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		News_NguonTin newNews_NguonTin = addNews_NguonTin();

		_persistence.remove(newNews_NguonTin);

		News_NguonTin existingNews_NguonTin = _persistence.fetchByPrimaryKey(
			newNews_NguonTin.getPrimaryKey());

		Assert.assertNull(existingNews_NguonTin);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNews_NguonTin();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_NguonTin newNews_NguonTin = _persistence.create(pk);

		newNews_NguonTin.setCompanyId(RandomTestUtil.nextLong());

		newNews_NguonTin.setGroupId(RandomTestUtil.nextLong());

		newNews_NguonTin.setName(RandomTestUtil.randomString());

		newNews_NguonTin.setStatus(RandomTestUtil.nextInt());

		newNews_NguonTin.setOrders(RandomTestUtil.nextInt());

		newNews_NguonTin.setDelete_status(RandomTestUtil.nextInt());

		_news_NguonTins.add(_persistence.update(newNews_NguonTin));

		News_NguonTin existingNews_NguonTin = _persistence.findByPrimaryKey(
			newNews_NguonTin.getPrimaryKey());

		Assert.assertEquals(
			existingNews_NguonTin.getId(), newNews_NguonTin.getId());
		Assert.assertEquals(
			existingNews_NguonTin.getCompanyId(),
			newNews_NguonTin.getCompanyId());
		Assert.assertEquals(
			existingNews_NguonTin.getGroupId(), newNews_NguonTin.getGroupId());
		Assert.assertEquals(
			existingNews_NguonTin.getName(), newNews_NguonTin.getName());
		Assert.assertEquals(
			existingNews_NguonTin.getStatus(), newNews_NguonTin.getStatus());
		Assert.assertEquals(
			existingNews_NguonTin.getOrders(), newNews_NguonTin.getOrders());
		Assert.assertEquals(
			existingNews_NguonTin.getDelete_status(),
			newNews_NguonTin.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		News_NguonTin newNews_NguonTin = addNews_NguonTin();

		News_NguonTin existingNews_NguonTin = _persistence.findByPrimaryKey(
			newNews_NguonTin.getPrimaryKey());

		Assert.assertEquals(existingNews_NguonTin, newNews_NguonTin);
	}

	@Test(expected = NoSuchNews_NguonTinException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<News_NguonTin> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_News_NguonTin", "id", true, "companyId", true, "groupId", true,
			"name", true, "status", true, "orders", true, "delete_status",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		News_NguonTin newNews_NguonTin = addNews_NguonTin();

		News_NguonTin existingNews_NguonTin = _persistence.fetchByPrimaryKey(
			newNews_NguonTin.getPrimaryKey());

		Assert.assertEquals(existingNews_NguonTin, newNews_NguonTin);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_NguonTin missingNews_NguonTin = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNews_NguonTin);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		News_NguonTin newNews_NguonTin1 = addNews_NguonTin();
		News_NguonTin newNews_NguonTin2 = addNews_NguonTin();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_NguonTin1.getPrimaryKey());
		primaryKeys.add(newNews_NguonTin2.getPrimaryKey());

		Map<Serializable, News_NguonTin> news_NguonTins =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, news_NguonTins.size());
		Assert.assertEquals(
			newNews_NguonTin1,
			news_NguonTins.get(newNews_NguonTin1.getPrimaryKey()));
		Assert.assertEquals(
			newNews_NguonTin2,
			news_NguonTins.get(newNews_NguonTin2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, News_NguonTin> news_NguonTins =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_NguonTins.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		News_NguonTin newNews_NguonTin = addNews_NguonTin();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_NguonTin.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, News_NguonTin> news_NguonTins =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_NguonTins.size());
		Assert.assertEquals(
			newNews_NguonTin,
			news_NguonTins.get(newNews_NguonTin.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, News_NguonTin> news_NguonTins =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_NguonTins.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		News_NguonTin newNews_NguonTin = addNews_NguonTin();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_NguonTin.getPrimaryKey());

		Map<Serializable, News_NguonTin> news_NguonTins =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_NguonTins.size());
		Assert.assertEquals(
			newNews_NguonTin,
			news_NguonTins.get(newNews_NguonTin.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			News_NguonTinLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<News_NguonTin>() {

				@Override
				public void performAction(News_NguonTin news_NguonTin) {
					Assert.assertNotNull(news_NguonTin);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		News_NguonTin newNews_NguonTin = addNews_NguonTin();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_NguonTin.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNews_NguonTin.getId()));

		List<News_NguonTin> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		News_NguonTin existingNews_NguonTin = result.get(0);

		Assert.assertEquals(existingNews_NguonTin, newNews_NguonTin);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_NguonTin.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<News_NguonTin> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		News_NguonTin newNews_NguonTin = addNews_NguonTin();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_NguonTin.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNews_NguonTin.getId();

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
			News_NguonTin.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected News_NguonTin addNews_NguonTin() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_NguonTin news_NguonTin = _persistence.create(pk);

		news_NguonTin.setCompanyId(RandomTestUtil.nextLong());

		news_NguonTin.setGroupId(RandomTestUtil.nextLong());

		news_NguonTin.setName(RandomTestUtil.randomString());

		news_NguonTin.setStatus(RandomTestUtil.nextInt());

		news_NguonTin.setOrders(RandomTestUtil.nextInt());

		news_NguonTin.setDelete_status(RandomTestUtil.nextInt());

		_news_NguonTins.add(_persistence.update(news_NguonTin));

		return news_NguonTin;
	}

	private List<News_NguonTin> _news_NguonTins =
		new ArrayList<News_NguonTin>();
	private News_NguonTinPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}