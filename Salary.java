import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;



public class Salary {
    public int howMuch(String[] arrival, String[] departure, int wage) {
        double p = 0;
        int day = 24*60*60;
        int e1 = 18*60*60; int e2 = day - 1;
        int n1 = 0; int n2 = 6+60*60 -1;

        double wps = wage/(60*60.0);
        for(int i=0; i < arrival.length; i++) {
            int arr = parse(arrival[i]);
            int dep = parse(departure[i]);
            int d = dep -arr;
            while(arr != dep) {
                if(arr >= e1 && arr <= e2) p += 1.5 * wps;
                else if(arr >= n1 && arr <= n2) p += 1.5 * wps;
                else p += wps;
                arr = (arr + 1) % day;
            }
        }
        return (int)(p + 0.000001);
    }

    protected int parse(String d) {
        StringTokenizer st = new StringTokenizer(d, ":");
        int ret = Integer.parseInt(st.nextToken()) * 60 * 60;
        ret += Integer.parseInt(st.nextToken()) * 60;
        ret += Integer.parseInt(st.nextToken());
        return ret;
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            SalaryHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                SalaryHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class SalaryHarness {
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
                        String[] arrival          = {"08:00:00","13:00:00","19:27:32"};
                        String[] departure        = {"12:00:00","17:00:00","20:48:10"};
                        int wage                  = 1000;
                        int expected__            = 10015;

                        return verifyCase(casenum__, expected__, new Salary().howMuch(arrival, departure, wage));
            }
            case 1: {
                        String[] arrival          = {"01:05:47","16:48:12"};
                        String[] departure        = {"09:27:30","21:17:59"};
                        int wage                  = 2000;
                        int expected__            = 33920;

                        return verifyCase(casenum__, expected__, new Salary().howMuch(arrival, departure, wage));
            }
            case 2: {
                        String[] arrival          = {"00:00:00"};
                        String[] departure        = {"23:59:59"};
                        int wage                  = 10000;
                        int expected__            = 299995;

                        return verifyCase(casenum__, expected__, new Salary().howMuch(arrival, departure, wage));
            }
            case 3: {
                        String[] arrival          = {"10:00:00"};
                        String[] departure        = {"18:00:00"};
                        int wage                  = 10000;
                        int expected__            = 80000;

                        return verifyCase(casenum__, expected__, new Salary().howMuch(arrival, departure, wage));
            }
            case 4: {
                        String[] arrival          = {"22:19:46"};
                        String[] departure        = {"23:12:46"};
                        int wage                  = 5320;
                        int expected__            = 7049;

                        return verifyCase(casenum__, expected__, new Salary().howMuch(arrival, departure, wage));
            }

            // custom cases

            /*      case 5: {
                    String[] arrival          = ;
                    String[] departure        = ;
                    int wage                  = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new Salary().howMuch(arrival, departure, wage));
                    }*/
            /*      case 6: {
                    String[] arrival          = ;
                    String[] departure        = ;
                    int wage                  = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new Salary().howMuch(arrival, departure, wage));
                    }*/
            /*      case 7: {
                    String[] arrival          = ;
                    String[] departure        = ;
                    int wage                  = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new Salary().howMuch(arrival, departure, wage));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
