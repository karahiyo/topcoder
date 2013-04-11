import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class DiskSpace {
    public int minDrives(int[] used, int[] total) {
        Arrays.sort(total);
        int sum = 0;
        int len = used.length;
        for(int i=0; i< len; i++) {
            sum += used[i];
        }

        int rec=0;
        for(int i=len-1; i >= 0; i--) {
            sum -= total[i];
            rec++;
            if(sum <= 0)
                break;
        }
        return rec;
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            DiskSpaceHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                DiskSpaceHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class DiskSpaceHarness {
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
                        int[] used                = {300,525,110};
                        int[] total               = {350,600,115};
                        int expected__            = 2;

                        return verifyCase(casenum__, expected__, new DiskSpace().minDrives(used, total));
            }
            case 1: {
                        int[] used                = {1,200,200,199,200,200};
                        int[] total               = {1000,200,200,200,200,200};
                        int expected__            = 1;

                        return verifyCase(casenum__, expected__, new DiskSpace().minDrives(used, total));
            }
            case 2: {
                        int[] used                = {750,800,850,900,950};
                        int[] total               = {800,850,900,950,1000};
                        int expected__            = 5;

                        return verifyCase(casenum__, expected__, new DiskSpace().minDrives(used, total));
            }
            case 3: {
                        int[] used                = {49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49, 49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49};
                        int[] total               = {50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50, 50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50};
                        int expected__            = 49;

                        return verifyCase(casenum__, expected__, new DiskSpace().minDrives(used, total));
            }
            case 4: {
                        int[] used                = {331,242,384,366,428,114,145,89,381,170,329,190,482,246,2,38,220,290,402,385};
                        int[] total               = {992,509,997,946,976,873,771,565,693,714,755,878,897,789,969,727,765,521,961,906};
                        int expected__            = 6;

                        return verifyCase(casenum__, expected__, new DiskSpace().minDrives(used, total));
            }

            // custom cases

            /*      case 5: {
                    int[] used                = ;
                    int[] total               = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new DiskSpace().minDrives(used, total));
                    }*/
            /*      case 6: {
                    int[] used                = ;
                    int[] total               = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new DiskSpace().minDrives(used, total));
                    }*/
            /*      case 7: {
                    int[] used                = ;
                    int[] total               = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new DiskSpace().minDrives(used, total));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
