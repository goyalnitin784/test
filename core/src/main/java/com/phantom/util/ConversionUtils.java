package com.phantom.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.phantom.dto.BaseDTO;
import com.phantom.logging.PhantomLogger;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;


public class ConversionUtils {

    private static PhantomLogger logger = PhantomLogger.getLoggerObject(ConversionUtils.class);

    private static ObjectMapper mapper = new ObjectMapper();

    private static com.fasterxml.jackson.databind.ObjectMapper mapperNew = new com.fasterxml.jackson.databind.ObjectMapper();

    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(String xml, Class<T> type) {
        if (StringUtils.isNotBlank(xml)) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(type);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                StringReader reader = new StringReader(xml);
                return (T) unmarshaller.unmarshal(reader);
            } catch (Exception e) {
                logger.error("Exception occured while unmarshalling object." + e.getMessage());
            }
        }
        return null;
    }

    public static <T> String marshal(T object, Class<T> type) {
        if (object != null) {
            try {
                JAXBContext context = JAXBContext.newInstance(type);
                Marshaller marshaller = context.createMarshaller();
                StringWriter stringWriter = new StringWriter();
                marshaller.marshal(object, stringWriter);
                return stringWriter.toString();
            } catch (Exception e) {
                logger.error("Exception occured while marshalling object." + e.getMessage());
            }
        }
        return null;
    }

    public static <T> T unmarshalJson(String json, Class<T> type) {
        if (StringUtils.isNotBlank(json)) {
            try {
                return mapper.readValue(json, type);
            } catch (Exception e) {
                logger.error("Exception occured while unmarshalling json object." + e.getMessage());
            }
        }
        return null;
    }

    public static <T> String marshalJson(T object) {
        if (object != null) {
            try {
                return mapper.writeValueAsString(object);
            } catch (Exception e) {
                logger.error("Exception occured while marshalling json object." + e.getMessage());
            }
        }
        return null;
    }

    public static <T> T unmarshalJsonNew(String json, Class<T> type) {
        if (StringUtils.isNotBlank(json)) {
            try {
                return mapperNew.readValue(json, type);
            } catch (Exception e) {
                logger.error("Exception occured while unmarshalling json object." + e.getMessage());
            }
        }
        return null;
    }

    public static <T> String marshalJsonNew(T object) {
        if (object != null) {
            try {
                return mapperNew.writeValueAsString(object);
            } catch (Exception e) {
                logger.error("Exception occured while marshalling json object." + e.getMessage());
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String json = "{\"userInfo\":{\"userId\":1234,\"email\":\"yatratestbookings@gmail.com\",\"mobile\":\"5795793459\"},\"searchCriteria\":{\"destinationCountry\":\"IN\",\"origin\":\"DEL\",\"destination\":\"BOM\",\"originCountry\":\"IN\",\"tenantId\":17,\"supplierId\":null,\"tripType\":\"R\",\"cabin\":\"Economy\",\"departureDate\":\"2019-01-19\",\"returnDate\":\"2019-01-19\",\"adt\":1,\"chd\":0,\"inf\":0},\"superPnr\":\"25714726\",\"flightInfo\":[{\"id\":\"DELBOMSG159HB20190102\",\"dt\":\"T-1D\",\"at\":\"T-1\",\"vac\":\"SG\"},{\"id\":\"BOMDELSG160HB20190119\",\"dt\":\"T-1\",\"at\":\"T-1C\",\"vac\":\"SG\"}],\"priceInfo\":{\"ttv\":8229,\"ysf\":450},\"promoInfo\":{\"promoCode\":\"TESTPROMOFORBUS\",\"promoAmount\":126},\"ttid\":\"1125714726\",\"rahul\":\"dev\"}";
        BaseDTO request = ConversionUtils.unmarshalJsonNew(json, BaseDTO.class);
        System.out.println(request.toString());
    }
}