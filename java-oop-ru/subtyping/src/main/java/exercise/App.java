package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void  swapKeyValue(KeyValueStorage map) {
        Map <String, String> dummy = new HashMap<>(map.toMap());
        for ( Map.Entry <String, String> e : dummy.entrySet()) {
            map.unset(e.getKey());
            map.set(e.getValue(), e.getKey());
        }
    }
}
// END
