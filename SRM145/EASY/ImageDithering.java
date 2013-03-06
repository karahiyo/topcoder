public class ImageDithering {
   public int count(String dithered, String[] screen) {
       int cnt = 0;
       char[] D = new char[dithered.length()];
       for (int i=0;i<dithered.length();i++)
           D[i] = dithered.charAt(i);

       for(String e : screen) {
           int len = e.length();
           for(int i=0;i<len;i++) {
               for(char a : D) {
                   if(e.charAt(i) == a) {
                       cnt++;
                       continue;
                   }
               }
           }
       }
       return cnt;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ImageDitheringHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ImageDitheringHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ImageDitheringHarness {
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
			String dithered           = "BW";
			String[] screen           = {"AAAAAAAA",
 "ABWBWBWA",
 "AWBWBWBA",
 "ABWBWBWA",
 "AWBWBWBA",
 "AAAAAAAA"};
			int expected__            = 24;

			return verifyCase(casenum__, expected__, new ImageDithering().count(dithered, screen));
		}
		case 1: {
			String dithered           = "BW";
			String[] screen           = {"BBBBBBBB",
 "BBWBWBWB",
 "BWBWBWBB",
 "BBWBWBWB",
 "BWBWBWBB",
 "BBBBBBBB"};
			int expected__            = 48;

			return verifyCase(casenum__, expected__, new ImageDithering().count(dithered, screen));
		}
		case 2: {
			String dithered           = "ACEGIKMOQSUWY";
			String[] screen           = {"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"};
			int expected__            = 150;

			return verifyCase(casenum__, expected__, new ImageDithering().count(dithered, screen));
		}
		case 3: {
			String dithered           = "CA";
			String[] screen           = {"BBBBBBB",
 "BBBBBBB",
 "BBBBBBB"};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new ImageDithering().count(dithered, screen));
		}
		case 4: {
			String dithered           = "DCBA";
			String[] screen           = {"ACBD"};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new ImageDithering().count(dithered, screen));
		}

		// custom cases

/*      case 5: {
			String dithered           = ;
			String[] screen           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ImageDithering().count(dithered, screen));
		}*/
/*      case 6: {
			String dithered           = ;
			String[] screen           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ImageDithering().count(dithered, screen));
		}*/
/*      case 7: {
			String dithered           = ;
			String[] screen           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ImageDithering().count(dithered, screen));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
