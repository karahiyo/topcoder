// SRM428 EASY
public class ThePalindrome {
   public int find(String s) {
       int ret = -1;
       for(int i=0;i<s.length()-1;i++) {
           char tail = s.charAt(s.length()-1);
           char head = s.charAt(i);
           if(head != tail) continue;
           for(int j=i+1;j<s.length();j++) {
               tail = s.charAt(s.length() - j + i);
               head = s.charAt(j);
               if(tail == head) 
                   continue;
               else
                   break;
           }
           ret = i;
           break;
       }
       if(ret == -1)
           return s.length()*2 -1;
       else
           return s.length() + ret;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ThePalindromeHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ThePalindromeHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ThePalindromeHarness {
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
			String s                  = "abab";
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new ThePalindrome().find(s));
		}
		case 1: {
			String s                  = "abacaba";
			int expected__            = 7;

			return verifyCase(casenum__, expected__, new ThePalindrome().find(s));
		}
		case 2: {
			String s                  = "qwerty";
			int expected__            = 11;

			return verifyCase(casenum__, expected__, new ThePalindrome().find(s));
		}
		case 3: {
			String s                  = "abdfhdyrbdbsdfghjkllkjhgfds";
			int expected__            = 38;

			return verifyCase(casenum__, expected__, new ThePalindrome().find(s));
		}

		// custom cases

/*      case 4: {
			String s                  = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ThePalindrome().find(s));
		}*/
/*      case 5: {
			String s                  = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ThePalindrome().find(s));
		}*/
/*      case 6: {
			String s                  = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ThePalindrome().find(s));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
