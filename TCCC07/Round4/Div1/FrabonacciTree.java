public class FrabonacciTree {
   public String shortestPath(int n, int startIndex, int finishIndex) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			FrabonacciTreeHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FrabonacciTreeHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class FrabonacciTreeHarness {
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
			int n                     = 3;
			int startIndex            = 2;
			int finishIndex           = 4;
			String expected__         = "URL";

			return verifyCase(casenum__, expected__, new FrabonacciTree().shortestPath(n, startIndex, finishIndex));
		}
		case 1: {
			int n                     = 3;
			int startIndex            = 4;
			int finishIndex           = 2;
			String expected__         = "UUL";

			return verifyCase(casenum__, expected__, new FrabonacciTree().shortestPath(n, startIndex, finishIndex));
		}
		case 2: {
			int n                     = 3;
			int startIndex            = 5;
			int finishIndex           = 4;
			String expected__         = "UL";

			return verifyCase(casenum__, expected__, new FrabonacciTree().shortestPath(n, startIndex, finishIndex));
		}
		case 3: {
			int n                     = 12;
			int startIndex            = 10;
			int finishIndex           = 10;
			String expected__         = "";

			return verifyCase(casenum__, expected__, new FrabonacciTree().shortestPath(n, startIndex, finishIndex));
		}

		// custom cases

/*      case 4: {
			int n                     = ;
			int startIndex            = ;
			int finishIndex           = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new FrabonacciTree().shortestPath(n, startIndex, finishIndex));
		}*/
/*      case 5: {
			int n                     = ;
			int startIndex            = ;
			int finishIndex           = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new FrabonacciTree().shortestPath(n, startIndex, finishIndex));
		}*/
/*      case 6: {
			int n                     = ;
			int startIndex            = ;
			int finishIndex           = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new FrabonacciTree().shortestPath(n, startIndex, finishIndex));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
