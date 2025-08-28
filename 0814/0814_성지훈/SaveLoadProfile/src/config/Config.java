package config;

import java.io.*;
import java.util.*;

/**
 * 설정을 불러오는 클래스
 */
public class Config {
	
	private static Properties props = new Properties();
	
	static {
		try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
			props.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		return props.getProperty(key);
	}
}
