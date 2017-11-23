package com.paymax.sign;

import com.paymax.exception.PaymaxException;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaowei.wang on 2016/4/27.
 */
public class RSAKeyGenerateUtil {
    public static String ALGORITHM = "RSA";

    public static PrivateKey pkey;

    public static PublicKey pubkey;

    public static String PUBLIC_KEY = "PublicKey";
    public static String PRIVATE_KEY = "PrivateKey";

    public static Map<String, String> genKey() throws PaymaxException {

        KeyPairGenerator kpg = null;
        try {
            kpg = KeyPairGenerator.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new PaymaxException(e);
        }
        kpg.initialize(1024);
        KeyPair kep = kpg.generateKeyPair();
        Provider p = kpg.getProvider();
        System.out.println(p.getName());
        pkey = kep.getPrivate();
        pubkey = kep.getPublic();
        System.out.println("生成的公钥:" + new String(Base64.encode(pubkey.getEncoded())));
        System.out.println("====================================");
        System.out.println("生成的私钥:" + new String(Base64.encode(pkey.getEncoded())));

        Map<String, String> param = new HashMap<String, String>();
        param.put(PUBLIC_KEY, new String(Base64.encode(pubkey.getEncoded())));
        param.put(PRIVATE_KEY, new String(Base64.encode(pkey.getEncoded())));

        return param;
    }


    public static void main(String[] args) throws Exception {
        genKey();
    }
}
