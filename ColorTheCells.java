public class ColorTheCells {
   public int minimalTime(int[] dryingTime) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ColorTheCellsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ColorTheCellsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ColorTheCellsHarness {
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
			int[] dryingTime          = {2, 2, 3};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new ColorTheCells().minimalTime(dryingTime));
		}
		case 1: {
			int[] dryingTime          = {1, 2, 100, 1};
			int expected__            = 7;

			return verifyCase(casenum__, expected__, new ColorTheCells().minimalTime(dryingTime));
		}
		case 2: {
			int[] dryingTime          = {33, 58, 21, 44};
			int expected__            = 26;

			return verifyCase(casenum__, expected__, new ColorTheCells().minimalTime(dryingTime));
		}
		case 3: {
			int[] dryingTime          = {35198, 26281, 72533, 91031, 44326, 43178, 85530};
			int expected__            = 26287;

			return verifyCase(casenum__, expected__, new ColorTheCells().minimalTime(dryingTime));
		}

		// custom cases

/*      case 4: {
			int[] dryingTime          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ColorTheCells().minimalTime(dryingTime));
		}*/
/*      case 5: {
			int[] dryingTime          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ColorTheCells().minimalTime(dryingTime));
		}*/
/*      case 6: {
			int[] dryingTime          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ColorTheCells().minimalTime(dryingTime));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
