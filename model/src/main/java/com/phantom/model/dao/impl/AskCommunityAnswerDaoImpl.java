package com.phantom.model.dao.impl;

import com.phantom.model.dao.AskCommunityAnswerDao;
import com.phantom.model.entity.AskCommunityAnswer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class AskCommunityAnswerDaoImpl extends GenericHibernateDAO<AskCommunityAnswer, Long> implements AskCommunityAnswerDao {

    @Override
    public boolean updateAnswerLike(int userId, String answerId) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update AskCommunityAnswer set totalLikes = totalLikes+1 where uuid = :uuid")
                    .setParameter("uuid", answerId);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating question like for question id : " + answerId, e);
        }
        return false;
    }

    @Override
    public boolean updateAnswerFollow(int userId, String answerId) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update AskCommunityAnswer set totalFollower = totalFollower+1 where uuid = :uuid")
                    .setParameter("uuid", answerId);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating question like for question id : " + answerId, e);
        }
        return false;
    }

    public List<AskCommunityAnswer> getAllAnswers(String questionId, int count) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(AskCommunityAnswer.class);
            criteria.add(Restrictions.eq("questionId", questionId));
            criteria.add(Restrictions.sqlRestriction("LIMIT " + count));
            List<AskCommunityAnswer> askCommunityAnswers = findByCriteria(criteria);
            if (askCommunityAnswers == null) {
                return new ArrayList<>(1);
            }
            return askCommunityAnswers;
        } catch (Exception e) {
            logger.error("Exception came while fetching answers for questions with id : "+questionId,e);
        }
        return new ArrayList<>(1);
    }
}
