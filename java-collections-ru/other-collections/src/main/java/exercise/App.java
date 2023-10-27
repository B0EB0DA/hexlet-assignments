package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {
    static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {

        Map<String, String> ret = new LinkedHashMap<>();

        for(String k : data1.keySet()) {
            ret.put(k, "deleted");
        }

        for(Map.Entry e : data2.entrySet()) {
            ret.merge((String) e.getKey(), "added", (oldValue, newValue) ->
                    e.getValue().equals(data1.get(e.getKey())) ? "unchanged" : "changed"
            );
        }
        return ret;
    }
}


//END
