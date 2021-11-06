package fog.faca.enums;

import fog.faca.access_rules.AccessRuleType;

public enum ATTRIBUTE {

    ROLE("Subject.Identity.Role", AccessRuleType.STRING),
    USERNAME("Subject.Identity.Username", AccessRuleType.STRING),
    AGE("Subject.Person.Age", AccessRuleType.NUMERIC),
    ORGANIZATION("Subject.Work.Organization", AccessRuleType.STRING),
    POSITION("Subject.Work.Profession", AccessRuleType.STRING),
    HANDICAP("Subject.Person.Handicap", AccessRuleType.STRING);

    private final String attributeName;
    private final AccessRuleType arType;

    ATTRIBUTE(final String attributeName, final AccessRuleType arType) {
        this.attributeName = attributeName;
        this.arType = arType;
    }

    public AccessRuleType getArType() {
        return arType;
    }

    @Override
    public String toString() {
        return attributeName;
    }
}
