package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private static ConfigFileReader configReader;

    private ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = System.getProperty("user.dir")+"//src//test//java//config//config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public static ConfigFileReader getInstance( ) {
        if(configReader == null) {
            configReader = new ConfigFileReader();
        }
        return configReader;
    }


    public String getURL(String env) {
        String url="";
        if(env.equals("QA"))
            url = properties.getProperty("url_QA");
        else if(env.equals("DEV"))
            url = properties.getProperty("url_DEV");

        if(url != null) return url;
        else throw new RuntimeException("url not specified in the config.properties file.");
    }

    public String getEnv() {
        String env = properties.getProperty("envToExecute");
        if(env != null) return env;
        else throw new RuntimeException("url not specified in the config.properties file.");
    }

}
