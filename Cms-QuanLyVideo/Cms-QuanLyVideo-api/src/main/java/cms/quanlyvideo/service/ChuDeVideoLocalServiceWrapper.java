/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ChuDeVideoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChuDeVideoLocalService
 * @generated
 */
public class ChuDeVideoLocalServiceWrapper
	implements ChuDeVideoLocalService, ServiceWrapper<ChuDeVideoLocalService> {

	public ChuDeVideoLocalServiceWrapper(
		ChuDeVideoLocalService chuDeVideoLocalService) {

		_chuDeVideoLocalService = chuDeVideoLocalService;
	}

	/**
	 * Adds the chu de video to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChuDeVideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chuDeVideo the chu de video
	 * @return the chu de video that was added
	 */
	@Override
	public cms.quanlyvideo.model.ChuDeVideo addChuDeVideo(
		cms.quanlyvideo.model.ChuDeVideo chuDeVideo) {

		return _chuDeVideoLocalService.addChuDeVideo(chuDeVideo);
	}

	/**
	 * Creates a new chu de video with the primary key. Does not add the chu de video to the database.
	 *
	 * @param id the primary key for the new chu de video
	 * @return the new chu de video
	 */
	@Override
	public cms.quanlyvideo.model.ChuDeVideo createChuDeVideo(long id) {
		return _chuDeVideoLocalService.createChuDeVideo(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chuDeVideoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the chu de video from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChuDeVideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chuDeVideo the chu de video
	 * @return the chu de video that was removed
	 */
	@Override
	public cms.quanlyvideo.model.ChuDeVideo deleteChuDeVideo(
		cms.quanlyvideo.model.ChuDeVideo chuDeVideo) {

		return _chuDeVideoLocalService.deleteChuDeVideo(chuDeVideo);
	}

	/**
	 * Deletes the chu de video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChuDeVideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the chu de video
	 * @return the chu de video that was removed
	 * @throws PortalException if a chu de video with the primary key could not be found
	 */
	@Override
	public cms.quanlyvideo.model.ChuDeVideo deleteChuDeVideo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chuDeVideoLocalService.deleteChuDeVideo(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chuDeVideoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _chuDeVideoLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _chuDeVideoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cms.quanlyvideo.model.impl.ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _chuDeVideoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cms.quanlyvideo.model.impl.ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _chuDeVideoLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _chuDeVideoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _chuDeVideoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cms.quanlyvideo.model.ChuDeVideo fetchChuDeVideo(long id) {
		return _chuDeVideoLocalService.fetchChuDeVideo(id);
	}

	@Override
	public java.util.List<cms.quanlyvideo.model.ChuDeVideo>
		findChuDeVideoByChuDeId(long chude_id) {

		return _chuDeVideoLocalService.findChuDeVideoByChuDeId(chude_id);
	}

	@Override
	public java.util.List<cms.quanlyvideo.model.ChuDeVideo>
		findChuDeVideoByVideoId(long video_id) {

		return _chuDeVideoLocalService.findChuDeVideoByVideoId(video_id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _chuDeVideoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the chu de video with the primary key.
	 *
	 * @param id the primary key of the chu de video
	 * @return the chu de video
	 * @throws PortalException if a chu de video with the primary key could not be found
	 */
	@Override
	public cms.quanlyvideo.model.ChuDeVideo getChuDeVideo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chuDeVideoLocalService.getChuDeVideo(id);
	}

	/**
	 * Returns a range of all the chu de videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cms.quanlyvideo.model.impl.ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chu de videos
	 * @param end the upper bound of the range of chu de videos (not inclusive)
	 * @return the range of chu de videos
	 */
	@Override
	public java.util.List<cms.quanlyvideo.model.ChuDeVideo> getChuDeVideos(
		int start, int end) {

		return _chuDeVideoLocalService.getChuDeVideos(start, end);
	}

	/**
	 * Returns the number of chu de videos.
	 *
	 * @return the number of chu de videos
	 */
	@Override
	public int getChuDeVideosCount() {
		return _chuDeVideoLocalService.getChuDeVideosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _chuDeVideoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chuDeVideoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chuDeVideoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the chu de video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChuDeVideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chuDeVideo the chu de video
	 * @return the chu de video that was updated
	 */
	@Override
	public cms.quanlyvideo.model.ChuDeVideo updateChuDeVideo(
		cms.quanlyvideo.model.ChuDeVideo chuDeVideo) {

		return _chuDeVideoLocalService.updateChuDeVideo(chuDeVideo);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _chuDeVideoLocalService.getBasePersistence();
	}

	@Override
	public ChuDeVideoLocalService getWrappedService() {
		return _chuDeVideoLocalService;
	}

	@Override
	public void setWrappedService(
		ChuDeVideoLocalService chuDeVideoLocalService) {

		_chuDeVideoLocalService = chuDeVideoLocalService;
	}

	private ChuDeVideoLocalService _chuDeVideoLocalService;

}