package utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class CryptoConstants {

    public static final String CURVE_NAME = "secp256r1";
    public static final String KEY_PAIR_GEN_ALGORITHM = "ECDSA";
    public static final String SIGNATURE_ALGORITHM = "SHA256withECDSA";
    public static final String OID_SHA256_ECDSA = "1.2.840.10045.4.3.2";
    public static final String CERT_COMMON_NAME_PREFIX = "CN=";
    public static final String CERTIFICATE_FACTORY_NAME = "X.509";

    public static final String PROVIDER_NAME = BouncyCastleProvider.PROVIDER_NAME;

    public static final String AES_ALGORITHM = "AES/GCM/NoPadding";
    public static final String EC_ALGORITHM = "ECIES";

    public static final Integer PBDKF2_ITERATIONS = 250000;
    public static final String PBDKF2_ALGORITHM = "PBKDF2WithHmacSHA256";
    public static final int PBDKF2_KEYLENGTH = 256;
    public static final String PBKDF2_KEY_ALG = "AES";

    public static final String IDENTITY_ROOT_PART = "COSYLab";
    public static final String IDENTITY_SEPARATOR = ".";

    public static final String ISSUER_JWS_NAME = "iss";
}
