import java.util.*;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=12623&rd=15707&rm=319159&cr=23158084
 */
public class LittleElephantAndXor {
    public long getNumber(int A, int B, int C) {
        long ret = 0;
        long N = (long)Math.pow(A+1, B+1);

        for( int a = 0; a<=A; a++) {
            int xor = a ^ B;
            if(xor <= C) {
                ret++;
            }
        }

        return ret;

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            LittleElephantAndXorHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                LittleElephantAndXorHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class LittleElephantAndXorHarness {
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

    static boolean compareOutput(long expected, long result) { return expected == result; }
    static String formatResult(long res) {
        return String.format("%d", res);
    }

    static int verifyCase(int casenum, long expected, long received) { 
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
                        int A                     = 2;
                        int B                     = 2;
                        int C                     = 1;
                        long expected__           = 5;

                        return verifyCase(casenum__, expected__, new LittleElephantAndXor().getNumber(A, B, C));
            }
            case 1: {
                        int A                     = 4;
                        int B                     = 7;
                        int C                     = 3;
                        long expected__           = 20;

                        return verifyCase(casenum__, expected__, new LittleElephantAndXor().getNumber(A, B, C));
            }
            case 2: {
                        int A                     = 10;
                        int B                     = 10;
                        int C                     = 5;
                        long expected__           = 57;

                        return verifyCase(casenum__, expected__, new LittleElephantAndXor().getNumber(A, B, C));
            }
            case 3: {
                        int A                     = 774;
                        int B                     = 477;
                        int C                     = 447;
                        long expected__           = 214144;

                        return verifyCase(casenum__, expected__, new LittleElephantAndXor().getNumber(A, B, C));
            }
            case 4: {
                        int A                     = 1000000000;
                        int B                     = 1000000000;
                        int C                     = 500000000;
                        long expected__           = 468566946385621507L;

                        return verifyCase(casenum__, expected__, new LittleElephantAndXor().getNumber(A, B, C));
            }

            // custom cases

            /*      case 5: {
                    int A                     = ;
                    int B                     = ;
                    int C                     = ;
                    long expected__           = ;

                    return verifyCase(casenum__, expected__, new LittleElephantAndXor().getNumber(A, B, C));
                    }*/
            /*      case 6: {
                    int A                     = ;
                    int B                     = ;
                    int C                     = ;
                    long expected__           = ;

                    return verifyCase(casenum__, expected__, new LittleElephantAndXor().getNumber(A, B, C));
                    }*/
            /*      case 7: {
                    int A                     = ;
                    int B                     = ;
                    int C                     = ;
                    long expected__           = ;

                    return verifyCase(casenum__, expected__, new LittleElephantAndXor().getNumber(A, B, C));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
