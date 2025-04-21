/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.service.persistence.test;

import com.demo.exception.NoSuchDemoDBException;
import com.demo.model.DemoDB;
import com.demo.service.DemoDBLocalServiceUtil;
import com.demo.service.persistence.DemoDBPersistence;
import com.demo.service.persistence.DemoDBUtil;

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
public class DemoDBPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.demo.service"));

	@Before
	public void setUp() {
		_persistence = DemoDBUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DemoDB> iterator = _demoDBs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DemoDB demoDB = _persistence.create(pk);

		Assert.assertNotNull(demoDB);

		Assert.assertEquals(demoDB.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DemoDB newDemoDB = addDemoDB();

		_persistence.remove(newDemoDB);

		DemoDB existingDemoDB = _persistence.fetchByPrimaryKey(
			newDemoDB.getPrimaryKey());

		Assert.assertNull(existingDemoDB);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDemoDB();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DemoDB newDemoDB = _persistence.create(pk);

		newDemoDB.setTen(RandomTestUtil.randomString());

		newDemoDB.setMoTa(RandomTestUtil.randomString());

		newDemoDB.setNoiDung(RandomTestUtil.randomString());

		newDemoDB.setNgayxuatban(RandomTestUtil.nextDate());

		newDemoDB.setNgayhethan(RandomTestUtil.nextDate());

		newDemoDB.setTinhtrang(RandomTestUtil.nextInt());

		_demoDBs.add(_persistence.update(newDemoDB));

		DemoDB existingDemoDB = _persistence.findByPrimaryKey(
			newDemoDB.getPrimaryKey());

		Assert.assertEquals(existingDemoDB.getId(), newDemoDB.getId());
		Assert.assertEquals(existingDemoDB.getTen(), newDemoDB.getTen());
		Assert.assertEquals(existingDemoDB.getMoTa(), newDemoDB.getMoTa());
		Assert.assertEquals(
			existingDemoDB.getNoiDung(), newDemoDB.getNoiDung());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDemoDB.getNgayxuatban()),
			Time.getShortTimestamp(newDemoDB.getNgayxuatban()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDemoDB.getNgayhethan()),
			Time.getShortTimestamp(newDemoDB.getNgayhethan()));
		Assert.assertEquals(
			existingDemoDB.getTinhtrang(), newDemoDB.getTinhtrang());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DemoDB newDemoDB = addDemoDB();

		DemoDB existingDemoDB = _persistence.findByPrimaryKey(
			newDemoDB.getPrimaryKey());

		Assert.assertEquals(existingDemoDB, newDemoDB);
	}

	@Test(expected = NoSuchDemoDBException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<DemoDB> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_DemoDB", "id", true, "ten", true, "moTa", true, "noiDung", true,
			"ngayxuatban", true, "ngayhethan", true, "tinhtrang", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DemoDB newDemoDB = addDemoDB();

		DemoDB existingDemoDB = _persistence.fetchByPrimaryKey(
			newDemoDB.getPrimaryKey());

		Assert.assertEquals(existingDemoDB, newDemoDB);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DemoDB missingDemoDB = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDemoDB);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DemoDB newDemoDB1 = addDemoDB();
		DemoDB newDemoDB2 = addDemoDB();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDemoDB1.getPrimaryKey());
		primaryKeys.add(newDemoDB2.getPrimaryKey());

		Map<Serializable, DemoDB> demoDBs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, demoDBs.size());
		Assert.assertEquals(
			newDemoDB1, demoDBs.get(newDemoDB1.getPrimaryKey()));
		Assert.assertEquals(
			newDemoDB2, demoDBs.get(newDemoDB2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DemoDB> demoDBs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(demoDBs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DemoDB newDemoDB = addDemoDB();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDemoDB.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DemoDB> demoDBs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, demoDBs.size());
		Assert.assertEquals(newDemoDB, demoDBs.get(newDemoDB.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DemoDB> demoDBs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(demoDBs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DemoDB newDemoDB = addDemoDB();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDemoDB.getPrimaryKey());

		Map<Serializable, DemoDB> demoDBs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, demoDBs.size());
		Assert.assertEquals(newDemoDB, demoDBs.get(newDemoDB.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DemoDBLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DemoDB>() {

				@Override
				public void performAction(DemoDB demoDB) {
					Assert.assertNotNull(demoDB);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DemoDB newDemoDB = addDemoDB();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DemoDB.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newDemoDB.getId()));

		List<DemoDB> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		DemoDB existingDemoDB = result.get(0);

		Assert.assertEquals(existingDemoDB, newDemoDB);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DemoDB.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<DemoDB> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DemoDB newDemoDB = addDemoDB();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DemoDB.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newDemoDB.getId();

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
			DemoDB.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected DemoDB addDemoDB() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DemoDB demoDB = _persistence.create(pk);

		demoDB.setTen(RandomTestUtil.randomString());

		demoDB.setMoTa(RandomTestUtil.randomString());

		demoDB.setNoiDung(RandomTestUtil.randomString());

		demoDB.setNgayxuatban(RandomTestUtil.nextDate());

		demoDB.setNgayhethan(RandomTestUtil.nextDate());

		demoDB.setTinhtrang(RandomTestUtil.nextInt());

		_demoDBs.add(_persistence.update(demoDB));

		return demoDB;
	}

	private List<DemoDB> _demoDBs = new ArrayList<DemoDB>();
	private DemoDBPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}