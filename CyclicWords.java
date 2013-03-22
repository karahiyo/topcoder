public class CyclicWords {
   public int differentCW(String[] words) {
       int rec = 0;
       for (int n=0; n<words.length; n++) {
           int m = (words.length+1)/2 + n;
           boolean ok = true;
           for(int i=0;i<m;i++) {
               if(words.charAt(m-i)!=words.charAt(m+i)) {
                   ok = false;
                   break;
               }
           }
           if(ok) return words.length + n;
       }

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			CyclicWordsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				CyclicWordsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class CyclicWordsHarness {
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
			String[] words            = { "picture", "turepic", "icturep", "word", "ordw" };
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new CyclicWords().differentCW(words));
		}
		case 1: {
			String[] words            = { "ast", "ats", "tas", "tsa", "sat", "sta", "ttt" };
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new CyclicWords().differentCW(words));
		}
		case 2: {
			String[] words            = {"aaaa", "aaa", "aa", "aaaa", "aaaaa"};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new CyclicWords().differentCW(words));
		}

		// custom cases

/*      case 3: {
			String[] words            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CyclicWords().differentCW(words));
		}*/
/*      case 4: {
			String[] words            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CyclicWords().differentCW(words));
		}*/
/*      case 5: {
			String[] words            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CyclicWords().differentCW(words));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
