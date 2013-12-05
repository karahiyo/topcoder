import java.util.*;

public class SimilarNames2 {
    public int count(String[] names, int L) {
        int X = 0;

        for ( int i=0; i<names.length; i++) {
            long tx = simil(names[i], names, L);
            X += tx;
        }

        return X % 1000000007;
    }

    public long simil(String first, String[] names, int L) {

        if (L-2 < 0) {
            return comb(names.length);
        }


        List<String> ns = Arrays.asList(names);
        System.err.println(first);
        System.err.println(ns);
        Iterator itr = ns.iterator();
        while(itr.hasNext()){
            String i = (String)itr.next();
            if(i.equals(first)) itr.remove();
        }
        System.err.println(ns);

        long ret = 0;
        for (int j =0; j<ns.size(); j++) {
            if (ns.get(j).startsWith(first)) {
                // first 置き換えて、nsのその文字削除
                first = ns.get(j);
                ret += simil(first, ns.toArray(new String[ns.size()]), L-1);

            } else {
                continue;
            }
        }

        return ret;

    }

    public long comb(int n) {
        long ret = 1;
        if (n == 0 || n == 1) {
            return ret;
        }
        for (int i=1; i<=n; i++) {
            ret *= i;
        }
        return ret;
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            SimilarNames2Harness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                SimilarNames2Harness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class SimilarNames2Harness {
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
                        String[] names            = {"kenta", "kentaro", "ken"};
                        int L                     = 2;
                        int expected__            = 3;

                        return verifyCase(casenum__, expected__, new SimilarNames2().count(names, L));
            }
            case 1: {
                        String[] names            = {"hideo", "hideto", "hideki", "hide"};
                        int L                     = 2;
                        int expected__            = 6;

                        return verifyCase(casenum__, expected__, new SimilarNames2().count(names, L));
            }
            case 2: {
                        String[] names            = {"aya", "saku", "emi", "ayane", "sakura", "emika", "sakurako"};
                        int L                     = 3;
                        int expected__            = 24;

                        return verifyCase(casenum__, expected__, new SimilarNames2().count(names, L));
            }
            case 3: {
                        String[] names            = {"taro", "jiro", "hanako"};
                        int L                     = 2;
                        int expected__            = 0;

                        return verifyCase(casenum__, expected__, new SimilarNames2().count(names, L));
            }
            case 4: {
                        String[] names            = {"alice", "bob", "charlie"};
                        int L                     = 1;
                        int expected__            = 6;

                        return verifyCase(casenum__, expected__, new SimilarNames2().count(names, L));
            }
            case 5: {
                        String[] names            = {"ryota", "ryohei", "ryotaro", "ryo", "ryoga", "ryoma", "ryoko", "ryosuke", "ciel", "lun",
                            "ryuta", "ryuji", "ryuma", "ryujiro", "ryusuke", "ryutaro", "ryu", "ryuhei", "ryuichi", "evima"};
                        int L                     = 3;
                        int expected__            = 276818566;

                        return verifyCase(casenum__, expected__, new SimilarNames2().count(names, L));
            }

            // custom cases

            /*      case 6: {
                    String[] names            = ;
                    int L                     = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new SimilarNames2().count(names, L));
                    }*/
            /*      case 7: {
                    String[] names            = ;
                    int L                     = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new SimilarNames2().count(names, L));
                    }*/
            /*      case 8: {
                    String[] names            = ;
                    int L                     = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new SimilarNames2().count(names, L));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
