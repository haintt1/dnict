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

import vn.dnict.qlgopy.exception.NoSuchmaiThongBaoException;
import vn.dnict.qlgopy.model.maiThongBao;
import vn.dnict.qlgopy.service.maiThongBaoLocalServiceUtil;
import vn.dnict.qlgopy.service.persistence.maiThongBaoPersistence;
import vn.dnict.qlgopy.service.persistence.maiThongBaoUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class maiThongBaoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlgopy.service"));

	@Before
	public void setUp() {
		_persistence = maiThongBaoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<maiThongBao> iterator = _maiThongBaos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		maiThongBao maiThongBao = _persistence.create(pk);

		Assert.assertNotNull(maiThongBao);

		Assert.assertEquals(maiThongBao.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		maiThongBao newmaiThongBao = addmaiThongBao();

		_persistence.remove(newmaiThongBao);

		maiThongBao existingmaiThongBao = _persistence.fetchByPrimaryKey(
			newmaiThongBao.getPrimaryKey());

		Assert.assertNull(existingmaiThongBao);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addmaiThongBao();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		maiThongBao newmaiThongBao = _persistence.create(pk);

		newmaiThongBao.setCompanyId(RandomTestUtil.nextLong());

		newmaiThongBao.setGroupId(RandomTestUtil.nextLong());

		newmaiThongBao.setTen(RandomTestUtil.randomString());

		newmaiThongBao.setPhone(RandomTestUtil.randomString());

		newmaiThongBao.setEmail(RandomTestUtil.randomString());

		_maiThongBaos.add(_persistence.update(newmaiThongBao));

		maiThongBao existingmaiThongBao = _persistence.findByPrimaryKey(
			newmaiThongBao.getPrimaryKey());

		Assert.assertEquals(
			existingmaiThongBao.getId(), newmaiThongBao.getId());
		Assert.assertEquals(
			existingmaiThongBao.getCompanyId(), newmaiThongBao.getCompanyId());
		Assert.assertEquals(
			existingmaiThongBao.getGroupId(), newmaiThongBao.getGroupId());
		Assert.assertEquals(
			existingmaiThongBao.getTen(), newmaiThongBao.getTen());
		Assert.assertEquals(
			existingmaiThongBao.getPhone(), newmaiThongBao.getPhone());
		Assert.assertEquals(
			existingmaiThongBao.getEmail(), newmaiThongBao.getEmail());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		maiThongBao newmaiThongBao = addmaiThongBao();

		maiThongBao existingmaiThongBao = _persistence.findByPrimaryKey(
			newmaiThongBao.getPrimaryKey());

		Assert.assertEquals(existingmaiThongBao, newmaiThongBao);
	}

	@Test(expected = NoSuchmaiThongBaoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<maiThongBao> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_gopy_mailthongbao", "id", true, "companyId", true, "groupId",
			true, "ten", true, "phone", true, "email", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		maiThongBao newmaiThongBao = addmaiThongBao();

		maiThongBao existingmaiThongBao = _persistence.fetchByPrimaryKey(
			newmaiThongBao.getPrimaryKey());

		Assert.assertEquals(existingmaiThongBao, newmaiThongBao);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		maiThongBao missingmaiThongBao = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingmaiThongBao);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		maiThongBao newmaiThongBao1 = addmaiThongBao();
		maiThongBao newmaiThongBao2 = addmaiThongBao();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newmaiThongBao1.getPrimaryKey());
		primaryKeys.add(newmaiThongBao2.getPrimaryKey());

		Map<Serializable, maiThongBao> maiThongBaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, maiThongBaos.size());
		Assert.assertEquals(
			newmaiThongBao1, maiThongBaos.get(newmaiThongBao1.getPrimaryKey()));
		Assert.assertEquals(
			newmaiThongBao2, maiThongBaos.get(newmaiThongBao2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, maiThongBao> maiThongBaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(maiThongBaos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		maiThongBao newmaiThongBao = addmaiThongBao();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newmaiThongBao.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, maiThongBao> maiThongBaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, maiThongBaos.size());
		Assert.assertEquals(
			newmaiThongBao, maiThongBaos.get(newmaiThongBao.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, maiThongBao> maiThongBaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(maiThongBaos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		maiThongBao newmaiThongBao = addmaiThongBao();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newmaiThongBao.getPrimaryKey());

		Map<Serializable, maiThongBao> maiThongBaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, maiThongBaos.size());
		Assert.assertEquals(
			newmaiThongBao, maiThongBaos.get(newmaiThongBao.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			maiThongBaoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<maiThongBao>() {

				@Override
				public void performAction(maiThongBao maiThongBao) {
					Assert.assertNotNull(maiThongBao);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		maiThongBao newmaiThongBao = addmaiThongBao();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			maiThongBao.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newmaiThongBao.getId()));

		List<maiThongBao> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		maiThongBao existingmaiThongBao = result.get(0);

		Assert.assertEquals(existingmaiThongBao, newmaiThongBao);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			maiThongBao.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<maiThongBao> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		maiThongBao newmaiThongBao = addmaiThongBao();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			maiThongBao.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newmaiThongBao.getId();

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
			maiThongBao.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected maiThongBao addmaiThongBao() throws Exception {
		long pk = RandomTestUtil.nextLong();

		maiThongBao maiThongBao = _persistence.create(pk);

		maiThongBao.setCompanyId(RandomTestUtil.nextLong());

		maiThongBao.setGroupId(RandomTestUtil.nextLong());

		maiThongBao.setTen(RandomTestUtil.randomString());

		maiThongBao.setPhone(RandomTestUtil.randomString());

		maiThongBao.setEmail(RandomTestUtil.randomString());

		_maiThongBaos.add(_persistence.update(maiThongBao));

		return maiThongBao;
	}

	private List<maiThongBao> _maiThongBaos = new ArrayList<maiThongBao>();
	private maiThongBaoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}