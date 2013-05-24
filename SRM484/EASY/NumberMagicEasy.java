public class NumberMagicEasy {
    public int theNumber(String answer) {
        answer = answer.replaceAll("Y", "0");
        answer = answer.replaceAll("N", "1");
        return Integer.parseInt(answer, 2) + 1;
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            NumberMagicEasyHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                NumberMagicEasyHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class NumberMagicEasyHarness {
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
                        String answer             = "YNYY";
                        int expected__            = 5;

                        return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
            }
            case 1: {
                        String answer             = "YNNN";
                        int expected__            = 8;

                        return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
            }
            case 2: {
                        String answer             = "NNNN";
                        int expected__            = 16;

                        return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
            }
            case 3: {
                        String answer             = "YYYY";
                        int expected__            = 1;

                        return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
            }
            case 4: {
                        String answer             = "NYNY";
                        int expected__            = 11;

                        return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
            }

            // custom cases

            /*      case 5: {
                    String answer             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
                    }*/
            /*      case 6: {
                    String answer             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
                    }*/
            /*      case 7: {
                    String answer             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
