package edu.onlinetests.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.onlinetests.persistance.PersistanceManager;

public class PropertiesProvider {

	private static final Logger logger = LogManager.getLogger(PropertiesProvider.class);
	
	public static Properties getPropertiesFromFile(String path) {
		Properties properties = new Properties();
		try {
			URL url = PersistanceManager.class.getResource("/"+path);
			File file = new File(url.toURI());
			properties.load(new FileInputStream(file));
		} catch (IOException e) {
			logger.error("Properties file " + path + " not found!");
		} catch (URISyntaxException e) {
			logger.error("URL not an URI");
		}
		return properties;
	}
	
	public static Map<String, String> propertiesToMap(Properties properties) {
		Map<String, String> propertiesMap = new HashMap<String, String>();
		for (Entry<Object, Object> property : properties.entrySet()) {
			propertiesMap.put((String)property.getKey(), (String)property.getValue());
		}
		return propertiesMap;
	}
	
	
}