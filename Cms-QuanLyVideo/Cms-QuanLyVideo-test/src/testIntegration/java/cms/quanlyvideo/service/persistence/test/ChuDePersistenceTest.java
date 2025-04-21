/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence.test;

import cms.quanlyvideo.exception.NoSuchChuDeException;
import cms.quanlyvideo.model.ChuDe;
import cms.quanlyvideo.service.ChuDeLocalServiceUtil;
import cms.quanlyvideo.service.persistence.ChuDePersistence;
import cms.quanlyvideo.service.persistence.ChuDeUtil;

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

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ChuDePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cms.quanlyvideo.service"));

	@Before
	public void setUp() {
		_persistence = ChuDeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ChuDe> iterator = _chuDes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChuDe chuDe = _persistence.create(pk);

		Assert.assertNotNull(chuDe);

		Assert.assertEquals(chuDe.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ChuDe newChuDe = addChuDe();

		_persistence.remove(newChuDe);

		ChuDe existingChuDe = _persistence.fetchByPrimaryKey(
			newChuDe.getPrimaryKey());

		Assert.assertNull(existingChuDe);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addChuDe();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChuDe newChuDe = _persistence.create(pk);

		newChuDe.setGroupId(RandomTestUtil.nextLong());

		newChuDe.setCompanyId(RandomTestUtil.nextLong());

		newChuDe.setUserId(RandomTestUtil.nextLong());

		newChuDe.setTen(RandomTestUtil.randomString());

		newChuDe.setMoTa(RandomTestUtil.randomString());

		newChuDe.setTrangThai(RandomTestUtil.nextLong());

		newChuDe.setDaXoa(RandomTestUtil.nextLong());

		newChuDe.setNgayTao(RandomTestUtil.nextDate());

		newChuDe.setNgaySua(RandomTestUtil.nextDate());

		_chuDes.add(_persistence.update(newChuDe));

		ChuDe existingChuDe = _persistence.findByPrimaryKey(
			newChuDe.getPrimaryKey());

		Assert.assertEquals(existingChuDe.getId(), newChuDe.getId());
		Assert.assertEquals(existingChuDe.getGroupId(), newChuDe.getGroupId());
		Assert.assertEquals(
			existingChuDe.getCompanyId(), newChuDe.getCompanyId());
		Assert.assertEquals(existingChuDe.getUserId(), newChuDe.getUserId());
		Assert.assertEquals(existingChuDe.getTen(), newChuDe.getTen());
		Assert.assertEquals(existingChuDe.getMoTa(), newChuDe.getMoTa());
		Assert.assertEquals(
			existingChuDe.getTrangThai(), newChuDe.getTrangThai());
		Assert.assertEquals(existingChuDe.getDaXoa(), newChuDe.getDaXoa());
		Assert.assertEquals(
			Time.getShortTimestamp(existingChuDe.getNgayTao()),
			Time.getShortTimestamp(newChuDe.getNgayTao()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingChuDe.getNgaySua()),
			Time.getShortTimestamp(newChuDe.getNgaySua()));
	}

	@Test
	public void testCountByten() throws Exception {
		_persistence.countByten("");

		_persistence.countByten("null");

		_persistence.countByten((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ChuDe newChuDe = addChuDe();

		ChuDe existingChuDe = _persistence.findByPrimaryKey(
			newChuDe.getPrimaryKey());

		Assert.assertEquals(existingChuDe, newChuDe);
	}

	@Test(expected = NoSuchChuDeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ChuDe> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Cms_quanlyvideo_chude", "id", true, "groupId", true, "companyId",
			true, "userId", true, "ten", true, "moTa", true, "trangThai", true,
			"daXoa", true, "ngayTao", true, "ngaySua", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ChuDe newChuDe = addChuDe();

		ChuDe existingChuDe = _persistence.fetchByPrimaryKey(
			newChuDe.getPrimaryKey());

		Assert.assertEquals(existingChuDe, newChuDe);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChuDe missingChuDe = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingChuDe);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ChuDe newChuDe1 = addChuDe();
		ChuDe newChuDe2 = addChuDe();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChuDe1.getPrimaryKey());
		primaryKeys.add(newChuDe2.getPrimaryKey());

		Map<Serializable, ChuDe> chuDes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, chuDes.size());
		Assert.assertEquals(newChuDe1, chuDes.get(newChuDe1.getPrimaryKey()));
		Assert.assertEquals(newChuDe2, chuDes.get(newChuDe2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ChuDe> chuDes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(chuDes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ChuDe newChuDe = addChuDe();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChuDe.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ChuDe> chuDes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, chuDes.size());
		Assert.assertEquals(newChuDe, chuDes.get(newChuDe.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ChuDe> chuDes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(chuDes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ChuDe newChuDe = addChuDe();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChuDe.getPrimaryKey());

		Map<Serializable, ChuDe> chuDes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, chuDes.size());
		Assert.assertEquals(newChuDe, chuDes.get(newChuDe.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ChuDeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ChuDe>() {

				@Override
				public void performAction(ChuDe chuDe) {
					Assert.assertNotNull(chuDe);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ChuDe newChuDe = addChuDe();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ChuDe.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newChuDe.getId()));

		List<ChuDe> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		ChuDe existingChuDe = result.get(0);

		Assert.assertEquals(existingChuDe, newChuDe);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ChuDe.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<ChuDe> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ChuDe newChuDe = addChuDe();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ChuDe.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newChuDe.getId();

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
			ChuDe.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ChuDe addChuDe() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChuDe chuDe = _persistence.create(pk);

		chuDe.setGroupId(RandomTestUtil.nextLong());

		chuDe.setCompanyId(RandomTestUtil.nextLong());

		chuDe.setUserId(RandomTestUtil.nextLong());

		chuDe.setTen(RandomTestUtil.randomString());

		chuDe.setMoTa(RandomTestUtil.randomString());

		chuDe.setTrangThai(RandomTestUtil.nextLong());

		chuDe.setDaXoa(RandomTestUtil.nextLong());

		chuDe.setNgayTao(RandomTestUtil.nextDate());

		chuDe.setNgaySua(RandomTestUtil.nextDate());

		_chuDes.add(_persistence.update(chuDe));

		return chuDe;
	}

	private List<ChuDe> _chuDes = new ArrayList<ChuDe>();
	private ChuDePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}