public class CeyKaps {
   public String decipher(String typed, String[] switches) {
       char[] rec = typed.toCharArray();
       char p;
       char q;

       for(int i=0; i<switches.length; i++) {
           p = switches[i].charAt(0);
           q = switches[i].charAt(2);
           for(int j=0;j<rec.length;j++) {
               if(rec[j] == p)
                   rec[j] = q;
               else if(rec[j] == q)
                   rec[j] = p;
               else
                   continue;
           }
       }
       return String.valueOf(rec);
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			CeyKapsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				CeyKapsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class CeyKapsHarness {
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
			String typed              = "AAAAA";
			String[] switches         = {"A:B","B:C","A:D"};
			String expected__         = "CCCCC";

			return verifyCase(casenum__, expected__, new CeyKaps().decipher(typed, switches));
		}
		case 1: {
			String typed              = "ABCDE";
			String[] switches         = {"A:B","B:C","C:D","D:E","E:A"};
			String expected__         = "AEBCD";

			return verifyCase(casenum__, expected__, new CeyKaps().decipher(typed, switches));
		}
		case 2: {
			String typed              = "IHWSIOTCHEDMYKEYCAPSARWUND";
			String[] switches         = {"W:O","W:I"};
			String expected__         = "WHOSWITCHEDMYKEYCAPSAROUND";

			return verifyCase(casenum__, expected__, new CeyKaps().decipher(typed, switches));
		}

		// custom cases

/*      case 3: {
			String typed              = ;
			String[] switches         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new CeyKaps().decipher(typed, switches));
		}*/
/*      case 4: {
			String typed              = ;
			String[] switches         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new CeyKaps().decipher(typed, switches));
		}*/
/*      case 5: {
			String typed              = ;
			String[] switches         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new CeyKaps().decipher(typed, switches));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
