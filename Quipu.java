public class Quipu {
   public int readKnots(String knots) {
       String rec = "";
       int count = 0;
       boolean zero = false;
       for(int i=0;i<knots.length();i++) {
           if(knots.charAt(i) == 'X') {
               count++;
               zero = false;
           } else if(!zero){
               rec += String.valueOf(count);
               zero = true;
               count = 0;
           } else {
               rec += "0";
               zero = false;
           }
       }
       return Integer.parseInt(rec);


   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			QuipuHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				QuipuHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class QuipuHarness {
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
			String knots              = "-XX-XXXX-XXX-";
			int expected__            = 243;

			return verifyCase(casenum__, expected__, new Quipu().readKnots(knots));
		}
		case 1: {
			String knots              = "-XX--XXXX---XXX-";
			int expected__            = 204003;

			return verifyCase(casenum__, expected__, new Quipu().readKnots(knots));
		}
		case 2: {
			String knots              = "-X-";
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new Quipu().readKnots(knots));
		}
		case 3: {
			String knots              = "-X-------";
			int expected__            = 1000000;

			return verifyCase(casenum__, expected__, new Quipu().readKnots(knots));
		}
		case 4: {
			String knots              = "-XXXXXXXXX--XXXXXXXXX-XXXXXXXXX-XXXXXXX-XXXXXXXXX-";
			int expected__            = 909979;

			return verifyCase(casenum__, expected__, new Quipu().readKnots(knots));
		}

		// custom cases

/*      case 5: {
			String knots              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Quipu().readKnots(knots));
		}*/
/*      case 6: {
			String knots              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Quipu().readKnots(knots));
		}*/
/*      case 7: {
			String knots              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Quipu().readKnots(knots));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
