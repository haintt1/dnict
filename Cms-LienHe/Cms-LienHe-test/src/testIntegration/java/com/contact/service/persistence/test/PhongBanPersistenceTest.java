/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.persistence.test;

import com.contact.exception.NoSuchPhongBanException;
import com.contact.model.PhongBan;
import com.contact.service.PhongBanLocalServiceUtil;
import com.contact.service.persistence.PhongBanPersistence;
import com.contact.service.persistence.PhongBanUtil;

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

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class PhongBanPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.contact.service"));

	@Before
	public void setUp() {
		_persistence = PhongBanUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PhongBan> iterator = _phongBans.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PhongBan phongBan = _persistence.create(pk);

		Assert.assertNotNull(phongBan);

		Assert.assertEquals(phongBan.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PhongBan newPhongBan = addPhongBan();

		_persistence.remove(newPhongBan);

		PhongBan existingPhongBan = _persistence.fetchByPrimaryKey(
			newPhongBan.getPrimaryKey());

		Assert.assertNull(existingPhongBan);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPhongBan();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PhongBan newPhongBan = _persistence.create(pk);

		newPhongBan.setCompanyId(RandomTestUtil.nextLong());

		newPhongBan.setGroupId(RandomTestUtil.nextLong());

		newPhongBan.setTen(RandomTestUtil.randomString());

		newPhongBan.setMoTa(RandomTestUtil.randomString());

		newPhongBan.setTochuc_id(RandomTestUtil.nextLong());

		newPhongBan.setTinhTrang(RandomTestUtil.nextLong());

		newPhongBan.setSapXep(RandomTestUtil.nextInt());

		newPhongBan.setDaXoa(RandomTestUtil.nextLong());

		newPhongBan.setNgayTao(RandomTestUtil.nextDate());

		newPhongBan.setNgaySua(RandomTestUtil.nextDate());

		_phongBans.add(_persistence.update(newPhongBan));

		PhongBan existingPhongBan = _persistence.findByPrimaryKey(
			newPhongBan.getPrimaryKey());

		Assert.assertEquals(
			existingPhongBan.getPhongbanId(), newPhongBan.getPhongbanId());
		Assert.assertEquals(
			existingPhongBan.getCompanyId(), newPhongBan.getCompanyId());
		Assert.assertEquals(
			existingPhongBan.getGroupId(), newPhongBan.getGroupId());
		Assert.assertEquals(existingPhongBan.getTen(), newPhongBan.getTen());
		Assert.assertEquals(existingPhongBan.getMoTa(), newPhongBan.getMoTa());
		Assert.assertEquals(
			existingPhongBan.getTochuc_id(), newPhongBan.getTochuc_id());
		Assert.assertEquals(
			existingPhongBan.getTinhTrang(), newPhongBan.getTinhTrang());
		Assert.assertEquals(
			existingPhongBan.getSapXep(), newPhongBan.getSapXep());
		Assert.assertEquals(
			existingPhongBan.getDaXoa(), newPhongBan.getDaXoa());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPhongBan.getNgayTao()),
			Time.getShortTimestamp(newPhongBan.getNgayTao()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingPhongBan.getNgaySua()),
			Time.getShortTimestamp(newPhongBan.getNgaySua()));
	}

	@Test
	public void testCountByten() throws Exception {
		_persistence.countByten("");

		_persistence.countByten("null");

		_persistence.countByten((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		PhongBan newPhongBan = addPhongBan();

		PhongBan existingPhongBan = _persistence.findByPrimaryKey(
			newPhongBan.getPrimaryKey());

		Assert.assertEquals(existingPhongBan, newPhongBan);
	}

	@Test(expected = NoSuchPhongBanException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<PhongBan> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cms_lienhe_phongban", "phongbanId", true, "companyId", true,
			"groupId", true, "ten", true, "moTa", true, "tochuc_id", true,
			"tinhTrang", true, "sapXep", true, "daXoa", true, "ngayTao", true,
			"ngaySua", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PhongBan newPhongBan = addPhongBan();

		PhongBan existingPhongBan = _persistence.fetchByPrimaryKey(
			newPhongBan.getPrimaryKey());

		Assert.assertEquals(existingPhongBan, newPhongBan);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PhongBan missingPhongBan = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPhongBan);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		PhongBan newPhongBan1 = addPhongBan();
		PhongBan newPhongBan2 = addPhongBan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPhongBan1.getPrimaryKey());
		primaryKeys.add(newPhongBan2.getPrimaryKey());

		Map<Serializable, PhongBan> phongBans = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, phongBans.size());
		Assert.assertEquals(
			newPhongBan1, phongBans.get(newPhongBan1.getPrimaryKey()));
		Assert.assertEquals(
			newPhongBan2, phongBans.get(newPhongBan2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, PhongBan> phongBans = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(phongBans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		PhongBan newPhongBan = addPhongBan();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPhongBan.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, PhongBan> phongBans = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, phongBans.size());
		Assert.assertEquals(
			newPhongBan, phongBans.get(newPhongBan.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, PhongBan> phongBans = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(phongBans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		PhongBan newPhongBan = addPhongBan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPhongBan.getPrimaryKey());

		Map<Serializable, PhongBan> phongBans = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, phongBans.size());
		Assert.assertEquals(
			newPhongBan, phongBans.get(newPhongBan.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PhongBanLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<PhongBan>() {

				@Override
				public void performAction(PhongBan phongBan) {
					Assert.assertNotNull(phongBan);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		PhongBan newPhongBan = addPhongBan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PhongBan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"phongbanId", newPhongBan.getPhongbanId()));

		List<PhongBan> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		PhongBan existingPhongBan = result.get(0);

		Assert.assertEquals(existingPhongBan, newPhongBan);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PhongBan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"phongbanId", RandomTestUtil.nextLong()));

		List<PhongBan> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		PhongBan newPhongBan = addPhongBan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PhongBan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("phongbanId"));

		Object newPhongbanId = newPhongBan.getPhongbanId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"phongbanId", new Object[] {newPhongbanId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPhongbanId = result.get(0);

		Assert.assertEquals(existingPhongbanId, newPhongbanId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PhongBan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("phongbanId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"phongbanId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected PhongBan addPhongBan() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PhongBan phongBan = _persistence.create(pk);

		phongBan.setCompanyId(RandomTestUtil.nextLong());

		phongBan.setGroupId(RandomTestUtil.nextLong());

		phongBan.setTen(RandomTestUtil.randomString());

		phongBan.setMoTa(RandomTestUtil.randomString());

		phongBan.setTochuc_id(RandomTestUtil.nextLong());

		phongBan.setTinhTrang(RandomTestUtil.nextLong());

		phongBan.setSapXep(RandomTestUtil.nextInt());

		phongBan.setDaXoa(RandomTestUtil.nextLong());

		phongBan.setNgayTao(RandomTestUtil.nextDate());

		phongBan.setNgaySua(RandomTestUtil.nextDate());

		_phongBans.add(_persistence.update(phongBan));

		return phongBan;
	}

	private List<PhongBan> _phongBans = new ArrayList<PhongBan>();
	private PhongBanPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}