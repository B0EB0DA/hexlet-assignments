package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
class Tag {
    protected String tagName;
    protected Map <String, String> tagAttributes;
    public String toString() {
        return tagAttributes
                .entrySet()
                .stream()
                .map(e -> " " + e.getKey() + "=\"" + e.getValue() + "\"")
                .collect(Collectors.joining());
    }
    public Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }
}
// END
