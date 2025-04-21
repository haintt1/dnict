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

import vn.dnict.qlnhuanbut.exception.NoSuchNhuanBut_HeSoException;
import vn.dnict.qlnhuanbut.model.NhuanBut_HeSo;
import vn.dnict.qlnhuanbut.service.NhuanBut_HeSoLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.persistence.NhuanBut_HeSoPersistence;
import vn.dnict.qlnhuanbut.service.persistence.NhuanBut_HeSoUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class NhuanBut_HeSoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlnhuanbut.service"));

	@Before
	public void setUp() {
		_persistence = NhuanBut_HeSoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<NhuanBut_HeSo> iterator = _nhuanBut_HeSos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_HeSo nhuanBut_HeSo = _persistence.create(pk);

		Assert.assertNotNull(nhuanBut_HeSo);

		Assert.assertEquals(nhuanBut_HeSo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		NhuanBut_HeSo newNhuanBut_HeSo = addNhuanBut_HeSo();

		_persistence.remove(newNhuanBut_HeSo);

		NhuanBut_HeSo existingNhuanBut_HeSo = _persistence.fetchByPrimaryKey(
			newNhuanBut_HeSo.getPrimaryKey());

		Assert.assertNull(existingNhuanBut_HeSo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNhuanBut_HeSo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_HeSo newNhuanBut_HeSo = _persistence.create(pk);

		newNhuanBut_HeSo.setTypeId(RandomTestUtil.nextLong());

		newNhuanBut_HeSo.setLoaiId(RandomTestUtil.nextLong());

		newNhuanBut_HeSo.setMinheso(
			new BigDecimal(RandomTestUtil.nextDouble()));

		newNhuanBut_HeSo.setMaxheso(
			new BigDecimal(RandomTestUtil.nextDouble()));

		_nhuanBut_HeSos.add(_persistence.update(newNhuanBut_HeSo));

		NhuanBut_HeSo existingNhuanBut_HeSo = _persistence.findByPrimaryKey(
			newNhuanBut_HeSo.getPrimaryKey());

		Assert.assertEquals(
			existingNhuanBut_HeSo.getId(), newNhuanBut_HeSo.getId());
		Assert.assertEquals(
			existingNhuanBut_HeSo.getTypeId(), newNhuanBut_HeSo.getTypeId());
		Assert.assertEquals(
			existingNhuanBut_HeSo.getLoaiId(), newNhuanBut_HeSo.getLoaiId());
		Assert.assertEquals(
			existingNhuanBut_HeSo.getMinheso(), newNhuanBut_HeSo.getMinheso());
		Assert.assertEquals(
			existingNhuanBut_HeSo.getMaxheso(), newNhuanBut_HeSo.getMaxheso());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		NhuanBut_HeSo newNhuanBut_HeSo = addNhuanBut_HeSo();

		NhuanBut_HeSo existingNhuanBut_HeSo = _persistence.findByPrimaryKey(
			newNhuanBut_HeSo.getPrimaryKey());

		Assert.assertEquals(existingNhuanBut_HeSo, newNhuanBut_HeSo);
	}

	@Test(expected = NoSuchNhuanBut_HeSoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<NhuanBut_HeSo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_nhuanbut_heso", "id", true, "typeId", true, "loaiId", true,
			"minheso", true, "maxheso", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		NhuanBut_HeSo newNhuanBut_HeSo = addNhuanBut_HeSo();

		NhuanBut_HeSo existingNhuanBut_HeSo = _persistence.fetchByPrimaryKey(
			newNhuanBut_HeSo.getPrimaryKey());

		Assert.assertEquals(existingNhuanBut_HeSo, newNhuanBut_HeSo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_HeSo missingNhuanBut_HeSo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNhuanBut_HeSo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		NhuanBut_HeSo newNhuanBut_HeSo1 = addNhuanBut_HeSo();
		NhuanBut_HeSo newNhuanBut_HeSo2 = addNhuanBut_HeSo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhuanBut_HeSo1.getPrimaryKey());
		primaryKeys.add(newNhuanBut_HeSo2.getPrimaryKey());

		Map<Serializable, NhuanBut_HeSo> nhuanBut_HeSos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, nhuanBut_HeSos.size());
		Assert.assertEquals(
			newNhuanBut_HeSo1,
			nhuanBut_HeSos.get(newNhuanBut_HeSo1.getPrimaryKey()));
		Assert.assertEquals(
			newNhuanBut_HeSo2,
			nhuanBut_HeSos.get(newNhuanBut_HeSo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, NhuanBut_HeSo> nhuanBut_HeSos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(nhuanBut_HeSos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		NhuanBut_HeSo newNhuanBut_HeSo = addNhuanBut_HeSo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhuanBut_HeSo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, NhuanBut_HeSo> nhuanBut_HeSos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, nhuanBut_HeSos.size());
		Assert.assertEquals(
			newNhuanBut_HeSo,
			nhuanBut_HeSos.get(newNhuanBut_HeSo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, NhuanBut_HeSo> nhuanBut_HeSos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(nhuanBut_HeSos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		NhuanBut_HeSo newNhuanBut_HeSo = addNhuanBut_HeSo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhuanBut_HeSo.getPrimaryKey());

		Map<Serializable, NhuanBut_HeSo> nhuanBut_HeSos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, nhuanBut_HeSos.size());
		Assert.assertEquals(
			newNhuanBut_HeSo,
			nhuanBut_HeSos.get(newNhuanBut_HeSo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			NhuanBut_HeSoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<NhuanBut_HeSo>() {

				@Override
				public void performAction(NhuanBut_HeSo nhuanBut_HeSo) {
					Assert.assertNotNull(nhuanBut_HeSo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		NhuanBut_HeSo newNhuanBut_HeSo = addNhuanBut_HeSo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhuanBut_HeSo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNhuanBut_HeSo.getId()));

		List<NhuanBut_HeSo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		NhuanBut_HeSo existingNhuanBut_HeSo = result.get(0);

		Assert.assertEquals(existingNhuanBut_HeSo, newNhuanBut_HeSo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhuanBut_HeSo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<NhuanBut_HeSo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		NhuanBut_HeSo newNhuanBut_HeSo = addNhuanBut_HeSo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhuanBut_HeSo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNhuanBut_HeSo.getId();

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
			NhuanBut_HeSo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected NhuanBut_HeSo addNhuanBut_HeSo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_HeSo nhuanBut_HeSo = _persistence.create(pk);

		nhuanBut_HeSo.setTypeId(RandomTestUtil.nextLong());

		nhuanBut_HeSo.setLoaiId(RandomTestUtil.nextLong());

		nhuanBut_HeSo.setMinheso(new BigDecimal(RandomTestUtil.nextDouble()));

		nhuanBut_HeSo.setMaxheso(new BigDecimal(RandomTestUtil.nextDouble()));

		_nhuanBut_HeSos.add(_persistence.update(nhuanBut_HeSo));

		return nhuanBut_HeSo;
	}

	private List<NhuanBut_HeSo> _nhuanBut_HeSos =
		new ArrayList<NhuanBut_HeSo>();
	private NhuanBut_HeSoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}