import java.util.*;

public class WinterAndCandies {
    public int getNumber(int[] type) {
        Arrays.sort(type);
        int N = type.length;
        int count = 0;
        Queue<int[]> q = new LinkedList<int[]>();

        for (int t : type) {
            int[] start = {t};
            q.offer(start);
        }

        while(q.peek() != null) {
            int[] ts = q.poll();
            if(tCheck(ts)) {
                count++;
                for(int i=ts.length; i<N; i++) {
                    int[] next = new int[ts.length+1];
                    arraySet(next, ts);
                    next[ts.length] = type[i];
                    q.offer(next);
                }
            }
        }

        return count;

    }

    public static void arraySet(int[] A, int[] B) {
        for(int i=0; i < B.length; i++) {
            A[i] = B[i];
        }
    }

    public static boolean tCheck(int[] types) {
        int N = types.length;
        for(int i=0; i<N; i++) {
            if (types[i] != i+1) {
                return false;
            } 
        }
        return true;
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            WinterAndCandiesHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                WinterAndCandiesHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class WinterAndCandiesHarness {
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
                        int[] type                = {1, 3, 2};
                        int expected__            = 3;

                        return verifyCase(casenum__, expected__, new WinterAndCandies().getNumber(type));
            }
            case 1: {
                        int[] type                = {1, 1, 2};
                        int expected__            = 4;

                        return verifyCase(casenum__, expected__, new WinterAndCandies().getNumber(type));
            }
            case 2: {
                        int[] type                = {1, 3, 2, 5, 7, 4, 5, 4};
                        int expected__            = 9;

                        return verifyCase(casenum__, expected__, new WinterAndCandies().getNumber(type));
            }
            case 3: {
                        int[] type                = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
                        int expected__            = 62;

                        return verifyCase(casenum__, expected__, new WinterAndCandies().getNumber(type));
            }
            case 4: {
                        int[] type                = {2};
                        int expected__            = 0;

                        return verifyCase(casenum__, expected__, new WinterAndCandies().getNumber(type));
            }

            // custom cases

            /*      case 5: {
                    int[] type                = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WinterAndCandies().getNumber(type));
                    }*/
            /*      case 6: {
                    int[] type                = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WinterAndCandies().getNumber(type));
                    }*/
            /*      case 7: {
                    int[] type                = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WinterAndCandies().getNumber(type));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
