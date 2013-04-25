public class GuessTheNumber {
   public int noGuesses(int upper, int answer) {
       int ret = 0;
       int lower = 1;

       while(true) {
           int guess = (upper+lower)/2;
           ret++;
           if(guess == answer)
               return ret;
           if(guess > answer)
               upper = guess - 1;
           else
               lower = guess + 1;
       }
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			GuessTheNumberHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				GuessTheNumberHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class GuessTheNumberHarness {
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
			int upper                 = 9;
			int answer                = 6;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new GuessTheNumber().noGuesses(upper, answer));
		}
		case 1: {
			int upper                 = 1000;
			int answer                = 750;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new GuessTheNumber().noGuesses(upper, answer));
		}
		case 2: {
			int upper                 = 643;
			int answer                = 327;
			int expected__            = 7;

			return verifyCase(casenum__, expected__, new GuessTheNumber().noGuesses(upper, answer));
		}
		case 3: {
			int upper                 = 157;
			int answer                = 157;
			int expected__            = 8;

			return verifyCase(casenum__, expected__, new GuessTheNumber().noGuesses(upper, answer));
		}
		case 4: {
			int upper                 = 128;
			int answer                = 64;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new GuessTheNumber().noGuesses(upper, answer));
		}

		// custom cases

/*      case 5: {
			int upper                 = ;
			int answer                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new GuessTheNumber().noGuesses(upper, answer));
		}*/
/*      case 6: {
			int upper                 = ;
			int answer                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new GuessTheNumber().noGuesses(upper, answer));
		}*/
/*      case 7: {
			int upper                 = ;
			int answer                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new GuessTheNumber().noGuesses(upper, answer));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
