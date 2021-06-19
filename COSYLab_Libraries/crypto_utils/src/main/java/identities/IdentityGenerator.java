package identities;

import utils.CryptoConstants;
import utils.CryptoUtilFunctions;

public class IdentityGenerator {

    public static String generateCloudServiceIdentifier(CloudServiceType ccService) {
        return CryptoConstants.IDENTITY_ROOT_PART + CryptoConstants.IDENTITY_SEPARATOR + EntityType.CC_SERVICE.getCertName()
                + CryptoConstants.IDENTITY_SEPARATOR + ccService + CryptoConstants.IDENTITY_SEPARATOR + CryptoUtilFunctions.generateUUID();
    }

    public static String generateFogServiceIdentifier(String ftaIdentifier, FogServiceType fcService) {
        return CryptoConstants.IDENTITY_ROOT_PART + CryptoConstants.IDENTITY_SEPARATOR + EntityType.FC_SERVICE.getCertName()
                + CryptoConstants.IDENTITY_SEPARATOR + fcService + CryptoConstants.IDENTITY_SEPARATOR + ftaIdentifier +
                CryptoConstants.IDENTITY_SEPARATOR + CryptoUtilFunctions.generateUUID();
    }

    public static String getFTAIdFromFogServiceIdentifier(String identity) {
        String[] parts = identity.split("\\" + CryptoConstants.IDENTITY_SEPARATOR);
        return parts[3];
    }

    public static String getFCComponentIdFromFogServiceIdentifier(String identity) {
        String[] parts = identity.split("\\" + CryptoConstants.IDENTITY_SEPARATOR);
        return parts[4];
    }

    public static String generateUserIdentifier(String ftaIdentifier) {
        return CryptoConstants.IDENTITY_ROOT_PART + CryptoConstants.IDENTITY_SEPARATOR + EntityType.USER.getCertName()
                + CryptoConstants.IDENTITY_SEPARATOR + ftaIdentifier + CryptoConstants.IDENTITY_SEPARATOR + CryptoUtilFunctions.generateUUID();
    }

    public static String generateThingIdentifier(String thingDeviceType, String ftaIdentifier, String ftpIdentifier) {
        return CryptoConstants.IDENTITY_ROOT_PART + CryptoConstants.IDENTITY_SEPARATOR + EntityType.THING.getCertName()
                + CryptoConstants.IDENTITY_SEPARATOR + thingDeviceType + CryptoConstants.IDENTITY_SEPARATOR
                + ftaIdentifier + CryptoConstants.IDENTITY_SEPARATOR + ftpIdentifier
                + CryptoConstants.IDENTITY_SEPARATOR + CryptoUtilFunctions.generateUUID();
    }

    public static String getEntityTypeFromIdentifier(String identifier) {
        String[] parts = identifier.split("\\" + CryptoConstants.IDENTITY_SEPARATOR);
        return parts[2];
    }

}
