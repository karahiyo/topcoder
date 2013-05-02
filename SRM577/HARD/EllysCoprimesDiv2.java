import java.util.*;
public class EllysCoprimesDiv2 {
    int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a % b);
    }
    int get(int f, int t) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] d = new int[t];
        boolean[] vi = new boolean[t];
        q.add(f);
        while(q.size() > 0) {
            int top = q.remove();
            if(gcd(top, t) == 1) return d[top];
            for(int i = 1;top + i < t; ++i) {
                if(vi[top + i]) continue;
                if(gcd(top, top + i) == 1) {
                    q.add(top + i);
                    d[top + i] += d[top] + 1;
                    vi[top + i] = true;
                }
            }
        }
        throw new RuntimeException();
    }
    public int getCount(int[] nu) {
        int r = 0, n = nu.length;
        Arrays.sort(nu);
        for(int i= 1; i<n;++i)
            r += get(nu[i-1], nu[i]);
        return r;

    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            EllysCoprimesDiv2Harness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                EllysCoprimesDiv2Harness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class EllysCoprimesDiv2Harness {
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
                        int[] numbers             = {2200, 42, 2184, 17};
                        int expected__            = 3;

                        return verifyCase(casenum__, expected__, new EllysCoprimesDiv2().getCount(numbers));
            }
            case 1: {
                        int[] numbers             = {13, 1, 6, 20, 33};
                        int expected__            = 0;

                        return verifyCase(casenum__, expected__, new EllysCoprimesDiv2().getCount(numbers));
            }
            case 2: {
                        int[] numbers             = {7, 42};
                        int expected__            = 1;

                        return verifyCase(casenum__, expected__, new EllysCoprimesDiv2().getCount(numbers));
            }
            case 3: {
                        int[] numbers             = {55780, 44918, 55653, 4762, 41536, 40083, 79260, 7374, 24124, 91858, 7856, 12999, 64025, 12706, 19770, 71495, 32817, 79309, 53779, 8421, 97984, 34586, 893, 64549, 77792, 12143, 52732, 94416, 54207, 51811, 80845, 67079, 14829, 25350, 22976, 23932, 62273, 58871, 82358, 13283, 33667, 64263, 1337, 42666};
                        int expected__            = 15;

                        return verifyCase(casenum__, expected__, new EllysCoprimesDiv2().getCount(numbers));
            }

            // custom cases

            /*      case 4: {
                    int[] numbers             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new EllysCoprimesDiv2().getCount(numbers));
                    }*/
            /*      case 5: {
                    int[] numbers             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new EllysCoprimesDiv2().getCount(numbers));
                    }*/
            /*      case 6: {
                    int[] numbers             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new EllysCoprimesDiv2().getCount(numbers));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
