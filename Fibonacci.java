//Timothy Girvin
//CMSI 186
//Fibonacci.java 


public class Fibonacci {
    public static void main(String[] args) {
        if (args.length != 1) {
            printUsage();
            return;
        }
        BigInteger numberInSequence = null;
        try {
            numberInSequence = new BigInteger(args[0]);
            if (numberInSequence.isLessThan(new BigInteger("1"))) {
                System.out.println("Sorry, but this program only accepts natural numbers.");
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException iaexc) {
            printUsage();
            return;
        }
        System.out.println("The " + numberInSequence.toString() + " number in the Fibonacci Sequence is " + fibonacci(numberInSequence).toString() + ".");
    }

    private static BigInteger fibonacci(BigInteger numberInSequence) {
        BigInteger result = new BigInteger();
        result.number = new int[numberInSequence];
        BigInteger currentNumber = new BigInteger("2");
        int i = 2;
        result.number[0] = 0;
        result.number[1] = 1;
        while (currentNumber.isLessThan(numberInSequence)) {
            result.number[i] = result.number[i - 1] + result.number[i - 2];
            currentNumber = currentNumber.addition(new BigInteger("1"));
            i += 1;
        }
        return result;
    }

    private static void printUsage() {
        System.out.println("Usage: java Fibonacci <number>, where <number> is a natural number");
    }
}