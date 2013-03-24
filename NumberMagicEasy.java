import java.util.*;

public class NumberMagicEasy {
   public int theNumber(String answer) {
       int card[][] = {{1, 2, 3, 4, 5, 6, 7, 8},
                       {1, 2, 3, 4, 9, 10, 11, 12},
                       {1, 2, 5, 6, 9, 10, 13, 14},
                       {1, 3, 5, 7, 9, 11, 13, 15}};

       HashMap<Integer, Integer> ans = new HashMap<Integer, Integer>();
       for(int i=1; i <= 16; i++) {
           ans.put(i, 0);
       }

       int ynum = 0;
       for(int i=0;i<answer.length();i++) {
           if(answer.charAt(i) == 'N') {
               for(int j=0;j<card[i].length;j++) {
                   ans.remove(card[i][j]);
               }
           } else {
               for(int j=0;j<card[i].length;j++){
                   if(ans.containsKey(card[i][j])) {
                       ans.put(card[i][j], ans.get(card[i][j])+1);
                   }
               }
               ynum++;
           }
       }
       int rec = 0;
       for(int k : ans.keySet()) {
           if(ans.get(k)==ynum) {
               rec = k;
               break;
           }
       }
       return rec;

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			NumberMagicEasyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				NumberMagicEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class NumberMagicEasyHarness {
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
			String answer             = "YNYY";
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
		}
		case 1: {
			String answer             = "YNNN";
			int expected__            = 8;

			return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
		}
		case 2: {
			String answer             = "NNNN";
			int expected__            = 16;

			return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
		}
		case 3: {
			String answer             = "YYYY";
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
		}
		case 4: {
			String answer             = "NYNY";
			int expected__            = 11;

			return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
		}

		// custom cases

/*      case 5: {
			String answer             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
		}*/
/*      case 6: {
			String answer             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
		}*/
/*      case 7: {
			String answer             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new NumberMagicEasy().theNumber(answer));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
