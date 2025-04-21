/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service.persistence.test;

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

import vn.dnict.qlquangcao.exception.NoSuchViTriDanhMucException;
import vn.dnict.qlquangcao.model.ViTriDanhMuc;
import vn.dnict.qlquangcao.service.ViTriDanhMucLocalServiceUtil;
import vn.dnict.qlquangcao.service.persistence.ViTriDanhMucPersistence;
import vn.dnict.qlquangcao.service.persistence.ViTriDanhMucUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ViTriDanhMucPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlquangcao.service"));

	@Before
	public void setUp() {
		_persistence = ViTriDanhMucUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ViTriDanhMuc> iterator = _viTriDanhMucs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ViTriDanhMuc viTriDanhMuc = _persistence.create(pk);

		Assert.assertNotNull(viTriDanhMuc);

		Assert.assertEquals(viTriDanhMuc.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ViTriDanhMuc newViTriDanhMuc = addViTriDanhMuc();

		_persistence.remove(newViTriDanhMuc);

		ViTriDanhMuc existingViTriDanhMuc = _persistence.fetchByPrimaryKey(
			newViTriDanhMuc.getPrimaryKey());

		Assert.assertNull(existingViTriDanhMuc);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addViTriDanhMuc();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ViTriDanhMuc newViTriDanhMuc = _persistence.create(pk);

		newViTriDanhMuc.setCompanyId(RandomTestUtil.nextLong());

		newViTriDanhMuc.setGroupId(RandomTestUtil.nextLong());

		newViTriDanhMuc.setNguoitao(RandomTestUtil.nextLong());

		newViTriDanhMuc.setTen(RandomTestUtil.randomString());

		newViTriDanhMuc.setCssClass(RandomTestUtil.randomString());

		newViTriDanhMuc.setKichthuoc(RandomTestUtil.randomString());

		newViTriDanhMuc.setNgaytao(RandomTestUtil.nextDate());

		newViTriDanhMuc.setDaxoa(RandomTestUtil.nextInt());

		newViTriDanhMuc.setTrangthai(RandomTestUtil.nextInt());

		newViTriDanhMuc.setNgaysua(RandomTestUtil.nextDate());

		_viTriDanhMucs.add(_persistence.update(newViTriDanhMuc));

		ViTriDanhMuc existingViTriDanhMuc = _persistence.findByPrimaryKey(
			newViTriDanhMuc.getPrimaryKey());

		Assert.assertEquals(
			existingViTriDanhMuc.getId(), newViTriDanhMuc.getId());
		Assert.assertEquals(
			existingViTriDanhMuc.getCompanyId(),
			newViTriDanhMuc.getCompanyId());
		Assert.assertEquals(
			existingViTriDanhMuc.getGroupId(), newViTriDanhMuc.getGroupId());
		Assert.assertEquals(
			existingViTriDanhMuc.getNguoitao(), newViTriDanhMuc.getNguoitao());
		Assert.assertEquals(
			existingViTriDanhMuc.getTen(), newViTriDanhMuc.getTen());
		Assert.assertEquals(
			existingViTriDanhMuc.getCssClass(), newViTriDanhMuc.getCssClass());
		Assert.assertEquals(
			existingViTriDanhMuc.getKichthuoc(),
			newViTriDanhMuc.getKichthuoc());
		Assert.assertEquals(
			Time.getShortTimestamp(existingViTriDanhMuc.getNgaytao()),
			Time.getShortTimestamp(newViTriDanhMuc.getNgaytao()));
		Assert.assertEquals(
			existingViTriDanhMuc.getDaxoa(), newViTriDanhMuc.getDaxoa());
		Assert.assertEquals(
			existingViTriDanhMuc.getTrangthai(),
			newViTriDanhMuc.getTrangthai());
		Assert.assertEquals(
			Time.getShortTimestamp(existingViTriDanhMuc.getNgaysua()),
			Time.getShortTimestamp(newViTriDanhMuc.getNgaysua()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ViTriDanhMuc newViTriDanhMuc = addViTriDanhMuc();

		ViTriDanhMuc existingViTriDanhMuc = _persistence.findByPrimaryKey(
			newViTriDanhMuc.getPrimaryKey());

		Assert.assertEquals(existingViTriDanhMuc, newViTriDanhMuc);
	}

	@Test(expected = NoSuchViTriDanhMucException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ViTriDanhMuc> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_quangcao_vitridanhmuc", "id", true, "companyId", true,
			"groupId", true, "nguoitao", true, "ten", true, "cssClass", true,
			"kichthuoc", true, "ngaytao", true, "daxoa", true, "trangthai",
			true, "ngaysua", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ViTriDanhMuc newViTriDanhMuc = addViTriDanhMuc();

		ViTriDanhMuc existingViTriDanhMuc = _persistence.fetchByPrimaryKey(
			newViTriDanhMuc.getPrimaryKey());

		Assert.assertEquals(existingViTriDanhMuc, newViTriDanhMuc);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ViTriDanhMuc missingViTriDanhMuc = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingViTriDanhMuc);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ViTriDanhMuc newViTriDanhMuc1 = addViTriDanhMuc();
		ViTriDanhMuc newViTriDanhMuc2 = addViTriDanhMuc();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newViTriDanhMuc1.getPrimaryKey());
		primaryKeys.add(newViTriDanhMuc2.getPrimaryKey());

		Map<Serializable, ViTriDanhMuc> viTriDanhMucs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, viTriDanhMucs.size());
		Assert.assertEquals(
			newViTriDanhMuc1,
			viTriDanhMucs.get(newViTriDanhMuc1.getPrimaryKey()));
		Assert.assertEquals(
			newViTriDanhMuc2,
			viTriDanhMucs.get(newViTriDanhMuc2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ViTriDanhMuc> viTriDanhMucs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(viTriDanhMucs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ViTriDanhMuc newViTriDanhMuc = addViTriDanhMuc();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newViTriDanhMuc.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ViTriDanhMuc> viTriDanhMucs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, viTriDanhMucs.size());
		Assert.assertEquals(
			newViTriDanhMuc,
			viTriDanhMucs.get(newViTriDanhMuc.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ViTriDanhMuc> viTriDanhMucs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(viTriDanhMucs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ViTriDanhMuc newViTriDanhMuc = addViTriDanhMuc();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newViTriDanhMuc.getPrimaryKey());

		Map<Serializable, ViTriDanhMuc> viTriDanhMucs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, viTriDanhMucs.size());
		Assert.assertEquals(
			newViTriDanhMuc,
			viTriDanhMucs.get(newViTriDanhMuc.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ViTriDanhMucLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ViTriDanhMuc>() {

				@Override
				public void performAction(ViTriDanhMuc viTriDanhMuc) {
					Assert.assertNotNull(viTriDanhMuc);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ViTriDanhMuc newViTriDanhMuc = addViTriDanhMuc();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ViTriDanhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newViTriDanhMuc.getId()));

		List<ViTriDanhMuc> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ViTriDanhMuc existingViTriDanhMuc = result.get(0);

		Assert.assertEquals(existingViTriDanhMuc, newViTriDanhMuc);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ViTriDanhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<ViTriDanhMuc> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ViTriDanhMuc newViTriDanhMuc = addViTriDanhMuc();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ViTriDanhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newViTriDanhMuc.getId();

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
			ViTriDanhMuc.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ViTriDanhMuc addViTriDanhMuc() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ViTriDanhMuc viTriDanhMuc = _persistence.create(pk);

		viTriDanhMuc.setCompanyId(RandomTestUtil.nextLong());

		viTriDanhMuc.setGroupId(RandomTestUtil.nextLong());

		viTriDanhMuc.setNguoitao(RandomTestUtil.nextLong());

		viTriDanhMuc.setTen(RandomTestUtil.randomString());

		viTriDanhMuc.setCssClass(RandomTestUtil.randomString());

		viTriDanhMuc.setKichthuoc(RandomTestUtil.randomString());

		viTriDanhMuc.setNgaytao(RandomTestUtil.nextDate());

		viTriDanhMuc.setDaxoa(RandomTestUtil.nextInt());

		viTriDanhMuc.setTrangthai(RandomTestUtil.nextInt());

		viTriDanhMuc.setNgaysua(RandomTestUtil.nextDate());

		_viTriDanhMucs.add(_persistence.update(viTriDanhMuc));

		return viTriDanhMuc;
	}

	private List<ViTriDanhMuc> _viTriDanhMucs = new ArrayList<ViTriDanhMuc>();
	private ViTriDanhMucPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}