//Timothy Girvin
//CMSI 186
//ChangemakerTestHarness.java





public class ChangemakerTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_USA();
        // Add more!
        // A few examples:
        test_Canada(); // 1,2,5,10,20,50
        test_randomTesting();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_USA() {
        int[] usaDenominations = new int[] { 25, 10, 5, 1 };

        Tuple result = Changemaker.makeChangeWithDynamicProgramming(usaDenominations, 99);
        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }
    public static void test_Canada() {
        int[] canadaDenominations = new int[] { 5, 100, 20, 50, 10 };

        Tuple result = Changemaker.makeChangeWithDynamicProgramming(canadaDenominations, 320);
        try {
            displaySuccessIfTrue(Changemaker.makeChangeWithDynamicProgramming(canadaDenominations, 49).isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(3 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void test_randomTesting() {
        int[] randomTestingDenominations = new int[] { 2, 6, 10, 22 };

        Tuple result = Changemaker.makeChangeWithDynamicProgramming(randomTestingDenominations, 984);
        try {
            displaySuccessIfTrue(Changemaker.makeChangeWithDynamicProgramming(randomTestingDenominations, 23).isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        try {
            displaySuccessIfTrue(Changemaker.makeChangeWithDynamicProgramming(randomTestingDenominations, 1).isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        try {
            displaySuccessIfTrue(!(Changemaker.makeChangeWithDynamicProgramming(randomTestingDenominations, 4).isImpossible()));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(44 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

}