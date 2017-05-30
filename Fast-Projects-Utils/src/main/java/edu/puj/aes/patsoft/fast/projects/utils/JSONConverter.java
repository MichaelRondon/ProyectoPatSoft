/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.fast.projects.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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

    public <E> E convert(Class<E> e, String xmlString) throws JAXBException {
        StringReader stringReader = new StringReader(xmlString);
        JAXBContext jaxbContext = JAXBContext.newInstance(e);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (E) unmarshaller.unmarshal(stringReader);
    }

    public <E> String convert(Class<E> e, E object) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(e);
        StringWriter stringWriter = new StringWriter();
        Marshaller createMarshaller = jaxbContext.createMarshaller();
        createMarshaller.marshal(object, stringWriter);
        stringWriter.flush();
        return stringWriter.toString();
    }
}
