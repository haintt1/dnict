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
import com.liferay.portal.kernel.util.Time;
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

import qlanphamdb.exception.NoSucheMagazine_BinhLuanException;

import qlanphamdb.model.eMagazine_BinhLuan;

import qlanphamdb.service.eMagazine_BinhLuanLocalServiceUtil;
import qlanphamdb.service.persistence.eMagazine_BinhLuanPersistence;
import qlanphamdb.service.persistence.eMagazine_BinhLuanUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class eMagazine_BinhLuanPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = eMagazine_BinhLuanUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<eMagazine_BinhLuan> iterator = _eMagazine_BinhLuans.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_BinhLuan eMagazine_BinhLuan = _persistence.create(pk);

		Assert.assertNotNull(eMagazine_BinhLuan);

		Assert.assertEquals(eMagazine_BinhLuan.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		eMagazine_BinhLuan neweMagazine_BinhLuan = addeMagazine_BinhLuan();

		_persistence.remove(neweMagazine_BinhLuan);

		eMagazine_BinhLuan existingeMagazine_BinhLuan =
			_persistence.fetchByPrimaryKey(
				neweMagazine_BinhLuan.getPrimaryKey());

		Assert.assertNull(existingeMagazine_BinhLuan);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addeMagazine_BinhLuan();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_BinhLuan neweMagazine_BinhLuan = _persistence.create(pk);

		neweMagazine_BinhLuan.setCompanyId(RandomTestUtil.nextLong());

		neweMagazine_BinhLuan.setGroupId(RandomTestUtil.nextLong());

		neweMagazine_BinhLuan.setMagazineId(RandomTestUtil.nextLong());

		neweMagazine_BinhLuan.setHoTen(RandomTestUtil.randomString());

		neweMagazine_BinhLuan.setNoiDung(RandomTestUtil.randomString());

		neweMagazine_BinhLuan.setNgayBinhLuan(RandomTestUtil.nextDate());

		neweMagazine_BinhLuan.setStatus(RandomTestUtil.nextInt());

		neweMagazine_BinhLuan.setOrders(RandomTestUtil.nextInt());

		neweMagazine_BinhLuan.setDelete_status(RandomTestUtil.nextInt());

		_eMagazine_BinhLuans.add(_persistence.update(neweMagazine_BinhLuan));

		eMagazine_BinhLuan existingeMagazine_BinhLuan =
			_persistence.findByPrimaryKey(
				neweMagazine_BinhLuan.getPrimaryKey());

		Assert.assertEquals(
			existingeMagazine_BinhLuan.getId(), neweMagazine_BinhLuan.getId());
		Assert.assertEquals(
			existingeMagazine_BinhLuan.getCompanyId(),
			neweMagazine_BinhLuan.getCompanyId());
		Assert.assertEquals(
			existingeMagazine_BinhLuan.getGroupId(),
			neweMagazine_BinhLuan.getGroupId());
		Assert.assertEquals(
			existingeMagazine_BinhLuan.getMagazineId(),
			neweMagazine_BinhLuan.getMagazineId());
		Assert.assertEquals(
			existingeMagazine_BinhLuan.getHoTen(),
			neweMagazine_BinhLuan.getHoTen());
		Assert.assertEquals(
			existingeMagazine_BinhLuan.getNoiDung(),
			neweMagazine_BinhLuan.getNoiDung());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingeMagazine_BinhLuan.getNgayBinhLuan()),
			Time.getShortTimestamp(neweMagazine_BinhLuan.getNgayBinhLuan()));
		Assert.assertEquals(
			existingeMagazine_BinhLuan.getStatus(),
			neweMagazine_BinhLuan.getStatus());
		Assert.assertEquals(
			existingeMagazine_BinhLuan.getOrders(),
			neweMagazine_BinhLuan.getOrders());
		Assert.assertEquals(
			existingeMagazine_BinhLuan.getDelete_status(),
			neweMagazine_BinhLuan.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		eMagazine_BinhLuan neweMagazine_BinhLuan = addeMagazine_BinhLuan();

		eMagazine_BinhLuan existingeMagazine_BinhLuan =
			_persistence.findByPrimaryKey(
				neweMagazine_BinhLuan.getPrimaryKey());

		Assert.assertEquals(existingeMagazine_BinhLuan, neweMagazine_BinhLuan);
	}

	@Test(expected = NoSucheMagazine_BinhLuanException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<eMagazine_BinhLuan> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_eMagazine_BinhLuan", "id", true, "companyId", true, "groupId",
			true, "magazineId", true, "hoTen", true, "noiDung", true,
			"ngayBinhLuan", true, "status", true, "orders", true,
			"delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		eMagazine_BinhLuan neweMagazine_BinhLuan = addeMagazine_BinhLuan();

		eMagazine_BinhLuan existingeMagazine_BinhLuan =
			_persistence.fetchByPrimaryKey(
				neweMagazine_BinhLuan.getPrimaryKey());

		Assert.assertEquals(existingeMagazine_BinhLuan, neweMagazine_BinhLuan);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_BinhLuan missingeMagazine_BinhLuan =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingeMagazine_BinhLuan);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		eMagazine_BinhLuan neweMagazine_BinhLuan1 = addeMagazine_BinhLuan();
		eMagazine_BinhLuan neweMagazine_BinhLuan2 = addeMagazine_BinhLuan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine_BinhLuan1.getPrimaryKey());
		primaryKeys.add(neweMagazine_BinhLuan2.getPrimaryKey());

		Map<Serializable, eMagazine_BinhLuan> eMagazine_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, eMagazine_BinhLuans.size());
		Assert.assertEquals(
			neweMagazine_BinhLuan1,
			eMagazine_BinhLuans.get(neweMagazine_BinhLuan1.getPrimaryKey()));
		Assert.assertEquals(
			neweMagazine_BinhLuan2,
			eMagazine_BinhLuans.get(neweMagazine_BinhLuan2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, eMagazine_BinhLuan> eMagazine_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eMagazine_BinhLuans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		eMagazine_BinhLuan neweMagazine_BinhLuan = addeMagazine_BinhLuan();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine_BinhLuan.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, eMagazine_BinhLuan> eMagazine_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eMagazine_BinhLuans.size());
		Assert.assertEquals(
			neweMagazine_BinhLuan,
			eMagazine_BinhLuans.get(neweMagazine_BinhLuan.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, eMagazine_BinhLuan> eMagazine_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eMagazine_BinhLuans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		eMagazine_BinhLuan neweMagazine_BinhLuan = addeMagazine_BinhLuan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine_BinhLuan.getPrimaryKey());

		Map<Serializable, eMagazine_BinhLuan> eMagazine_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eMagazine_BinhLuans.size());
		Assert.assertEquals(
			neweMagazine_BinhLuan,
			eMagazine_BinhLuans.get(neweMagazine_BinhLuan.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			eMagazine_BinhLuanLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<eMagazine_BinhLuan>() {

				@Override
				public void performAction(
					eMagazine_BinhLuan eMagazine_BinhLuan) {

					Assert.assertNotNull(eMagazine_BinhLuan);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		eMagazine_BinhLuan neweMagazine_BinhLuan = addeMagazine_BinhLuan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", neweMagazine_BinhLuan.getId()));

		List<eMagazine_BinhLuan> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		eMagazine_BinhLuan existingeMagazine_BinhLuan = result.get(0);

		Assert.assertEquals(existingeMagazine_BinhLuan, neweMagazine_BinhLuan);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<eMagazine_BinhLuan> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		eMagazine_BinhLuan neweMagazine_BinhLuan = addeMagazine_BinhLuan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = neweMagazine_BinhLuan.getId();

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
			eMagazine_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected eMagazine_BinhLuan addeMagazine_BinhLuan() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_BinhLuan eMagazine_BinhLuan = _persistence.create(pk);

		eMagazine_BinhLuan.setCompanyId(RandomTestUtil.nextLong());

		eMagazine_BinhLuan.setGroupId(RandomTestUtil.nextLong());

		eMagazine_BinhLuan.setMagazineId(RandomTestUtil.nextLong());

		eMagazine_BinhLuan.setHoTen(RandomTestUtil.randomString());

		eMagazine_BinhLuan.setNoiDung(RandomTestUtil.randomString());

		eMagazine_BinhLuan.setNgayBinhLuan(RandomTestUtil.nextDate());

		eMagazine_BinhLuan.setStatus(RandomTestUtil.nextInt());

		eMagazine_BinhLuan.setOrders(RandomTestUtil.nextInt());

		eMagazine_BinhLuan.setDelete_status(RandomTestUtil.nextInt());

		_eMagazine_BinhLuans.add(_persistence.update(eMagazine_BinhLuan));

		return eMagazine_BinhLuan;
	}

	private List<eMagazine_BinhLuan> _eMagazine_BinhLuans =
		new ArrayList<eMagazine_BinhLuan>();
	private eMagazine_BinhLuanPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}