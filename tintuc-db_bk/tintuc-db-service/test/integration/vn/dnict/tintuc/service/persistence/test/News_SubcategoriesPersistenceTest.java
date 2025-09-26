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

import vn.dnict.tintuc.exception.NoSuchNews_SubcategoriesException;
import vn.dnict.tintuc.model.News_Subcategories;
import vn.dnict.tintuc.service.News_SubcategoriesLocalServiceUtil;
import vn.dnict.tintuc.service.persistence.News_SubcategoriesPersistence;
import vn.dnict.tintuc.service.persistence.News_SubcategoriesUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class News_SubcategoriesPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.tintuc.service"));

	@Before
	public void setUp() {
		_persistence = News_SubcategoriesUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<News_Subcategories> iterator =
			_news_Subcategorieses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Subcategories news_Subcategories = _persistence.create(pk);

		Assert.assertNotNull(news_Subcategories);

		Assert.assertEquals(news_Subcategories.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		News_Subcategories newNews_Subcategories = addNews_Subcategories();

		_persistence.remove(newNews_Subcategories);

		News_Subcategories existingNews_Subcategories =
			_persistence.fetchByPrimaryKey(
				newNews_Subcategories.getPrimaryKey());

		Assert.assertNull(existingNews_Subcategories);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNews_Subcategories();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Subcategories newNews_Subcategories = _persistence.create(pk);

		newNews_Subcategories.setCompanyId(RandomTestUtil.nextLong());

		newNews_Subcategories.setGroupId(RandomTestUtil.nextLong());

		newNews_Subcategories.setName(RandomTestUtil.randomString());

		newNews_Subcategories.setLanguage(RandomTestUtil.randomString());

		newNews_Subcategories.setStatus(RandomTestUtil.nextInt());

		newNews_Subcategories.setOrders(RandomTestUtil.nextInt());

		newNews_Subcategories.setDelete_status(RandomTestUtil.nextInt());

		_news_Subcategorieses.add(_persistence.update(newNews_Subcategories));

		News_Subcategories existingNews_Subcategories =
			_persistence.findByPrimaryKey(
				newNews_Subcategories.getPrimaryKey());

		Assert.assertEquals(
			existingNews_Subcategories.getId(), newNews_Subcategories.getId());
		Assert.assertEquals(
			existingNews_Subcategories.getCompanyId(),
			newNews_Subcategories.getCompanyId());
		Assert.assertEquals(
			existingNews_Subcategories.getGroupId(),
			newNews_Subcategories.getGroupId());
		Assert.assertEquals(
			existingNews_Subcategories.getName(),
			newNews_Subcategories.getName());
		Assert.assertEquals(
			existingNews_Subcategories.getLanguage(),
			newNews_Subcategories.getLanguage());
		Assert.assertEquals(
			existingNews_Subcategories.getStatus(),
			newNews_Subcategories.getStatus());
		Assert.assertEquals(
			existingNews_Subcategories.getOrders(),
			newNews_Subcategories.getOrders());
		Assert.assertEquals(
			existingNews_Subcategories.getDelete_status(),
			newNews_Subcategories.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		News_Subcategories newNews_Subcategories = addNews_Subcategories();

		News_Subcategories existingNews_Subcategories =
			_persistence.findByPrimaryKey(
				newNews_Subcategories.getPrimaryKey());

		Assert.assertEquals(existingNews_Subcategories, newNews_Subcategories);
	}

	@Test(expected = NoSuchNews_SubcategoriesException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<News_Subcategories> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_News_Subcategories", "id", true, "companyId", true, "groupId",
			true, "name", true, "language", true, "status", true, "orders",
			true, "delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		News_Subcategories newNews_Subcategories = addNews_Subcategories();

		News_Subcategories existingNews_Subcategories =
			_persistence.fetchByPrimaryKey(
				newNews_Subcategories.getPrimaryKey());

		Assert.assertEquals(existingNews_Subcategories, newNews_Subcategories);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Subcategories missingNews_Subcategories =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNews_Subcategories);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		News_Subcategories newNews_Subcategories1 = addNews_Subcategories();
		News_Subcategories newNews_Subcategories2 = addNews_Subcategories();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Subcategories1.getPrimaryKey());
		primaryKeys.add(newNews_Subcategories2.getPrimaryKey());

		Map<Serializable, News_Subcategories> news_Subcategorieses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, news_Subcategorieses.size());
		Assert.assertEquals(
			newNews_Subcategories1,
			news_Subcategorieses.get(newNews_Subcategories1.getPrimaryKey()));
		Assert.assertEquals(
			newNews_Subcategories2,
			news_Subcategorieses.get(newNews_Subcategories2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, News_Subcategories> news_Subcategorieses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Subcategorieses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		News_Subcategories newNews_Subcategories = addNews_Subcategories();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Subcategories.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, News_Subcategories> news_Subcategorieses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Subcategorieses.size());
		Assert.assertEquals(
			newNews_Subcategories,
			news_Subcategorieses.get(newNews_Subcategories.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, News_Subcategories> news_Subcategorieses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Subcategorieses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		News_Subcategories newNews_Subcategories = addNews_Subcategories();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Subcategories.getPrimaryKey());

		Map<Serializable, News_Subcategories> news_Subcategorieses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Subcategorieses.size());
		Assert.assertEquals(
			newNews_Subcategories,
			news_Subcategorieses.get(newNews_Subcategories.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			News_SubcategoriesLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<News_Subcategories>() {

				@Override
				public void performAction(
					News_Subcategories news_Subcategories) {

					Assert.assertNotNull(news_Subcategories);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		News_Subcategories newNews_Subcategories = addNews_Subcategories();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Subcategories.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNews_Subcategories.getId()));

		List<News_Subcategories> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		News_Subcategories existingNews_Subcategories = result.get(0);

		Assert.assertEquals(existingNews_Subcategories, newNews_Subcategories);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Subcategories.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<News_Subcategories> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		News_Subcategories newNews_Subcategories = addNews_Subcategories();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Subcategories.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNews_Subcategories.getId();

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
			News_Subcategories.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected News_Subcategories addNews_Subcategories() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Subcategories news_Subcategories = _persistence.create(pk);

		news_Subcategories.setCompanyId(RandomTestUtil.nextLong());

		news_Subcategories.setGroupId(RandomTestUtil.nextLong());

		news_Subcategories.setName(RandomTestUtil.randomString());

		news_Subcategories.setLanguage(RandomTestUtil.randomString());

		news_Subcategories.setStatus(RandomTestUtil.nextInt());

		news_Subcategories.setOrders(RandomTestUtil.nextInt());

		news_Subcategories.setDelete_status(RandomTestUtil.nextInt());

		_news_Subcategorieses.add(_persistence.update(news_Subcategories));

		return news_Subcategories;
	}

	private List<News_Subcategories> _news_Subcategorieses =
		new ArrayList<News_Subcategories>();
	private News_SubcategoriesPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}