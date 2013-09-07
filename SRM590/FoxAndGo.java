import java.util.*;

public class FoxAndGo {
    public int maxKill(String[] b) {

        int max = 0;
        int h = b.length;
        int w = b[0].length();

        int[][] checked = new int[h][w];

        for ( int i=0; i<h; i++) {
            for( int j = 0; j<w; j++) {
                if(b[i].charAt(j) == 'o') {
                    Queue<Integer
                    int[] x = (i, j + 1);
                    int[] y = 

                
                }
            }
        }
        

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            FoxAndGoHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                FoxAndGoHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class FoxAndGoHarness {
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
                        String[] board            = {".....",
                            "..x..",
                            ".xox.",
                            ".....",
                            "....."}
                        ;
                        int expected__            = 1;

                        return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
            }
            case 1: {
                        String[] board            = {"ooooo",
                            "xxxxo",
                            "xxxx.",
                            "xxxx.",
                            "ooooo"}
                        ;
                        int expected__            = 6;

                        return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
            }
            case 2: {
                        String[] board            = {".xoxo",
                            "ooxox",
                            "oooxx",
                            "xoxox",
                            "oxoox"}
                        ;
                        int expected__            = 13;

                        return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
            }
            case 3: {
                        String[] board            = {".......",
                            ".......",
                            ".......",
                            "xxxx...",
                            "ooox...",
                            "ooox...",
                            "ooox..."}
                        ;
                        int expected__            = 9;

                        return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
            }
            case 4: {
                        String[] board            = {".......",
                            ".xxxxx.",
                            ".xooox.",
                            ".xo.ox.",
                            ".xooox.",
                            ".xxxxx.",
                            "......."}
                        ;
                        int expected__            = 8;

                        return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
            }
            case 5: {
                        String[] board            = {"o.xox.o",
                            "..xox..",
                            "xxxoxxx",
                            "ooo.ooo",
                            "xxxoxxx",
                            "..xox..",
                            "o.xox.o"}
                        ;
                        int expected__            = 12;

                        return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
            }
            case 6: {
                        String[] board            = {".......",
                            "..xx...",
                            ".xooox.",
                            ".oxxox.",
                            ".oxxxo.",
                            "...oo..",
                            "......."};
                        int expected__            = 4;

                        return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
            }
            case 7: {
                        String[] board            = {".ox....",
                            "xxox...",
                            "..xoox.",
                            "..xoox.",
                            "...xx..",
                            ".......",
                            "......."}
                        ;
                        int expected__            = 5;

                        return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
            }
            case 8: {
                        String[] board            = {"...................",
                            "...................",
                            "...o..........o....",
                            "................x..",
                            "...............x...",
                            "...................",
                            "...................",
                            "...................",
                            "...................",
                            "...................",
                            "...................",
                            "...................",
                            "...................",
                            "...................",
                            "................o..",
                            "..x................",
                            "...............x...",
                            "...................",
                            "..................."}
                        ;
                        int expected__            = 0;

                        return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
            }

            // custom cases

            /*      case 9: {
                    String[] board            = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
                    }*/
            /*      case 10: {
                    String[] board            = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
                    }*/
            /*      case 11: {
                    String[] board            = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new FoxAndGo().maxKill(board));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
