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

import vn.dnict.qlnhuanbut.exception.NoSuchDinhMucException;
import vn.dnict.qlnhuanbut.model.DinhMuc;
import vn.dnict.qlnhuanbut.service.DinhMucLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.persistence.DinhMucPersistence;
import vn.dnict.qlnhuanbut.service.persistence.DinhMucUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class DinhMucPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlnhuanbut.service"));

	@Before
	public void setUp() {
		_persistence = DinhMucUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DinhMuc> iterator = _dinhMucs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DinhMuc dinhMuc = _persistence.create(pk);

		Assert.assertNotNull(dinhMuc);

		Assert.assertEquals(dinhMuc.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DinhMuc newDinhMuc = addDinhMuc();

		_persistence.remove(newDinhMuc);

		DinhMuc existingDinhMuc = _persistence.fetchByPrimaryKey(
			newDinhMuc.getPrimaryKey());

		Assert.assertNull(existingDinhMuc);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDinhMuc();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DinhMuc newDinhMuc = _persistence.create(pk);

		newDinhMuc.setLoaidinhmuc(RandomTestUtil.nextInt());

		newDinhMuc.setGia(RandomTestUtil.randomString());

		_dinhMucs.add(_persistence.update(newDinhMuc));

		DinhMuc existingDinhMuc = _persistence.findByPrimaryKey(
			newDinhMuc.getPrimaryKey());

		Assert.assertEquals(existingDinhMuc.getId(), newDinhMuc.getId());
		Assert.assertEquals(
			existingDinhMuc.getLoaidinhmuc(), newDinhMuc.getLoaidinhmuc());
		Assert.assertEquals(existingDinhMuc.getGia(), newDinhMuc.getGia());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DinhMuc newDinhMuc = addDinhMuc();

		DinhMuc existingDinhMuc = _persistence.findByPrimaryKey(
			newDinhMuc.getPrimaryKey());

		Assert.assertEquals(existingDinhMuc, newDinhMuc);
	}

	@Test(expected = NoSuchDinhMucException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<DinhMuc> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_nhuanbut_dinhmuc", "id", true, "loaidinhmuc", true, "gia",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DinhMuc newDinhMuc = addDinhMuc();

		DinhMuc existingDinhMuc = _persistence.fetchByPrimaryKey(
			newDinhMuc.getPrimaryKey());

		Assert.assertEquals(existingDinhMuc, newDinhMuc);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DinhMuc missingDinhMuc = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDinhMuc);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DinhMuc newDinhMuc1 = addDinhMuc();
		DinhMuc newDinhMuc2 = addDinhMuc();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDinhMuc1.getPrimaryKey());
		primaryKeys.add(newDinhMuc2.getPrimaryKey());

		Map<Serializable, DinhMuc> dinhMucs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, dinhMucs.size());
		Assert.assertEquals(
			newDinhMuc1, dinhMucs.get(newDinhMuc1.getPrimaryKey()));
		Assert.assertEquals(
			newDinhMuc2, dinhMucs.get(newDinhMuc2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DinhMuc> dinhMucs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(dinhMucs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DinhMuc newDinhMuc = addDinhMuc();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDinhMuc.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DinhMuc> dinhMucs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, dinhMucs.size());
		Assert.assertEquals(
			newDinhMuc, dinhMucs.get(newDinhMuc.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DinhMuc> dinhMucs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(dinhMucs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DinhMuc newDinhMuc = addDinhMuc();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDinhMuc.getPrimaryKey());

		Map<Serializable, DinhMuc> dinhMucs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, dinhMucs.size());
		Assert.assertEquals(
			newDinhMuc, dinhMucs.get(newDinhMuc.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DinhMucLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DinhMuc>() {

				@Override
				public void performAction(DinhMuc dinhMuc) {
					Assert.assertNotNull(dinhMuc);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DinhMuc newDinhMuc = addDinhMuc();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DinhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newDinhMuc.getId()));

		List<DinhMuc> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		DinhMuc existingDinhMuc = result.get(0);

		Assert.assertEquals(existingDinhMuc, newDinhMuc);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DinhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<DinhMuc> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DinhMuc newDinhMuc = addDinhMuc();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DinhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newDinhMuc.getId();

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
			DinhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected DinhMuc addDinhMuc() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DinhMuc dinhMuc = _persistence.create(pk);

		dinhMuc.setLoaidinhmuc(RandomTestUtil.nextInt());

		dinhMuc.setGia(RandomTestUtil.randomString());

		_dinhMucs.add(_persistence.update(dinhMuc));

		return dinhMuc;
	}

	private List<DinhMuc> _dinhMucs = new ArrayList<DinhMuc>();
	private DinhMucPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}