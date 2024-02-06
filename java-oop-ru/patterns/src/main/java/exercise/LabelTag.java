package exercise;

// BEGIN
class LabelTag implements TagInterface {
    String text;
    TagInterface childTag;
    @Override
    public String render() {
        return "<label>" + text + childTag.render() + "</label>";
        // <label>Press Submit<input type="submit" value="Save"></label>
    }
    public LabelTag(String text, TagInterface childTag) {
        this.text = text;
        this.childTag = childTag;
    }
}
// END
