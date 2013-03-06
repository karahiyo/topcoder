import java.util.*;

public class Time {
   public String whatTime(int seconds) {
       int H=0, M=0, S=0;
       int tmp=0;
       H = seconds/3600;
       tmp = seconds%3600;
       M = tmp/60;
       tmp = tmp%60;
       S = tmp;

       return Integer.toString(H)+":"+Integer.toString(M)+":"+Integer.toString(S);

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			TimeHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				TimeHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class TimeHarness {
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
			int seconds               = 0;
			String expected__         = "0:0:0";

			return verifyCase(casenum__, expected__, new Time().whatTime(seconds));
		}
		case 1: {
			int seconds               = 3661;
			String expected__         = "1:1:1";

			return verifyCase(casenum__, expected__, new Time().whatTime(seconds));
		}
		case 2: {
			int seconds               = 5436;
			String expected__         = "1:30:36";

			return verifyCase(casenum__, expected__, new Time().whatTime(seconds));
		}
		case 3: {
			int seconds               = 86399;
			String expected__         = "23:59:59";

			return verifyCase(casenum__, expected__, new Time().whatTime(seconds));
		}

		// custom cases

/*      case 4: {
			int seconds               = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new Time().whatTime(seconds));
		}*/
/*      case 5: {
			int seconds               = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new Time().whatTime(seconds));
		}*/
/*      case 6: {
			int seconds               = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new Time().whatTime(seconds));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
