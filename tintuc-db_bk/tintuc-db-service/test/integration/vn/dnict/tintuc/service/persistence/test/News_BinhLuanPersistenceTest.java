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

import vn.dnict.tintuc.exception.NoSuchNews_BinhLuanException;
import vn.dnict.tintuc.model.News_BinhLuan;
import vn.dnict.tintuc.service.News_BinhLuanLocalServiceUtil;
import vn.dnict.tintuc.service.persistence.News_BinhLuanPersistence;
import vn.dnict.tintuc.service.persistence.News_BinhLuanUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class News_BinhLuanPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.tintuc.service"));

	@Before
	public void setUp() {
		_persistence = News_BinhLuanUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<News_BinhLuan> iterator = _news_BinhLuans.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_BinhLuan news_BinhLuan = _persistence.create(pk);

		Assert.assertNotNull(news_BinhLuan);

		Assert.assertEquals(news_BinhLuan.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		News_BinhLuan newNews_BinhLuan = addNews_BinhLuan();

		_persistence.remove(newNews_BinhLuan);

		News_BinhLuan existingNews_BinhLuan = _persistence.fetchByPrimaryKey(
			newNews_BinhLuan.getPrimaryKey());

		Assert.assertNull(existingNews_BinhLuan);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNews_BinhLuan();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_BinhLuan newNews_BinhLuan = _persistence.create(pk);

		newNews_BinhLuan.setCompanyId(RandomTestUtil.nextLong());

		newNews_BinhLuan.setGroupId(RandomTestUtil.nextLong());

		newNews_BinhLuan.setNewarticleId(RandomTestUtil.nextLong());

		newNews_BinhLuan.setHoTen(RandomTestUtil.randomString());

		newNews_BinhLuan.setNoiDung(RandomTestUtil.randomString());

		newNews_BinhLuan.setNgayBinhLuan(RandomTestUtil.nextDate());

		newNews_BinhLuan.setStatus(RandomTestUtil.nextInt());

		newNews_BinhLuan.setOrders(RandomTestUtil.nextInt());

		newNews_BinhLuan.setDelete_status(RandomTestUtil.nextInt());

		_news_BinhLuans.add(_persistence.update(newNews_BinhLuan));

		News_BinhLuan existingNews_BinhLuan = _persistence.findByPrimaryKey(
			newNews_BinhLuan.getPrimaryKey());

		Assert.assertEquals(
			existingNews_BinhLuan.getId(), newNews_BinhLuan.getId());
		Assert.assertEquals(
			existingNews_BinhLuan.getCompanyId(),
			newNews_BinhLuan.getCompanyId());
		Assert.assertEquals(
			existingNews_BinhLuan.getGroupId(), newNews_BinhLuan.getGroupId());
		Assert.assertEquals(
			existingNews_BinhLuan.getNewarticleId(),
			newNews_BinhLuan.getNewarticleId());
		Assert.assertEquals(
			existingNews_BinhLuan.getHoTen(), newNews_BinhLuan.getHoTen());
		Assert.assertEquals(
			existingNews_BinhLuan.getNoiDung(), newNews_BinhLuan.getNoiDung());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNews_BinhLuan.getNgayBinhLuan()),
			Time.getShortTimestamp(newNews_BinhLuan.getNgayBinhLuan()));
		Assert.assertEquals(
			existingNews_BinhLuan.getStatus(), newNews_BinhLuan.getStatus());
		Assert.assertEquals(
			existingNews_BinhLuan.getOrders(), newNews_BinhLuan.getOrders());
		Assert.assertEquals(
			existingNews_BinhLuan.getDelete_status(),
			newNews_BinhLuan.getDelete_status());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		News_BinhLuan newNews_BinhLuan = addNews_BinhLuan();

		News_BinhLuan existingNews_BinhLuan = _persistence.findByPrimaryKey(
			newNews_BinhLuan.getPrimaryKey());

		Assert.assertEquals(existingNews_BinhLuan, newNews_BinhLuan);
	}

	@Test(expected = NoSuchNews_BinhLuanException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<News_BinhLuan> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_News_BinhLuan", "id", true, "companyId", true, "groupId", true,
			"newarticleId", true, "hoTen", true, "noiDung", true,
			"ngayBinhLuan", true, "status", true, "orders", true,
			"delete_status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		News_BinhLuan newNews_BinhLuan = addNews_BinhLuan();

		News_BinhLuan existingNews_BinhLuan = _persistence.fetchByPrimaryKey(
			newNews_BinhLuan.getPrimaryKey());

		Assert.assertEquals(existingNews_BinhLuan, newNews_BinhLuan);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_BinhLuan missingNews_BinhLuan = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNews_BinhLuan);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		News_BinhLuan newNews_BinhLuan1 = addNews_BinhLuan();
		News_BinhLuan newNews_BinhLuan2 = addNews_BinhLuan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_BinhLuan1.getPrimaryKey());
		primaryKeys.add(newNews_BinhLuan2.getPrimaryKey());

		Map<Serializable, News_BinhLuan> news_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, news_BinhLuans.size());
		Assert.assertEquals(
			newNews_BinhLuan1,
			news_BinhLuans.get(newNews_BinhLuan1.getPrimaryKey()));
		Assert.assertEquals(
			newNews_BinhLuan2,
			news_BinhLuans.get(newNews_BinhLuan2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, News_BinhLuan> news_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_BinhLuans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		News_BinhLuan newNews_BinhLuan = addNews_BinhLuan();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_BinhLuan.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, News_BinhLuan> news_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_BinhLuans.size());
		Assert.assertEquals(
			newNews_BinhLuan,
			news_BinhLuans.get(newNews_BinhLuan.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, News_BinhLuan> news_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_BinhLuans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		News_BinhLuan newNews_BinhLuan = addNews_BinhLuan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_BinhLuan.getPrimaryKey());

		Map<Serializable, News_BinhLuan> news_BinhLuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_BinhLuans.size());
		Assert.assertEquals(
			newNews_BinhLuan,
			news_BinhLuans.get(newNews_BinhLuan.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			News_BinhLuanLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<News_BinhLuan>() {

				@Override
				public void performAction(News_BinhLuan news_BinhLuan) {
					Assert.assertNotNull(news_BinhLuan);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		News_BinhLuan newNews_BinhLuan = addNews_BinhLuan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNews_BinhLuan.getId()));

		List<News_BinhLuan> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		News_BinhLuan existingNews_BinhLuan = result.get(0);

		Assert.assertEquals(existingNews_BinhLuan, newNews_BinhLuan);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<News_BinhLuan> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		News_BinhLuan newNews_BinhLuan = addNews_BinhLuan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNews_BinhLuan.getId();

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
			News_BinhLuan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected News_BinhLuan addNews_BinhLuan() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_BinhLuan news_BinhLuan = _persistence.create(pk);

		news_BinhLuan.setCompanyId(RandomTestUtil.nextLong());

		news_BinhLuan.setGroupId(RandomTestUtil.nextLong());

		news_BinhLuan.setNewarticleId(RandomTestUtil.nextLong());

		news_BinhLuan.setHoTen(RandomTestUtil.randomString());

		news_BinhLuan.setNoiDung(RandomTestUtil.randomString());

		news_BinhLuan.setNgayBinhLuan(RandomTestUtil.nextDate());

		news_BinhLuan.setStatus(RandomTestUtil.nextInt());

		news_BinhLuan.setOrders(RandomTestUtil.nextInt());

		news_BinhLuan.setDelete_status(RandomTestUtil.nextInt());

		_news_BinhLuans.add(_persistence.update(news_BinhLuan));

		return news_BinhLuan;
	}

	private List<News_BinhLuan> _news_BinhLuans =
		new ArrayList<News_BinhLuan>();
	private News_BinhLuanPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}