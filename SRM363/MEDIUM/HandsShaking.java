public class HandsShaking {
    public long countPerfect(int n) {
        long[] map = new long[n/2+1];
        map[0] = 1;

        for(int i=1; i<=n/2; i++) {
            map[i] = 0;
            for(int j=0; j<i; j++) {
                map[i] += map[j] * map[i-j-1];
            }
        }

        return map[n/2];

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            HandsShakingHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                HandsShakingHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class HandsShakingHarness {
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
                        int n                     = 2;
                        long expected__           = 1;

                        return verifyCase(casenum__, expected__, new HandsShaking().countPerfect(n));
            }
            case 1: {
                        int n                     = 4;
                        long expected__           = 2;

                        return verifyCase(casenum__, expected__, new HandsShaking().countPerfect(n));
            }
            case 2: {
                        int n                     = 8;
                        long expected__           = 14;

                        return verifyCase(casenum__, expected__, new HandsShaking().countPerfect(n));
            }

            // custom cases

            /*      case 3: {
                    int n                     = ;
                    long expected__           = ;

                    return verifyCase(casenum__, expected__, new HandsShaking().countPerfect(n));
                    }*/
            /*      case 4: {
                    int n                     = ;
                    long expected__           = ;

                    return verifyCase(casenum__, expected__, new HandsShaking().countPerfect(n));
                    }*/
            /*      case 5: {
                    int n                     = ;
                    long expected__           = ;

                    return verifyCase(casenum__, expected__, new HandsShaking().countPerfect(n));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
