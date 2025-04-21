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

import qlanphamdb.exception.NoSuchAnPham_DeCuongException;

import qlanphamdb.model.AnPham_DeCuong;

import qlanphamdb.service.AnPham_DeCuongLocalServiceUtil;
import qlanphamdb.service.persistence.AnPham_DeCuongPersistence;
import qlanphamdb.service.persistence.AnPham_DeCuongUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AnPham_DeCuongPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = AnPham_DeCuongUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnPham_DeCuong> iterator = _anPham_DeCuongs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_DeCuong anPham_DeCuong = _persistence.create(pk);

		Assert.assertNotNull(anPham_DeCuong);

		Assert.assertEquals(anPham_DeCuong.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnPham_DeCuong newAnPham_DeCuong = addAnPham_DeCuong();

		_persistence.remove(newAnPham_DeCuong);

		AnPham_DeCuong existingAnPham_DeCuong = _persistence.fetchByPrimaryKey(
			newAnPham_DeCuong.getPrimaryKey());

		Assert.assertNull(existingAnPham_DeCuong);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnPham_DeCuong();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_DeCuong newAnPham_DeCuong = _persistence.create(pk);

		newAnPham_DeCuong.setGroupId(RandomTestUtil.nextLong());

		newAnPham_DeCuong.setCompanyId(RandomTestUtil.nextLong());

		newAnPham_DeCuong.setTen(RandomTestUtil.randomString());

		newAnPham_DeCuong.setMoTa(RandomTestUtil.randomString());

		newAnPham_DeCuong.setLoaiId(RandomTestUtil.nextLong());

		newAnPham_DeCuong.setNoiDung(RandomTestUtil.randomString());

		newAnPham_DeCuong.setPhienBan(RandomTestUtil.nextLong());

		newAnPham_DeCuong.setNguoiTao(RandomTestUtil.nextLong());

		newAnPham_DeCuong.setNgayTao(RandomTestUtil.nextDate());

		newAnPham_DeCuong.setNguoiSua(RandomTestUtil.nextLong());

		newAnPham_DeCuong.setNgaySua(RandomTestUtil.nextDate());

		newAnPham_DeCuong.setNguoiNhan(RandomTestUtil.nextLong());

		newAnPham_DeCuong.setNguoiXuLy(RandomTestUtil.nextLong());

		newAnPham_DeCuong.setNgayXuLy(RandomTestUtil.nextDate());

		newAnPham_DeCuong.setLanguage(RandomTestUtil.randomString());

		newAnPham_DeCuong.setStatus(RandomTestUtil.nextInt());

		newAnPham_DeCuong.setOrders(RandomTestUtil.nextLong());

		newAnPham_DeCuong.setDelete_status(RandomTestUtil.nextInt());

		_anPham_DeCuongs.add(_persistence.update(newAnPham_DeCuong));

		AnPham_DeCuong existingAnPham_DeCuong = _persistence.findByPrimaryKey(
			newAnPham_DeCuong.getPrimaryKey());

		Assert.assertEquals(
			existingAnPham_DeCuong.getId(), newAnPham_DeCuong.getId());
		Assert.assertEquals(
			existingAnPham_DeCuong.getGroupId(),
			newAnPham_DeCuong.getGroupId());
		Assert.assertEquals(
			existingAnPham_DeCuong.getCompanyId(),
			newAnPham_DeCuong.getCompanyId());
		Assert.assertEquals(
			existingAnPham_DeCuong.getTen(), newAnPham_DeCuong.getTen());
		Assert.assertEquals(
			existingAnPham_DeCuong.getMoTa(), newAnPham_DeCuong.getMoTa());
		Assert.assertEquals(
			existingAnPham_DeCuong.getLoaiId(), newAnPham_DeCuong.getLoaiId());
		Assert.assertEquals(
			existingAnPham_DeCuong.getNoiDung(),
			newAnPham_DeCuong.getNoiDung());
		Assert.assertEquals(
			existingAnPham_DeCuong.getPhienBan(),
			newAnPham_DeCuong.getPhienBan());
		Assert.assertEquals(
			existingAnPham_DeCuong.getNguoiTao(),
			newAnPham_DeCuong.getNguoiTao());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_DeCuong.getNgayTao()),
			Time.getShortTimestamp(newAnPham_DeCuong.getNgayTao()));
		Assert.assertEquals(
			existingAnPham_DeCuong.getNguoiSua(),
			newAnPham_DeCuong.getNguoiSua());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_DeCuong.getNgaySua()),
			Time.getShortTimestamp(newAnPham_DeCuong.getNgaySua()));
		Assert.assertEquals(
			existingAnPham_DeCuong.getNguoiNhan(),
			newAnPham_DeCuong.getNguoiNhan());
		Assert.assertEquals(
			existingAnPham_DeCuong.getNguoiXuLy(),
			newAnPham_DeCuong.getNguoiXuLy());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_DeCuong.getNgayXuLy()),
			Time.getShortTimestamp(newAnPham_DeCuong.getNgayXuLy()));
		Assert.assertEquals(
			existingAnPham_DeCuong.getLanguage(),
			newAnPham_DeCuong.getLanguage());
		Assert.assertEquals(
			existingAnPham_DeCuong.getStatus(), newAnPham_DeCuong.getStatus());
		Assert.assertEquals(
			existingAnPham_DeCuong.getOrders(), newAnPham_DeCuong.getOrders());
		Assert.assertEquals(
			existingAnPham_DeCuong.getDelete_status(),
			newAnPham_DeCuong.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnPham_DeCuong newAnPham_DeCuong = addAnPham_DeCuong();

		AnPham_DeCuong existingAnPham_DeCuong = _persistence.findByPrimaryKey(
			newAnPham_DeCuong.getPrimaryKey());

		Assert.assertEquals(existingAnPham_DeCuong, newAnPham_DeCuong);
	}

	@Test(expected = NoSuchAnPham_DeCuongException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AnPham_DeCuong> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_AnPham_DeCuong", "id", true, "groupId", true, "companyId", true,
			"ten", true, "moTa", true, "loaiId", true, "noiDung", true,
			"phienBan", true, "nguoiTao", true, "ngayTao", true, "nguoiSua",
			true, "ngaySua", true, "nguoiNhan", true, "nguoiXuLy", true,
			"ngayXuLy", true, "language", true, "status", true, "orders", true,
			"delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnPham_DeCuong newAnPham_DeCuong = addAnPham_DeCuong();

		AnPham_DeCuong existingAnPham_DeCuong = _persistence.fetchByPrimaryKey(
			newAnPham_DeCuong.getPrimaryKey());

		Assert.assertEquals(existingAnPham_DeCuong, newAnPham_DeCuong);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_DeCuong missingAnPham_DeCuong = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingAnPham_DeCuong);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AnPham_DeCuong newAnPham_DeCuong1 = addAnPham_DeCuong();
		AnPham_DeCuong newAnPham_DeCuong2 = addAnPham_DeCuong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_DeCuong1.getPrimaryKey());
		primaryKeys.add(newAnPham_DeCuong2.getPrimaryKey());

		Map<Serializable, AnPham_DeCuong> anPham_DeCuongs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, anPham_DeCuongs.size());
		Assert.assertEquals(
			newAnPham_DeCuong1,
			anPham_DeCuongs.get(newAnPham_DeCuong1.getPrimaryKey()));
		Assert.assertEquals(
			newAnPham_DeCuong2,
			anPham_DeCuongs.get(newAnPham_DeCuong2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnPham_DeCuong> anPham_DeCuongs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_DeCuongs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AnPham_DeCuong newAnPham_DeCuong = addAnPham_DeCuong();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_DeCuong.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnPham_DeCuong> anPham_DeCuongs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_DeCuongs.size());
		Assert.assertEquals(
			newAnPham_DeCuong,
			anPham_DeCuongs.get(newAnPham_DeCuong.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnPham_DeCuong> anPham_DeCuongs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_DeCuongs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AnPham_DeCuong newAnPham_DeCuong = addAnPham_DeCuong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_DeCuong.getPrimaryKey());

		Map<Serializable, AnPham_DeCuong> anPham_DeCuongs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_DeCuongs.size());
		Assert.assertEquals(
			newAnPham_DeCuong,
			anPham_DeCuongs.get(newAnPham_DeCuong.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AnPham_DeCuongLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AnPham_DeCuong>() {

				@Override
				public void performAction(AnPham_DeCuong anPham_DeCuong) {
					Assert.assertNotNull(anPham_DeCuong);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AnPham_DeCuong newAnPham_DeCuong = addAnPham_DeCuong();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_DeCuong.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newAnPham_DeCuong.getId()));

		List<AnPham_DeCuong> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnPham_DeCuong existingAnPham_DeCuong = result.get(0);

		Assert.assertEquals(existingAnPham_DeCuong, newAnPham_DeCuong);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_DeCuong.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<AnPham_DeCuong> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AnPham_DeCuong newAnPham_DeCuong = addAnPham_DeCuong();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_DeCuong.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newAnPham_DeCuong.getId();

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
			AnPham_DeCuong.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnPham_DeCuong addAnPham_DeCuong() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_DeCuong anPham_DeCuong = _persistence.create(pk);

		anPham_DeCuong.setGroupId(RandomTestUtil.nextLong());

		anPham_DeCuong.setCompanyId(RandomTestUtil.nextLong());

		anPham_DeCuong.setTen(RandomTestUtil.randomString());

		anPham_DeCuong.setMoTa(RandomTestUtil.randomString());

		anPham_DeCuong.setLoaiId(RandomTestUtil.nextLong());

		anPham_DeCuong.setNoiDung(RandomTestUtil.randomString());

		anPham_DeCuong.setPhienBan(RandomTestUtil.nextLong());

		anPham_DeCuong.setNguoiTao(RandomTestUtil.nextLong());

		anPham_DeCuong.setNgayTao(RandomTestUtil.nextDate());

		anPham_DeCuong.setNguoiSua(RandomTestUtil.nextLong());

		anPham_DeCuong.setNgaySua(RandomTestUtil.nextDate());

		anPham_DeCuong.setNguoiNhan(RandomTestUtil.nextLong());

		anPham_DeCuong.setNguoiXuLy(RandomTestUtil.nextLong());

		anPham_DeCuong.setNgayXuLy(RandomTestUtil.nextDate());

		anPham_DeCuong.setLanguage(RandomTestUtil.randomString());

		anPham_DeCuong.setStatus(RandomTestUtil.nextInt());

		anPham_DeCuong.setOrders(RandomTestUtil.nextLong());

		anPham_DeCuong.setDelete_status(RandomTestUtil.nextInt());

		_anPham_DeCuongs.add(_persistence.update(anPham_DeCuong));

		return anPham_DeCuong;
	}

	private List<AnPham_DeCuong> _anPham_DeCuongs =
		new ArrayList<AnPham_DeCuong>();
	private AnPham_DeCuongPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}