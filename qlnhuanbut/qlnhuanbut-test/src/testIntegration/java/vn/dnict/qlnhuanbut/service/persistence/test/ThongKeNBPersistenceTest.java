/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AssertUtils;
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

import vn.dnict.qlnhuanbut.exception.NoSuchThongKeNBException;
import vn.dnict.qlnhuanbut.model.ThongKeNB;
import vn.dnict.qlnhuanbut.service.ThongKeNBLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.persistence.ThongKeNBPersistence;
import vn.dnict.qlnhuanbut.service.persistence.ThongKeNBUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ThongKeNBPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlnhuanbut.service"));

	@Before
	public void setUp() {
		_persistence = ThongKeNBUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ThongKeNB> iterator = _thongKeNBs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ThongKeNB thongKeNB = _persistence.create(pk);

		Assert.assertNotNull(thongKeNB);

		Assert.assertEquals(thongKeNB.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ThongKeNB newThongKeNB = addThongKeNB();

		_persistence.remove(newThongKeNB);

		ThongKeNB existingThongKeNB = _persistence.fetchByPrimaryKey(
			newThongKeNB.getPrimaryKey());

		Assert.assertNull(existingThongKeNB);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addThongKeNB();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ThongKeNB newThongKeNB = _persistence.create(pk);

		newThongKeNB.setNguoixuly(RandomTestUtil.nextLong());

		newThongKeNB.setNewarticleId(RandomTestUtil.nextLong());

		newThongKeNB.setAnphamId(RandomTestUtil.nextLong());

		newThongKeNB.setHeso(RandomTestUtil.randomString());

		newThongKeNB.setTongtien(RandomTestUtil.nextDouble());

		newThongKeNB.setStatus(RandomTestUtil.nextInt());

		newThongKeNB.setNgaytao(RandomTestUtil.nextDate());

		newThongKeNB.setNgaysua(RandomTestUtil.nextDate());

		_thongKeNBs.add(_persistence.update(newThongKeNB));

		ThongKeNB existingThongKeNB = _persistence.findByPrimaryKey(
			newThongKeNB.getPrimaryKey());

		Assert.assertEquals(existingThongKeNB.getId(), newThongKeNB.getId());
		Assert.assertEquals(
			existingThongKeNB.getNguoixuly(), newThongKeNB.getNguoixuly());
		Assert.assertEquals(
			existingThongKeNB.getNewarticleId(),
			newThongKeNB.getNewarticleId());
		Assert.assertEquals(
			existingThongKeNB.getAnphamId(), newThongKeNB.getAnphamId());
		Assert.assertEquals(
			existingThongKeNB.getHeso(), newThongKeNB.getHeso());
		AssertUtils.assertEquals(
			existingThongKeNB.getTongtien(), newThongKeNB.getTongtien());
		Assert.assertEquals(
			existingThongKeNB.getStatus(), newThongKeNB.getStatus());
		Assert.assertEquals(
			Time.getShortTimestamp(existingThongKeNB.getNgaytao()),
			Time.getShortTimestamp(newThongKeNB.getNgaytao()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingThongKeNB.getNgaysua()),
			Time.getShortTimestamp(newThongKeNB.getNgaysua()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ThongKeNB newThongKeNB = addThongKeNB();

		ThongKeNB existingThongKeNB = _persistence.findByPrimaryKey(
			newThongKeNB.getPrimaryKey());

		Assert.assertEquals(existingThongKeNB, newThongKeNB);
	}

	@Test(expected = NoSuchThongKeNBException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ThongKeNB> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_nhuanbut_thongke", "id", true, "nguoixuly", true,
			"newarticleId", true, "anphamId", true, "heso", true, "tongtien",
			true, "status", true, "ngaytao", true, "ngaysua", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ThongKeNB newThongKeNB = addThongKeNB();

		ThongKeNB existingThongKeNB = _persistence.fetchByPrimaryKey(
			newThongKeNB.getPrimaryKey());

		Assert.assertEquals(existingThongKeNB, newThongKeNB);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ThongKeNB missingThongKeNB = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingThongKeNB);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ThongKeNB newThongKeNB1 = addThongKeNB();
		ThongKeNB newThongKeNB2 = addThongKeNB();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newThongKeNB1.getPrimaryKey());
		primaryKeys.add(newThongKeNB2.getPrimaryKey());

		Map<Serializable, ThongKeNB> thongKeNBs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, thongKeNBs.size());
		Assert.assertEquals(
			newThongKeNB1, thongKeNBs.get(newThongKeNB1.getPrimaryKey()));
		Assert.assertEquals(
			newThongKeNB2, thongKeNBs.get(newThongKeNB2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ThongKeNB> thongKeNBs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(thongKeNBs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ThongKeNB newThongKeNB = addThongKeNB();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newThongKeNB.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ThongKeNB> thongKeNBs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, thongKeNBs.size());
		Assert.assertEquals(
			newThongKeNB, thongKeNBs.get(newThongKeNB.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ThongKeNB> thongKeNBs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(thongKeNBs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ThongKeNB newThongKeNB = addThongKeNB();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newThongKeNB.getPrimaryKey());

		Map<Serializable, ThongKeNB> thongKeNBs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, thongKeNBs.size());
		Assert.assertEquals(
			newThongKeNB, thongKeNBs.get(newThongKeNB.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ThongKeNBLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ThongKeNB>() {

				@Override
				public void performAction(ThongKeNB thongKeNB) {
					Assert.assertNotNull(thongKeNB);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ThongKeNB newThongKeNB = addThongKeNB();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ThongKeNB.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newThongKeNB.getId()));

		List<ThongKeNB> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ThongKeNB existingThongKeNB = result.get(0);

		Assert.assertEquals(existingThongKeNB, newThongKeNB);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ThongKeNB.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<ThongKeNB> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ThongKeNB newThongKeNB = addThongKeNB();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ThongKeNB.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newThongKeNB.getId();

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
			ThongKeNB.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ThongKeNB addThongKeNB() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ThongKeNB thongKeNB = _persistence.create(pk);

		thongKeNB.setNguoixuly(RandomTestUtil.nextLong());

		thongKeNB.setNewarticleId(RandomTestUtil.nextLong());

		thongKeNB.setAnphamId(RandomTestUtil.nextLong());

		thongKeNB.setHeso(RandomTestUtil.randomString());

		thongKeNB.setTongtien(RandomTestUtil.nextDouble());

		thongKeNB.setStatus(RandomTestUtil.nextInt());

		thongKeNB.setNgaytao(RandomTestUtil.nextDate());

		thongKeNB.setNgaysua(RandomTestUtil.nextDate());

		_thongKeNBs.add(_persistence.update(thongKeNB));

		return thongKeNB;
	}

	private List<ThongKeNB> _thongKeNBs = new ArrayList<ThongKeNB>();
	private ThongKeNBPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}