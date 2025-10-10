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

import vn.dnict.vanbanphapquy.exception.NoSuchCapbanhanhException;
import vn.dnict.vanbanphapquy.model.Capbanhanh;
import vn.dnict.vanbanphapquy.service.CapbanhanhLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.persistence.CapbanhanhPersistence;
import vn.dnict.vanbanphapquy.service.persistence.CapbanhanhUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CapbanhanhPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.vanbanphapquy.service"));

	@Before
	public void setUp() {
		_persistence = CapbanhanhUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Capbanhanh> iterator = _capbanhanhs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Capbanhanh capbanhanh = _persistence.create(pk);

		Assert.assertNotNull(capbanhanh);

		Assert.assertEquals(capbanhanh.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Capbanhanh newCapbanhanh = addCapbanhanh();

		_persistence.remove(newCapbanhanh);

		Capbanhanh existingCapbanhanh = _persistence.fetchByPrimaryKey(
			newCapbanhanh.getPrimaryKey());

		Assert.assertNull(existingCapbanhanh);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCapbanhanh();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Capbanhanh newCapbanhanh = _persistence.create(pk);

		newCapbanhanh.setCompanyId(RandomTestUtil.nextLong());

		newCapbanhanh.setGroupId(RandomTestUtil.nextLong());

		newCapbanhanh.setName(RandomTestUtil.randomString());

		newCapbanhanh.setCode(RandomTestUtil.randomString());

		newCapbanhanh.setStatus(RandomTestUtil.nextInt());

		_capbanhanhs.add(_persistence.update(newCapbanhanh));

		Capbanhanh existingCapbanhanh = _persistence.findByPrimaryKey(
			newCapbanhanh.getPrimaryKey());

		Assert.assertEquals(existingCapbanhanh.getId(), newCapbanhanh.getId());
		Assert.assertEquals(
			existingCapbanhanh.getCompanyId(), newCapbanhanh.getCompanyId());
		Assert.assertEquals(
			existingCapbanhanh.getGroupId(), newCapbanhanh.getGroupId());
		Assert.assertEquals(
			existingCapbanhanh.getName(), newCapbanhanh.getName());
		Assert.assertEquals(
			existingCapbanhanh.getCode(), newCapbanhanh.getCode());
		Assert.assertEquals(
			existingCapbanhanh.getStatus(), newCapbanhanh.getStatus());
	}

	@Test
	public void testCountByStatus() throws Exception {
		_persistence.countByStatus(RandomTestUtil.nextInt());

		_persistence.countByStatus(0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Capbanhanh newCapbanhanh = addCapbanhanh();

		Capbanhanh existingCapbanhanh = _persistence.findByPrimaryKey(
			newCapbanhanh.getPrimaryKey());

		Assert.assertEquals(existingCapbanhanh, newCapbanhanh);
	}

	@Test(expected = NoSuchCapbanhanhException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Capbanhanh> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_capbanhanh", "id", true, "companyId", true, "groupId", true,
			"name", true, "code", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Capbanhanh newCapbanhanh = addCapbanhanh();

		Capbanhanh existingCapbanhanh = _persistence.fetchByPrimaryKey(
			newCapbanhanh.getPrimaryKey());

		Assert.assertEquals(existingCapbanhanh, newCapbanhanh);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Capbanhanh missingCapbanhanh = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCapbanhanh);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Capbanhanh newCapbanhanh1 = addCapbanhanh();
		Capbanhanh newCapbanhanh2 = addCapbanhanh();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCapbanhanh1.getPrimaryKey());
		primaryKeys.add(newCapbanhanh2.getPrimaryKey());

		Map<Serializable, Capbanhanh> capbanhanhs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, capbanhanhs.size());
		Assert.assertEquals(
			newCapbanhanh1, capbanhanhs.get(newCapbanhanh1.getPrimaryKey()));
		Assert.assertEquals(
			newCapbanhanh2, capbanhanhs.get(newCapbanhanh2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Capbanhanh> capbanhanhs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(capbanhanhs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Capbanhanh newCapbanhanh = addCapbanhanh();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCapbanhanh.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Capbanhanh> capbanhanhs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, capbanhanhs.size());
		Assert.assertEquals(
			newCapbanhanh, capbanhanhs.get(newCapbanhanh.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Capbanhanh> capbanhanhs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(capbanhanhs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Capbanhanh newCapbanhanh = addCapbanhanh();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCapbanhanh.getPrimaryKey());

		Map<Serializable, Capbanhanh> capbanhanhs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, capbanhanhs.size());
		Assert.assertEquals(
			newCapbanhanh, capbanhanhs.get(newCapbanhanh.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CapbanhanhLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Capbanhanh>() {

				@Override
				public void performAction(Capbanhanh capbanhanh) {
					Assert.assertNotNull(capbanhanh);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Capbanhanh newCapbanhanh = addCapbanhanh();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Capbanhanh.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newCapbanhanh.getId()));

		List<Capbanhanh> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Capbanhanh existingCapbanhanh = result.get(0);

		Assert.assertEquals(existingCapbanhanh, newCapbanhanh);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Capbanhanh.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Capbanhanh> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Capbanhanh newCapbanhanh = addCapbanhanh();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Capbanhanh.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newCapbanhanh.getId();

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
			Capbanhanh.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Capbanhanh addCapbanhanh() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Capbanhanh capbanhanh = _persistence.create(pk);

		capbanhanh.setCompanyId(RandomTestUtil.nextLong());

		capbanhanh.setGroupId(RandomTestUtil.nextLong());

		capbanhanh.setName(RandomTestUtil.randomString());

		capbanhanh.setCode(RandomTestUtil.randomString());

		capbanhanh.setStatus(RandomTestUtil.nextInt());

		_capbanhanhs.add(_persistence.update(capbanhanh));

		return capbanhanh;
	}

	private List<Capbanhanh> _capbanhanhs = new ArrayList<Capbanhanh>();
	private CapbanhanhPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}