public class LittleElephantAndArray {
   public int getNumber(long A, int N) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			LittleElephantAndArrayHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				LittleElephantAndArrayHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class LittleElephantAndArrayHarness {
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
			long A                    = 1;
			int N                     = 9;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new LittleElephantAndArray().getNumber(A, N));
		}
		case 1: {
			long A                    = 10;
			int N                     = 2;
			int expected__            = 15;

			return verifyCase(casenum__, expected__, new LittleElephantAndArray().getNumber(A, N));
		}
		case 2: {
			long A                    = 4747774;
			int N                     = 1;
			int expected__            = 8369;

			return verifyCase(casenum__, expected__, new LittleElephantAndArray().getNumber(A, N));
		}
		case 3: {
			long A                    = 6878542150015L;
			int N                     = 74;
			int expected__            = 977836619;

			return verifyCase(casenum__, expected__, new LittleElephantAndArray().getNumber(A, N));
		}

		// custom cases

/*      case 4: {
			long A                    = ;
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new LittleElephantAndArray().getNumber(A, N));
		}*/
/*      case 5: {
			long A                    = ;
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new LittleElephantAndArray().getNumber(A, N));
		}*/
/*      case 6: {
			long A                    = ;
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new LittleElephantAndArray().getNumber(A, N));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
