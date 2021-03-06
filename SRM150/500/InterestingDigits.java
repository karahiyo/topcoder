import java.util.*;
public class InterestingDigits {
    public int[] digits(int base) {
        ArrayList<Integer> rec = new ArrayList<Integer>();

        for(int n = 2; n<base; n++) {
            boolean ok = true;
            for(int k1=0; k1<base; k1++){
                for(int k2=0; k2<base; k2++){
                    for(int k3=0; k3<base; k3++) {
                        if((k1+k2*base+k3*base*base)%n==0 &&
                            (k1+k2+k3)%n != 0) {
                            ok = false;
                            break;
                            }
                        if(!ok) break;
                    }
                    if(!ok) break;
                }
                if(!ok) break;
            }
            if(ok) rec.add(n);
        }

        int ans[] = new int[rec.size()];
        for(int i=0;i<rec.size();i++)
            ans[i] = rec.get(i);

        return ans;
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            InterestingDigitsHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                InterestingDigitsHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class InterestingDigitsHarness {
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
                        int base                  = 10;
                        int[] expected__          = { 3, 9 };

                        return verifyCase(casenum__, expected__, new InterestingDigits().digits(base));
            }
            case 1: {
                        int base                  = 3;
                        int[] expected__          = { 2 };

                        return verifyCase(casenum__, expected__, new InterestingDigits().digits(base));
            }
            case 2: {
                        int base                  = 9;
                        int[] expected__          = { 2, 4, 8 };

                        return verifyCase(casenum__, expected__, new InterestingDigits().digits(base));
            }
            case 3: {
                        int base                  = 26;
                        int[] expected__          = { 5, 25 };

                        return verifyCase(casenum__, expected__, new InterestingDigits().digits(base));
            }
            case 4: {
                        int base                  = 30;
                        int[] expected__          = { 29 };

                        return verifyCase(casenum__, expected__, new InterestingDigits().digits(base));
            }

            // custom cases

            /*      case 5: {
                    int base                  = ;
                    int[] expected__          = ;

                    return verifyCase(casenum__, expected__, new InterestingDigits().digits(base));
                    }*/
            /*      case 6: {
                    int base                  = ;
                    int[] expected__          = ;

                    return verifyCase(casenum__, expected__, new InterestingDigits().digits(base));
                    }*/
            /*      case 7: {
                    int base                  = ;
                    int[] expected__          = ;

                    return verifyCase(casenum__, expected__, new InterestingDigits().digits(base));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
