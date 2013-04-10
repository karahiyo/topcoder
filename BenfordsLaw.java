import java.lang.Math;

public class BenfordsLaw {
    public int questionableDigit(int[] transactions, int threshold) {
        int len = transactions.length;
        int[] actual = new int[9];
        System.err.print("\n");
        for(int i=0; i<9; i++) {
            for(int j=0; j<len; j++) {
                char first_digit = String.valueOf(transactions[j]).charAt(0);
                //System.err.print((first_digit+1)+":"+(i+1)+"\n");
                if((first_digit - '0') == (i+1)) {
                    //System.err.print("@@@@@@@@@@@@@@@");
                    actual[i] = actual[i]+1;
                }
            }
        }

        double[] expected = new double[9];
        for(int i=0; i<9; i++) {
            if(actual[i]==0) continue;
            expected[i] = ( Math.log(1.0+1.0/((double)i+1.0)) / Math.log(10.0))
                * transactions.length;
        }

        System.err.print("threshold="+threshold+"\n");
        System.err.print("actual: ");
        for(int v : actual)
            System.err.print(v+" ");
        System.err.print("\n");
        System.err.print("expected: ");
        for(double v : expected)
            System.err.print(v+" ");
        System.err.print("\n");

        int rec = -1;
        double min = 1000;
        for(int i=0; i<9; i++) {
            //if(actual[i] == 0) continue;
            if(actual[i] > expected[i] * threshold ||
                    actual[i] < expected[i] * (1.0 / threshold)) {
                min = expected[i]/actual[i];
                rec = i+1;
                System.err.print("["+rec+"] min = "+min+"\n");
                return i+1;
            }
            /*
            else if (threshold < actual[i]/expected[i]
                    && min > actual[i]/expected[i]) {
                min = actual[i]/expected[i];
                rec = i+1;
                System.err.print("["+rec+"] min = "+min+"\n");
            }
            */
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
