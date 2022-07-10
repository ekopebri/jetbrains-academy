package numbers;

public class NumberUtils {
    public static boolean isPalindromNumber(long number) {
        if (number < 10) {
            return true;
        }

        StringBuilder sb = new StringBuilder(Long.toString(number));
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isEvenNumber(long number) {
        return number % 2 == 0;
    }

    public static boolean isSpyNumber(long number) {
        long product = 1;
        long sum = 0;
        String numberString = Long.toString(number);
        for (int i = 0; i < numberString.length(); i++) {
            long value = Long.parseLong(String.valueOf(numberString.charAt(i)));
            product *= value;
            sum += value;
        }

        return product == sum;
    }

    public static boolean isGapfulNumber(long number) {
        String numberString = Long.toString(number);
        if (numberString.length() < 3) {
            return false;
        }

        long firstDigit = Long.parseLong(String.valueOf(numberString.charAt(0)));
        long lastDigit = Long.parseLong(String.valueOf(numberString.charAt(numberString.length() - 1)));

        return number % (firstDigit * 10 + lastDigit) == 0;
    }

    public static boolean isBuzzNumber(long number) {
        String numberString = Long.toString(number);
        return number % 7 == 0 || numberString.charAt(numberString.length() - 1) == '7';
    }

    public static boolean isDuckNumber(long number) {
        String numberString = Long.toString(number);
        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) == '0') {
                return true;
            }
        }

        return false;
    }

    public static boolean isSunnyNumber(long number) {
        if (isSquareNumber(number + 1)) {
            return true;
        }
        return false;
    }

    public static boolean isSquareNumber(long number) {
        double square_root = Math.sqrt(number);
        return (square_root - Math.floor(square_root)) == 0;
    }

    public static boolean isJumping(long number) {
        long n = number;
        while (n != 0) {
            long digit1 = n % 10;
            n = n / 10;
            if (n != 0) {
                long digit2 = n % 10;
                if (Math.abs(digit1 - digit2) != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isHappyNumber(long number) {
        long value = number;
        while (value != 1 && value != 4) {
            long rem = 0;
            long sum = 0;
            long n = value;

            while (n > 0) {
                rem = n % 10;
                sum += (rem * rem);
                n = n / 10;
            }

            value = sum;
        }

        return value == 1;
    }
}
