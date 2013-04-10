public class TheNumberGameDivTwo {
   public String find(int n) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			TheNumberGameDivTwoHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				TheNumberGameDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class TheNumberGameDivTwoHarness {
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
			int n                     = 6;
			String expected__         = "John";

			return verifyCase(casenum__, expected__, new TheNumberGameDivTwo().find(n));
		}
		case 1: {
			int n                     = 2;
			String expected__         = "Brus";

			return verifyCase(casenum__, expected__, new TheNumberGameDivTwo().find(n));
		}
		case 2: {
			int n                     = 747;
			String expected__         = "Brus";

			return verifyCase(casenum__, expected__, new TheNumberGameDivTwo().find(n));
		}
		case 3: {
			int n                     = 128;
			String expected__         = "Brus";

			return verifyCase(casenum__, expected__, new TheNumberGameDivTwo().find(n));
		}

		// custom cases

/*      case 4: {
			int n                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new TheNumberGameDivTwo().find(n));
		}*/
/*      case 5: {
			int n                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new TheNumberGameDivTwo().find(n));
		}*/
/*      case 6: {
			int n                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new TheNumberGameDivTwo().find(n));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
