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

import vn.dnict.qlnhuanbut.exception.NoSuchNhuanBut_TongTienException;
import vn.dnict.qlnhuanbut.model.NhuanBut_TongTien;
import vn.dnict.qlnhuanbut.service.NhuanBut_TongTienLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.persistence.NhuanBut_TongTienPersistence;
import vn.dnict.qlnhuanbut.service.persistence.NhuanBut_TongTienUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class NhuanBut_TongTienPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlnhuanbut.service"));

	@Before
	public void setUp() {
		_persistence = NhuanBut_TongTienUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<NhuanBut_TongTien> iterator = _nhuanBut_TongTiens.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_TongTien nhuanBut_TongTien = _persistence.create(pk);

		Assert.assertNotNull(nhuanBut_TongTien);

		Assert.assertEquals(nhuanBut_TongTien.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		NhuanBut_TongTien newNhuanBut_TongTien = addNhuanBut_TongTien();

		_persistence.remove(newNhuanBut_TongTien);

		NhuanBut_TongTien existingNhuanBut_TongTien =
			_persistence.fetchByPrimaryKey(
				newNhuanBut_TongTien.getPrimaryKey());

		Assert.assertNull(existingNhuanBut_TongTien);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNhuanBut_TongTien();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_TongTien newNhuanBut_TongTien = _persistence.create(pk);

		newNhuanBut_TongTien.setHesoId(RandomTestUtil.nextLong());

		newNhuanBut_TongTien.setDinhmucId(RandomTestUtil.nextLong());

		_nhuanBut_TongTiens.add(_persistence.update(newNhuanBut_TongTien));

		NhuanBut_TongTien existingNhuanBut_TongTien =
			_persistence.findByPrimaryKey(newNhuanBut_TongTien.getPrimaryKey());

		Assert.assertEquals(
			existingNhuanBut_TongTien.getId(), newNhuanBut_TongTien.getId());
		Assert.assertEquals(
			existingNhuanBut_TongTien.getHesoId(),
			newNhuanBut_TongTien.getHesoId());
		Assert.assertEquals(
			existingNhuanBut_TongTien.getDinhmucId(),
			newNhuanBut_TongTien.getDinhmucId());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		NhuanBut_TongTien newNhuanBut_TongTien = addNhuanBut_TongTien();

		NhuanBut_TongTien existingNhuanBut_TongTien =
			_persistence.findByPrimaryKey(newNhuanBut_TongTien.getPrimaryKey());

		Assert.assertEquals(existingNhuanBut_TongTien, newNhuanBut_TongTien);
	}

	@Test(expected = NoSuchNhuanBut_TongTienException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<NhuanBut_TongTien> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_nhuanbut_tongtien", "id", true, "hesoId", true, "dinhmucId",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		NhuanBut_TongTien newNhuanBut_TongTien = addNhuanBut_TongTien();

		NhuanBut_TongTien existingNhuanBut_TongTien =
			_persistence.fetchByPrimaryKey(
				newNhuanBut_TongTien.getPrimaryKey());

		Assert.assertEquals(existingNhuanBut_TongTien, newNhuanBut_TongTien);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_TongTien missingNhuanBut_TongTien =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNhuanBut_TongTien);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		NhuanBut_TongTien newNhuanBut_TongTien1 = addNhuanBut_TongTien();
		NhuanBut_TongTien newNhuanBut_TongTien2 = addNhuanBut_TongTien();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhuanBut_TongTien1.getPrimaryKey());
		primaryKeys.add(newNhuanBut_TongTien2.getPrimaryKey());

		Map<Serializable, NhuanBut_TongTien> nhuanBut_TongTiens =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, nhuanBut_TongTiens.size());
		Assert.assertEquals(
			newNhuanBut_TongTien1,
			nhuanBut_TongTiens.get(newNhuanBut_TongTien1.getPrimaryKey()));
		Assert.assertEquals(
			newNhuanBut_TongTien2,
			nhuanBut_TongTiens.get(newNhuanBut_TongTien2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, NhuanBut_TongTien> nhuanBut_TongTiens =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(nhuanBut_TongTiens.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		NhuanBut_TongTien newNhuanBut_TongTien = addNhuanBut_TongTien();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhuanBut_TongTien.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, NhuanBut_TongTien> nhuanBut_TongTiens =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, nhuanBut_TongTiens.size());
		Assert.assertEquals(
			newNhuanBut_TongTien,
			nhuanBut_TongTiens.get(newNhuanBut_TongTien.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, NhuanBut_TongTien> nhuanBut_TongTiens =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(nhuanBut_TongTiens.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		NhuanBut_TongTien newNhuanBut_TongTien = addNhuanBut_TongTien();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhuanBut_TongTien.getPrimaryKey());

		Map<Serializable, NhuanBut_TongTien> nhuanBut_TongTiens =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, nhuanBut_TongTiens.size());
		Assert.assertEquals(
			newNhuanBut_TongTien,
			nhuanBut_TongTiens.get(newNhuanBut_TongTien.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			NhuanBut_TongTienLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<NhuanBut_TongTien>() {

				@Override
				public void performAction(NhuanBut_TongTien nhuanBut_TongTien) {
					Assert.assertNotNull(nhuanBut_TongTien);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		NhuanBut_TongTien newNhuanBut_TongTien = addNhuanBut_TongTien();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhuanBut_TongTien.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newNhuanBut_TongTien.getId()));

		List<NhuanBut_TongTien> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		NhuanBut_TongTien existingNhuanBut_TongTien = result.get(0);

		Assert.assertEquals(existingNhuanBut_TongTien, newNhuanBut_TongTien);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhuanBut_TongTien.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<NhuanBut_TongTien> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		NhuanBut_TongTien newNhuanBut_TongTien = addNhuanBut_TongTien();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhuanBut_TongTien.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNhuanBut_TongTien.getId();

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
			NhuanBut_TongTien.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected NhuanBut_TongTien addNhuanBut_TongTien() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhuanBut_TongTien nhuanBut_TongTien = _persistence.create(pk);

		nhuanBut_TongTien.setHesoId(RandomTestUtil.nextLong());

		nhuanBut_TongTien.setDinhmucId(RandomTestUtil.nextLong());

		_nhuanBut_TongTiens.add(_persistence.update(nhuanBut_TongTien));

		return nhuanBut_TongTien;
	}

	private List<NhuanBut_TongTien> _nhuanBut_TongTiens =
		new ArrayList<NhuanBut_TongTien>();
	private NhuanBut_TongTienPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}