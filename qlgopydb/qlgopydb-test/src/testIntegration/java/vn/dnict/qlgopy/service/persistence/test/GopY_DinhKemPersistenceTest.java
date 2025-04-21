/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service.persistence.test;

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

import vn.dnict.qlgopy.exception.NoSuchGopY_DinhKemException;
import vn.dnict.qlgopy.model.GopY_DinhKem;
import vn.dnict.qlgopy.service.GopY_DinhKemLocalServiceUtil;
import vn.dnict.qlgopy.service.persistence.GopY_DinhKemPersistence;
import vn.dnict.qlgopy.service.persistence.GopY_DinhKemUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class GopY_DinhKemPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlgopy.service"));

	@Before
	public void setUp() {
		_persistence = GopY_DinhKemUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<GopY_DinhKem> iterator = _gopY_DinhKems.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		GopY_DinhKem gopY_DinhKem = _persistence.create(pk);

		Assert.assertNotNull(gopY_DinhKem);

		Assert.assertEquals(gopY_DinhKem.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		GopY_DinhKem newGopY_DinhKem = addGopY_DinhKem();

		_persistence.remove(newGopY_DinhKem);

		GopY_DinhKem existingGopY_DinhKem = _persistence.fetchByPrimaryKey(
			newGopY_DinhKem.getPrimaryKey());

		Assert.assertNull(existingGopY_DinhKem);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addGopY_DinhKem();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		GopY_DinhKem newGopY_DinhKem = _persistence.create(pk);

		newGopY_DinhKem.setCompanyId(RandomTestUtil.nextLong());

		newGopY_DinhKem.setGroupId(RandomTestUtil.nextLong());

		newGopY_DinhKem.setUserId(RandomTestUtil.nextLong());

		newGopY_DinhKem.setTen(RandomTestUtil.randomString());

		newGopY_DinhKem.setUrl(RandomTestUtil.randomString());

		newGopY_DinhKem.setObject(RandomTestUtil.nextLong());

		newGopY_DinhKem.setObjectId(RandomTestUtil.nextLong());

		newGopY_DinhKem.setGhichu(RandomTestUtil.randomString());

		newGopY_DinhKem.setDaxoa(RandomTestUtil.nextInt());

		newGopY_DinhKem.setStatus(RandomTestUtil.nextInt());

		_gopY_DinhKems.add(_persistence.update(newGopY_DinhKem));

		GopY_DinhKem existingGopY_DinhKem = _persistence.findByPrimaryKey(
			newGopY_DinhKem.getPrimaryKey());

		Assert.assertEquals(
			existingGopY_DinhKem.getId(), newGopY_DinhKem.getId());
		Assert.assertEquals(
			existingGopY_DinhKem.getCompanyId(),
			newGopY_DinhKem.getCompanyId());
		Assert.assertEquals(
			existingGopY_DinhKem.getGroupId(), newGopY_DinhKem.getGroupId());
		Assert.assertEquals(
			existingGopY_DinhKem.getUserId(), newGopY_DinhKem.getUserId());
		Assert.assertEquals(
			existingGopY_DinhKem.getTen(), newGopY_DinhKem.getTen());
		Assert.assertEquals(
			existingGopY_DinhKem.getUrl(), newGopY_DinhKem.getUrl());
		Assert.assertEquals(
			existingGopY_DinhKem.getObject(), newGopY_DinhKem.getObject());
		Assert.assertEquals(
			existingGopY_DinhKem.getObjectId(), newGopY_DinhKem.getObjectId());
		Assert.assertEquals(
			existingGopY_DinhKem.getGhichu(), newGopY_DinhKem.getGhichu());
		Assert.assertEquals(
			existingGopY_DinhKem.getDaxoa(), newGopY_DinhKem.getDaxoa());
		Assert.assertEquals(
			existingGopY_DinhKem.getStatus(), newGopY_DinhKem.getStatus());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		GopY_DinhKem newGopY_DinhKem = addGopY_DinhKem();

		GopY_DinhKem existingGopY_DinhKem = _persistence.findByPrimaryKey(
			newGopY_DinhKem.getPrimaryKey());

		Assert.assertEquals(existingGopY_DinhKem, newGopY_DinhKem);
	}

	@Test(expected = NoSuchGopY_DinhKemException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<GopY_DinhKem> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_gopy_dinhkemfile", "id", true, "companyId", true, "groupId",
			true, "userId", true, "ten", true, "url", true, "Object", true,
			"ObjectId", true, "ghichu", true, "daxoa", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		GopY_DinhKem newGopY_DinhKem = addGopY_DinhKem();

		GopY_DinhKem existingGopY_DinhKem = _persistence.fetchByPrimaryKey(
			newGopY_DinhKem.getPrimaryKey());

		Assert.assertEquals(existingGopY_DinhKem, newGopY_DinhKem);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		GopY_DinhKem missingGopY_DinhKem = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingGopY_DinhKem);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		GopY_DinhKem newGopY_DinhKem1 = addGopY_DinhKem();
		GopY_DinhKem newGopY_DinhKem2 = addGopY_DinhKem();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGopY_DinhKem1.getPrimaryKey());
		primaryKeys.add(newGopY_DinhKem2.getPrimaryKey());

		Map<Serializable, GopY_DinhKem> gopY_DinhKems =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, gopY_DinhKems.size());
		Assert.assertEquals(
			newGopY_DinhKem1,
			gopY_DinhKems.get(newGopY_DinhKem1.getPrimaryKey()));
		Assert.assertEquals(
			newGopY_DinhKem2,
			gopY_DinhKems.get(newGopY_DinhKem2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, GopY_DinhKem> gopY_DinhKems =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(gopY_DinhKems.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		GopY_DinhKem newGopY_DinhKem = addGopY_DinhKem();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGopY_DinhKem.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, GopY_DinhKem> gopY_DinhKems =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, gopY_DinhKems.size());
		Assert.assertEquals(
			newGopY_DinhKem,
			gopY_DinhKems.get(newGopY_DinhKem.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, GopY_DinhKem> gopY_DinhKems =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(gopY_DinhKems.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		GopY_DinhKem newGopY_DinhKem = addGopY_DinhKem();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGopY_DinhKem.getPrimaryKey());

		Map<Serializable, GopY_DinhKem> gopY_DinhKems =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, gopY_DinhKems.size());
		Assert.assertEquals(
			newGopY_DinhKem,
			gopY_DinhKems.get(newGopY_DinhKem.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			GopY_DinhKemLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<GopY_DinhKem>() {

				@Override
				public void performAction(GopY_DinhKem gopY_DinhKem) {
					Assert.assertNotNull(gopY_DinhKem);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		GopY_DinhKem newGopY_DinhKem = addGopY_DinhKem();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			GopY_DinhKem.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newGopY_DinhKem.getId()));

		List<GopY_DinhKem> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		GopY_DinhKem existingGopY_DinhKem = result.get(0);

		Assert.assertEquals(existingGopY_DinhKem, newGopY_DinhKem);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			GopY_DinhKem.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<GopY_DinhKem> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		GopY_DinhKem newGopY_DinhKem = addGopY_DinhKem();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			GopY_DinhKem.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newGopY_DinhKem.getId();

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
			GopY_DinhKem.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected GopY_DinhKem addGopY_DinhKem() throws Exception {
		long pk = RandomTestUtil.nextLong();

		GopY_DinhKem gopY_DinhKem = _persistence.create(pk);

		gopY_DinhKem.setCompanyId(RandomTestUtil.nextLong());

		gopY_DinhKem.setGroupId(RandomTestUtil.nextLong());

		gopY_DinhKem.setUserId(RandomTestUtil.nextLong());

		gopY_DinhKem.setTen(RandomTestUtil.randomString());

		gopY_DinhKem.setUrl(RandomTestUtil.randomString());

		gopY_DinhKem.setObject(RandomTestUtil.nextLong());

		gopY_DinhKem.setObjectId(RandomTestUtil.nextLong());

		gopY_DinhKem.setGhichu(RandomTestUtil.randomString());

		gopY_DinhKem.setDaxoa(RandomTestUtil.nextInt());

		gopY_DinhKem.setStatus(RandomTestUtil.nextInt());

		_gopY_DinhKems.add(_persistence.update(gopY_DinhKem));

		return gopY_DinhKem;
	}

	private List<GopY_DinhKem> _gopY_DinhKems = new ArrayList<GopY_DinhKem>();
	private GopY_DinhKemPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}