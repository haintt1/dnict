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

import vn.dnict.qlnhuanbut.exception.NoSuchHeSoLoaiAPException;
import vn.dnict.qlnhuanbut.model.HeSoLoaiAP;
import vn.dnict.qlnhuanbut.service.HeSoLoaiAPLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.persistence.HeSoLoaiAPPersistence;
import vn.dnict.qlnhuanbut.service.persistence.HeSoLoaiAPUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class HeSoLoaiAPPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlnhuanbut.service"));

	@Before
	public void setUp() {
		_persistence = HeSoLoaiAPUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<HeSoLoaiAP> iterator = _heSoLoaiAPs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HeSoLoaiAP heSoLoaiAP = _persistence.create(pk);

		Assert.assertNotNull(heSoLoaiAP);

		Assert.assertEquals(heSoLoaiAP.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		HeSoLoaiAP newHeSoLoaiAP = addHeSoLoaiAP();

		_persistence.remove(newHeSoLoaiAP);

		HeSoLoaiAP existingHeSoLoaiAP = _persistence.fetchByPrimaryKey(
			newHeSoLoaiAP.getPrimaryKey());

		Assert.assertNull(existingHeSoLoaiAP);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addHeSoLoaiAP();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HeSoLoaiAP newHeSoLoaiAP = _persistence.create(pk);

		newHeSoLoaiAP.setLoaiId(RandomTestUtil.nextLong());

		newHeSoLoaiAP.setMinheso(RandomTestUtil.randomString());

		newHeSoLoaiAP.setMaxheso(RandomTestUtil.randomString());

		_heSoLoaiAPs.add(_persistence.update(newHeSoLoaiAP));

		HeSoLoaiAP existingHeSoLoaiAP = _persistence.findByPrimaryKey(
			newHeSoLoaiAP.getPrimaryKey());

		Assert.assertEquals(existingHeSoLoaiAP.getId(), newHeSoLoaiAP.getId());
		Assert.assertEquals(
			existingHeSoLoaiAP.getLoaiId(), newHeSoLoaiAP.getLoaiId());
		Assert.assertEquals(
			existingHeSoLoaiAP.getMinheso(), newHeSoLoaiAP.getMinheso());
		Assert.assertEquals(
			existingHeSoLoaiAP.getMaxheso(), newHeSoLoaiAP.getMaxheso());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		HeSoLoaiAP newHeSoLoaiAP = addHeSoLoaiAP();

		HeSoLoaiAP existingHeSoLoaiAP = _persistence.findByPrimaryKey(
			newHeSoLoaiAP.getPrimaryKey());

		Assert.assertEquals(existingHeSoLoaiAP, newHeSoLoaiAP);
	}

	@Test(expected = NoSuchHeSoLoaiAPException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<HeSoLoaiAP> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_nhuanbut_hesoloaiAP", "id", true, "loaiId", true, "minheso",
			true, "maxheso", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		HeSoLoaiAP newHeSoLoaiAP = addHeSoLoaiAP();

		HeSoLoaiAP existingHeSoLoaiAP = _persistence.fetchByPrimaryKey(
			newHeSoLoaiAP.getPrimaryKey());

		Assert.assertEquals(existingHeSoLoaiAP, newHeSoLoaiAP);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HeSoLoaiAP missingHeSoLoaiAP = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingHeSoLoaiAP);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		HeSoLoaiAP newHeSoLoaiAP1 = addHeSoLoaiAP();
		HeSoLoaiAP newHeSoLoaiAP2 = addHeSoLoaiAP();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHeSoLoaiAP1.getPrimaryKey());
		primaryKeys.add(newHeSoLoaiAP2.getPrimaryKey());

		Map<Serializable, HeSoLoaiAP> heSoLoaiAPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, heSoLoaiAPs.size());
		Assert.assertEquals(
			newHeSoLoaiAP1, heSoLoaiAPs.get(newHeSoLoaiAP1.getPrimaryKey()));
		Assert.assertEquals(
			newHeSoLoaiAP2, heSoLoaiAPs.get(newHeSoLoaiAP2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, HeSoLoaiAP> heSoLoaiAPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(heSoLoaiAPs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		HeSoLoaiAP newHeSoLoaiAP = addHeSoLoaiAP();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHeSoLoaiAP.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, HeSoLoaiAP> heSoLoaiAPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, heSoLoaiAPs.size());
		Assert.assertEquals(
			newHeSoLoaiAP, heSoLoaiAPs.get(newHeSoLoaiAP.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, HeSoLoaiAP> heSoLoaiAPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(heSoLoaiAPs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		HeSoLoaiAP newHeSoLoaiAP = addHeSoLoaiAP();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHeSoLoaiAP.getPrimaryKey());

		Map<Serializable, HeSoLoaiAP> heSoLoaiAPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, heSoLoaiAPs.size());
		Assert.assertEquals(
			newHeSoLoaiAP, heSoLoaiAPs.get(newHeSoLoaiAP.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			HeSoLoaiAPLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<HeSoLoaiAP>() {

				@Override
				public void performAction(HeSoLoaiAP heSoLoaiAP) {
					Assert.assertNotNull(heSoLoaiAP);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		HeSoLoaiAP newHeSoLoaiAP = addHeSoLoaiAP();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HeSoLoaiAP.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newHeSoLoaiAP.getId()));

		List<HeSoLoaiAP> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		HeSoLoaiAP existingHeSoLoaiAP = result.get(0);

		Assert.assertEquals(existingHeSoLoaiAP, newHeSoLoaiAP);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HeSoLoaiAP.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<HeSoLoaiAP> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		HeSoLoaiAP newHeSoLoaiAP = addHeSoLoaiAP();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HeSoLoaiAP.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newHeSoLoaiAP.getId();

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
			HeSoLoaiAP.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected HeSoLoaiAP addHeSoLoaiAP() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HeSoLoaiAP heSoLoaiAP = _persistence.create(pk);

		heSoLoaiAP.setLoaiId(RandomTestUtil.nextLong());

		heSoLoaiAP.setMinheso(RandomTestUtil.randomString());

		heSoLoaiAP.setMaxheso(RandomTestUtil.randomString());

		_heSoLoaiAPs.add(_persistence.update(heSoLoaiAP));

		return heSoLoaiAP;
	}

	private List<HeSoLoaiAP> _heSoLoaiAPs = new ArrayList<HeSoLoaiAP>();
	private HeSoLoaiAPPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}