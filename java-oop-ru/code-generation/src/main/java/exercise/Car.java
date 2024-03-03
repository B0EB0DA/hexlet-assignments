package exercise;

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
    public String serialize() throws Exception{
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
    public static Car unserialize(String carJSONString) throws Exception{
        return new ObjectMapper().readValue(carJSONString, Car.class);
    }
    // END
}
