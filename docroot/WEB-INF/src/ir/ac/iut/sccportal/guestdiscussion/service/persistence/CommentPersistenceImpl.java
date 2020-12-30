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

import ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException;
import ir.ac.iut.sccportal.guestdiscussion.model.Comment;
import ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentImpl;
import ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alireza
 * @see CommentPersistence
 * @see CommentUtil
 * @generated
 */
public class CommentPersistenceImpl extends BasePersistenceImpl<Comment>
	implements CommentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CommentUtil} to access the comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CommentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID_TITLEID_VERIFIED =
		new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentId_TitleId_Verified",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID_TITLEID_VERIFIED =
		new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentId_TitleId_Verified",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			CommentModelImpl.PARENTID_COLUMN_BITMASK |
			CommentModelImpl.TITLEID_COLUMN_BITMASK |
			CommentModelImpl.VERIFIED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID_TITLEID_VERIFIED =
		new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentId_TitleId_Verified",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the comments where parentId = &#63; and titleId = &#63; and verified = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param titleId the title ID
	 * @param verified the verified
	 * @return the matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByParentId_TitleId_Verified(long parentId,
		long titleId, boolean verified) throws SystemException {
		return findByParentId_TitleId_Verified(parentId, titleId, verified,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comments where parentId = &#63; and titleId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByParentId_TitleId_Verified(long parentId,
		long titleId, boolean verified, int start, int end)
		throws SystemException {
		return findByParentId_TitleId_Verified(parentId, titleId, verified,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the comments where parentId = &#63; and titleId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByParentId_TitleId_Verified(long parentId,
		long titleId, boolean verified, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID_TITLEID_VERIFIED;
			finderArgs = new Object[] { parentId, titleId, verified };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID_TITLEID_VERIFIED;
			finderArgs = new Object[] {
					parentId, titleId, verified,
					
					start, end, orderByComparator
				};
		}

		List<Comment> list = (List<Comment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Comment comment : list) {
				if ((parentId != comment.getParentId()) ||
						(titleId != comment.getTitleId()) ||
						(verified != comment.getVerified())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_PARENTID_2);

			query.append(_FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_TITLEID_2);

			query.append(_FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_VERIFIED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				qPos.add(titleId);

				qPos.add(verified);

				if (!pagination) {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Comment>(list);
				}
				else {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first comment in the ordered set where parentId = &#63; and titleId = &#63; and verified = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByParentId_TitleId_Verified_First(long parentId,
		long titleId, boolean verified, OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByParentId_TitleId_Verified_First(parentId,
				titleId, verified, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", titleId=");
		msg.append(titleId);

		msg.append(", verified=");
		msg.append(verified);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the first comment in the ordered set where parentId = &#63; and titleId = &#63; and verified = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByParentId_TitleId_Verified_First(long parentId,
		long titleId, boolean verified, OrderByComparator orderByComparator)
		throws SystemException {
		List<Comment> list = findByParentId_TitleId_Verified(parentId, titleId,
				verified, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment in the ordered set where parentId = &#63; and titleId = &#63; and verified = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByParentId_TitleId_Verified_Last(long parentId,
		long titleId, boolean verified, OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByParentId_TitleId_Verified_Last(parentId,
				titleId, verified, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", titleId=");
		msg.append(titleId);

		msg.append(", verified=");
		msg.append(verified);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the last comment in the ordered set where parentId = &#63; and titleId = &#63; and verified = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByParentId_TitleId_Verified_Last(long parentId,
		long titleId, boolean verified, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentId_TitleId_Verified(parentId, titleId, verified);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByParentId_TitleId_Verified(parentId, titleId,
				verified, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where parentId = &#63; and titleId = &#63; and verified = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param parentId the parent ID
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment[] findByParentId_TitleId_Verified_PrevAndNext(
		long commentId, long parentId, long titleId, boolean verified,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByParentId_TitleId_Verified_PrevAndNext(session,
					comment, parentId, titleId, verified, orderByComparator,
					true);

			array[1] = comment;

			array[2] = getByParentId_TitleId_Verified_PrevAndNext(session,
					comment, parentId, titleId, verified, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByParentId_TitleId_Verified_PrevAndNext(
		Session session, Comment comment, long parentId, long titleId,
		boolean verified, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMENT_WHERE);

		query.append(_FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_PARENTID_2);

		query.append(_FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_TITLEID_2);

		query.append(_FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_VERIFIED_2);

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
			query.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		qPos.add(titleId);

		qPos.add(verified);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(comment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Comment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where parentId = &#63; and titleId = &#63; and verified = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param titleId the title ID
	 * @param verified the verified
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentId_TitleId_Verified(long parentId, long titleId,
		boolean verified) throws SystemException {
		for (Comment comment : findByParentId_TitleId_Verified(parentId,
				titleId, verified, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(comment);
		}
	}

	/**
	 * Returns the number of comments where parentId = &#63; and titleId = &#63; and verified = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param titleId the title ID
	 * @param verified the verified
	 * @return the number of matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentId_TitleId_Verified(long parentId, long titleId,
		boolean verified) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTID_TITLEID_VERIFIED;

		Object[] finderArgs = new Object[] { parentId, titleId, verified };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_PARENTID_2);

			query.append(_FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_TITLEID_2);

			query.append(_FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_VERIFIED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				qPos.add(titleId);

				qPos.add(verified);

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

	private static final String _FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_PARENTID_2 =
		"comment.parentId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_TITLEID_2 =
		"comment.titleId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTID_TITLEID_VERIFIED_VERIFIED_2 =
		"comment.verified = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEID_VIRIFIED =
		new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitleId_Virified",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID_VIRIFIED =
		new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTitleId_Virified",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			CommentModelImpl.TITLEID_COLUMN_BITMASK |
			CommentModelImpl.VERIFIED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLEID_VIRIFIED = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTitleId_Virified",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the comments where titleId = &#63; and verified = &#63;.
	 *
	 * @param titleId the title ID
	 * @param verified the verified
	 * @return the matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByTitleId_Virified(long titleId, boolean verified)
		throws SystemException {
		return findByTitleId_Virified(titleId, verified, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comments where titleId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByTitleId_Virified(long titleId, boolean verified,
		int start, int end) throws SystemException {
		return findByTitleId_Virified(titleId, verified, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comments where titleId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByTitleId_Virified(long titleId, boolean verified,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID_VIRIFIED;
			finderArgs = new Object[] { titleId, verified };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEID_VIRIFIED;
			finderArgs = new Object[] {
					titleId, verified,
					
					start, end, orderByComparator
				};
		}

		List<Comment> list = (List<Comment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Comment comment : list) {
				if ((titleId != comment.getTitleId()) ||
						(verified != comment.getVerified())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_TITLEID_VIRIFIED_TITLEID_2);

			query.append(_FINDER_COLUMN_TITLEID_VIRIFIED_VERIFIED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titleId);

				qPos.add(verified);

				if (!pagination) {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Comment>(list);
				}
				else {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first comment in the ordered set where titleId = &#63; and verified = &#63;.
	 *
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByTitleId_Virified_First(long titleId, boolean verified,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByTitleId_Virified_First(titleId, verified,
				orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titleId=");
		msg.append(titleId);

		msg.append(", verified=");
		msg.append(verified);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the first comment in the ordered set where titleId = &#63; and verified = &#63;.
	 *
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByTitleId_Virified_First(long titleId,
		boolean verified, OrderByComparator orderByComparator)
		throws SystemException {
		List<Comment> list = findByTitleId_Virified(titleId, verified, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment in the ordered set where titleId = &#63; and verified = &#63;.
	 *
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByTitleId_Virified_Last(long titleId, boolean verified,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByTitleId_Virified_Last(titleId, verified,
				orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titleId=");
		msg.append(titleId);

		msg.append(", verified=");
		msg.append(verified);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the last comment in the ordered set where titleId = &#63; and verified = &#63;.
	 *
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByTitleId_Virified_Last(long titleId, boolean verified,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitleId_Virified(titleId, verified);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByTitleId_Virified(titleId, verified,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where titleId = &#63; and verified = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param titleId the title ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment[] findByTitleId_Virified_PrevAndNext(long commentId,
		long titleId, boolean verified, OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByTitleId_Virified_PrevAndNext(session, comment,
					titleId, verified, orderByComparator, true);

			array[1] = comment;

			array[2] = getByTitleId_Virified_PrevAndNext(session, comment,
					titleId, verified, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByTitleId_Virified_PrevAndNext(Session session,
		Comment comment, long titleId, boolean verified,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMENT_WHERE);

		query.append(_FINDER_COLUMN_TITLEID_VIRIFIED_TITLEID_2);

		query.append(_FINDER_COLUMN_TITLEID_VIRIFIED_VERIFIED_2);

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
			query.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(titleId);

		qPos.add(verified);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(comment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Comment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where titleId = &#63; and verified = &#63; from the database.
	 *
	 * @param titleId the title ID
	 * @param verified the verified
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitleId_Virified(long titleId, boolean verified)
		throws SystemException {
		for (Comment comment : findByTitleId_Virified(titleId, verified,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(comment);
		}
	}

	/**
	 * Returns the number of comments where titleId = &#63; and verified = &#63;.
	 *
	 * @param titleId the title ID
	 * @param verified the verified
	 * @return the number of matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTitleId_Virified(long titleId, boolean verified)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TITLEID_VIRIFIED;

		Object[] finderArgs = new Object[] { titleId, verified };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_TITLEID_VIRIFIED_TITLEID_2);

			query.append(_FINDER_COLUMN_TITLEID_VIRIFIED_VERIFIED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titleId);

				qPos.add(verified);

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

	private static final String _FINDER_COLUMN_TITLEID_VIRIFIED_TITLEID_2 = "comment.titleId = ? AND ";
	private static final String _FINDER_COLUMN_TITLEID_VIRIFIED_VERIFIED_2 = "comment.verified = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEID = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitleId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID =
		new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitleId",
			new String[] { Long.class.getName() },
			CommentModelImpl.TITLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLEID = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitleId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the comments where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @return the matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByTitleId(long titleId) throws SystemException {
		return findByTitleId(titleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comments where titleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titleId the title ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByTitleId(long titleId, int start, int end)
		throws SystemException {
		return findByTitleId(titleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comments where titleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titleId the title ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findByTitleId(long titleId, int start, int end,
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

		List<Comment> list = (List<Comment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Comment comment : list) {
				if ((titleId != comment.getTitleId())) {
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

			query.append(_SQL_SELECT_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_TITLEID_TITLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titleId);

				if (!pagination) {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Comment>(list);
				}
				else {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first comment in the ordered set where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByTitleId_First(long titleId,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByTitleId_First(titleId, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titleId=");
		msg.append(titleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the first comment in the ordered set where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByTitleId_First(long titleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Comment> list = findByTitleId(titleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment in the ordered set where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByTitleId_Last(long titleId,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByTitleId_Last(titleId, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titleId=");
		msg.append(titleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the last comment in the ordered set where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByTitleId_Last(long titleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitleId(titleId);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByTitleId(titleId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where titleId = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param titleId the title ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment[] findByTitleId_PrevAndNext(long commentId, long titleId,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByTitleId_PrevAndNext(session, comment, titleId,
					orderByComparator, true);

			array[1] = comment;

			array[2] = getByTitleId_PrevAndNext(session, comment, titleId,
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

	protected Comment getByTitleId_PrevAndNext(Session session,
		Comment comment, long titleId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMENT_WHERE);

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
			query.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(titleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(comment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Comment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where titleId = &#63; from the database.
	 *
	 * @param titleId the title ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitleId(long titleId) throws SystemException {
		for (Comment comment : findByTitleId(titleId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(comment);
		}
	}

	/**
	 * Returns the number of comments where titleId = &#63;.
	 *
	 * @param titleId the title ID
	 * @return the number of matching comments
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

			query.append(_SQL_COUNT_COMMENT_WHERE);

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

	private static final String _FINDER_COLUMN_TITLEID_TITLEID_2 = "comment.titleId = ?";

	public CommentPersistenceImpl() {
		setModelClass(Comment.class);
	}

	/**
	 * Caches the comment in the entity cache if it is enabled.
	 *
	 * @param comment the comment
	 */
	@Override
	public void cacheResult(Comment comment) {
		EntityCacheUtil.putResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentImpl.class, comment.getPrimaryKey(), comment);

		comment.resetOriginalValues();
	}

	/**
	 * Caches the comments in the entity cache if it is enabled.
	 *
	 * @param comments the comments
	 */
	@Override
	public void cacheResult(List<Comment> comments) {
		for (Comment comment : comments) {
			if (EntityCacheUtil.getResult(
						CommentModelImpl.ENTITY_CACHE_ENABLED,
						CommentImpl.class, comment.getPrimaryKey()) == null) {
				cacheResult(comment);
			}
			else {
				comment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all comments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CommentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CommentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the comment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Comment comment) {
		EntityCacheUtil.removeResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentImpl.class, comment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Comment> comments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Comment comment : comments) {
			EntityCacheUtil.removeResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
				CommentImpl.class, comment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new comment with the primary key. Does not add the comment to the database.
	 *
	 * @param commentId the primary key for the new comment
	 * @return the new comment
	 */
	@Override
	public Comment create(long commentId) {
		Comment comment = new CommentImpl();

		comment.setNew(true);
		comment.setPrimaryKey(commentId);

		return comment;
	}

	/**
	 * Removes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment that was removed
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment remove(long commentId)
		throws NoSuchCommentException, SystemException {
		return remove((Serializable)commentId);
	}

	/**
	 * Removes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comment
	 * @return the comment that was removed
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment remove(Serializable primaryKey)
		throws NoSuchCommentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Comment comment = (Comment)session.get(CommentImpl.class, primaryKey);

			if (comment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(comment);
		}
		catch (NoSuchCommentException nsee) {
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
	protected Comment removeImpl(Comment comment) throws SystemException {
		comment = toUnwrappedModel(comment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(comment)) {
				comment = (Comment)session.get(CommentImpl.class,
						comment.getPrimaryKeyObj());
			}

			if (comment != null) {
				session.delete(comment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (comment != null) {
			clearCache(comment);
		}

		return comment;
	}

	@Override
	public Comment updateImpl(
		ir.ac.iut.sccportal.guestdiscussion.model.Comment comment)
		throws SystemException {
		comment = toUnwrappedModel(comment);

		boolean isNew = comment.isNew();

		CommentModelImpl commentModelImpl = (CommentModelImpl)comment;

		Session session = null;

		try {
			session = openSession();

			if (comment.isNew()) {
				session.save(comment);

				comment.setNew(false);
			}
			else {
				session.merge(comment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CommentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((commentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID_TITLEID_VERIFIED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						commentModelImpl.getOriginalParentId(),
						commentModelImpl.getOriginalTitleId(),
						commentModelImpl.getOriginalVerified()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID_TITLEID_VERIFIED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID_TITLEID_VERIFIED,
					args);

				args = new Object[] {
						commentModelImpl.getParentId(),
						commentModelImpl.getTitleId(),
						commentModelImpl.getVerified()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID_TITLEID_VERIFIED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID_TITLEID_VERIFIED,
					args);
			}

			if ((commentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID_VIRIFIED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						commentModelImpl.getOriginalTitleId(),
						commentModelImpl.getOriginalVerified()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLEID_VIRIFIED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID_VIRIFIED,
					args);

				args = new Object[] {
						commentModelImpl.getTitleId(),
						commentModelImpl.getVerified()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLEID_VIRIFIED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID_VIRIFIED,
					args);
			}

			if ((commentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						commentModelImpl.getOriginalTitleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID,
					args);

				args = new Object[] { commentModelImpl.getTitleId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLEID,
					args);
			}
		}

		EntityCacheUtil.putResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentImpl.class, comment.getPrimaryKey(), comment);

		return comment;
	}

	protected Comment toUnwrappedModel(Comment comment) {
		if (comment instanceof CommentImpl) {
			return comment;
		}

		CommentImpl commentImpl = new CommentImpl();

		commentImpl.setNew(comment.isNew());
		commentImpl.setPrimaryKey(comment.getPrimaryKey());

		commentImpl.setCommentId(comment.getCommentId());
		commentImpl.setGroupId(comment.getGroupId());
		commentImpl.setCompanyId(comment.getCompanyId());
		commentImpl.setModifiedDate(comment.getModifiedDate());
		commentImpl.setParentId(comment.getParentId());
		commentImpl.setParentName(comment.getParentName());
		commentImpl.setCommentText(comment.getCommentText());
		commentImpl.setGuestName(comment.getGuestName());
		commentImpl.setGuestEmailAddress(comment.getGuestEmailAddress());
		commentImpl.setGuestEmailNotification(comment.isGuestEmailNotification());
		commentImpl.setLikeCount(comment.getLikeCount());
		commentImpl.setDislikeCount(comment.getDislikeCount());
		commentImpl.setTitleId(comment.getTitleId());
		commentImpl.setVerified(comment.isVerified());
		commentImpl.setHasAnswer(comment.isHasAnswer());

		return commentImpl;
	}

	/**
	 * Returns the comment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the comment
	 * @return the comment
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByPrimaryKey(primaryKey);

		if (comment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return comment;
	}

	/**
	 * Returns the comment with the primary key or throws a {@link ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException} if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment
	 * @throws ir.ac.iut.sccportal.guestdiscussion.NoSuchCommentException if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByPrimaryKey(long commentId)
		throws NoSuchCommentException, SystemException {
		return findByPrimaryKey((Serializable)commentId);
	}

	/**
	 * Returns the comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comment
	 * @return the comment, or <code>null</code> if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Comment comment = (Comment)EntityCacheUtil.getResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
				CommentImpl.class, primaryKey);

		if (comment == _nullComment) {
			return null;
		}

		if (comment == null) {
			Session session = null;

			try {
				session = openSession();

				comment = (Comment)session.get(CommentImpl.class, primaryKey);

				if (comment != null) {
					cacheResult(comment);
				}
				else {
					EntityCacheUtil.putResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
						CommentImpl.class, primaryKey, _nullComment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
					CommentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return comment;
	}

	/**
	 * Returns the comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment, or <code>null</code> if a comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByPrimaryKey(long commentId) throws SystemException {
		return fetchByPrimaryKey((Serializable)commentId);
	}

	/**
	 * Returns all the comments.
	 *
	 * @return the comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ir.ac.iut.sccportal.guestdiscussion.model.impl.CommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Comment> findAll(int start, int end,
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

		List<Comment> list = (List<Comment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMENT;

				if (pagination) {
					sql = sql.concat(CommentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Comment>(list);
				}
				else {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the comments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Comment comment : findAll()) {
			remove(comment);
		}
	}

	/**
	 * Returns the number of comments.
	 *
	 * @return the number of comments
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

				Query q = session.createQuery(_SQL_COUNT_COMMENT);

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
	 * Initializes the comment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.ir.ac.iut.sccportal.guestdiscussion.model.Comment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Comment>> listenersList = new ArrayList<ModelListener<Comment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Comment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CommentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COMMENT = "SELECT comment FROM Comment comment";
	private static final String _SQL_SELECT_COMMENT_WHERE = "SELECT comment FROM Comment comment WHERE ";
	private static final String _SQL_COUNT_COMMENT = "SELECT COUNT(comment) FROM Comment comment";
	private static final String _SQL_COUNT_COMMENT_WHERE = "SELECT COUNT(comment) FROM Comment comment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "comment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Comment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Comment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CommentPersistenceImpl.class);
	private static Comment _nullComment = new CommentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Comment> toCacheModel() {
				return _nullCommentCacheModel;
			}
		};

	private static CacheModel<Comment> _nullCommentCacheModel = new CacheModel<Comment>() {
			@Override
			public Comment toEntityModel() {
				return _nullComment;
			}
		};
}