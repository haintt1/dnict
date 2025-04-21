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

import qlanphamdb.exception.NoSucheMagazine_templateException;

import qlanphamdb.model.eMagazine_template;

import qlanphamdb.service.eMagazine_templateLocalServiceUtil;
import qlanphamdb.service.persistence.eMagazine_templatePersistence;
import qlanphamdb.service.persistence.eMagazine_templateUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class eMagazine_templatePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = eMagazine_templateUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<eMagazine_template> iterator = _eMagazine_templates.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_template eMagazine_template = _persistence.create(pk);

		Assert.assertNotNull(eMagazine_template);

		Assert.assertEquals(eMagazine_template.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		eMagazine_template neweMagazine_template = addeMagazine_template();

		_persistence.remove(neweMagazine_template);

		eMagazine_template existingeMagazine_template =
			_persistence.fetchByPrimaryKey(
				neweMagazine_template.getPrimaryKey());

		Assert.assertNull(existingeMagazine_template);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addeMagazine_template();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_template neweMagazine_template = _persistence.create(pk);

		neweMagazine_template.setCompanyId(RandomTestUtil.nextLong());

		neweMagazine_template.setGroupId(RandomTestUtil.nextLong());

		neweMagazine_template.setTen(RandomTestUtil.randomString());

		neweMagazine_template.setNoidung(RandomTestUtil.randomString());

		neweMagazine_template.setStatus(RandomTestUtil.nextInt());

		_eMagazine_templates.add(_persistence.update(neweMagazine_template));

		eMagazine_template existingeMagazine_template =
			_persistence.findByPrimaryKey(
				neweMagazine_template.getPrimaryKey());

		Assert.assertEquals(
			existingeMagazine_template.getId(), neweMagazine_template.getId());
		Assert.assertEquals(
			existingeMagazine_template.getCompanyId(),
			neweMagazine_template.getCompanyId());
		Assert.assertEquals(
			existingeMagazine_template.getGroupId(),
			neweMagazine_template.getGroupId());
		Assert.assertEquals(
			existingeMagazine_template.getTen(),
			neweMagazine_template.getTen());
		Assert.assertEquals(
			existingeMagazine_template.getNoidung(),
			neweMagazine_template.getNoidung());
		Assert.assertEquals(
			existingeMagazine_template.getStatus(),
			neweMagazine_template.getStatus());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		eMagazine_template neweMagazine_template = addeMagazine_template();

		eMagazine_template existingeMagazine_template =
			_persistence.findByPrimaryKey(
				neweMagazine_template.getPrimaryKey());

		Assert.assertEquals(existingeMagazine_template, neweMagazine_template);
	}

	@Test(expected = NoSucheMagazine_templateException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<eMagazine_template> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_eMagazine_template", "id", true, "companyId", true, "groupId",
			true, "ten", true, "noidung", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		eMagazine_template neweMagazine_template = addeMagazine_template();

		eMagazine_template existingeMagazine_template =
			_persistence.fetchByPrimaryKey(
				neweMagazine_template.getPrimaryKey());

		Assert.assertEquals(existingeMagazine_template, neweMagazine_template);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_template missingeMagazine_template =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingeMagazine_template);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		eMagazine_template neweMagazine_template1 = addeMagazine_template();
		eMagazine_template neweMagazine_template2 = addeMagazine_template();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine_template1.getPrimaryKey());
		primaryKeys.add(neweMagazine_template2.getPrimaryKey());

		Map<Serializable, eMagazine_template> eMagazine_templates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, eMagazine_templates.size());
		Assert.assertEquals(
			neweMagazine_template1,
			eMagazine_templates.get(neweMagazine_template1.getPrimaryKey()));
		Assert.assertEquals(
			neweMagazine_template2,
			eMagazine_templates.get(neweMagazine_template2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, eMagazine_template> eMagazine_templates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eMagazine_templates.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		eMagazine_template neweMagazine_template = addeMagazine_template();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine_template.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, eMagazine_template> eMagazine_templates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eMagazine_templates.size());
		Assert.assertEquals(
			neweMagazine_template,
			eMagazine_templates.get(neweMagazine_template.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, eMagazine_template> eMagazine_templates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eMagazine_templates.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		eMagazine_template neweMagazine_template = addeMagazine_template();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(neweMagazine_template.getPrimaryKey());

		Map<Serializable, eMagazine_template> eMagazine_templates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eMagazine_templates.size());
		Assert.assertEquals(
			neweMagazine_template,
			eMagazine_templates.get(neweMagazine_template.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			eMagazine_templateLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<eMagazine_template>() {

				@Override
				public void performAction(
					eMagazine_template eMagazine_template) {

					Assert.assertNotNull(eMagazine_template);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		eMagazine_template neweMagazine_template = addeMagazine_template();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine_template.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", neweMagazine_template.getId()));

		List<eMagazine_template> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		eMagazine_template existingeMagazine_template = result.get(0);

		Assert.assertEquals(existingeMagazine_template, neweMagazine_template);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine_template.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<eMagazine_template> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		eMagazine_template neweMagazine_template = addeMagazine_template();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			eMagazine_template.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = neweMagazine_template.getId();

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
			eMagazine_template.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected eMagazine_template addeMagazine_template() throws Exception {
		long pk = RandomTestUtil.nextLong();

		eMagazine_template eMagazine_template = _persistence.create(pk);

		eMagazine_template.setCompanyId(RandomTestUtil.nextLong());

		eMagazine_template.setGroupId(RandomTestUtil.nextLong());

		eMagazine_template.setTen(RandomTestUtil.randomString());

		eMagazine_template.setNoidung(RandomTestUtil.randomString());

		eMagazine_template.setStatus(RandomTestUtil.nextInt());

		_eMagazine_templates.add(_persistence.update(eMagazine_template));

		return eMagazine_template;
	}

	private List<eMagazine_template> _eMagazine_templates =
		new ArrayList<eMagazine_template>();
	private eMagazine_templatePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}