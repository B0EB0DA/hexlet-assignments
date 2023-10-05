package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {

    static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {

        List<Map<String, String>> ret = new ArrayList<>();
        for (Map<String, String> book : books) {
            boolean isGood = true;
            for (Map.Entry<String, String> rule : where.entrySet()) {
                var ruleKey = rule.getKey();
                if (book.containsKey(ruleKey)) {
                    if(book.get(ruleKey) != rule.getValue()) {
                        isGood = false;
                        break;
                    }
                } else {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                ret.add(book);
            }
        }
        return ret;
    }
    
}

//END
