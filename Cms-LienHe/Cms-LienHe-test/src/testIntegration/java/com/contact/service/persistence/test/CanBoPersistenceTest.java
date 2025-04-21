/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.persistence.test;

import com.contact.exception.NoSuchCanBoException;
import com.contact.model.CanBo;
import com.contact.service.CanBoLocalServiceUtil;
import com.contact.service.persistence.CanBoPersistence;
import com.contact.service.persistence.CanBoUtil;

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

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CanBoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.contact.service"));

	@Before
	public void setUp() {
		_persistence = CanBoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CanBo> iterator = _canBos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CanBo canBo = _persistence.create(pk);

		Assert.assertNotNull(canBo);

		Assert.assertEquals(canBo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CanBo newCanBo = addCanBo();

		_persistence.remove(newCanBo);

		CanBo existingCanBo = _persistence.fetchByPrimaryKey(
			newCanBo.getPrimaryKey());

		Assert.assertNull(existingCanBo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCanBo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CanBo newCanBo = _persistence.create(pk);

		newCanBo.setCompanyId(RandomTestUtil.nextLong());

		newCanBo.setGroupId(RandomTestUtil.nextLong());

		newCanBo.setTen(RandomTestUtil.randomString());

		newCanBo.setChucVu(RandomTestUtil.randomString());

		newCanBo.setPhongban_id(RandomTestUtil.nextLong());

		newCanBo.setSdt(RandomTestUtil.randomString());

		newCanBo.setEmail(RandomTestUtil.randomString());

		newCanBo.setTinhTrang(RandomTestUtil.nextLong());

		newCanBo.setSapXep(RandomTestUtil.nextInt());

		newCanBo.setDaXoa(RandomTestUtil.nextLong());

		newCanBo.setNgayTao(RandomTestUtil.nextDate());

		newCanBo.setNgaySua(RandomTestUtil.nextDate());

		_canBos.add(_persistence.update(newCanBo));

		CanBo existingCanBo = _persistence.findByPrimaryKey(
			newCanBo.getPrimaryKey());

		Assert.assertEquals(existingCanBo.getCanboId(), newCanBo.getCanboId());
		Assert.assertEquals(
			existingCanBo.getCompanyId(), newCanBo.getCompanyId());
		Assert.assertEquals(existingCanBo.getGroupId(), newCanBo.getGroupId());
		Assert.assertEquals(existingCanBo.getTen(), newCanBo.getTen());
		Assert.assertEquals(existingCanBo.getChucVu(), newCanBo.getChucVu());
		Assert.assertEquals(
			existingCanBo.getPhongban_id(), newCanBo.getPhongban_id());
		Assert.assertEquals(existingCanBo.getSdt(), newCanBo.getSdt());
		Assert.assertEquals(existingCanBo.getEmail(), newCanBo.getEmail());
		Assert.assertEquals(
			existingCanBo.getTinhTrang(), newCanBo.getTinhTrang());
		Assert.assertEquals(existingCanBo.getSapXep(), newCanBo.getSapXep());
		Assert.assertEquals(existingCanBo.getDaXoa(), newCanBo.getDaXoa());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCanBo.getNgayTao()),
			Time.getShortTimestamp(newCanBo.getNgayTao()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCanBo.getNgaySua()),
			Time.getShortTimestamp(newCanBo.getNgaySua()));
	}

	@Test
	public void testCountByten() throws Exception {
		_persistence.countByten("");

		_persistence.countByten("null");

		_persistence.countByten((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CanBo newCanBo = addCanBo();

		CanBo existingCanBo = _persistence.findByPrimaryKey(
			newCanBo.getPrimaryKey());

		Assert.assertEquals(existingCanBo, newCanBo);
	}

	@Test(expected = NoSuchCanBoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CanBo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cms_lienhe_canbo", "canboId", true, "companyId", true, "groupId",
			true, "ten", true, "chucVu", true, "phongban_id", true, "sdt", true,
			"email", true, "tinhTrang", true, "sapXep", true, "daXoa", true,
			"ngayTao", true, "ngaySua", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CanBo newCanBo = addCanBo();

		CanBo existingCanBo = _persistence.fetchByPrimaryKey(
			newCanBo.getPrimaryKey());

		Assert.assertEquals(existingCanBo, newCanBo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CanBo missingCanBo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCanBo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CanBo newCanBo1 = addCanBo();
		CanBo newCanBo2 = addCanBo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCanBo1.getPrimaryKey());
		primaryKeys.add(newCanBo2.getPrimaryKey());

		Map<Serializable, CanBo> canBos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, canBos.size());
		Assert.assertEquals(newCanBo1, canBos.get(newCanBo1.getPrimaryKey()));
		Assert.assertEquals(newCanBo2, canBos.get(newCanBo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CanBo> canBos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(canBos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CanBo newCanBo = addCanBo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCanBo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CanBo> canBos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, canBos.size());
		Assert.assertEquals(newCanBo, canBos.get(newCanBo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CanBo> canBos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(canBos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CanBo newCanBo = addCanBo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCanBo.getPrimaryKey());

		Map<Serializable, CanBo> canBos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, canBos.size());
		Assert.assertEquals(newCanBo, canBos.get(newCanBo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CanBoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CanBo>() {

				@Override
				public void performAction(CanBo canBo) {
					Assert.assertNotNull(canBo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CanBo newCanBo = addCanBo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CanBo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("canboId", newCanBo.getCanboId()));

		List<CanBo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CanBo existingCanBo = result.get(0);

		Assert.assertEquals(existingCanBo, newCanBo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CanBo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("canboId", RandomTestUtil.nextLong()));

		List<CanBo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CanBo newCanBo = addCanBo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CanBo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("canboId"));

		Object newCanboId = newCanBo.getCanboId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("canboId", new Object[] {newCanboId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCanboId = result.get(0);

		Assert.assertEquals(existingCanboId, newCanboId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CanBo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("canboId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"canboId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected CanBo addCanBo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CanBo canBo = _persistence.create(pk);

		canBo.setCompanyId(RandomTestUtil.nextLong());

		canBo.setGroupId(RandomTestUtil.nextLong());

		canBo.setTen(RandomTestUtil.randomString());

		canBo.setChucVu(RandomTestUtil.randomString());

		canBo.setPhongban_id(RandomTestUtil.nextLong());

		canBo.setSdt(RandomTestUtil.randomString());

		canBo.setEmail(RandomTestUtil.randomString());

		canBo.setTinhTrang(RandomTestUtil.nextLong());

		canBo.setSapXep(RandomTestUtil.nextInt());

		canBo.setDaXoa(RandomTestUtil.nextLong());

		canBo.setNgayTao(RandomTestUtil.nextDate());

		canBo.setNgaySua(RandomTestUtil.nextDate());

		_canBos.add(_persistence.update(canBo));

		return canBo;
	}

	private List<CanBo> _canBos = new ArrayList<CanBo>();
	private CanBoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}