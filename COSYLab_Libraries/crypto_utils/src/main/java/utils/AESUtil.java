package utils;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import static utils.CryptoConstants.*;

public class AESUtil {

    public static String encryptString(String strToEncrypt, SecretKey secretKey, IvParameterSpec ivSpec) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return Base64.getEncoder().encodeToString(
                cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));

    }

    public static String decryptString(String strToDecrypt, SecretKey secretKey, IvParameterSpec ivSpec) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));

    }

    public static SecretKey generateAESKey(String keyInput, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {

        SecretKeyFactory factory = SecretKeyFactory.getInstance(PBDKF2_ALGORITHM);

        KeySpec spec = new PBEKeySpec(keyInput.toCharArray(), salt.getBytes(), PBDKF2_ITERATIONS, PBDKF2_KEYLENGTH);
        SecretKey key = factory.generateSecret(spec);

        return new SecretKeySpec(key.getEncoded(), PBKDF2_KEY_ALG);

    }

}
