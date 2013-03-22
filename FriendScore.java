public class FriendScore {
   public int highestScore(String[] friends) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			FriendScoreHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FriendScoreHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class FriendScoreHarness {
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
			String[] friends          = {"NNN",
 "NNN",
 "NNN"};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new FriendScore().highestScore(friends));
		}
		case 1: {
			String[] friends          = {"NYY",
 "YNY",
 "YYN"};
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new FriendScore().highestScore(friends));
		}
		case 2: {
			String[] friends          = {"NYNNN",
 "YNYNN", 
 "NYNYN", 
 "NNYNY", 
 "NNNYN"};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new FriendScore().highestScore(friends));
		}
		case 3: {
			String[] friends          = {"NNNNYNNNNN",
 "NNNNYNYYNN",
 "NNNYYYNNNN",
 "NNYNNNNNNN",
 "YYYNNNNNNY",
 "NNYNNNNNYN",
 "NYNNNNNYNN",
 "NYNNNNYNNN",
 "NNNNNYNNNN",
 "NNNNYNNNNN"};
			int expected__            = 8;

			return verifyCase(casenum__, expected__, new FriendScore().highestScore(friends));
		}
		case 4: {
			String[] friends          = {"NNNNNNNNNNNNNNY",
 "NNNNNNNNNNNNNNN",
 "NNNNNNNYNNNNNNN",
 "NNNNNNNYNNNNNNY",
 "NNNNNNNNNNNNNNY",
 "NNNNNNNNYNNNNNN",
 "NNNNNNNNNNNNNNN",
 "NNYYNNNNNNNNNNN",
 "NNNNNYNNNNNYNNN",
 "NNNNNNNNNNNNNNY",
 "NNNNNNNNNNNNNNN",
 "NNNNNNNNYNNNNNN",
 "NNNNNNNNNNNNNNN",
 "NNNNNNNNNNNNNNN",
 "YNNYYNNNNYNNNNN"};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new FriendScore().highestScore(friends));
		}

		// custom cases

/*      case 5: {
			String[] friends          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FriendScore().highestScore(friends));
		}*/
/*      case 6: {
			String[] friends          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FriendScore().highestScore(friends));
		}*/
/*      case 7: {
			String[] friends          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FriendScore().highestScore(friends));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
