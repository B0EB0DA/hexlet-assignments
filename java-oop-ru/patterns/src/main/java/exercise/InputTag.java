package exercise;

// BEGIN
class InputTag implements TagInterface {
    String type;
    String value;
    @Override
    public String render() {
        return "<input type=\"" + type + "\" value=\"" + value + "\">";
        //<input type="submit" value="Save">
    }
    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }
}
// END
