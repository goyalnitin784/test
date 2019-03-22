package com.phantom.model.dao.impl;

import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.AskCommunityQuestionsDao;
import com.phantom.model.entity.AskCommunityQuestions;
import com.phantom.util.PhantomUtil;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class AskCommunityQuestionsDaoImpl extends GenericHibernateDAO<AskCommunityQuestions, Long> implements AskCommunityQuestionsDao {

    private static final PhantomLogger logger = PhantomLogger.getLoggerObject(AskCommunityQuestionsDaoImpl.class);

    public AskCommunityQuestions getQuestion(String uuid) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(AskCommunityQuestions.class);
            criteria.add(Restrictions.eq("uuid", uuid));
            return findByCriteria(criteria).get(0);
        } catch (Exception e) {
            logger.error("Exception came while fetching top questions", e);
        }
        return null;
    }

    @Override
    public List<AskCommunityQuestions> getTopQuestions(int userId, String dispId, String strainId, int count) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(AskCommunityQuestions.class);
            if (userId != 0) {
                criteria.add(Restrictions.eq("userId", userId));
            }
            if (!PhantomUtil.isNullOrEmpty(dispId)) {
                criteria.add(Restrictions.eq("dispensaryId", dispId));
            }
            if (!PhantomUtil.isNullOrEmpty(strainId)) {
                criteria.add(Restrictions.eq("strainId", strainId));
            }
            criteria.getExecutableCriteria(getSessionFactory().getCurrentSession()).setMaxResults(count);
            criteria.addOrder(Order.desc("createdOn"));
            return findByCriteria(criteria);
        } catch (Exception e) {
            logger.error("Exception came while fetching top questions", e);
        }
        return new ArrayList<>(1);
    }

    @Override
    public boolean updateQuestionLike(int userId, String questionId) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update AskCommunityQuestions set totalLikes = totalLikes+1 where uuid = :uuid")
                    .setParameter("uuid", questionId);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating question like for question id : " + questionId, e);
        }
        return false;
    }

    @Override
    public boolean updateQuestionFollow(int userId, String questionId) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update AskCommunityQuestions set totalFollower = totalFollower+1 where uuid = :uuid")
                    .setParameter("uuid", questionId);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating question follower for question id : " + questionId, e);
        }
        return false;
    }

    public boolean saveQuestion(AskCommunityQuestions q){
        try{
            super.saveOrUpdate(q);
            return true;
        }catch (Exception e){
            logger.error("Exception came while saving ask community question",e);
        }
        return false;
    }
}
