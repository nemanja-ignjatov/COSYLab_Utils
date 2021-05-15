package pki.certificate;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import utils.CryptoConstants;

import java.math.BigInteger;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;

public class CertificateHelper {

    public static Certificate generateSelfSignedCertificate(Provider securityProvider, KeyPair keyPair, String subjectDN) {

        long now = System.currentTimeMillis();

        Date startDate = new Date(now);

        X500Name dnName = new X500Name(subjectDN);
        BigInteger certSerialNumber = new BigInteger(Long.toString(now));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.YEAR, 1); // <-- 1 Yr validity

        Date endDate = calendar.getTime();

        String signatureAlgorithm = CryptoConstants.SIGNATURE_ALGORITHM; // <-- Use appropriate signature algorithm based on your keyPair algorithm.

        ContentSigner contentSigner = null;
        try {
            contentSigner = new JcaContentSignerBuilder(signatureAlgorithm).build(keyPair.getPrivate());


        JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(dnName, certSerialNumber, startDate, endDate, dnName, keyPair.getPublic());
        // Extensions --------------------------

        // Basic Constraints
        BasicConstraints basicConstraints = new BasicConstraints(true); // <-- true for CA, false for EndEntity

        certBuilder.addExtension(new ASN1ObjectIdentifier("2.5.29.19"), true, basicConstraints); // Basic Constraints is usually marked as critical.

        return new JcaX509CertificateConverter().setProvider(securityProvider).getCertificate(certBuilder.build(contentSigner));
        } catch (OperatorCreationException | CertificateException | CertIOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean verifyCertificateSignature(PublicKey signerPublicKey, X509Certificate verifiedCertificate) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance(CryptoConstants.SIGNATURE_ALGORITHM);
        signature.initVerify(signerPublicKey);
        return signature.verify(verifiedCertificate.getSignature());
    }
}
