package pki.certificate;

import identities.IdentityGenerator;
import lombok.Data;

import java.security.PublicKey;

@Data
public class CertificateCreationData {

    private String issuerCN;
    private String issuerCountry;
    private String issuerOrganisation;

    private String subjectCN;
    private String subjectCountry;
    private String subjectOrganisation;
    private String subjectEntityType;

    public PublicKey subjectPublicKey;

    public String crlDistributionPoint;
    public String authorityInfoAccessOCSP;

    public String caCertificateSerialNumber;

    public CertificateCreationData(String issuerCN, String subjectCN, PublicKey subjectPublicKey) {
        this.issuerCN = issuerCN;
        this.issuerCountry = CertificateHelper.COUNTRY;
        this.issuerOrganisation = CertificateHelper.ORGANISATION;
        this.subjectCN = subjectCN;
        this.subjectCountry = CertificateHelper.COUNTRY;
        this.subjectOrganisation = CertificateHelper.ORGANISATION;
        this.subjectPublicKey = subjectPublicKey;
        this.subjectEntityType = IdentityGenerator.getEntityTypeFromIdentifier(subjectCN);
    }
}
