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

import qlanphamdb.exception.NoSucheMagazine_LogsException;

import qlanphamdb.model.eMagazine_Logs;

import qlanphamdb.service.eMagazine_LogsLocalServiceUtil;
import qlanphamdb.service.persistence.eMagazine_LogsPersistence;
import qlanphamdb.service.persistence.eMagazine_LogsUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class eMagazine_LogsPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = eMagazine_LogsUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<eMagazine_Logs> iterator = _eMagazine_Logses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_Logs eMagazine_Logs = _persistence.create(pk);

		Assert.assertNotNull(eMagazine_Logs);

		Assert.assertEquals(eMagazine_Logs.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		eMagazine_Logs neweMagazine_Logs = addeMagazine_Logs();

		_persistence.remove(neweMagazine_Logs);

		eMagazine_Logs existingeMagazine_Logs = _persistence.fetchByPrimaryKey(
			neweMagazine_Logs.getPrimaryKey());

		Assert.assertNull(existingeMagazine_Logs);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addeMagazine_Logs();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_Logs neweMagazine_Logs = _persistence.create(pk);

		neweMagazine_Logs.setGroupId(RandomTestUtil.nextLong());

		neweMagazine_Logs.setCompanyId(RandomTestUtil.nextLong());

		neweMagazine_Logs.setTen(RandomTestUtil.randomString());

		neweMagazine_Logs.setSlug(RandomTestUtil.randomString());

		neweMagazine_Logs.setMoTa(RandomTestUtil.randomString());

		neweMagazine_Logs.setAnhDaiDien(RandomTestUtil.randomString());

		neweMagazine_Logs.setMauChuDao(RandomTestUtil.randomString());

		neweMagazine_Logs.setHinhNen(RandomTestUtil.randomString());

		neweMagazine_Logs.setTemplateId(RandomTestUtil.nextLong());

		neweMagazine_Logs.setNoiDung(RandomTestUtil.randomString());

		neweMagazine_Logs.setTuKhoa(RandomTestUtil.randomString());

		neweMagazine_Logs.setPhienBan(RandomTestUtil.nextLong());

		neweMagazine_Logs.setLuotXem(RandomTestUtil.nextLong());

		neweMagazine_Logs.setNguoiTao(RandomTestUtil.nextLong());

		neweMagazine_Logs.setNgayTao(RandomTestUtil.nextDate());

		neweMagazine_Logs.setNguoiSua(RandomTestUtil.nextLong());

		neweMagazine_Logs.setNgaySua(RandomTestUtil.nextDate());

		neweMagazine_Logs.setNguoiNhan(RandomTestUtil.nextLong());

		neweMagazine_Logs.setNguoiXuLy(RandomTestUtil.nextLong());

		neweMagazine_Logs.setNgayXuLy(RandomTestUtil.nextDate());

		neweMagazine_Logs.setLanguage(RandomTestUtil.randomString());

		neweMagazine_Logs.setIsFormHienBinhLuan(RandomTestUtil.nextInt());

		neweMagazine_Logs.setIsFormViewBinhLuan(RandomTestUtil.nextInt());

		neweMagazine_Logs.setStatus(RandomTestUtil.nextInt());

		neweMagazine_Logs.setOrders(RandomTestUtil.nextLong());

		neweMagazine_Logs.setDelete_status(RandomTestUtil.nextInt());

		_eMagazine_Logses.add(_persistence.update(neweMagazine_Logs));

		eMagazine_Logs existingeMagazine_Logs = _persistence.findByPrimaryKey(
			neweMagazine_Logs.getPrimaryKey());

		Assert.assertEquals(
			existingeMagazine_Logs.getId(), neweMagazine_Logs.getId());
		Assert.assertEquals(
			existingeMagazine_Logs.getGroupId(),
			neweMagazine_Logs.getGroupId());
		Assert.assertEquals(
			existingeMagazine_Logs.getCompanyId(),
			neweMagazine_Logs.getCompanyId());
		Assert.assertEquals(
			existingeMagazine_Logs.getTen(), neweMagazine_Logs.getTen());
		Assert.assertEquals(
			existingeMagazine_Logs.getSlug(), neweMagazine_Logs.getSlug());
		Assert.assertEquals(
			existingeMagazine_Logs.getMoTa(), neweMagazine_Logs.getMoTa());
		Assert.assertEquals(
			existingeMagazine_Logs.getAnhDaiDien(),
			neweMagazine_Logs.getAnhDaiDien());
		Assert.assertEquals(
			existingeMagazine_Logs.getMauChuDao(),
			neweMagazine_Logs.getMauChuDao());
		Assert.assertEquals(
			existingeMagazine_Logs.getHinhNen(),
			neweMagazine_Logs.getHinhNen());
		Assert.assertEquals(
			existingeMagazine_Logs.getTemplateId(),
			neweMagazine_Logs.getTemplateId());
		Assert.assertEquals(
			existingeMagazine_Logs.getNoiDung(),
			neweMagazine_Logs.getNoiDung());
		Assert.assertEquals(
			existingeMagazine_Logs.getTuKhoa(), neweMagazine_Logs.getTuKhoa());
		Assert.assertEquals(
			existingeMagazine_Logs.getPhienBan(),
			neweMagazine_Logs.getPhienBan());
		Assert.assertEquals(
			existingeMagazine_Logs.getLuotXem(),
			neweMagazine_Logs.getLuotXem());
		Assert.assertEquals(
			existingeMagazine_Logs.getNguoiTao(),
			neweMagazine_Logs.getNguoiTao());
		Assert.assertEquals(
			Time.getShortTimestamp(existingeMagazine_Logs.getNgayTao()),
			Time.getShortTimestamp(neweMagazine_Logs.getNgayTao()));
		Assert.assertEquals(
			existingeMagazine_Logs.getNguoiSua(),
			neweMagazine_Logs.getNguoiSua());
		Assert.assertEquals(
			Time.getShortTimestamp(existingeMagazine_Logs.getNgaySua()),
			Time.getShortTimestamp(neweMagazine_Logs.getNgaySua()));
		Assert.assertEquals(
			existingeMagazine_Logs.getNguoiNhan(),
			neweMagazine_Logs.getNguoiNhan());
		Assert.assertEquals(
			existingeMagazine_Logs.getNguoiXuLy(),
			neweMagazine_Logs.getNguoiXuLy());
		Assert.assertEquals(
			Time.getShortTimestamp(existingeMagazine_Logs.getNgayXuLy()),
			Time.getShortTimestamp(neweMagazine_Logs.getNgayXuLy()));
		Assert.assertEquals(
			existingeMagazine_Logs.getLanguage(),
			neweMagazine_Logs.getLanguage());
		Assert.assertEquals(
			existingeMagazine_Logs.getIsFormHienBinhLuan(),
			neweMagazine_Logs.getIsFormHienBinhLuan());
		Assert.assertEquals(
			existingeMagazine_Logs.getIsFormViewBinhLuan(),
			neweMagazine_Logs.getIsFormViewBinhLuan());
		Assert.assertEquals(
			existingeMagazine_Logs.getStatus(), neweMagazine_Logs.getStatus());
		Assert.assertEquals(
			existingeMagazine_Logs.getOrders(), neweMagazine_Logs.getOrders());
		Assert.assertEquals(
			existingeMagazine_Logs.getDelete_status(),
			neweMagazine_Logs.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		eMagazine_Logs neweMagazine_Logs = addeMagazine_Logs();

		eMagazine_Logs existingeMagazine_Logs = _persistence.findByPrimaryKey(
			neweMagazine_Logs.getPrimaryKey());

		Assert.assertEquals(existingeMagazine_Logs, neweMagazine_Logs);
	}

	@Test(expected = NoSucheMagazine_LogsException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<eMagazine_Logs> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_eMagazine_Logs", "id", true, "groupId", true, "companyId", true,
			"ten", true, "slug", true, "moTa", true, "anhDaiDien", true,
			"mauChuDao", true, "hinhNen", true, "templateId", true, "noiDung",
			true, "tuKhoa", true, "phienBan", true, "luotXem", true, "nguoiTao",
			true, "ngayTao", true, "nguoiSua", true, "ngaySua", true,
			"nguoiNhan", true, "nguoiXuLy", true, "ngayXuLy", true, "language",
			true, "isFormHienBinhLuan", true, "isFormViewBinhLuan", true,
			"status", true, "orders", true, "delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		eMagazine_Logs neweMagazine_Logs = addeMagazine_Logs();

		eMagazine_Logs existingeMagazine_Logs = _persistence.fetchByPrimaryKey(
			neweMagazine_Logs.getPrimaryKey());

		Assert.assertEquals(existingeMagazine_Logs, neweMagazine_Logs);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_Logs missingeMagazine_Logs = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingeMagazine_Logs);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		eMagazine_Logs neweMagazine_Logs1 = addeMagazine_Logs();
		eMagazine_Logs neweMagazine_Logs2 = addeMagazine_Logs();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine_Logs1.getPrimaryKey());
		primaryKeys.add(neweMagazine_Logs2.getPrimaryKey());

		Map<Serializable, eMagazine_Logs> eMagazine_Logses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, eMagazine_Logses.size());
		Assert.assertEquals(
			neweMagazine_Logs1,
			eMagazine_Logses.get(neweMagazine_Logs1.getPrimaryKey()));
		Assert.assertEquals(
			neweMagazine_Logs2,
			eMagazine_Logses.get(neweMagazine_Logs2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, eMagazine_Logs> eMagazine_Logses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eMagazine_Logses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		eMagazine_Logs neweMagazine_Logs = addeMagazine_Logs();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine_Logs.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, eMagazine_Logs> eMagazine_Logses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eMagazine_Logses.size());
		Assert.assertEquals(
			neweMagazine_Logs,
			eMagazine_Logses.get(neweMagazine_Logs.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, eMagazine_Logs> eMagazine_Logses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eMagazine_Logses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		eMagazine_Logs neweMagazine_Logs = addeMagazine_Logs();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine_Logs.getPrimaryKey());

		Map<Serializable, eMagazine_Logs> eMagazine_Logses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eMagazine_Logses.size());
		Assert.assertEquals(
			neweMagazine_Logs,
			eMagazine_Logses.get(neweMagazine_Logs.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			eMagazine_LogsLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<eMagazine_Logs>() {

				@Override
				public void performAction(eMagazine_Logs eMagazine_Logs) {
					Assert.assertNotNull(eMagazine_Logs);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		eMagazine_Logs neweMagazine_Logs = addeMagazine_Logs();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine_Logs.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", neweMagazine_Logs.getId()));

		List<eMagazine_Logs> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		eMagazine_Logs existingeMagazine_Logs = result.get(0);

		Assert.assertEquals(existingeMagazine_Logs, neweMagazine_Logs);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine_Logs.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<eMagazine_Logs> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		eMagazine_Logs neweMagazine_Logs = addeMagazine_Logs();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine_Logs.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = neweMagazine_Logs.getId();

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
			eMagazine_Logs.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected eMagazine_Logs addeMagazine_Logs() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_Logs eMagazine_Logs = _persistence.create(pk);

		eMagazine_Logs.setGroupId(RandomTestUtil.nextLong());

		eMagazine_Logs.setCompanyId(RandomTestUtil.nextLong());

		eMagazine_Logs.setTen(RandomTestUtil.randomString());

		eMagazine_Logs.setSlug(RandomTestUtil.randomString());

		eMagazine_Logs.setMoTa(RandomTestUtil.randomString());

		eMagazine_Logs.setAnhDaiDien(RandomTestUtil.randomString());

		eMagazine_Logs.setMauChuDao(RandomTestUtil.randomString());

		eMagazine_Logs.setHinhNen(RandomTestUtil.randomString());

		eMagazine_Logs.setTemplateId(RandomTestUtil.nextLong());

		eMagazine_Logs.setNoiDung(RandomTestUtil.randomString());

		eMagazine_Logs.setTuKhoa(RandomTestUtil.randomString());

		eMagazine_Logs.setPhienBan(RandomTestUtil.nextLong());

		eMagazine_Logs.setLuotXem(RandomTestUtil.nextLong());

		eMagazine_Logs.setNguoiTao(RandomTestUtil.nextLong());

		eMagazine_Logs.setNgayTao(RandomTestUtil.nextDate());

		eMagazine_Logs.setNguoiSua(RandomTestUtil.nextLong());

		eMagazine_Logs.setNgaySua(RandomTestUtil.nextDate());

		eMagazine_Logs.setNguoiNhan(RandomTestUtil.nextLong());

		eMagazine_Logs.setNguoiXuLy(RandomTestUtil.nextLong());

		eMagazine_Logs.setNgayXuLy(RandomTestUtil.nextDate());

		eMagazine_Logs.setLanguage(RandomTestUtil.randomString());

		eMagazine_Logs.setIsFormHienBinhLuan(RandomTestUtil.nextInt());

		eMagazine_Logs.setIsFormViewBinhLuan(RandomTestUtil.nextInt());

		eMagazine_Logs.setStatus(RandomTestUtil.nextInt());

		eMagazine_Logs.setOrders(RandomTestUtil.nextLong());

		eMagazine_Logs.setDelete_status(RandomTestUtil.nextInt());

		_eMagazine_Logses.add(_persistence.update(eMagazine_Logs));

		return eMagazine_Logs;
	}

	private List<eMagazine_Logs> _eMagazine_Logses =
		new ArrayList<eMagazine_Logs>();
	private eMagazine_LogsPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}