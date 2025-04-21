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

import vn.dnict.qlgopy.exception.NoSuchemailTemplateException;
import vn.dnict.qlgopy.model.emailTemplate;
import vn.dnict.qlgopy.service.emailTemplateLocalServiceUtil;
import vn.dnict.qlgopy.service.persistence.emailTemplatePersistence;
import vn.dnict.qlgopy.service.persistence.emailTemplateUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class emailTemplatePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "vn.dnict.qlgopy.service"));

	@Before
	public void setUp() {
		_persistence = emailTemplateUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<emailTemplate> iterator = _emailTemplates.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		emailTemplate emailTemplate = _persistence.create(pk);

		Assert.assertNotNull(emailTemplate);

		Assert.assertEquals(emailTemplate.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		emailTemplate newemailTemplate = addemailTemplate();

		_persistence.remove(newemailTemplate);

		emailTemplate existingemailTemplate = _persistence.fetchByPrimaryKey(
			newemailTemplate.getPrimaryKey());

		Assert.assertNull(existingemailTemplate);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addemailTemplate();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		emailTemplate newemailTemplate = _persistence.create(pk);

		newemailTemplate.setCompanyId(RandomTestUtil.nextLong());

		newemailTemplate.setGroupId(RandomTestUtil.nextLong());

		newemailTemplate.setTen(RandomTestUtil.randomString());

		newemailTemplate.setNoidung(RandomTestUtil.randomString());

		newemailTemplate.setLoai(RandomTestUtil.nextInt());

		_emailTemplates.add(_persistence.update(newemailTemplate));

		emailTemplate existingemailTemplate = _persistence.findByPrimaryKey(
			newemailTemplate.getPrimaryKey());

		Assert.assertEquals(
			existingemailTemplate.getId(), newemailTemplate.getId());
		Assert.assertEquals(
			existingemailTemplate.getCompanyId(),
			newemailTemplate.getCompanyId());
		Assert.assertEquals(
			existingemailTemplate.getGroupId(), newemailTemplate.getGroupId());
		Assert.assertEquals(
			existingemailTemplate.getTen(), newemailTemplate.getTen());
		Assert.assertEquals(
			existingemailTemplate.getNoidung(), newemailTemplate.getNoidung());
		Assert.assertEquals(
			existingemailTemplate.getLoai(), newemailTemplate.getLoai());
	}

	@Test
	public void testCountByloai() throws Exception {
		_persistence.countByloai(RandomTestUtil.nextInt());

		_persistence.countByloai(0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		emailTemplate newemailTemplate = addemailTemplate();

		emailTemplate existingemailTemplate = _persistence.findByPrimaryKey(
			newemailTemplate.getPrimaryKey());

		Assert.assertEquals(existingemailTemplate, newemailTemplate);
	}

	@Test(expected = NoSuchemailTemplateException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<emailTemplate> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cw_gopy_emailTemplate", "id", true, "companyId", true, "groupId",
			true, "ten", true, "noidung", true, "loai", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		emailTemplate newemailTemplate = addemailTemplate();

		emailTemplate existingemailTemplate = _persistence.fetchByPrimaryKey(
			newemailTemplate.getPrimaryKey());

		Assert.assertEquals(existingemailTemplate, newemailTemplate);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		emailTemplate missingemailTemplate = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingemailTemplate);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		emailTemplate newemailTemplate1 = addemailTemplate();
		emailTemplate newemailTemplate2 = addemailTemplate();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newemailTemplate1.getPrimaryKey());
		primaryKeys.add(newemailTemplate2.getPrimaryKey());

		Map<Serializable, emailTemplate> emailTemplates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, emailTemplates.size());
		Assert.assertEquals(
			newemailTemplate1,
			emailTemplates.get(newemailTemplate1.getPrimaryKey()));
		Assert.assertEquals(
			newemailTemplate2,
			emailTemplates.get(newemailTemplate2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, emailTemplate> emailTemplates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(emailTemplates.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		emailTemplate newemailTemplate = addemailTemplate();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newemailTemplate.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, emailTemplate> emailTemplates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, emailTemplates.size());
		Assert.assertEquals(
			newemailTemplate,
			emailTemplates.get(newemailTemplate.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, emailTemplate> emailTemplates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(emailTemplates.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		emailTemplate newemailTemplate = addemailTemplate();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newemailTemplate.getPrimaryKey());

		Map<Serializable, emailTemplate> emailTemplates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, emailTemplates.size());
		Assert.assertEquals(
			newemailTemplate,
			emailTemplates.get(newemailTemplate.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			emailTemplateLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<emailTemplate>() {

				@Override
				public void performAction(emailTemplate emailTemplate) {
					Assert.assertNotNull(emailTemplate);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		emailTemplate newemailTemplate = addemailTemplate();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			emailTemplate.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newemailTemplate.getId()));

		List<emailTemplate> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		emailTemplate existingemailTemplate = result.get(0);

		Assert.assertEquals(existingemailTemplate, newemailTemplate);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			emailTemplate.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<emailTemplate> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		emailTemplate newemailTemplate = addemailTemplate();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			emailTemplate.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newemailTemplate.getId();

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
			emailTemplate.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected emailTemplate addemailTemplate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		emailTemplate emailTemplate = _persistence.create(pk);

		emailTemplate.setCompanyId(RandomTestUtil.nextLong());

		emailTemplate.setGroupId(RandomTestUtil.nextLong());

		emailTemplate.setTen(RandomTestUtil.randomString());

		emailTemplate.setNoidung(RandomTestUtil.randomString());

		emailTemplate.setLoai(RandomTestUtil.nextInt());

		_emailTemplates.add(_persistence.update(emailTemplate));

		return emailTemplate;
	}

	private List<emailTemplate> _emailTemplates =
		new ArrayList<emailTemplate>();
	private emailTemplatePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}