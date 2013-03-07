// SRM146 EASY
import static java.lang.Math.*;

public class YahtzeeScore {
   public int maxPoints(int[] toss) {
       int[] point = new int[7];
       int len = toss.length;

       for(int i=0;i<len;i++) {
           point[toss[i]] += toss[i];
       }

       int max=0;
       for(int p : point) {
           max = max(max, p);
       }
       return max;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			YahtzeeScoreHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				YahtzeeScoreHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class YahtzeeScoreHarness {
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
			int[] toss                = { 2, 2, 3, 5, 4 };
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new YahtzeeScore().maxPoints(toss));
		}
		case 1: {
			int[] toss                = { 6, 4, 1, 1, 3 };
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new YahtzeeScore().maxPoints(toss));
		}
		case 2: {
			int[] toss                = { 5, 3, 5, 3, 3 };
			int expected__            = 10;

			return verifyCase(casenum__, expected__, new YahtzeeScore().maxPoints(toss));
		}

		// custom cases

/*      case 3: {
			int[] toss                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new YahtzeeScore().maxPoints(toss));
		}*/
/*      case 4: {
			int[] toss                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new YahtzeeScore().maxPoints(toss));
		}*/
/*      case 5: {
			int[] toss                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new YahtzeeScore().maxPoints(toss));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
