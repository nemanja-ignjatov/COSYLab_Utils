package pki.certificate;

import identities.CloudServiceType;
import identities.EntityType;
import identities.FogServiceType;
import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.*;
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
import java.util.*;

public class CertificateHelper {

    private static final int CERTIFICATE_VALID_YEARS = 1;

    private static final String ENTITY_INFORMATION_SEPARATOR = ",";
    private static final String ENTITY_INFORMATION_BINDER = "=";

    public static final String ENTITY_CN = "CN";
    private static final String ENITTY_O = "O";
    private static final String ENTITY_C = "C";

    private static final String CN_PREFIX = ENTITY_CN + ENTITY_INFORMATION_BINDER;
    private static final String O_PREFIX = ENITTY_O + ENTITY_INFORMATION_BINDER;
    private static final String C_PREFIX = ENTITY_C + ENTITY_INFORMATION_BINDER;

    public static final String COUNTRY = "AT";
    public static final String ORGANISATION = "COSYLab";

    public static Certificate generateCertificate(Provider securityProvider, PrivateKey issuerPrivateKey, CertificateCreationData certificateData) {

        //Certificate validity
        long now = System.currentTimeMillis();
        Date startDate = new Date(now);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.YEAR, CERTIFICATE_VALID_YEARS);

        Date endDate = calendar.getTime();

        // Certificate serial number
        BigInteger certSerialNumber = new BigInteger(Long.toString(now));

        // Signature algorithm
        String signatureAlgorithm = CryptoConstants.SIGNATURE_ALGORITHM; // <-- Use appropriate signature algorithm based on your keyPair algorithm.

        // Subject information
        String subjectDN = CN_PREFIX + certificateData.getSubjectCN() + ENTITY_INFORMATION_SEPARATOR +
                O_PREFIX + certificateData.getSubjectOrganisation() + ENTITY_INFORMATION_SEPARATOR +
                C_PREFIX + certificateData.getSubjectCountry();

        X500Name subject = new X500Name(subjectDN);

        // Issuer information
        String issuerDN = CN_PREFIX + certificateData.getIssuerCN() + ENTITY_INFORMATION_SEPARATOR +
                O_PREFIX + certificateData.getIssuerOrganisation() + ENTITY_INFORMATION_SEPARATOR +
                C_PREFIX + certificateData.getIssuerCountry();

        X500Name issuer = new X500Name(issuerDN);

        try {
            ContentSigner contentSigner = new JcaContentSignerBuilder(signatureAlgorithm).build(issuerPrivateKey);


            JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(issuer, certSerialNumber, startDate, endDate, subject, certificateData.getSubjectPublicKey());
            // Extensions --------------------------

            certBuilder.addExtension(Extension.keyUsage, true,
                    getKeyUsageForEntity(certificateData.getSubjectEntityType()));

            certBuilder.addExtension(Extension.basicConstraints, true, getBasicConstraintsForEntity(certificateData.getSubjectEntityType())); // Basic Constraints is usually marked as critical.

            if (certificateData.getCrlDistributionPoint() != null) {
                certBuilder.addExtension(Extension.cRLDistributionPoints, true,
                        getCRLDistributionPoint(certificateData.getCrlDistributionPoint()));
            }

            if (certificateData.getAuthorityInfoAccessOCSP() != null) {
                certBuilder.addExtension(Extension.authorityInfoAccess, true,
                        getOCSPInfoAccess(certificateData.getAuthorityInfoAccessOCSP()));
            }

            if (certificateData.getCaCertificateSerialNumber() != null) {
                certBuilder.addExtension(Extension.authorityKeyIdentifier, false,
                        getAuthorityKeyIdentifier(certificateData.getIssuerCN(), new BigInteger(certificateData.getCaCertificateSerialNumber())));
            }

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

    public static Map<String, String> parseX500Name(X500Name entityData) {
        Map<String, String> retMap = new HashMap<>();
        String[] parts = entityData.toString().split(ENTITY_INFORMATION_SEPARATOR);
        for (String part : parts) {
            String[] keyValue = part.split(ENTITY_INFORMATION_BINDER);
            retMap.put(keyValue[0], keyValue[1]);
        }

        return retMap;
    }

    private static KeyUsage getKeyUsageForEntity(String subjectEntityType) {
        if (subjectEntityType.equals(CloudServiceType.TNTA.toString())) {
            return new KeyUsage(KeyUsage.digitalSignature | KeyUsage.nonRepudiation | KeyUsage.cRLSign | KeyUsage.keyEncipherment | KeyUsage.keyCertSign);
        } else if (subjectEntityType.equals(FogServiceType.FTA.toString()) || subjectEntityType.equals(FogServiceType.FTP) ||
                subjectEntityType.equals(FogServiceType.FACA.toString())) {
            return new KeyUsage(KeyUsage.digitalSignature | KeyUsage.nonRepudiation | KeyUsage.keyCertSign);
        } else if (subjectEntityType.equals(EntityType.USER.toString())) {
            return new KeyUsage(KeyUsage.digitalSignature | KeyUsage.nonRepudiation | KeyUsage.dataEncipherment);
        } else if (subjectEntityType.equals(EntityType.THING.toString())) {
            return new KeyUsage(KeyUsage.digitalSignature | KeyUsage.nonRepudiation | KeyUsage.keyCertSign | KeyUsage.keyAgreement);
        } else {
            return new KeyUsage(KeyUsage.digitalSignature | KeyUsage.nonRepudiation);
        }
    }

    private static BasicConstraints getBasicConstraintsForEntity(String subjectEntityType) {
        if (subjectEntityType.equals(CloudServiceType.TNTA.toString())) {
            return new BasicConstraints(3);
        } else if (subjectEntityType.equals(FogServiceType.FTA.toString())) {
            return new BasicConstraints(2);
        } else if (subjectEntityType.equals(FogServiceType.FTP.toString()) ||
                subjectEntityType.equals(FogServiceType.FACA.toString())) {
            return new BasicConstraints(1);
        } else {
            return new BasicConstraints(false);
        }
    }

    private static CRLDistPoint getCRLDistributionPoint(String crlDistributionURL) {
        GeneralName gn = new GeneralName(GeneralName.uniformResourceIdentifier, new DERIA5String(crlDistributionURL));
        GeneralNames gns = new GeneralNames(gn);
        DistributionPointName dpn = new DistributionPointName(0, gns);
        List<DistributionPoint> l = new ArrayList<>();
        l.add(new DistributionPoint(dpn, null, null));
        return new CRLDistPoint(l.toArray(new DistributionPoint[0]));
    }

    private static AuthorityInformationAccess getOCSPInfoAccess(String ocspPoint) {
        GeneralName gn = new GeneralName(GeneralName.uniformResourceIdentifier, new DERIA5String(ocspPoint));
        AccessDescription acDesc = new AccessDescription(AccessDescription.id_ad_ocsp, gn);
        return new AuthorityInformationAccess(acDesc);
    }

    private static AuthorityKeyIdentifier getAuthorityKeyIdentifier(String certIssuer, BigInteger certSerialNumber) {
        GeneralName gn = new GeneralName(GeneralName.uniformResourceIdentifier, new DERIA5String(certIssuer));
        GeneralNames gns = new GeneralNames(gn);
        return new AuthorityKeyIdentifier(gns, certSerialNumber);
    }

}
