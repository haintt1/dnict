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

import qlanphamdb.exception.NoSuchAnPham_CongTacVienException;

import qlanphamdb.model.AnPham_CongTacVien;

import qlanphamdb.service.AnPham_CongTacVienLocalServiceUtil;
import qlanphamdb.service.persistence.AnPham_CongTacVienPersistence;
import qlanphamdb.service.persistence.AnPham_CongTacVienUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AnPham_CongTacVienPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = AnPham_CongTacVienUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnPham_CongTacVien> iterator = _anPham_CongTacViens.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_CongTacVien anPham_CongTacVien = _persistence.create(pk);

		Assert.assertNotNull(anPham_CongTacVien);

		Assert.assertEquals(anPham_CongTacVien.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnPham_CongTacVien newAnPham_CongTacVien = addAnPham_CongTacVien();

		_persistence.remove(newAnPham_CongTacVien);

		AnPham_CongTacVien existingAnPham_CongTacVien =
			_persistence.fetchByPrimaryKey(
				newAnPham_CongTacVien.getPrimaryKey());

		Assert.assertNull(existingAnPham_CongTacVien);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnPham_CongTacVien();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_CongTacVien newAnPham_CongTacVien = _persistence.create(pk);

		newAnPham_CongTacVien.setGroupId(RandomTestUtil.nextLong());

		newAnPham_CongTacVien.setCompanyId(RandomTestUtil.nextLong());

		newAnPham_CongTacVien.setHoTen(RandomTestUtil.randomString());

		newAnPham_CongTacVien.setEmail(RandomTestUtil.randomString());

		newAnPham_CongTacVien.setThongTin(RandomTestUtil.randomString());

		newAnPham_CongTacVien.setStatus(RandomTestUtil.nextInt());

		newAnPham_CongTacVien.setOrders(RandomTestUtil.nextLong());

		newAnPham_CongTacVien.setDelete_status(RandomTestUtil.nextInt());

		_anPham_CongTacViens.add(_persistence.update(newAnPham_CongTacVien));

		AnPham_CongTacVien existingAnPham_CongTacVien =
			_persistence.findByPrimaryKey(
				newAnPham_CongTacVien.getPrimaryKey());

		Assert.assertEquals(
			existingAnPham_CongTacVien.getId(), newAnPham_CongTacVien.getId());
		Assert.assertEquals(
			existingAnPham_CongTacVien.getGroupId(),
			newAnPham_CongTacVien.getGroupId());
		Assert.assertEquals(
			existingAnPham_CongTacVien.getCompanyId(),
			newAnPham_CongTacVien.getCompanyId());
		Assert.assertEquals(
			existingAnPham_CongTacVien.getHoTen(),
			newAnPham_CongTacVien.getHoTen());
		Assert.assertEquals(
			existingAnPham_CongTacVien.getEmail(),
			newAnPham_CongTacVien.getEmail());
		Assert.assertEquals(
			existingAnPham_CongTacVien.getThongTin(),
			newAnPham_CongTacVien.getThongTin());
		Assert.assertEquals(
			existingAnPham_CongTacVien.getStatus(),
			newAnPham_CongTacVien.getStatus());
		Assert.assertEquals(
			existingAnPham_CongTacVien.getOrders(),
			newAnPham_CongTacVien.getOrders());
		Assert.assertEquals(
			existingAnPham_CongTacVien.getDelete_status(),
			newAnPham_CongTacVien.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnPham_CongTacVien newAnPham_CongTacVien = addAnPham_CongTacVien();

		AnPham_CongTacVien existingAnPham_CongTacVien =
			_persistence.findByPrimaryKey(
				newAnPham_CongTacVien.getPrimaryKey());

		Assert.assertEquals(existingAnPham_CongTacVien, newAnPham_CongTacVien);
	}

	@Test(expected = NoSuchAnPham_CongTacVienException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AnPham_CongTacVien> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_AnPham_CongTacVien", "id", true, "groupId", true, "companyId",
			true, "hoTen", true, "email", true, "thongTin", true, "status",
			true, "orders", true, "delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnPham_CongTacVien newAnPham_CongTacVien = addAnPham_CongTacVien();

		AnPham_CongTacVien existingAnPham_CongTacVien =
			_persistence.fetchByPrimaryKey(
				newAnPham_CongTacVien.getPrimaryKey());

		Assert.assertEquals(existingAnPham_CongTacVien, newAnPham_CongTacVien);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_CongTacVien missingAnPham_CongTacVien =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnPham_CongTacVien);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AnPham_CongTacVien newAnPham_CongTacVien1 = addAnPham_CongTacVien();
		AnPham_CongTacVien newAnPham_CongTacVien2 = addAnPham_CongTacVien();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_CongTacVien1.getPrimaryKey());
		primaryKeys.add(newAnPham_CongTacVien2.getPrimaryKey());

		Map<Serializable, AnPham_CongTacVien> anPham_CongTacViens =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, anPham_CongTacViens.size());
		Assert.assertEquals(
			newAnPham_CongTacVien1,
			anPham_CongTacViens.get(newAnPham_CongTacVien1.getPrimaryKey()));
		Assert.assertEquals(
			newAnPham_CongTacVien2,
			anPham_CongTacViens.get(newAnPham_CongTacVien2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnPham_CongTacVien> anPham_CongTacViens =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_CongTacViens.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AnPham_CongTacVien newAnPham_CongTacVien = addAnPham_CongTacVien();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_CongTacVien.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnPham_CongTacVien> anPham_CongTacViens =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_CongTacViens.size());
		Assert.assertEquals(
			newAnPham_CongTacVien,
			anPham_CongTacViens.get(newAnPham_CongTacVien.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnPham_CongTacVien> anPham_CongTacViens =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_CongTacViens.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AnPham_CongTacVien newAnPham_CongTacVien = addAnPham_CongTacVien();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_CongTacVien.getPrimaryKey());

		Map<Serializable, AnPham_CongTacVien> anPham_CongTacViens =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_CongTacViens.size());
		Assert.assertEquals(
			newAnPham_CongTacVien,
			anPham_CongTacViens.get(newAnPham_CongTacVien.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AnPham_CongTacVienLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<AnPham_CongTacVien>() {

				@Override
				public void performAction(
					AnPham_CongTacVien anPham_CongTacVien) {

					Assert.assertNotNull(anPham_CongTacVien);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AnPham_CongTacVien newAnPham_CongTacVien = addAnPham_CongTacVien();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_CongTacVien.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newAnPham_CongTacVien.getId()));

		List<AnPham_CongTacVien> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnPham_CongTacVien existingAnPham_CongTacVien = result.get(0);

		Assert.assertEquals(existingAnPham_CongTacVien, newAnPham_CongTacVien);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_CongTacVien.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<AnPham_CongTacVien> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AnPham_CongTacVien newAnPham_CongTacVien = addAnPham_CongTacVien();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_CongTacVien.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newAnPham_CongTacVien.getId();

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
			AnPham_CongTacVien.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnPham_CongTacVien addAnPham_CongTacVien() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_CongTacVien anPham_CongTacVien = _persistence.create(pk);

		anPham_CongTacVien.setGroupId(RandomTestUtil.nextLong());

		anPham_CongTacVien.setCompanyId(RandomTestUtil.nextLong());

		anPham_CongTacVien.setHoTen(RandomTestUtil.randomString());

		anPham_CongTacVien.setEmail(RandomTestUtil.randomString());

		anPham_CongTacVien.setThongTin(RandomTestUtil.randomString());

		anPham_CongTacVien.setStatus(RandomTestUtil.nextInt());

		anPham_CongTacVien.setOrders(RandomTestUtil.nextLong());

		anPham_CongTacVien.setDelete_status(RandomTestUtil.nextInt());

		_anPham_CongTacViens.add(_persistence.update(anPham_CongTacVien));

		return anPham_CongTacVien;
	}

	private List<AnPham_CongTacVien> _anPham_CongTacViens =
		new ArrayList<AnPham_CongTacVien>();
	private AnPham_CongTacVienPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}