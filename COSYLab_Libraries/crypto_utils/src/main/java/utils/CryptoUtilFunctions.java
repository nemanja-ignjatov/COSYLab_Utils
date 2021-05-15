package utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.UUID;

public class CryptoUtilFunctions {
    
    public static Provider initializeSecurityProvider() {
        BouncyCastleProvider bc = new BouncyCastleProvider();
        Security.addProvider(bc);
        return bc;
    }

    public static String generateCertCommonName(String identifier) {
        return CryptoConstants.CERT_COMMON_NAME_PREFIX + identifier;
    }

    public static ContentSigner prepareContentSigner(PrivateKey privKey) throws OperatorCreationException {
        return new JcaContentSignerBuilder(CryptoConstants.SIGNATURE_ALGORITHM).setProvider
                (CryptoConstants.PROVIDER_NAME).build
                (privKey);
    }

    public static String createSHA256Hash(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < encodedHash.length; i++) {
                String hex = Integer.toHexString(0xff & encodedHash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
