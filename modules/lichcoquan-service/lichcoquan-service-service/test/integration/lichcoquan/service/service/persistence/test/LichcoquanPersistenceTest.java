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

import lichcoquan.service.exception.NoSuchLichcoquanException;
import lichcoquan.service.model.Lichcoquan;
import lichcoquan.service.service.LichcoquanLocalServiceUtil;
import lichcoquan.service.service.persistence.LichcoquanPersistence;
import lichcoquan.service.service.persistence.LichcoquanUtil;

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
public class LichcoquanPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "lichcoquan.service.service"));

	@Before
	public void setUp() {
		_persistence = LichcoquanUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Lichcoquan> iterator = _lichcoquans.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lichcoquan lichcoquan = _persistence.create(pk);

		Assert.assertNotNull(lichcoquan);

		Assert.assertEquals(lichcoquan.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Lichcoquan newLichcoquan = addLichcoquan();

		_persistence.remove(newLichcoquan);

		Lichcoquan existingLichcoquan = _persistence.fetchByPrimaryKey(
			newLichcoquan.getPrimaryKey());

		Assert.assertNull(existingLichcoquan);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addLichcoquan();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lichcoquan newLichcoquan = _persistence.create(pk);

		newLichcoquan.setCompanyId(RandomTestUtil.nextLong());

		newLichcoquan.setUserId(RandomTestUtil.nextLong());

		newLichcoquan.setContent(RandomTestUtil.randomString());

		newLichcoquan.setCreateDate(RandomTestUtil.nextDate());

		newLichcoquan.setTungay(RandomTestUtil.nextDate());

		newLichcoquan.setDenngay(RandomTestUtil.nextDate());

		newLichcoquan.setTrangthai(RandomTestUtil.nextInt());

		newLichcoquan.setBanhanh(RandomTestUtil.nextInt());

		newLichcoquan.setTuan(RandomTestUtil.nextInt());

		newLichcoquan.setNam(RandomTestUtil.nextInt());

		_lichcoquans.add(_persistence.update(newLichcoquan));

		Lichcoquan existingLichcoquan = _persistence.findByPrimaryKey(
			newLichcoquan.getPrimaryKey());

		Assert.assertEquals(
			existingLichcoquan.getLichCongtacId(),
			newLichcoquan.getLichCongtacId());
		Assert.assertEquals(
			existingLichcoquan.getCompanyId(), newLichcoquan.getCompanyId());
		Assert.assertEquals(
			existingLichcoquan.getUserId(), newLichcoquan.getUserId());
		Assert.assertEquals(
			existingLichcoquan.getContent(), newLichcoquan.getContent());
		Assert.assertEquals(
			Time.getShortTimestamp(existingLichcoquan.getCreateDate()),
			Time.getShortTimestamp(newLichcoquan.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingLichcoquan.getTungay()),
			Time.getShortTimestamp(newLichcoquan.getTungay()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingLichcoquan.getDenngay()),
			Time.getShortTimestamp(newLichcoquan.getDenngay()));
		Assert.assertEquals(
			existingLichcoquan.getTrangthai(), newLichcoquan.getTrangthai());
		Assert.assertEquals(
			existingLichcoquan.getBanhanh(), newLichcoquan.getBanhanh());
		Assert.assertEquals(
			existingLichcoquan.getTuan(), newLichcoquan.getTuan());
		Assert.assertEquals(
			existingLichcoquan.getNam(), newLichcoquan.getNam());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Lichcoquan newLichcoquan = addLichcoquan();

		Lichcoquan existingLichcoquan = _persistence.findByPrimaryKey(
			newLichcoquan.getPrimaryKey());

		Assert.assertEquals(existingLichcoquan, newLichcoquan);
	}

	@Test(expected = NoSuchLichcoquanException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Lichcoquan> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"lcq_lichcoquan", "lichCongtacId", true, "companyId", true,
			"userId", true, "content", true, "createDate", true, "tungay", true,
			"denngay", true, "trangthai", true, "banhanh", true, "tuan", true,
			"nam", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Lichcoquan newLichcoquan = addLichcoquan();

		Lichcoquan existingLichcoquan = _persistence.fetchByPrimaryKey(
			newLichcoquan.getPrimaryKey());

		Assert.assertEquals(existingLichcoquan, newLichcoquan);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lichcoquan missingLichcoquan = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingLichcoquan);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Lichcoquan newLichcoquan1 = addLichcoquan();
		Lichcoquan newLichcoquan2 = addLichcoquan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLichcoquan1.getPrimaryKey());
		primaryKeys.add(newLichcoquan2.getPrimaryKey());

		Map<Serializable, Lichcoquan> lichcoquans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, lichcoquans.size());
		Assert.assertEquals(
			newLichcoquan1, lichcoquans.get(newLichcoquan1.getPrimaryKey()));
		Assert.assertEquals(
			newLichcoquan2, lichcoquans.get(newLichcoquan2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Lichcoquan> lichcoquans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(lichcoquans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Lichcoquan newLichcoquan = addLichcoquan();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLichcoquan.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Lichcoquan> lichcoquans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, lichcoquans.size());
		Assert.assertEquals(
			newLichcoquan, lichcoquans.get(newLichcoquan.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Lichcoquan> lichcoquans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(lichcoquans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Lichcoquan newLichcoquan = addLichcoquan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLichcoquan.getPrimaryKey());

		Map<Serializable, Lichcoquan> lichcoquans =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, lichcoquans.size());
		Assert.assertEquals(
			newLichcoquan, lichcoquans.get(newLichcoquan.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			LichcoquanLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Lichcoquan>() {

				@Override
				public void performAction(Lichcoquan lichcoquan) {
					Assert.assertNotNull(lichcoquan);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Lichcoquan newLichcoquan = addLichcoquan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Lichcoquan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"lichCongtacId", newLichcoquan.getLichCongtacId()));

		List<Lichcoquan> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Lichcoquan existingLichcoquan = result.get(0);

		Assert.assertEquals(existingLichcoquan, newLichcoquan);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Lichcoquan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"lichCongtacId", RandomTestUtil.nextLong()));

		List<Lichcoquan> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Lichcoquan newLichcoquan = addLichcoquan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Lichcoquan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("lichCongtacId"));

		Object newLichCongtacId = newLichcoquan.getLichCongtacId();

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
			Lichcoquan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("lichCongtacId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"lichCongtacId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Lichcoquan addLichcoquan() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Lichcoquan lichcoquan = _persistence.create(pk);

		lichcoquan.setCompanyId(RandomTestUtil.nextLong());

		lichcoquan.setUserId(RandomTestUtil.nextLong());

		lichcoquan.setContent(RandomTestUtil.randomString());

		lichcoquan.setCreateDate(RandomTestUtil.nextDate());

		lichcoquan.setTungay(RandomTestUtil.nextDate());

		lichcoquan.setDenngay(RandomTestUtil.nextDate());

		lichcoquan.setTrangthai(RandomTestUtil.nextInt());

		lichcoquan.setBanhanh(RandomTestUtil.nextInt());

		lichcoquan.setTuan(RandomTestUtil.nextInt());

		lichcoquan.setNam(RandomTestUtil.nextInt());

		_lichcoquans.add(_persistence.update(lichcoquan));

		return lichcoquan;
	}

	private List<Lichcoquan> _lichcoquans = new ArrayList<Lichcoquan>();
	private LichcoquanPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}