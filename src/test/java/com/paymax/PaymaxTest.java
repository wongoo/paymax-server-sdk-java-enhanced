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
                String app = properties.getProperty("app");
                String secretKey = properties.getProperty("secret_key");
                String privateKey = properties.getProperty("private_key");
                String paymaxPublicKey = properties.getProperty("paymax_public_key");

                if (app != null) {
                    SignConfig.setApp(app);
                    System.out.println("set app:" + SignConfig.getApp());
                }
                if (secretKey != null) {
                    SignConfig.setSecretKey(secretKey);
                    System.out.println("set secret key:" + SignConfig.getSecretKey());
                }
                if (privateKey != null) {
                    SignConfig.setPrivateKey(privateKey);
                    System.out.println("set private key:" + SignConfig.getPrivateKey());
                }
                if (paymaxPublicKey != null) {
                    SignConfig.setPaymaxPublicKey(paymaxPublicKey);
                    System.out.println("set paymax public key:" + SignConfig.getPaymaxPublicKey());
                }

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
