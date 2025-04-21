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

import vn.dnict.qlnhuanbut.exception.NoSuchHeSoTheLoaiException;
import vn.dnict.qlnhuanbut.model.HeSoTheLoai;
import vn.dnict.qlnhuanbut.service.HeSoTheLoaiLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.persistence.HeSoTheLoaiPersistence;
import vn.dnict.qlnhuanbut.service.persistence.HeSoTheLoaiUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class HeSoTheLoaiPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlnhuanbut.service"));

	@Before
	public void setUp() {
		_persistence = HeSoTheLoaiUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<HeSoTheLoai> iterator = _heSoTheLoais.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HeSoTheLoai heSoTheLoai = _persistence.create(pk);

		Assert.assertNotNull(heSoTheLoai);

		Assert.assertEquals(heSoTheLoai.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		HeSoTheLoai newHeSoTheLoai = addHeSoTheLoai();

		_persistence.remove(newHeSoTheLoai);

		HeSoTheLoai existingHeSoTheLoai = _persistence.fetchByPrimaryKey(
			newHeSoTheLoai.getPrimaryKey());

		Assert.assertNull(existingHeSoTheLoai);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addHeSoTheLoai();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HeSoTheLoai newHeSoTheLoai = _persistence.create(pk);

		newHeSoTheLoai.setTypeId(RandomTestUtil.nextLong());

		newHeSoTheLoai.setMinheso(RandomTestUtil.randomString());

		newHeSoTheLoai.setMaxheso(RandomTestUtil.randomString());

		_heSoTheLoais.add(_persistence.update(newHeSoTheLoai));

		HeSoTheLoai existingHeSoTheLoai = _persistence.findByPrimaryKey(
			newHeSoTheLoai.getPrimaryKey());

		Assert.assertEquals(
			existingHeSoTheLoai.getId(), newHeSoTheLoai.getId());
		Assert.assertEquals(
			existingHeSoTheLoai.getTypeId(), newHeSoTheLoai.getTypeId());
		Assert.assertEquals(
			existingHeSoTheLoai.getMinheso(), newHeSoTheLoai.getMinheso());
		Assert.assertEquals(
			existingHeSoTheLoai.getMaxheso(), newHeSoTheLoai.getMaxheso());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		HeSoTheLoai newHeSoTheLoai = addHeSoTheLoai();

		HeSoTheLoai existingHeSoTheLoai = _persistence.findByPrimaryKey(
			newHeSoTheLoai.getPrimaryKey());

		Assert.assertEquals(existingHeSoTheLoai, newHeSoTheLoai);
	}

	@Test(expected = NoSuchHeSoTheLoaiException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<HeSoTheLoai> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_nhuanbut_hesotheloai", "id", true, "typeId", true, "minheso",
			true, "maxheso", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		HeSoTheLoai newHeSoTheLoai = addHeSoTheLoai();

		HeSoTheLoai existingHeSoTheLoai = _persistence.fetchByPrimaryKey(
			newHeSoTheLoai.getPrimaryKey());

		Assert.assertEquals(existingHeSoTheLoai, newHeSoTheLoai);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HeSoTheLoai missingHeSoTheLoai = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingHeSoTheLoai);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		HeSoTheLoai newHeSoTheLoai1 = addHeSoTheLoai();
		HeSoTheLoai newHeSoTheLoai2 = addHeSoTheLoai();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHeSoTheLoai1.getPrimaryKey());
		primaryKeys.add(newHeSoTheLoai2.getPrimaryKey());

		Map<Serializable, HeSoTheLoai> heSoTheLoais =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, heSoTheLoais.size());
		Assert.assertEquals(
			newHeSoTheLoai1, heSoTheLoais.get(newHeSoTheLoai1.getPrimaryKey()));
		Assert.assertEquals(
			newHeSoTheLoai2, heSoTheLoais.get(newHeSoTheLoai2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, HeSoTheLoai> heSoTheLoais =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(heSoTheLoais.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		HeSoTheLoai newHeSoTheLoai = addHeSoTheLoai();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHeSoTheLoai.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, HeSoTheLoai> heSoTheLoais =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, heSoTheLoais.size());
		Assert.assertEquals(
			newHeSoTheLoai, heSoTheLoais.get(newHeSoTheLoai.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, HeSoTheLoai> heSoTheLoais =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(heSoTheLoais.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		HeSoTheLoai newHeSoTheLoai = addHeSoTheLoai();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHeSoTheLoai.getPrimaryKey());

		Map<Serializable, HeSoTheLoai> heSoTheLoais =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, heSoTheLoais.size());
		Assert.assertEquals(
			newHeSoTheLoai, heSoTheLoais.get(newHeSoTheLoai.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			HeSoTheLoaiLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<HeSoTheLoai>() {

				@Override
				public void performAction(HeSoTheLoai heSoTheLoai) {
					Assert.assertNotNull(heSoTheLoai);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		HeSoTheLoai newHeSoTheLoai = addHeSoTheLoai();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HeSoTheLoai.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newHeSoTheLoai.getId()));

		List<HeSoTheLoai> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		HeSoTheLoai existingHeSoTheLoai = result.get(0);

		Assert.assertEquals(existingHeSoTheLoai, newHeSoTheLoai);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HeSoTheLoai.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<HeSoTheLoai> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		HeSoTheLoai newHeSoTheLoai = addHeSoTheLoai();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HeSoTheLoai.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newHeSoTheLoai.getId();

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
			HeSoTheLoai.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected HeSoTheLoai addHeSoTheLoai() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HeSoTheLoai heSoTheLoai = _persistence.create(pk);

		heSoTheLoai.setTypeId(RandomTestUtil.nextLong());

		heSoTheLoai.setMinheso(RandomTestUtil.randomString());

		heSoTheLoai.setMaxheso(RandomTestUtil.randomString());

		_heSoTheLoais.add(_persistence.update(heSoTheLoai));

		return heSoTheLoai;
	}

	private List<HeSoTheLoai> _heSoTheLoais = new ArrayList<HeSoTheLoai>();
	private HeSoTheLoaiPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}