/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.fast.projects.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author acost
 */
public class JSONConverter {

    private JSONConverter() {
    }

    public static JSONConverter getInstance() {
        return JSONConverterHolder.INSTANCE;
    }

    private static class JSONConverterHolder {

        private static final JSONConverter INSTANCE = new JSONConverter();
    }

    public <E> E convert(Class<E> e, LinkedHashMap linkedHashMap) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(linkedHashMap, e);
    }

    public Map convert(InputStream inputStream) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Map.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshal = unmarshaller.unmarshal(inputStream);
        System.out.println("unmarshal: "+unmarshal);
return null;
    }
}
