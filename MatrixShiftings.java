public class MatrixShiftings {
   public int minimumShifts(String[] matrix, int value) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			MatrixShiftingsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				MatrixShiftingsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class MatrixShiftingsHarness {
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
			String[] matrix           = {"136",
 "427",
 "568",
 "309"};
			int value                 = 2;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new MatrixShiftings().minimumShifts(matrix, value));
		}
		case 1: {
			String[] matrix           = {"0000",
 "0000",
 "0099"};
			int value                 = 9;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new MatrixShiftings().minimumShifts(matrix, value));
		}
		case 2: {
			String[] matrix           = {"0123456789"};
			int value                 = 7;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new MatrixShiftings().minimumShifts(matrix, value));
		}
		case 3: {
			String[] matrix           = {"555",
 "555"};
			int value                 = 1;
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new MatrixShiftings().minimumShifts(matrix, value));
		}
		case 4: {
			String[] matrix           = {"12417727123",
 "65125691886",
 "55524912622",
 "12261288888"};
			int value                 = 9;
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new MatrixShiftings().minimumShifts(matrix, value));
		}

		// custom cases

/*      case 5: {
			String[] matrix           = ;
			int value                 = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new MatrixShiftings().minimumShifts(matrix, value));
		}*/
/*      case 6: {
			String[] matrix           = ;
			int value                 = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new MatrixShiftings().minimumShifts(matrix, value));
		}*/
/*      case 7: {
			String[] matrix           = ;
			int value                 = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new MatrixShiftings().minimumShifts(matrix, value));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
