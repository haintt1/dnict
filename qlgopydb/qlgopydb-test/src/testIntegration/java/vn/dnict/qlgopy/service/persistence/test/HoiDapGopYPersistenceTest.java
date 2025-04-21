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

import vn.dnict.qlgopy.exception.NoSuchHoiDapGopYException;
import vn.dnict.qlgopy.model.HoiDapGopY;
import vn.dnict.qlgopy.service.HoiDapGopYLocalServiceUtil;
import vn.dnict.qlgopy.service.persistence.HoiDapGopYPersistence;
import vn.dnict.qlgopy.service.persistence.HoiDapGopYUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class HoiDapGopYPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlgopy.service"));

	@Before
	public void setUp() {
		_persistence = HoiDapGopYUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<HoiDapGopY> iterator = _hoiDapGopYs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HoiDapGopY hoiDapGopY = _persistence.create(pk);

		Assert.assertNotNull(hoiDapGopY);

		Assert.assertEquals(hoiDapGopY.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		HoiDapGopY newHoiDapGopY = addHoiDapGopY();

		_persistence.remove(newHoiDapGopY);

		HoiDapGopY existingHoiDapGopY = _persistence.fetchByPrimaryKey(
			newHoiDapGopY.getPrimaryKey());

		Assert.assertNull(existingHoiDapGopY);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addHoiDapGopY();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HoiDapGopY newHoiDapGopY = _persistence.create(pk);

		newHoiDapGopY.setCompanyId(RandomTestUtil.nextLong());

		newHoiDapGopY.setGroupId(RandomTestUtil.nextLong());

		newHoiDapGopY.setName(RandomTestUtil.randomString());

		newHoiDapGopY.setTencoquan(RandomTestUtil.randomString());

		newHoiDapGopY.setPhone(RandomTestUtil.randomString());

		newHoiDapGopY.setEmail(RandomTestUtil.randomString());

		newHoiDapGopY.setTitle(RandomTestUtil.randomString());

		newHoiDapGopY.setContent(RandomTestUtil.randomString());

		newHoiDapGopY.setAnswer(RandomTestUtil.randomString());

		newHoiDapGopY.setNgay_guigopy(RandomTestUtil.nextDate());

		newHoiDapGopY.setNgay_traloigopy(RandomTestUtil.nextDate());

		newHoiDapGopY.setTypeForm(RandomTestUtil.nextInt());

		newHoiDapGopY.setIs_traloi(RandomTestUtil.nextInt());

		newHoiDapGopY.setIs_pheduyet(RandomTestUtil.nextInt());

		_hoiDapGopYs.add(_persistence.update(newHoiDapGopY));

		HoiDapGopY existingHoiDapGopY = _persistence.findByPrimaryKey(
			newHoiDapGopY.getPrimaryKey());

		Assert.assertEquals(existingHoiDapGopY.getId(), newHoiDapGopY.getId());
		Assert.assertEquals(
			existingHoiDapGopY.getCompanyId(), newHoiDapGopY.getCompanyId());
		Assert.assertEquals(
			existingHoiDapGopY.getGroupId(), newHoiDapGopY.getGroupId());
		Assert.assertEquals(
			existingHoiDapGopY.getName(), newHoiDapGopY.getName());
		Assert.assertEquals(
			existingHoiDapGopY.getTencoquan(), newHoiDapGopY.getTencoquan());
		Assert.assertEquals(
			existingHoiDapGopY.getPhone(), newHoiDapGopY.getPhone());
		Assert.assertEquals(
			existingHoiDapGopY.getEmail(), newHoiDapGopY.getEmail());
		Assert.assertEquals(
			existingHoiDapGopY.getTitle(), newHoiDapGopY.getTitle());
		Assert.assertEquals(
			existingHoiDapGopY.getContent(), newHoiDapGopY.getContent());
		Assert.assertEquals(
			existingHoiDapGopY.getAnswer(), newHoiDapGopY.getAnswer());
		Assert.assertEquals(
			Time.getShortTimestamp(existingHoiDapGopY.getNgay_guigopy()),
			Time.getShortTimestamp(newHoiDapGopY.getNgay_guigopy()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingHoiDapGopY.getNgay_traloigopy()),
			Time.getShortTimestamp(newHoiDapGopY.getNgay_traloigopy()));
		Assert.assertEquals(
			existingHoiDapGopY.getTypeForm(), newHoiDapGopY.getTypeForm());
		Assert.assertEquals(
			existingHoiDapGopY.getIs_traloi(), newHoiDapGopY.getIs_traloi());
		Assert.assertEquals(
			existingHoiDapGopY.getIs_pheduyet(),
			newHoiDapGopY.getIs_pheduyet());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		HoiDapGopY newHoiDapGopY = addHoiDapGopY();

		HoiDapGopY existingHoiDapGopY = _persistence.findByPrimaryKey(
			newHoiDapGopY.getPrimaryKey());

		Assert.assertEquals(existingHoiDapGopY, newHoiDapGopY);
	}

	@Test(expected = NoSuchHoiDapGopYException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<HoiDapGopY> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_gopy", "id", true, "companyId", true, "groupId", true, "name",
			true, "tencoquan", true, "phone", true, "email", true, "title",
			true, "content", true, "answer", true, "ngay_guigopy", true,
			"ngay_traloigopy", true, "typeForm", true, "is_traloi", true,
			"is_pheduyet", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		HoiDapGopY newHoiDapGopY = addHoiDapGopY();

		HoiDapGopY existingHoiDapGopY = _persistence.fetchByPrimaryKey(
			newHoiDapGopY.getPrimaryKey());

		Assert.assertEquals(existingHoiDapGopY, newHoiDapGopY);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HoiDapGopY missingHoiDapGopY = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingHoiDapGopY);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		HoiDapGopY newHoiDapGopY1 = addHoiDapGopY();
		HoiDapGopY newHoiDapGopY2 = addHoiDapGopY();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHoiDapGopY1.getPrimaryKey());
		primaryKeys.add(newHoiDapGopY2.getPrimaryKey());

		Map<Serializable, HoiDapGopY> hoiDapGopYs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, hoiDapGopYs.size());
		Assert.assertEquals(
			newHoiDapGopY1, hoiDapGopYs.get(newHoiDapGopY1.getPrimaryKey()));
		Assert.assertEquals(
			newHoiDapGopY2, hoiDapGopYs.get(newHoiDapGopY2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, HoiDapGopY> hoiDapGopYs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(hoiDapGopYs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		HoiDapGopY newHoiDapGopY = addHoiDapGopY();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHoiDapGopY.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, HoiDapGopY> hoiDapGopYs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, hoiDapGopYs.size());
		Assert.assertEquals(
			newHoiDapGopY, hoiDapGopYs.get(newHoiDapGopY.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, HoiDapGopY> hoiDapGopYs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(hoiDapGopYs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		HoiDapGopY newHoiDapGopY = addHoiDapGopY();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHoiDapGopY.getPrimaryKey());

		Map<Serializable, HoiDapGopY> hoiDapGopYs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, hoiDapGopYs.size());
		Assert.assertEquals(
			newHoiDapGopY, hoiDapGopYs.get(newHoiDapGopY.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			HoiDapGopYLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<HoiDapGopY>() {

				@Override
				public void performAction(HoiDapGopY hoiDapGopY) {
					Assert.assertNotNull(hoiDapGopY);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		HoiDapGopY newHoiDapGopY = addHoiDapGopY();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HoiDapGopY.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newHoiDapGopY.getId()));

		List<HoiDapGopY> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		HoiDapGopY existingHoiDapGopY = result.get(0);

		Assert.assertEquals(existingHoiDapGopY, newHoiDapGopY);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HoiDapGopY.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<HoiDapGopY> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		HoiDapGopY newHoiDapGopY = addHoiDapGopY();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			HoiDapGopY.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newHoiDapGopY.getId();

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
			HoiDapGopY.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected HoiDapGopY addHoiDapGopY() throws Exception {
		long pk = RandomTestUtil.nextLong();

		HoiDapGopY hoiDapGopY = _persistence.create(pk);

		hoiDapGopY.setCompanyId(RandomTestUtil.nextLong());

		hoiDapGopY.setGroupId(RandomTestUtil.nextLong());

		hoiDapGopY.setName(RandomTestUtil.randomString());

		hoiDapGopY.setTencoquan(RandomTestUtil.randomString());

		hoiDapGopY.setPhone(RandomTestUtil.randomString());

		hoiDapGopY.setEmail(RandomTestUtil.randomString());

		hoiDapGopY.setTitle(RandomTestUtil.randomString());

		hoiDapGopY.setContent(RandomTestUtil.randomString());

		hoiDapGopY.setAnswer(RandomTestUtil.randomString());

		hoiDapGopY.setNgay_guigopy(RandomTestUtil.nextDate());

		hoiDapGopY.setNgay_traloigopy(RandomTestUtil.nextDate());

		hoiDapGopY.setTypeForm(RandomTestUtil.nextInt());

		hoiDapGopY.setIs_traloi(RandomTestUtil.nextInt());

		hoiDapGopY.setIs_pheduyet(RandomTestUtil.nextInt());

		_hoiDapGopYs.add(_persistence.update(hoiDapGopY));

		return hoiDapGopY;
	}

	private List<HoiDapGopY> _hoiDapGopYs = new ArrayList<HoiDapGopY>();
	private HoiDapGopYPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}