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

package vn.dnict.tintuc.service.persistence.test;

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

import vn.dnict.tintuc.exception.NoSuchNews_AttachFileException;
import vn.dnict.tintuc.model.News_AttachFile;
import vn.dnict.tintuc.service.News_AttachFileLocalServiceUtil;
import vn.dnict.tintuc.service.persistence.News_AttachFilePersistence;
import vn.dnict.tintuc.service.persistence.News_AttachFileUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class News_AttachFilePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.tintuc.service"));

	@Before
	public void setUp() {
		_persistence = News_AttachFileUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<News_AttachFile> iterator = _news_AttachFiles.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_AttachFile news_AttachFile = _persistence.create(pk);

		Assert.assertNotNull(news_AttachFile);

		Assert.assertEquals(news_AttachFile.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		News_AttachFile newNews_AttachFile = addNews_AttachFile();

		_persistence.remove(newNews_AttachFile);

		News_AttachFile existingNews_AttachFile =
			_persistence.fetchByPrimaryKey(newNews_AttachFile.getPrimaryKey());

		Assert.assertNull(existingNews_AttachFile);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNews_AttachFile();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_AttachFile newNews_AttachFile = _persistence.create(pk);

		newNews_AttachFile.setCompanyId(RandomTestUtil.nextLong());

		newNews_AttachFile.setGroupId(RandomTestUtil.nextLong());

		newNews_AttachFile.setUserId(RandomTestUtil.nextLong());

		newNews_AttachFile.setTen(RandomTestUtil.randomString());

		newNews_AttachFile.setUrl(RandomTestUtil.randomString());

		newNews_AttachFile.setObject(RandomTestUtil.nextLong());

		newNews_AttachFile.setObjectId(RandomTestUtil.nextLong());

		newNews_AttachFile.setGhichu(RandomTestUtil.randomString());

		newNews_AttachFile.setDaxoa(RandomTestUtil.nextInt());

		newNews_AttachFile.setTrangthai(RandomTestUtil.nextInt());

		_news_AttachFiles.add(_persistence.update(newNews_AttachFile));

		News_AttachFile existingNews_AttachFile = _persistence.findByPrimaryKey(
			newNews_AttachFile.getPrimaryKey());

		Assert.assertEquals(
			existingNews_AttachFile.getId(), newNews_AttachFile.getId());
		Assert.assertEquals(
			existingNews_AttachFile.getCompanyId(),
			newNews_AttachFile.getCompanyId());
		Assert.assertEquals(
			existingNews_AttachFile.getGroupId(),
			newNews_AttachFile.getGroupId());
		Assert.assertEquals(
			existingNews_AttachFile.getUserId(),
			newNews_AttachFile.getUserId());
		Assert.assertEquals(
			existingNews_AttachFile.getTen(), newNews_AttachFile.getTen());
		Assert.assertEquals(
			existingNews_AttachFile.getUrl(), newNews_AttachFile.getUrl());
		Assert.assertEquals(
			existingNews_AttachFile.getObject(),
			newNews_AttachFile.getObject());
		Assert.assertEquals(
			existingNews_AttachFile.getObjectId(),
			newNews_AttachFile.getObjectId());
		Assert.assertEquals(
			existingNews_AttachFile.getGhichu(),
			newNews_AttachFile.getGhichu());
		Assert.assertEquals(
			existingNews_AttachFile.getDaxoa(), newNews_AttachFile.getDaxoa());
		Assert.assertEquals(
			existingNews_AttachFile.getTrangthai(),
			newNews_AttachFile.getTrangthai());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		News_AttachFile newNews_AttachFile = addNews_AttachFile();

		News_AttachFile existingNews_AttachFile = _persistence.findByPrimaryKey(
			newNews_AttachFile.getPrimaryKey());

		Assert.assertEquals(existingNews_AttachFile, newNews_AttachFile);
	}

	@Test(expected = NoSuchNews_AttachFileException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<News_AttachFile> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_News_AttachFile", "id", true, "companyId", true, "groupId",
			true, "userId", true, "ten", true, "url", true, "Object", true,
			"ObjectId", true, "ghichu", true, "daxoa", true, "trangthai", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		News_AttachFile newNews_AttachFile = addNews_AttachFile();

		News_AttachFile existingNews_AttachFile =
			_persistence.fetchByPrimaryKey(newNews_AttachFile.getPrimaryKey());

		Assert.assertEquals(existingNews_AttachFile, newNews_AttachFile);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_AttachFile missingNews_AttachFile = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingNews_AttachFile);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		News_AttachFile newNews_AttachFile1 = addNews_AttachFile();
		News_AttachFile newNews_AttachFile2 = addNews_AttachFile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_AttachFile1.getPrimaryKey());
		primaryKeys.add(newNews_AttachFile2.getPrimaryKey());

		Map<Serializable, News_AttachFile> news_AttachFiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, news_AttachFiles.size());
		Assert.assertEquals(
			newNews_AttachFile1,
			news_AttachFiles.get(newNews_AttachFile1.getPrimaryKey()));
		Assert.assertEquals(
			newNews_AttachFile2,
			news_AttachFiles.get(newNews_AttachFile2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, News_AttachFile> news_AttachFiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_AttachFiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		News_AttachFile newNews_AttachFile = addNews_AttachFile();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_AttachFile.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, News_AttachFile> news_AttachFiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_AttachFiles.size());
		Assert.assertEquals(
			newNews_AttachFile,
			news_AttachFiles.get(newNews_AttachFile.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, News_AttachFile> news_AttachFiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_AttachFiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		News_AttachFile newNews_AttachFile = addNews_AttachFile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_AttachFile.getPrimaryKey());

		Map<Serializable, News_AttachFile> news_AttachFiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_AttachFiles.size());
		Assert.assertEquals(
			newNews_AttachFile,
			news_AttachFiles.get(newNews_AttachFile.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			News_AttachFileLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<News_AttachFile>() {

				@Override
				public void performAction(News_AttachFile news_AttachFile) {
					Assert.assertNotNull(news_AttachFile);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		News_AttachFile newNews_AttachFile = addNews_AttachFile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_AttachFile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNews_AttachFile.getId()));

		List<News_AttachFile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		News_AttachFile existingNews_AttachFile = result.get(0);

		Assert.assertEquals(existingNews_AttachFile, newNews_AttachFile);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_AttachFile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<News_AttachFile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		News_AttachFile newNews_AttachFile = addNews_AttachFile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_AttachFile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNews_AttachFile.getId();

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
			News_AttachFile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected News_AttachFile addNews_AttachFile() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_AttachFile news_AttachFile = _persistence.create(pk);

		news_AttachFile.setCompanyId(RandomTestUtil.nextLong());

		news_AttachFile.setGroupId(RandomTestUtil.nextLong());

		news_AttachFile.setUserId(RandomTestUtil.nextLong());

		news_AttachFile.setTen(RandomTestUtil.randomString());

		news_AttachFile.setUrl(RandomTestUtil.randomString());

		news_AttachFile.setObject(RandomTestUtil.nextLong());

		news_AttachFile.setObjectId(RandomTestUtil.nextLong());

		news_AttachFile.setGhichu(RandomTestUtil.randomString());

		news_AttachFile.setDaxoa(RandomTestUtil.nextInt());

		news_AttachFile.setTrangthai(RandomTestUtil.nextInt());

		_news_AttachFiles.add(_persistence.update(news_AttachFile));

		return news_AttachFile;
	}

	private List<News_AttachFile> _news_AttachFiles =
		new ArrayList<News_AttachFile>();
	private News_AttachFilePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}