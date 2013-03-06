public class BinaryCode {
   public String[] decode(String message) {
       int[] P= new int[3];
       int[] Q = new int[50];
       for (int i=0;i<50;i++)
           Q[i] = -1;

       String ans0 = "";
       String ans1 = "";
       String[] ans = new String[2];

       // pattern 1
       int tmp = 0;
       Q[0] = 0;

       for(int i=1;i<message.length()-1;i++) {
           tmp = Integer.parseInt("" + message.charAt(i));
           System.err.print("tmp(" + i + ") = " + tmp + "\n");
           System.err.print("ans0=" + ans0 + "\n");
           if (Q[i] >= 0)
               continue;

           if (tmp == 1) {
               Q[i] = -1;
               continue;
           } else if (tmp == 2) {
               if (Q[i-1] == 0) {
                   Q[i] = 1;
                   Q[i+1] = 1;
                   continue;
               } else if(Q[i-1] > 0 && Q[i+1] > 0) {
                   Q[i] = 0;
                   continue;
               }
           }else if (tmp == 3) {
               if(Q[i-1] == 0 || Q[i] == 0 || Q[i+1] == 0) {
                   ans0 = "NONE";
                   System.err.print("none");
                   break;
               }
               Q[i-1] = 1;
               Q[i] = 1;
               Q[i+1] = 1;
           }
       }

       if (Q[message.length()-1] == -1) {
           tmp = Integer.parseInt("" + message.charAt(message.length()-1));
           System.err.print("LAST=" + tmp + "\n");
           if (tmp > 2) {
               ans0 = "NONE";
               System.err.print("none?");
           } else if (tmp == 2) {
               if (Q[message.length() -1 -1] == 0) {
                   ans0 = "NONE";
                   System.err.print("none");
               }
               Q[(message.length() -1)] = 1;
           }
       }

       if (ans0.equals("NONE")) {
        // nothing
       } else {
           for(int i=0; i<message.length(); i++) {
               System.err.print(Q[i] + ", ");
                ans0.concat(Integer.toString(Q[i]));
           }
           System.err.print("\n");
       }

       // }}} pattern 1



       // ---------------------------------------------
       // {{{ pattern 1
       //
       for (int i=0;i<50;i++)
            Q[i] = -1;

       Q[1] = 0;

       System.err.print("** " + message.length() + "\n");
       for(int i=1;i<message.length()-1;i++) {
           tmp = Integer.valueOf(message.charAt(i));
           if (Q[i] >= 0)
               continue;

           if (tmp == 1) {
               Q[i] = -1;
               continue;
           } else if (tmp == 2) {
               if (Q[i-1] == 0) {
                   Q[i] = 1;
                   Q[i+1] = 1;
                   continue;
               } else if(Q[i-1] > 0 && Q[i+1] > 0) {
                   Q[i] = 0;
                   continue;
               }
           }else if (tmp == 3) {
               if(Q[i-1] == 0 || Q[i] == 0 || Q[i+1] == 0) {
                   ans1 = "NONE";
                   break;
               }
               Q[i-1] = 1;
               Q[i] = 1;
               Q[i+1] = 1;
           }
       }

       if (Q[message.length()-1] == -1) {
           tmp = Integer.valueOf(message.charAt(message.length()-1));
           if (tmp > 2) {
               ans1 = "NONE";
           } else if (tmp == 2) {
               if (Q[message.length() -1 -1] != 1) {
                   ans1 = "NONE";
               }
               Q[(message.length() -1)] = 1;
           } else if (tmp == 1) {
               if (Q[message.length() -1 -1] == 0)
                   Q[message.length() -1] = 1;
               else
                   Q[message.length() -1] = 0;
           }
       }

       if (ans0.equals("NONE")) {
        // nothing
       } else {
           for(int i=0; i<Q.length; i++) {
                ans1.concat(Integer.toString(Q[i]));
           }
       }

       // }}} pattern 2

       // --------------------------------------
       boolean flag=true;
       for (int i=0, j=message.length()-1;i<j;i++, j--) {
           if(message.charAt(i) != message.charAt(j)) {
               flag = false;
               break;
           }
       }

       if (ans0.equals("NONE") && flag == true) {
           ans1 = "NONE";
       }

       ans[0] = ans0;
       ans[1] = ans1;
       return ans;
   }








// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			BinaryCodeHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				BinaryCodeHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class BinaryCodeHarness {
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

	static boolean compareOutput(String[] expected, String[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (!expected[i].equals(result[i])) return false; return true; }

	static String formatResult(String[] res) {
		String ret = "";
		ret += "{";
		for (int i=0; i<res.length; ++i) {
			if (i > 0) ret += ",";
			ret += String.format(" \"%s\"", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, String[] expected, String[] received) {
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
			String message            = "123210122";
			String[] expected__       = { "011100011",  "NONE" };

			return verifyCase(casenum__, expected__, new BinaryCode().decode(message));
		}
		case 1: {
			String message            = "11";
			String[] expected__       = { "01",  "10" };

			return verifyCase(casenum__, expected__, new BinaryCode().decode(message));
		}
		case 2: {
			String message            = "22111";
			String[] expected__       = { "NONE",  "11001" };

			return verifyCase(casenum__, expected__, new BinaryCode().decode(message));
		}
		case 3: {
			String message            = "123210120";
			String[] expected__       = { "NONE",  "NONE" };

			return verifyCase(casenum__, expected__, new BinaryCode().decode(message));
		}
		case 4: {
			String message            = "3";
			String[] expected__       = { "NONE",  "NONE" };

			return verifyCase(casenum__, expected__, new BinaryCode().decode(message));
		}
		case 5: {
			String message            = "12221112222221112221111111112221111";
			String[] expected__       = { "01101001101101001101001001001101001",  "10110010110110010110010010010110010" };

			return verifyCase(casenum__, expected__, new BinaryCode().decode(message));
		}

		// custom cases

/*      case 6: {
			String message            = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new BinaryCode().decode(message));
		}*/
/*      case 7: {
			String message            = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new BinaryCode().decode(message));
		}*/
/*      case 8: {
			String message            = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new BinaryCode().decode(message));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
