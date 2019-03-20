package com.phantom.dispensary.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.ProductsCategoryTypeDao;
import com.phantom.model.entity.ProductsCategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispensaryService {

    PhantomLogger logger  = PhantomLogger.getLoggerObject(this.getClass());

    @Autowired ProductsCategoryTypeDao productsCategoryTypeDao;

    public String getProductList(){
        try{
            List<ProductsCategoryType> productsCategoryTypeList = productsCategoryTypeDao.findAll();
            if(productsCategoryTypeList==null || productsCategoryTypeList.size()==0){
                return "[]";
            }
            JsonArray jsonElements = new JsonArray();
            for(ProductsCategoryType productsCategoryType : productsCategoryTypeList){
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("category",productsCategoryType.getProductCategory());
                jsonObject.addProperty("desc",productsCategoryType.getDescription());
                jsonElements.add(jsonObject);
            }

            return jsonElements.toString();
        }catch (Exception e){
            logger.error("Exception came while fetching product",e);
            return "[]";
        }
    }

}
