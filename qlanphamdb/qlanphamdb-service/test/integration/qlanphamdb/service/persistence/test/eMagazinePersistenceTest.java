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

import qlanphamdb.exception.NoSucheMagazineException;

import qlanphamdb.model.eMagazine;

import qlanphamdb.service.eMagazineLocalServiceUtil;
import qlanphamdb.service.persistence.eMagazinePersistence;
import qlanphamdb.service.persistence.eMagazineUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class eMagazinePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = eMagazineUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<eMagazine> iterator = _eMagazines.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine eMagazine = _persistence.create(pk);

		Assert.assertNotNull(eMagazine);

		Assert.assertEquals(eMagazine.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		eMagazine neweMagazine = addeMagazine();

		_persistence.remove(neweMagazine);

		eMagazine existingeMagazine = _persistence.fetchByPrimaryKey(
			neweMagazine.getPrimaryKey());

		Assert.assertNull(existingeMagazine);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addeMagazine();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine neweMagazine = _persistence.create(pk);

		neweMagazine.setGroupId(RandomTestUtil.nextLong());

		neweMagazine.setCompanyId(RandomTestUtil.nextLong());

		neweMagazine.setTen(RandomTestUtil.randomString());

		neweMagazine.setSlug(RandomTestUtil.randomString());

		neweMagazine.setMoTa(RandomTestUtil.randomString());

		neweMagazine.setAnhDaiDien(RandomTestUtil.randomString());

		neweMagazine.setMauChuDao(RandomTestUtil.randomString());

		neweMagazine.setHinhNen(RandomTestUtil.randomString());

		neweMagazine.setTemplateId(RandomTestUtil.nextLong());

		neweMagazine.setNoiDung(RandomTestUtil.randomString());

		neweMagazine.setTuKhoa(RandomTestUtil.randomString());

		neweMagazine.setPhienBan(RandomTestUtil.nextLong());

		neweMagazine.setLuotXem(RandomTestUtil.nextLong());

		neweMagazine.setNguoiTao(RandomTestUtil.nextLong());

		neweMagazine.setNgayTao(RandomTestUtil.nextDate());

		neweMagazine.setNguoiSua(RandomTestUtil.nextLong());

		neweMagazine.setNgaySua(RandomTestUtil.nextDate());

		neweMagazine.setNguoiNhan(RandomTestUtil.nextLong());

		neweMagazine.setNguoiXuLy(RandomTestUtil.nextLong());

		neweMagazine.setNgayXuLy(RandomTestUtil.nextDate());

		neweMagazine.setLanguage(RandomTestUtil.randomString());

		neweMagazine.setIsFormHienBinhLuan(RandomTestUtil.nextInt());

		neweMagazine.setIsFormViewBinhLuan(RandomTestUtil.nextInt());

		neweMagazine.setStatus(RandomTestUtil.nextInt());

		neweMagazine.setOrders(RandomTestUtil.nextLong());

		neweMagazine.setDelete_status(RandomTestUtil.nextInt());

		_eMagazines.add(_persistence.update(neweMagazine));

		eMagazine existingeMagazine = _persistence.findByPrimaryKey(
			neweMagazine.getPrimaryKey());

		Assert.assertEquals(existingeMagazine.getId(), neweMagazine.getId());
		Assert.assertEquals(
			existingeMagazine.getGroupId(), neweMagazine.getGroupId());
		Assert.assertEquals(
			existingeMagazine.getCompanyId(), neweMagazine.getCompanyId());
		Assert.assertEquals(existingeMagazine.getTen(), neweMagazine.getTen());
		Assert.assertEquals(
			existingeMagazine.getSlug(), neweMagazine.getSlug());
		Assert.assertEquals(
			existingeMagazine.getMoTa(), neweMagazine.getMoTa());
		Assert.assertEquals(
			existingeMagazine.getAnhDaiDien(), neweMagazine.getAnhDaiDien());
		Assert.assertEquals(
			existingeMagazine.getMauChuDao(), neweMagazine.getMauChuDao());
		Assert.assertEquals(
			existingeMagazine.getHinhNen(), neweMagazine.getHinhNen());
		Assert.assertEquals(
			existingeMagazine.getTemplateId(), neweMagazine.getTemplateId());
		Assert.assertEquals(
			existingeMagazine.getNoiDung(), neweMagazine.getNoiDung());
		Assert.assertEquals(
			existingeMagazine.getTuKhoa(), neweMagazine.getTuKhoa());
		Assert.assertEquals(
			existingeMagazine.getPhienBan(), neweMagazine.getPhienBan());
		Assert.assertEquals(
			existingeMagazine.getLuotXem(), neweMagazine.getLuotXem());
		Assert.assertEquals(
			existingeMagazine.getNguoiTao(), neweMagazine.getNguoiTao());
		Assert.assertEquals(
			Time.getShortTimestamp(existingeMagazine.getNgayTao()),
			Time.getShortTimestamp(neweMagazine.getNgayTao()));
		Assert.assertEquals(
			existingeMagazine.getNguoiSua(), neweMagazine.getNguoiSua());
		Assert.assertEquals(
			Time.getShortTimestamp(existingeMagazine.getNgaySua()),
			Time.getShortTimestamp(neweMagazine.getNgaySua()));
		Assert.assertEquals(
			existingeMagazine.getNguoiNhan(), neweMagazine.getNguoiNhan());
		Assert.assertEquals(
			existingeMagazine.getNguoiXuLy(), neweMagazine.getNguoiXuLy());
		Assert.assertEquals(
			Time.getShortTimestamp(existingeMagazine.getNgayXuLy()),
			Time.getShortTimestamp(neweMagazine.getNgayXuLy()));
		Assert.assertEquals(
			existingeMagazine.getLanguage(), neweMagazine.getLanguage());
		Assert.assertEquals(
			existingeMagazine.getIsFormHienBinhLuan(),
			neweMagazine.getIsFormHienBinhLuan());
		Assert.assertEquals(
			existingeMagazine.getIsFormViewBinhLuan(),
			neweMagazine.getIsFormViewBinhLuan());
		Assert.assertEquals(
			existingeMagazine.getStatus(), neweMagazine.getStatus());
		Assert.assertEquals(
			existingeMagazine.getOrders(), neweMagazine.getOrders());
		Assert.assertEquals(
			existingeMagazine.getDelete_status(),
			neweMagazine.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		eMagazine neweMagazine = addeMagazine();

		eMagazine existingeMagazine = _persistence.findByPrimaryKey(
			neweMagazine.getPrimaryKey());

		Assert.assertEquals(existingeMagazine, neweMagazine);
	}

	@Test(expected = NoSucheMagazineException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<eMagazine> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_eMagazine", "id", true, "groupId", true, "companyId", true,
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
		eMagazine neweMagazine = addeMagazine();

		eMagazine existingeMagazine = _persistence.fetchByPrimaryKey(
			neweMagazine.getPrimaryKey());

		Assert.assertEquals(existingeMagazine, neweMagazine);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine missingeMagazine = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingeMagazine);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		eMagazine neweMagazine1 = addeMagazine();
		eMagazine neweMagazine2 = addeMagazine();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine1.getPrimaryKey());
		primaryKeys.add(neweMagazine2.getPrimaryKey());

		Map<Serializable, eMagazine> eMagazines =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, eMagazines.size());
		Assert.assertEquals(
			neweMagazine1, eMagazines.get(neweMagazine1.getPrimaryKey()));
		Assert.assertEquals(
			neweMagazine2, eMagazines.get(neweMagazine2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, eMagazine> eMagazines =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eMagazines.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		eMagazine neweMagazine = addeMagazine();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, eMagazine> eMagazines =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eMagazines.size());
		Assert.assertEquals(
			neweMagazine, eMagazines.get(neweMagazine.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, eMagazine> eMagazines =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eMagazines.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		eMagazine neweMagazine = addeMagazine();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine.getPrimaryKey());

		Map<Serializable, eMagazine> eMagazines =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eMagazines.size());
		Assert.assertEquals(
			neweMagazine, eMagazines.get(neweMagazine.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			eMagazineLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<eMagazine>() {

				@Override
				public void performAction(eMagazine eMagazine) {
					Assert.assertNotNull(eMagazine);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		eMagazine neweMagazine = addeMagazine();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", neweMagazine.getId()));

		List<eMagazine> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		eMagazine existingeMagazine = result.get(0);

		Assert.assertEquals(existingeMagazine, neweMagazine);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<eMagazine> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		eMagazine neweMagazine = addeMagazine();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = neweMagazine.getId();

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
			eMagazine.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected eMagazine addeMagazine() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine eMagazine = _persistence.create(pk);

		eMagazine.setGroupId(RandomTestUtil.nextLong());

		eMagazine.setCompanyId(RandomTestUtil.nextLong());

		eMagazine.setTen(RandomTestUtil.randomString());

		eMagazine.setSlug(RandomTestUtil.randomString());

		eMagazine.setMoTa(RandomTestUtil.randomString());

		eMagazine.setAnhDaiDien(RandomTestUtil.randomString());

		eMagazine.setMauChuDao(RandomTestUtil.randomString());

		eMagazine.setHinhNen(RandomTestUtil.randomString());

		eMagazine.setTemplateId(RandomTestUtil.nextLong());

		eMagazine.setNoiDung(RandomTestUtil.randomString());

		eMagazine.setTuKhoa(RandomTestUtil.randomString());

		eMagazine.setPhienBan(RandomTestUtil.nextLong());

		eMagazine.setLuotXem(RandomTestUtil.nextLong());

		eMagazine.setNguoiTao(RandomTestUtil.nextLong());

		eMagazine.setNgayTao(RandomTestUtil.nextDate());

		eMagazine.setNguoiSua(RandomTestUtil.nextLong());

		eMagazine.setNgaySua(RandomTestUtil.nextDate());

		eMagazine.setNguoiNhan(RandomTestUtil.nextLong());

		eMagazine.setNguoiXuLy(RandomTestUtil.nextLong());

		eMagazine.setNgayXuLy(RandomTestUtil.nextDate());

		eMagazine.setLanguage(RandomTestUtil.randomString());

		eMagazine.setIsFormHienBinhLuan(RandomTestUtil.nextInt());

		eMagazine.setIsFormViewBinhLuan(RandomTestUtil.nextInt());

		eMagazine.setStatus(RandomTestUtil.nextInt());

		eMagazine.setOrders(RandomTestUtil.nextLong());

		eMagazine.setDelete_status(RandomTestUtil.nextInt());

		_eMagazines.add(_persistence.update(eMagazine));

		return eMagazine;
	}

	private List<eMagazine> _eMagazines = new ArrayList<eMagazine>();
	private eMagazinePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}