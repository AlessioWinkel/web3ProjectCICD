package domain.util;

import domain.exceptions.DbException;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {


    public static String hashPassword(String password) {
        try{
            //create MessageDigest
            MessageDigest crypt = MessageDigest.getInstance("SHA-512");
//reset
            crypt.reset();
//update
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            crypt.update(passwordBytes);
//digest
            byte[] digest = crypt.digest();
//convert to String
            BigInteger digestAsBigInteger = new BigInteger(1, digest);
//return hashed password
            return digestAsBigInteger.toString(16);
        }catch(NoSuchAlgorithmException e){
            throw new DbException(e.getMessage());
        }

    }
}
