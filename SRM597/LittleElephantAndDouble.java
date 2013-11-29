
public class LittleElephantAndDouble {
    public String getAnswer(int[] A) {
        int min = Integer.MAX_VALUE;;
        int max = 0;
        for (int i=0; i < A.length; i++) {
            if (min > A[i]) {
                min = A[i];
            }
            if ( max < A[i]) {
                max = A[i];
            }
        }
        for (int i=0; i < A.length; i++) {
            int a = A[i];
            while (a < max) {
                a *= 2;
            }
            if(a == max){
                continue;
            } 
            return "NO";
        }
        return "YES";

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            LittleElephantAndDoubleHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                LittleElephantAndDoubleHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class LittleElephantAndDoubleHarness {
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
                        int[] A                   = {1, 2};
                        String expected__         = "YES";

                        return verifyCase(casenum__, expected__, new LittleElephantAndDouble().getAnswer(A));
            }
            case 1: {
                        int[] A                   = {1, 2, 3};
                        String expected__         = "NO";

                        return verifyCase(casenum__, expected__, new LittleElephantAndDouble().getAnswer(A));
            }
            case 2: {
                        int[] A                   = {4, 8, 2, 1, 16};
                        String expected__         = "YES";

                        return verifyCase(casenum__, expected__, new LittleElephantAndDouble().getAnswer(A));
            }
            case 3: {
                        int[] A                   = {94, 752, 94, 376, 1504};
                        String expected__         = "YES";

                        return verifyCase(casenum__, expected__, new LittleElephantAndDouble().getAnswer(A));
            }
            case 4: {
                        int[] A                   = {148, 298, 1184};
                        String expected__         = "NO";

                        return verifyCase(casenum__, expected__, new LittleElephantAndDouble().getAnswer(A));
            }
            case 5: {
                        int[] A                   = {7, 7, 7, 7};
                        String expected__         = "YES";

                        return verifyCase(casenum__, expected__, new LittleElephantAndDouble().getAnswer(A));
            }

            // custom cases

            /*      case 6: {
                    int[] A                   = ;
                    String expected__         = ;

                    return verifyCase(casenum__, expected__, new LittleElephantAndDouble().getAnswer(A));
                    }*/
            /*      case 7: {
                    int[] A                   = ;
                    String expected__         = ;

                    return verifyCase(casenum__, expected__, new LittleElephantAndDouble().getAnswer(A));
                    }*/
            /*      case 8: {
                    int[] A                   = ;
                    String expected__         = ;

                    return verifyCase(casenum__, expected__, new LittleElephantAndDouble().getAnswer(A));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
