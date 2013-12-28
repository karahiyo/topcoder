import java.util.*;

public class PilingRectsDiv2 {
    public int getmax(int[] X, int[] Y, int limit) {
        int max = 0;
        for (int x=1; x <= 200; x++) {
            for (int y=1; y <= 200; y++) {
                if ( x*y >= limit) {
                    int cnt = 0;
                    for (int i=0; i< X.length; i++)
                        if ((X[i] >= x && Y[i] >= y) ||
                                (X[i] >= y && Y[i] >=x)) 
                            cnt++;
                    max = Math.max(max, cnt);
                }
            }
        }
        return max == 0 ? -1:max;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            PilingRectsDiv2Harness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                PilingRectsDiv2Harness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class PilingRectsDiv2Harness {
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
                        int[] X                   = {1,2,3,1};
                        int[] Y                   = {3,2,4,4};
                        int limit                 = 3;
                        int expected__            = 3;

                        return verifyCase(casenum__, expected__, new PilingRectsDiv2().getmax(X, Y, limit));
            }
            case 1: {
                        int[] X                   = {4,7};
                        int[] Y                   = {7,4};
                        int limit                 = 25;
                        int expected__            = 2;

                        return verifyCase(casenum__, expected__, new PilingRectsDiv2().getmax(X, Y, limit));
            }
            case 2: {
                        int[] X                   = {10};
                        int[] Y                   = {10};
                        int limit                 = 9999;
                        int expected__            = -1;

                        return verifyCase(casenum__, expected__, new PilingRectsDiv2().getmax(X, Y, limit));
            }
            case 3: {
                        int[] X                   = {10};
                        int[] Y                   = {3};
                        int limit                 = 30;
                        int expected__            = 1;

                        return verifyCase(casenum__, expected__, new PilingRectsDiv2().getmax(X, Y, limit));
            }
            case 4: {
                        int[] X                   = {3,6,5,8,2,9,14};
                        int[] Y                   = {14,6,13,8,15,6,3};
                        int limit                 = 27;
                        int expected__            = 4;

                        return verifyCase(casenum__, expected__, new PilingRectsDiv2().getmax(X, Y, limit));
            }
            case 5: {
                        int[] X                   = {121,168,86,106,36,10,125,97,53,26,148,129,41,18,173,55,13,73,91,174,177,190,28,164,122,92,5,26,58,188,14,67,48,196,41,94,24,89,54,117,12,6,155,103,200,128,184,29,92,149};
                        int[] Y                   = {199,182,43,191,2,145,15,53,38,37,61,45,157,129,119,123,177,178,183,188,132,108,112,137,92,59,75,196,102,152,114,121,181,93,32,3,24,116,4,163,96,159,196,43,59,150,79,113,20,146};
                        int limit                 = 5345;
                        int expected__            = 24;

                        return verifyCase(casenum__, expected__, new PilingRectsDiv2().getmax(X, Y, limit));
            }

            // custom cases

            /*      case 6: {
                    int[] X                   = ;
                    int[] Y                   = ;
                    int limit                 = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new PilingRectsDiv2().getmax(X, Y, limit));
                    }*/
            /*      case 7: {
                    int[] X                   = ;
                    int[] Y                   = ;
                    int limit                 = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new PilingRectsDiv2().getmax(X, Y, limit));
                    }*/
            /*      case 8: {
                    int[] X                   = ;
                    int[] Y                   = ;
                    int limit                 = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new PilingRectsDiv2().getmax(X, Y, limit));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
