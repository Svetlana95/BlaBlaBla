package org.bitbucket.automation.utils;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Random;

public class StringGenerator {

    private static SecureRandom random = new SecureRandom();

    public static String getString() {
        return new BigInteger(130, random).toString(32);
    }

    public static String getKey() {
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

}
