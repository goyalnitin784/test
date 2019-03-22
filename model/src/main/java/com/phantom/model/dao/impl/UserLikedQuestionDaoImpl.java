package com.phantom.model.dao.impl;

import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.UserLikedQuestionDao;
import com.phantom.model.entity.UserLikedQuestion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserLikedQuestionDaoImpl extends GenericHibernateDAO<UserLikedQuestion, Long> implements UserLikedQuestionDao {

    PhantomLogger logger = PhantomLogger.getLoggerObject(this.getClass());

    public boolean saveDetails(UserLikedQuestion userLikedQuestion) {
        DetachedCriteria criteria = DetachedCriteria.forClass(UserLikedQuestion.class);
        criteria.add(Restrictions.eq("userId", userLikedQuestion.getUserId()));
        criteria.add(Restrictions.eq("questionId", userLikedQuestion.getQuestionId()));
        criteria.addOrder(Order.desc("createdOn"));
        UserLikedQuestion likedQuestion = findByCriteria(criteria).get(0);
        if (likedQuestion == null) {
            try {
                super.saveOrUpdate(userLikedQuestion);
                return true;
            } catch (Exception e) {
                logger.error("Exception came while saving user liked question", e);
                return false;
            }
        } else {
            likedQuestion.setFollowFlag(userLikedQuestion.getFollowFlag());
            likedQuestion.setLikeFlag(userLikedQuestion.getLikeFlag());
            try {
                super.saveOrUpdate(likedQuestion);
                return true;
            } catch (Exception e) {
                logger.error("Exception came while saving user liked question", e);
                return false;
            }
        }
    }
}
