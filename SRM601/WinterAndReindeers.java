import java.util.*;

public class WinterAndReindeers {
    public int getNumber(String[] allA, String[] allB, String[] allC) {
        // List<String> Ss = new ArrayList<String>();
        String S = "";

        String A = concatenate(allA);
        String B = concatenate(allB);
        String C = concatenate(allC);

        Queue<String> q_subC = new LinkedList<String>();
        for(int i=0; i<C.length(); i++) {
            q_subC.offer("" + C.charAt(i));
        }

        // add data in queue

        while(q_subC.peek() != null) {
            String subC = q_subC.poll();

            if (subA.matches(subC)) {
                // up length
            }
        }

    }

    public static boolean isSub(String A, String sub) {
        char[] cs = sub.toCharArray();
        for (int i=0; i<cs.length; i++) {
            if(A.indexOf(cs[i]) == -1) {
                return false;
            }
        }
        return true;
    }

    public static String concatenate(String[] all) {
        String ret = "";
        for(int i=0; i<all.length; i++) {
            ret += all[i];
        }
        return ret;
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            WinterAndReindeersHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                WinterAndReindeersHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class WinterAndReindeersHarness {
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
                        String[] allA             = {"X"};
                        String[] allB             = {"X", "Y"};
                        String[] allC             = {"X"};
                        int expected__            = 1;

                        return verifyCase(casenum__, expected__, new WinterAndReindeers().getNumber(allA, allB, allC));
            }
            case 1: {
                        String[] allA             = {"ABCXD"};
                        String[] allB             = {"BCDEF"};
                        String[] allC             = {"CD"};
                        int expected__            = 3;

                        return verifyCase(casenum__, expected__, new WinterAndReindeers().getNumber(allA, allB, allC));
            }
            case 2: {
                        String[] allA             = {"WE", "LOVE"};
                        String[] allB             = {"WORKING", "FOR", "SANTA"};
                        String[] allC             = {"JK"};
                        int expected__            = 0;

                        return verifyCase(casenum__, expected__, new WinterAndReindeers().getNumber(allA, allB, allC));
            }
            case 3: {
                        String[] allA             = {"ABCDE"};
                        String[] allB             = {"CDEAB"};
                        String[] allC             = {"B"};
                        int expected__            = 2;

                        return verifyCase(casenum__, expected__, new WinterAndReindeers().getNumber(allA, allB, allC));
            }
            case 4: {
                        String[] allA             = {"ABCABDEGAXAHDJBAAHFJDXBB", "ABHFHCDALFDJDBBA", "BABBAXAXXX"};
                        String[] allB             = {"ABLOCBAXBAHAJDXBIJKA", "JBABCDAHKFIUDALPJAH", "AABACX"};
                        String[] allC             = {"AXBADXBBAB", "CDD"};
                        int expected__            = 23;

                        return verifyCase(casenum__, expected__, new WinterAndReindeers().getNumber(allA, allB, allC));
            }

            // custom cases

            /*      case 5: {
                    String[] allA             = ;
                    String[] allB             = ;
                    String[] allC             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WinterAndReindeers().getNumber(allA, allB, allC));
                    }*/
            /*      case 6: {
                    String[] allA             = ;
                    String[] allB             = ;
                    String[] allC             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WinterAndReindeers().getNumber(allA, allB, allC));
                    }*/
            /*      case 7: {
                    String[] allA             = ;
                    String[] allB             = ;
                    String[] allC             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WinterAndReindeers().getNumber(allA, allB, allC));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
