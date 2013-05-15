import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.lang.Integer.*;

public class WordParts {
    public int partCount(String original, String compound) {
        List<String> validSubStrings = new ArrayList<String>();
        validSubStrings.add(original);
        for(int i=1;i<original.length(); i++) {
            validSubStrings.add(original.substring(i));
            validSubStrings.add(original.substring(i, original.length()-1));
        }

        int[] dp = new int[compound.length()-1];
        fill(dp, 10000);

        dp[0] = 0;

        for(int i=0;i<compound.length(); i++){
            for(String validSubString : validSubStrings) {
                if(compound.substring(i).startsWith(validSubString)) {
                    System.err.print(compound.substring(i)+"\t\t\t");
                    System.err.print(i+ ": "+validSubString+"\t");
                    dp[i+validSubString.length()] = min(dp[i], dp[i]+1);
                    System.err.print(dp[i]+1 + "\t");
                    System.err.print(dp[i+validSubString.length()]+"\n");
                }
            }
        }
        return dp[compound.length()] == 100000 ? -1 : dp[compound.length()];
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            WordPartsHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                WordPartsHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class WordPartsHarness {
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
                        String original           = "ANTIDISESTABLISHMENTARIANISM";
                        String compound           = "ANTIDISIANISMISM";
                        int expected__            = 3;

                        return verifyCase(casenum__, expected__, new WordParts().partCount(original, compound));
            }
            case 1: {
                        String original           = "ANTIDISESTABLISHMENTARIANISM";
                        String compound           = "ESTABLISHMENT";
                        int expected__            = -1;

                        return verifyCase(casenum__, expected__, new WordParts().partCount(original, compound));
            }
            case 2: {
                        String original           = "TOPCODERDOTCOM";
                        String compound           = "TOMTMODERDOTCOM";
                        int expected__            = 5;

                        return verifyCase(casenum__, expected__, new WordParts().partCount(original, compound));
            }
            case 3: {
                        String original           = "HELLO";
                        String compound           = "HELLOHEHELLOLOHELLO";
                        int expected__            = 5;

                        return verifyCase(casenum__, expected__, new WordParts().partCount(original, compound));
            }
            case 4: {
                        String original           = "DONTFORGETTHEEMPTYCASE";
                        String compound           = "";
                        int expected__            = 0;

                        return verifyCase(casenum__, expected__, new WordParts().partCount(original, compound));
            }
            case 5: {
                        String original           = "BAAABA";
                        String compound           = "BAAABAAA";
                        int expected__            = 2;

                        return verifyCase(casenum__, expected__, new WordParts().partCount(original, compound));
            }
            case 6: {
                        String original           = "ABBBAABABBBAABBABBABABBABAABBAABBBBBABBABABBABAABB";
                        String compound           = "BBBAABABBBAABBABBABABBABAABBAABBBBBABBABABBABAABAA";
                        int expected__            = 17;

                        return verifyCase(casenum__, expected__, new WordParts().partCount(original, compound));
            }

            // custom cases

            /*      case 7: {
                    String original           = ;
                    String compound           = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WordParts().partCount(original, compound));
                    }*/
            /*      case 8: {
                    String original           = ;
                    String compound           = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WordParts().partCount(original, compound));
                    }*/
            /*      case 9: {
                    String original           = ;
                    String compound           = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new WordParts().partCount(original, compound));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
