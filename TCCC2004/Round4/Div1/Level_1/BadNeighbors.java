public class BadNeighbors {
    public int maxDonations(int[] donations) {
        int ret = 0;
        int house_num = donations.length;
        int[] dp = new int[house_num];

        for(int i=0;i<house_num-1; i++) {
            dp[i] = donations[i];
            if(i > 0) dp[i] = Math.max(dp[i], dp[i-1]);
            if(i > 1) dp[i] = Math.max(dp[i], dp[i-2] + donations[i]);
            ret = Math.max(ret, dp[i]);
        }

        for(int i=1;i<house_num; i++) {
            dp[i-1] = donations[i];
            if(i > 1) dp[i-1] = Math.max(dp[i-1], dp[i-2]);
            if(i > 2) dp[i-1] = Math.max(dp[i-1], dp[i-3] + donations[i]);
            ret = Math.max(ret, dp[i-1]);
        }

        return ret;

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            BadNeighborsHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                BadNeighborsHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class BadNeighborsHarness {
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
                        int[] donations           =  { 10, 3, 2, 5, 7, 8 };
                        int expected__            = 19;

                        return verifyCase(casenum__, expected__, new BadNeighbors().maxDonations(donations));
            }
            case 1: {
                        int[] donations           = { 11, 15 };
                        int expected__            = 15;

                        return verifyCase(casenum__, expected__, new BadNeighbors().maxDonations(donations));
            }
            case 2: {
                        int[] donations           = { 7, 7, 7, 7, 7, 7, 7 };
                        int expected__            = 21;

                        return verifyCase(casenum__, expected__, new BadNeighbors().maxDonations(donations));
            }
            case 3: {
                        int[] donations           = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
                        int expected__            = 16;

                        return verifyCase(casenum__, expected__, new BadNeighbors().maxDonations(donations));
            }
            case 4: {
                        int[] donations           = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
                        int expected__            = 2926;

                        return verifyCase(casenum__, expected__, new BadNeighbors().maxDonations(donations));
            }

            // custom cases

            /*      case 5: {
                    int[] donations           = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new BadNeighbors().maxDonations(donations));
                    }*/
            /*      case 6: {
                    int[] donations           = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new BadNeighbors().maxDonations(donations));
                    }*/
            /*      case 7: {
                    int[] donations           = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new BadNeighbors().maxDonations(donations));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
