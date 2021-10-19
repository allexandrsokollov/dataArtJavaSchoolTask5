package ru.dataart.academy.java;

public class ReverseInteger {
    char[] INT_MAX_VALUE_IN_CHAR = ("" + Integer.MAX_VALUE).toCharArray();

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
        int toReturn ;

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





        if ((number.length < 10) || (number.length == 10 && number[0] == '-')) {
            return Integer.parseInt(new String(number));
        } else if (number.length > 10 && number[0] != '-') {
            try {
                throw new ValueOutOfIntegerException("value is more than Integer max value");
            } catch (ValueOutOfIntegerException e) {
                System.out.println(e.getMessage());
            }
        } else {
            for (int i = 0, j = 0; i < number.length; i++) {
                if (number[i] == '-') {
                    continue;
                }

                if (number[i] > INT_MAX_VALUE_IN_CHAR[j]) {
                    try {
                        throw new ValueOutOfIntegerException("value is more than Integer max value");
                    } catch (ValueOutOfIntegerException e) {
                        System.out.println(e.getMessage());
                    }
                }
                j++;
            }

        }
        return Integer.parseInt(new String(number));
    }


}
