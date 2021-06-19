package pki.certificate;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import utils.CryptoConstants;

import java.io.*;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertificateKeyConverter {

    private static final String CSR_KEY = "CERTIFICATE REQUEST";

    public static X509Certificate convertCertToX509(Certificate cert) throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance(CryptoConstants.CERTIFICATE_FACTORY_NAME);
        ByteArrayInputStream bais = new ByteArrayInputStream(cert.getEncoded());
        return (X509Certificate) cf.generateCertificate(bais);
    }

    public static String convertX509ToPEM(X509Certificate signedCertificate) throws IOException {
        StringWriter signedCertificatePEMDataStringWriter = new StringWriter();
        JcaPEMWriter pemWriter = new JcaPEMWriter(signedCertificatePEMDataStringWriter);
        pemWriter.writeObject(signedCertificate);
        pemWriter.close();
        return signedCertificatePEMDataStringWriter.toString().replace("\r", "");
    }

    public static X509Certificate convertPEMToX509(String pemCertificate) throws IOException, CertificateException {
        StringReader reader = new StringReader(pemCertificate);
        PemReader pr = new PemReader(reader);
        PemObject pemObject = pr.readPemObject();
        X509CertificateHolder certificateHolder = new X509CertificateHolder(pemObject.getContent());
        return new JcaX509CertificateConverter().setProvider(CryptoConstants.PROVIDER_NAME).getCertificate(certificateHolder);
    }

    public static X509Certificate convertPEMToX509(FileReader pemFileReader) throws IOException, CertificateException {
        PemReader pr = new PemReader(pemFileReader);
        PemObject pemObject = pr.readPemObject();
        X509CertificateHolder certificateHolder = new X509CertificateHolder(pemObject.getContent());
        return new JcaX509CertificateConverter().setProvider(CryptoConstants.PROVIDER_NAME).getCertificate(certificateHolder);
    }

    public static PKCS10CertificationRequest convertPemToPKCS10CertificationRequest(String pem) {
        PKCS10CertificationRequest csr = null;
        ByteArrayInputStream pemStream;
        try {
            pemStream = new ByteArrayInputStream(pem.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new SecurityException(ex.getMessage(), ex.getCause());
        }
        Reader pemReader = new BufferedReader(new InputStreamReader(pemStream));
        PEMParser pemParser = new PEMParser(pemReader);
        try {
            Object parsedObj = pemParser.readObject();

            if (parsedObj instanceof PKCS10CertificationRequest) {
                csr = (PKCS10CertificationRequest) parsedObj;
            }
        } catch (IOException ex) {
            throw new SecurityException(ex.getMessage(), ex.getCause());
        }
        return csr;
    }

    public static String convertPKCS10CertificationRequestToPEM(PKCS10CertificationRequest certificationRequest) throws IOException {
        PemObject pemObject = new PemObject(CSR_KEY, certificationRequest.getEncoded());
        StringWriter str = new StringWriter();
        JcaPEMWriter pemWriter = new JcaPEMWriter(str);
        pemWriter.writeObject(pemObject);
        pemWriter.close();
        str.close();
        return str.toString();
    }

    public static String convertPrivateKeyToPEM(PrivateKey key) throws IOException {
        StringWriter keyPEMDataStringWriter = new StringWriter();
        JcaPEMWriter pemWriter = new JcaPEMWriter(keyPEMDataStringWriter);
        pemWriter.writeObject(key);
        pemWriter.close();
        return keyPEMDataStringWriter.toString();
    }

    public static PrivateKey convertPEMToPrivateKey(String pemPrivatekey) throws IOException {
        StringReader reader = new StringReader(pemPrivatekey);
        PEMParser pemParser = new PEMParser(reader);
        Object o = pemParser.readObject();
        KeyPair kp = new JcaPEMKeyConverter().setProvider(CryptoConstants.PROVIDER_NAME).getKeyPair((PEMKeyPair) o);
        return kp.getPrivate();
    }
}
