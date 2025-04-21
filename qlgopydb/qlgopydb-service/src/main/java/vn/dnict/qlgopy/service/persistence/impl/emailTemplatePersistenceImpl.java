/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import vn.dnict.qlgopy.exception.NoSuchemailTemplateException;
import vn.dnict.qlgopy.model.emailTemplate;
import vn.dnict.qlgopy.model.impl.emailTemplateImpl;
import vn.dnict.qlgopy.model.impl.emailTemplateModelImpl;
import vn.dnict.qlgopy.service.persistence.emailTemplatePersistence;
import vn.dnict.qlgopy.service.persistence.emailTemplateUtil;
import vn.dnict.qlgopy.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the email template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = emailTemplatePersistence.class)
public class emailTemplatePersistenceImpl
	extends BasePersistenceImpl<emailTemplate>
	implements emailTemplatePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>emailTemplateUtil</code> to access the email template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		emailTemplateImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByloai;
	private FinderPath _finderPathWithoutPaginationFindByloai;
	private FinderPath _finderPathCountByloai;

	/**
	 * Returns all the email templates where loai = &#63;.
	 *
	 * @param loai the loai
	 * @return the matching email templates
	 */
	@Override
	public List<emailTemplate> findByloai(int loai) {
		return findByloai(loai, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the email templates where loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param loai the loai
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @return the range of matching email templates
	 */
	@Override
	public List<emailTemplate> findByloai(int loai, int start, int end) {
		return findByloai(loai, start, end, null);
	}

	/**
	 * Returns an ordered range of all the email templates where loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param loai the loai
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching email templates
	 */
	@Override
	public List<emailTemplate> findByloai(
		int loai, int start, int end,
		OrderByComparator<emailTemplate> orderByComparator) {

		return findByloai(loai, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the email templates where loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param loai the loai
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching email templates
	 */
	@Override
	public List<emailTemplate> findByloai(
		int loai, int start, int end,
		OrderByComparator<emailTemplate> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByloai;
				finderArgs = new Object[] {loai};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByloai;
			finderArgs = new Object[] {loai, start, end, orderByComparator};
		}

		List<emailTemplate> list = null;

		if (useFinderCache) {
			list = (List<emailTemplate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (emailTemplate emailTemplate : list) {
					if (loai != emailTemplate.getLoai()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EMAILTEMPLATE_WHERE);

			sb.append(_FINDER_COLUMN_LOAI_LOAI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(emailTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(loai);

				list = (List<emailTemplate>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email template
	 * @throws NoSuchemailTemplateException if a matching email template could not be found
	 */
	@Override
	public emailTemplate findByloai_First(
			int loai, OrderByComparator<emailTemplate> orderByComparator)
		throws NoSuchemailTemplateException {

		emailTemplate emailTemplate = fetchByloai_First(
			loai, orderByComparator);

		if (emailTemplate != null) {
			return emailTemplate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("loai=");
		sb.append(loai);

		sb.append("}");

		throw new NoSuchemailTemplateException(sb.toString());
	}

	/**
	 * Returns the first email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email template, or <code>null</code> if a matching email template could not be found
	 */
	@Override
	public emailTemplate fetchByloai_First(
		int loai, OrderByComparator<emailTemplate> orderByComparator) {

		List<emailTemplate> list = findByloai(loai, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email template
	 * @throws NoSuchemailTemplateException if a matching email template could not be found
	 */
	@Override
	public emailTemplate findByloai_Last(
			int loai, OrderByComparator<emailTemplate> orderByComparator)
		throws NoSuchemailTemplateException {

		emailTemplate emailTemplate = fetchByloai_Last(loai, orderByComparator);

		if (emailTemplate != null) {
			return emailTemplate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("loai=");
		sb.append(loai);

		sb.append("}");

		throw new NoSuchemailTemplateException(sb.toString());
	}

	/**
	 * Returns the last email template in the ordered set where loai = &#63;.
	 *
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email template, or <code>null</code> if a matching email template could not be found
	 */
	@Override
	public emailTemplate fetchByloai_Last(
		int loai, OrderByComparator<emailTemplate> orderByComparator) {

		int count = countByloai(loai);

		if (count == 0) {
			return null;
		}

		List<emailTemplate> list = findByloai(
			loai, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the email templates before and after the current email template in the ordered set where loai = &#63;.
	 *
	 * @param id the primary key of the current email template
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email template
	 * @throws NoSuchemailTemplateException if a email template with the primary key could not be found
	 */
	@Override
	public emailTemplate[] findByloai_PrevAndNext(
			long id, int loai,
			OrderByComparator<emailTemplate> orderByComparator)
		throws NoSuchemailTemplateException {

		emailTemplate emailTemplate = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			emailTemplate[] array = new emailTemplateImpl[3];

			array[0] = getByloai_PrevAndNext(
				session, emailTemplate, loai, orderByComparator, true);

			array[1] = emailTemplate;

			array[2] = getByloai_PrevAndNext(
				session, emailTemplate, loai, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected emailTemplate getByloai_PrevAndNext(
		Session session, emailTemplate emailTemplate, int loai,
		OrderByComparator<emailTemplate> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMAILTEMPLATE_WHERE);

		sb.append(_FINDER_COLUMN_LOAI_LOAI_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(emailTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(loai);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						emailTemplate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<emailTemplate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the email templates where loai = &#63; from the database.
	 *
	 * @param loai the loai
	 */
	@Override
	public void removeByloai(int loai) {
		for (emailTemplate emailTemplate :
				findByloai(loai, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(emailTemplate);
		}
	}

	/**
	 * Returns the number of email templates where loai = &#63;.
	 *
	 * @param loai the loai
	 * @return the number of matching email templates
	 */
	@Override
	public int countByloai(int loai) {
		FinderPath finderPath = _finderPathCountByloai;

		Object[] finderArgs = new Object[] {loai};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMAILTEMPLATE_WHERE);

			sb.append(_FINDER_COLUMN_LOAI_LOAI_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(loai);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LOAI_LOAI_2 =
		"emailTemplate.loai = ?";

	public emailTemplatePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(emailTemplate.class);

		setModelImplClass(emailTemplateImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the email template in the entity cache if it is enabled.
	 *
	 * @param emailTemplate the email template
	 */
	@Override
	public void cacheResult(emailTemplate emailTemplate) {
		entityCache.putResult(
			emailTemplateImpl.class, emailTemplate.getPrimaryKey(),
			emailTemplate);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the email templates in the entity cache if it is enabled.
	 *
	 * @param emailTemplates the email templates
	 */
	@Override
	public void cacheResult(List<emailTemplate> emailTemplates) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (emailTemplates.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (emailTemplate emailTemplate : emailTemplates) {
			if (entityCache.getResult(
					emailTemplateImpl.class, emailTemplate.getPrimaryKey()) ==
						null) {

				cacheResult(emailTemplate);
			}
		}
	}

	/**
	 * Clears the cache for all email templates.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(emailTemplateImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the email template.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(emailTemplate emailTemplate) {
		entityCache.removeResult(emailTemplateImpl.class, emailTemplate);
	}

	@Override
	public void clearCache(List<emailTemplate> emailTemplates) {
		for (emailTemplate emailTemplate : emailTemplates) {
			entityCache.removeResult(emailTemplateImpl.class, emailTemplate);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(emailTemplateImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new email template with the primary key. Does not add the email template to the database.
	 *
	 * @param id the primary key for the new email template
	 * @return the new email template
	 */
	@Override
	public emailTemplate create(long id) {
		emailTemplate emailTemplate = new emailTemplateImpl();

		emailTemplate.setNew(true);
		emailTemplate.setPrimaryKey(id);

		emailTemplate.setCompanyId(CompanyThreadLocal.getCompanyId());

		return emailTemplate;
	}

	/**
	 * Removes the email template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email template
	 * @return the email template that was removed
	 * @throws NoSuchemailTemplateException if a email template with the primary key could not be found
	 */
	@Override
	public emailTemplate remove(long id) throws NoSuchemailTemplateException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the email template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email template
	 * @return the email template that was removed
	 * @throws NoSuchemailTemplateException if a email template with the primary key could not be found
	 */
	@Override
	public emailTemplate remove(Serializable primaryKey)
		throws NoSuchemailTemplateException {

		Session session = null;

		try {
			session = openSession();

			emailTemplate emailTemplate = (emailTemplate)session.get(
				emailTemplateImpl.class, primaryKey);

			if (emailTemplate == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchemailTemplateException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(emailTemplate);
		}
		catch (NoSuchemailTemplateException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected emailTemplate removeImpl(emailTemplate emailTemplate) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emailTemplate)) {
				emailTemplate = (emailTemplate)session.get(
					emailTemplateImpl.class, emailTemplate.getPrimaryKeyObj());
			}

			if (emailTemplate != null) {
				session.delete(emailTemplate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (emailTemplate != null) {
			clearCache(emailTemplate);
		}

		return emailTemplate;
	}

	@Override
	public emailTemplate updateImpl(emailTemplate emailTemplate) {
		boolean isNew = emailTemplate.isNew();

		if (!(emailTemplate instanceof emailTemplateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(emailTemplate.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					emailTemplate);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in emailTemplate proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom emailTemplate implementation " +
					emailTemplate.getClass());
		}

		emailTemplateModelImpl emailTemplateModelImpl =
			(emailTemplateModelImpl)emailTemplate;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(emailTemplate);
			}
			else {
				emailTemplate = (emailTemplate)session.merge(emailTemplate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			emailTemplateImpl.class, emailTemplateModelImpl, false, true);

		if (isNew) {
			emailTemplate.setNew(false);
		}

		emailTemplate.resetOriginalValues();

		return emailTemplate;
	}

	/**
	 * Returns the email template with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email template
	 * @return the email template
	 * @throws NoSuchemailTemplateException if a email template with the primary key could not be found
	 */
	@Override
	public emailTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchemailTemplateException {

		emailTemplate emailTemplate = fetchByPrimaryKey(primaryKey);

		if (emailTemplate == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchemailTemplateException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return emailTemplate;
	}

	/**
	 * Returns the email template with the primary key or throws a <code>NoSuchemailTemplateException</code> if it could not be found.
	 *
	 * @param id the primary key of the email template
	 * @return the email template
	 * @throws NoSuchemailTemplateException if a email template with the primary key could not be found
	 */
	@Override
	public emailTemplate findByPrimaryKey(long id)
		throws NoSuchemailTemplateException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the email template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the email template
	 * @return the email template, or <code>null</code> if a email template with the primary key could not be found
	 */
	@Override
	public emailTemplate fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the email templates.
	 *
	 * @return the email templates
	 */
	@Override
	public List<emailTemplate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the email templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @return the range of email templates
	 */
	@Override
	public List<emailTemplate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the email templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of email templates
	 */
	@Override
	public List<emailTemplate> findAll(
		int start, int end,
		OrderByComparator<emailTemplate> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the email templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>emailTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of email templates
	 */
	@Override
	public List<emailTemplate> findAll(
		int start, int end, OrderByComparator<emailTemplate> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<emailTemplate> list = null;

		if (useFinderCache) {
			list = (List<emailTemplate>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMAILTEMPLATE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMAILTEMPLATE;

				sql = sql.concat(emailTemplateModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<emailTemplate>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the email templates from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (emailTemplate emailTemplate : findAll()) {
			remove(emailTemplate);
		}
	}

	/**
	 * Returns the number of email templates.
	 *
	 * @return the number of email templates
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMAILTEMPLATE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMAILTEMPLATE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return emailTemplateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the email template persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new emailTemplateModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", emailTemplate.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByloai = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByloai",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"loai"}, true);

		_finderPathWithoutPaginationFindByloai = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByloai",
			new String[] {Integer.class.getName()}, new String[] {"loai"},
			true);

		_finderPathCountByloai = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByloai",
			new String[] {Integer.class.getName()}, new String[] {"loai"},
			false);

		emailTemplateUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		emailTemplateUtil.setPersistence(null);

		entityCache.removeCache(emailTemplateImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = cwPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = cwPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = cwPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EMAILTEMPLATE =
		"SELECT emailTemplate FROM emailTemplate emailTemplate";

	private static final String _SQL_SELECT_EMAILTEMPLATE_WHERE =
		"SELECT emailTemplate FROM emailTemplate emailTemplate WHERE ";

	private static final String _SQL_COUNT_EMAILTEMPLATE =
		"SELECT COUNT(emailTemplate) FROM emailTemplate emailTemplate";

	private static final String _SQL_COUNT_EMAILTEMPLATE_WHERE =
		"SELECT COUNT(emailTemplate) FROM emailTemplate emailTemplate WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "emailTemplate.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No emailTemplate exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No emailTemplate exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		emailTemplatePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class emailTemplateModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			emailTemplateModelImpl emailTemplateModelImpl =
				(emailTemplateModelImpl)baseModel;

			long columnBitmask = emailTemplateModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(emailTemplateModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						emailTemplateModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(emailTemplateModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			emailTemplateModelImpl emailTemplateModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						emailTemplateModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = emailTemplateModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}