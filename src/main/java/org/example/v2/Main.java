package org.example.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.Getter;
import org.example.v2.configuration.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Getter
public class Main {

    private static Configuration configuration;
    private static ObjectReader objectReader;
    private static ObjectMapper objectMapper;

    public static void main(String[] args) throws IOException {
        objectMapper = new ObjectMapper();
        InputStream json = loadConfigurationFromResource("config1.json");
        configuration = objectMapper.readValue(json, Configuration.class);
        objectReader = objectMapper.readerForUpdating(configuration);

        System.out.println("######################");
        update("config2.json");
    }

    public static void update(String fileName) throws IOException {
        InputStream json = loadConfigurationFromResource(fileName);
        objectReader.readValue(json);
    }

    private static InputStream loadConfigurationFromResource(String resourceName) {
        ClassLoader classLoader = Main.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(resourceName);
        return inputStream;
    }

}