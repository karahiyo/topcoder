import java.util.*;

public class SurveillanceSystem {
    public String getContainerInfo(String containers, int[] reports, int L) {
        int N = containers.length();
        int R = reports.length;
        int[] ways = new int[R];

        HashMap<Integer, Integer> reps = new HashMap<Integer, Integer>();
        for(int i : reports)
            if(reps.contains(i))
                reps.put(i, reps.get(i)+1);
            else
                reps.put(i, 1);


        for(int i=0; i<N-L+1; i++) {
            int count = 0;
            for(int j=0; j<L; j++) {
                if(containers.charAt(i+j) == 'X')
                    count++;
            }

            if(reps.contains(count)) {
                ways[reps.indexOf(count)]++;
            }
        }


        char[] ret = new char[N];
        for(int i=0; i<N; i++) { 
            ret[i] = '0';
        }
        int tmp = 0;
        for(int i=0; i<N-L+1; i++) {
            int count = 0;
            for(int j=0; j<L; j++) {
                if(containers.charAt(i+j) == 'X')
                    count++;
            }
            if(reps.contains(count)) {
                if(ways[reps.indexOf(count)] == 1) {
                    for(int j=0; j<L; j++)
                        ret[i+j] = '+';
                } else {
                    tmp++;
                    for(int j=0; j<L; j++) {
                        if(ret[i+j] == '+')
                            continue;
                        else {
                            ret[i+j]++;
                        }
                    }
                }
            }
        }

        System.err.print("** " + tmp + "\n");
        System.err.print("** " + String.valueOf(ret)+"\n");
        for(int i=0; i<N; i++) {
            if(ret[i] != '+') {
                if(ret[i] == '0')
                    ret[i] = '-';
                else {
                    System.err.print("["+i+"] ret[i] ? tmp = " + ret[i] +":" + tmp+"\n");
                    if((ret[i] - '0') == tmp) {
                        System.err.print("@@@@ "+i+" \n");
                        ret[i] = '+';
                    } else
                        ret[i] = '?';
                }
            }
        }


        return String.valueOf(ret);

    }



    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            SurveillanceSystemHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                SurveillanceSystemHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class SurveillanceSystemHarness {
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
                        String containers         = "-X--XX";
                        int[] reports             = {1, 2};
                        int L                     = 3;
                        String expected__         = "??++++";

                        return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
            }
            case 1: {
                        String containers         = "-XXXXX-";
                        int[] reports             = {2};
                        int L                     = 3;
                        String expected__         = "???-???";

                        return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
            }
            case 2: {
                        String containers         = "------X-XX-";
                        int[] reports             = {3, 0, 2, 0};
                        int L                     = 5;
                        String expected__         = "++++++++++?";

                        return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
            }
            case 3: {
                        String containers         = "-XXXXX---X--";
                        int[] reports             = {2, 1, 0, 1};
                        int L                     = 3;
                        String expected__         = "???-??++++??";

                        return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
            }
            case 4: {
                        String containers         = "-XX--X-XX-X-X--X---XX-X---XXXX-----X";
                        int[] reports             = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
                        int L                     = 7;
                        String expected__         = "???++++?++++++++++++++++++++??????--";

                        return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
            }

            // custom cases

            /*      case 5: {
                    String containers         = ;
                    int[] reports             = ;
                    int L                     = ;
                    String expected__         = ;

                    return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
                    }*/
            /*      case 6: {
                    String containers         = ;
                    int[] reports             = ;
                    int L                     = ;
                    String expected__         = ;

                    return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
                    }*/
            /*      case 7: {
                    String containers         = ;
                    int[] reports             = ;
                    int L                     = ;
                    String expected__         = ;

                    return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
