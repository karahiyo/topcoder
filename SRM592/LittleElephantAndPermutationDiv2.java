public class LittleElephantAndPermutationDiv2 {

    static boolean next_permutation(int[] as) {
        int n = as.length;
        for (int i=n-1; i>0; i--) {
            if (as[i - 1] < as[i]) {
                int j = n;
                while (as[i-1] >= as[--j]);
                swap(as, i-1, j);
                reverse(as, i, n);
                return true;
            }
        }
        return false;
    }
    static void swap(int[] is, int i, int j) {
        int t = is[i];
        is[i] = is[j];
        is[j] = t;
    }
    static void reverse(int[] is, int s, int t) {
        while(s < --t)
            swap(is, s++, t);
    }
    public long fact(int i) {
        return i == 0 ? 1 : i * fact(i - 1);
    }

    public long getNumber(int N, int K) {
        long res=0;
        int[] per = new int[N];
        for(int i=0; i<N; i++)
            per[i] = i;

        int[] as = new int[N];
        for(int i=0; i<N; i++)
            as[i] = i+1;

        do{
            int k=0;
            for(int i=0; i<N; i++) {
                k += Math.max(as[i], as[per[i]]);
            }
            if (k>=K)res++;
        } while(next_permutation(per));
        return res * fact(N);
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            LittleElephantAndPermutationDiv2Harness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                LittleElephantAndPermutationDiv2Harness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class LittleElephantAndPermutationDiv2Harness {
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

    static boolean compareOutput(long expected, long result) { return expected == result; }
    static String formatResult(long res) {
        return String.format("%d", res);
    }

    static int verifyCase(int casenum, long expected, long received) { 
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
                        int N                     = 1;
                        int K                     = 1;
                        long expected__           = 1;

                        return verifyCase(casenum__, expected__, new LittleElephantAndPermutationDiv2().getNumber(N, K));
            }
            case 1: {
                        int N                     = 2;
                        int K                     = 1;
                        long expected__           = 4;

                        return verifyCase(casenum__, expected__, new LittleElephantAndPermutationDiv2().getNumber(N, K));
            }
            case 2: {
                        int N                     = 3;
                        int K                     = 8;
                        long expected__           = 18;

                        return verifyCase(casenum__, expected__, new LittleElephantAndPermutationDiv2().getNumber(N, K));
            }
            case 3: {
                        int N                     = 10;
                        int K                     = 47;
                        long expected__           = 13168189440000L;

                        return verifyCase(casenum__, expected__, new LittleElephantAndPermutationDiv2().getNumber(N, K));
            }

            // custom cases

            case 4: {
                        int N                     = 10;
                        int K                     = 100;
                        long expected__           = 0;

                        return verifyCase(casenum__, expected__, new LittleElephantAndPermutationDiv2().getNumber(N, K));
            }
            case 5: {
                        int N                     = 9;
                        int K                     = 74;
                        long expected__           = 0;

                        return verifyCase(casenum__, expected__, new LittleElephantAndPermutationDiv2().getNumber(N, K));
            }
            case 6: {
                        int N                     = 9;
                        int K                     = 65;
                        long expected__           = 1881169920;

                        return verifyCase(casenum__, expected__, new LittleElephantAndPermutationDiv2().getNumber(N, K));
            }
            case 7: {
                        int N                     = 10;
                        int K                     = 47;
                        long expected__           = (long)1316818944 * 10000;

                        return verifyCase(casenum__, expected__, new LittleElephantAndPermutationDiv2().getNumber(N, K));
            }
            default:
                    return -1;
        }
    }
}

// END CUT HERE
