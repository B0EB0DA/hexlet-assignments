package exercise;

import java.util.Arrays;
import java.util.Optional;

class SafetyList {
    // BEGIN
    final int START_SIZE = 16;
    int[] array = new int[START_SIZE];
    Optional<Integer> pointer = Optional.empty();             // Index of last item

    public int getSize() {
        return pointer.orElse(-1) + 1;
    }

    public int get() {
        if (pointer.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int index = pointer.get();
            if (index == 0) {
                pointer = Optional.empty();
            } else {
                pointer = Optional.of(index - 1);
            }
            return array[index];
        }
    }

    public void add(int i) {
        synchronized (this) {
            checkArray();
            int newIndex = pointer.orElse(-1) + 1;
            array[newIndex] = i;
            pointer = Optional.of(newIndex);
        }
    }

    private void checkArray() {             // Checks if pointer is at last element, doubles size of array if true
        if (pointer.isPresent()) {
            int length = array.length;
            if (pointer.get() == length - 1) {
                int[] newArray = new int[length * 2];
                System.arraycopy(array, 0, newArray, 0, length);
                array = newArray;
            }
        }
    }

    @Override
    public String toString() {
        return "SafetyList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    // END
}
