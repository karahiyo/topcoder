public class SuperRot {
    char Rot(char b) {
        if(b>=48 && b<=57) return (char)((b-'0'+5)%10 + '0');
        if(b>=65 && b<=90) return (char)((b-'A'+13)%26 + 'A');
        if(b>=97 && b<=122) return (char)((b-'a'+13)%26 + 'a');
        return ' ';
    }

    public String decoder(String message) {
        char[] m = message.toCharArray();
        String rec = "";
        for(char b : m)
            rec += Rot(b);

        return rec;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			SuperRotHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SuperRotHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class SuperRotHarness {
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
			String message            = "Uryyb 28";
			String expected__         = "Hello 73";

			return verifyCase(casenum__, expected__, new SuperRot().decoder(message));
		}
		case 1: {
			String message            = "GbcPbqre";
			String expected__         = "TopCoder";

			return verifyCase(casenum__, expected__, new SuperRot().decoder(message));
		}
		case 2: {
			String message            = "";
			String expected__         = "";

			return verifyCase(casenum__, expected__, new SuperRot().decoder(message));
		}
		case 3: {
			String message            = "5678901234";
			String expected__         = "0123456789";

			return verifyCase(casenum__, expected__, new SuperRot().decoder(message));
		}
		case 4: {
			String message            = "NnOoPpQqRr AaBbCcDdEe";
			String expected__         = "AaBbCcDdEe NnOoPpQqRr";

			return verifyCase(casenum__, expected__, new SuperRot().decoder(message));
		}
		case 5: {
			String message            = "Gvzr vf 54 71 CZ ba Whyl 4gu bs gur lrne 7558 NQ";
			String expected__         = "Time is 09 26 PM on July 9th of the year 2003 AD";

			return verifyCase(casenum__, expected__, new SuperRot().decoder(message));
		}
		case 6: {
			String message            = "Gur dhvpx oebja sbk whzcf bire n ynml qbt";
			String expected__         = "The quick brown fox jumps over a lazy dog";

			return verifyCase(casenum__, expected__, new SuperRot().decoder(message));
		}

		// custom cases

/*      case 7: {
			String message            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SuperRot().decoder(message));
		}*/
/*      case 8: {
			String message            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SuperRot().decoder(message));
		}*/
/*      case 9: {
			String message            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SuperRot().decoder(message));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
