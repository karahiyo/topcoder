public class KiwiJuiceEasy {
   public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
       int[] rec = bottles;
       for (int i=0;i<fromId.length;i++) {
           int f = fromId[i];
           int t = toId[i];
           int vol = bottles[f] + bottles[t];
           if (capacities[t] > vol) {
               bottles[t] = vol;
               bottles[f] = 0;
           } else {
               bottles[t] = capacities[t];
               bottles[f] = vol - capacities[t];
           }
        }
       return rec;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			KiwiJuiceEasyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				KiwiJuiceEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class KiwiJuiceEasyHarness {
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

	static boolean compareOutput(int[] expected, int[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (expected[i] != result[i]) return false; return true; }

	static String formatResult(int[] res) {
		String ret = "";
		ret += "{";
		for (int i=0; i<res.length; ++i) {
			if (i > 0) ret += ",";
			ret += String.format(" %d", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, int[] expected, int[] received) {
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
			int[] capacities          = {20, 20};
			int[] bottles             = {5, 8};
			int[] fromId              = {0};
			int[] toId                = {1};
			int[] expected__          = {0, 13 };

			return verifyCase(casenum__, expected__, new KiwiJuiceEasy().thePouring(capacities, bottles, fromId, toId));
		}
		case 1: {
			int[] capacities          = {10, 10};
			int[] bottles             = {5, 8};
			int[] fromId              = {0};
			int[] toId                = {1};
			int[] expected__          = {3, 10 };

			return verifyCase(casenum__, expected__, new KiwiJuiceEasy().thePouring(capacities, bottles, fromId, toId));
		}
		case 2: {
			int[] capacities          = {30, 20, 10};
			int[] bottles             = {10, 5, 5};
			int[] fromId              = {0, 1, 2};
			int[] toId                = {1, 2, 0};
			int[] expected__          = {10, 10, 0 };

			return verifyCase(casenum__, expected__, new KiwiJuiceEasy().thePouring(capacities, bottles, fromId, toId));
		}
		case 3: {
			int[] capacities          = {14, 35, 86, 58, 25, 62};
			int[] bottles             = {6, 34, 27, 38, 9, 60};
			int[] fromId              = {1, 2, 4, 5, 3, 3, 1, 0};
			int[] toId                = {0, 1, 2, 4, 2, 5, 3, 1};
			int[] expected__          = {0, 14, 65, 35, 25, 35 };

			return verifyCase(casenum__, expected__, new KiwiJuiceEasy().thePouring(capacities, bottles, fromId, toId));
		}
		case 4: {
			int[] capacities          = {700000, 800000, 900000, 1000000};
			int[] bottles             = {478478, 478478, 478478, 478478};
			int[] fromId              = {2, 3, 2, 0, 1};
			int[] toId                = {0, 1, 1, 3, 2};
			int[] expected__          = {0, 156956, 900000, 856956 };

			return verifyCase(casenum__, expected__, new KiwiJuiceEasy().thePouring(capacities, bottles, fromId, toId));
		}

		// custom cases

/*      case 5: {
			int[] capacities          = ;
			int[] bottles             = ;
			int[] fromId              = ;
			int[] toId                = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new KiwiJuiceEasy().thePouring(capacities, bottles, fromId, toId));
		}*/
/*      case 6: {
			int[] capacities          = ;
			int[] bottles             = ;
			int[] fromId              = ;
			int[] toId                = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new KiwiJuiceEasy().thePouring(capacities, bottles, fromId, toId));
		}*/
/*      case 7: {
			int[] capacities          = ;
			int[] bottles             = ;
			int[] fromId              = ;
			int[] toId                = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new KiwiJuiceEasy().thePouring(capacities, bottles, fromId, toId));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
