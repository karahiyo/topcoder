public class TireRotation {
    String rot(String before) {
        String after = "";
        after += before.charAt(3);
        after += before.charAt(2);
        after += before.charAt(0);
        after += before.charAt(1);
        return after;
    }

    public int getCycle(String initial, String current) {
        for(int i=1;i<5;i++) {
            if(initial.equals(current))
                return i;
            initial = rot(initial);
        }
        return -1;

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            TireRotationHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                TireRotationHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class TireRotationHarness {
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
                        String initial            = "ABCD";
                        String current            = "ABCD";
                        int expected__            = 1;

                        return verifyCase(casenum__, expected__, new TireRotation().getCycle(initial, current));
            }
            case 1: {
                        String initial            = "ABCD";
                        String current            = "DCAB";
                        int expected__            = 2;

                        return verifyCase(casenum__, expected__, new TireRotation().getCycle(initial, current));
            }
            case 2: {
                        String initial            = "ABCD";
                        String current            = "CDBA";
                        int expected__            = 4;

                        return verifyCase(casenum__, expected__, new TireRotation().getCycle(initial, current));
            }
            case 3: {
                        String initial            = "ABCD";
                        String current            = "ABDC";
                        int expected__            = -1;

                        return verifyCase(casenum__, expected__, new TireRotation().getCycle(initial, current));
            }
            case 4: {
                        String initial            = "ZAXN";
                        String current            = "XNAZ";
                        int expected__            = 4;

                        return verifyCase(casenum__, expected__, new TireRotation().getCycle(initial, current));
            }

            // custom cases

            /*      case 5: {
                    String initial            = ;
                    String current            = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new TireRotation().getCycle(initial, current));
                    }*/
            /*      case 6: {
                    String initial            = ;
                    String current            = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new TireRotation().getCycle(initial, current));
                    }*/
            /*      case 7: {
                    String initial            = ;
                    String current            = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new TireRotation().getCycle(initial, current));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
