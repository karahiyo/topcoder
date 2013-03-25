import java.util.*;
import java.lang.*;

public class TheNumberGameDiv2 {
    public int minimumMoves(int A, int B) {
        String a = Integer.toString(A);
        String b = Integer.toString(B);
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<a.length();i++) {
            if(a.charAt(i) == b.charAt(0)) {
                if(found(i, a, b)) {
                    min1 = a.length() - (b.length() + i) + i+ 2;
                    if(i==0)
                        min1--;
                    min = Math.min(min, min1);
                }
            }
        }
        for(int i=a.length()-1;i>=0;i--) {
            if(a.charAt(i) == b.charAt(0)) {
                if(found2(i, a, b)) {
                    min2=a.length()-(i+1)+(i-b.length())+2;
                    min = Math.min(min, min2);
                }
            }
        }
        if(min==Integer.MAX_VALUE)
            return -1;
        return min;
    }
    static boolean found(int i, String a, String b) {
        int c = 0;
        for(int j=0;j<b.length();j++) {
            if((j+1) < a.length()) {
                if(b.charAt(j) != a.charAt(i+j))
                    return false;
                c++;
            }
        }
        if(c < b.length()) return false;
        return true;
    }
    static boolean found2(int i, String a,  String b) {
        int c=0;
        for(int j=0;j<b.length();j++) {
            if(i-j >= 0) {
                if(b.charAt(j) != a.charAt(i-j))
                    return false;
                c++;
            }
        }
        if(c<b.length()) return false;
        return true;
    }



    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            TheNumberGameDiv2Harness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                TheNumberGameDiv2Harness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class TheNumberGameDiv2Harness {
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
                        int A                     = 25;
                        int B                     = 5;
                        int expected__            = 2;

                        return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
            }
            case 1: {
                        int A                     = 5162;
                        int B                     = 16;
                        int expected__            = 4;

                        return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
            }
            case 2: {
                        int A                     = 334;
                        int B                     = 12;
                        int expected__            = -1;

                        return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
            }
            case 3: {
                        int A                     = 218181918;
                        int B                     = 9181;
                        int expected__            = 6;

                        return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
            }
            case 4: {
                        int A                     = 9798147;
                        int B                     = 79817;
                        int expected__            = -1;

                        return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
            }

            // custom cases

            /*      case 5: {
                    int A                     = ;
                    int B                     = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
                    }*/
            /*      case 6: {
                    int A                     = ;
                    int B                     = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
                    }*/
            /*      case 7: {
                    int A                     = ;
                    int B                     = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new TheNumberGameDiv2().minimumMoves(A, B));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
