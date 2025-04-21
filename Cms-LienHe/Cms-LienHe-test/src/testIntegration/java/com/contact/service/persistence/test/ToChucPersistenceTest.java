/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.persistence.test;

import com.contact.exception.NoSuchToChucException;
import com.contact.model.ToChuc;
import com.contact.service.ToChucLocalServiceUtil;
import com.contact.service.persistence.ToChucPersistence;
import com.contact.service.persistence.ToChucUtil;

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
public class ToChucPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.contact.service"));

	@Before
	public void setUp() {
		_persistence = ToChucUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ToChuc> iterator = _toChucs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ToChuc toChuc = _persistence.create(pk);

		Assert.assertNotNull(toChuc);

		Assert.assertEquals(toChuc.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ToChuc newToChuc = addToChuc();

		_persistence.remove(newToChuc);

		ToChuc existingToChuc = _persistence.fetchByPrimaryKey(
			newToChuc.getPrimaryKey());

		Assert.assertNull(existingToChuc);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addToChuc();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ToChuc newToChuc = _persistence.create(pk);

		newToChuc.setCompanyId(RandomTestUtil.nextLong());

		newToChuc.setGroupId(RandomTestUtil.nextLong());

		newToChuc.setTen(RandomTestUtil.randomString());

		newToChuc.setMoTa(RandomTestUtil.randomString());

		newToChuc.setTinhTrang(RandomTestUtil.nextLong());

		newToChuc.setSapXep(RandomTestUtil.nextInt());

		newToChuc.setDaXoa(RandomTestUtil.nextLong());

		newToChuc.setNgayTao(RandomTestUtil.nextDate());

		newToChuc.setNgaySua(RandomTestUtil.nextDate());

		_toChucs.add(_persistence.update(newToChuc));

		ToChuc existingToChuc = _persistence.findByPrimaryKey(
			newToChuc.getPrimaryKey());

		Assert.assertEquals(
			existingToChuc.getTochucId(), newToChuc.getTochucId());
		Assert.assertEquals(
			existingToChuc.getCompanyId(), newToChuc.getCompanyId());
		Assert.assertEquals(
			existingToChuc.getGroupId(), newToChuc.getGroupId());
		Assert.assertEquals(existingToChuc.getTen(), newToChuc.getTen());
		Assert.assertEquals(existingToChuc.getMoTa(), newToChuc.getMoTa());
		Assert.assertEquals(
			existingToChuc.getTinhTrang(), newToChuc.getTinhTrang());
		Assert.assertEquals(existingToChuc.getSapXep(), newToChuc.getSapXep());
		Assert.assertEquals(existingToChuc.getDaXoa(), newToChuc.getDaXoa());
		Assert.assertEquals(
			Time.getShortTimestamp(existingToChuc.getNgayTao()),
			Time.getShortTimestamp(newToChuc.getNgayTao()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingToChuc.getNgaySua()),
			Time.getShortTimestamp(newToChuc.getNgaySua()));
	}

	@Test
	public void testCountByten() throws Exception {
		_persistence.countByten("");

		_persistence.countByten("null");

		_persistence.countByten((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ToChuc newToChuc = addToChuc();

		ToChuc existingToChuc = _persistence.findByPrimaryKey(
			newToChuc.getPrimaryKey());

		Assert.assertEquals(existingToChuc, newToChuc);
	}

	@Test(expected = NoSuchToChucException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ToChuc> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cms_lienhe_tochuc", "tochucId", true, "companyId", true, "groupId",
			true, "ten", true, "moTa", true, "tinhTrang", true, "sapXep", true,
			"daXoa", true, "ngayTao", true, "ngaySua", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ToChuc newToChuc = addToChuc();

		ToChuc existingToChuc = _persistence.fetchByPrimaryKey(
			newToChuc.getPrimaryKey());

		Assert.assertEquals(existingToChuc, newToChuc);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ToChuc missingToChuc = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingToChuc);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ToChuc newToChuc1 = addToChuc();
		ToChuc newToChuc2 = addToChuc();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newToChuc1.getPrimaryKey());
		primaryKeys.add(newToChuc2.getPrimaryKey());

		Map<Serializable, ToChuc> toChucs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, toChucs.size());
		Assert.assertEquals(
			newToChuc1, toChucs.get(newToChuc1.getPrimaryKey()));
		Assert.assertEquals(
			newToChuc2, toChucs.get(newToChuc2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ToChuc> toChucs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(toChucs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ToChuc newToChuc = addToChuc();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newToChuc.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ToChuc> toChucs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, toChucs.size());
		Assert.assertEquals(newToChuc, toChucs.get(newToChuc.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ToChuc> toChucs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(toChucs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ToChuc newToChuc = addToChuc();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newToChuc.getPrimaryKey());

		Map<Serializable, ToChuc> toChucs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, toChucs.size());
		Assert.assertEquals(newToChuc, toChucs.get(newToChuc.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ToChucLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ToChuc>() {

				@Override
				public void performAction(ToChuc toChuc) {
					Assert.assertNotNull(toChuc);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ToChuc newToChuc = addToChuc();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ToChuc.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("tochucId", newToChuc.getTochucId()));

		List<ToChuc> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		ToChuc existingToChuc = result.get(0);

		Assert.assertEquals(existingToChuc, newToChuc);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ToChuc.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("tochucId", RandomTestUtil.nextLong()));

		List<ToChuc> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ToChuc newToChuc = addToChuc();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ToChuc.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("tochucId"));

		Object newTochucId = newToChuc.getTochucId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("tochucId", new Object[] {newTochucId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTochucId = result.get(0);

		Assert.assertEquals(existingTochucId, newTochucId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ToChuc.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("tochucId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"tochucId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ToChuc addToChuc() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ToChuc toChuc = _persistence.create(pk);

		toChuc.setCompanyId(RandomTestUtil.nextLong());

		toChuc.setGroupId(RandomTestUtil.nextLong());

		toChuc.setTen(RandomTestUtil.randomString());

		toChuc.setMoTa(RandomTestUtil.randomString());

		toChuc.setTinhTrang(RandomTestUtil.nextLong());

		toChuc.setSapXep(RandomTestUtil.nextInt());

		toChuc.setDaXoa(RandomTestUtil.nextLong());

		toChuc.setNgayTao(RandomTestUtil.nextDate());

		toChuc.setNgaySua(RandomTestUtil.nextDate());

		_toChucs.add(_persistence.update(toChuc));

		return toChuc;
	}

	private List<ToChuc> _toChucs = new ArrayList<ToChuc>();
	private ToChucPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}