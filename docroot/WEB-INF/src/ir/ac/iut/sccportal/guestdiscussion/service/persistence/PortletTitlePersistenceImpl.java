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

import ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException;
import ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle;
import ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleImpl;
import ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the portlet title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alireza
 * @see PortletTitlePersistence
 * @see PortletTitleUtil
 * @generated
 */
public class PortletTitlePersistenceImpl extends BasePersistenceImpl<PortletTitle>
	implements PortletTitlePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PortletTitleUtil} to access the portlet title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PortletTitleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
			PortletTitleModelImpl.FINDER_CACHE_ENABLED, PortletTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
			PortletTitleModelImpl.FINDER_CACHE_ENABLED, PortletTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
			PortletTitleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEID = new FinderPath(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
			PortletTitleModelImpl.FINDER_CACHE_ENABLED, PortletTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitleId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID =
		new FinderPath(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
			PortletTitleModelImpl.FINDER_CACHE_ENABLED, PortletTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitleId",
			new String[] { Long.class.getName() },
			PortletTitleModelImpl.TITLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLEID = new FinderPath(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
			PortletTitleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitleId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the portlet titles where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @return the matching portlet titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortletTitle> findByTitleId(long titleId)
		throws SystemException {
		return findByTitleId(titleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portlet titles where titleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titleId the title ID
	 * @param start the lower bound of the range of portlet titles
	 * @param end the upper bound of the range of portlet titles (not inclusive)
	 * @return the range of matching portlet titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortletTitle> findByTitleId(long titleId, int start, int end)
		throws SystemException {
		return findByTitleId(titleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the portlet titles where titleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titleId the title ID
	 * @param start the lower bound of the range of portlet titles
	 * @param end the upper bound of the range of portlet titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portlet titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortletTitle> findByTitleId(long titleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID;
			finderArgs = new Object[] { titleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEID;
			finderArgs = new Object[] { titleId, start, end, orderByComparator };
		}

		List<PortletTitle> list = (List<PortletTitle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortletTitle portletTitle : list) {
				if ((titleId != portletTitle.getTitleId())) {
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

			query.append(_SQL_SELECT_PORTLETTITLE_WHERE);

			query.append(_FINDER_COLUMN_TITLEID_TITLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PortletTitleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titleId);

				if (!pagination) {
					list = (List<PortletTitle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortletTitle>(list);
				}
				else {
					list = (List<PortletTitle>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first portlet title in the ordered set where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet title
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a matching portlet title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletTitle findByTitleId_First(long titleId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletTitleException, SystemException {
		PortletTitle portletTitle = fetchByTitleId_First(titleId,
				orderByComparator);

		if (portletTitle != null) {
			return portletTitle;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titleId=");
		msg.append(titleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletTitleException(msg.toString());
	}

	/**
	 * Returns the first portlet title in the ordered set where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet title, or <code>null</code> if a matching portlet title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletTitle fetchByTitleId_First(long titleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortletTitle> list = findByTitleId(titleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last portlet title in the ordered set where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet title
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a matching portlet title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletTitle findByTitleId_Last(long titleId,
		OrderByComparator orderByComparator)
		throws NoSuchPortletTitleException, SystemException {
		PortletTitle portletTitle = fetchByTitleId_Last(titleId,
				orderByComparator);

		if (portletTitle != null) {
			return portletTitle;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titleId=");
		msg.append(titleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletTitleException(msg.toString());
	}

	/**
	 * Returns the last portlet title in the ordered set where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet title, or <code>null</code> if a matching portlet title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletTitle fetchByTitleId_Last(long titleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitleId(titleId);

		if (count == 0) {
			return null;
		}

		List<PortletTitle> list = findByTitleId(titleId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the portlet titles before and after the current portlet title in the ordered set where titleId = &#63;.
	 *
	 * @param portletId the primary key of the current portlet title
	 * @param titleId the title ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portlet title
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a portlet title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletTitle[] findByTitleId_PrevAndNext(String portletId,
		long titleId, OrderByComparator orderByComparator)
		throws NoSuchPortletTitleException, SystemException {
		PortletTitle portletTitle = findByPrimaryKey(portletId);

		Session session = null;

		try {
			session = openSession();

			PortletTitle[] array = new PortletTitleImpl[3];

			array[0] = getByTitleId_PrevAndNext(session, portletTitle, titleId,
					orderByComparator, true);

			array[1] = portletTitle;

			array[2] = getByTitleId_PrevAndNext(session, portletTitle, titleId,
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

	protected PortletTitle getByTitleId_PrevAndNext(Session session,
		PortletTitle portletTitle, long titleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETTITLE_WHERE);

		query.append(_FINDER_COLUMN_TITLEID_TITLEID_2);

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
			query.append(PortletTitleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(titleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletTitle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletTitle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the portlet titles where titleId = &#63; from the database.
	 *
	 * @param titleId the title ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitleId(long titleId) throws SystemException {
		for (PortletTitle portletTitle : findByTitleId(titleId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(portletTitle);
		}
	}

	/**
	 * Returns the number of portlet titles where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @return the number of matching portlet titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTitleId(long titleId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TITLEID;

		Object[] finderArgs = new Object[] { titleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PORTLETTITLE_WHERE);

			query.append(_FINDER_COLUMN_TITLEID_TITLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titleId);

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

	private static final String _FINDER_COLUMN_TITLEID_TITLEID_2 = "portletTitle.titleId = ?";

	public PortletTitlePersistenceImpl() {
		setModelClass(PortletTitle.class);
	}

	/**
	 * Caches the portlet title in the entity cache if it is enabled.
	 *
	 * @param portletTitle the portlet title
	 */
	@Override
	public void cacheResult(PortletTitle portletTitle) {
		EntityCacheUtil.putResult(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
			PortletTitleImpl.class, portletTitle.getPrimaryKey(), portletTitle);

		portletTitle.resetOriginalValues();
	}

	/**
	 * Caches the portlet titles in the entity cache if it is enabled.
	 *
	 * @param portletTitles the portlet titles
	 */
	@Override
	public void cacheResult(List<PortletTitle> portletTitles) {
		for (PortletTitle portletTitle : portletTitles) {
			if (EntityCacheUtil.getResult(
						PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
						PortletTitleImpl.class, portletTitle.getPrimaryKey()) == null) {
				cacheResult(portletTitle);
			}
			else {
				portletTitle.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all portlet titles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PortletTitleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PortletTitleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the portlet title.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PortletTitle portletTitle) {
		EntityCacheUtil.removeResult(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
			PortletTitleImpl.class, portletTitle.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PortletTitle> portletTitles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PortletTitle portletTitle : portletTitles) {
			EntityCacheUtil.removeResult(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
				PortletTitleImpl.class, portletTitle.getPrimaryKey());
		}
	}

	/**
	 * Creates a new portlet title with the primary key. Does not add the portlet title to the database.
	 *
	 * @param portletId the primary key for the new portlet title
	 * @return the new portlet title
	 */
	@Override
	public PortletTitle create(String portletId) {
		PortletTitle portletTitle = new PortletTitleImpl();

		portletTitle.setNew(true);
		portletTitle.setPrimaryKey(portletId);

		return portletTitle;
	}

	/**
	 * Removes the portlet title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portletId the primary key of the portlet title
	 * @return the portlet title that was removed
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a portlet title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletTitle remove(String portletId)
		throws NoSuchPortletTitleException, SystemException {
		return remove((Serializable)portletId);
	}

	/**
	 * Removes the portlet title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the portlet title
	 * @return the portlet title that was removed
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a portlet title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletTitle remove(Serializable primaryKey)
		throws NoSuchPortletTitleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PortletTitle portletTitle = (PortletTitle)session.get(PortletTitleImpl.class,
					primaryKey);

			if (portletTitle == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortletTitleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(portletTitle);
		}
		catch (NoSuchPortletTitleException nsee) {
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
	protected PortletTitle removeImpl(PortletTitle portletTitle)
		throws SystemException {
		portletTitle = toUnwrappedModel(portletTitle);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(portletTitle)) {
				portletTitle = (PortletTitle)session.get(PortletTitleImpl.class,
						portletTitle.getPrimaryKeyObj());
			}

			if (portletTitle != null) {
				session.delete(portletTitle);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (portletTitle != null) {
			clearCache(portletTitle);
		}

		return portletTitle;
	}

	@Override
	public PortletTitle updateImpl(
		ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle portletTitle)
		throws SystemException {
		portletTitle = toUnwrappedModel(portletTitle);

		boolean isNew = portletTitle.isNew();

		PortletTitleModelImpl portletTitleModelImpl = (PortletTitleModelImpl)portletTitle;

		Session session = null;

		try {
			session = openSession();

			if (portletTitle.isNew()) {
				session.save(portletTitle);

				portletTitle.setNew(false);
			}
			else {
				session.merge(portletTitle);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PortletTitleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((portletTitleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						portletTitleModelImpl.getOriginalTitleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID,
					args);

				args = new Object[] { portletTitleModelImpl.getTitleId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID,
					args);
			}
		}

		EntityCacheUtil.putResult(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
			PortletTitleImpl.class, portletTitle.getPrimaryKey(), portletTitle);

		return portletTitle;
	}

	protected PortletTitle toUnwrappedModel(PortletTitle portletTitle) {
		if (portletTitle instanceof PortletTitleImpl) {
			return portletTitle;
		}

		PortletTitleImpl portletTitleImpl = new PortletTitleImpl();

		portletTitleImpl.setNew(portletTitle.isNew());
		portletTitleImpl.setPrimaryKey(portletTitle.getPrimaryKey());

		portletTitleImpl.setPortletId(portletTitle.getPortletId());
		portletTitleImpl.setTitleId(portletTitle.getTitleId());

		return portletTitleImpl;
	}

	/**
	 * Returns the portlet title with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the portlet title
	 * @return the portlet title
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a portlet title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletTitle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPortletTitleException, SystemException {
		PortletTitle portletTitle = fetchByPrimaryKey(primaryKey);

		if (portletTitle == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPortletTitleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return portletTitle;
	}

	/**
	 * Returns the portlet title with the primary key or throws a {@link ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException} if it could not be found.
	 *
	 * @param portletId the primary key of the portlet title
	 * @return the portlet title
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchPortletTitleException if a portlet title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletTitle findByPrimaryKey(String portletId)
		throws NoSuchPortletTitleException, SystemException {
		return findByPrimaryKey((Serializable)portletId);
	}

	/**
	 * Returns the portlet title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the portlet title
	 * @return the portlet title, or <code>null</code> if a portlet title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletTitle fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PortletTitle portletTitle = (PortletTitle)EntityCacheUtil.getResult(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
				PortletTitleImpl.class, primaryKey);

		if (portletTitle == _nullPortletTitle) {
			return null;
		}

		if (portletTitle == null) {
			Session session = null;

			try {
				session = openSession();

				portletTitle = (PortletTitle)session.get(PortletTitleImpl.class,
						primaryKey);

				if (portletTitle != null) {
					cacheResult(portletTitle);
				}
				else {
					EntityCacheUtil.putResult(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
						PortletTitleImpl.class, primaryKey, _nullPortletTitle);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PortletTitleModelImpl.ENTITY_CACHE_ENABLED,
					PortletTitleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return portletTitle;
	}

	/**
	 * Returns the portlet title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param portletId the primary key of the portlet title
	 * @return the portlet title, or <code>null</code> if a portlet title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletTitle fetchByPrimaryKey(String portletId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)portletId);
	}

	/**
	 * Returns all the portlet titles.
	 *
	 * @return the portlet titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortletTitle> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portlet titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet titles
	 * @param end the upper bound of the range of portlet titles (not inclusive)
	 * @return the range of portlet titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortletTitle> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the portlet titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.PortletTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet titles
	 * @param end the upper bound of the range of portlet titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of portlet titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortletTitle> findAll(int start, int end,
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

		List<PortletTitle> list = (List<PortletTitle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PORTLETTITLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTLETTITLE;

				if (pagination) {
					sql = sql.concat(PortletTitleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PortletTitle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortletTitle>(list);
				}
				else {
					list = (List<PortletTitle>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the portlet titles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PortletTitle portletTitle : findAll()) {
			remove(portletTitle);
		}
	}

	/**
	 * Returns the number of portlet titles.
	 *
	 * @return the number of portlet titles
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

				Query q = session.createQuery(_SQL_COUNT_PORTLETTITLE);

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
	 * Initializes the portlet title persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.ir.ac.iut.sccportal.guestdiscussion.model.PortletTitle")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PortletTitle>> listenersList = new ArrayList<ModelListener<PortletTitle>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PortletTitle>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PortletTitleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PORTLETTITLE = "SELECT portletTitle FROM PortletTitle portletTitle";
	private static final String _SQL_SELECT_PORTLETTITLE_WHERE = "SELECT portletTitle FROM PortletTitle portletTitle WHERE ";
	private static final String _SQL_COUNT_PORTLETTITLE = "SELECT COUNT(portletTitle) FROM PortletTitle portletTitle";
	private static final String _SQL_COUNT_PORTLETTITLE_WHERE = "SELECT COUNT(portletTitle) FROM PortletTitle portletTitle WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "portletTitle.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PortletTitle exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PortletTitle exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PortletTitlePersistenceImpl.class);
	private static PortletTitle _nullPortletTitle = new PortletTitleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PortletTitle> toCacheModel() {
				return _nullPortletTitleCacheModel;
			}
		};

	private static CacheModel<PortletTitle> _nullPortletTitleCacheModel = new CacheModel<PortletTitle>() {
			@Override
			public PortletTitle toEntityModel() {
				return _nullPortletTitle;
			}
		};
}