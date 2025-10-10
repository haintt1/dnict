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

package vn.dnict.vanbanphapquy.service.persistence.test;

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

import vn.dnict.vanbanphapquy.exception.NoSuchCoquanbanhanhException;
import vn.dnict.vanbanphapquy.model.Coquanbanhanh;
import vn.dnict.vanbanphapquy.service.CoquanbanhanhLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.persistence.CoquanbanhanhPersistence;
import vn.dnict.vanbanphapquy.service.persistence.CoquanbanhanhUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CoquanbanhanhPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.vanbanphapquy.service"));

	@Before
	public void setUp() {
		_persistence = CoquanbanhanhUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Coquanbanhanh> iterator = _coquanbanhanhs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Coquanbanhanh coquanbanhanh = _persistence.create(pk);

		Assert.assertNotNull(coquanbanhanh);

		Assert.assertEquals(coquanbanhanh.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Coquanbanhanh newCoquanbanhanh = addCoquanbanhanh();

		_persistence.remove(newCoquanbanhanh);

		Coquanbanhanh existingCoquanbanhanh = _persistence.fetchByPrimaryKey(
			newCoquanbanhanh.getPrimaryKey());

		Assert.assertNull(existingCoquanbanhanh);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCoquanbanhanh();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Coquanbanhanh newCoquanbanhanh = _persistence.create(pk);

		newCoquanbanhanh.setCompanyId(RandomTestUtil.nextLong());

		newCoquanbanhanh.setGroupId(RandomTestUtil.nextLong());

		newCoquanbanhanh.setName(RandomTestUtil.randomString());

		newCoquanbanhanh.setCode(RandomTestUtil.randomString());

		newCoquanbanhanh.setStatus(RandomTestUtil.nextInt());

		_coquanbanhanhs.add(_persistence.update(newCoquanbanhanh));

		Coquanbanhanh existingCoquanbanhanh = _persistence.findByPrimaryKey(
			newCoquanbanhanh.getPrimaryKey());

		Assert.assertEquals(
			existingCoquanbanhanh.getId(), newCoquanbanhanh.getId());
		Assert.assertEquals(
			existingCoquanbanhanh.getCompanyId(),
			newCoquanbanhanh.getCompanyId());
		Assert.assertEquals(
			existingCoquanbanhanh.getGroupId(), newCoquanbanhanh.getGroupId());
		Assert.assertEquals(
			existingCoquanbanhanh.getName(), newCoquanbanhanh.getName());
		Assert.assertEquals(
			existingCoquanbanhanh.getCode(), newCoquanbanhanh.getCode());
		Assert.assertEquals(
			existingCoquanbanhanh.getStatus(), newCoquanbanhanh.getStatus());
	}

	@Test
	public void testCountByStatus() throws Exception {
		_persistence.countByStatus(RandomTestUtil.nextInt());

		_persistence.countByStatus(0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Coquanbanhanh newCoquanbanhanh = addCoquanbanhanh();

		Coquanbanhanh existingCoquanbanhanh = _persistence.findByPrimaryKey(
			newCoquanbanhanh.getPrimaryKey());

		Assert.assertEquals(existingCoquanbanhanh, newCoquanbanhanh);
	}

	@Test(expected = NoSuchCoquanbanhanhException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Coquanbanhanh> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_coquanbanhanh", "id", true, "companyId", true, "groupId", true,
			"name", true, "code", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Coquanbanhanh newCoquanbanhanh = addCoquanbanhanh();

		Coquanbanhanh existingCoquanbanhanh = _persistence.fetchByPrimaryKey(
			newCoquanbanhanh.getPrimaryKey());

		Assert.assertEquals(existingCoquanbanhanh, newCoquanbanhanh);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Coquanbanhanh missingCoquanbanhanh = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCoquanbanhanh);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Coquanbanhanh newCoquanbanhanh1 = addCoquanbanhanh();
		Coquanbanhanh newCoquanbanhanh2 = addCoquanbanhanh();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCoquanbanhanh1.getPrimaryKey());
		primaryKeys.add(newCoquanbanhanh2.getPrimaryKey());

		Map<Serializable, Coquanbanhanh> coquanbanhanhs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, coquanbanhanhs.size());
		Assert.assertEquals(
			newCoquanbanhanh1,
			coquanbanhanhs.get(newCoquanbanhanh1.getPrimaryKey()));
		Assert.assertEquals(
			newCoquanbanhanh2,
			coquanbanhanhs.get(newCoquanbanhanh2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Coquanbanhanh> coquanbanhanhs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(coquanbanhanhs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Coquanbanhanh newCoquanbanhanh = addCoquanbanhanh();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCoquanbanhanh.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Coquanbanhanh> coquanbanhanhs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, coquanbanhanhs.size());
		Assert.assertEquals(
			newCoquanbanhanh,
			coquanbanhanhs.get(newCoquanbanhanh.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Coquanbanhanh> coquanbanhanhs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(coquanbanhanhs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Coquanbanhanh newCoquanbanhanh = addCoquanbanhanh();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCoquanbanhanh.getPrimaryKey());

		Map<Serializable, Coquanbanhanh> coquanbanhanhs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, coquanbanhanhs.size());
		Assert.assertEquals(
			newCoquanbanhanh,
			coquanbanhanhs.get(newCoquanbanhanh.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CoquanbanhanhLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Coquanbanhanh>() {

				@Override
				public void performAction(Coquanbanhanh coquanbanhanh) {
					Assert.assertNotNull(coquanbanhanh);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Coquanbanhanh newCoquanbanhanh = addCoquanbanhanh();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Coquanbanhanh.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newCoquanbanhanh.getId()));

		List<Coquanbanhanh> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Coquanbanhanh existingCoquanbanhanh = result.get(0);

		Assert.assertEquals(existingCoquanbanhanh, newCoquanbanhanh);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Coquanbanhanh.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Coquanbanhanh> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Coquanbanhanh newCoquanbanhanh = addCoquanbanhanh();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Coquanbanhanh.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newCoquanbanhanh.getId();

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
			Coquanbanhanh.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Coquanbanhanh addCoquanbanhanh() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Coquanbanhanh coquanbanhanh = _persistence.create(pk);

		coquanbanhanh.setCompanyId(RandomTestUtil.nextLong());

		coquanbanhanh.setGroupId(RandomTestUtil.nextLong());

		coquanbanhanh.setName(RandomTestUtil.randomString());

		coquanbanhanh.setCode(RandomTestUtil.randomString());

		coquanbanhanh.setStatus(RandomTestUtil.nextInt());

		_coquanbanhanhs.add(_persistence.update(coquanbanhanh));

		return coquanbanhanh;
	}

	private List<Coquanbanhanh> _coquanbanhanhs =
		new ArrayList<Coquanbanhanh>();
	private CoquanbanhanhPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}