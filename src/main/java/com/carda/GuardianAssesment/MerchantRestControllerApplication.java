package com.carda.GuardianAssesment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MerchantRestControllerApplication {

	private static final Properties properties;

	static {
		properties = new Properties();

		try {
			ClassLoader classLoader = MerchantRestControllerApplication.class.getClassLoader();
			InputStream applicationPropertiesStream = classLoader.getResourceAsStream("application.properties");
			properties.load(applicationPropertiesStream);
		} catch (Exception e) {
			// process the exception
		}
	}

	public static void main(String[] args) {

		Properties envProperties = new Properties();
		String envAppProp = properties.getProperty("config.environment") + ".properties";
		ClassLoader classLoader = MerchantRestControllerApplication.class.getClassLoader();
		InputStream applicationPropertiesStream = classLoader.getResourceAsStream(envAppProp);
		try {
			envProperties.load(applicationPropertiesStream);
		} catch (IOException e) {
			System.out.println("Environmental properties could not load!");
		}

		new SpringApplicationBuilder(MerchantRestControllerApplication.class).properties(envProperties).build()
				.run(args);

	}

}
