public class EllysPlaylists {
   public int countPlaylists(String[] songs, int K) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			EllysPlaylistsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				EllysPlaylistsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class EllysPlaylistsHarness {
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
			String[] songs            = { "abcxxx", "xxxabc", "entersandman", "toxicity", "maneater", "heavensalie",
  "liebe", "citylights", "fadetoblack", "breakingthehabit", "yyydefg", "defgyyy" };
			int K                     = 2;
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new EllysPlaylists().countPlaylists(songs, K));
		}
		case 1: {
			String[] songs            = { "aaaaaa", "aaabcd", "bcdaaa" };
			int K                     = 4;
			int expected__            = 13;

			return verifyCase(casenum__, expected__, new EllysPlaylists().countPlaylists(songs, K));
		}
		case 2: {
			String[] songs            = { "aaa", "aaaa", "aaaaa" };
			int K                     = 3;
			int expected__            = 27;

			return verifyCase(casenum__, expected__, new EllysPlaylists().countPlaylists(songs, K));
		}
		case 3: {
			String[] songs            = { "elly", "looks", "lovely" };
			int K                     = 1;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new EllysPlaylists().countPlaylists(songs, K));
		}
		case 4: {
			String[] songs            = { "life", "universe", "everything" };
			int K                     = 42;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new EllysPlaylists().countPlaylists(songs, K));
		}
		case 5: {
			String[] songs            = { "aaaaaaaaa", "aaabbbaaa", "aaacccaaa", "aaadddaaa", "aaaeeeaaa", "aaafffaaa" };
			int K                     = 12;
			int expected__            = 176782322;

			return verifyCase(casenum__, expected__, new EllysPlaylists().countPlaylists(songs, K));
		}

		// custom cases

/*      case 6: {
			String[] songs            = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new EllysPlaylists().countPlaylists(songs, K));
		}*/
/*      case 7: {
			String[] songs            = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new EllysPlaylists().countPlaylists(songs, K));
		}*/
/*      case 8: {
			String[] songs            = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new EllysPlaylists().countPlaylists(songs, K));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
