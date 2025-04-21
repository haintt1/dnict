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

import qlanphamdb.exception.NoSuchAnPham_PhanCongException;

import qlanphamdb.model.AnPham_PhanCong;

import qlanphamdb.service.AnPham_PhanCongLocalServiceUtil;
import qlanphamdb.service.persistence.AnPham_PhanCongPersistence;
import qlanphamdb.service.persistence.AnPham_PhanCongUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AnPham_PhanCongPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = AnPham_PhanCongUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnPham_PhanCong> iterator = _anPham_PhanCongs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_PhanCong anPham_PhanCong = _persistence.create(pk);

		Assert.assertNotNull(anPham_PhanCong);

		Assert.assertEquals(anPham_PhanCong.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnPham_PhanCong newAnPham_PhanCong = addAnPham_PhanCong();

		_persistence.remove(newAnPham_PhanCong);

		AnPham_PhanCong existingAnPham_PhanCong =
			_persistence.fetchByPrimaryKey(newAnPham_PhanCong.getPrimaryKey());

		Assert.assertNull(existingAnPham_PhanCong);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnPham_PhanCong();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_PhanCong newAnPham_PhanCong = _persistence.create(pk);

		newAnPham_PhanCong.setCompanyId(RandomTestUtil.nextLong());

		newAnPham_PhanCong.setGroupId(RandomTestUtil.nextLong());

		newAnPham_PhanCong.setLoaiId(RandomTestUtil.nextLong());

		newAnPham_PhanCong.setDeCuongId(RandomTestUtil.nextLong());

		newAnPham_PhanCong.setCtvId(RandomTestUtil.nextLong());

		newAnPham_PhanCong.setNoiDung(RandomTestUtil.randomString());

		newAnPham_PhanCong.setGhiChu(RandomTestUtil.randomString());

		newAnPham_PhanCong.setNgaybatdau(RandomTestUtil.nextDate());

		newAnPham_PhanCong.setNgayketthuc(RandomTestUtil.nextDate());

		newAnPham_PhanCong.setStatus(RandomTestUtil.nextInt());

		newAnPham_PhanCong.setIs_gui(RandomTestUtil.nextInt());

		_anPham_PhanCongs.add(_persistence.update(newAnPham_PhanCong));

		AnPham_PhanCong existingAnPham_PhanCong = _persistence.findByPrimaryKey(
			newAnPham_PhanCong.getPrimaryKey());

		Assert.assertEquals(
			existingAnPham_PhanCong.getId(), newAnPham_PhanCong.getId());
		Assert.assertEquals(
			existingAnPham_PhanCong.getCompanyId(),
			newAnPham_PhanCong.getCompanyId());
		Assert.assertEquals(
			existingAnPham_PhanCong.getGroupId(),
			newAnPham_PhanCong.getGroupId());
		Assert.assertEquals(
			existingAnPham_PhanCong.getLoaiId(),
			newAnPham_PhanCong.getLoaiId());
		Assert.assertEquals(
			existingAnPham_PhanCong.getDeCuongId(),
			newAnPham_PhanCong.getDeCuongId());
		Assert.assertEquals(
			existingAnPham_PhanCong.getCtvId(), newAnPham_PhanCong.getCtvId());
		Assert.assertEquals(
			existingAnPham_PhanCong.getNoiDung(),
			newAnPham_PhanCong.getNoiDung());
		Assert.assertEquals(
			existingAnPham_PhanCong.getGhiChu(),
			newAnPham_PhanCong.getGhiChu());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_PhanCong.getNgaybatdau()),
			Time.getShortTimestamp(newAnPham_PhanCong.getNgaybatdau()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_PhanCong.getNgayketthuc()),
			Time.getShortTimestamp(newAnPham_PhanCong.getNgayketthuc()));
		Assert.assertEquals(
			existingAnPham_PhanCong.getStatus(),
			newAnPham_PhanCong.getStatus());
		Assert.assertEquals(
			existingAnPham_PhanCong.getIs_gui(),
			newAnPham_PhanCong.getIs_gui());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnPham_PhanCong newAnPham_PhanCong = addAnPham_PhanCong();

		AnPham_PhanCong existingAnPham_PhanCong = _persistence.findByPrimaryKey(
			newAnPham_PhanCong.getPrimaryKey());

		Assert.assertEquals(existingAnPham_PhanCong, newAnPham_PhanCong);
	}

	@Test(expected = NoSuchAnPham_PhanCongException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AnPham_PhanCong> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_AnPham_PhanCong", "id", true, "companyId", true, "groupId",
			true, "loaiId", true, "deCuongId", true, "ctvId", true, "noiDung",
			true, "ghiChu", true, "ngaybatdau", true, "ngayketthuc", true,
			"status", true, "is_gui", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnPham_PhanCong newAnPham_PhanCong = addAnPham_PhanCong();

		AnPham_PhanCong existingAnPham_PhanCong =
			_persistence.fetchByPrimaryKey(newAnPham_PhanCong.getPrimaryKey());

		Assert.assertEquals(existingAnPham_PhanCong, newAnPham_PhanCong);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_PhanCong missingAnPham_PhanCong = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingAnPham_PhanCong);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AnPham_PhanCong newAnPham_PhanCong1 = addAnPham_PhanCong();
		AnPham_PhanCong newAnPham_PhanCong2 = addAnPham_PhanCong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_PhanCong1.getPrimaryKey());
		primaryKeys.add(newAnPham_PhanCong2.getPrimaryKey());

		Map<Serializable, AnPham_PhanCong> anPham_PhanCongs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, anPham_PhanCongs.size());
		Assert.assertEquals(
			newAnPham_PhanCong1,
			anPham_PhanCongs.get(newAnPham_PhanCong1.getPrimaryKey()));
		Assert.assertEquals(
			newAnPham_PhanCong2,
			anPham_PhanCongs.get(newAnPham_PhanCong2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnPham_PhanCong> anPham_PhanCongs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_PhanCongs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AnPham_PhanCong newAnPham_PhanCong = addAnPham_PhanCong();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_PhanCong.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnPham_PhanCong> anPham_PhanCongs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_PhanCongs.size());
		Assert.assertEquals(
			newAnPham_PhanCong,
			anPham_PhanCongs.get(newAnPham_PhanCong.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnPham_PhanCong> anPham_PhanCongs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_PhanCongs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AnPham_PhanCong newAnPham_PhanCong = addAnPham_PhanCong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_PhanCong.getPrimaryKey());

		Map<Serializable, AnPham_PhanCong> anPham_PhanCongs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_PhanCongs.size());
		Assert.assertEquals(
			newAnPham_PhanCong,
			anPham_PhanCongs.get(newAnPham_PhanCong.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AnPham_PhanCongLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AnPham_PhanCong>() {

				@Override
				public void performAction(AnPham_PhanCong anPham_PhanCong) {
					Assert.assertNotNull(anPham_PhanCong);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AnPham_PhanCong newAnPham_PhanCong = addAnPham_PhanCong();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_PhanCong.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newAnPham_PhanCong.getId()));

		List<AnPham_PhanCong> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnPham_PhanCong existingAnPham_PhanCong = result.get(0);

		Assert.assertEquals(existingAnPham_PhanCong, newAnPham_PhanCong);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_PhanCong.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<AnPham_PhanCong> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AnPham_PhanCong newAnPham_PhanCong = addAnPham_PhanCong();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_PhanCong.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newAnPham_PhanCong.getId();

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
			AnPham_PhanCong.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnPham_PhanCong addAnPham_PhanCong() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_PhanCong anPham_PhanCong = _persistence.create(pk);

		anPham_PhanCong.setCompanyId(RandomTestUtil.nextLong());

		anPham_PhanCong.setGroupId(RandomTestUtil.nextLong());

		anPham_PhanCong.setLoaiId(RandomTestUtil.nextLong());

		anPham_PhanCong.setDeCuongId(RandomTestUtil.nextLong());

		anPham_PhanCong.setCtvId(RandomTestUtil.nextLong());

		anPham_PhanCong.setNoiDung(RandomTestUtil.randomString());

		anPham_PhanCong.setGhiChu(RandomTestUtil.randomString());

		anPham_PhanCong.setNgaybatdau(RandomTestUtil.nextDate());

		anPham_PhanCong.setNgayketthuc(RandomTestUtil.nextDate());

		anPham_PhanCong.setStatus(RandomTestUtil.nextInt());

		anPham_PhanCong.setIs_gui(RandomTestUtil.nextInt());

		_anPham_PhanCongs.add(_persistence.update(anPham_PhanCong));

		return anPham_PhanCong;
	}

	private List<AnPham_PhanCong> _anPham_PhanCongs =
		new ArrayList<AnPham_PhanCong>();
	private AnPham_PhanCongPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}