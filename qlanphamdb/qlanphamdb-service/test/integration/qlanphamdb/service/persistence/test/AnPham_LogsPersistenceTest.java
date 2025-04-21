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

import qlanphamdb.exception.NoSuchAnPham_LogsException;

import qlanphamdb.model.AnPham_Logs;

import qlanphamdb.service.AnPham_LogsLocalServiceUtil;
import qlanphamdb.service.persistence.AnPham_LogsPersistence;
import qlanphamdb.service.persistence.AnPham_LogsUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AnPham_LogsPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = AnPham_LogsUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnPham_Logs> iterator = _anPham_Logses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Logs anPham_Logs = _persistence.create(pk);

		Assert.assertNotNull(anPham_Logs);

		Assert.assertEquals(anPham_Logs.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnPham_Logs newAnPham_Logs = addAnPham_Logs();

		_persistence.remove(newAnPham_Logs);

		AnPham_Logs existingAnPham_Logs = _persistence.fetchByPrimaryKey(
			newAnPham_Logs.getPrimaryKey());

		Assert.assertNull(existingAnPham_Logs);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnPham_Logs();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Logs newAnPham_Logs = _persistence.create(pk);

		newAnPham_Logs.setGroupId(RandomTestUtil.nextLong());

		newAnPham_Logs.setCompanyId(RandomTestUtil.nextLong());

		newAnPham_Logs.setActivityId(RandomTestUtil.nextLong());

		newAnPham_Logs.setTen(RandomTestUtil.randomString());

		newAnPham_Logs.setSlug(RandomTestUtil.randomString());

		newAnPham_Logs.setMoTa(RandomTestUtil.randomString());

		newAnPham_Logs.setAnhDaiDien(RandomTestUtil.randomString());

		newAnPham_Logs.setLoaiId(RandomTestUtil.nextLong());

		newAnPham_Logs.setDeCuongId(RandomTestUtil.nextLong());

		newAnPham_Logs.setNoiDung(RandomTestUtil.randomString());

		newAnPham_Logs.setTuKhoa(RandomTestUtil.randomString());

		newAnPham_Logs.setPhienBan(RandomTestUtil.nextLong());

		newAnPham_Logs.setLuotXem(RandomTestUtil.nextLong());

		newAnPham_Logs.setAnPhamId(RandomTestUtil.nextLong());

		newAnPham_Logs.setNoiDungLog(RandomTestUtil.randomString());

		newAnPham_Logs.setNguoiTao(RandomTestUtil.nextLong());

		newAnPham_Logs.setNgayTao(RandomTestUtil.nextDate());

		newAnPham_Logs.setNguoiSua(RandomTestUtil.nextLong());

		newAnPham_Logs.setNgaySua(RandomTestUtil.nextDate());

		newAnPham_Logs.setNguoiNhan(RandomTestUtil.nextLong());

		newAnPham_Logs.setNguoiXuLy(RandomTestUtil.nextLong());

		newAnPham_Logs.setNgayXuLy(RandomTestUtil.nextDate());

		newAnPham_Logs.setLanguage(RandomTestUtil.randomString());

		newAnPham_Logs.setLoaiTin(RandomTestUtil.nextInt());

		newAnPham_Logs.setIsFormHienBinhLuan(RandomTestUtil.nextInt());

		newAnPham_Logs.setIsFormViewBinhLuan(RandomTestUtil.nextInt());

		newAnPham_Logs.setStatus(RandomTestUtil.nextInt());

		newAnPham_Logs.setOrders(RandomTestUtil.nextLong());

		newAnPham_Logs.setDelete_status(RandomTestUtil.nextInt());

		_anPham_Logses.add(_persistence.update(newAnPham_Logs));

		AnPham_Logs existingAnPham_Logs = _persistence.findByPrimaryKey(
			newAnPham_Logs.getPrimaryKey());

		Assert.assertEquals(
			existingAnPham_Logs.getId(), newAnPham_Logs.getId());
		Assert.assertEquals(
			existingAnPham_Logs.getGroupId(), newAnPham_Logs.getGroupId());
		Assert.assertEquals(
			existingAnPham_Logs.getCompanyId(), newAnPham_Logs.getCompanyId());
		Assert.assertEquals(
			existingAnPham_Logs.getActivityId(),
			newAnPham_Logs.getActivityId());
		Assert.assertEquals(
			existingAnPham_Logs.getTen(), newAnPham_Logs.getTen());
		Assert.assertEquals(
			existingAnPham_Logs.getSlug(), newAnPham_Logs.getSlug());
		Assert.assertEquals(
			existingAnPham_Logs.getMoTa(), newAnPham_Logs.getMoTa());
		Assert.assertEquals(
			existingAnPham_Logs.getAnhDaiDien(),
			newAnPham_Logs.getAnhDaiDien());
		Assert.assertEquals(
			existingAnPham_Logs.getLoaiId(), newAnPham_Logs.getLoaiId());
		Assert.assertEquals(
			existingAnPham_Logs.getDeCuongId(), newAnPham_Logs.getDeCuongId());
		Assert.assertEquals(
			existingAnPham_Logs.getNoiDung(), newAnPham_Logs.getNoiDung());
		Assert.assertEquals(
			existingAnPham_Logs.getTuKhoa(), newAnPham_Logs.getTuKhoa());
		Assert.assertEquals(
			existingAnPham_Logs.getPhienBan(), newAnPham_Logs.getPhienBan());
		Assert.assertEquals(
			existingAnPham_Logs.getLuotXem(), newAnPham_Logs.getLuotXem());
		Assert.assertEquals(
			existingAnPham_Logs.getAnPhamId(), newAnPham_Logs.getAnPhamId());
		Assert.assertEquals(
			existingAnPham_Logs.getNoiDungLog(),
			newAnPham_Logs.getNoiDungLog());
		Assert.assertEquals(
			existingAnPham_Logs.getNguoiTao(), newAnPham_Logs.getNguoiTao());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_Logs.getNgayTao()),
			Time.getShortTimestamp(newAnPham_Logs.getNgayTao()));
		Assert.assertEquals(
			existingAnPham_Logs.getNguoiSua(), newAnPham_Logs.getNguoiSua());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_Logs.getNgaySua()),
			Time.getShortTimestamp(newAnPham_Logs.getNgaySua()));
		Assert.assertEquals(
			existingAnPham_Logs.getNguoiNhan(), newAnPham_Logs.getNguoiNhan());
		Assert.assertEquals(
			existingAnPham_Logs.getNguoiXuLy(), newAnPham_Logs.getNguoiXuLy());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_Logs.getNgayXuLy()),
			Time.getShortTimestamp(newAnPham_Logs.getNgayXuLy()));
		Assert.assertEquals(
			existingAnPham_Logs.getLanguage(), newAnPham_Logs.getLanguage());
		Assert.assertEquals(
			existingAnPham_Logs.getLoaiTin(), newAnPham_Logs.getLoaiTin());
		Assert.assertEquals(
			existingAnPham_Logs.getIsFormHienBinhLuan(),
			newAnPham_Logs.getIsFormHienBinhLuan());
		Assert.assertEquals(
			existingAnPham_Logs.getIsFormViewBinhLuan(),
			newAnPham_Logs.getIsFormViewBinhLuan());
		Assert.assertEquals(
			existingAnPham_Logs.getStatus(), newAnPham_Logs.getStatus());
		Assert.assertEquals(
			existingAnPham_Logs.getOrders(), newAnPham_Logs.getOrders());
		Assert.assertEquals(
			existingAnPham_Logs.getDelete_status(),
			newAnPham_Logs.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnPham_Logs newAnPham_Logs = addAnPham_Logs();

		AnPham_Logs existingAnPham_Logs = _persistence.findByPrimaryKey(
			newAnPham_Logs.getPrimaryKey());

		Assert.assertEquals(existingAnPham_Logs, newAnPham_Logs);
	}

	@Test(expected = NoSuchAnPham_LogsException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AnPham_Logs> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_AnPham_Logs", "id", true, "groupId", true, "companyId", true,
			"activityId", true, "ten", true, "slug", true, "moTa", true,
			"anhDaiDien", true, "loaiId", true, "deCuongId", true, "noiDung",
			true, "tuKhoa", true, "phienBan", true, "luotXem", true, "anPhamId",
			true, "noiDungLog", true, "nguoiTao", true, "ngayTao", true,
			"nguoiSua", true, "ngaySua", true, "nguoiNhan", true, "nguoiXuLy",
			true, "ngayXuLy", true, "language", true, "loaiTin", true,
			"isFormHienBinhLuan", true, "isFormViewBinhLuan", true, "status",
			true, "orders", true, "delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnPham_Logs newAnPham_Logs = addAnPham_Logs();

		AnPham_Logs existingAnPham_Logs = _persistence.fetchByPrimaryKey(
			newAnPham_Logs.getPrimaryKey());

		Assert.assertEquals(existingAnPham_Logs, newAnPham_Logs);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Logs missingAnPham_Logs = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnPham_Logs);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AnPham_Logs newAnPham_Logs1 = addAnPham_Logs();
		AnPham_Logs newAnPham_Logs2 = addAnPham_Logs();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_Logs1.getPrimaryKey());
		primaryKeys.add(newAnPham_Logs2.getPrimaryKey());

		Map<Serializable, AnPham_Logs> anPham_Logses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, anPham_Logses.size());
		Assert.assertEquals(
			newAnPham_Logs1,
			anPham_Logses.get(newAnPham_Logs1.getPrimaryKey()));
		Assert.assertEquals(
			newAnPham_Logs2,
			anPham_Logses.get(newAnPham_Logs2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnPham_Logs> anPham_Logses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_Logses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AnPham_Logs newAnPham_Logs = addAnPham_Logs();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_Logs.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnPham_Logs> anPham_Logses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_Logses.size());
		Assert.assertEquals(
			newAnPham_Logs, anPham_Logses.get(newAnPham_Logs.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnPham_Logs> anPham_Logses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_Logses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AnPham_Logs newAnPham_Logs = addAnPham_Logs();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_Logs.getPrimaryKey());

		Map<Serializable, AnPham_Logs> anPham_Logses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_Logses.size());
		Assert.assertEquals(
			newAnPham_Logs, anPham_Logses.get(newAnPham_Logs.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AnPham_LogsLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AnPham_Logs>() {

				@Override
				public void performAction(AnPham_Logs anPham_Logs) {
					Assert.assertNotNull(anPham_Logs);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AnPham_Logs newAnPham_Logs = addAnPham_Logs();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_Logs.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newAnPham_Logs.getId()));

		List<AnPham_Logs> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnPham_Logs existingAnPham_Logs = result.get(0);

		Assert.assertEquals(existingAnPham_Logs, newAnPham_Logs);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_Logs.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<AnPham_Logs> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AnPham_Logs newAnPham_Logs = addAnPham_Logs();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_Logs.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newAnPham_Logs.getId();

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
			AnPham_Logs.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnPham_Logs addAnPham_Logs() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Logs anPham_Logs = _persistence.create(pk);

		anPham_Logs.setGroupId(RandomTestUtil.nextLong());

		anPham_Logs.setCompanyId(RandomTestUtil.nextLong());

		anPham_Logs.setActivityId(RandomTestUtil.nextLong());

		anPham_Logs.setTen(RandomTestUtil.randomString());

		anPham_Logs.setSlug(RandomTestUtil.randomString());

		anPham_Logs.setMoTa(RandomTestUtil.randomString());

		anPham_Logs.setAnhDaiDien(RandomTestUtil.randomString());

		anPham_Logs.setLoaiId(RandomTestUtil.nextLong());

		anPham_Logs.setDeCuongId(RandomTestUtil.nextLong());

		anPham_Logs.setNoiDung(RandomTestUtil.randomString());

		anPham_Logs.setTuKhoa(RandomTestUtil.randomString());

		anPham_Logs.setPhienBan(RandomTestUtil.nextLong());

		anPham_Logs.setLuotXem(RandomTestUtil.nextLong());

		anPham_Logs.setAnPhamId(RandomTestUtil.nextLong());

		anPham_Logs.setNoiDungLog(RandomTestUtil.randomString());

		anPham_Logs.setNguoiTao(RandomTestUtil.nextLong());

		anPham_Logs.setNgayTao(RandomTestUtil.nextDate());

		anPham_Logs.setNguoiSua(RandomTestUtil.nextLong());

		anPham_Logs.setNgaySua(RandomTestUtil.nextDate());

		anPham_Logs.setNguoiNhan(RandomTestUtil.nextLong());

		anPham_Logs.setNguoiXuLy(RandomTestUtil.nextLong());

		anPham_Logs.setNgayXuLy(RandomTestUtil.nextDate());

		anPham_Logs.setLanguage(RandomTestUtil.randomString());

		anPham_Logs.setLoaiTin(RandomTestUtil.nextInt());

		anPham_Logs.setIsFormHienBinhLuan(RandomTestUtil.nextInt());

		anPham_Logs.setIsFormViewBinhLuan(RandomTestUtil.nextInt());

		anPham_Logs.setStatus(RandomTestUtil.nextInt());

		anPham_Logs.setOrders(RandomTestUtil.nextLong());

		anPham_Logs.setDelete_status(RandomTestUtil.nextInt());

		_anPham_Logses.add(_persistence.update(anPham_Logs));

		return anPham_Logs;
	}

	private List<AnPham_Logs> _anPham_Logses = new ArrayList<AnPham_Logs>();
	private AnPham_LogsPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}