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

import qlanphamdb.exception.NoSuchAnPham_LoaiException;

import qlanphamdb.model.AnPham_Loai;

import qlanphamdb.service.AnPham_LoaiLocalServiceUtil;
import qlanphamdb.service.persistence.AnPham_LoaiPersistence;
import qlanphamdb.service.persistence.AnPham_LoaiUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AnPham_LoaiPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = AnPham_LoaiUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnPham_Loai> iterator = _anPham_Loais.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Loai anPham_Loai = _persistence.create(pk);

		Assert.assertNotNull(anPham_Loai);

		Assert.assertEquals(anPham_Loai.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnPham_Loai newAnPham_Loai = addAnPham_Loai();

		_persistence.remove(newAnPham_Loai);

		AnPham_Loai existingAnPham_Loai = _persistence.fetchByPrimaryKey(
			newAnPham_Loai.getPrimaryKey());

		Assert.assertNull(existingAnPham_Loai);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnPham_Loai();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Loai newAnPham_Loai = _persistence.create(pk);

		newAnPham_Loai.setGroupId(RandomTestUtil.nextLong());

		newAnPham_Loai.setCompanyId(RandomTestUtil.nextLong());

		newAnPham_Loai.setTen(RandomTestUtil.randomString());

		newAnPham_Loai.setStatus(RandomTestUtil.nextInt());

		newAnPham_Loai.setOrders(RandomTestUtil.nextLong());

		newAnPham_Loai.setDelete_status(RandomTestUtil.nextInt());

		_anPham_Loais.add(_persistence.update(newAnPham_Loai));

		AnPham_Loai existingAnPham_Loai = _persistence.findByPrimaryKey(
			newAnPham_Loai.getPrimaryKey());

		Assert.assertEquals(
			existingAnPham_Loai.getId(), newAnPham_Loai.getId());
		Assert.assertEquals(
			existingAnPham_Loai.getGroupId(), newAnPham_Loai.getGroupId());
		Assert.assertEquals(
			existingAnPham_Loai.getCompanyId(), newAnPham_Loai.getCompanyId());
		Assert.assertEquals(
			existingAnPham_Loai.getTen(), newAnPham_Loai.getTen());
		Assert.assertEquals(
			existingAnPham_Loai.getStatus(), newAnPham_Loai.getStatus());
		Assert.assertEquals(
			existingAnPham_Loai.getOrders(), newAnPham_Loai.getOrders());
		Assert.assertEquals(
			existingAnPham_Loai.getDelete_status(),
			newAnPham_Loai.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnPham_Loai newAnPham_Loai = addAnPham_Loai();

		AnPham_Loai existingAnPham_Loai = _persistence.findByPrimaryKey(
			newAnPham_Loai.getPrimaryKey());

		Assert.assertEquals(existingAnPham_Loai, newAnPham_Loai);
	}

	@Test(expected = NoSuchAnPham_LoaiException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AnPham_Loai> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_AnPham_Loai", "id", true, "groupId", true, "companyId", true,
			"ten", true, "status", true, "orders", true, "delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnPham_Loai newAnPham_Loai = addAnPham_Loai();

		AnPham_Loai existingAnPham_Loai = _persistence.fetchByPrimaryKey(
			newAnPham_Loai.getPrimaryKey());

		Assert.assertEquals(existingAnPham_Loai, newAnPham_Loai);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Loai missingAnPham_Loai = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnPham_Loai);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AnPham_Loai newAnPham_Loai1 = addAnPham_Loai();
		AnPham_Loai newAnPham_Loai2 = addAnPham_Loai();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_Loai1.getPrimaryKey());
		primaryKeys.add(newAnPham_Loai2.getPrimaryKey());

		Map<Serializable, AnPham_Loai> anPham_Loais =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, anPham_Loais.size());
		Assert.assertEquals(
			newAnPham_Loai1, anPham_Loais.get(newAnPham_Loai1.getPrimaryKey()));
		Assert.assertEquals(
			newAnPham_Loai2, anPham_Loais.get(newAnPham_Loai2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnPham_Loai> anPham_Loais =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_Loais.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AnPham_Loai newAnPham_Loai = addAnPham_Loai();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_Loai.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnPham_Loai> anPham_Loais =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_Loais.size());
		Assert.assertEquals(
			newAnPham_Loai, anPham_Loais.get(newAnPham_Loai.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnPham_Loai> anPham_Loais =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_Loais.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AnPham_Loai newAnPham_Loai = addAnPham_Loai();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_Loai.getPrimaryKey());

		Map<Serializable, AnPham_Loai> anPham_Loais =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_Loais.size());
		Assert.assertEquals(
			newAnPham_Loai, anPham_Loais.get(newAnPham_Loai.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AnPham_LoaiLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AnPham_Loai>() {

				@Override
				public void performAction(AnPham_Loai anPham_Loai) {
					Assert.assertNotNull(anPham_Loai);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AnPham_Loai newAnPham_Loai = addAnPham_Loai();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_Loai.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newAnPham_Loai.getId()));

		List<AnPham_Loai> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnPham_Loai existingAnPham_Loai = result.get(0);

		Assert.assertEquals(existingAnPham_Loai, newAnPham_Loai);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_Loai.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<AnPham_Loai> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AnPham_Loai newAnPham_Loai = addAnPham_Loai();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_Loai.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newAnPham_Loai.getId();

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
			AnPham_Loai.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnPham_Loai addAnPham_Loai() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_Loai anPham_Loai = _persistence.create(pk);

		anPham_Loai.setGroupId(RandomTestUtil.nextLong());

		anPham_Loai.setCompanyId(RandomTestUtil.nextLong());

		anPham_Loai.setTen(RandomTestUtil.randomString());

		anPham_Loai.setStatus(RandomTestUtil.nextInt());

		anPham_Loai.setOrders(RandomTestUtil.nextLong());

		anPham_Loai.setDelete_status(RandomTestUtil.nextInt());

		_anPham_Loais.add(_persistence.update(anPham_Loai));

		return anPham_Loai;
	}

	private List<AnPham_Loai> _anPham_Loais = new ArrayList<AnPham_Loai>();
	private AnPham_LoaiPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}