public class ColorfulBoxesAndBalls {
   public int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ColorfulBoxesAndBallsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ColorfulBoxesAndBallsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ColorfulBoxesAndBallsHarness {
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
			int numRed                = 2;
			int numBlue               = 3;
			int onlyRed               = 100;
			int onlyBlue              = 400;
			int bothColors            = 200;
			int expected__            = 1400;

			return verifyCase(casenum__, expected__, new ColorfulBoxesAndBalls().getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors));
		}
		case 1: {
			int numRed                = 2;
			int numBlue               = 3;
			int onlyRed               = 100;
			int onlyBlue              = 400;
			int bothColors            = 300;
			int expected__            = 1600;

			return verifyCase(casenum__, expected__, new ColorfulBoxesAndBalls().getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors));
		}
		case 2: {
			int numRed                = 5;
			int numBlue               = 5;
			int onlyRed               = 464;
			int onlyBlue              = 464;
			int bothColors            = 464;
			int expected__            = 4640;

			return verifyCase(casenum__, expected__, new ColorfulBoxesAndBalls().getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors));
		}
		case 3: {
			int numRed                = 1;
			int numBlue               = 4;
			int onlyRed               = 20;
			int onlyBlue              = -30;
			int bothColors            = -10;
			int expected__            = -100;

			return verifyCase(casenum__, expected__, new ColorfulBoxesAndBalls().getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors));
		}
		case 4: {
			int numRed                = 9;
			int numBlue               = 1;
			int onlyRed               = -1;
			int onlyBlue              = -10;
			int bothColors            = 4;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new ColorfulBoxesAndBalls().getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors));
		}

		// custom cases

/*      case 5: {
			int numRed                = ;
			int numBlue               = ;
			int onlyRed               = ;
			int onlyBlue              = ;
			int bothColors            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ColorfulBoxesAndBalls().getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors));
		}*/
/*      case 6: {
			int numRed                = ;
			int numBlue               = ;
			int onlyRed               = ;
			int onlyBlue              = ;
			int bothColors            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ColorfulBoxesAndBalls().getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors));
		}*/
/*      case 7: {
			int numRed                = ;
			int numBlue               = ;
			int onlyRed               = ;
			int onlyBlue              = ;
			int bothColors            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ColorfulBoxesAndBalls().getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
