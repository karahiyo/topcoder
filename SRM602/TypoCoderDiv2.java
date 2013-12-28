
public class TypoCoderDiv2 {
    public int count(int[] rating) {
        int count = 0;
        int rate = 500;
        for(int r: rating) {
            if (rate < 1200 && r >= 1200) {
                count++;
            } else if (rate >= 1200 && r < 1200) {
                count++;
            } 
            rate = r;
        }

        return count;

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            TypoCoderDiv2Harness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                TypoCoderDiv2Harness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class TypoCoderDiv2Harness {
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
                        int[] rating              = {1000,1200,1199};
                        int expected__            = 2;

                        return verifyCase(casenum__, expected__, new TypoCoderDiv2().count(rating));
            }
            case 1: {
                        int[] rating              = {1500,2200,900,3000};
                        int expected__            = 3;

                        return verifyCase(casenum__, expected__, new TypoCoderDiv2().count(rating));
            }
            case 2: {
                        int[] rating              = {600,700,800,900,1000,1100,1199};
                        int expected__            = 0;

                        return verifyCase(casenum__, expected__, new TypoCoderDiv2().count(rating));
            }
            case 3: {
                        int[] rating              = {0,4000,0,4000,4000,0,0};
                        int expected__            = 4;

                        return verifyCase(casenum__, expected__, new TypoCoderDiv2().count(rating));
            }
            case 4: {
                        int[] rating              = {575,1090,3271,2496,859,2708,3774,2796,1616,2552,3783,2435,1111,526,562};
                        int expected__            = 4;

                        return verifyCase(casenum__, expected__, new TypoCoderDiv2().count(rating));
            }

            // custom cases

            /*      case 5: {
                    int[] rating              = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new TypoCoderDiv2().count(rating));
                    }*/
            /*      case 6: {
                    int[] rating              = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new TypoCoderDiv2().count(rating));
                    }*/
            /*      case 7: {
                    int[] rating              = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new TypoCoderDiv2().count(rating));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
