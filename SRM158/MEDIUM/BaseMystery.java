import java.util.regex.*;
import java.util.*;

public class BaseMystery {
    boolean valid(String[] parts, int n) {
        try{
            return Integer.valueOf(parts[2], n) == Integer.valueOf(parts[0], n) + Integer.valueOf(parts[1], n);
        } catch(Exception e) {
            return false;
        }
    }

    int[] toIntegerList(List<Integer> list) {
        int[] ret = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    
    public int[] getBase(String equation) {
        String[] parts = equation.split("[=+]");
        List<Integer> ret = new ArrayList<Integer>();

        for(int n=2; n<=20; n++) {
            if(valid(parts, n))
                ret.add(n);
        }

        return toIntegerList(ret);
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            BaseMysteryHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                BaseMysteryHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class BaseMysteryHarness {
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

    static boolean compareOutput(int[] expected, int[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (expected[i] != result[i]) return false; return true; }

    static String formatResult(int[] res) {
        String ret = "";
        ret += "{";
        for (int i=0; i<res.length; ++i) {
            if (i > 0) ret += ",";
            ret += String.format(" %d", res[i]);
        }
        ret += " }";
        return ret;
    }

    static int verifyCase(int casenum, int[] expected, int[] received) { 
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
                        String equation           = "1+1=2";
                        int[] expected__          = { 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

                        return verifyCase(casenum__, expected__, new BaseMystery().getBase(equation));
            }
            case 1: {
                        String equation           = "1+1=10";
                        int[] expected__          = { 2 };

                        return verifyCase(casenum__, expected__, new BaseMystery().getBase(equation));
            }
            case 2: {
                        String equation           = "1+1=3";
                        int[] expected__          = { };

                        return verifyCase(casenum__, expected__, new BaseMystery().getBase(equation));
            }
            case 3: {
                        String equation           = "ABCD+211=B000";
                        int[] expected__          = { 14 };

                        return verifyCase(casenum__, expected__, new BaseMystery().getBase(equation));
            }
            case 4: {
                        String equation           = "ABCD+322=B000";
                        int[] expected__          = { 15 };

                        return verifyCase(casenum__, expected__, new BaseMystery().getBase(equation));
            }
            case 5: {
                        String equation           = "1+0=1";
                        int[] expected__          = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

                        return verifyCase(casenum__, expected__, new BaseMystery().getBase(equation));
            }
            case 6: {
                        String equation           = "GHIJ+1111=HJ00";
                        int[] expected__          = { 20 };

                        return verifyCase(casenum__, expected__, new BaseMystery().getBase(equation));
            }
            case 7: {
                        String equation           = "1234+8765=9999";
                        int[] expected__          = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

                        return verifyCase(casenum__, expected__, new BaseMystery().getBase(equation));
            }

            // custom cases

            /*      case 8: {
                    String equation           = ;
                    int[] expected__          = ;

                    return verifyCase(casenum__, expected__, new BaseMystery().getBase(equation));
                    }*/
            /*      case 9: {
                    String equation           = ;
                    int[] expected__          = ;

                    return verifyCase(casenum__, expected__, new BaseMystery().getBase(equation));
                    }*/
            /*      case 10: {
                    String equation           = ;
                    int[] expected__          = ;

                    return verifyCase(casenum__, expected__, new BaseMystery().getBase(equation));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
