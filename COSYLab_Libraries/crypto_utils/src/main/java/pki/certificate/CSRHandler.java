package pki.certificate;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequest;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CryptoConstants;
import utils.CryptoUtilFunctions;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

public class CSRHandler {

    private static Logger logger = LoggerFactory.getLogger(CSRHandler.class);

    private static final Long CERTIFICATE_VALIDITY_PERIOD = 1L * 365L * 24L * 60L * 60L * 1000L;
    private static final String CA_FLAG_IDENTIFIER = "2.5.29.19";

    private ContentSigner contentSigner;

    public CSRHandler(PrivateKey privKey) throws OperatorCreationException {
        this.contentSigner = CryptoUtilFunctions.prepareContentSigner(privKey);
    }


    public static PKCS10CertificationRequest generateCSR(PrivateKey privateKey, PublicKey publicKey, String subjectCN) throws OperatorCreationException {
        PKCS10CertificationRequestBuilder csrBuilder = new JcaPKCS10CertificationRequestBuilder(
                new X500Name(subjectCN), publicKey);

        return csrBuilder.build(
                new JcaContentSignerBuilder(CryptoConstants.SIGNATURE_ALGORITHM).
                        build(privateKey));
    }

    public X509Certificate generateCertificateFromCSR(PKCS10CertificationRequest request, boolean flagCA, X509Certificate caCert) throws
            CertificateException {

        BasicConstraints basicConstraints;

        JcaPKCS10CertificationRequest jcaRequest = new JcaPKCS10CertificationRequest(request);

        PublicKey publicKey;
        try {
            publicKey = jcaRequest.getPublicKey();
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            logger.error(e.toString());
            throw new SecurityException(e.getMessage(), e.getCause());
        }
        if (flagCA)
            basicConstraints = new BasicConstraints(0);
        else
            basicConstraints = new BasicConstraints(false);

        X509v3CertificateBuilder certGen;
        try {
            certGen = new JcaX509v3CertificateBuilder(
                    caCert,
                    BigInteger.valueOf(System.currentTimeMillis()),
                    new Date(System.currentTimeMillis()),
                    new Date(System.currentTimeMillis() + CERTIFICATE_VALIDITY_PERIOD),
                    jcaRequest.getSubject(),
                    publicKey)
                    .setIssuerUniqueID(new boolean[]{true, true, false, false})
                    .addExtension(
                            new ASN1ObjectIdentifier(CA_FLAG_IDENTIFIER),
                            false,
                            basicConstraints);
        } catch (CertIOException e) {
            logger.error(e.toString());
            throw new SecurityException(e.getMessage(), e.getCause());
        }

        return new JcaX509CertificateConverter()
                .setProvider(CryptoConstants.PROVIDER_NAME)
                .getCertificate(certGen
                        .build(contentSigner));
    }
}
