import java.util.*;

public class BatchSystem {
    public int[] schedule(int[] duration, String[] user) {
        String[] c = new String[duration.length];
        int index = 0;
        HashMap<String, Long> h = new HashMap<String, Long>();
        for(int i=0; i<duration.length; i++) {
            if(h.containsKey(user[i]))
                h.put(user[i], h.get(user[i]) + (long)duration[i]);
            else {
                h.put(user[i], (long)duration[i]);
                c[index++] = user[i];
            }
        }

        int now = 0;
        int ret[] = new int[duration.length];
        for(int i=0; i<index; i++) {
            long max = Long.MAX_VALUE;
            String maxVal = "";
            int kesu = 0;
            for(int j=0; j<index; j++) {
                if(max > h.get(c[j])) {
                    max = h.get(c[j]);
                    kesu = j;
                    maxVal = c[j];
                }
            }
            h.put(maxVal, Long.MAX_VALUE);
            System.err.println(maxVal);
            for(int j=0; j<duration.length; j++) {
                if(maxVal.equals(user[j]))
                    ret[j] = now++;
            }
        }
        int honto[] = new int[duration.length];
        for(int i=0; i<duration.length; i++) {
            honto[ret[i]] = i;
        }
        return honto;

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            BatchSystemHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                BatchSystemHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class BatchSystemHarness {
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
                        int[] duration            = {400, 100, 100, 100};
                        String[] user             = {"Danny Messer", "Stella Bonasera", "Stella Bonasera", "Mac Taylor"};
                        int[] expected__          = {3, 1, 2, 0 };

                        return verifyCase(casenum__, expected__, new BatchSystem().schedule(duration, user));
            }
            case 1: {
                        int[] duration            = {200, 200, 200};
                        String[] user             = {"Gil", "Sarah", "Warrick"};
                        int[] expected__          = {0, 1, 2 };

                        return verifyCase(casenum__, expected__, new BatchSystem().schedule(duration, user));
            }
            case 2: {
                        int[] duration            = {100, 200, 50};
                        String[] user             = {"Horatio Caine", "horatio caine", "YEAAAAAAH"};
                        int[] expected__          = {2, 0, 1 };

                        return verifyCase(casenum__, expected__, new BatchSystem().schedule(duration, user));
            }

            // custom cases

            /*      case 3: {
                    int[] duration            = ;
                    String[] user             = ;
                    int[] expected__          = ;

                    return verifyCase(casenum__, expected__, new BatchSystem().schedule(duration, user));
                    }*/
            /*      case 4: {
                    int[] duration            = ;
                    String[] user             = ;
                    int[] expected__          = ;

                    return verifyCase(casenum__, expected__, new BatchSystem().schedule(duration, user));
                    }*/
            /*      case 5: {
                    int[] duration            = ;
                    String[] user             = ;
                    int[] expected__          = ;

                    return verifyCase(casenum__, expected__, new BatchSystem().schedule(duration, user));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
