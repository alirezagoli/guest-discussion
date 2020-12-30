/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ir.ac.iut.sccportal.guestdiscussion.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException;
import ir.ac.iut.sccportal.guestdiscussion.model.Title;
import ir.ac.iut.sccportal.guestdiscussion.model.impl.TitleImpl;
import ir.ac.iut.sccportal.guestdiscussion.model.impl.TitleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alireza
 * @see TitlePersistence
 * @see TitleUtil
 * @generated
 */
public class TitlePersistenceImpl extends BasePersistenceImpl<Title>
	implements TitlePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TitleUtil} to access the title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TitleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TitleModelImpl.ENTITY_CACHE_ENABLED,
			TitleModelImpl.FINDER_CACHE_ENABLED, TitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TitleModelImpl.ENTITY_CACHE_ENABLED,
			TitleModelImpl.FINDER_CACHE_ENABLED, TitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TitleModelImpl.ENTITY_CACHE_ENABLED,
			TitleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TitleModelImpl.ENTITY_CACHE_ENABLED,
			TitleModelImpl.FINDER_CACHE_ENABLED, TitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TitleModelImpl.ENTITY_CACHE_ENABLED,
			TitleModelImpl.FINDER_CACHE_ENABLED, TitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			TitleModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(TitleModelImpl.ENTITY_CACHE_ENABLED,
			TitleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the titles where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Title> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the titles where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.TitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of titles
	 * @param end the upper bound of the range of titles (not inclusive)
	 * @return the range of matching titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Title> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.TitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of titles
	 * @param end the upper bound of the range of titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Title> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Title> list = (List<Title>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Title title : list) {
				if ((companyId != title.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TITLE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Title>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Title>(list);
				}
				else {
					list = (List<Title>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first title in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching title
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a matching title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Title findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTitleException, SystemException {
		Title title = fetchByCompanyId_First(companyId, orderByComparator);

		if (title != null) {
			return title;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitleException(msg.toString());
	}

	/**
	 * Returns the first title in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching title, or <code>null</code> if a matching title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Title fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Title> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last title in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching title
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a matching title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Title findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTitleException, SystemException {
		Title title = fetchByCompanyId_Last(companyId, orderByComparator);

		if (title != null) {
			return title;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitleException(msg.toString());
	}

	/**
	 * Returns the last title in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching title, or <code>null</code> if a matching title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Title fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Title> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles before and after the current title in the ordered set where companyId = &#63;.
	 *
	 * @param titleId the primary key of the current title
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next title
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Title[] findByCompanyId_PrevAndNext(long titleId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTitleException, SystemException {
		Title title = findByPrimaryKey(titleId);

		Session session = null;

		try {
			session = openSession();

			Title[] array = new TitleImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, title, companyId,
					orderByComparator, true);

			array[1] = title;

			array[2] = getByCompanyId_PrevAndNext(session, title, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Title getByCompanyId_PrevAndNext(Session session, Title title,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLE_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TitleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(title);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Title> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Title title : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(title);
		}
	}

	/**
	 * Returns the number of titles where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TITLE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "title.companyId = ?";

	public TitlePersistenceImpl() {
		setModelClass(Title.class);
	}

	/**
	 * Caches the title in the entity cache if it is enabled.
	 *
	 * @param title the title
	 */
	@Override
	public void cacheResult(Title title) {
		EntityCacheUtil.putResult(TitleModelImpl.ENTITY_CACHE_ENABLED,
			TitleImpl.class, title.getPrimaryKey(), title);

		title.resetOriginalValues();
	}

	/**
	 * Caches the titles in the entity cache if it is enabled.
	 *
	 * @param titles the titles
	 */
	@Override
	public void cacheResult(List<Title> titles) {
		for (Title title : titles) {
			if (EntityCacheUtil.getResult(TitleModelImpl.ENTITY_CACHE_ENABLED,
						TitleImpl.class, title.getPrimaryKey()) == null) {
				cacheResult(title);
			}
			else {
				title.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all titles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TitleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TitleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the title.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Title title) {
		EntityCacheUtil.removeResult(TitleModelImpl.ENTITY_CACHE_ENABLED,
			TitleImpl.class, title.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Title> titles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Title title : titles) {
			EntityCacheUtil.removeResult(TitleModelImpl.ENTITY_CACHE_ENABLED,
				TitleImpl.class, title.getPrimaryKey());
		}
	}

	/**
	 * Creates a new title with the primary key. Does not add the title to the database.
	 *
	 * @param titleId the primary key for the new title
	 * @return the new title
	 */
	@Override
	public Title create(long titleId) {
		Title title = new TitleImpl();

		title.setNew(true);
		title.setPrimaryKey(titleId);

		return title;
	}

	/**
	 * Removes the title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param titleId the primary key of the title
	 * @return the title that was removed
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Title remove(long titleId)
		throws NoSuchTitleException, SystemException {
		return remove((Serializable)titleId);
	}

	/**
	 * Removes the title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the title
	 * @return the title that was removed
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Title remove(Serializable primaryKey)
		throws NoSuchTitleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Title title = (Title)session.get(TitleImpl.class, primaryKey);

			if (title == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTitleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(title);
		}
		catch (NoSuchTitleException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Title removeImpl(Title title) throws SystemException {
		title = toUnwrappedModel(title);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(title)) {
				title = (Title)session.get(TitleImpl.class,
						title.getPrimaryKeyObj());
			}

			if (title != null) {
				session.delete(title);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (title != null) {
			clearCache(title);
		}

		return title;
	}

	@Override
	public Title updateImpl(
		ir.ac.iut.sccportal.guestdiscussion.model.Title title)
		throws SystemException {
		title = toUnwrappedModel(title);

		boolean isNew = title.isNew();

		TitleModelImpl titleModelImpl = (TitleModelImpl)title;

		Session session = null;

		try {
			session = openSession();

			if (title.isNew()) {
				session.save(title);

				title.setNew(false);
			}
			else {
				session.merge(title);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TitleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((titleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titleModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { titleModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(TitleModelImpl.ENTITY_CACHE_ENABLED,
			TitleImpl.class, title.getPrimaryKey(), title);

		return title;
	}

	protected Title toUnwrappedModel(Title title) {
		if (title instanceof TitleImpl) {
			return title;
		}

		TitleImpl titleImpl = new TitleImpl();

		titleImpl.setNew(title.isNew());
		titleImpl.setPrimaryKey(title.getPrimaryKey());

		titleImpl.setTitleId(title.getTitleId());
		titleImpl.setGroupId(title.getGroupId());
		titleImpl.setCompanyId(title.getCompanyId());
		titleImpl.setUserId(title.getUserId());
		titleImpl.setUserName(title.getUserName());
		titleImpl.setCreateDate(title.getCreateDate());
		titleImpl.setTitleText(title.getTitleText());
		titleImpl.setNewCommentDraft(title.getNewCommentDraft());
		titleImpl.setAnswerCommentDraft(title.getAnswerCommentDraft());

		return titleImpl;
	}

	/**
	 * Returns the title with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the title
	 * @return the title
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Title findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTitleException, SystemException {
		Title title = fetchByPrimaryKey(primaryKey);

		if (title == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTitleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return title;
	}

	/**
	 * Returns the title with the primary key or throws a {@link ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException} if it could not be found.
	 *
	 * @param titleId the primary key of the title
	 * @return the title
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchTitleException if a title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Title findByPrimaryKey(long titleId)
		throws NoSuchTitleException, SystemException {
		return findByPrimaryKey((Serializable)titleId);
	}

	/**
	 * Returns the title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the title
	 * @return the title, or <code>null</code> if a title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Title fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Title title = (Title)EntityCacheUtil.getResult(TitleModelImpl.ENTITY_CACHE_ENABLED,
				TitleImpl.class, primaryKey);

		if (title == _nullTitle) {
			return null;
		}

		if (title == null) {
			Session session = null;

			try {
				session = openSession();

				title = (Title)session.get(TitleImpl.class, primaryKey);

				if (title != null) {
					cacheResult(title);
				}
				else {
					EntityCacheUtil.putResult(TitleModelImpl.ENTITY_CACHE_ENABLED,
						TitleImpl.class, primaryKey, _nullTitle);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TitleModelImpl.ENTITY_CACHE_ENABLED,
					TitleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return title;
	}

	/**
	 * Returns the title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param titleId the primary key of the title
	 * @return the title, or <code>null</code> if a title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Title fetchByPrimaryKey(long titleId) throws SystemException {
		return fetchByPrimaryKey((Serializable)titleId);
	}

	/**
	 * Returns all the titles.
	 *
	 * @return the titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Title> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.TitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of titles
	 * @param end the upper bound of the range of titles (not inclusive)
	 * @return the range of titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Title> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.TitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of titles
	 * @param end the upper bound of the range of titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Title> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Title> list = (List<Title>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TITLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TITLE;

				if (pagination) {
					sql = sql.concat(TitleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Title>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Title>(list);
				}
				else {
					list = (List<Title>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the titles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Title title : findAll()) {
			remove(title);
		}
	}

	/**
	 * Returns the number of titles.
	 *
	 * @return the number of titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TITLE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the title persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.ir.ac.iut.sccportal.guestdiscussion.model.Title")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Title>> listenersList = new ArrayList<ModelListener<Title>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Title>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TitleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TITLE = "SELECT title FROM Title title";
	private static final String _SQL_SELECT_TITLE_WHERE = "SELECT title FROM Title title WHERE ";
	private static final String _SQL_COUNT_TITLE = "SELECT COUNT(title) FROM Title title";
	private static final String _SQL_COUNT_TITLE_WHERE = "SELECT COUNT(title) FROM Title title WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "title.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Title exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Title exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TitlePersistenceImpl.class);
	private static Title _nullTitle = new TitleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Title> toCacheModel() {
				return _nullTitleCacheModel;
			}
		};

	private static CacheModel<Title> _nullTitleCacheModel = new CacheModel<Title>() {
			@Override
			public Title toEntityModel() {
				return _nullTitle;
			}
		};
}