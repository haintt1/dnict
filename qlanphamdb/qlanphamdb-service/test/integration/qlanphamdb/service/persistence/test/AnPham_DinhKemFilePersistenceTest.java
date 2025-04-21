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

import qlanphamdb.exception.NoSuchAnPham_DinhKemFileException;

import qlanphamdb.model.AnPham_DinhKemFile;

import qlanphamdb.service.AnPham_DinhKemFileLocalServiceUtil;
import qlanphamdb.service.persistence.AnPham_DinhKemFilePersistence;
import qlanphamdb.service.persistence.AnPham_DinhKemFileUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AnPham_DinhKemFilePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "qlanphamdb.service"));

	@Before
	public void setUp() {
		_persistence = AnPham_DinhKemFileUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnPham_DinhKemFile> iterator = _anPham_DinhKemFiles.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_DinhKemFile anPham_DinhKemFile = _persistence.create(pk);

		Assert.assertNotNull(anPham_DinhKemFile);

		Assert.assertEquals(anPham_DinhKemFile.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnPham_DinhKemFile newAnPham_DinhKemFile = addAnPham_DinhKemFile();

		_persistence.remove(newAnPham_DinhKemFile);

		AnPham_DinhKemFile existingAnPham_DinhKemFile =
			_persistence.fetchByPrimaryKey(
				newAnPham_DinhKemFile.getPrimaryKey());

		Assert.assertNull(existingAnPham_DinhKemFile);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnPham_DinhKemFile();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_DinhKemFile newAnPham_DinhKemFile = _persistence.create(pk);

		newAnPham_DinhKemFile.setCompanyId(RandomTestUtil.nextLong());

		newAnPham_DinhKemFile.setGroupId(RandomTestUtil.nextLong());

		newAnPham_DinhKemFile.setUserId(RandomTestUtil.nextLong());

		newAnPham_DinhKemFile.setTen(RandomTestUtil.randomString());

		newAnPham_DinhKemFile.setUrl(RandomTestUtil.randomString());

		newAnPham_DinhKemFile.setObject(RandomTestUtil.nextLong());

		newAnPham_DinhKemFile.setObjectId(RandomTestUtil.nextLong());

		newAnPham_DinhKemFile.setLuotTai(RandomTestUtil.nextLong());

		newAnPham_DinhKemFile.setGhiChu(RandomTestUtil.randomString());

		newAnPham_DinhKemFile.setDelete_status(RandomTestUtil.nextInt());

		newAnPham_DinhKemFile.setStatus(RandomTestUtil.nextInt());

		_anPham_DinhKemFiles.add(_persistence.update(newAnPham_DinhKemFile));

		AnPham_DinhKemFile existingAnPham_DinhKemFile =
			_persistence.findByPrimaryKey(
				newAnPham_DinhKemFile.getPrimaryKey());

		Assert.assertEquals(
			existingAnPham_DinhKemFile.getId(), newAnPham_DinhKemFile.getId());
		Assert.assertEquals(
			existingAnPham_DinhKemFile.getCompanyId(),
			newAnPham_DinhKemFile.getCompanyId());
		Assert.assertEquals(
			existingAnPham_DinhKemFile.getGroupId(),
			newAnPham_DinhKemFile.getGroupId());
		Assert.assertEquals(
			existingAnPham_DinhKemFile.getUserId(),
			newAnPham_DinhKemFile.getUserId());
		Assert.assertEquals(
			existingAnPham_DinhKemFile.getTen(),
			newAnPham_DinhKemFile.getTen());
		Assert.assertEquals(
			existingAnPham_DinhKemFile.getUrl(),
			newAnPham_DinhKemFile.getUrl());
		Assert.assertEquals(
			existingAnPham_DinhKemFile.getObject(),
			newAnPham_DinhKemFile.getObject());
		Assert.assertEquals(
			existingAnPham_DinhKemFile.getObjectId(),
			newAnPham_DinhKemFile.getObjectId());
		Assert.assertEquals(
			existingAnPham_DinhKemFile.getLuotTai(),
			newAnPham_DinhKemFile.getLuotTai());
		Assert.assertEquals(
			existingAnPham_DinhKemFile.getGhiChu(),
			newAnPham_DinhKemFile.getGhiChu());
		Assert.assertEquals(
			existingAnPham_DinhKemFile.getDelete_status(),
			newAnPham_DinhKemFile.getDelete_status());
		Assert.assertEquals(
			existingAnPham_DinhKemFile.getStatus(),
			newAnPham_DinhKemFile.getStatus());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnPham_DinhKemFile newAnPham_DinhKemFile = addAnPham_DinhKemFile();

		AnPham_DinhKemFile existingAnPham_DinhKemFile =
			_persistence.findByPrimaryKey(
				newAnPham_DinhKemFile.getPrimaryKey());

		Assert.assertEquals(existingAnPham_DinhKemFile, newAnPham_DinhKemFile);
	}

	@Test(expected = NoSuchAnPham_DinhKemFileException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AnPham_DinhKemFile> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_AnPham_DinhKemFile", "id", true, "companyId", true, "groupId",
			true, "userId", true, "ten", true, "url", true, "Object", true,
			"ObjectId", true, "luotTai", true, "ghiChu", true, "delete_status",
			true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnPham_DinhKemFile newAnPham_DinhKemFile = addAnPham_DinhKemFile();

		AnPham_DinhKemFile existingAnPham_DinhKemFile =
			_persistence.fetchByPrimaryKey(
				newAnPham_DinhKemFile.getPrimaryKey());

		Assert.assertEquals(existingAnPham_DinhKemFile, newAnPham_DinhKemFile);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_DinhKemFile missingAnPham_DinhKemFile =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnPham_DinhKemFile);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AnPham_DinhKemFile newAnPham_DinhKemFile1 = addAnPham_DinhKemFile();
		AnPham_DinhKemFile newAnPham_DinhKemFile2 = addAnPham_DinhKemFile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_DinhKemFile1.getPrimaryKey());
		primaryKeys.add(newAnPham_DinhKemFile2.getPrimaryKey());

		Map<Serializable, AnPham_DinhKemFile> anPham_DinhKemFiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, anPham_DinhKemFiles.size());
		Assert.assertEquals(
			newAnPham_DinhKemFile1,
			anPham_DinhKemFiles.get(newAnPham_DinhKemFile1.getPrimaryKey()));
		Assert.assertEquals(
			newAnPham_DinhKemFile2,
			anPham_DinhKemFiles.get(newAnPham_DinhKemFile2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnPham_DinhKemFile> anPham_DinhKemFiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_DinhKemFiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AnPham_DinhKemFile newAnPham_DinhKemFile = addAnPham_DinhKemFile();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_DinhKemFile.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnPham_DinhKemFile> anPham_DinhKemFiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_DinhKemFiles.size());
		Assert.assertEquals(
			newAnPham_DinhKemFile,
			anPham_DinhKemFiles.get(newAnPham_DinhKemFile.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnPham_DinhKemFile> anPham_DinhKemFiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anPham_DinhKemFiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AnPham_DinhKemFile newAnPham_DinhKemFile = addAnPham_DinhKemFile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnPham_DinhKemFile.getPrimaryKey());

		Map<Serializable, AnPham_DinhKemFile> anPham_DinhKemFiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anPham_DinhKemFiles.size());
		Assert.assertEquals(
			newAnPham_DinhKemFile,
			anPham_DinhKemFiles.get(newAnPham_DinhKemFile.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AnPham_DinhKemFileLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<AnPham_DinhKemFile>() {

				@Override
				public void performAction(
					AnPham_DinhKemFile anPham_DinhKemFile) {

					Assert.assertNotNull(anPham_DinhKemFile);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AnPham_DinhKemFile newAnPham_DinhKemFile = addAnPham_DinhKemFile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_DinhKemFile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newAnPham_DinhKemFile.getId()));

		List<AnPham_DinhKemFile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnPham_DinhKemFile existingAnPham_DinhKemFile = result.get(0);

		Assert.assertEquals(existingAnPham_DinhKemFile, newAnPham_DinhKemFile);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_DinhKemFile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<AnPham_DinhKemFile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AnPham_DinhKemFile newAnPham_DinhKemFile = addAnPham_DinhKemFile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AnPham_DinhKemFile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newAnPham_DinhKemFile.getId();

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
			AnPham_DinhKemFile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnPham_DinhKemFile addAnPham_DinhKemFile() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnPham_DinhKemFile anPham_DinhKemFile = _persistence.create(pk);

		anPham_DinhKemFile.setCompanyId(RandomTestUtil.nextLong());

		anPham_DinhKemFile.setGroupId(RandomTestUtil.nextLong());

		anPham_DinhKemFile.setUserId(RandomTestUtil.nextLong());

		anPham_DinhKemFile.setTen(RandomTestUtil.randomString());

		anPham_DinhKemFile.setUrl(RandomTestUtil.randomString());

		anPham_DinhKemFile.setObject(RandomTestUtil.nextLong());

		anPham_DinhKemFile.setObjectId(RandomTestUtil.nextLong());

		anPham_DinhKemFile.setLuotTai(RandomTestUtil.nextLong());

		anPham_DinhKemFile.setGhiChu(RandomTestUtil.randomString());

		anPham_DinhKemFile.setDelete_status(RandomTestUtil.nextInt());

		anPham_DinhKemFile.setStatus(RandomTestUtil.nextInt());

		_anPham_DinhKemFiles.add(_persistence.update(anPham_DinhKemFile));

		return anPham_DinhKemFile;
	}

	private List<AnPham_DinhKemFile> _anPham_DinhKemFiles =
		new ArrayList<AnPham_DinhKemFile>();
	private AnPham_DinhKemFilePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}