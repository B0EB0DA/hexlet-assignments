package exercise;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    static boolean scrabble (String letters, String word) {

        int wordLen = word.length();
        if (wordLen > letters.length()) {
            return false;
        }
        letters = letters.toLowerCase();
        word = word.toLowerCase();

        for (int i = 0; i < wordLen; i++) {
            String ch = word.substring(i, i + 1);
            if (letters.contains(ch)) {
                letters = letters.replaceFirst(ch, "*");
            } else {
                return false;
            }
        }
        return true;
    }

}
//END
