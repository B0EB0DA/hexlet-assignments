package exercise;

import static java.util.Arrays.stream;

// BEGIN
class MinThread extends Thread{
    int[] numbers;
    int minValue;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMinValue() {
        return minValue;
    }

    @Override
    public void run() {
        minValue = stream(numbers).min().getAsInt();
    }

}
// END
