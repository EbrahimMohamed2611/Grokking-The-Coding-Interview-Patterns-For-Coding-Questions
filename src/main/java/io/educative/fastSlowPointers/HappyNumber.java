package io.educative.fastSlowPointers;

public class HappyNumber {
    public static boolean isHappy(int n) {
        int slowPointer = n, fastPointer = n;
        do{
            slowPointer = sum(slowPointer);
            fastPointer = sum(sum(fastPointer));
        }while(slowPointer != fastPointer);

        return slowPointer == 1;
    }


    private static int sum(int number){
        int sum = 0;
        while(number != 0){
            int firstDigit = number % 10;
            sum+= firstDigit * firstDigit;
            number = (number/10);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
