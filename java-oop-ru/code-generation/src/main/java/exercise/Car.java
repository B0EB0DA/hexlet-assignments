package exercise;

import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    @SneakyThrows
    public String serialize() {
        return new ObjectMapper().writeValueAsString(this);
        //final ObjectMapper mapper = new ObjectMapper();
//        try {
//            return new ObjectMapper().writeValueAsString(this);
//        } catch (Exception e) {
//            return "";
//        }
    }
    @SneakyThrows
    public static Car unserialize(String carJSONString) {
        return new ObjectMapper().readValue(carJSONString, Car.class);
    }
    // END
}
