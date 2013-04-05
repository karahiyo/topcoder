import java.util.*;
import java.util.regex.*;
import java.math.*;
import java.text.*;
import java.io.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.lang.System.*;

public class ContestScore {
    public int[] ranking(double[] col_points) {
        int[] ret = new int[col_points.length];
        for(int i=0;i<col_points.length;i++){
            double score = col_points[i];
            int count = 1;
            for(int j=0; j<col_points.length;j++) {
                if(score < col_points[j]) {
                    count++;
                }
            }
            ret[i] = count;
        }
        return ret;
    }

    public String[] sortResults(String[] data) {
        if(data.length == 0) return new String[]{};
        int[] team_rank = new int[data.length];
        double[] team_points = new double[data.length];
        int game_num = data[0].split(" ").length-1;
        int man_num = data.length;
        for(int i=1;i<=game_num;i++) {
            double[] col_point = new double[man_num];
            for(int j=0;j<man_num;j++) {
                col_point[j] = Double.parseDouble(((data[j].split(" "))[i]));
            }
            for(int j=0;j<man_num;j++) {
                team_rank[j] += (ranking(col_point))[j];
                BigDecimal a = new BigDecimal(col_point[j]);
                team_points[j] += a.doubleValue();
            }
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Double> score_map = new HashMap<String, Double>();
        for(int i=0;i<data.length;i++) {
            map.put((data[i].split(" "))[0], team_rank[i]);
            score_map.put((data[i].split(" "))[0], team_points[i]);
        }
        String[] rec = new String[map.size()];

        List<Map.Entry> entries = new ArrayList<Map.Entry>(map.entrySet());
        Collections.sort(entries, new Comparator() {
            public int compare(Object o1, Object o2) {
                Map.Entry e1 = (Map.Entry)o1;
                Map.Entry e2 = (Map.Entry)o2;
                return ((Integer)e1.getValue()).compareTo((Integer)e2.getValue());
            }
        });
        int i = 0;
        for(Map.Entry entry : entries) {
            BigDecimal a = new BigDecimal(score_map.get(entry.getKey()));
            rec[i] = (entry.getKey()+" "+entry.getValue()+" "+a.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            i++;
        }

        return rec;

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ContestScoreHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ContestScoreHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ContestScoreHarness {
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
			String[] data             = {"A 90.7 92.9 87.4",
 "B 90.5 96.6 88.0",
 "C 92.2 91.0 95.3"};
			String[] expected__       = { "C 5 278.5",  "B 6 275.1",  "A 7 271.0" };

			return verifyCase(casenum__, expected__, new ContestScore().sortResults(data));
		}
		case 1: {
			String[] data             = {"STANFORD 85.3 90.1 82.6 84.6 96.6 94.5 87.3 90.3",
 "MIT 95.5 83.9 80.4 85.5 98.7 98.3 96.7 82.7",
 "PRINCETON 99.2 79.1 87.6 85.1 93.6 96.4 86.0 90.6",
 "HARVARD 83.6 92.0 85.5 94.3 97.5 91.5 92.5 83.0",
 "YALE 99.5 92.6 86.2 82.0 96.4 92.6 84.5 78.6",
 "COLUMBIA 97.2 87.6 81.7 93.7 88.0 86.3 95.9 89.6",
 "BROWN 92.2 95.8 92.1 81.5 89.5 87.0 95.5 86.4",
 "PENN 96.3 80.7 81.2 91.6 85.8 92.2 83.9 87.8",
 "CORNELL 88.0 83.7 85.0 83.8 99.8 92.1 91.0 88.9"};
			String[] expected__       = { "PRINCETON 34 717.6",  "MIT 36 721.7",  "HARVARD 38 719.9",  "COLUMBIA 39 720.0",  "STANFORD 39 711.3",  "YALE 40 712.4",  "BROWN 41 720.0",  "CORNELL 42 712.3",  "PENN 51 699.5" };

			return verifyCase(casenum__, expected__, new ContestScore().sortResults(data));
		}
		case 2: {
			String[] data             = {};
			String[] expected__       = { };

			return verifyCase(casenum__, expected__, new ContestScore().sortResults(data));
		}
		case 3: {
			String[] data             = {"AA 90.0 80.0 70.0 60.0 50.0 40.0",
 "BBB 80.0 70.0 60.0 50.0 40.0 90.0",
 "EEE 70.0 60.0 50.0 40.0 90.0 80.0",
 "AAA 60.0 50.0 40.0 90.0 80.0 70.0",
 "DDD 50.0 40.0 90.0 80.0 70.0 60.0",
 "CCC 40.0 90.0 80.0 70.0 60.0 50.0"};
			String[] expected__       = { "AA 21 390.0",  "AAA 21 390.0",  "BBB 21 390.0",  "CCC 21 390.0",  "DDD 21 390.0",  "EEE 21 390.0" };

			return verifyCase(casenum__, expected__, new ContestScore().sortResults(data));
		}
		case 4: {
			String[] data             = {"A 00.1", "B 05.2", "C 29.0","D 00.0"};
			String[] expected__       = { "C 1 29.0",  "B 2 5.2",  "A 3 0.1",  "D 4 0.0" };

			return verifyCase(casenum__, expected__, new ContestScore().sortResults(data));
		}

		// custom cases

/*      case 5: {
			String[] data             = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new ContestScore().sortResults(data));
		}*/
/*      case 6: {
			String[] data             = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new ContestScore().sortResults(data));
		}*/
/*      case 7: {
			String[] data             = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new ContestScore().sortResults(data));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
