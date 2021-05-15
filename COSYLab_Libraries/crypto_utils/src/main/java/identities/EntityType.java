package identities;

public enum EntityType {
    FC_SERVICE("FCService"), CC_SERVICE("CCService"), USER("User"), THING("Thing");

    private final String certName;

    EntityType(final String certName) {
        this.certName = certName;
    }

    public String getCertName() {
        return certName;
    }

    @Override
    public String toString() {
        return certName;
    }
}
