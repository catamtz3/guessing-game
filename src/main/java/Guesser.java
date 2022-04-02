import java.math.BigInteger;

public class Guesser {
    /**
     * This method must return the number Chooser c has chosen. c can guess() any
     * number and tell you whether the number is "correct", "higher", or "lower".
     *
     * @param c The "chooser" that has chosen a number you must guess.
     * @return The number that the "chooser" has chosen
     */
    public static BigInteger findNumber(Chooser c) {
        BigInteger upperBound = new BigInteger("2");
        BigInteger lowerBound = new BigInteger("1");
        boolean condition = true;
        while (condition == true) {
            String high = c.guess(upperBound);
            if (high.equalsIgnoreCase("correct")) {
                return upperBound;
            }
            String low = c.guess(lowerBound);
            if (low.equalsIgnoreCase("correct")) {
            return lowerBound;
            }
            if (high.equalsIgnoreCase("higher")) {
                lowerBound = upperBound;
                upperBound = upperBound.multiply(BigInteger.valueOf(2));
            } else if (high.equalsIgnoreCase("lower")) {
                condition = false;
            }
        }
        while (lowerBound.compareTo(upperBound) < 0) {
            upperBound = lowerBound;
            BigInteger difference = upperBound.subtract(lowerBound).divide(BigInteger.valueOf(2));
            lowerBound = upperBound.subtract(difference);
            String test = c.guess(difference);
            if (test.equalsIgnoreCase("correct")) {
                return difference;
            } if (test.equalsIgnoreCase("higher")) {
                upperBound = difference.subtract(BigInteger.valueOf(1));
            } if (test.equalsIgnoreCase("lower")) {
                lowerBound = difference.add(BigInteger.valueOf(1));
            }
        }
        return upperBound;
    }
}