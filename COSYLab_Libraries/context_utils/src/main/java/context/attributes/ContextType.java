package context.attributes;

public enum ContextType {
    CONNECTIVITY("Connectivity"), BEHAVIOUR("Behaviour"), LOCATION("Location");

    private String representationName;

    ContextType(String representationName) {
        this.representationName = representationName;
    }

    public String getRepresentationName() {
        return representationName;
    }
}
