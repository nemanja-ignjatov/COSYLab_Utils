package pki.certificate;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequest;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CryptoConstants;

import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

public class CSRHandler {

    private static Logger logger = LoggerFactory.getLogger(CSRHandler.class);

    private static final Long CERTIFICATE_VALIDITY_PERIOD = 1L * 365L * 24L * 60L * 60L * 1000L;
    private static final String CA_FLAG_IDENTIFIER = "2.5.29.19";

    private PrivateKey caPrivateKey;

    public CSRHandler(PrivateKey privKey) throws OperatorCreationException {
        this.caPrivateKey = privKey;
    }


    public static PKCS10CertificationRequest generateCSR(PrivateKey privateKey, PublicKey publicKey, String subjectCN) throws OperatorCreationException {
        PKCS10CertificationRequestBuilder csrBuilder = new JcaPKCS10CertificationRequestBuilder(
                new X500Name(subjectCN), publicKey);

        return csrBuilder.build(
                new JcaContentSignerBuilder(CryptoConstants.SIGNATURE_ALGORITHM).
                        build(privateKey));
    }

    public X509Certificate generateCertificateFromCSR(Provider securityProvider, PKCS10CertificationRequest request, String caCN,
                                                      String crlDistributionPoint, String infoAccessOCSP, String caCertNumber) throws
            CertificateException {

        JcaPKCS10CertificationRequest jcaRequest = new JcaPKCS10CertificationRequest(request);

        CertificateCreationData certData = null;
        Map<String, String> subjectNames = CertificateHelper.parseX500Name(jcaRequest.getSubject());
        try {
            certData = new CertificateCreationData(caCN, subjectNames.get(CertificateHelper.ENTITY_CN), jcaRequest.getPublicKey());
            certData.setCrlDistributionPoint(crlDistributionPoint);
            certData.setAuthorityInfoAccessOCSP(infoAccessOCSP);
            certData.setCaCertificateSerialNumber(caCertNumber);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return CertificateKeyConverter.convertCertToX509(CertificateHelper.generateCertificate(securityProvider, caPrivateKey, certData));
    }
}
