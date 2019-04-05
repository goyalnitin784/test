package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryDao;
import com.phantom.model.entity.Dispensary;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DispensaryDaoImpl extends GenericHibernateDAO<Dispensary, Long> implements DispensaryDao {
    @Override
    public void saveDispensary(Dispensary dispensary) {
        try {
            super.saveOrUpdate(dispensary);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }

    public List<Dispensary> findDispOnLatLong(String lat, String longitude, String distance, int maxCount, boolean isFeaturedDispensary) {
        try {
            List<Integer> list = (List<Integer>)this.getHibernateTemplate().getSessionFactory().getCurrentSession().createNativeQuery("SELECT id,( 3959* acos( cos( radians(" + lat + ") )* cos(  radians( lattitude ))* cos(  radians( longitude ) - radians(" + longitude + ") )+ sin( radians(" + lat + ") )* sin( radians( lattitude ) )))AS distance FROM dispensary HAVING distance < " + distance + " ORDER BY distance LIMIT 0 , " + maxCount);
            if(list!=null && list.size()>0){
                DetachedCriteria criteria = DetachedCriteria.forClass(Dispensary.class);
                criteria.add(Restrictions.in("id", list));
                if(isFeaturedDispensary) {
                    criteria.add(Restrictions.eq("isFeaturedDispensary", 1));
                }
                List<Dispensary> dispensaries = findByCriteria(criteria);
                return dispensaries;
            }
        } catch (Throwable e) {
            logger.error("Exception came while fetching nearby dispensery for distance : " + distance, e);
        }
        return null;
    }

    @Override
    public List<String> findDispIDNearYou(String lat, String longitude, String distance) {
        List<String> list = (List<String>)this.getHibernateTemplate().getSessionFactory().getCurrentSession().createNativeQuery("SELECT uuid,( 3959* acos( cos( radians(" + lat + ") )* cos(  radians( lattitude ))* cos(  radians( longitude ) - radians(" + longitude + ") )+ sin( radians(" + lat + ") )* sin( radians( lattitude ) )))AS distance FROM dispensary HAVING distance < " + distance + " ORDER BY distance ");
        return list;
    }

    @Override
    public long getDispId(String uuid) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(Dispensary.class);
            criteria.add(Restrictions.eq("uuid", uuid));
            return findByCriteria(criteria).get(0).getId();
        }catch (Exception e){
            logger.error("Exception occurred while getting disp id for disp uuid : "+uuid, e);
            return -1;
        }
    }

    @Override
    public Dispensary getDispensaryByDispUuid(String dispUUID) {
        try{
            DetachedCriteria criteria = DetachedCriteria.forClass(Dispensary.class);
            criteria.add(Restrictions.eq("uuid", dispUUID));
            return findByCriteria(criteria).get(0);
        }catch(Exception e){
            logger.error("Exception occurred while getting dispensary using disp id : "+dispUUID, e);
            return null;
        }
    }
}
