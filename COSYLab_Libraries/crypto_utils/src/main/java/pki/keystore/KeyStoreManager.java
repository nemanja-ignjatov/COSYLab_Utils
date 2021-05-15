package pki.keystore;


import lombok.extern.slf4j.Slf4j;
import pki.certificate.CertificateKeyConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

@Slf4j
public class KeyStoreManager {

    private final String KEYSTORE_TYPE = "PKCS12";
    private final String KEYSTORE_PROVIDER = "BC";

    private String keyStoreFileName;
    private String keyStorePassword;
    private KeyStore keystore;

    public KeyStoreManager(String keyStoreFileName, String keyStorePassword) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException, KeyStoreException, IOException {
        this.keyStoreFileName = keyStoreFileName;
        this.keyStorePassword = keyStorePassword;
        this.initKeyStore();

    }

    public X509Certificate getCertificate(String certificateAlias) throws KeyStoreException, CertificateException {
        Certificate cert = this.keystore.getCertificate(certificateAlias);
        return cert != null ? CertificateKeyConverter.convertCertToX509(cert) : null;

    }

    public PrivateKey getPrivateKey(String keyAlias) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {

        return (PrivateKey) this.keystore.getKey(keyAlias, this.keyStorePassword.toCharArray());


    }

    synchronized public void storeCertificate(String certificateAlias, X509Certificate certificate) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {

        FileOutputStream fOut = new FileOutputStream(this.keyStoreFileName);

        keystore.setCertificateEntry(certificateAlias, certificate);
        keystore.store(fOut, this.keyStorePassword.toCharArray());

        fOut.close();


    }

    synchronized public void storePrivateKey(String keyAlias, PrivateKey privateKey, Certificate[] trustChain) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {

        FileOutputStream fOut = new FileOutputStream(this.keyStoreFileName);

        keystore.setKeyEntry(keyAlias, privateKey, null, trustChain);
        keystore.store(fOut, this.keyStorePassword.toCharArray());

        fOut.close();

    }

    private void initKeyStore() throws NoSuchProviderException, KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        this.keystore = KeyStore.getInstance(KEYSTORE_TYPE, KEYSTORE_PROVIDER);

        File keystoreFile = new File(this.keyStoreFileName);
        if (!keystoreFile.exists()) {
            keystoreFile.createNewFile();
            this.keystore.load(null, this.keyStorePassword.toCharArray());
        } else {
            this.keystore.load(new FileInputStream(keystoreFile), this.keyStorePassword.toCharArray());
        }
    }
}
