
public class PrefixCode {
   public String isOne(String[] words) {
       if (words.length == 1)
           return "Yes";
       for(int i=0;i<words.length;i++) {
           for (int j=0;j<words.length; j++) {
               if(i==j)
                   continue;
               if(words[j].startsWith(words[i]))
                   return "No, "+i;
           }
       }
       return "Yes";
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			PrefixCodeHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				PrefixCodeHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class PrefixCodeHarness {
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
			String[] words            = {"trivial"};
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new PrefixCode().isOne(words));
		}
		case 1: {
			String[] words            = {"10001", "011", "100", "001", "10"};
			String expected__         = "No, 2";

			return verifyCase(casenum__, expected__, new PrefixCode().isOne(words));
		}
		case 2: {
			String[] words            = {"no", "nosy", "neighbors", "needed"};
			String expected__         = "No, 0";

			return verifyCase(casenum__, expected__, new PrefixCode().isOne(words));
		}
		case 3: {
			String[] words            = {"1010", "11", "100", "0", "1011"};
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new PrefixCode().isOne(words));
		}
		case 4: {
			String[] words            = {"No", "not"};
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new PrefixCode().isOne(words));
		}

		// custom cases

/*      case 5: {
			String[] words            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new PrefixCode().isOne(words));
		}*/
/*      case 6: {
			String[] words            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new PrefixCode().isOne(words));
		}*/
/*      case 7: {
			String[] words            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new PrefixCode().isOne(words));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
