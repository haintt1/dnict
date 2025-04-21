/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence.test;

import cms.quanlyvideo.exception.NoSuchVideoException;
import cms.quanlyvideo.model.Video;
import cms.quanlyvideo.service.VideoLocalServiceUtil;
import cms.quanlyvideo.service.persistence.VideoPersistence;
import cms.quanlyvideo.service.persistence.VideoUtil;

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
public class VideoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "cms.quanlyvideo.service"));

	@Before
	public void setUp() {
		_persistence = VideoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Video> iterator = _videos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Video video = _persistence.create(pk);

		Assert.assertNotNull(video);

		Assert.assertEquals(video.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Video newVideo = addVideo();

		_persistence.remove(newVideo);

		Video existingVideo = _persistence.fetchByPrimaryKey(
			newVideo.getPrimaryKey());

		Assert.assertNull(existingVideo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addVideo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Video newVideo = _persistence.create(pk);

		newVideo.setCompanyId(RandomTestUtil.nextLong());

		newVideo.setGroupId(RandomTestUtil.nextLong());

		newVideo.setUserId(RandomTestUtil.nextLong());

		newVideo.setTen(RandomTestUtil.randomString());

		newVideo.setMoTa(RandomTestUtil.randomString());

		newVideo.setNoiDung(RandomTestUtil.randomString());

		newVideo.setDuongDan(RandomTestUtil.randomString());

		newVideo.setLuotXem(RandomTestUtil.nextLong());

		newVideo.setLuotThich(RandomTestUtil.nextLong());

		newVideo.setTuKhoa(RandomTestUtil.randomString());

		newVideo.setChoBinhLuan(RandomTestUtil.nextLong());

		newVideo.setTrangThai(RandomTestUtil.nextLong());

		newVideo.setDaXoa(RandomTestUtil.nextLong());

		newVideo.setNgayTao(RandomTestUtil.nextDate());

		newVideo.setNgaySua(RandomTestUtil.nextDate());

		_videos.add(_persistence.update(newVideo));

		Video existingVideo = _persistence.findByPrimaryKey(
			newVideo.getPrimaryKey());

		Assert.assertEquals(existingVideo.getId(), newVideo.getId());
		Assert.assertEquals(
			existingVideo.getCompanyId(), newVideo.getCompanyId());
		Assert.assertEquals(existingVideo.getGroupId(), newVideo.getGroupId());
		Assert.assertEquals(existingVideo.getUserId(), newVideo.getUserId());
		Assert.assertEquals(existingVideo.getTen(), newVideo.getTen());
		Assert.assertEquals(existingVideo.getMoTa(), newVideo.getMoTa());
		Assert.assertEquals(existingVideo.getNoiDung(), newVideo.getNoiDung());
		Assert.assertEquals(
			existingVideo.getDuongDan(), newVideo.getDuongDan());
		Assert.assertEquals(existingVideo.getLuotXem(), newVideo.getLuotXem());
		Assert.assertEquals(
			existingVideo.getLuotThich(), newVideo.getLuotThich());
		Assert.assertEquals(existingVideo.getTuKhoa(), newVideo.getTuKhoa());
		Assert.assertEquals(
			existingVideo.getChoBinhLuan(), newVideo.getChoBinhLuan());
		Assert.assertEquals(
			existingVideo.getTrangThai(), newVideo.getTrangThai());
		Assert.assertEquals(existingVideo.getDaXoa(), newVideo.getDaXoa());
		Assert.assertEquals(
			Time.getShortTimestamp(existingVideo.getNgayTao()),
			Time.getShortTimestamp(newVideo.getNgayTao()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingVideo.getNgaySua()),
			Time.getShortTimestamp(newVideo.getNgaySua()));
	}

	@Test
	public void testCountByten() throws Exception {
		_persistence.countByten("");

		_persistence.countByten("null");

		_persistence.countByten((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Video newVideo = addVideo();

		Video existingVideo = _persistence.findByPrimaryKey(
			newVideo.getPrimaryKey());

		Assert.assertEquals(existingVideo, newVideo);
	}

	@Test(expected = NoSuchVideoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Video> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"cms_quanlyvideo_video", "id", true, "companyId", true, "groupId",
			true, "userId", true, "ten", true, "moTa", true, "noiDung", true,
			"duongDan", true, "luotXem", true, "luotThich", true, "tuKhoa",
			true, "choBinhLuan", true, "trangThai", true, "daXoa", true,
			"ngayTao", true, "ngaySua", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Video newVideo = addVideo();

		Video existingVideo = _persistence.fetchByPrimaryKey(
			newVideo.getPrimaryKey());

		Assert.assertEquals(existingVideo, newVideo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Video missingVideo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingVideo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Video newVideo1 = addVideo();
		Video newVideo2 = addVideo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVideo1.getPrimaryKey());
		primaryKeys.add(newVideo2.getPrimaryKey());

		Map<Serializable, Video> videos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, videos.size());
		Assert.assertEquals(newVideo1, videos.get(newVideo1.getPrimaryKey()));
		Assert.assertEquals(newVideo2, videos.get(newVideo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Video> videos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(videos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Video newVideo = addVideo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVideo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Video> videos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, videos.size());
		Assert.assertEquals(newVideo, videos.get(newVideo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Video> videos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(videos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Video newVideo = addVideo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVideo.getPrimaryKey());

		Map<Serializable, Video> videos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, videos.size());
		Assert.assertEquals(newVideo, videos.get(newVideo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			VideoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Video>() {

				@Override
				public void performAction(Video video) {
					Assert.assertNotNull(video);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Video newVideo = addVideo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Video.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newVideo.getId()));

		List<Video> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Video existingVideo = result.get(0);

		Assert.assertEquals(existingVideo, newVideo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Video.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Video> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Video newVideo = addVideo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Video.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newVideo.getId();

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
			Video.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Video addVideo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Video video = _persistence.create(pk);

		video.setCompanyId(RandomTestUtil.nextLong());

		video.setGroupId(RandomTestUtil.nextLong());

		video.setUserId(RandomTestUtil.nextLong());

		video.setTen(RandomTestUtil.randomString());

		video.setMoTa(RandomTestUtil.randomString());

		video.setNoiDung(RandomTestUtil.randomString());

		video.setDuongDan(RandomTestUtil.randomString());

		video.setLuotXem(RandomTestUtil.nextLong());

		video.setLuotThich(RandomTestUtil.nextLong());

		video.setTuKhoa(RandomTestUtil.randomString());

		video.setChoBinhLuan(RandomTestUtil.nextLong());

		video.setTrangThai(RandomTestUtil.nextLong());

		video.setDaXoa(RandomTestUtil.nextLong());

		video.setNgayTao(RandomTestUtil.nextDate());

		video.setNgaySua(RandomTestUtil.nextDate());

		_videos.add(_persistence.update(video));

		return video;
	}

	private List<Video> _videos = new ArrayList<Video>();
	private VideoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}