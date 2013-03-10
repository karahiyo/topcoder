public class PrimeContainers {
   public int containerSize(int N) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			PrimeContainersHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				PrimeContainersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class PrimeContainersHarness {
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
			int N                     = 10;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new PrimeContainers().containerSize(N));
		}
		case 1: {
			int N                     = 42;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new PrimeContainers().containerSize(N));
		}
		case 2: {
			int N                     = 47;
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new PrimeContainers().containerSize(N));
		}
		case 3: {
			int N                     = 959;
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new PrimeContainers().containerSize(N));
		}
		case 4: {
			int N                     = 421337;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new PrimeContainers().containerSize(N));
		}

		// custom cases

/*      case 5: {
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PrimeContainers().containerSize(N));
		}*/
/*      case 6: {
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PrimeContainers().containerSize(N));
		}*/
/*      case 7: {
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PrimeContainers().containerSize(N));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
