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

import vn.dnict.tintuc.exception.NoSuchNews_roleException;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_roleLocalServiceUtil;
import vn.dnict.tintuc.service.persistence.News_rolePersistence;
import vn.dnict.tintuc.service.persistence.News_roleUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class News_rolePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.tintuc.service"));

	@Before
	public void setUp() {
		_persistence = News_roleUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<News_role> iterator = _news_roles.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_role news_role = _persistence.create(pk);

		Assert.assertNotNull(news_role);

		Assert.assertEquals(news_role.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		News_role newNews_role = addNews_role();

		_persistence.remove(newNews_role);

		News_role existingNews_role = _persistence.fetchByPrimaryKey(
			newNews_role.getPrimaryKey());

		Assert.assertNull(existingNews_role);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNews_role();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_role newNews_role = _persistence.create(pk);

		newNews_role.setCompanyId(RandomTestUtil.nextLong());

		newNews_role.setGroupId(RandomTestUtil.nextLong());

		newNews_role.setUserid(RandomTestUtil.nextLong());

		newNews_role.setRole_add(RandomTestUtil.nextInt());

		newNews_role.setRole_edit(RandomTestUtil.nextInt());

		newNews_role.setRole_public(RandomTestUtil.nextInt());

		newNews_role.setCategory_active_role(RandomTestUtil.randomString());

		_news_roles.add(_persistence.update(newNews_role));

		News_role existingNews_role = _persistence.findByPrimaryKey(
			newNews_role.getPrimaryKey());

		Assert.assertEquals(
			existingNews_role.getCompanyId(), newNews_role.getCompanyId());
		Assert.assertEquals(
			existingNews_role.getGroupId(), newNews_role.getGroupId());
		Assert.assertEquals(existingNews_role.getId(), newNews_role.getId());
		Assert.assertEquals(
			existingNews_role.getUserid(), newNews_role.getUserid());
		Assert.assertEquals(
			existingNews_role.getRole_add(), newNews_role.getRole_add());
		Assert.assertEquals(
			existingNews_role.getRole_edit(), newNews_role.getRole_edit());
		Assert.assertEquals(
			existingNews_role.getRole_public(), newNews_role.getRole_public());
		Assert.assertEquals(
			existingNews_role.getCategory_active_role(),
			newNews_role.getCategory_active_role());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		News_role newNews_role = addNews_role();

		News_role existingNews_role = _persistence.findByPrimaryKey(
			newNews_role.getPrimaryKey());

		Assert.assertEquals(existingNews_role, newNews_role);
	}

	@Test(expected = NoSuchNews_roleException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<News_role> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_News_role", "companyId", true, "groupId", true, "id", true,
			"userid", true, "role_add", true, "role_edit", true, "role_public",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		News_role newNews_role = addNews_role();

		News_role existingNews_role = _persistence.fetchByPrimaryKey(
			newNews_role.getPrimaryKey());

		Assert.assertEquals(existingNews_role, newNews_role);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_role missingNews_role = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNews_role);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		News_role newNews_role1 = addNews_role();
		News_role newNews_role2 = addNews_role();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_role1.getPrimaryKey());
		primaryKeys.add(newNews_role2.getPrimaryKey());

		Map<Serializable, News_role> news_roles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, news_roles.size());
		Assert.assertEquals(
			newNews_role1, news_roles.get(newNews_role1.getPrimaryKey()));
		Assert.assertEquals(
			newNews_role2, news_roles.get(newNews_role2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, News_role> news_roles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_roles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		News_role newNews_role = addNews_role();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_role.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, News_role> news_roles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_roles.size());
		Assert.assertEquals(
			newNews_role, news_roles.get(newNews_role.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, News_role> news_roles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_roles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		News_role newNews_role = addNews_role();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_role.getPrimaryKey());

		Map<Serializable, News_role> news_roles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_roles.size());
		Assert.assertEquals(
			newNews_role, news_roles.get(newNews_role.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			News_roleLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<News_role>() {

				@Override
				public void performAction(News_role news_role) {
					Assert.assertNotNull(news_role);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		News_role newNews_role = addNews_role();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_role.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNews_role.getId()));

		List<News_role> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		News_role existingNews_role = result.get(0);

		Assert.assertEquals(existingNews_role, newNews_role);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_role.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<News_role> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		News_role newNews_role = addNews_role();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_role.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNews_role.getId();

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
			News_role.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected News_role addNews_role() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_role news_role = _persistence.create(pk);

		news_role.setCompanyId(RandomTestUtil.nextLong());

		news_role.setGroupId(RandomTestUtil.nextLong());

		news_role.setUserid(RandomTestUtil.nextLong());

		news_role.setRole_add(RandomTestUtil.nextInt());

		news_role.setRole_edit(RandomTestUtil.nextInt());

		news_role.setRole_public(RandomTestUtil.nextInt());

		news_role.setCategory_active_role(RandomTestUtil.randomString());

		_news_roles.add(_persistence.update(news_role));

		return news_role;
	}

	private List<News_role> _news_roles = new ArrayList<News_role>();
	private News_rolePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}