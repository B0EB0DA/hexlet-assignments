package exercise;

import java.util.stream.IntStream;

// BEGIN
class ReversedSequence implements CharSequence {
    private String str;
    public ReversedSequence(String str) {
        this.str = str;
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        return str.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

}
// END
