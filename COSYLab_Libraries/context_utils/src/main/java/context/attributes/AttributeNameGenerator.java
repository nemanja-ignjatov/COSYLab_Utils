package context.attributes;

public class AttributeNameGenerator {

    public static final String CONTEXT_ATTR_PREFIX = "Context";
    public static final String STATIC_ATTTRIBUTE_NAME_PART_DELIMITER = "?";

    public static final String generateContextAttributeName(ContextType contextType, String contextRelevantName) {
        return CONTEXT_ATTR_PREFIX + "." + contextType.getRepresentationName() + "." + contextRelevantName;
    }

    public static final String getStaticContextAttributeNamePart(String attributeName) {
        return attributeName.split("\\"+STATIC_ATTTRIBUTE_NAME_PART_DELIMITER)[0];
    }

    public static final String getDynamicContextAttributeNamePart(String attributeName) {
        String[] parts = attributeName.split("\\"+STATIC_ATTTRIBUTE_NAME_PART_DELIMITER);
        if(parts.length > 1) {
            return parts[1];
        }
        return null;
    }
}
