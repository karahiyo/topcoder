/*
 * SRM149 EASY
 */
public class FormatAmt {
   public String amount(int dollars, int cents) {
       return String.format("$%,d.%02d", dollars, cents);
   }
       /*
       StringBuilder D = new StringBuilder(""+dollars);
       for(int i=3;i<D.length();i+=4)
           D.insert(D.length()-i, ",");
       return "$"+D.toString()+"."+((cents < 10)?"0"+cents:cents);
       */


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			FormatAmtHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FormatAmtHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class FormatAmtHarness {
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
			int dollars               = 123456;
			int cents                 = 0;
			String expected__         = "$123,456.00";

			return verifyCase(casenum__, expected__, new FormatAmt().amount(dollars, cents));
		}
		case 1: {
			int dollars               = 49734321;
			int cents                 = 9;
			String expected__         = "$49,734,321.09";

			return verifyCase(casenum__, expected__, new FormatAmt().amount(dollars, cents));
		}
		case 2: {
			int dollars               = 0;
			int cents                 = 99;
			String expected__         = "$0.99";

			return verifyCase(casenum__, expected__, new FormatAmt().amount(dollars, cents));
		}
		case 3: {
			int dollars               = 249;
			int cents                 = 30;
			String expected__         = "$249.30";

			return verifyCase(casenum__, expected__, new FormatAmt().amount(dollars, cents));
		}
		case 4: {
			int dollars               = 1000;
			int cents                 = 1;
			String expected__         = "$1,000.01";

			return verifyCase(casenum__, expected__, new FormatAmt().amount(dollars, cents));
		}

		// custom cases

/*      case 5: {
			int dollars               = ;
			int cents                 = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new FormatAmt().amount(dollars, cents));
		}*/
/*      case 6: {
			int dollars               = ;
			int cents                 = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new FormatAmt().amount(dollars, cents));
		}*/
/*      case 7: {
			int dollars               = ;
			int cents                 = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new FormatAmt().amount(dollars, cents));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
