public class WolfInZooDivTwo {
   public int count(int N, String[] L, String[] R) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			WolfInZooDivTwoHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				WolfInZooDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class WolfInZooDivTwoHarness {
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
			int N                     = 5;
			String[] L                = {"0 1"};
			String[] R                = {"2 4"};
			int expected__            = 27;

			return verifyCase(casenum__, expected__, new WolfInZooDivTwo().count(N, L, R));
		}
		case 1: {
			int N                     = 10;
			String[] L                = {"0 4 2 7"};
			String[] R                = {"3 9 5 9"};
			int expected__            = 798;

			return verifyCase(casenum__, expected__, new WolfInZooDivTwo().count(N, L, R));
		}
		case 2: {
			int N                     = 100;
			String[] L                = {"0 2 2 7 10 1","3 16 22 30 33 38"," 42 44 49 51 57 60 62"," 65 69 72 74 77 7","8 81 84 88 91 93 96"};
			String[] R                = {"41 5 13 22 12 13 ","33 41 80 47 40 ","4","8 96 57 66 ","80 60 71 79"," 70 77 ","99"," 83 85 93 88 89 97 97 98"};
			int expected__            = 250671525;

			return verifyCase(casenum__, expected__, new WolfInZooDivTwo().count(N, L, R));
		}
		case 3: {
			int N                     = 3;
			String[] L                = {"1"};
			String[] R                = {"2"};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new WolfInZooDivTwo().count(N, L, R));
		}

		// custom cases

/*      case 4: {
			int N                     = ;
			String[] L                = ;
			String[] R                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new WolfInZooDivTwo().count(N, L, R));
		}*/
/*      case 5: {
			int N                     = ;
			String[] L                = ;
			String[] R                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new WolfInZooDivTwo().count(N, L, R));
		}*/
/*      case 6: {
			int N                     = ;
			String[] L                = ;
			String[] R                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new WolfInZooDivTwo().count(N, L, R));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
