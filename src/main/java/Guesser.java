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
//            String low = c.guess(lowerBound);
//            if (low.equalsIgnoreCase("correct")) {
//            return lowerBound;
//            }
            String high = c.guess(upperBound);
            if (high.equalsIgnoreCase("correct")) {
                return upperBound;
            }
            if (high.equalsIgnoreCase("higher")) {
                lowerBound = upperBound;
                upperBound = upperBound.multiply(BigInteger.valueOf(2));
            } else if (high.equalsIgnoreCase("lower")) {
                condition = false;
            }
        }
        String test = "";
        BigInteger average = new BigInteger("1");
        while (!test.equalsIgnoreCase("correct")) {
            average = upperBound.add(lowerBound).divide(BigInteger.valueOf(2));
            test = c.guess(average);
            if (test.equalsIgnoreCase("lower")) {
                upperBound = average.subtract(BigInteger.valueOf(1));
            } else if (test.equalsIgnoreCase("higher")) {
                lowerBound = average.add(BigInteger.valueOf(1));
            }
        }
        return average;
    }
}