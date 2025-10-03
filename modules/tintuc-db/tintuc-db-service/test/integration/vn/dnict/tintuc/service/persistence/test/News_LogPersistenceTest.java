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

import vn.dnict.tintuc.exception.NoSuchNews_LogException;
import vn.dnict.tintuc.model.News_Log;
import vn.dnict.tintuc.service.News_LogLocalServiceUtil;
import vn.dnict.tintuc.service.persistence.News_LogPersistence;
import vn.dnict.tintuc.service.persistence.News_LogUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class News_LogPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.tintuc.service"));

	@Before
	public void setUp() {
		_persistence = News_LogUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<News_Log> iterator = _news_Logs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Log news_Log = _persistence.create(pk);

		Assert.assertNotNull(news_Log);

		Assert.assertEquals(news_Log.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		News_Log newNews_Log = addNews_Log();

		_persistence.remove(newNews_Log);

		News_Log existingNews_Log = _persistence.fetchByPrimaryKey(
			newNews_Log.getPrimaryKey());

		Assert.assertNull(existingNews_Log);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNews_Log();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Log newNews_Log = _persistence.create(pk);

		newNews_Log.setCompanyId(RandomTestUtil.nextLong());

		newNews_Log.setGroupId(RandomTestUtil.nextLong());

		newNews_Log.setTypeid(RandomTestUtil.nextLong());

		newNews_Log.setIdnewactivity(RandomTestUtil.nextLong());

		newNews_Log.setTitle(RandomTestUtil.randomString());

		newNews_Log.setInfo(RandomTestUtil.randomString());

		newNews_Log.setContent(RandomTestUtil.randomString());

		newNews_Log.setCreatedby(RandomTestUtil.nextLong());

		newNews_Log.setCreatedtime(RandomTestUtil.nextDate());

		newNews_Log.setModifiedby(RandomTestUtil.nextLong());

		newNews_Log.setModifiedtime(RandomTestUtil.nextDate());

		newNews_Log.setNguoinhanid(RandomTestUtil.nextLong());

		newNews_Log.setNguoixulyid(RandomTestUtil.nextLong());

		newNews_Log.setNgayxuly(RandomTestUtil.nextDate());

		newNews_Log.setStatus(RandomTestUtil.nextInt());

		newNews_Log.setLanguage(RandomTestUtil.randomString());

		newNews_Log.setVersion(RandomTestUtil.nextLong());

		newNews_Log.setUrlimagesmall(RandomTestUtil.randomString());

		newNews_Log.setLuotxem(RandomTestUtil.nextLong());

		newNews_Log.setIsnoibat(RandomTestUtil.nextLong());

		newNews_Log.setArticleid(RandomTestUtil.nextLong());

		newNews_Log.setNoidungxuly(RandomTestUtil.randomString());

		newNews_Log.setNgayxuatban(RandomTestUtil.nextDate());

		newNews_Log.setNgayketthuc(RandomTestUtil.nextDate());

		newNews_Log.setIshethang(RandomTestUtil.nextLong());

		newNews_Log.setNguontin(RandomTestUtil.nextLong());

		newNews_Log.setCongtacvien(RandomTestUtil.randomString());

		newNews_Log.setLoaitintuc(RandomTestUtil.nextInt());

		newNews_Log.setTukhoa(RandomTestUtil.randomString());

		newNews_Log.setSotinanh(RandomTestUtil.nextInt());

		newNews_Log.setIsformbinhluan(RandomTestUtil.nextInt());

		newNews_Log.setIsviewbinhluan(RandomTestUtil.nextInt());

		_news_Logs.add(_persistence.update(newNews_Log));

		News_Log existingNews_Log = _persistence.findByPrimaryKey(
			newNews_Log.getPrimaryKey());

		Assert.assertEquals(
			existingNews_Log.getCompanyId(), newNews_Log.getCompanyId());
		Assert.assertEquals(
			existingNews_Log.getGroupId(), newNews_Log.getGroupId());
		Assert.assertEquals(existingNews_Log.getId(), newNews_Log.getId());
		Assert.assertEquals(
			existingNews_Log.getTypeid(), newNews_Log.getTypeid());
		Assert.assertEquals(
			existingNews_Log.getIdnewactivity(),
			newNews_Log.getIdnewactivity());
		Assert.assertEquals(
			existingNews_Log.getTitle(), newNews_Log.getTitle());
		Assert.assertEquals(existingNews_Log.getInfo(), newNews_Log.getInfo());
		Assert.assertEquals(
			existingNews_Log.getContent(), newNews_Log.getContent());
		Assert.assertEquals(
			existingNews_Log.getCreatedby(), newNews_Log.getCreatedby());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNews_Log.getCreatedtime()),
			Time.getShortTimestamp(newNews_Log.getCreatedtime()));
		Assert.assertEquals(
			existingNews_Log.getModifiedby(), newNews_Log.getModifiedby());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNews_Log.getModifiedtime()),
			Time.getShortTimestamp(newNews_Log.getModifiedtime()));
		Assert.assertEquals(
			existingNews_Log.getNguoinhanid(), newNews_Log.getNguoinhanid());
		Assert.assertEquals(
			existingNews_Log.getNguoixulyid(), newNews_Log.getNguoixulyid());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNews_Log.getNgayxuly()),
			Time.getShortTimestamp(newNews_Log.getNgayxuly()));
		Assert.assertEquals(
			existingNews_Log.getStatus(), newNews_Log.getStatus());
		Assert.assertEquals(
			existingNews_Log.getLanguage(), newNews_Log.getLanguage());
		Assert.assertEquals(
			existingNews_Log.getVersion(), newNews_Log.getVersion());
		Assert.assertEquals(
			existingNews_Log.getUrlimagesmall(),
			newNews_Log.getUrlimagesmall());
		Assert.assertEquals(
			existingNews_Log.getLuotxem(), newNews_Log.getLuotxem());
		Assert.assertEquals(
			existingNews_Log.getIsnoibat(), newNews_Log.getIsnoibat());
		Assert.assertEquals(
			existingNews_Log.getArticleid(), newNews_Log.getArticleid());
		Assert.assertEquals(
			existingNews_Log.getNoidungxuly(), newNews_Log.getNoidungxuly());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNews_Log.getNgayxuatban()),
			Time.getShortTimestamp(newNews_Log.getNgayxuatban()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingNews_Log.getNgayketthuc()),
			Time.getShortTimestamp(newNews_Log.getNgayketthuc()));
		Assert.assertEquals(
			existingNews_Log.getIshethang(), newNews_Log.getIshethang());
		Assert.assertEquals(
			existingNews_Log.getNguontin(), newNews_Log.getNguontin());
		Assert.assertEquals(
			existingNews_Log.getCongtacvien(), newNews_Log.getCongtacvien());
		Assert.assertEquals(
			existingNews_Log.getLoaitintuc(), newNews_Log.getLoaitintuc());
		Assert.assertEquals(
			existingNews_Log.getTukhoa(), newNews_Log.getTukhoa());
		Assert.assertEquals(
			existingNews_Log.getSotinanh(), newNews_Log.getSotinanh());
		Assert.assertEquals(
			existingNews_Log.getIsformbinhluan(),
			newNews_Log.getIsformbinhluan());
		Assert.assertEquals(
			existingNews_Log.getIsviewbinhluan(),
			newNews_Log.getIsviewbinhluan());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		News_Log newNews_Log = addNews_Log();

		News_Log existingNews_Log = _persistence.findByPrimaryKey(
			newNews_Log.getPrimaryKey());

		Assert.assertEquals(existingNews_Log, newNews_Log);
	}

	@Test(expected = NoSuchNews_LogException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<News_Log> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_News_Log", "companyId", true, "groupId", true, "id", true,
			"typeid", true, "idnewactivity", true, "info", true, "createdby",
			true, "createdtime", true, "modifiedby", true, "modifiedtime", true,
			"nguoinhanid", true, "nguoixulyid", true, "ngayxuly", true,
			"status", true, "language", true, "version", true, "urlimagesmall",
			true, "luotxem", true, "isnoibat", true, "articleid", true,
			"ngayxuatban", true, "ngayketthuc", true, "ishethang", true,
			"nguontin", true, "congtacvien", true, "loaitintuc", true, "tukhoa",
			true, "sotinanh", true, "isformbinhluan", true, "isviewbinhluan",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		News_Log newNews_Log = addNews_Log();

		News_Log existingNews_Log = _persistence.fetchByPrimaryKey(
			newNews_Log.getPrimaryKey());

		Assert.assertEquals(existingNews_Log, newNews_Log);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Log missingNews_Log = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNews_Log);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		News_Log newNews_Log1 = addNews_Log();
		News_Log newNews_Log2 = addNews_Log();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Log1.getPrimaryKey());
		primaryKeys.add(newNews_Log2.getPrimaryKey());

		Map<Serializable, News_Log> news_Logs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, news_Logs.size());
		Assert.assertEquals(
			newNews_Log1, news_Logs.get(newNews_Log1.getPrimaryKey()));
		Assert.assertEquals(
			newNews_Log2, news_Logs.get(newNews_Log2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, News_Log> news_Logs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(news_Logs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		News_Log newNews_Log = addNews_Log();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Log.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, News_Log> news_Logs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, news_Logs.size());
		Assert.assertEquals(
			newNews_Log, news_Logs.get(newNews_Log.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, News_Log> news_Logs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(news_Logs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		News_Log newNews_Log = addNews_Log();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Log.getPrimaryKey());

		Map<Serializable, News_Log> news_Logs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, news_Logs.size());
		Assert.assertEquals(
			newNews_Log, news_Logs.get(newNews_Log.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			News_LogLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<News_Log>() {

				@Override
				public void performAction(News_Log news_Log) {
					Assert.assertNotNull(news_Log);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		News_Log newNews_Log = addNews_Log();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Log.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newNews_Log.getId()));

		List<News_Log> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		News_Log existingNews_Log = result.get(0);

		Assert.assertEquals(existingNews_Log, newNews_Log);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Log.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<News_Log> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		News_Log newNews_Log = addNews_Log();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Log.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNews_Log.getId();

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
			News_Log.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected News_Log addNews_Log() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Log news_Log = _persistence.create(pk);

		news_Log.setCompanyId(RandomTestUtil.nextLong());

		news_Log.setGroupId(RandomTestUtil.nextLong());

		news_Log.setTypeid(RandomTestUtil.nextLong());

		news_Log.setIdnewactivity(RandomTestUtil.nextLong());

		news_Log.setTitle(RandomTestUtil.randomString());

		news_Log.setInfo(RandomTestUtil.randomString());

		news_Log.setContent(RandomTestUtil.randomString());

		news_Log.setCreatedby(RandomTestUtil.nextLong());

		news_Log.setCreatedtime(RandomTestUtil.nextDate());

		news_Log.setModifiedby(RandomTestUtil.nextLong());

		news_Log.setModifiedtime(RandomTestUtil.nextDate());

		news_Log.setNguoinhanid(RandomTestUtil.nextLong());

		news_Log.setNguoixulyid(RandomTestUtil.nextLong());

		news_Log.setNgayxuly(RandomTestUtil.nextDate());

		news_Log.setStatus(RandomTestUtil.nextInt());

		news_Log.setLanguage(RandomTestUtil.randomString());

		news_Log.setVersion(RandomTestUtil.nextLong());

		news_Log.setUrlimagesmall(RandomTestUtil.randomString());

		news_Log.setLuotxem(RandomTestUtil.nextLong());

		news_Log.setIsnoibat(RandomTestUtil.nextLong());

		news_Log.setArticleid(RandomTestUtil.nextLong());

		news_Log.setNoidungxuly(RandomTestUtil.randomString());

		news_Log.setNgayxuatban(RandomTestUtil.nextDate());

		news_Log.setNgayketthuc(RandomTestUtil.nextDate());

		news_Log.setIshethang(RandomTestUtil.nextLong());

		news_Log.setNguontin(RandomTestUtil.nextLong());

		news_Log.setCongtacvien(RandomTestUtil.randomString());

		news_Log.setLoaitintuc(RandomTestUtil.nextInt());

		news_Log.setTukhoa(RandomTestUtil.randomString());

		news_Log.setSotinanh(RandomTestUtil.nextInt());

		news_Log.setIsformbinhluan(RandomTestUtil.nextInt());

		news_Log.setIsviewbinhluan(RandomTestUtil.nextInt());

		_news_Logs.add(_persistence.update(news_Log));

		return news_Log;
	}

	private List<News_Log> _news_Logs = new ArrayList<News_Log>();
	private News_LogPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}