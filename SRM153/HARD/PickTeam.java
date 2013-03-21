import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickTeam {
   public String[] pickPeople(int teamSize, String[] people) {
       int n = people.length;
       String[] names = new String[n];
       int[][] g = new int[n][n];
       String[] sp;
       for (int i=0;i<n;i++) {
           sp = people[i].split(" ");
           names[i] = sp[0];
           for (int j=0;j<n;j++)
               g[i][j] = Integer.parseInt(sp[j+1]);
       }

       boolean[] used, best = new boolean[n];
       int max = Integer.MIN_VALUE;

       for (int mask=0;mask < 1<<n; mask++) {
           if(Integer.bitCount(mask) != teamSize)
               continue;

           int res = 0;
           used = new boolean[n];
           for (int j=0;j<n;j++)
               if((mask&(1<<j)) > 0) used[j] = true;
           for (int i=0;i<n;i++) {
               if(!used[i])
                   continue;
               for (int j=0;j<n;j++) {
                   if(!used[j])
                       continue;
                   res += g[i][j];
               }
           }
           if (res > max) {
               max = res;
               best = used.clone();
           }
       }
       List<String> list = new ArrayList<String>();
       for (int i=0; i<n; i++)
           if (best[i])
               list.add(names[i]);
       Collections.sort(list);
       return list.toArray(new String[0]);
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			PickTeamHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				PickTeamHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class PickTeamHarness {
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

	static boolean compareOutput(String[] expected, String[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (!expected[i].equals(result[i])) return false; return true; }

	static String formatResult(String[] res) {
		String ret = "";
		ret += "{";
		for (int i=0; i<res.length; ++i) {
			if (i > 0) ret += ",";
			ret += String.format(" \"%s\"", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, String[] expected, String[] received) {
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
			int teamSize              = 3;
			String[] people           = {"ALICE 0 1 -1 3",
 "BOB 1 0 2 -4",
 "CAROL -1 2 0 2",
 "DAVID 3 -4 2 0"};
			String[] expected__       = { "ALICE",  "CAROL",  "DAVID" };

			return verifyCase(casenum__, expected__, new PickTeam().pickPeople(teamSize, people));
		}
		case 1: {
			int teamSize              = 2;
			String[] people           = {"ALICE 0 1 -1 3",
 "BOB 1 0 2 -4",
 "CAROL -1 2 0 2",
 "DAVID 3 -4 2 0"};
			String[] expected__       = { "ALICE",  "DAVID" };

			return verifyCase(casenum__, expected__, new PickTeam().pickPeople(teamSize, people));
		}
		case 2: {
			int teamSize              = 2;
			String[] people           = {"A 0 -2 -2","B -2 0 -1","C -2 -1 0"};
			String[] expected__       = { "B",  "C" };

			return verifyCase(casenum__, expected__, new PickTeam().pickPeople(teamSize, people));
		}
		case 3: {
			int teamSize              = 13;
			String[] people           = {"A 0 2 8 7 1 -4 -3 1 8 2 8 2 1 -3 7 1 3 9 -6 -5",
 "A 2 0 0 7 -7 -5 8 -8 -9 -9 6 -9 -4 -8 8 1 7 0 3 3",
 "A 8 0 0 -5 -5 -7 1 -3 1 9 -6 6 1 5 6 -9 8 6 -8 -8",
 "A 7 7 -5 0 7 -5 3 9 8 3 -6 -5 -5 2 -6 2 -2 -1 -2 8",
 "B 1 -7 -5 7 0 7 -2 -9 3 7 0 -2 1 1 -9 -3 -2 2 1 -2",
 "B -4 -5 -7 -5 7 0 4 8 6 0 -1 4 1 -2 -9 4 0 -7 6 -2",
 "B -3 8 1 3 -2 4 0 8 -1 1 -2 -7 5 0 -6 9 0 -3 1 3",
 "B 1 -8 -3 9 -9 8 8 0 0 -2 5 0 5 8 3 5 2 4 5 4",
 "C 8 -9 1 8 3 6 -1 0 0 8 -3 8 -6 -4 7 -4 1 -5 5 4",
 "C 2 -9 9 3 7 0 1 -2 8 0 -9 -6 6 5 -8 -3 -8 2 2 4",
 "C 8 6 -6 -6 0 -1 -2 5 -3 -9 0 2 7 8 2 -6 -4 -6 4 4",
 "C 2 -9 6 -5 -2 4 -7 0 8 -6 2 0 0 -3 6 7 -1 2 -4 -2",
 "D 1 -4 1 -5 1 1 5 5 -6 6 7 0 0 -7 -4 8 -6 -3 4 -6",
 "D -3 -8 5 2 1 -2 0 8 -4 5 8 -3 -7 0 7 -3 5 -8 5 1",
 "D 7 8 6 -6 -9 -9 -6 3 7 -8 2 6 -4 7 0 9 -5 -5 -8 3",
 "D 1 1 -9 2 -3 4 9 5 -4 -3 -6 7 8 -3 9 0 -2 -7 8 -7",
 "E 3 7 8 -2 -2 0 0 2 1 -8 -4 -1 -6 5 -5 -2 0 6 0 5",
 "E 9 0 6 -1 2 -7 -3 4 -5 2 -6 2 -3 -8 -5 -7 6 0 4 8",
 "E -6 3 -8 -2 1 6 1 5 5 2 4 -4 4 5 -8 8 0 4 0 1",
 "E -5 3 -8 8 -2 -2 3 4 4 4 4 -2 -6 1 3 -7 5 8 1 0"};
			String[] expected__       = { "A",  "A",  "B",  "B",  "B",  "B",  "C",  "C",  "C",  "D",  "D",  "D",  "E" };

			return verifyCase(casenum__, expected__, new PickTeam().pickPeople(teamSize, people));
		}

		// custom cases

/*      case 4: {
			int teamSize              = ;
			String[] people           = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new PickTeam().pickPeople(teamSize, people));
		}*/
/*      case 5: {
			int teamSize              = ;
			String[] people           = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new PickTeam().pickPeople(teamSize, people));
		}*/
/*      case 6: {
			int teamSize              = ;
			String[] people           = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new PickTeam().pickPeople(teamSize, people));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
