import java.util.*;
import java.util.regex.*;
import java.math.*;
import java.text.*;
import java.io.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;


public class PipeCuts {
   public double probability(int[] weldLocations, int L) {
       int N = weldLocations.length;
       int cnt=0, sum=0;

       sort(weldLocations);

       for(int i=0; i<N; i++) {
           for(int j=i+1; j<N; j++) {
               if(weldLocations[i] > L
                    || weldLocations[j]-weldLocations[i] > L
                    || 100 - weldLocations[j] > L)
                   cnt++;
               sum++;
           }
       }

       return (double)cnt/(double)sum;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			PipeCutsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				PipeCutsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class PipeCutsHarness {
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
			int[] weldLocations       = {25, 50, 75};
			int L                     = 25;
			double expected__         = 1.0;

			return verifyCase(casenum__, expected__, new PipeCuts().probability(weldLocations, L));
		}
		case 1: {
			int[] weldLocations       = {25, 50, 75};
			int L                     = 50;
			double expected__         = 0.0;

			return verifyCase(casenum__, expected__, new PipeCuts().probability(weldLocations, L));
		}
		case 2: {
			int[] weldLocations       = {25, 50, 75};
			int L                     = 24;
			double expected__         = 1.0;

			return verifyCase(casenum__, expected__, new PipeCuts().probability(weldLocations, L));
		}
		case 3: {
			int[] weldLocations       = {99, 88, 77, 66, 55, 44, 33, 22, 11};
			int L                     = 50;
			double expected__         = 0.7222222222222222;

			return verifyCase(casenum__, expected__, new PipeCuts().probability(weldLocations, L));
		}

		// custom cases

/*      case 4: {
			int[] weldLocations       = ;
			int L                     = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new PipeCuts().probability(weldLocations, L));
		}*/
/*      case 5: {
			int[] weldLocations       = ;
			int L                     = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new PipeCuts().probability(weldLocations, L));
		}*/
/*      case 6: {
			int[] weldLocations       = ;
			int L                     = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new PipeCuts().probability(weldLocations, L));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
