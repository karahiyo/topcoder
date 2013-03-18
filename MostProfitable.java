public class MostProfitable {
   public String bestItem(int[] costs, int[] prices, int[] sales, String[] items) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			MostProfitableHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				MostProfitableHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class MostProfitableHarness {
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
			int[] costs               = {100,120,150,1000};
			int[] prices              = {110,110,200,2000};
			int[] sales               = {20,100,50,3};
			String[] items            = {"Video Card","256M Mem","CPU/Mobo combo","Complete machine"};
			String expected__         = "Complete machine";

			return verifyCase(casenum__, expected__, new MostProfitable().bestItem(costs, prices, sales, items));
		}
		case 1: {
			int[] costs               = {100};
			int[] prices              = {100};
			int[] sales               = {134};
			String[] items            = {"Service, at cost"};
			String expected__         = "";

			return verifyCase(casenum__, expected__, new MostProfitable().bestItem(costs, prices, sales, items));
		}
		case 2: {
			int[] costs               = {38,24};
			int[] prices              = {37,23};
			int[] sales               = {1000,643};
			String[] items            = {"Letter","Postcard"};
			String expected__         = "";

			return verifyCase(casenum__, expected__, new MostProfitable().bestItem(costs, prices, sales, items));
		}
		case 3: {
			int[] costs               = {10,10};
			int[] prices              = {11,12};
			int[] sales               = {2,1};
			String[] items            = {"A","B"};
			String expected__         = "A";

			return verifyCase(casenum__, expected__, new MostProfitable().bestItem(costs, prices, sales, items));
		}

		// custom cases

/*      case 4: {
			int[] costs               = ;
			int[] prices              = ;
			int[] sales               = ;
			String[] items            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new MostProfitable().bestItem(costs, prices, sales, items));
		}*/
/*      case 5: {
			int[] costs               = ;
			int[] prices              = ;
			int[] sales               = ;
			String[] items            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new MostProfitable().bestItem(costs, prices, sales, items));
		}*/
/*      case 6: {
			int[] costs               = ;
			int[] prices              = ;
			int[] sales               = ;
			String[] items            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new MostProfitable().bestItem(costs, prices, sales, items));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
