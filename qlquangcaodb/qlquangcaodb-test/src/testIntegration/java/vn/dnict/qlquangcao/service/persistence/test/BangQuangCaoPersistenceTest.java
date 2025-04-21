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

import vn.dnict.qlquangcao.exception.NoSuchBangQuangCaoException;
import vn.dnict.qlquangcao.model.BangQuangCao;
import vn.dnict.qlquangcao.service.BangQuangCaoLocalServiceUtil;
import vn.dnict.qlquangcao.service.persistence.BangQuangCaoPersistence;
import vn.dnict.qlquangcao.service.persistence.BangQuangCaoUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class BangQuangCaoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlquangcao.service"));

	@Before
	public void setUp() {
		_persistence = BangQuangCaoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<BangQuangCao> iterator = _bangQuangCaos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BangQuangCao bangQuangCao = _persistence.create(pk);

		Assert.assertNotNull(bangQuangCao);

		Assert.assertEquals(bangQuangCao.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		BangQuangCao newBangQuangCao = addBangQuangCao();

		_persistence.remove(newBangQuangCao);

		BangQuangCao existingBangQuangCao = _persistence.fetchByPrimaryKey(
			newBangQuangCao.getPrimaryKey());

		Assert.assertNull(existingBangQuangCao);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBangQuangCao();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BangQuangCao newBangQuangCao = _persistence.create(pk);

		newBangQuangCao.setCompanyId(RandomTestUtil.nextLong());

		newBangQuangCao.setGroupId(RandomTestUtil.nextLong());

		newBangQuangCao.setNguoitao(RandomTestUtil.nextLong());

		newBangQuangCao.setTen(RandomTestUtil.randomString());

		newBangQuangCao.setDuongdan(RandomTestUtil.randomString());

		newBangQuangCao.setLienket(RandomTestUtil.randomString());

		newBangQuangCao.setNhomKH(RandomTestUtil.nextLong());

		newBangQuangCao.setVitriQC(RandomTestUtil.nextLong());

		newBangQuangCao.setNgaytao(RandomTestUtil.nextDate());

		newBangQuangCao.setNgayketthuc(RandomTestUtil.nextDate());

		newBangQuangCao.setDaxoa(RandomTestUtil.nextInt());

		newBangQuangCao.setTrangthai(RandomTestUtil.nextInt());

		newBangQuangCao.setTrangthaisudung(RandomTestUtil.nextInt());

		newBangQuangCao.setNgaysua(RandomTestUtil.nextDate());

		_bangQuangCaos.add(_persistence.update(newBangQuangCao));

		BangQuangCao existingBangQuangCao = _persistence.findByPrimaryKey(
			newBangQuangCao.getPrimaryKey());

		Assert.assertEquals(
			existingBangQuangCao.getId(), newBangQuangCao.getId());
		Assert.assertEquals(
			existingBangQuangCao.getCompanyId(),
			newBangQuangCao.getCompanyId());
		Assert.assertEquals(
			existingBangQuangCao.getGroupId(), newBangQuangCao.getGroupId());
		Assert.assertEquals(
			existingBangQuangCao.getNguoitao(), newBangQuangCao.getNguoitao());
		Assert.assertEquals(
			existingBangQuangCao.getTen(), newBangQuangCao.getTen());
		Assert.assertEquals(
			existingBangQuangCao.getDuongdan(), newBangQuangCao.getDuongdan());
		Assert.assertEquals(
			existingBangQuangCao.getLienket(), newBangQuangCao.getLienket());
		Assert.assertEquals(
			existingBangQuangCao.getNhomKH(), newBangQuangCao.getNhomKH());
		Assert.assertEquals(
			existingBangQuangCao.getVitriQC(), newBangQuangCao.getVitriQC());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBangQuangCao.getNgaytao()),
			Time.getShortTimestamp(newBangQuangCao.getNgaytao()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingBangQuangCao.getNgayketthuc()),
			Time.getShortTimestamp(newBangQuangCao.getNgayketthuc()));
		Assert.assertEquals(
			existingBangQuangCao.getDaxoa(), newBangQuangCao.getDaxoa());
		Assert.assertEquals(
			existingBangQuangCao.getTrangthai(),
			newBangQuangCao.getTrangthai());
		Assert.assertEquals(
			existingBangQuangCao.getTrangthaisudung(),
			newBangQuangCao.getTrangthaisudung());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBangQuangCao.getNgaysua()),
			Time.getShortTimestamp(newBangQuangCao.getNgaysua()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		BangQuangCao newBangQuangCao = addBangQuangCao();

		BangQuangCao existingBangQuangCao = _persistence.findByPrimaryKey(
			newBangQuangCao.getPrimaryKey());

		Assert.assertEquals(existingBangQuangCao, newBangQuangCao);
	}

	@Test(expected = NoSuchBangQuangCaoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<BangQuangCao> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_quangcao_banner", "id", true, "companyId", true, "groupId",
			true, "nguoitao", true, "ten", true, "duongdan", true, "lienket",
			true, "nhomKH", true, "vitriQC", true, "ngaytao", true,
			"ngayketthuc", true, "daxoa", true, "trangthai", true,
			"trangthaisudung", true, "ngaysua", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		BangQuangCao newBangQuangCao = addBangQuangCao();

		BangQuangCao existingBangQuangCao = _persistence.fetchByPrimaryKey(
			newBangQuangCao.getPrimaryKey());

		Assert.assertEquals(existingBangQuangCao, newBangQuangCao);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BangQuangCao missingBangQuangCao = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBangQuangCao);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		BangQuangCao newBangQuangCao1 = addBangQuangCao();
		BangQuangCao newBangQuangCao2 = addBangQuangCao();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBangQuangCao1.getPrimaryKey());
		primaryKeys.add(newBangQuangCao2.getPrimaryKey());

		Map<Serializable, BangQuangCao> bangQuangCaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, bangQuangCaos.size());
		Assert.assertEquals(
			newBangQuangCao1,
			bangQuangCaos.get(newBangQuangCao1.getPrimaryKey()));
		Assert.assertEquals(
			newBangQuangCao2,
			bangQuangCaos.get(newBangQuangCao2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, BangQuangCao> bangQuangCaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bangQuangCaos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		BangQuangCao newBangQuangCao = addBangQuangCao();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBangQuangCao.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, BangQuangCao> bangQuangCaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bangQuangCaos.size());
		Assert.assertEquals(
			newBangQuangCao,
			bangQuangCaos.get(newBangQuangCao.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, BangQuangCao> bangQuangCaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bangQuangCaos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		BangQuangCao newBangQuangCao = addBangQuangCao();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBangQuangCao.getPrimaryKey());

		Map<Serializable, BangQuangCao> bangQuangCaos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bangQuangCaos.size());
		Assert.assertEquals(
			newBangQuangCao,
			bangQuangCaos.get(newBangQuangCao.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			BangQuangCaoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<BangQuangCao>() {

				@Override
				public void performAction(BangQuangCao bangQuangCao) {
					Assert.assertNotNull(bangQuangCao);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		BangQuangCao newBangQuangCao = addBangQuangCao();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BangQuangCao.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newBangQuangCao.getId()));

		List<BangQuangCao> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		BangQuangCao existingBangQuangCao = result.get(0);

		Assert.assertEquals(existingBangQuangCao, newBangQuangCao);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BangQuangCao.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<BangQuangCao> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		BangQuangCao newBangQuangCao = addBangQuangCao();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BangQuangCao.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newBangQuangCao.getId();

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
			BangQuangCao.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected BangQuangCao addBangQuangCao() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BangQuangCao bangQuangCao = _persistence.create(pk);

		bangQuangCao.setCompanyId(RandomTestUtil.nextLong());

		bangQuangCao.setGroupId(RandomTestUtil.nextLong());

		bangQuangCao.setNguoitao(RandomTestUtil.nextLong());

		bangQuangCao.setTen(RandomTestUtil.randomString());

		bangQuangCao.setDuongdan(RandomTestUtil.randomString());

		bangQuangCao.setLienket(RandomTestUtil.randomString());

		bangQuangCao.setNhomKH(RandomTestUtil.nextLong());

		bangQuangCao.setVitriQC(RandomTestUtil.nextLong());

		bangQuangCao.setNgaytao(RandomTestUtil.nextDate());

		bangQuangCao.setNgayketthuc(RandomTestUtil.nextDate());

		bangQuangCao.setDaxoa(RandomTestUtil.nextInt());

		bangQuangCao.setTrangthai(RandomTestUtil.nextInt());

		bangQuangCao.setTrangthaisudung(RandomTestUtil.nextInt());

		bangQuangCao.setNgaysua(RandomTestUtil.nextDate());

		_bangQuangCaos.add(_persistence.update(bangQuangCao));

		return bangQuangCao;
	}

	private List<BangQuangCao> _bangQuangCaos = new ArrayList<BangQuangCao>();
	private BangQuangCaoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}