package com.paymax;

import com.paymax.config.SignConfig;

import org.junit.BeforeClass;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author wangoo
 * @since 2017-11-27 10:49
 */

public class PaymaxTest {

    private static String testConfigFileClassPath = "paymaxtest.properties";

    @BeforeClass
    public static void init() {
        try {
            InputStream stream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(testConfigFileClassPath);

            if (stream == null) {
                System.err.println("======================");
                System.err.println("paymax test config file not exist: " + testConfigFileClassPath);
                System.err.println("======================");
            } else {
                Properties properties = new Properties();
                properties.load(stream);

                SignConfig.setApp(properties.getProperty("app"));
                SignConfig.setSecretKey(properties.getProperty("secret_key"));
                SignConfig.setPrivateKey(properties.getProperty("private_key"));

                System.out.println("set app:" + SignConfig.getApp());
                System.out.println("set secret key:" + SignConfig.getSecretKey());

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
