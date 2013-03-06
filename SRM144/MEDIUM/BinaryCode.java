public class BinaryCode {
   public String[] decode(String message) {
       String[] result = new String[2];
       char[] messageChar = message.toCharArray();
       result[0] = this.fixedDecode(0,messageChar);
       result[1] = this.fixedDecode(1,messageChar);
       return result;
   }

   public String fixedDecode(int pzero, char[] messageChar) {
       int[] decodeNum = new int[messageChar.length+1];
       decodeNum[0] = 0;
       for (int i=0;i<messageChar.length;i++) {
           if(i==0)
               decodeNum[i+1] = pzero;
           else {
               decodeNum[i+1] = messageChar[i-1] -'0'-decodeNum[i]-decodeNum[i-1];
               if(decodeNum[i+1] !=0 && decodeNum[i+1] != 1)
                   return "NONE";
           }
       }
       int lastIndex = messageChar.length-1;
       int lastTest = messageChar[lastIndex] - '0';
       if(lastTest==(decodeNum[lastIndex+1] + decodeNum[lastIndex]))
           return this.intArrayToStr(decodeNum);
       else
           return "NONE";
   }

   public String intArrayToStr(int[] intArray) {
       String arrayStr="";
       for(int i=1;i<intArray.length;i++) {
           arrayStr += intArray[i];
       }
       return arrayStr;
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
