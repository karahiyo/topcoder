import java.lang.*;
import java.util.ArrayList;

public class RectangularGrid {
   public long countRectangles(int width, int height) {
       class fig {
           int width;
           int height;
           fig(int a,  int b) {
               this.width = a;
               this.height = b;
           }
       }

       ArrayList<fig> figs = new ArrayList<fig>();
       for(int i=1; i<=width;i++) {
           for(int j=1; j<=height;j++) {
               if(i!=j) {
                   fig F = new fig(i, j);
                   figs.add(F);
               }
           }
       }

       long sum = 0;
       int len = figs.size();
       for(fig n : figs) {
           sum += (width+1 - n.width) * (height+1 - n.height);
       }
       return sum;
   }

// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			RectangularGridHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				RectangularGridHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class RectangularGridHarness {
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

	static boolean compareOutput(long expected, long result) { return expected == result; }
	static String formatResult(long res) {
		return String.format("%d", res);
	}

	static int verifyCase(int casenum, long expected, long received) {
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
			int width                 = 3;
			int height                = 3;
			long expected__           = 22;

			return verifyCase(casenum__, expected__, new RectangularGrid().countRectangles(width, height));
		}
		case 1: {
			int width                 = 5;
			int height                = 2;
			long expected__           = 31;

			return verifyCase(casenum__, expected__, new RectangularGrid().countRectangles(width, height));
		}
		case 2: {
			int width                 = 10;
			int height                = 10;
			long expected__           = 2640;

			return verifyCase(casenum__, expected__, new RectangularGrid().countRectangles(width, height));
		}
		case 3: {
			int width                 = 1;
			int height                = 1;
			long expected__           = 0;

			return verifyCase(casenum__, expected__, new RectangularGrid().countRectangles(width, height));
		}
		case 4: {
			int width                 = 592;
			int height                = 964;
			long expected__           = 81508708664L;

			return verifyCase(casenum__, expected__, new RectangularGrid().countRectangles(width, height));
		}

		// custom cases

/*      case 5: {
			int width                 = ;
			int height                = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new RectangularGrid().countRectangles(width, height));
		}*/
/*      case 6: {
			int width                 = ;
			int height                = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new RectangularGrid().countRectangles(width, height));
		}*/
/*      case 7: {
			int width                 = ;
			int height                = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new RectangularGrid().countRectangles(width, height));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
