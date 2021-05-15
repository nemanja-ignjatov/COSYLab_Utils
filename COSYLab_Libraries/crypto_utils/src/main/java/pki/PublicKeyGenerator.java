package pki;

import utils.CryptoConstants;

import java.security.*;
import java.security.spec.ECGenParameterSpec;


public class PublicKeyGenerator {

    public static KeyPair generatePublicKeyPair() throws NoSuchProviderException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException {
        ECGenParameterSpec ecGenSpec = new ECGenParameterSpec(CryptoConstants.CURVE_NAME);
        KeyPairGenerator g = KeyPairGenerator.getInstance(CryptoConstants.KEY_PAIR_GEN_ALGORITHM, CryptoConstants
                .PROVIDER_NAME);
        g.initialize(ecGenSpec, new SecureRandom());
        return g.generateKeyPair();
    }

}
