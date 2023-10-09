package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

class AppTest {

    List<Integer> forTests;

    @BeforeAll
    static void prepareTests() {
        System.out.println("Here comes...");
    }

    @BeforeEach void initList() {
        this.forTests = new ArrayList<Integer>();
        this.forTests.add(1);
        this.forTests.add(2);
        this.forTests.add(3);
        this.forTests.add(4);
        this.forTests.add(5);
    }

    @Test
    void testTake() {
        // BEGIN
        List<Integer> testMe = App.take(forTests, 3);
        Assertions.assertEquals(testMe.size(), 3);
        Assertions.assertEquals(testMe.get(1), 2);
        Assertions.assertTrue(!forTests.isEmpty());
        // END
    }
}
