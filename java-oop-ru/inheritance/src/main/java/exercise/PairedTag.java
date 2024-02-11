package exercise;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> tagChildren;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String tagBody, List<Tag> tagChildren) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.tagChildren = tagChildren;
    }

    @Override
    public String toString() {
        String childrenString = tagChildren
                .stream()
                .map(c -> c.toString())
                .collect(Collectors.joining());
        return "<" + tagName + super.toString() + ">" + tagBody + childrenString + "</" + tagName + ">";

    }
}
// END

class main {
    public static void main(String[] args) {


        Tag p = new PairedTag(
                "p",
                Map.of("id", "abc"),
                "Text paragraph",
                new ArrayList<Tag>()
        );

        System.out.println(p.toString()); // <p id="abc">Text paragraph</p>

        Tag div = new PairedTag(
                "div",
                Map.of("class", "y-5"),
                "",
                List.of(
                        new SingleTag("br", Map.of("id", "s")),
                        new SingleTag("hr", Map.of("class", "a-5"))
                )
        );

        System.out.println(div.toString()); // <div class="y-5"><br id="s"><hr class="a-5"></div>

    }
}
