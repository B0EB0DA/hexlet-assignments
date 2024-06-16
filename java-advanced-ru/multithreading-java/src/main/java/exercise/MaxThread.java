package exercise;

import java.util.Arrays;

import static java.util.Arrays.stream;

// BEGIN
class MaxThread extends Thread {
    int[] numbers;
    int maxValue;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public void run() {
        maxValue = stream(numbers).max().getAsInt();
    }
}
// END
