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

package qlanphamdb.service.persistence.test;

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

import qlanphamdb.exception.NoSuchAnPham_ActivityException;

import qlanphamdb.model.AnPham_Activity;

import qlanphamdb.service.AnPham_ActivityLocalServiceUtil;
import qlanphamdb.service.persistence.AnPham_ActivityPersistence;
import qlanphamdb.service.persistence.AnPham_ActivityUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AnPham_ActivityPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = AnPham_ActivityUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnPham_Activity> iterator = _anPham_Activities.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Activity anPham_Activity = _persistence.create(pk);

		Assert.assertNotNull(anPham_Activity);

		Assert.assertEquals(anPham_Activity.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnPham_Activity newAnPham_Activity = addAnPham_Activity();

		_persistence.remove(newAnPham_Activity);

		AnPham_Activity existingAnPham_Activity =
			_persistence.fetchByPrimaryKey(newAnPham_Activity.getPrimaryKey());

		Assert.assertNull(existingAnPham_Activity);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnPham_Activity();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Activity newAnPham_Activity = _persistence.create(pk);

		newAnPham_Activity.setCompanyId(RandomTestUtil.nextLong());

		newAnPham_Activity.setGroupId(RandomTestUtil.nextLong());

		newAnPham_Activity.setDeCuongId(RandomTestUtil.nextLong());

		newAnPham_Activity.setAnPhamId(RandomTestUtil.nextLong());

		newAnPham_Activity.setStartuserid(RandomTestUtil.nextLong());

		newAnPham_Activity.setEnduserid(RandomTestUtil.nextLong());

		newAnPham_Activity.setContentrequest(RandomTestUtil.randomString());

		newAnPham_Activity.setStatusofarticle(RandomTestUtil.nextInt());

		_anPham_Activities.add(_persistence.update(newAnPham_Activity));

		AnPham_Activity existingAnPham_Activity = _persistence.findByPrimaryKey(
			newAnPham_Activity.getPrimaryKey());

		Assert.assertEquals(
			existingAnPham_Activity.getCompanyId(),
			newAnPham_Activity.getCompanyId());
		Assert.assertEquals(
			existingAnPham_Activity.getGroupId(),
			newAnPham_Activity.getGroupId());
		Assert.assertEquals(
			existingAnPham_Activity.getId(), newAnPham_Activity.getId());
		Assert.assertEquals(
			existingAnPham_Activity.getDeCuongId(),
			newAnPham_Activity.getDeCuongId());
		Assert.assertEquals(
			existingAnPham_Activity.getAnPhamId(),
			newAnPham_Activity.getAnPhamId());
		Assert.assertEquals(
			existingAnPham_Activity.getStartuserid(),
			newAnPham_Activity.getStartuserid());
		Assert.assertEquals(
			existingAnPham_Activity.getEnduserid(),
			newAnPham_Activity.getEnduserid());
		Assert.assertEquals(
			existingAnPham_Activity.getContentrequest(),
			newAnPham_Activity.getContentrequest());
		Assert.assertEquals(
			existingAnPham_Activity.getStatusofarticle(),
			newAnPham_Activity.getStatusofarticle());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnPham_Activity newAnPham_Activity = addAnPham_Activity();

		AnPham_Activity existingAnPham_Activity = _persistence.findByPrimaryKey(
			newAnPham_Activity.getPrimaryKey());

		Assert.assertEquals(existingAnPham_Activity, newAnPham_Activity);
	}

	@Test(expected = NoSuchAnPham_ActivityException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AnPham_Activity> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_AnPham_Activity", "companyId", true, "groupId", true, "id",
			true, "deCuongId", true, "anPhamId", true, "startuserid", true,
			"enduserid", true, "contentrequest", true, "statusofarticle", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnPham_Activity newAnPham_Activity = addAnPham_Activity();

		AnPham_Activity existingAnPham_Activity =
			_persistence.fetchByPrimaryKey(newAnPham_Activity.getPrimaryKey());

		Assert.assertEquals(existingAnPham_Activity, newAnPham_Activity);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Activity missingAnPham_Activity = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingAnPham_Activity);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AnPham_Activity newAnPham_Activity1 = addAnPham_Activity();
		AnPham_Activity newAnPham_Activity2 = addAnPham_Activity();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_Activity1.getPrimaryKey());
		primaryKeys.add(newAnPham_Activity2.getPrimaryKey());

		Map<Serializable, AnPham_Activity> anPham_Activities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, anPham_Activities.size());
		Assert.assertEquals(
			newAnPham_Activity1,
			anPham_Activities.get(newAnPham_Activity1.getPrimaryKey()));
		Assert.assertEquals(
			newAnPham_Activity2,
			anPham_Activities.get(newAnPham_Activity2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnPham_Activity> anPham_Activities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_Activities.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AnPham_Activity newAnPham_Activity = addAnPham_Activity();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_Activity.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnPham_Activity> anPham_Activities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_Activities.size());
		Assert.assertEquals(
			newAnPham_Activity,
			anPham_Activities.get(newAnPham_Activity.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnPham_Activity> anPham_Activities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_Activities.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AnPham_Activity newAnPham_Activity = addAnPham_Activity();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_Activity.getPrimaryKey());

		Map<Serializable, AnPham_Activity> anPham_Activities =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_Activities.size());
		Assert.assertEquals(
			newAnPham_Activity,
			anPham_Activities.get(newAnPham_Activity.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AnPham_ActivityLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AnPham_Activity>() {

				@Override
				public void performAction(AnPham_Activity anPham_Activity) {
					Assert.assertNotNull(anPham_Activity);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AnPham_Activity newAnPham_Activity = addAnPham_Activity();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_Activity.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newAnPham_Activity.getId()));

		List<AnPham_Activity> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnPham_Activity existingAnPham_Activity = result.get(0);

		Assert.assertEquals(existingAnPham_Activity, newAnPham_Activity);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_Activity.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<AnPham_Activity> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AnPham_Activity newAnPham_Activity = addAnPham_Activity();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_Activity.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newAnPham_Activity.getId();

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
			AnPham_Activity.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnPham_Activity addAnPham_Activity() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Activity anPham_Activity = _persistence.create(pk);

		anPham_Activity.setCompanyId(RandomTestUtil.nextLong());

		anPham_Activity.setGroupId(RandomTestUtil.nextLong());

		anPham_Activity.setDeCuongId(RandomTestUtil.nextLong());

		anPham_Activity.setAnPhamId(RandomTestUtil.nextLong());

		anPham_Activity.setStartuserid(RandomTestUtil.nextLong());

		anPham_Activity.setEnduserid(RandomTestUtil.nextLong());

		anPham_Activity.setContentrequest(RandomTestUtil.randomString());

		anPham_Activity.setStatusofarticle(RandomTestUtil.nextInt());

		_anPham_Activities.add(_persistence.update(anPham_Activity));

		return anPham_Activity;
	}

	private List<AnPham_Activity> _anPham_Activities =
		new ArrayList<AnPham_Activity>();
	private AnPham_ActivityPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}