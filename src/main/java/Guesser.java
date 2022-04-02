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
        while (condition) {
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
        BigInteger difference = upperBound.subtract(lowerBound).divide(BigInteger.valueOf(2));
        String test = "";
        while (!test.equalsIgnoreCase("correct")) {
            lowerBound = upperBound.subtract(difference);
            test = c.guess(lowerBound);
            if (test.equalsIgnoreCase("higher")) {
                upperBound = difference.subtract(BigInteger.valueOf(1));
            } else if (test.equalsIgnoreCase("lower")) {
                lowerBound = difference.add(BigInteger.valueOf(1));
            }
        }
        return lowerBound;
    }
}