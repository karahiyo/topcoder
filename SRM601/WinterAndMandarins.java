import java.util.*;

public class WinterAndMandarins {
    public int getNumber(int[] bags, int K) {
        Arrays.sort(bags);
        int min = Integer.MAX_VALUE;
        for (int i=0; i< bags.length - K + 1; i++) {
            int tmp = bags[i+K - 1] - bags[i];
            if (min > tmp) min = tmp;
        }
        return min;

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            WinterAndMandarinsHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                WinterAndMandarinsHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class WinterAndMandarinsHarness {
    public static void run_test(int casenum) {
        if (casenum != -1) {
            if (runTestCase(casenum) == -1)
                System.err.println("Illegal input! Test case " + casenum + " does not exist.");
            return;
        }

        int correct = 0, total = 0;
        for (int i=0;; ++i) {
            int x = runTestCase(i);
            if (x == -1) {
                if (i >= 100) break;
                continue;
            }
            correct += x;
            ++total;
        }

        if (total == 0) {
            System.err.println("No test cases run.");
        } else if (correct < total) {
            System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
        } else {
            System.err.println("All " + total + " tests passed!");
        }
    }

    static boolean compareOutput(int expected, int result) { return expected == result; }
    static String formatResult(int res) {
        return String.format("%d", res);
    }

    static int verifyCase(int casenum, int expected, int received) { 
        System.err.print("Example " + casenum + "... ");
        if (compareOutput(expected, received)) {
            System.err.println("PASSED");
            return 1;
        } else {
            System.err.println("FAILED");
            System.err.println("    Expected: " + formatResult(expected)); 
            System.err.println("    Received: " + formatResult(received)); 
            return 0;
        }
    }

    static int runTestCase(int casenum__) {
        switch(casenum__) {
            case 0: {
                        int[] bags                = {10, 20, 30};
                        int K                     = 2;
                        int expected__            = 10;

                        return verifyCase(casenum__, expected__, new WinterAndMandarins().getNumber(bags, K));
            }
            case 1: {
                        int[] bags                = {4, 7, 4};
                        int K                     = 3;
                        int expected__            = 3;

                        return verifyCase(casenum__, expected__, new WinterAndMandarins().getNumber(bags, K));
            }
            case 2: {
                        int[] bags                = {4, 1, 2, 3};
                        int K                     = 3;
                        int expected__            = 2;

                        return verifyCase(casenum__, expected__, new WinterAndMandarins().getNumber(bags, K));
            }
            case 3: {
                        int[] bags                = {5, 4, 6, 1, 9, 4, 2, 7, 5, 6};
                        int K                     = 4;
                        int expected__            = 1;

                        return verifyCase(casenum__, expected__, new WinterAndMandarins().getNumber(bags, K));
            }
            case 4: {
                        int[] bags                = {47, 1000000000, 1, 74};
                        int K                     = 2;
                        int expected__            = 27;

                        return verifyCase(casenum__, expected__, new WinterAndMandarins().getNumber(bags, K));
            }

            // custom cases

            /*      case 5: {
                    int[] bags                = ;
                    int K                     = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WinterAndMandarins().getNumber(bags, K));
                    }*/
            /*      case 6: {
                    int[] bags                = ;
                    int K                     = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WinterAndMandarins().getNumber(bags, K));
                    }*/
            /*      case 7: {
                    int[] bags                = ;
                    int K                     = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WinterAndMandarins().getNumber(bags, K));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
