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

import qlanphamdb.exception.NoSuchAnPham_TapChiException;

import qlanphamdb.model.AnPham_TapChi;

import qlanphamdb.service.AnPham_TapChiLocalServiceUtil;
import qlanphamdb.service.persistence.AnPham_TapChiPersistence;
import qlanphamdb.service.persistence.AnPham_TapChiUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AnPham_TapChiPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = AnPham_TapChiUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnPham_TapChi> iterator = _anPham_TapChis.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_TapChi anPham_TapChi = _persistence.create(pk);

		Assert.assertNotNull(anPham_TapChi);

		Assert.assertEquals(anPham_TapChi.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnPham_TapChi newAnPham_TapChi = addAnPham_TapChi();

		_persistence.remove(newAnPham_TapChi);

		AnPham_TapChi existingAnPham_TapChi = _persistence.fetchByPrimaryKey(
			newAnPham_TapChi.getPrimaryKey());

		Assert.assertNull(existingAnPham_TapChi);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnPham_TapChi();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_TapChi newAnPham_TapChi = _persistence.create(pk);

		newAnPham_TapChi.setGroupId(RandomTestUtil.nextLong());

		newAnPham_TapChi.setCompanyId(RandomTestUtil.nextLong());

		newAnPham_TapChi.setTen(RandomTestUtil.randomString());

		newAnPham_TapChi.setSlug(RandomTestUtil.randomString());

		newAnPham_TapChi.setMoTa(RandomTestUtil.randomString());

		newAnPham_TapChi.setAnhDaiDien(RandomTestUtil.randomString());

		newAnPham_TapChi.setLoaiId(RandomTestUtil.nextLong());

		newAnPham_TapChi.setDeCuongId(RandomTestUtil.nextLong());

		newAnPham_TapChi.setNoiDung(RandomTestUtil.randomString());

		newAnPham_TapChi.setTuKhoa(RandomTestUtil.randomString());

		newAnPham_TapChi.setPhienBan(RandomTestUtil.nextLong());

		newAnPham_TapChi.setLuotXem(RandomTestUtil.nextLong());

		newAnPham_TapChi.setNguoiTao(RandomTestUtil.nextLong());

		newAnPham_TapChi.setNgayTao(RandomTestUtil.nextDate());

		newAnPham_TapChi.setNguoiSua(RandomTestUtil.nextLong());

		newAnPham_TapChi.setNgaySua(RandomTestUtil.nextDate());

		newAnPham_TapChi.setNguoiNhan(RandomTestUtil.nextLong());

		newAnPham_TapChi.setNguoiXuLy(RandomTestUtil.nextLong());

		newAnPham_TapChi.setNgayXuLy(RandomTestUtil.nextDate());

		newAnPham_TapChi.setLanguage(RandomTestUtil.randomString());

		newAnPham_TapChi.setLoaiTin(RandomTestUtil.nextInt());

		newAnPham_TapChi.setIsFormHienBinhLuan(RandomTestUtil.nextInt());

		newAnPham_TapChi.setIsFormViewBinhLuan(RandomTestUtil.nextInt());

		newAnPham_TapChi.setStatus(RandomTestUtil.nextInt());

		newAnPham_TapChi.setOrders(RandomTestUtil.nextLong());

		newAnPham_TapChi.setDelete_status(RandomTestUtil.nextInt());

		_anPham_TapChis.add(_persistence.update(newAnPham_TapChi));

		AnPham_TapChi existingAnPham_TapChi = _persistence.findByPrimaryKey(
			newAnPham_TapChi.getPrimaryKey());

		Assert.assertEquals(
			existingAnPham_TapChi.getId(), newAnPham_TapChi.getId());
		Assert.assertEquals(
			existingAnPham_TapChi.getGroupId(), newAnPham_TapChi.getGroupId());
		Assert.assertEquals(
			existingAnPham_TapChi.getCompanyId(),
			newAnPham_TapChi.getCompanyId());
		Assert.assertEquals(
			existingAnPham_TapChi.getTen(), newAnPham_TapChi.getTen());
		Assert.assertEquals(
			existingAnPham_TapChi.getSlug(), newAnPham_TapChi.getSlug());
		Assert.assertEquals(
			existingAnPham_TapChi.getMoTa(), newAnPham_TapChi.getMoTa());
		Assert.assertEquals(
			existingAnPham_TapChi.getAnhDaiDien(),
			newAnPham_TapChi.getAnhDaiDien());
		Assert.assertEquals(
			existingAnPham_TapChi.getLoaiId(), newAnPham_TapChi.getLoaiId());
		Assert.assertEquals(
			existingAnPham_TapChi.getDeCuongId(),
			newAnPham_TapChi.getDeCuongId());
		Assert.assertEquals(
			existingAnPham_TapChi.getNoiDung(), newAnPham_TapChi.getNoiDung());
		Assert.assertEquals(
			existingAnPham_TapChi.getTuKhoa(), newAnPham_TapChi.getTuKhoa());
		Assert.assertEquals(
			existingAnPham_TapChi.getPhienBan(),
			newAnPham_TapChi.getPhienBan());
		Assert.assertEquals(
			existingAnPham_TapChi.getLuotXem(), newAnPham_TapChi.getLuotXem());
		Assert.assertEquals(
			existingAnPham_TapChi.getNguoiTao(),
			newAnPham_TapChi.getNguoiTao());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_TapChi.getNgayTao()),
			Time.getShortTimestamp(newAnPham_TapChi.getNgayTao()));
		Assert.assertEquals(
			existingAnPham_TapChi.getNguoiSua(),
			newAnPham_TapChi.getNguoiSua());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_TapChi.getNgaySua()),
			Time.getShortTimestamp(newAnPham_TapChi.getNgaySua()));
		Assert.assertEquals(
			existingAnPham_TapChi.getNguoiNhan(),
			newAnPham_TapChi.getNguoiNhan());
		Assert.assertEquals(
			existingAnPham_TapChi.getNguoiXuLy(),
			newAnPham_TapChi.getNguoiXuLy());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAnPham_TapChi.getNgayXuLy()),
			Time.getShortTimestamp(newAnPham_TapChi.getNgayXuLy()));
		Assert.assertEquals(
			existingAnPham_TapChi.getLanguage(),
			newAnPham_TapChi.getLanguage());
		Assert.assertEquals(
			existingAnPham_TapChi.getLoaiTin(), newAnPham_TapChi.getLoaiTin());
		Assert.assertEquals(
			existingAnPham_TapChi.getIsFormHienBinhLuan(),
			newAnPham_TapChi.getIsFormHienBinhLuan());
		Assert.assertEquals(
			existingAnPham_TapChi.getIsFormViewBinhLuan(),
			newAnPham_TapChi.getIsFormViewBinhLuan());
		Assert.assertEquals(
			existingAnPham_TapChi.getStatus(), newAnPham_TapChi.getStatus());
		Assert.assertEquals(
			existingAnPham_TapChi.getOrders(), newAnPham_TapChi.getOrders());
		Assert.assertEquals(
			existingAnPham_TapChi.getDelete_status(),
			newAnPham_TapChi.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnPham_TapChi newAnPham_TapChi = addAnPham_TapChi();

		AnPham_TapChi existingAnPham_TapChi = _persistence.findByPrimaryKey(
			newAnPham_TapChi.getPrimaryKey());

		Assert.assertEquals(existingAnPham_TapChi, newAnPham_TapChi);
	}

	@Test(expected = NoSuchAnPham_TapChiException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AnPham_TapChi> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_AnPham_TapChi", "id", true, "groupId", true, "companyId", true,
			"ten", true, "slug", true, "moTa", true, "anhDaiDien", true,
			"loaiId", true, "deCuongId", true, "noiDung", true, "tuKhoa", true,
			"phienBan", true, "luotXem", true, "nguoiTao", true, "ngayTao",
			true, "nguoiSua", true, "ngaySua", true, "nguoiNhan", true,
			"nguoiXuLy", true, "ngayXuLy", true, "language", true, "loaiTin",
			true, "isFormHienBinhLuan", true, "isFormViewBinhLuan", true,
			"status", true, "orders", true, "delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnPham_TapChi newAnPham_TapChi = addAnPham_TapChi();

		AnPham_TapChi existingAnPham_TapChi = _persistence.fetchByPrimaryKey(
			newAnPham_TapChi.getPrimaryKey());

		Assert.assertEquals(existingAnPham_TapChi, newAnPham_TapChi);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_TapChi missingAnPham_TapChi = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnPham_TapChi);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AnPham_TapChi newAnPham_TapChi1 = addAnPham_TapChi();
		AnPham_TapChi newAnPham_TapChi2 = addAnPham_TapChi();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_TapChi1.getPrimaryKey());
		primaryKeys.add(newAnPham_TapChi2.getPrimaryKey());

		Map<Serializable, AnPham_TapChi> anPham_TapChis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, anPham_TapChis.size());
		Assert.assertEquals(
			newAnPham_TapChi1,
			anPham_TapChis.get(newAnPham_TapChi1.getPrimaryKey()));
		Assert.assertEquals(
			newAnPham_TapChi2,
			anPham_TapChis.get(newAnPham_TapChi2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnPham_TapChi> anPham_TapChis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_TapChis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AnPham_TapChi newAnPham_TapChi = addAnPham_TapChi();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_TapChi.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnPham_TapChi> anPham_TapChis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_TapChis.size());
		Assert.assertEquals(
			newAnPham_TapChi,
			anPham_TapChis.get(newAnPham_TapChi.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnPham_TapChi> anPham_TapChis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_TapChis.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AnPham_TapChi newAnPham_TapChi = addAnPham_TapChi();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_TapChi.getPrimaryKey());

		Map<Serializable, AnPham_TapChi> anPham_TapChis =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_TapChis.size());
		Assert.assertEquals(
			newAnPham_TapChi,
			anPham_TapChis.get(newAnPham_TapChi.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AnPham_TapChiLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AnPham_TapChi>() {

				@Override
				public void performAction(AnPham_TapChi anPham_TapChi) {
					Assert.assertNotNull(anPham_TapChi);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AnPham_TapChi newAnPham_TapChi = addAnPham_TapChi();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_TapChi.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newAnPham_TapChi.getId()));

		List<AnPham_TapChi> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnPham_TapChi existingAnPham_TapChi = result.get(0);

		Assert.assertEquals(existingAnPham_TapChi, newAnPham_TapChi);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_TapChi.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<AnPham_TapChi> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AnPham_TapChi newAnPham_TapChi = addAnPham_TapChi();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_TapChi.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newAnPham_TapChi.getId();

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
			AnPham_TapChi.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnPham_TapChi addAnPham_TapChi() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_TapChi anPham_TapChi = _persistence.create(pk);

		anPham_TapChi.setGroupId(RandomTestUtil.nextLong());

		anPham_TapChi.setCompanyId(RandomTestUtil.nextLong());

		anPham_TapChi.setTen(RandomTestUtil.randomString());

		anPham_TapChi.setSlug(RandomTestUtil.randomString());

		anPham_TapChi.setMoTa(RandomTestUtil.randomString());

		anPham_TapChi.setAnhDaiDien(RandomTestUtil.randomString());

		anPham_TapChi.setLoaiId(RandomTestUtil.nextLong());

		anPham_TapChi.setDeCuongId(RandomTestUtil.nextLong());

		anPham_TapChi.setNoiDung(RandomTestUtil.randomString());

		anPham_TapChi.setTuKhoa(RandomTestUtil.randomString());

		anPham_TapChi.setPhienBan(RandomTestUtil.nextLong());

		anPham_TapChi.setLuotXem(RandomTestUtil.nextLong());

		anPham_TapChi.setNguoiTao(RandomTestUtil.nextLong());

		anPham_TapChi.setNgayTao(RandomTestUtil.nextDate());

		anPham_TapChi.setNguoiSua(RandomTestUtil.nextLong());

		anPham_TapChi.setNgaySua(RandomTestUtil.nextDate());

		anPham_TapChi.setNguoiNhan(RandomTestUtil.nextLong());

		anPham_TapChi.setNguoiXuLy(RandomTestUtil.nextLong());

		anPham_TapChi.setNgayXuLy(RandomTestUtil.nextDate());

		anPham_TapChi.setLanguage(RandomTestUtil.randomString());

		anPham_TapChi.setLoaiTin(RandomTestUtil.nextInt());

		anPham_TapChi.setIsFormHienBinhLuan(RandomTestUtil.nextInt());

		anPham_TapChi.setIsFormViewBinhLuan(RandomTestUtil.nextInt());

		anPham_TapChi.setStatus(RandomTestUtil.nextInt());

		anPham_TapChi.setOrders(RandomTestUtil.nextLong());

		anPham_TapChi.setDelete_status(RandomTestUtil.nextInt());

		_anPham_TapChis.add(_persistence.update(anPham_TapChi));

		return anPham_TapChi;
	}

	private List<AnPham_TapChi> _anPham_TapChis =
		new ArrayList<AnPham_TapChi>();
	private AnPham_TapChiPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}