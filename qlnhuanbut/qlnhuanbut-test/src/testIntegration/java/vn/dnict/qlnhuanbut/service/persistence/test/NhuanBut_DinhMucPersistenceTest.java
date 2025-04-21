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

import java.math.BigDecimal;

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

import vn.dnict.qlnhuanbut.exception.NoSuchNhuanBut_DinhMucException;
import vn.dnict.qlnhuanbut.model.NhuanBut_DinhMuc;
import vn.dnict.qlnhuanbut.service.NhuanBut_DinhMucLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.persistence.NhuanBut_DinhMucPersistence;
import vn.dnict.qlnhuanbut.service.persistence.NhuanBut_DinhMucUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class NhuanBut_DinhMucPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlnhuanbut.service"));

	@Before
	public void setUp() {
		_persistence = NhuanBut_DinhMucUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<NhuanBut_DinhMuc> iterator = _nhuanBut_DinhMucs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_DinhMuc nhuanBut_DinhMuc = _persistence.create(pk);

		Assert.assertNotNull(nhuanBut_DinhMuc);

		Assert.assertEquals(nhuanBut_DinhMuc.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		NhuanBut_DinhMuc newNhuanBut_DinhMuc = addNhuanBut_DinhMuc();

		_persistence.remove(newNhuanBut_DinhMuc);

		NhuanBut_DinhMuc existingNhuanBut_DinhMuc =
			_persistence.fetchByPrimaryKey(newNhuanBut_DinhMuc.getPrimaryKey());

		Assert.assertNull(existingNhuanBut_DinhMuc);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNhuanBut_DinhMuc();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_DinhMuc newNhuanBut_DinhMuc = _persistence.create(pk);

		newNhuanBut_DinhMuc.setLoaidinhmuc(RandomTestUtil.nextLong());

		newNhuanBut_DinhMuc.setTonggia(
			new BigDecimal(RandomTestUtil.nextDouble()));

		_nhuanBut_DinhMucs.add(_persistence.update(newNhuanBut_DinhMuc));

		NhuanBut_DinhMuc existingNhuanBut_DinhMuc =
			_persistence.findByPrimaryKey(newNhuanBut_DinhMuc.getPrimaryKey());

		Assert.assertEquals(
			existingNhuanBut_DinhMuc.getId(), newNhuanBut_DinhMuc.getId());
		Assert.assertEquals(
			existingNhuanBut_DinhMuc.getLoaidinhmuc(),
			newNhuanBut_DinhMuc.getLoaidinhmuc());
		Assert.assertEquals(
			existingNhuanBut_DinhMuc.getTonggia(),
			newNhuanBut_DinhMuc.getTonggia());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		NhuanBut_DinhMuc newNhuanBut_DinhMuc = addNhuanBut_DinhMuc();

		NhuanBut_DinhMuc existingNhuanBut_DinhMuc =
			_persistence.findByPrimaryKey(newNhuanBut_DinhMuc.getPrimaryKey());

		Assert.assertEquals(existingNhuanBut_DinhMuc, newNhuanBut_DinhMuc);
	}

	@Test(expected = NoSuchNhuanBut_DinhMucException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<NhuanBut_DinhMuc> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_nhuanbut_dinhmuc", "id", true, "loaidinhmuc", true, "tonggia",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		NhuanBut_DinhMuc newNhuanBut_DinhMuc = addNhuanBut_DinhMuc();

		NhuanBut_DinhMuc existingNhuanBut_DinhMuc =
			_persistence.fetchByPrimaryKey(newNhuanBut_DinhMuc.getPrimaryKey());

		Assert.assertEquals(existingNhuanBut_DinhMuc, newNhuanBut_DinhMuc);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_DinhMuc missingNhuanBut_DinhMuc =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNhuanBut_DinhMuc);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		NhuanBut_DinhMuc newNhuanBut_DinhMuc1 = addNhuanBut_DinhMuc();
		NhuanBut_DinhMuc newNhuanBut_DinhMuc2 = addNhuanBut_DinhMuc();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhuanBut_DinhMuc1.getPrimaryKey());
		primaryKeys.add(newNhuanBut_DinhMuc2.getPrimaryKey());

		Map<Serializable, NhuanBut_DinhMuc> nhuanBut_DinhMucs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, nhuanBut_DinhMucs.size());
		Assert.assertEquals(
			newNhuanBut_DinhMuc1,
			nhuanBut_DinhMucs.get(newNhuanBut_DinhMuc1.getPrimaryKey()));
		Assert.assertEquals(
			newNhuanBut_DinhMuc2,
			nhuanBut_DinhMucs.get(newNhuanBut_DinhMuc2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, NhuanBut_DinhMuc> nhuanBut_DinhMucs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(nhuanBut_DinhMucs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		NhuanBut_DinhMuc newNhuanBut_DinhMuc = addNhuanBut_DinhMuc();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhuanBut_DinhMuc.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, NhuanBut_DinhMuc> nhuanBut_DinhMucs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, nhuanBut_DinhMucs.size());
		Assert.assertEquals(
			newNhuanBut_DinhMuc,
			nhuanBut_DinhMucs.get(newNhuanBut_DinhMuc.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, NhuanBut_DinhMuc> nhuanBut_DinhMucs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(nhuanBut_DinhMucs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		NhuanBut_DinhMuc newNhuanBut_DinhMuc = addNhuanBut_DinhMuc();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhuanBut_DinhMuc.getPrimaryKey());

		Map<Serializable, NhuanBut_DinhMuc> nhuanBut_DinhMucs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, nhuanBut_DinhMucs.size());
		Assert.assertEquals(
			newNhuanBut_DinhMuc,
			nhuanBut_DinhMucs.get(newNhuanBut_DinhMuc.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			NhuanBut_DinhMucLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<NhuanBut_DinhMuc>() {

				@Override
				public void performAction(NhuanBut_DinhMuc nhuanBut_DinhMuc) {
					Assert.assertNotNull(nhuanBut_DinhMuc);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		NhuanBut_DinhMuc newNhuanBut_DinhMuc = addNhuanBut_DinhMuc();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhuanBut_DinhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNhuanBut_DinhMuc.getId()));

		List<NhuanBut_DinhMuc> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		NhuanBut_DinhMuc existingNhuanBut_DinhMuc = result.get(0);

		Assert.assertEquals(existingNhuanBut_DinhMuc, newNhuanBut_DinhMuc);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhuanBut_DinhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<NhuanBut_DinhMuc> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		NhuanBut_DinhMuc newNhuanBut_DinhMuc = addNhuanBut_DinhMuc();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhuanBut_DinhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNhuanBut_DinhMuc.getId();

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
			NhuanBut_DinhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected NhuanBut_DinhMuc addNhuanBut_DinhMuc() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_DinhMuc nhuanBut_DinhMuc = _persistence.create(pk);

		nhuanBut_DinhMuc.setLoaidinhmuc(RandomTestUtil.nextLong());

		nhuanBut_DinhMuc.setTonggia(
			new BigDecimal(RandomTestUtil.nextDouble()));

		_nhuanBut_DinhMucs.add(_persistence.update(nhuanBut_DinhMuc));

		return nhuanBut_DinhMuc;
	}

	private List<NhuanBut_DinhMuc> _nhuanBut_DinhMucs =
		new ArrayList<NhuanBut_DinhMuc>();
	private NhuanBut_DinhMucPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}