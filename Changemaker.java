//Timothy Girvin
//CMSI 186
//Changemaker.java

public class Changemaker {

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length]; //giving new integer array calling denominations string.length

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }



            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }

    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {

        Tuple[ ][ ] table = new Tuple[denominations.length][amount + 1];

        for (int i = 0; i < denominations.length; i += 1) {
            table[i][0] = new Tuple(denominations.length);
        }

        for (int row = 0; row < denominations.length; row += 1) {
            for (int collumn = 1; collumn < amount + 1; collumn += 1) {
                if (collumn < denominations[row]) {
                    table[row][collumn] = Tuple.IMPOSSIBLE;
                } else {
                    table[row][collumn] = new Tuple(denominations.length);
                    table[row][collumn].setElement(row, 1);

                    if (table[row][collumn - denominations[row]].isImpossible()) {
                        table[row][collumn] = Tuple.IMPOSSIBLE;
                    } else {
                        table[row][collumn] = table[row][collumn].add(table[row][collumn - denominations[row]]);
                    }
                }
                if (row > 0 && (table[row][collumn].isImpossible() || (!(table[row - 1][collumn].isImpossible()) 
                        && table[row][collumn].total() > table[row - 1][collumn].total()))) {
                    table[row][collumn] = table[row - 1][collumn];
                }
            }
        }
        return table[denominations.length - 1][amount];
    }


    private static void printUsage() {
        System.out.println("Usage: java Changemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}