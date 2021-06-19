package jws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class JWSTokenHandler {

    private static final Logger logger = LoggerFactory.getLogger(JWSTokenHandler.class);
    private static final String ATTRIBUTES_CLAIM_NAME = "meta_info";

    private PublicKey publicKey;
    private PrivateKey privateKey;
    private String subjectId;
    private String issuerId;
    private ObjectMapper objectMapper;

    public JWSTokenHandler(PublicKey publicKey, PrivateKey privateKey, String issuerId) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.subjectId = issuerId;
        this.issuerId = issuerId;
        this.objectMapper = new ObjectMapper();
    }

    public JWSTokenHandler(PublicKey publicKey, PrivateKey privateKey, String issuerId, String subjectId) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.subjectId = subjectId;
        this.issuerId = issuerId;
        this.objectMapper = new ObjectMapper();
    }

    public String generateJWSToken(Serializable attributes) throws JsonProcessingException {
        Map<String, String> claims = Map.of(ATTRIBUTES_CLAIM_NAME, this.objectMapper.writeValueAsString(attributes));
        String jws = Jwts.builder()
                .setClaims(claims)
                .setIssuer(this.issuerId)
                .setExpiration(new Date(System.currentTimeMillis()+2*3600000))
                .setNotBefore(new Date())
                .setIssuedAt(new Date())
                .setId(UUID.randomUUID().toString())
                .setSubject(this.subjectId)
                .signWith(privateKey).compact();
        return jws;
    }

    public String generateJWSTokenForSubject(Serializable attributes, String subjectId) throws JsonProcessingException {
        Map<String, String> claims = Map.of(ATTRIBUTES_CLAIM_NAME, this.objectMapper.writeValueAsString(attributes));
        String jws = Jwts.builder()
                .setClaims(claims)
                .setIssuer(this.issuerId)
                .setExpiration(new Date(System.currentTimeMillis()+2*3600000))
                .setNotBefore(new Date())
                .setIssuedAt(new Date())
                .setId(UUID.randomUUID().toString())
                .setSubject(subjectId)
                .signWith(privateKey).compact();
        return jws;
    }

    public String generateJWSToken(Map<String, String> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer(this.issuerId)
                .setExpiration(new Date(System.currentTimeMillis()+2*3600000))
                .setNotBefore(new Date())
                .setIssuedAt(new Date())
                .setId(UUID.randomUUID().toString())
                .setSubject(this.subjectId)
                .signWith(privateKey).compact();
    }

    public String generateJWSTokenForSubject(Map<String, String> claims, String subjectId) {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer(this.issuerId)
                .setExpiration(new Date(System.currentTimeMillis()+2*3600000))
                .setNotBefore(new Date())
                .setIssuedAt(new Date())
                .setId(UUID.randomUUID().toString())
                .setSubject(subjectId)
                .signWith(privateKey).compact();
    }

    public Map<String, Object> getClaimsFromJWS(String jws) {
        return Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(jws).getBody();
    }

    public String getClaimFromJWS(String jws, String claimKey) {
        Claims claims = Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(jws).getBody();
        return (String)claims.get(claimKey);
    }
}
