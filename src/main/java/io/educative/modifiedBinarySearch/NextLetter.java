package io.educative.modifiedBinarySearch;

public class NextLetter {

    public static char findNextLetter(char[] letters, char key) {
        if (key < letters[0] || key > letters[letters.length - 1])
            return letters[0];

        int start = 0;
        int end = letters.length - 1;
        int mid;
        while (end >= start) {
            mid = start + (end - start) / 2;
            if (key == letters[mid]) {
                start = mid + 1;
            } else if (key > letters[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return letters[start % letters.length];
    }

    public static void main(String[] args) {
        System.out.println(findNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'f')); // h
        System.out.println(findNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'b')); // c
        System.out.println(findNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'm')); // a
        System.out.println(findNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'h')); // a
    }
}
