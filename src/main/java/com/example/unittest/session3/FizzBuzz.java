package com.example.unittest.session3;

public class FizzBuzz {

    //start 3
    public String compute1(int i) {
        int divisible3 = i % 3;
        int divisible5 = i % 5;
        if (divisible3 == 0 && divisible5 == 0) {
            return "FizzBuzz";
        } else if (divisible3 == 0) {
            return "Fizz";
        } else if (divisible5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(i);
        }
    }

    public static String compute(int i) {
        StringBuilder builder = new StringBuilder(10);
        int divisible3 = i % 3;
        int divisible5 = i % 5;
        if (divisible3 == 0) {
            builder.append("Fizz");
        }
        if (divisible5 == 0) {
            builder.append("Buzz");
        }
        if (builder.isEmpty()) {
            builder.append(i);
        }
        return builder.toString();
    }

    public String fizzBuzz() {
        StringBuilder builder = new StringBuilder(250);
        for (int i = 1; i <= 100; i++) {
            int divisible3 = i % 3;
            int divisible5 = i % 5;
            if (divisible3 == 0 && divisible5 == 0) {
                builder.append("FizzBuzz\n");
            } else if (divisible3 == 0) {
                builder.append("Fizz\n");
            } else if (divisible5 == 0) {
                builder.append("Buzz\n");
            } else {
                builder.append(i).append("\n");
            }
        }
        System.out.println(builder);
        return "";
    }

    public String fizzBuzz2() {
        for (int i = 1; i < 100; i++,
                System.out.println(
                        i % 3 == 0 || i % 5 == 0
                                ?
                                ((i % 3) == 0 ? "fizz" : "") + ((i % 5) == 0 ? "buzz" : "")
                                :
                                i))
            ;

        return "";
    }
    //end 3
}