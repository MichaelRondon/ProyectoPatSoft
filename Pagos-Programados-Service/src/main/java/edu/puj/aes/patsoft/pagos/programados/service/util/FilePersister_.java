/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.patsoft.pagos.programados.service.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.puj.aes.patsoft.pagos.programados.service.control.PagoProgramadoImpl;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acost
 */
public class FilePersister_ {

    private final String persistenceDirectory;

    public FilePersister_(String persistenceDirectory) {
        this.persistenceDirectory = persistenceDirectory;
    }

    public <E> void guardar(String fileName, E e) {
        Path path = Paths.get(persistenceDirectory);
        try {
            path = Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(PagoProgramadoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        path = path.resolve(fileName);

        ObjectMapper objectMapper = new ObjectMapper();

        try (FileWriter fileWriter = new FileWriter(path.toFile())) {
            objectMapper.writeValue(fileWriter, e);
        } catch (IOException ex) {
            Logger.getLogger(FilePersister_.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public <E> E cargar(String fileName, Class<E> e) {
        Path path = Paths.get(persistenceDirectory);
        path = path.resolve(fileName);

        ObjectMapper objectMapper = new ObjectMapper();

        try (FileReader fileReader = new FileReader(path.toFile())) {
            return (E) objectMapper.readValue(fileReader, e);
        } catch (IOException ex) {
            Logger.getLogger(FilePersister_.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public <E> E convert(Class<E> e, LinkedHashMap linkedHashMap) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(linkedHashMap, e);
    }
}
