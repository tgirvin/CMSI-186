//Timothy Girvin
//CMSI 186
//BigInteger.java 




import java.util.Arrays;

public class BigInteger {

    private int[] number;
    private boolean negative = false;



    public BigInteger() {
        this("0");
    }

    public BigInteger(java.lang.String input) {
        boolean hitFirstNonZero = false;
        int leadingZeros = 0;
        String inputTrimmed = input.trim();

        // Deals with leading signs
        if (inputTrimmed.charAt(0) == '-'){
            negative = true;
            inputTrimmed = inputTrimmed.substring(1);
        } else if (inputTrimmed.charAt(0) == '+'){
            negative = false;
            inputTrimmed = inputTrimmed.substring(1);
        }

        // Removes leading zeros
        for (int i = 0; i < inputTrimmed.length(); i++) {
            if (Character.getNumericValue(inputTrimmed.charAt(i)) != 0) {
                hitFirstNonZero = true;
                this.number = new int[inputTrimmed.length() - leadingZeros];
            }
            if (!hitFirstNonZero){
                leadingZeros += 1;
            }
        }
        if (!hitFirstNonZero) {
            this.number = new int[1];
            this.number[0] = 0;
        }

        //Converts string to int[]
        for (int i = 0, x = 0; i < inputTrimmed.length() - leadingZeros; i+=1, x+=1) {
            if (Character.getNumericValue(inputTrimmed.charAt(i + leadingZeros)) > 9) {
                throw new IllegalArgumentException();
            }
            this.number[x] = Character.getNumericValue(inputTrimmed.charAt(i + leadingZeros));
        }
    }


    public BigInteger subtraction (BigInteger subtract) {
        //Decides whether to subtract or add
        if (subtract.negative == true) {
            subtract.negative = false;
            return this.addition(subtract);
        } else if (this.negative == true && subtract.negative == false) {
            subtract.negative = true;
            return this.addition(subtract);
        } else {
            BigInteger firstNumber;
            BigInteger secondNumber;
            BigInteger result = new BigInteger();

            //puts absolute value of numbers in order of largest to smallest
            if (absoluteValue(this).isLessThan(absoluteValue(subtract))) {
                firstNumber = absoluteValue(subtract);
                secondNumber = absoluteValue(this);
                result.negative = true;
            } else {
                firstNumber = absoluteValue(this);
                secondNumber = absoluteValue(subtract);
                result.negative = false;
            }

            // pads first number
            int[] paddedFirstNumber = new int[firstNumber.number.length + 1];
            paddedFirstNumber[0] = 0;
            for (int i = 1, x = 0; i < paddedFirstNumber.length; i+=1, x+=1) {
                paddedFirstNumber[i] = firstNumber.number[x];
            }
            firstNumber.number = paddedFirstNumber;

            // pads second number
            int[] paddedSecondNumber = new int[firstNumber.number.length];
            for (int i = 0, x = 0; i < paddedSecondNumber.length; i+=1) {
                if (i < firstNumber.number.length - secondNumber.number.length) {
                    paddedSecondNumber[i] = 0;
                } else {
                    paddedSecondNumber[i] = secondNumber.number[x];
                    x+=1;
                }
            }
            secondNumber.number = paddedSecondNumber;

            //subtracts numbers
            result.number = new int[firstNumber.number.length];
            for (int i = result.number.length - 1; i > 0; i-=1) {
                result.number[i] = result.number[i] + firstNumber.number[i] - secondNumber.number[i];
                if (result.number[i] < 0) {
                    result.number[i] += 10;
                    result.number[i - 1] -= 1;
                }
            }
            return new BigInteger(result.toString());
        }
    }
    public BigInteger addition (BigInteger add) {
        //Decides whether to subtract or add
        if (this.negative == false && add.negative == true) {
            add.negative = false;
            return this.subtraction(add);
        } else if (this.negative == true && add.negative == false) {
            this.negative = false;
            return add.subtraction(this);
        } else {
            BigInteger firstNumber;
            BigInteger secondNumber;
            BigInteger result = new BigInteger();
            result.negative = this.negative;

            //puts absolute value of numbers in order of largest to smallest
            if (absoluteValue(this).isLessThan(absoluteValue(add))) {
                firstNumber = absoluteValue(add);
                secondNumber = absoluteValue(this);
            } else {
                firstNumber = absoluteValue(this);
                secondNumber = absoluteValue(add);
            }

            // pads firstNumber
            int[] paddedFirstNumber = new int[firstNumber.number.length + 1];
            paddedFirstNumber[0] = 0;
            for (int i = 1, x = 0; i < paddedFirstNumber.length; i+=1, x+=1) {
                paddedFirstNumber[i] = firstNumber.number[x];
            }
            firstNumber.number = paddedFirstNumber;

            // pads secondNumber
            int[] paddedSecondNumber = new int[firstNumber.number.length];
            for (int i = 0, x = 0; i < paddedSecondNumber.length; i+=1) {
                if (i < firstNumber.number.length - secondNumber.number.length) {
                    paddedSecondNumber[i] = 0;
                } else {
                    paddedSecondNumber[i] = secondNumber.number[x];
                    x+=1;
                }
            }
            secondNumber.number = paddedSecondNumber;

            //adds numbers
            result.number = new int[firstNumber.number.length];
            for (int i = result.number.length - 1; i > 0; i-=1) {
                result.number[i] = result.number[i] + firstNumber.number[i] + secondNumber.number[i];
                if (result.number[i] > 9) {
                    result.number[i] -= 10;
                    result.number[i - 1] += 1;
                }
            }
            add = new BigInteger(add.toString());
            return new BigInteger(result.toString());
        }
    }

        public BigInteger multiplication (BigInteger multiply) {
        boolean productNegative = false;
        if (this.negative != multiply.negative) {
            productNegative = true;
        }
        BigInteger firstNumber = absoluteValue(this);
        BigInteger secondNumber = absoluteValue(multiply);
        BigInteger result = new BigInteger();
        while (firstNumber.isGreaterThan(new BigInteger("1")) || firstNumber.equals(new BigInteger("1"))) {
            int currentIndex = firstNumber.number[firstNumber.number.length - 1];
            if (currentIndex == 1 || currentIndex == 3 || currentIndex == 5 || currentIndex == 7 || currentIndex == 9) {
                System.out.println("" + firstNumber + ", " + secondNumber);
                result = result.addition(secondNumber);
                System.out.println("" + firstNumber + ", " + secondNumber);
                //firstNumber = new BigInteger(firstNumber.toString());
                //secondNumber = new BigInteger(firstNumber.toString());
            }
            secondNumber = secondNumber.addition(secondNumber);
            firstNumber = firstNumber.divide(new BigInteger("2"));
        }
        result.negative = productNegative;
        return result;
    }
    public BigInteger divide(BigInteger division) {
        BigInteger quotient = new BigInteger();
        boolean quotientNegative = false;

        if (this.negative != division.negative) {
            quotientNegative = true;
        }

        if (new BigInteger("1").equals(absoluteValue(division))) {
            quotient.number = this.number;
            quotient.negative = quotientNegative;
            return quotient;
        } else if (absoluteValue(division).isGreaterThan(absoluteValue(this))) {
            return new BigInteger("0");
        } else if (absoluteValue(this).equals(absoluteValue(division))) {
            return new BigInteger("1");
        } else if (division.number.equals("0") && !(this.number.equals("0"))) {
            throw new ArithmeticException();
        } else {
            BigInteger newdivision = new BigInteger();
            newdivision.number = new int[this.number.length];
            BigInteger numbersToAdd = new BigInteger();
            numbersToAdd.number = new int[this.number.length - division.number.length + 1];
            numbersToAdd.number[0] = 1;
            BigInteger newdividend = absoluteValue(this);

            for (int i = 0; i < division.number.length; i+=1) {
                newdivision.number[i] = division.number[i];
            }

            for (int i = 1; i < numbersToAdd.number.length; i+=1) {
                numbersToAdd.number[i] = 0;
            }

            while (newdividend.isGreaterThan(division) || newdividend.equals(division)) {
                if (newdivision.isGreaterThan(newdividend)) {
                    remainder(newdivision);
                    remainder(numbersToAdd);
                }
                
                newdividend = newdividend.subtraction(newdivision);
                newdivision = new BigInteger(newdivision.toString());
                quotient = quotient.addition(numbersToAdd);
            }
            quotient.negative = quotientNegative;
            return new BigInteger(quotient.toString());
        }
    }
    public BigInteger remainder(BigInteger input) {
        input.number = Arrays.copyOfRange(input.number, 0 , input.number.length - 1);
        return new BigInteger(input.toString());
    }

    public String toString() {
        String string = "";
        if (negative) {
            string += "-";
        } else if (!negative && (this.number[0] != 0)) {
            string += "+";
        }
        for (int i = 0; i < this.number.length; i+=1) {
            string += Integer.toString(this.number[i]);
        }
        return string;
    }
    public boolean equals(java.lang.Object otherNumber) {

        if (this == otherNumber) {
            return true;
        }

        if (otherNumber == null) {
            return false;
        }

        if (getClass() != otherNumber.getClass()) {
            return false;
        }

        BigInteger other = (BigInteger)otherNumber;
        boolean equals = true;
        if (this.number.length != other.number.length || this.negative != other.negative) {
            return false;
        } else {
            for (int i = 0; i < number.length; i+=1){
                if (this.number[i] != other.number[i]) {
                    equals = false;
                }
            }
        }
        return equals;
    }
    public boolean isGreaterThan(BigInteger otherNumber) {
        if (this.negative == false && otherNumber.negative == true) {
            return true;
        } else if (this.negative == true && otherNumber.negative == false) {
            return false;
        } else if (this.negative == false && otherNumber.negative == false && this.number.length > otherNumber.number.length) {
            return true;
        } else if (this.negative == false && otherNumber.negative == false && this.number.length < otherNumber.number.length) {
            return false;
        } else if (this.negative == false && otherNumber.negative == false && this.number.length == otherNumber.number.length) {
            for (int i = 0; i < this.number.length; i+=1) {
                while (this.number[i] != otherNumber.number[i]) {
                    return this.number[i] > otherNumber.number[i];
                }
            }
        } else if (this.negative == true && otherNumber.negative == true && this.number.length > otherNumber.number.length) {
            return false;
        } else if (this.negative == true && otherNumber.negative == true && this.number.length < otherNumber.number.length) {
            return true;
        } else {
            for (int i = 0; i < this.number.length; i++) {
                while (this.number[i] != otherNumber.number[i]) {
                    return this.number[i] < otherNumber.number[i];
                }
            }
        }
        return false;
    }

    public boolean isLessThan(BigInteger otherNumber) {
        return ((!this.isGreaterThan(otherNumber)) && (!this.equals(otherNumber)));
    }

    public BigInteger absoluteValue(BigInteger inputNumber) {
        inputNumber.negative = false;
        return inputNumber;
    }
    public BigInteger mod(BigInteger divisor) { 
        BigInteger result = new BigInteger();

        if (this.negative == false && divisor.negative == false) {
            BigInteger newdividend = absoluteValue(this);
            BigInteger newDivision = absoluteValue(divisor);
            result = newdividend.subtraction((newDivision.multiplication(newdividend.divide(newDivision))));
            result.negative = false;
            return result;
        } else if (this.negative == true && divisor.negative == false) {
            BigInteger newdividend = absoluteValue(this);
            BigInteger newDivision = absoluteValue(divisor);
            result = newDivision.subtraction(newdividend.subtraction((newDivision.multiplication(newdividend.divide(newDivision)))));
            result.negative = false;
            return result;
        } else if (this.negative == false && divisor.negative == true) {
            BigInteger newdividend = absoluteValue(this);
            BigInteger newDivision = absoluteValue(divisor);
            result = newDivision.subtraction(newdividend.subtraction((newDivision.multiplication(newdividend.divide(newDivision)))));
            result.negative = true;
            return result;
        } else {
            BigInteger newdividend = absoluteValue(this);
            BigInteger newDivision = absoluteValue(divisor);
            result = newdividend.subtraction((newDivision.multiplication(newdividend.divide(newDivision))));
            result.negative = true;
            return result;
        }
    }
}
