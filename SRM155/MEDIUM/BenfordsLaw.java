import java.lang.Math;

public class BenfordsLaw {
    public int questionableDigit(int[] transactions, int threshold) {
        int[] actual = new int[9];
        for(int i=0; i < transactions.length; i++) {
            char first_digit = String.valueOf(transactions[i]).charAt(0);
            int n = first_digit - '0';
            actual[n-1]++;
        }

        double[] expected = new double[9];
        for(int i=0; i<9; i++) {
            expected[i] =  transactions.length * Math.log10(1+1.0/(i+1));
        }

        for(int i=0; i<9; i++) {
            if(actual[i] > expected[i] * threshold ||
                    actual[i] < expected[i] / threshold) {
                return i+1;
            }
        }
        return -1;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			BenfordsLawHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				BenfordsLawHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class BenfordsLawHarness {
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
			int[] transactions        = { 5236,7290,200,1907,3336,9182,17,4209,8746,7932, 6375,909,2189,3977,2389,2500,1239,3448,6380,4812 };
			int threshold             = 2;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new BenfordsLaw().questionableDigit(transactions, threshold));
		}
		case 1: {
			int[] transactions        = { 1,10,100,2,20,200,2000,3,30,300 };
			int threshold             = 2;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new BenfordsLaw().questionableDigit(transactions, threshold));
		}
		case 2: {
			int[] transactions        = { 9,87,765,6543,54321,43219,321987,21987,1987,345,234,123 };
			int threshold             = 2;
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new BenfordsLaw().questionableDigit(transactions, threshold));
		}
		case 3: {
			int[] transactions        = { 1,2,3,4,5,6,7,8,7,6,5,4,3,2,1 };
			int threshold             = 8;
			int expected__            = 9;

			return verifyCase(casenum__, expected__, new BenfordsLaw().questionableDigit(transactions, threshold));
		}
		case 4: {
			int[] transactions        = { 987,234,1234,234873487,876,234562,17, 7575734,5555,4210,678234,3999,8123 };
			int threshold             = 3;
			int expected__            = 8;

			return verifyCase(casenum__, expected__, new BenfordsLaw().questionableDigit(transactions, threshold));
		}

		// custom cases

/*      case 5: {
			int[] transactions        = ;
			int threshold             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BenfordsLaw().questionableDigit(transactions, threshold));
		}*/
/*      case 6: {
			int[] transactions        = ;
			int threshold             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BenfordsLaw().questionableDigit(transactions, threshold));
		}*/
/*      case 7: {
			int[] transactions        = ;
			int threshold             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BenfordsLaw().questionableDigit(transactions, threshold));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
