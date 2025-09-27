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

import vn.dnict.tintuc.exception.NoSuchNews_ActivityException;
import vn.dnict.tintuc.model.News_Activity;
import vn.dnict.tintuc.service.News_ActivityLocalServiceUtil;
import vn.dnict.tintuc.service.persistence.News_ActivityPersistence;
import vn.dnict.tintuc.service.persistence.News_ActivityUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class News_ActivityPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.tintuc.service"));

	@Before
	public void setUp() {
		_persistence = News_ActivityUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<News_Activity> iterator = _news_Activities.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Activity news_Activity = _persistence.create(pk);

		Assert.assertNotNull(news_Activity);

		Assert.assertEquals(news_Activity.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		News_Activity newNews_Activity = addNews_Activity();

		_persistence.remove(newNews_Activity);

		News_Activity existingNews_Activity = _persistence.fetchByPrimaryKey(
			newNews_Activity.getPrimaryKey());

		Assert.assertNull(existingNews_Activity);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNews_Activity();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Activity newNews_Activity = _persistence.create(pk);

		newNews_Activity.setCompanyId(RandomTestUtil.nextLong());

		newNews_Activity.setGroupId(RandomTestUtil.nextLong());

		newNews_Activity.setArticleid(RandomTestUtil.nextLong());

		newNews_Activity.setStartuserid(RandomTestUtil.nextLong());

		newNews_Activity.setEnduserid(RandomTestUtil.nextLong());

		newNews_Activity.setContentrequest(RandomTestUtil.randomString());

		newNews_Activity.setStatusofarticle(RandomTestUtil.nextInt());

		_news_Activities.add(_persistence.update(newNews_Activity));

		News_Activity existingNews_Activity = _persistence.findByPrimaryKey(
			newNews_Activity.getPrimaryKey());

		Assert.assertEquals(
			existingNews_Activity.getCompanyId(),
			newNews_Activity.getCompanyId());
		Assert.assertEquals(
			existingNews_Activity.getGroupId(), newNews_Activity.getGroupId());
		Assert.assertEquals(
			existingNews_Activity.getId(), newNews_Activity.getId());
		Assert.assertEquals(
			existingNews_Activity.getArticleid(),
			newNews_Activity.getArticleid());
		Assert.assertEquals(
			existingNews_Activity.getStartuserid(),
			newNews_Activity.getStartuserid());
		Assert.assertEquals(
			existingNews_Activity.getEnduserid(),
			newNews_Activity.getEnduserid());
		Assert.assertEquals(
			existingNews_Activity.getContentrequest(),
			newNews_Activity.getContentrequest());
		Assert.assertEquals(
			existingNews_Activity.getStatusofarticle(),
			newNews_Activity.getStatusofarticle());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		News_Activity newNews_Activity = addNews_Activity();

		News_Activity existingNews_Activity = _persistence.findByPrimaryKey(
			newNews_Activity.getPrimaryKey());

		Assert.assertEquals(existingNews_Activity, newNews_Activity);
	}

	@Test(expected = NoSuchNews_ActivityException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<News_Activity> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_News_Activity", "companyId", true, "groupId", true, "id", true,
			"articleid", true, "startuserid", true, "enduserid", true,
			"statusofarticle", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		News_Activity newNews_Activity = addNews_Activity();

		News_Activity existingNews_Activity = _persistence.fetchByPrimaryKey(
			newNews_Activity.getPrimaryKey());

		Assert.assertEquals(existingNews_Activity, newNews_Activity);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Activity missingNews_Activity = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNews_Activity);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		News_Activity newNews_Activity1 = addNews_Activity();
		News_Activity newNews_Activity2 = addNews_Activity();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Activity1.getPrimaryKey());
		primaryKeys.add(newNews_Activity2.getPrimaryKey());

		Map<Serializable, News_Activity> news_Activities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, news_Activities.size());
		Assert.assertEquals(
			newNews_Activity1,
			news_Activities.get(newNews_Activity1.getPrimaryKey()));
		Assert.assertEquals(
			newNews_Activity2,
			news_Activities.get(newNews_Activity2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, News_Activity> news_Activities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Activities.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		News_Activity newNews_Activity = addNews_Activity();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Activity.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, News_Activity> news_Activities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Activities.size());
		Assert.assertEquals(
			newNews_Activity,
			news_Activities.get(newNews_Activity.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, News_Activity> news_Activities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Activities.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		News_Activity newNews_Activity = addNews_Activity();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Activity.getPrimaryKey());

		Map<Serializable, News_Activity> news_Activities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Activities.size());
		Assert.assertEquals(
			newNews_Activity,
			news_Activities.get(newNews_Activity.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			News_ActivityLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<News_Activity>() {

				@Override
				public void performAction(News_Activity news_Activity) {
					Assert.assertNotNull(news_Activity);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		News_Activity newNews_Activity = addNews_Activity();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Activity.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNews_Activity.getId()));

		List<News_Activity> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		News_Activity existingNews_Activity = result.get(0);

		Assert.assertEquals(existingNews_Activity, newNews_Activity);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Activity.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<News_Activity> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		News_Activity newNews_Activity = addNews_Activity();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Activity.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNews_Activity.getId();

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
			News_Activity.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected News_Activity addNews_Activity() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Activity news_Activity = _persistence.create(pk);

		news_Activity.setCompanyId(RandomTestUtil.nextLong());

		news_Activity.setGroupId(RandomTestUtil.nextLong());

		news_Activity.setArticleid(RandomTestUtil.nextLong());

		news_Activity.setStartuserid(RandomTestUtil.nextLong());

		news_Activity.setEnduserid(RandomTestUtil.nextLong());

		news_Activity.setContentrequest(RandomTestUtil.randomString());

		news_Activity.setStatusofarticle(RandomTestUtil.nextInt());

		_news_Activities.add(_persistence.update(news_Activity));

		return news_Activity;
	}

	private List<News_Activity> _news_Activities =
		new ArrayList<News_Activity>();
	private News_ActivityPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}