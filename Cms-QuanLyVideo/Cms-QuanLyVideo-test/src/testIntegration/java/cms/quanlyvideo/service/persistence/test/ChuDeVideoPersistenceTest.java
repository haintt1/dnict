/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence.test;

import cms.quanlyvideo.exception.NoSuchChuDeVideoException;
import cms.quanlyvideo.model.ChuDeVideo;
import cms.quanlyvideo.service.ChuDeVideoLocalServiceUtil;
import cms.quanlyvideo.service.persistence.ChuDeVideoPersistence;
import cms.quanlyvideo.service.persistence.ChuDeVideoUtil;

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

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ChuDeVideoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cms.quanlyvideo.service"));

	@Before
	public void setUp() {
		_persistence = ChuDeVideoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ChuDeVideo> iterator = _chuDeVideos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChuDeVideo chuDeVideo = _persistence.create(pk);

		Assert.assertNotNull(chuDeVideo);

		Assert.assertEquals(chuDeVideo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ChuDeVideo newChuDeVideo = addChuDeVideo();

		_persistence.remove(newChuDeVideo);

		ChuDeVideo existingChuDeVideo = _persistence.fetchByPrimaryKey(
			newChuDeVideo.getPrimaryKey());

		Assert.assertNull(existingChuDeVideo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addChuDeVideo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChuDeVideo newChuDeVideo = _persistence.create(pk);

		newChuDeVideo.setChude_id(RandomTestUtil.nextLong());

		newChuDeVideo.setVideo_id(RandomTestUtil.nextLong());

		_chuDeVideos.add(_persistence.update(newChuDeVideo));

		ChuDeVideo existingChuDeVideo = _persistence.findByPrimaryKey(
			newChuDeVideo.getPrimaryKey());

		Assert.assertEquals(existingChuDeVideo.getId(), newChuDeVideo.getId());
		Assert.assertEquals(
			existingChuDeVideo.getChude_id(), newChuDeVideo.getChude_id());
		Assert.assertEquals(
			existingChuDeVideo.getVideo_id(), newChuDeVideo.getVideo_id());
	}

	@Test
	public void testCountByvideoId() throws Exception {
		_persistence.countByvideoId(RandomTestUtil.nextLong());

		_persistence.countByvideoId(0L);
	}

	@Test
	public void testCountBychudeId() throws Exception {
		_persistence.countBychudeId(RandomTestUtil.nextLong());

		_persistence.countBychudeId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ChuDeVideo newChuDeVideo = addChuDeVideo();

		ChuDeVideo existingChuDeVideo = _persistence.findByPrimaryKey(
			newChuDeVideo.getPrimaryKey());

		Assert.assertEquals(existingChuDeVideo, newChuDeVideo);
	}

	@Test(expected = NoSuchChuDeVideoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ChuDeVideo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cms_quanlyvideo_chudevideo", "id", true, "chude_id", true,
			"video_id", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ChuDeVideo newChuDeVideo = addChuDeVideo();

		ChuDeVideo existingChuDeVideo = _persistence.fetchByPrimaryKey(
			newChuDeVideo.getPrimaryKey());

		Assert.assertEquals(existingChuDeVideo, newChuDeVideo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChuDeVideo missingChuDeVideo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingChuDeVideo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ChuDeVideo newChuDeVideo1 = addChuDeVideo();
		ChuDeVideo newChuDeVideo2 = addChuDeVideo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChuDeVideo1.getPrimaryKey());
		primaryKeys.add(newChuDeVideo2.getPrimaryKey());

		Map<Serializable, ChuDeVideo> chuDeVideos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, chuDeVideos.size());
		Assert.assertEquals(
			newChuDeVideo1, chuDeVideos.get(newChuDeVideo1.getPrimaryKey()));
		Assert.assertEquals(
			newChuDeVideo2, chuDeVideos.get(newChuDeVideo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ChuDeVideo> chuDeVideos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(chuDeVideos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ChuDeVideo newChuDeVideo = addChuDeVideo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChuDeVideo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ChuDeVideo> chuDeVideos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, chuDeVideos.size());
		Assert.assertEquals(
			newChuDeVideo, chuDeVideos.get(newChuDeVideo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ChuDeVideo> chuDeVideos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(chuDeVideos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ChuDeVideo newChuDeVideo = addChuDeVideo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChuDeVideo.getPrimaryKey());

		Map<Serializable, ChuDeVideo> chuDeVideos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, chuDeVideos.size());
		Assert.assertEquals(
			newChuDeVideo, chuDeVideos.get(newChuDeVideo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ChuDeVideoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ChuDeVideo>() {

				@Override
				public void performAction(ChuDeVideo chuDeVideo) {
					Assert.assertNotNull(chuDeVideo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ChuDeVideo newChuDeVideo = addChuDeVideo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ChuDeVideo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newChuDeVideo.getId()));

		List<ChuDeVideo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ChuDeVideo existingChuDeVideo = result.get(0);

		Assert.assertEquals(existingChuDeVideo, newChuDeVideo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ChuDeVideo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<ChuDeVideo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ChuDeVideo newChuDeVideo = addChuDeVideo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ChuDeVideo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newChuDeVideo.getId();

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
			ChuDeVideo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ChuDeVideo addChuDeVideo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChuDeVideo chuDeVideo = _persistence.create(pk);

		chuDeVideo.setChude_id(RandomTestUtil.nextLong());

		chuDeVideo.setVideo_id(RandomTestUtil.nextLong());

		_chuDeVideos.add(_persistence.update(chuDeVideo));

		return chuDeVideo;
	}

	private List<ChuDeVideo> _chuDeVideos = new ArrayList<ChuDeVideo>();
	private ChuDeVideoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}