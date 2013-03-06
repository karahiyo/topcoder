public class BrickByBrick {
   public int timeToClear(String[] map) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			BrickByBrickHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				BrickByBrickHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class BrickByBrickHarness {
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
			String[] map              = { ".B",
  "BB" };
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new BrickByBrick().timeToClear(map));
		}
		case 1: {
			String[] map              = { ".BB",
  "BBB",
  "BBB" };
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new BrickByBrick().timeToClear(map));
		}
		case 2: {
			String[] map              = { "......B",
  "###.###",
  "B.....B" };
			int expected__            = 35;

			return verifyCase(casenum__, expected__, new BrickByBrick().timeToClear(map));
		}
		case 3: {
			String[] map              = { "..BBB...",
  ".#BB..#.",
  "B.#B.B..",
  "B.B.....",
  "##.B.B#.",
  "#BB.#.B.",
  "B..B.BB.",
  "#..BB..B",
  ".B....#." };
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new BrickByBrick().timeToClear(map));
		}
		case 4: {
			String[] map              = { ".BB..BBB.B...",
  "B.B...B..BB..",
  "#B...B#B.....",
  "B#B.B##...##B",
  "BB.B#.B##B.B#",
  "B.B#.BBB.BB#B",
  "B#BBB##.#B#B.",
  "B#BB.BBB#BB.#" };
			int expected__            = 3912;

			return verifyCase(casenum__, expected__, new BrickByBrick().timeToClear(map));
		}
		case 5: {
			String[] map              = { ".BBBBBBBBBBBBBB",
  "##############B",
  "BBBBBBBBBBBBBBB",
  "B##############",
  "BBBBBBBBBBBBBBB",
  "##############B",
  "BBBBBBBBBBBBBBB",
  "B##############",
  "BBBBBBBBBBBBBBB",
  "##############B",
  "BBBBBBBBBBBBBBB",
  "B##############",
  "BBBBBBBBBBBBBBB",
  "##############B",
  "BBBBBBBBBBBBBBB" };
			int expected__            = 31753;

			return verifyCase(casenum__, expected__, new BrickByBrick().timeToClear(map));
		}

		// custom cases

/*      case 6: {
			String[] map              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BrickByBrick().timeToClear(map));
		}*/
/*      case 7: {
			String[] map              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BrickByBrick().timeToClear(map));
		}*/
/*      case 8: {
			String[] map              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BrickByBrick().timeToClear(map));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
