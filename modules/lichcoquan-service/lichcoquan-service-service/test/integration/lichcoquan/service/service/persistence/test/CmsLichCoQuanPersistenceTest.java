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

package lichcoquan.service.service.persistence.test;

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

import lichcoquan.service.exception.NoSuchCmsLichCoQuanException;
import lichcoquan.service.model.CmsLichCoQuan;
import lichcoquan.service.service.CmsLichCoQuanLocalServiceUtil;
import lichcoquan.service.service.persistence.CmsLichCoQuanPersistence;
import lichcoquan.service.service.persistence.CmsLichCoQuanUtil;

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
public class CmsLichCoQuanPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "lichcoquan.service.service"));

	@Before
	public void setUp() {
		_persistence = CmsLichCoQuanUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CmsLichCoQuan> iterator = _cmsLichCoQuans.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CmsLichCoQuan cmsLichCoQuan = _persistence.create(pk);

		Assert.assertNotNull(cmsLichCoQuan);

		Assert.assertEquals(cmsLichCoQuan.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CmsLichCoQuan newCmsLichCoQuan = addCmsLichCoQuan();

		_persistence.remove(newCmsLichCoQuan);

		CmsLichCoQuan existingCmsLichCoQuan = _persistence.fetchByPrimaryKey(
			newCmsLichCoQuan.getPrimaryKey());

		Assert.assertNull(existingCmsLichCoQuan);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCmsLichCoQuan();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CmsLichCoQuan newCmsLichCoQuan = _persistence.create(pk);

		newCmsLichCoQuan.setCompanyId(RandomTestUtil.nextLong());

		newCmsLichCoQuan.setUserId(RandomTestUtil.nextLong());

		newCmsLichCoQuan.setContent(RandomTestUtil.randomString());

		newCmsLichCoQuan.setCreateDate(RandomTestUtil.nextDate());

		newCmsLichCoQuan.setTungay(RandomTestUtil.nextDate());

		newCmsLichCoQuan.setDenngay(RandomTestUtil.nextDate());

		newCmsLichCoQuan.setTrangthai(RandomTestUtil.nextInt());

		newCmsLichCoQuan.setBanhanh(RandomTestUtil.nextInt());

		newCmsLichCoQuan.setTuan(RandomTestUtil.nextInt());

		newCmsLichCoQuan.setNam(RandomTestUtil.nextInt());

		_cmsLichCoQuans.add(_persistence.update(newCmsLichCoQuan));

		CmsLichCoQuan existingCmsLichCoQuan = _persistence.findByPrimaryKey(
			newCmsLichCoQuan.getPrimaryKey());

		Assert.assertEquals(
			existingCmsLichCoQuan.getLichCongtacId(),
			newCmsLichCoQuan.getLichCongtacId());
		Assert.assertEquals(
			existingCmsLichCoQuan.getCompanyId(),
			newCmsLichCoQuan.getCompanyId());
		Assert.assertEquals(
			existingCmsLichCoQuan.getUserId(), newCmsLichCoQuan.getUserId());
		Assert.assertEquals(
			existingCmsLichCoQuan.getContent(), newCmsLichCoQuan.getContent());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCmsLichCoQuan.getCreateDate()),
			Time.getShortTimestamp(newCmsLichCoQuan.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCmsLichCoQuan.getTungay()),
			Time.getShortTimestamp(newCmsLichCoQuan.getTungay()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCmsLichCoQuan.getDenngay()),
			Time.getShortTimestamp(newCmsLichCoQuan.getDenngay()));
		Assert.assertEquals(
			existingCmsLichCoQuan.getTrangthai(),
			newCmsLichCoQuan.getTrangthai());
		Assert.assertEquals(
			existingCmsLichCoQuan.getBanhanh(), newCmsLichCoQuan.getBanhanh());
		Assert.assertEquals(
			existingCmsLichCoQuan.getTuan(), newCmsLichCoQuan.getTuan());
		Assert.assertEquals(
			existingCmsLichCoQuan.getNam(), newCmsLichCoQuan.getNam());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CmsLichCoQuan newCmsLichCoQuan = addCmsLichCoQuan();

		CmsLichCoQuan existingCmsLichCoQuan = _persistence.findByPrimaryKey(
			newCmsLichCoQuan.getPrimaryKey());

		Assert.assertEquals(existingCmsLichCoQuan, newCmsLichCoQuan);
	}

	@Test(expected = NoSuchCmsLichCoQuanException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CmsLichCoQuan> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cms_lichcoquan", "lichCongtacId", true, "companyId", true,
			"userId", true, "content", true, "createDate", true, "tungay", true,
			"denngay", true, "trangthai", true, "banhanh", true, "tuan", true,
			"nam", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CmsLichCoQuan newCmsLichCoQuan = addCmsLichCoQuan();

		CmsLichCoQuan existingCmsLichCoQuan = _persistence.fetchByPrimaryKey(
			newCmsLichCoQuan.getPrimaryKey());

		Assert.assertEquals(existingCmsLichCoQuan, newCmsLichCoQuan);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CmsLichCoQuan missingCmsLichCoQuan = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCmsLichCoQuan);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CmsLichCoQuan newCmsLichCoQuan1 = addCmsLichCoQuan();
		CmsLichCoQuan newCmsLichCoQuan2 = addCmsLichCoQuan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCmsLichCoQuan1.getPrimaryKey());
		primaryKeys.add(newCmsLichCoQuan2.getPrimaryKey());

		Map<Serializable, CmsLichCoQuan> cmsLichCoQuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, cmsLichCoQuans.size());
		Assert.assertEquals(
			newCmsLichCoQuan1,
			cmsLichCoQuans.get(newCmsLichCoQuan1.getPrimaryKey()));
		Assert.assertEquals(
			newCmsLichCoQuan2,
			cmsLichCoQuans.get(newCmsLichCoQuan2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CmsLichCoQuan> cmsLichCoQuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cmsLichCoQuans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CmsLichCoQuan newCmsLichCoQuan = addCmsLichCoQuan();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCmsLichCoQuan.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CmsLichCoQuan> cmsLichCoQuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cmsLichCoQuans.size());
		Assert.assertEquals(
			newCmsLichCoQuan,
			cmsLichCoQuans.get(newCmsLichCoQuan.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CmsLichCoQuan> cmsLichCoQuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cmsLichCoQuans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CmsLichCoQuan newCmsLichCoQuan = addCmsLichCoQuan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCmsLichCoQuan.getPrimaryKey());

		Map<Serializable, CmsLichCoQuan> cmsLichCoQuans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cmsLichCoQuans.size());
		Assert.assertEquals(
			newCmsLichCoQuan,
			cmsLichCoQuans.get(newCmsLichCoQuan.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CmsLichCoQuanLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CmsLichCoQuan>() {

				@Override
				public void performAction(CmsLichCoQuan cmsLichCoQuan) {
					Assert.assertNotNull(cmsLichCoQuan);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CmsLichCoQuan newCmsLichCoQuan = addCmsLichCoQuan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CmsLichCoQuan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"lichCongtacId", newCmsLichCoQuan.getLichCongtacId()));

		List<CmsLichCoQuan> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CmsLichCoQuan existingCmsLichCoQuan = result.get(0);

		Assert.assertEquals(existingCmsLichCoQuan, newCmsLichCoQuan);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CmsLichCoQuan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"lichCongtacId", RandomTestUtil.nextLong()));

		List<CmsLichCoQuan> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CmsLichCoQuan newCmsLichCoQuan = addCmsLichCoQuan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CmsLichCoQuan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("lichCongtacId"));

		Object newLichCongtacId = newCmsLichCoQuan.getLichCongtacId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"lichCongtacId", new Object[] {newLichCongtacId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingLichCongtacId = result.get(0);

		Assert.assertEquals(existingLichCongtacId, newLichCongtacId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CmsLichCoQuan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("lichCongtacId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"lichCongtacId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected CmsLichCoQuan addCmsLichCoQuan() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CmsLichCoQuan cmsLichCoQuan = _persistence.create(pk);

		cmsLichCoQuan.setCompanyId(RandomTestUtil.nextLong());

		cmsLichCoQuan.setUserId(RandomTestUtil.nextLong());

		cmsLichCoQuan.setContent(RandomTestUtil.randomString());

		cmsLichCoQuan.setCreateDate(RandomTestUtil.nextDate());

		cmsLichCoQuan.setTungay(RandomTestUtil.nextDate());

		cmsLichCoQuan.setDenngay(RandomTestUtil.nextDate());

		cmsLichCoQuan.setTrangthai(RandomTestUtil.nextInt());

		cmsLichCoQuan.setBanhanh(RandomTestUtil.nextInt());

		cmsLichCoQuan.setTuan(RandomTestUtil.nextInt());

		cmsLichCoQuan.setNam(RandomTestUtil.nextInt());

		_cmsLichCoQuans.add(_persistence.update(cmsLichCoQuan));

		return cmsLichCoQuan;
	}

	private List<CmsLichCoQuan> _cmsLichCoQuans =
		new ArrayList<CmsLichCoQuan>();
	private CmsLichCoQuanPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}