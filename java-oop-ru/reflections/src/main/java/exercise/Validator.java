package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class Validator {
    public static List<String> validate(Object obj) {
        List<String> ret = new ArrayList<>();
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.getAnnotation(NotNull.class) != null) {
                    field.setAccessible(true);
                    if (field.get(obj) == null) {
                        ret.add(field.getName());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ret;
    }
}
// END
class main {
    public static void main(String[] args) {
        Address address = new Address(null, "London", "1-st street", "7", "2");
        List<String> notValidFields = Validator.validate(address);
        System.out.println(notValidFields); // => [country]

        Address address2 = new Address("England", null, null, "7", "2");
        List<String> notValidFields2 = Validator.validate(address2);
        System.out.println(notValidFields2); // => [city, street]
    }
}
