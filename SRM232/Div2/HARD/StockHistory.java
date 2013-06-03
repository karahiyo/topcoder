public class StockHistory {
    public int maximumEarnings(int initialInvestment, int monthlyContribution, String[] stockPrices) {
        
        int timeframe = stockPrices.length;
        int coms_num = stockPrices[0].split(" ").length;
        int[][] stocks = new int[timeframe][coms_num];

        for(int i=0; i<timeframe; i++) {
            String[] s = stockPrices[i].split(" ");
            for(int j=0; j<coms_num; j++) {
                stocks[i][j] = Integer.parseInt(s[j]);
            }
        }

        boolean[] buy = new boolean[timeframe-1];
        double[] profit = new double[timeframe];
        double max_profit = 0.0;

        for(int i=0; i<timeframe-1; i++) {
            double  tmp_profit = 0;
            for(int j=0; j<coms_num; j++) {
                int a = stocks[i][j];
                int b = stocks[timeframe-1][j];
                if(b > a) {
                    buy[i] = true;
                    tmp_profit = Math.max(tmp_profit, (double)b/a);
                } 
            }
            profit[i] = tmp_profit;
            max_profit = Math.max(max_profit, tmp_profit);
            System.err.print("** " + profit[i] +"\n");
        }

        double ret = 0;
        boolean start = false;
        int money = monthlyContribution;
        for(int i=0; i<buy.length; i++) {
            if(start) {
                if(buy[i]) {
                    ret += money * (profit[i] - 1);
                    System.err.print("["+i+"]"+ profit[i] +" ==>> ");
                    System.err.print(ret+"\n");
                } else {
                    money += monthlyContribution;
                }
            }
            if(max_profit == profit[i] && max_profit > 0) {
                ret += initialInvestment * (max_profit - 1);
                System.err.print("*************START\n"+ret+"\n");
                start = true;
            }
        }

        return (int)Math.round(ret);
        /*
         * 109/37 = 2.94
         * 53/37 = 1.43
         * 53/52 = 1.01
         *
         * 1.94*init_money + 0.43 * money + 0.01 * money
         */
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
