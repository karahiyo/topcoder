import java.util.*;
import java.lang.*;

public class TheNumberGameDiv2 {
   public int minimumMoves(int A, int B) {
       Queue<String> q = new LinkedList<String>();
       Queue<Integer> qnum = new LinkedList<Integer>();
       HashSet<String> seen = new HashSet<String>();
       String strA = String.valueOf(A);
       String strB = String.valueOf(B);
       q.add(strA);
       seen.add(strA);
       qnum.add(0);
       while(!q.isEmpty()) {
           String str = q.poll();
           int num = qnum.poll();
           if(str.length() < strB.length())
               continue;
           if(str.equals(strB))
               return num;
           String reversed = ((new StringBuffer(str)).reverse()).toString();
           if(!seen.contains(reversed)) {
               q.add(reversed);
               seen.add(reversed);
               qnum.add(num+1);
           }
           String dived = str.substring(0, str.length()-1);
           if(!seen.contains(dived)) {
               q.add(dived);
               seen.add(dived);
               qnum.add(num+1);
           }
       }
       return -1;

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			TheNumberGameDiv2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				TheNumberGameDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class TheNumberGameDiv2Harness {
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
			int A                     = 25;
			int B                     = 5;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
		}
		case 1: {
			int A                     = 5162;
			int B                     = 16;
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
		}
		case 2: {
			int A                     = 334;
			int B                     = 12;
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
		}
		case 3: {
			int A                     = 218181918;
			int B                     = 9181;
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
		}
		case 4: {
			int A                     = 9798147;
			int B                     = 79817;
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
		}

		// custom cases

/*      case 5: {
			int A                     = ;
			int B                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
		}*/
/*      case 6: {
			int A                     = ;
			int B                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
		}*/
/*      case 7: {
			int A                     = ;
			int B                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
