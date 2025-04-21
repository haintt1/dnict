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

import vn.dnict.qlquangcao.exception.NoSuchNhomKHException;
import vn.dnict.qlquangcao.model.NhomKH;
import vn.dnict.qlquangcao.service.NhomKHLocalServiceUtil;
import vn.dnict.qlquangcao.service.persistence.NhomKHPersistence;
import vn.dnict.qlquangcao.service.persistence.NhomKHUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class NhomKHPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlquangcao.service"));

	@Before
	public void setUp() {
		_persistence = NhomKHUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<NhomKH> iterator = _nhomKHs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhomKH nhomKH = _persistence.create(pk);

		Assert.assertNotNull(nhomKH);

		Assert.assertEquals(nhomKH.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		NhomKH newNhomKH = addNhomKH();

		_persistence.remove(newNhomKH);

		NhomKH existingNhomKH = _persistence.fetchByPrimaryKey(
			newNhomKH.getPrimaryKey());

		Assert.assertNull(existingNhomKH);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addNhomKH();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhomKH newNhomKH = _persistence.create(pk);

		newNhomKH.setCompanyId(RandomTestUtil.nextLong());

		newNhomKH.setGroupId(RandomTestUtil.nextLong());

		newNhomKH.setNguoitao(RandomTestUtil.nextLong());

		newNhomKH.setTen(RandomTestUtil.randomString());

		newNhomKH.setNguoidaidien(RandomTestUtil.randomString());

		newNhomKH.setLogo(RandomTestUtil.randomString());

		newNhomKH.setMota(RandomTestUtil.randomString());

		newNhomKH.setDiachi(RandomTestUtil.randomString());

		newNhomKH.setSdt(RandomTestUtil.randomString());

		newNhomKH.setEmail(RandomTestUtil.randomString());

		newNhomKH.setNgaytao(RandomTestUtil.nextDate());

		newNhomKH.setDaxoa(RandomTestUtil.nextInt());

		newNhomKH.setTrangthai(RandomTestUtil.nextInt());

		newNhomKH.setNgaysua(RandomTestUtil.nextDate());

		_nhomKHs.add(_persistence.update(newNhomKH));

		NhomKH existingNhomKH = _persistence.findByPrimaryKey(
			newNhomKH.getPrimaryKey());

		Assert.assertEquals(existingNhomKH.getId(), newNhomKH.getId());
		Assert.assertEquals(
			existingNhomKH.getCompanyId(), newNhomKH.getCompanyId());
		Assert.assertEquals(
			existingNhomKH.getGroupId(), newNhomKH.getGroupId());
		Assert.assertEquals(
			existingNhomKH.getNguoitao(), newNhomKH.getNguoitao());
		Assert.assertEquals(existingNhomKH.getTen(), newNhomKH.getTen());
		Assert.assertEquals(
			existingNhomKH.getNguoidaidien(), newNhomKH.getNguoidaidien());
		Assert.assertEquals(existingNhomKH.getLogo(), newNhomKH.getLogo());
		Assert.assertEquals(existingNhomKH.getMota(), newNhomKH.getMota());
		Assert.assertEquals(existingNhomKH.getDiachi(), newNhomKH.getDiachi());
		Assert.assertEquals(existingNhomKH.getSdt(), newNhomKH.getSdt());
		Assert.assertEquals(existingNhomKH.getEmail(), newNhomKH.getEmail());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNhomKH.getNgaytao()),
			Time.getShortTimestamp(newNhomKH.getNgaytao()));
		Assert.assertEquals(existingNhomKH.getDaxoa(), newNhomKH.getDaxoa());
		Assert.assertEquals(
			existingNhomKH.getTrangthai(), newNhomKH.getTrangthai());
		Assert.assertEquals(
			Time.getShortTimestamp(existingNhomKH.getNgaysua()),
			Time.getShortTimestamp(newNhomKH.getNgaysua()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		NhomKH newNhomKH = addNhomKH();

		NhomKH existingNhomKH = _persistence.findByPrimaryKey(
			newNhomKH.getPrimaryKey());

		Assert.assertEquals(existingNhomKH, newNhomKH);
	}

	@Test(expected = NoSuchNhomKHException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<NhomKH> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_quangcao_nhomkhachhang", "id", true, "companyId", true,
			"groupId", true, "nguoitao", true, "ten", true, "nguoidaidien",
			true, "logo", true, "mota", true, "diachi", true, "sdt", true,
			"email", true, "ngaytao", true, "daxoa", true, "trangthai", true,
			"ngaysua", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		NhomKH newNhomKH = addNhomKH();

		NhomKH existingNhomKH = _persistence.fetchByPrimaryKey(
			newNhomKH.getPrimaryKey());

		Assert.assertEquals(existingNhomKH, newNhomKH);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhomKH missingNhomKH = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingNhomKH);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		NhomKH newNhomKH1 = addNhomKH();
		NhomKH newNhomKH2 = addNhomKH();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhomKH1.getPrimaryKey());
		primaryKeys.add(newNhomKH2.getPrimaryKey());

		Map<Serializable, NhomKH> nhomKHs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, nhomKHs.size());
		Assert.assertEquals(
			newNhomKH1, nhomKHs.get(newNhomKH1.getPrimaryKey()));
		Assert.assertEquals(
			newNhomKH2, nhomKHs.get(newNhomKH2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, NhomKH> nhomKHs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(nhomKHs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		NhomKH newNhomKH = addNhomKH();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhomKH.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, NhomKH> nhomKHs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, nhomKHs.size());
		Assert.assertEquals(newNhomKH, nhomKHs.get(newNhomKH.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, NhomKH> nhomKHs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(nhomKHs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		NhomKH newNhomKH = addNhomKH();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newNhomKH.getPrimaryKey());

		Map<Serializable, NhomKH> nhomKHs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, nhomKHs.size());
		Assert.assertEquals(newNhomKH, nhomKHs.get(newNhomKH.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			NhomKHLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<NhomKH>() {

				@Override
				public void performAction(NhomKH nhomKH) {
					Assert.assertNotNull(nhomKH);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		NhomKH newNhomKH = addNhomKH();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhomKH.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newNhomKH.getId()));

		List<NhomKH> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		NhomKH existingNhomKH = result.get(0);

		Assert.assertEquals(existingNhomKH, newNhomKH);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhomKH.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<NhomKH> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		NhomKH newNhomKH = addNhomKH();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			NhomKH.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newNhomKH.getId();

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
			NhomKH.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected NhomKH addNhomKH() throws Exception {
		long pk = RandomTestUtil.nextLong();

		NhomKH nhomKH = _persistence.create(pk);

		nhomKH.setCompanyId(RandomTestUtil.nextLong());

		nhomKH.setGroupId(RandomTestUtil.nextLong());

		nhomKH.setNguoitao(RandomTestUtil.nextLong());

		nhomKH.setTen(RandomTestUtil.randomString());

		nhomKH.setNguoidaidien(RandomTestUtil.randomString());

		nhomKH.setLogo(RandomTestUtil.randomString());

		nhomKH.setMota(RandomTestUtil.randomString());

		nhomKH.setDiachi(RandomTestUtil.randomString());

		nhomKH.setSdt(RandomTestUtil.randomString());

		nhomKH.setEmail(RandomTestUtil.randomString());

		nhomKH.setNgaytao(RandomTestUtil.nextDate());

		nhomKH.setDaxoa(RandomTestUtil.nextInt());

		nhomKH.setTrangthai(RandomTestUtil.nextInt());

		nhomKH.setNgaysua(RandomTestUtil.nextDate());

		_nhomKHs.add(_persistence.update(nhomKH));

		return nhomKH;
	}

	private List<NhomKH> _nhomKHs = new ArrayList<NhomKH>();
	private NhomKHPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}