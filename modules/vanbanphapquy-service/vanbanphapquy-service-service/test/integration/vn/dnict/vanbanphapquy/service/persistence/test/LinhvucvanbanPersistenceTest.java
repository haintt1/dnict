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

package vn.dnict.vanbanphapquy.service.persistence.test;

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

import vn.dnict.vanbanphapquy.exception.NoSuchLinhvucvanbanException;
import vn.dnict.vanbanphapquy.model.Linhvucvanban;
import vn.dnict.vanbanphapquy.service.LinhvucvanbanLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.persistence.LinhvucvanbanPersistence;
import vn.dnict.vanbanphapquy.service.persistence.LinhvucvanbanUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class LinhvucvanbanPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.vanbanphapquy.service"));

	@Before
	public void setUp() {
		_persistence = LinhvucvanbanUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Linhvucvanban> iterator = _linhvucvanbans.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Linhvucvanban linhvucvanban = _persistence.create(pk);

		Assert.assertNotNull(linhvucvanban);

		Assert.assertEquals(linhvucvanban.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Linhvucvanban newLinhvucvanban = addLinhvucvanban();

		_persistence.remove(newLinhvucvanban);

		Linhvucvanban existingLinhvucvanban = _persistence.fetchByPrimaryKey(
			newLinhvucvanban.getPrimaryKey());

		Assert.assertNull(existingLinhvucvanban);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addLinhvucvanban();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Linhvucvanban newLinhvucvanban = _persistence.create(pk);

		newLinhvucvanban.setCompanyId(RandomTestUtil.nextLong());

		newLinhvucvanban.setGroupId(RandomTestUtil.nextLong());

		newLinhvucvanban.setName(RandomTestUtil.randomString());

		newLinhvucvanban.setCode(RandomTestUtil.randomString());

		newLinhvucvanban.setStatus(RandomTestUtil.nextInt());

		_linhvucvanbans.add(_persistence.update(newLinhvucvanban));

		Linhvucvanban existingLinhvucvanban = _persistence.findByPrimaryKey(
			newLinhvucvanban.getPrimaryKey());

		Assert.assertEquals(
			existingLinhvucvanban.getId(), newLinhvucvanban.getId());
		Assert.assertEquals(
			existingLinhvucvanban.getCompanyId(),
			newLinhvucvanban.getCompanyId());
		Assert.assertEquals(
			existingLinhvucvanban.getGroupId(), newLinhvucvanban.getGroupId());
		Assert.assertEquals(
			existingLinhvucvanban.getName(), newLinhvucvanban.getName());
		Assert.assertEquals(
			existingLinhvucvanban.getCode(), newLinhvucvanban.getCode());
		Assert.assertEquals(
			existingLinhvucvanban.getStatus(), newLinhvucvanban.getStatus());
	}

	@Test
	public void testCountByStatus() throws Exception {
		_persistence.countByStatus(RandomTestUtil.nextInt());

		_persistence.countByStatus(0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Linhvucvanban newLinhvucvanban = addLinhvucvanban();

		Linhvucvanban existingLinhvucvanban = _persistence.findByPrimaryKey(
			newLinhvucvanban.getPrimaryKey());

		Assert.assertEquals(existingLinhvucvanban, newLinhvucvanban);
	}

	@Test(expected = NoSuchLinhvucvanbanException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Linhvucvanban> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_linhvucvanban", "id", true, "companyId", true, "groupId", true,
			"name", true, "code", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Linhvucvanban newLinhvucvanban = addLinhvucvanban();

		Linhvucvanban existingLinhvucvanban = _persistence.fetchByPrimaryKey(
			newLinhvucvanban.getPrimaryKey());

		Assert.assertEquals(existingLinhvucvanban, newLinhvucvanban);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Linhvucvanban missingLinhvucvanban = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingLinhvucvanban);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Linhvucvanban newLinhvucvanban1 = addLinhvucvanban();
		Linhvucvanban newLinhvucvanban2 = addLinhvucvanban();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLinhvucvanban1.getPrimaryKey());
		primaryKeys.add(newLinhvucvanban2.getPrimaryKey());

		Map<Serializable, Linhvucvanban> linhvucvanbans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, linhvucvanbans.size());
		Assert.assertEquals(
			newLinhvucvanban1,
			linhvucvanbans.get(newLinhvucvanban1.getPrimaryKey()));
		Assert.assertEquals(
			newLinhvucvanban2,
			linhvucvanbans.get(newLinhvucvanban2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Linhvucvanban> linhvucvanbans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(linhvucvanbans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Linhvucvanban newLinhvucvanban = addLinhvucvanban();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLinhvucvanban.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Linhvucvanban> linhvucvanbans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, linhvucvanbans.size());
		Assert.assertEquals(
			newLinhvucvanban,
			linhvucvanbans.get(newLinhvucvanban.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Linhvucvanban> linhvucvanbans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(linhvucvanbans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Linhvucvanban newLinhvucvanban = addLinhvucvanban();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLinhvucvanban.getPrimaryKey());

		Map<Serializable, Linhvucvanban> linhvucvanbans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, linhvucvanbans.size());
		Assert.assertEquals(
			newLinhvucvanban,
			linhvucvanbans.get(newLinhvucvanban.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			LinhvucvanbanLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Linhvucvanban>() {

				@Override
				public void performAction(Linhvucvanban linhvucvanban) {
					Assert.assertNotNull(linhvucvanban);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Linhvucvanban newLinhvucvanban = addLinhvucvanban();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Linhvucvanban.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newLinhvucvanban.getId()));

		List<Linhvucvanban> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Linhvucvanban existingLinhvucvanban = result.get(0);

		Assert.assertEquals(existingLinhvucvanban, newLinhvucvanban);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Linhvucvanban.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Linhvucvanban> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Linhvucvanban newLinhvucvanban = addLinhvucvanban();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Linhvucvanban.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newLinhvucvanban.getId();

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
			Linhvucvanban.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Linhvucvanban addLinhvucvanban() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Linhvucvanban linhvucvanban = _persistence.create(pk);

		linhvucvanban.setCompanyId(RandomTestUtil.nextLong());

		linhvucvanban.setGroupId(RandomTestUtil.nextLong());

		linhvucvanban.setName(RandomTestUtil.randomString());

		linhvucvanban.setCode(RandomTestUtil.randomString());

		linhvucvanban.setStatus(RandomTestUtil.nextInt());

		_linhvucvanbans.add(_persistence.update(linhvucvanban));

		return linhvucvanban;
	}

	private List<Linhvucvanban> _linhvucvanbans =
		new ArrayList<Linhvucvanban>();
	private LinhvucvanbanPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}