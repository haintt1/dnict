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

import vn.dnict.tintuc.exception.NoSuchNews_ArticleException;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.persistence.News_ArticlePersistence;
import vn.dnict.tintuc.service.persistence.News_ArticleUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class News_ArticlePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.tintuc.service"));

	@Before
	public void setUp() {
		_persistence = News_ArticleUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<News_Article> iterator = _news_Articles.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Article news_Article = _persistence.create(pk);

		Assert.assertNotNull(news_Article);

		Assert.assertEquals(news_Article.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		News_Article newNews_Article = addNews_Article();

		_persistence.remove(newNews_Article);

		News_Article existingNews_Article = _persistence.fetchByPrimaryKey(
			newNews_Article.getPrimaryKey());

		Assert.assertNull(existingNews_Article);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNews_Article();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Article newNews_Article = _persistence.create(pk);

		newNews_Article.setCompanyId(RandomTestUtil.nextLong());

		newNews_Article.setGroupId(RandomTestUtil.nextLong());

		newNews_Article.setTypeid(RandomTestUtil.nextLong());

		newNews_Article.setTitle(RandomTestUtil.randomString());

		newNews_Article.setInfo(RandomTestUtil.randomString());

		newNews_Article.setContent(RandomTestUtil.randomString());

		newNews_Article.setCreatedby(RandomTestUtil.nextLong());

		newNews_Article.setCreatedtime(RandomTestUtil.nextDate());

		newNews_Article.setModifiedby(RandomTestUtil.nextLong());

		newNews_Article.setModifiedtime(RandomTestUtil.nextDate());

		newNews_Article.setNguoinhanid(RandomTestUtil.nextLong());

		newNews_Article.setNguoixulyid(RandomTestUtil.nextLong());

		newNews_Article.setNgayxuly(RandomTestUtil.nextDate());

		newNews_Article.setStatus(RandomTestUtil.nextInt());

		newNews_Article.setLanguage(RandomTestUtil.randomString());

		newNews_Article.setVersion(RandomTestUtil.nextLong());

		newNews_Article.setDelete_status(RandomTestUtil.nextInt());

		newNews_Article.setUrlimagesmall(RandomTestUtil.randomString());

		newNews_Article.setLuotxem(RandomTestUtil.nextLong());

		newNews_Article.setIsnoibat(RandomTestUtil.nextLong());

		newNews_Article.setNgayxuatban(RandomTestUtil.nextDate());

		newNews_Article.setNgayketthuc(RandomTestUtil.nextDate());

		newNews_Article.setIshethang(RandomTestUtil.nextLong());

		newNews_Article.setNguontin(RandomTestUtil.nextLong());

		newNews_Article.setCongtacvien(RandomTestUtil.randomString());

		newNews_Article.setLoaitintuc(RandomTestUtil.nextInt());

		newNews_Article.setTukhoa(RandomTestUtil.randomString());

		newNews_Article.setSotinanh(RandomTestUtil.nextInt());

		newNews_Article.setIsformbinhluan(RandomTestUtil.nextInt());

		newNews_Article.setIsviewbinhluan(RandomTestUtil.nextInt());

		_news_Articles.add(_persistence.update(newNews_Article));

		News_Article existingNews_Article = _persistence.findByPrimaryKey(
			newNews_Article.getPrimaryKey());

		Assert.assertEquals(
			existingNews_Article.getId(), newNews_Article.getId());
		Assert.assertEquals(
			existingNews_Article.getCompanyId(),
			newNews_Article.getCompanyId());
		Assert.assertEquals(
			existingNews_Article.getGroupId(), newNews_Article.getGroupId());
		Assert.assertEquals(
			existingNews_Article.getTypeid(), newNews_Article.getTypeid());
		Assert.assertEquals(
			existingNews_Article.getTitle(), newNews_Article.getTitle());
		Assert.assertEquals(
			existingNews_Article.getInfo(), newNews_Article.getInfo());
		Assert.assertEquals(
			existingNews_Article.getContent(), newNews_Article.getContent());
		Assert.assertEquals(
			existingNews_Article.getCreatedby(),
			newNews_Article.getCreatedby());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNews_Article.getCreatedtime()),
			Time.getShortTimestamp(newNews_Article.getCreatedtime()));
		Assert.assertEquals(
			existingNews_Article.getModifiedby(),
			newNews_Article.getModifiedby());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNews_Article.getModifiedtime()),
			Time.getShortTimestamp(newNews_Article.getModifiedtime()));
		Assert.assertEquals(
			existingNews_Article.getNguoinhanid(),
			newNews_Article.getNguoinhanid());
		Assert.assertEquals(
			existingNews_Article.getNguoixulyid(),
			newNews_Article.getNguoixulyid());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNews_Article.getNgayxuly()),
			Time.getShortTimestamp(newNews_Article.getNgayxuly()));
		Assert.assertEquals(
			existingNews_Article.getStatus(), newNews_Article.getStatus());
		Assert.assertEquals(
			existingNews_Article.getLanguage(), newNews_Article.getLanguage());
		Assert.assertEquals(
			existingNews_Article.getVersion(), newNews_Article.getVersion());
		Assert.assertEquals(
			existingNews_Article.getDelete_status(),
			newNews_Article.getDelete_status());
		Assert.assertEquals(
			existingNews_Article.getUrlimagesmall(),
			newNews_Article.getUrlimagesmall());
		Assert.assertEquals(
			existingNews_Article.getLuotxem(), newNews_Article.getLuotxem());
		Assert.assertEquals(
			existingNews_Article.getIsnoibat(), newNews_Article.getIsnoibat());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNews_Article.getNgayxuatban()),
			Time.getShortTimestamp(newNews_Article.getNgayxuatban()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingNews_Article.getNgayketthuc()),
			Time.getShortTimestamp(newNews_Article.getNgayketthuc()));
		Assert.assertEquals(
			existingNews_Article.getIshethang(),
			newNews_Article.getIshethang());
		Assert.assertEquals(
			existingNews_Article.getNguontin(), newNews_Article.getNguontin());
		Assert.assertEquals(
			existingNews_Article.getCongtacvien(),
			newNews_Article.getCongtacvien());
		Assert.assertEquals(
			existingNews_Article.getLoaitintuc(),
			newNews_Article.getLoaitintuc());
		Assert.assertEquals(
			existingNews_Article.getTukhoa(), newNews_Article.getTukhoa());
		Assert.assertEquals(
			existingNews_Article.getSotinanh(), newNews_Article.getSotinanh());
		Assert.assertEquals(
			existingNews_Article.getIsformbinhluan(),
			newNews_Article.getIsformbinhluan());
		Assert.assertEquals(
			existingNews_Article.getIsviewbinhluan(),
			newNews_Article.getIsviewbinhluan());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		News_Article newNews_Article = addNews_Article();

		News_Article existingNews_Article = _persistence.findByPrimaryKey(
			newNews_Article.getPrimaryKey());

		Assert.assertEquals(existingNews_Article, newNews_Article);
	}

	@Test(expected = NoSuchNews_ArticleException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<News_Article> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_News_Article", "id", true, "companyId", true, "groupId", true,
			"typeid", true, "info", true, "createdby", true, "createdtime",
			true, "modifiedby", true, "modifiedtime", true, "nguoinhanid", true,
			"nguoixulyid", true, "ngayxuly", true, "status", true, "language",
			true, "version", true, "delete_status", true, "urlimagesmall", true,
			"luotxem", true, "isnoibat", true, "ngayxuatban", true,
			"ngayketthuc", true, "ishethang", true, "nguontin", true,
			"congtacvien", true, "loaitintuc", true, "tukhoa", true, "sotinanh",
			true, "isformbinhluan", true, "isviewbinhluan", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		News_Article newNews_Article = addNews_Article();

		News_Article existingNews_Article = _persistence.fetchByPrimaryKey(
			newNews_Article.getPrimaryKey());

		Assert.assertEquals(existingNews_Article, newNews_Article);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Article missingNews_Article = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNews_Article);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		News_Article newNews_Article1 = addNews_Article();
		News_Article newNews_Article2 = addNews_Article();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Article1.getPrimaryKey());
		primaryKeys.add(newNews_Article2.getPrimaryKey());

		Map<Serializable, News_Article> news_Articles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, news_Articles.size());
		Assert.assertEquals(
			newNews_Article1,
			news_Articles.get(newNews_Article1.getPrimaryKey()));
		Assert.assertEquals(
			newNews_Article2,
			news_Articles.get(newNews_Article2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, News_Article> news_Articles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Articles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		News_Article newNews_Article = addNews_Article();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Article.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, News_Article> news_Articles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Articles.size());
		Assert.assertEquals(
			newNews_Article,
			news_Articles.get(newNews_Article.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, News_Article> news_Articles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(news_Articles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		News_Article newNews_Article = addNews_Article();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNews_Article.getPrimaryKey());

		Map<Serializable, News_Article> news_Articles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, news_Articles.size());
		Assert.assertEquals(
			newNews_Article,
			news_Articles.get(newNews_Article.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			News_ArticleLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<News_Article>() {

				@Override
				public void performAction(News_Article news_Article) {
					Assert.assertNotNull(news_Article);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		News_Article newNews_Article = addNews_Article();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Article.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNews_Article.getId()));

		List<News_Article> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		News_Article existingNews_Article = result.get(0);

		Assert.assertEquals(existingNews_Article, newNews_Article);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Article.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<News_Article> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		News_Article newNews_Article = addNews_Article();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			News_Article.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNews_Article.getId();

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
			News_Article.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected News_Article addNews_Article() throws Exception {
		long pk = RandomTestUtil.nextLong();

		News_Article news_Article = _persistence.create(pk);

		news_Article.setCompanyId(RandomTestUtil.nextLong());

		news_Article.setGroupId(RandomTestUtil.nextLong());

		news_Article.setTypeid(RandomTestUtil.nextLong());

		news_Article.setTitle(RandomTestUtil.randomString());

		news_Article.setInfo(RandomTestUtil.randomString());

		news_Article.setContent(RandomTestUtil.randomString());

		news_Article.setCreatedby(RandomTestUtil.nextLong());

		news_Article.setCreatedtime(RandomTestUtil.nextDate());

		news_Article.setModifiedby(RandomTestUtil.nextLong());

		news_Article.setModifiedtime(RandomTestUtil.nextDate());

		news_Article.setNguoinhanid(RandomTestUtil.nextLong());

		news_Article.setNguoixulyid(RandomTestUtil.nextLong());

		news_Article.setNgayxuly(RandomTestUtil.nextDate());

		news_Article.setStatus(RandomTestUtil.nextInt());

		news_Article.setLanguage(RandomTestUtil.randomString());

		news_Article.setVersion(RandomTestUtil.nextLong());

		news_Article.setDelete_status(RandomTestUtil.nextInt());

		news_Article.setUrlimagesmall(RandomTestUtil.randomString());

		news_Article.setLuotxem(RandomTestUtil.nextLong());

		news_Article.setIsnoibat(RandomTestUtil.nextLong());

		news_Article.setNgayxuatban(RandomTestUtil.nextDate());

		news_Article.setNgayketthuc(RandomTestUtil.nextDate());

		news_Article.setIshethang(RandomTestUtil.nextLong());

		news_Article.setNguontin(RandomTestUtil.nextLong());

		news_Article.setCongtacvien(RandomTestUtil.randomString());

		news_Article.setLoaitintuc(RandomTestUtil.nextInt());

		news_Article.setTukhoa(RandomTestUtil.randomString());

		news_Article.setSotinanh(RandomTestUtil.nextInt());

		news_Article.setIsformbinhluan(RandomTestUtil.nextInt());

		news_Article.setIsviewbinhluan(RandomTestUtil.nextInt());

		_news_Articles.add(_persistence.update(news_Article));

		return news_Article;
	}

	private List<News_Article> _news_Articles = new ArrayList<News_Article>();
	private News_ArticlePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}