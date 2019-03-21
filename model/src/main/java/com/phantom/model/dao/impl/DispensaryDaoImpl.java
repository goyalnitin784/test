package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryDao;
import com.phantom.model.entity.Dispensary;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryDaoImpl  extends GenericHibernateDAO<Dispensary, Long> implements DispensaryDao {
    @Override
    public void saveDispensary(Dispensary dispensary) {
        try{
            super.saveOrUpdate(dispensary);
        }catch (Exception e){
            logger.error("Exception came while saving object",e);
        }
    }
}
