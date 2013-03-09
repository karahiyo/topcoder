public class CCipher {
   public String decode(String cipherText, int shift) {
       char[] CT = cipherText.toCharArray();
       String ans="";
       for(int W: CT) {
           W = W - shift;
           if (W<'A')
               W += 26;
           ans += (char)W;
       }

       return ans;

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			CCipherHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				CCipherHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class CCipherHarness {
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
			String cipherText         = "VQREQFGT";
			int shift                 = 2;
			String expected__         = "TOPCODER";

			return verifyCase(casenum__, expected__, new CCipher().decode(cipherText, shift));
		}
		case 1: {
			String cipherText         = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			int shift                 = 10;
			String expected__         = "QRSTUVWXYZABCDEFGHIJKLMNOP";

			return verifyCase(casenum__, expected__, new CCipher().decode(cipherText, shift));
		}
		case 2: {
			String cipherText         = "TOPCODER";
			int shift                 = 0;
			String expected__         = "TOPCODER";

			return verifyCase(casenum__, expected__, new CCipher().decode(cipherText, shift));
		}
		case 3: {
			String cipherText         = "ZWBGLZ";
			int shift                 = 25;
			String expected__         = "AXCHMA";

			return verifyCase(casenum__, expected__, new CCipher().decode(cipherText, shift));
		}
		case 4: {
			String cipherText         = "DBNPCBQ";
			int shift                 = 1;
			String expected__         = "CAMOBAP";

			return verifyCase(casenum__, expected__, new CCipher().decode(cipherText, shift));
		}
		case 5: {
			String cipherText         = "LIPPSASVPH";
			int shift                 = 4;
			String expected__         = "HELLOWORLD";

			return verifyCase(casenum__, expected__, new CCipher().decode(cipherText, shift));
		}

		// custom cases

/*      case 6: {
			String cipherText         = ;
			int shift                 = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new CCipher().decode(cipherText, shift));
		}*/
/*      case 7: {
			String cipherText         = ;
			int shift                 = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new CCipher().decode(cipherText, shift));
		}*/
/*      case 8: {
			String cipherText         = ;
			int shift                 = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new CCipher().decode(cipherText, shift));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
