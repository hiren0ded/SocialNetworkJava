package com.hiren.social.socialnetwork.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Utility class to generate SHA and Salt based Encrypted password.
 * It uses Singleton Design Pattern
 */
public class HashGenerator {

    private static final HashGenerator hashGenerator = new HashGenerator();
    //TODO: Move this constant to general constant class
    private static final String ENCRYPTION_METHOD = "SHA-512";

    //Singleton Design Pattetn
    private HashGenerator(){

    }

    /**
     * Generate Random String for Salt based encryption
     * @return
     */
    private byte[] getSalt(){
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }

    /**
     * Generate Object for specified Encryption Method
     * @return
     */
    private MessageDigest hashFunction(){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(ENCRYPTION_METHOD);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return messageDigest;
    }

    /**
     * Generate Hashed Password using (Salt + Encryption) Method
     * @return
     */
    public static String[] hashPassword(final String password){
        MessageDigest messageDigest = hashGenerator.hashFunction();
        if(messageDigest == null) return null;

        String[] object = new String[2];
        byte[] salt = hashGenerator.getSalt();

        messageDigest.update(salt);
        byte[] hashedPassword = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        object[0] = salt.toString();
        object[1] = hashedPassword.toString();

        return object;
    }
}
