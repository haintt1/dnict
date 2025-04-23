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

import qlanphamdb.exception.NoSuchAnPham_BinhLuanException;

import qlanphamdb.model.AnPham_BinhLuan;

import qlanphamdb.service.AnPham_BinhLuanLocalServiceUtil;
import qlanphamdb.service.persistence.AnPham_BinhLuanPersistence;
import qlanphamdb.service.persistence.AnPham_BinhLuanUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AnPham_BinhLuanPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = AnPham_BinhLuanUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnPham_BinhLuan> iterator = _anPham_BinhLuans.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_BinhLuan anPham_BinhLuan = _persistence.create(pk);

		Assert.assertNotNull(anPham_BinhLuan);

		Assert.assertEquals(anPham_BinhLuan.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnPham_BinhLuan newAnPham_BinhLuan = addAnPham_BinhLuan();

		_persistence.remove(newAnPham_BinhLuan);

		AnPham_BinhLuan existingAnPham_BinhLuan =
			_persistence.fetchByPrimaryKey(newAnPham_BinhLuan.getPrimaryKey());

		Assert.assertNull(existingAnPham_BinhLuan);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnPham_BinhLuan();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_BinhLuan newAnPham_BinhLuan = _persistence.create(pk);

		newAnPham_BinhLuan.setCompanyId(RandomTestUtil.nextLong());

		newAnPham_BinhLuan.setGroupId(RandomTestUtil.nextLong());

		newAnPham_BinhLuan.setAnPhamId(RandomTestUtil.nextLong());

		newAnPham_BinhLuan.setHoTen(RandomTestUtil.randomString());

		newAnPham_BinhLuan.setNoiDung(RandomTestUtil.randomString());

		newAnPham_BinhLuan.setNgayBinhLuan(RandomTestUtil.nextDate());

		newAnPham_BinhLuan.setStatus(RandomTestUtil.nextInt());

		newAnPham_BinhLuan.setOrders(RandomTestUtil.nextInt());

		newAnPham_BinhLuan.setDelete_status(RandomTestUtil.nextInt());

		_anPham_BinhLuans.add(_persistence.update(newAnPham_BinhLuan));

		AnPham_BinhLuan existingAnPham_BinhLuan = _persistence.findByPrimaryKey(
			newAnPham_BinhLuan.getPrimaryKey());

		Assert.assertEquals(
			existingAnPham_BinhLuan.getId(), newAnPham_BinhLuan.getId());
		Assert.assertEquals(
			existingAnPham_BinhLuan.getCompanyId(),
			newAnPham_BinhLuan.getCompanyId());
		Assert.assertEquals(
			existingAnPham_BinhLuan.getGroupId(),
			newAnPham_BinhLuan.getGroupId());
		Assert.assertEquals(
			existingAnPham_BinhLuan.getAnPhamId(),
			newAnPham_BinhLuan.getAnPhamId());
		Assert.assertEquals(
			existingAnPham_BinhLuan.getHoTen(), newAnPham_BinhLuan.getHoTen());
		Assert.assertEquals(
			existingAnPham_BinhLuan.getNoiDung(),
			newAnPham_BinhLuan.getNoiDung());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_BinhLuan.getNgayBinhLuan()),
			Time.getShortTimestamp(newAnPham_BinhLuan.getNgayBinhLuan()));
		Assert.assertEquals(
			existingAnPham_BinhLuan.getStatus(),
			newAnPham_BinhLuan.getStatus());
		Assert.assertEquals(
			existingAnPham_BinhLuan.getOrders(),
			newAnPham_BinhLuan.getOrders());
		Assert.assertEquals(
			existingAnPham_BinhLuan.getDelete_status(),
			newAnPham_BinhLuan.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnPham_BinhLuan newAnPham_BinhLuan = addAnPham_BinhLuan();

		AnPham_BinhLuan existingAnPham_BinhLuan = _persistence.findByPrimaryKey(
			newAnPham_BinhLuan.getPrimaryKey());

		Assert.assertEquals(existingAnPham_BinhLuan, newAnPham_BinhLuan);
	}

	@Test(expected = NoSuchAnPham_BinhLuanException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AnPham_BinhLuan> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_AnPham_BinhLuan", "id", true, "companyId", true, "groupId",
			true, "anPhamId", true, "hoTen", true, "noiDung", true,
			"ngayBinhLuan", true, "status", true, "orders", true,
			"delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnPham_BinhLuan newAnPham_BinhLuan = addAnPham_BinhLuan();

		AnPham_BinhLuan existingAnPham_BinhLuan =
			_persistence.fetchByPrimaryKey(newAnPham_BinhLuan.getPrimaryKey());

		Assert.assertEquals(existingAnPham_BinhLuan, newAnPham_BinhLuan);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_BinhLuan missingAnPham_BinhLuan = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingAnPham_BinhLuan);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AnPham_BinhLuan newAnPham_BinhLuan1 = addAnPham_BinhLuan();
		AnPham_BinhLuan newAnPham_BinhLuan2 = addAnPham_BinhLuan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_BinhLuan1.getPrimaryKey());
		primaryKeys.add(newAnPham_BinhLuan2.getPrimaryKey());

		Map<Serializable, AnPham_BinhLuan> anPham_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, anPham_BinhLuans.size());
		Assert.assertEquals(
			newAnPham_BinhLuan1,
			anPham_BinhLuans.get(newAnPham_BinhLuan1.getPrimaryKey()));
		Assert.assertEquals(
			newAnPham_BinhLuan2,
			anPham_BinhLuans.get(newAnPham_BinhLuan2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnPham_BinhLuan> anPham_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_BinhLuans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AnPham_BinhLuan newAnPham_BinhLuan = addAnPham_BinhLuan();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_BinhLuan.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnPham_BinhLuan> anPham_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_BinhLuans.size());
		Assert.assertEquals(
			newAnPham_BinhLuan,
			anPham_BinhLuans.get(newAnPham_BinhLuan.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnPham_BinhLuan> anPham_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_BinhLuans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AnPham_BinhLuan newAnPham_BinhLuan = addAnPham_BinhLuan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_BinhLuan.getPrimaryKey());

		Map<Serializable, AnPham_BinhLuan> anPham_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_BinhLuans.size());
		Assert.assertEquals(
			newAnPham_BinhLuan,
			anPham_BinhLuans.get(newAnPham_BinhLuan.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AnPham_BinhLuanLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AnPham_BinhLuan>() {

				@Override
				public void performAction(AnPham_BinhLuan anPham_BinhLuan) {
					Assert.assertNotNull(anPham_BinhLuan);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AnPham_BinhLuan newAnPham_BinhLuan = addAnPham_BinhLuan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newAnPham_BinhLuan.getId()));

		List<AnPham_BinhLuan> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnPham_BinhLuan existingAnPham_BinhLuan = result.get(0);

		Assert.assertEquals(existingAnPham_BinhLuan, newAnPham_BinhLuan);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<AnPham_BinhLuan> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AnPham_BinhLuan newAnPham_BinhLuan = addAnPham_BinhLuan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newAnPham_BinhLuan.getId();

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
			AnPham_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnPham_BinhLuan addAnPham_BinhLuan() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_BinhLuan anPham_BinhLuan = _persistence.create(pk);

		anPham_BinhLuan.setCompanyId(RandomTestUtil.nextLong());

		anPham_BinhLuan.setGroupId(RandomTestUtil.nextLong());

		anPham_BinhLuan.setAnPhamId(RandomTestUtil.nextLong());

		anPham_BinhLuan.setHoTen(RandomTestUtil.randomString());

		anPham_BinhLuan.setNoiDung(RandomTestUtil.randomString());

		anPham_BinhLuan.setNgayBinhLuan(RandomTestUtil.nextDate());

		anPham_BinhLuan.setStatus(RandomTestUtil.nextInt());

		anPham_BinhLuan.setOrders(RandomTestUtil.nextInt());

		anPham_BinhLuan.setDelete_status(RandomTestUtil.nextInt());

		_anPham_BinhLuans.add(_persistence.update(anPham_BinhLuan));

		return anPham_BinhLuan;
	}

	private List<AnPham_BinhLuan> _anPham_BinhLuans =
		new ArrayList<AnPham_BinhLuan>();
	private AnPham_BinhLuanPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}