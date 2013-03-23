import java.util.*;

public class CrazyBot {
    boolean[][] grid = new boolean[100][100];
    int vx[] = {1, -1, 0, 0};
    int vy[] = {0, 0, 1, -1};

    double[] prob = new double[4];

    public double getProbability(int n, int east, int west, int south, int north) {
        prob[0] = east / 100.0;
        prob[1] = west / 100.0;
        prob[2] = south / 100.0;
        prob[3] = north / 100.0;
        return solve(50, 50, n);
    }

    double solve(int x,  int y, int n) {
        if(grid[x][y]) return 0;
        if(n==0) return 1;
        grid[x][y] = true;
        double rec = 0;
        for(int i=0;i<4;i++) {
            rec += solve(x+vx[i], y+vy[i], n-1) * prob[i];
        }
        grid[x][y] = false;
        return rec;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			CrazyBotHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				CrazyBotHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class CrazyBotHarness {
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

	static final double MAX_DOUBLE_ERROR = 1E-9;
	static boolean compareOutput(double expected, double result){ if(Double.isNaN(expected)){ return Double.isNaN(result); }else if(Double.isInfinite(expected)){ if(expected > 0){ return result > 0 && Double.isInfinite(result); }else{ return result < 0 && Double.isInfinite(result); } }else if(Double.isNaN(result) || Double.isInfinite(result)){ return false; }else if(Math.abs(result - expected) < MAX_DOUBLE_ERROR){ return true; }else{ double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); return result > min && result < max; } }
	static double relativeError(double expected, double result) { if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result) || expected == 0) return 0; return Math.abs(result-expected) / Math.abs(expected); }

	static String formatResult(double res) {
		return String.format("%.10g", res);
	}

	static int verifyCase(int casenum, double expected, double received) {
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.print("PASSED");
			double rerr = relativeError(expected, received);
			if (rerr > 0) System.err.printf(" (relative error %g)", rerr);
			System.err.println();
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
			int n                     = 1;
			int east                  = 25;
			int west                  = 25;
			int south                 = 25;
			int north                 = 25;
			double expected__         = 1.0;

			return verifyCase(casenum__, expected__, new CrazyBot().getProbability(n, east, west, south, north));
		}
		case 1: {
			int n                     = 2;
			int east                  = 25;
			int west                  = 25;
			int south                 = 25;
			int north                 = 25;
			double expected__         = 0.75;

			return verifyCase(casenum__, expected__, new CrazyBot().getProbability(n, east, west, south, north));
		}
		case 2: {
			int n                     = 7;
			int east                  = 50;
			int west                  = 0;
			int south                 = 0;
			int north                 = 50;
			double expected__         = 1.0;

			return verifyCase(casenum__, expected__, new CrazyBot().getProbability(n, east, west, south, north));
		}
		case 3: {
			int n                     = 14;
			int east                  = 50;
			int west                  = 50;
			int south                 = 0;
			int north                 = 0;
			double expected__         = 1.220703125E-4;

			return verifyCase(casenum__, expected__, new CrazyBot().getProbability(n, east, west, south, north));
		}
		case 4: {
			int n                     = 14;
			int east                  = 25;
			int west                  = 25;
			int south                 = 25;
			int north                 = 25;
			double expected__         = 0.008845493197441101;

			return verifyCase(casenum__, expected__, new CrazyBot().getProbability(n, east, west, south, north));
		}

		// custom cases

/*      case 5: {
			int n                     = ;
			int east                  = ;
			int west                  = ;
			int south                 = ;
			int north                 = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new CrazyBot().getProbability(n, east, west, south, north));
		}*/
/*      case 6: {
			int n                     = ;
			int east                  = ;
			int west                  = ;
			int south                 = ;
			int north                 = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new CrazyBot().getProbability(n, east, west, south, north));
		}*/
/*      case 7: {
			int n                     = ;
			int east                  = ;
			int west                  = ;
			int south                 = ;
			int north                 = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new CrazyBot().getProbability(n, east, west, south, north));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
