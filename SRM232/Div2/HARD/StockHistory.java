public class StockHistory {
    public int maximumEarnings(int initialInvestment, int monthlyContribution, String[] stockPrices) {

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            StockHistoryHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                StockHistoryHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class StockHistoryHarness {
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
                        int initialInvestment     = 1000;
                        int monthlyContribution   = 0;
                        String[] stockPrices      = {"10 20 30", "15 24 32"};
                        int expected__            = 500;

                        return verifyCase(casenum__, expected__, new StockHistory().maximumEarnings(initialInvestment, monthlyContribution, stockPrices));
            }
            case 1: {
                        int initialInvestment     = 1000;
                        int monthlyContribution   = 0;
                        String[] stockPrices      = {"10", "9"};
                        int expected__            = 0;

                        return verifyCase(casenum__, expected__, new StockHistory().maximumEarnings(initialInvestment, monthlyContribution, stockPrices));
            }
            case 2: {
                        int initialInvestment     = 100;
                        int monthlyContribution   = 20;
                        String[] stockPrices      = {"40 50 60",
                            "37 48 55",
                            "100 48 50",
                            "105 48 47",
                            "110 50 52",
                            "110 50 52",
                            "110 51 54",
                            "109 49 53"};
                        int expected__            = 239;

                        return verifyCase(casenum__, expected__, new StockHistory().maximumEarnings(initialInvestment, monthlyContribution, stockPrices));
            }

            // custom cases

            /*      case 3: {
                    int initialInvestment     = ;
                    int monthlyContribution   = ;
                    String[] stockPrices      = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new StockHistory().maximumEarnings(initialInvestment, monthlyContribution, stockPrices));
                    }*/
            /*      case 4: {
                    int initialInvestment     = ;
                    int monthlyContribution   = ;
                    String[] stockPrices      = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new StockHistory().maximumEarnings(initialInvestment, monthlyContribution, stockPrices));
                    }*/
            /*      case 5: {
                    int initialInvestment     = ;
                    int monthlyContribution   = ;
                    String[] stockPrices      = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new StockHistory().maximumEarnings(initialInvestment, monthlyContribution, stockPrices));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
