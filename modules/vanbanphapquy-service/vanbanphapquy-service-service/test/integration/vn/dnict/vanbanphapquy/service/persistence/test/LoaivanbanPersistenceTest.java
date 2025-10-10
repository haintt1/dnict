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

import vn.dnict.vanbanphapquy.exception.NoSuchLoaivanbanException;
import vn.dnict.vanbanphapquy.model.Loaivanban;
import vn.dnict.vanbanphapquy.service.LoaivanbanLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.persistence.LoaivanbanPersistence;
import vn.dnict.vanbanphapquy.service.persistence.LoaivanbanUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class LoaivanbanPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.vanbanphapquy.service"));

	@Before
	public void setUp() {
		_persistence = LoaivanbanUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Loaivanban> iterator = _loaivanbans.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Loaivanban loaivanban = _persistence.create(pk);

		Assert.assertNotNull(loaivanban);

		Assert.assertEquals(loaivanban.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Loaivanban newLoaivanban = addLoaivanban();

		_persistence.remove(newLoaivanban);

		Loaivanban existingLoaivanban = _persistence.fetchByPrimaryKey(
			newLoaivanban.getPrimaryKey());

		Assert.assertNull(existingLoaivanban);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addLoaivanban();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Loaivanban newLoaivanban = _persistence.create(pk);

		newLoaivanban.setCompanyId(RandomTestUtil.nextLong());

		newLoaivanban.setGroupId(RandomTestUtil.nextLong());

		newLoaivanban.setName(RandomTestUtil.randomString());

		newLoaivanban.setCode(RandomTestUtil.randomString());

		newLoaivanban.setStatus(RandomTestUtil.nextInt());

		_loaivanbans.add(_persistence.update(newLoaivanban));

		Loaivanban existingLoaivanban = _persistence.findByPrimaryKey(
			newLoaivanban.getPrimaryKey());

		Assert.assertEquals(existingLoaivanban.getId(), newLoaivanban.getId());
		Assert.assertEquals(
			existingLoaivanban.getCompanyId(), newLoaivanban.getCompanyId());
		Assert.assertEquals(
			existingLoaivanban.getGroupId(), newLoaivanban.getGroupId());
		Assert.assertEquals(
			existingLoaivanban.getName(), newLoaivanban.getName());
		Assert.assertEquals(
			existingLoaivanban.getCode(), newLoaivanban.getCode());
		Assert.assertEquals(
			existingLoaivanban.getStatus(), newLoaivanban.getStatus());
	}

	@Test
	public void testCountByStatus() throws Exception {
		_persistence.countByStatus(RandomTestUtil.nextInt());

		_persistence.countByStatus(0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Loaivanban newLoaivanban = addLoaivanban();

		Loaivanban existingLoaivanban = _persistence.findByPrimaryKey(
			newLoaivanban.getPrimaryKey());

		Assert.assertEquals(existingLoaivanban, newLoaivanban);
	}

	@Test(expected = NoSuchLoaivanbanException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Loaivanban> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_loaivanban", "id", true, "companyId", true, "groupId", true,
			"name", true, "code", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Loaivanban newLoaivanban = addLoaivanban();

		Loaivanban existingLoaivanban = _persistence.fetchByPrimaryKey(
			newLoaivanban.getPrimaryKey());

		Assert.assertEquals(existingLoaivanban, newLoaivanban);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Loaivanban missingLoaivanban = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingLoaivanban);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Loaivanban newLoaivanban1 = addLoaivanban();
		Loaivanban newLoaivanban2 = addLoaivanban();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLoaivanban1.getPrimaryKey());
		primaryKeys.add(newLoaivanban2.getPrimaryKey());

		Map<Serializable, Loaivanban> loaivanbans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, loaivanbans.size());
		Assert.assertEquals(
			newLoaivanban1, loaivanbans.get(newLoaivanban1.getPrimaryKey()));
		Assert.assertEquals(
			newLoaivanban2, loaivanbans.get(newLoaivanban2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Loaivanban> loaivanbans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(loaivanbans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Loaivanban newLoaivanban = addLoaivanban();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLoaivanban.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Loaivanban> loaivanbans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, loaivanbans.size());
		Assert.assertEquals(
			newLoaivanban, loaivanbans.get(newLoaivanban.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Loaivanban> loaivanbans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(loaivanbans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Loaivanban newLoaivanban = addLoaivanban();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLoaivanban.getPrimaryKey());

		Map<Serializable, Loaivanban> loaivanbans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, loaivanbans.size());
		Assert.assertEquals(
			newLoaivanban, loaivanbans.get(newLoaivanban.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			LoaivanbanLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Loaivanban>() {

				@Override
				public void performAction(Loaivanban loaivanban) {
					Assert.assertNotNull(loaivanban);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Loaivanban newLoaivanban = addLoaivanban();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Loaivanban.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newLoaivanban.getId()));

		List<Loaivanban> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Loaivanban existingLoaivanban = result.get(0);

		Assert.assertEquals(existingLoaivanban, newLoaivanban);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Loaivanban.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Loaivanban> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Loaivanban newLoaivanban = addLoaivanban();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Loaivanban.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newLoaivanban.getId();

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
			Loaivanban.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Loaivanban addLoaivanban() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Loaivanban loaivanban = _persistence.create(pk);

		loaivanban.setCompanyId(RandomTestUtil.nextLong());

		loaivanban.setGroupId(RandomTestUtil.nextLong());

		loaivanban.setName(RandomTestUtil.randomString());

		loaivanban.setCode(RandomTestUtil.randomString());

		loaivanban.setStatus(RandomTestUtil.nextInt());

		_loaivanbans.add(_persistence.update(loaivanban));

		return loaivanban;
	}

	private List<Loaivanban> _loaivanbans = new ArrayList<Loaivanban>();
	private LoaivanbanPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}