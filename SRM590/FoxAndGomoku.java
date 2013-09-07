public class FoxAndGomoku {
    public String win(String[] b) {
        String ok = "not found";
        String bad = "found";

        int w = b[0].length();
        int h = b.length;

        // check column
        for (int i=0; i < h; i++) {
            for (int j=0; j<=w-5; j++) {
                if(b[i].charAt(j+0) == 'o' && 
                    b[i].charAt(j+1) == 'o' &&
                    b[i].charAt(j+2) == 'o' &&
                    b[i].charAt(j+3) == 'o' &&
                    b[i].charAt(j+4) == 'o') 
                {
                    return bad;
                }
            }
        }

        // check row
        for (int i=0; i <= h-5; i++) {
            for (int j=0; j < w; j++) {
                if(b[i+0].charAt(j) == 'o' &&
                    b[i+1].charAt(j) == 'o' &&
                    b[i+2].charAt(j) == 'o' &&
                    b[i+3].charAt(j) == 'o' &&
                    b[i+4].charAt(j) == 'o') 
                {
                    return bad;
                }
            }
        }

        // check L verical
        for (int i=0; i < h-5; i++) {
            for (int j=w-1; j >= w-5; j--) {
                if(b[i+0].charAt(j-0) == 'o' &&
                    b[i+1].charAt(j-1) == 'o' &&
                    b[i+2].charAt(j-2) == 'o' &&
                    b[i+3].charAt(j-3) == 'o' &&
                    b[i+4].charAt(j-4) == 'o')
                {
                    return bad;
                }
            }
        }

        // check R verical
        for (int i=0; i <= h-5; i++) {
            for (int j=0; j <= w-5; j++) {
                if(b[i+0].charAt(j+0) == 'o' &&
                    b[i+1].charAt(j+1) == 'o' &&
                    b[i+2].charAt(j+2) == 'o' &&
                    b[i+3].charAt(j+3) == 'o' &&
                    b[i+4].charAt(j+4) == 'o')
                {
                    return bad;
                }
            }
        }

        return ok;

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            FoxAndGomokuHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                FoxAndGomokuHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class FoxAndGomokuHarness {
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
                        String[] board            = {"....o.",
                            "...o..",
                            "..o...",
                            ".o....",
                            "o.....",
                            "......"};
                        String expected__         = "found";

                        return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
            }
            case 1: {
                        String[] board            = {"oooo.",
                            ".oooo",
                            "oooo.",
                            ".oooo",
                            "....."}
                        ;
                        String expected__         = "not found";

                        return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
            }
            case 2: {
                        String[] board            = {"oooo.",
                            ".oooo",
                            "oooo.",
                            ".oooo",
                            "....o"}
                        ;
                        String expected__         = "found";

                        return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
            }
            case 3: {
                        String[] board            = {"o.....",
                            ".o....",
                            "..o...",
                            "...o..",
                            "....o.",
                            "......"};
                        String expected__         = "found";

                        return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
            }
            case 4: {
                        String[] board            = {"o....",
                            "o.o..",
                            "o.o.o",
                            "o.o..",
                            "o...."};
                        String expected__         = "found";

                        return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
            }
            case 5: {
                        String[] board            = {"..........",
                            "..........",
                            "..oooooo..",
                            "..o.......",
                            "..o.......",
                            "..oooooo..",
                            ".......o..",
                            ".......o..",
                            "..oooooo..",
                            ".........."}

                        ;
                        String expected__         = "found";

                        return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
            }
            case 6: {
                        String[] board            = {"..........",
                            "..........",
                            "..oooo.o..",
                            "..o.......",
                            "..o.......",
                            "..o.oooo..",
                            ".......o..",
                            ".......o..",
                            "..oooo.o..",
                            ".........."}
                        ;
                        String expected__         = "not found";

                        return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
            }
            case 7: {
                        String[] board            = {"ooooo",
                            "ooooo",
                            "ooooo",
                            "ooooo",
                            "ooooo"};
                        String expected__         = "found";

                        return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
            }
            case 8: {
                        String[] board            = {".....",
                            ".....",
                            ".....",
                            ".....",
                            "....."};
                        String expected__         = "not found";

                        return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
            }

            // custom cases

            /*      case 9: {
                    String[] board            = ;
                    String expected__         = ;

                    return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
                    }*/
            /*      case 10: {
                    String[] board            = ;
                    String expected__         = ;

                    return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
                    }*/
            /*      case 11: {
                    String[] board            = ;
                    String expected__         = ;

                    return verifyCase(casenum__, expected__, new FoxAndGomoku().win(board));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
