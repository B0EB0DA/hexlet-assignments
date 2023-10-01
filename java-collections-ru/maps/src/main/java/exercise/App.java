package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    static Map<String, Integer> getWordCount(String sentence) {

        Map<String, Integer> ret = new HashMap<>();
        String[] splittedSentence = sentence.split(" ");
        for (String st : splittedSentence) {
            if (!st.isEmpty()) {
                if (ret.containsKey(st)) {
                    ret.put(st, ret.get(st) + 1);
                } else {
                    ret.put(st, 1);
                }
            }
        }
        return ret;
    }
    static String toString(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<String, Integer> s : map.entrySet()) {
            sb.append("\n");
            sb.append("  ").append(s.getKey()).append(": ").append(s.getValue());
        }
        if (!map.isEmpty()) {
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
//END
