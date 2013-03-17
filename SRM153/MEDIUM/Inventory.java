import java.lang.Math;

public class Inventory {
   public int monthlyOrder(int[] sales, int[] daysAvailable) {
       double rec = 0;
       int x = 0;
       for (int i=0;i<sales.length;i++) {
           if (sales[i] == 0 || daysAvailable[i] == 0)
               continue;
           rec += sales[i]*30.0/(double)daysAvailable[i];
           x++;
       }
       return (int)Math.ceil((rec - 1e-9)/x);

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			InventoryHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				InventoryHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class InventoryHarness {
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
			int[] sales               = {5};
			int[] daysAvailable       = {15};
			int expected__            = 10;

			return verifyCase(casenum__, expected__, new Inventory().monthlyOrder(sales, daysAvailable));
		}
		case 1: {
			int[] sales               = {75,120,0,93};
			int[] daysAvailable       = {24,30,0,30};
			int expected__            = 103;

			return verifyCase(casenum__, expected__, new Inventory().monthlyOrder(sales, daysAvailable));
		}
		case 2: {
			int[] sales               = {8773};
			int[] daysAvailable       = {16};
			int expected__            = 16450;

			return verifyCase(casenum__, expected__, new Inventory().monthlyOrder(sales, daysAvailable));
		}
		case 3: {
			int[] sales               = {1115,7264,3206,6868,7301} ;
			int[] daysAvailable       = {1,3,9,4,18};
			int expected__            = 36091;

			return verifyCase(casenum__, expected__, new Inventory().monthlyOrder(sales, daysAvailable));
		}

		// custom cases

/*      case 4: {
			int[] sales               = ;
			int[] daysAvailable       = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Inventory().monthlyOrder(sales, daysAvailable));
		}*/
/*      case 5: {
			int[] sales               = ;
			int[] daysAvailable       = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Inventory().monthlyOrder(sales, daysAvailable));
		}*/
/*      case 6: {
			int[] sales               = ;
			int[] daysAvailable       = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Inventory().monthlyOrder(sales, daysAvailable));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
