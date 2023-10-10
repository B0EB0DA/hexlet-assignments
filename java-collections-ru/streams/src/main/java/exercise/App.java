package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {

    /*
    String[] emails = {
            "info@gmail.com",
            "info@yandex.ru",
            "mk@host.com",
            "support@hexlet.io",
            "info@hotmail.com",
            "support.yandex.ru@host.com"
    };
    List<String> emailsList = Arrays.asList(emails);
     */

    private static List<String> freeDomains = Arrays.asList("gmail.com", "yandex.ru", "hotmail.com");
    private static boolean checkFreeDomain(String email) {
        String[] splitEmail = email.split("@");
        if (splitEmail.length == 2) {
            if (freeDomains.contains(splitEmail[1])) {
                return true;
            }
        }
        return false;
    }
    static long getCountOfFreeEmails(List<String> emailsList) {
        return emailsList.stream()
                .filter(email -> checkFreeDomain(email))
                .count();
    }
}
// END
