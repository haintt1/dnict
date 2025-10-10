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

import vn.dnict.vanbanphapquy.exception.NoSuchVanbanphapquyException;
import vn.dnict.vanbanphapquy.model.Vanbanphapquy;
import vn.dnict.vanbanphapquy.service.VanbanphapquyLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.persistence.VanbanphapquyPersistence;
import vn.dnict.vanbanphapquy.service.persistence.VanbanphapquyUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class VanbanphapquyPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.vanbanphapquy.service"));

	@Before
	public void setUp() {
		_persistence = VanbanphapquyUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Vanbanphapquy> iterator = _vanbanphapquys.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Vanbanphapquy vanbanphapquy = _persistence.create(pk);

		Assert.assertNotNull(vanbanphapquy);

		Assert.assertEquals(vanbanphapquy.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Vanbanphapquy newVanbanphapquy = addVanbanphapquy();

		_persistence.remove(newVanbanphapquy);

		Vanbanphapquy existingVanbanphapquy = _persistence.fetchByPrimaryKey(
			newVanbanphapquy.getPrimaryKey());

		Assert.assertNull(existingVanbanphapquy);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addVanbanphapquy();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Vanbanphapquy newVanbanphapquy = _persistence.create(pk);

		newVanbanphapquy.setCompanyId(RandomTestUtil.nextLong());

		newVanbanphapquy.setGroupId(RandomTestUtil.nextLong());

		newVanbanphapquy.setSohieu(RandomTestUtil.randomString());

		newVanbanphapquy.setTrichyeu(RandomTestUtil.randomString());

		newVanbanphapquy.setNoidung(RandomTestUtil.randomString());

		newVanbanphapquy.setNgay_banhanh(RandomTestUtil.nextDate());

		newVanbanphapquy.setNgay_hieuluc(RandomTestUtil.nextDate());

		newVanbanphapquy.setNgay_hethieuluc(RandomTestUtil.nextDate());

		newVanbanphapquy.setNgay_xuatban(RandomTestUtil.nextDate());

		newVanbanphapquy.setId_linhvuc(RandomTestUtil.nextLong());

		newVanbanphapquy.setId_loaivanban(RandomTestUtil.nextLong());

		newVanbanphapquy.setId_capbanhanh(RandomTestUtil.nextLong());

		newVanbanphapquy.setId_coquanbanhanh(RandomTestUtil.nextLong());

		newVanbanphapquy.setNguoiky(RandomTestUtil.randomString());

		newVanbanphapquy.setStatus(RandomTestUtil.nextInt());

		newVanbanphapquy.setType(RandomTestUtil.randomString());

		_vanbanphapquys.add(_persistence.update(newVanbanphapquy));

		Vanbanphapquy existingVanbanphapquy = _persistence.findByPrimaryKey(
			newVanbanphapquy.getPrimaryKey());

		Assert.assertEquals(
			existingVanbanphapquy.getId(), newVanbanphapquy.getId());
		Assert.assertEquals(
			existingVanbanphapquy.getCompanyId(),
			newVanbanphapquy.getCompanyId());
		Assert.assertEquals(
			existingVanbanphapquy.getGroupId(), newVanbanphapquy.getGroupId());
		Assert.assertEquals(
			existingVanbanphapquy.getSohieu(), newVanbanphapquy.getSohieu());
		Assert.assertEquals(
			existingVanbanphapquy.getTrichyeu(),
			newVanbanphapquy.getTrichyeu());
		Assert.assertEquals(
			existingVanbanphapquy.getNoidung(), newVanbanphapquy.getNoidung());
		Assert.assertEquals(
			Time.getShortTimestamp(existingVanbanphapquy.getNgay_banhanh()),
			Time.getShortTimestamp(newVanbanphapquy.getNgay_banhanh()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingVanbanphapquy.getNgay_hieuluc()),
			Time.getShortTimestamp(newVanbanphapquy.getNgay_hieuluc()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingVanbanphapquy.getNgay_hethieuluc()),
			Time.getShortTimestamp(newVanbanphapquy.getNgay_hethieuluc()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingVanbanphapquy.getNgay_xuatban()),
			Time.getShortTimestamp(newVanbanphapquy.getNgay_xuatban()));
		Assert.assertEquals(
			existingVanbanphapquy.getId_linhvuc(),
			newVanbanphapquy.getId_linhvuc());
		Assert.assertEquals(
			existingVanbanphapquy.getId_loaivanban(),
			newVanbanphapquy.getId_loaivanban());
		Assert.assertEquals(
			existingVanbanphapquy.getId_capbanhanh(),
			newVanbanphapquy.getId_capbanhanh());
		Assert.assertEquals(
			existingVanbanphapquy.getId_coquanbanhanh(),
			newVanbanphapquy.getId_coquanbanhanh());
		Assert.assertEquals(
			existingVanbanphapquy.getNguoiky(), newVanbanphapquy.getNguoiky());
		Assert.assertEquals(
			existingVanbanphapquy.getStatus(), newVanbanphapquy.getStatus());
		Assert.assertEquals(
			existingVanbanphapquy.getType(), newVanbanphapquy.getType());
	}

	@Test
	public void testCountByStatus() throws Exception {
		_persistence.countByStatus(RandomTestUtil.nextInt());

		_persistence.countByStatus(0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Vanbanphapquy newVanbanphapquy = addVanbanphapquy();

		Vanbanphapquy existingVanbanphapquy = _persistence.findByPrimaryKey(
			newVanbanphapquy.getPrimaryKey());

		Assert.assertEquals(existingVanbanphapquy, newVanbanphapquy);
	}

	@Test(expected = NoSuchVanbanphapquyException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Vanbanphapquy> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_vanbanphapquy", "id", true, "companyId", true, "groupId", true,
			"sohieu", true, "trichyeu", true, "noidung", true, "ngay_banhanh",
			true, "ngay_hieuluc", true, "ngay_hethieuluc", true, "ngay_xuatban",
			true, "id_linhvuc", true, "id_loaivanban", true, "id_capbanhanh",
			true, "id_coquanbanhanh", true, "nguoiky", true, "status", true,
			"type", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Vanbanphapquy newVanbanphapquy = addVanbanphapquy();

		Vanbanphapquy existingVanbanphapquy = _persistence.fetchByPrimaryKey(
			newVanbanphapquy.getPrimaryKey());

		Assert.assertEquals(existingVanbanphapquy, newVanbanphapquy);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Vanbanphapquy missingVanbanphapquy = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingVanbanphapquy);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Vanbanphapquy newVanbanphapquy1 = addVanbanphapquy();
		Vanbanphapquy newVanbanphapquy2 = addVanbanphapquy();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVanbanphapquy1.getPrimaryKey());
		primaryKeys.add(newVanbanphapquy2.getPrimaryKey());

		Map<Serializable, Vanbanphapquy> vanbanphapquys =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, vanbanphapquys.size());
		Assert.assertEquals(
			newVanbanphapquy1,
			vanbanphapquys.get(newVanbanphapquy1.getPrimaryKey()));
		Assert.assertEquals(
			newVanbanphapquy2,
			vanbanphapquys.get(newVanbanphapquy2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Vanbanphapquy> vanbanphapquys =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(vanbanphapquys.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Vanbanphapquy newVanbanphapquy = addVanbanphapquy();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVanbanphapquy.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Vanbanphapquy> vanbanphapquys =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, vanbanphapquys.size());
		Assert.assertEquals(
			newVanbanphapquy,
			vanbanphapquys.get(newVanbanphapquy.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Vanbanphapquy> vanbanphapquys =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(vanbanphapquys.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Vanbanphapquy newVanbanphapquy = addVanbanphapquy();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVanbanphapquy.getPrimaryKey());

		Map<Serializable, Vanbanphapquy> vanbanphapquys =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, vanbanphapquys.size());
		Assert.assertEquals(
			newVanbanphapquy,
			vanbanphapquys.get(newVanbanphapquy.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			VanbanphapquyLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Vanbanphapquy>() {

				@Override
				public void performAction(Vanbanphapquy vanbanphapquy) {
					Assert.assertNotNull(vanbanphapquy);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Vanbanphapquy newVanbanphapquy = addVanbanphapquy();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Vanbanphapquy.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newVanbanphapquy.getId()));

		List<Vanbanphapquy> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Vanbanphapquy existingVanbanphapquy = result.get(0);

		Assert.assertEquals(existingVanbanphapquy, newVanbanphapquy);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Vanbanphapquy.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Vanbanphapquy> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Vanbanphapquy newVanbanphapquy = addVanbanphapquy();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Vanbanphapquy.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newVanbanphapquy.getId();

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
			Vanbanphapquy.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Vanbanphapquy addVanbanphapquy() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Vanbanphapquy vanbanphapquy = _persistence.create(pk);

		vanbanphapquy.setCompanyId(RandomTestUtil.nextLong());

		vanbanphapquy.setGroupId(RandomTestUtil.nextLong());

		vanbanphapquy.setSohieu(RandomTestUtil.randomString());

		vanbanphapquy.setTrichyeu(RandomTestUtil.randomString());

		vanbanphapquy.setNoidung(RandomTestUtil.randomString());

		vanbanphapquy.setNgay_banhanh(RandomTestUtil.nextDate());

		vanbanphapquy.setNgay_hieuluc(RandomTestUtil.nextDate());

		vanbanphapquy.setNgay_hethieuluc(RandomTestUtil.nextDate());

		vanbanphapquy.setNgay_xuatban(RandomTestUtil.nextDate());

		vanbanphapquy.setId_linhvuc(RandomTestUtil.nextLong());

		vanbanphapquy.setId_loaivanban(RandomTestUtil.nextLong());

		vanbanphapquy.setId_capbanhanh(RandomTestUtil.nextLong());

		vanbanphapquy.setId_coquanbanhanh(RandomTestUtil.nextLong());

		vanbanphapquy.setNguoiky(RandomTestUtil.randomString());

		vanbanphapquy.setStatus(RandomTestUtil.nextInt());

		vanbanphapquy.setType(RandomTestUtil.randomString());

		_vanbanphapquys.add(_persistence.update(vanbanphapquy));

		return vanbanphapquy;
	}

	private List<Vanbanphapquy> _vanbanphapquys =
		new ArrayList<Vanbanphapquy>();
	private VanbanphapquyPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}