package ru.dataart.academy.java;

public class ReverseInteger {
    /**
     * @param inputNumber - any integer value
     * @return - inputNumber in reversed order
     * Example: 1234 -> 4321
     * -23 -> -32
     * 120 -> 21
     * -2,147,483,648 -> exception and error message
     * If result (number in reversed order) is out of int range [-2,147,483,648,  2,147,483,647] throw custom
     * unchecked exception. In main method (Main class) if exception happened output message with problem to user.
     */
    public int reverse(int inputNumber)  {
        char[] number = ("" + inputNumber).toCharArray();
        int toReturn = 0;

        if(number.length <= 1) {
            toReturn = Integer.parseInt(new String(number));
            return toReturn;
        }

        for (int i = 0, j = number.length - 1; i < number.length / 2; i++, j--) {

            if(number[i] == '-') {
                i++;
            }

            char tmp = number[i];
            number[i] = number[j];
            number[j] = tmp;
        }


        toReturn = charArrayToInt(number);



        return toReturn;
    }

    private static int charArrayToInt(char[] chars) throws ValueOutOfIntegerException {
        char[] INT_MAX_VALUE_IN_CHAR = ("" + Integer.MAX_VALUE).toCharArray();

        if ((chars.length < 10) || (chars.length == 10 && chars[0] == '-')) {
            return Integer.parseInt(new String(chars));
        } else if (chars.length > 10 && chars[0] != '-') {
            throw new ValueOutOfIntegerException("value is more than Integer max value");
        } else {
            for (int i = 0, j = 0; i < chars.length; i++) {
                if (chars[i] == '-') {
                    continue;
                }

                if (chars[i] > INT_MAX_VALUE_IN_CHAR[j]) {
                    throw new ValueOutOfIntegerException("value is more than Integer max value");
                }
                j++;
            }
            return Integer.parseInt(new String(chars));

        }


    }
}
