import java.util.*;

public class BigFatInteger2 {
    public String isDivisible(int A, int B, int C, int D) {
        for (int i=2; i*i <= C; i++) {
            long p=0, q = 0;
            while (A%i == 0) {
                p++;
                A /= i;
            }
            while (C%i == 0) {
                q++;
                C /= i;
            }
            if ( p * B < q * D) {
                return "not divisible";
            }
        }
        if ( C > 1) {
            long p = 0;
            while (A%C == 0) {
                p++;
                A /= C;
            }
            if (p * B < 1 * D)  return "not divisible";
        }
        return "divisible";
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            BigFatInteger2Harness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                BigFatInteger2Harness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class BigFatInteger2Harness {
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

    static boolean compareOutput(String expected, String result) { return expected.equals(result); }
    static String formatResult(String res) {
        return String.format("\"%s\"", res);
    }

    static int verifyCase(int casenum, String expected, String received) { 
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
                        int A                     = 6;
                        int B                     = 1;
                        int C                     = 2;
                        int D                     = 1;
                        String expected__         = "divisible";

                        return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
            }
            case 1: {
                        int A                     = 2;
                        int B                     = 1;
                        int C                     = 6;
                        int D                     = 1;
                        String expected__         = "not divisible";

                        return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
            }
            case 2: {
                        int A                     = 1000000000;
                        int B                     = 1000000000;
                        int C                     = 1000000000;
                        int D                     = 200000000;
                        String expected__         = "divisible";

                        return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
            }
            case 3: {
                        int A                     = 8;
                        int B                     = 100;
                        int C                     = 4;
                        int D                     = 200;
                        String expected__         = "not divisible";

                        return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
            }
            case 4: {
                        int A                     = 999999937;
                        int B                     = 1000000000;
                        int C                     = 999999929;
                        int D                     = 1;
                        String expected__         = "not divisible";

                        return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
            }
            case 5: {
                        int A                     = 2;
                        int B                     = 2;
                        int C                     = 4;
                        int D                     = 1;
                        String expected__         = "divisible";

                        return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
            }

            case 6: {
                        int A                     = 268435456;
                        int B                     = 1;
                        int C                     = 2;
                        int D                     = 29;
                        String expected__         = "not divisible";

                        return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
            }
            case 7: {
                        int A                     = 2;
                        int B                     = 999999999;
                        int C                     = 2;
                        int D                     = 1000000000;
                        String expected__         = "not divisible";

                        return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
            }
            case 8: {
                        int A                   = 1000000000;
                        int B                   = 1000000000;  
                        int C                   = 2;
                        int D                   = 1;
                        String expected__       = "divisible";

                        return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
            }
            default:
                    return -1;
        }
    }
}

// END CUT HERE
