import java.util.*;
import java.lang.Math;

public class MazeMaker {
    public int longestPath(String[] maze, int startX, int startY, int[] moveRow, int[] moveCol) {
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();

        qx.add(startX);
        qy.add(startY);

        int maxRow = maze[0].length();
        int maxCol = maze.length;

        int[][] table = new int[maxCol][maxRow];
        for(int i=0;i<maxCol;i++)
            for(int j=0;j<maxRow;j++) {
                table[i][j] = -1;
            }

        table[startY][startX] = 0;

        while(!qx.isEmpty()) {
            System.err.print(qx+":"+qy+"   => ");
            int tx = qx.poll();
            int ty = qy.poll();
            System.err.print(table[ty][tx]+"\n");
            if(maze[ty].charAt(tx) == 'X')
                continue;

            for(int n=0;n<moveRow.length;n++) {
                int nextX = tx + moveRow[n];
                int nextY = ty + moveCol[n];
                if( nextX < 0 || nextX >= maxRow ||
                        nextY < 0 || nextY >= maxCol ||
                        table[nextY][nextX] != -1) continue;

                if(maze[nextY].charAt(nextX) == 'X')
                    continue;
                else {//ミチのマス発見
                    table[nextY][nextX] = table[ty][tx] + 1;
                    qx.add(nextX);
                    qy.add(nextY);
                }
            }
        }

        int ret = 0;
        for(int i=0;i<maxCol;i++) {
            for(int j=0;j<maxRow;j++) {
                if(maze[i].charAt(j) == 'X')
                    continue;
                if(table[i][j] == -1)
                    return -1;
                else
                    ret = Math.max(ret, table[i][j]);
            }
        }

        return ret;

    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            MazeMakerHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                MazeMakerHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class MazeMakerHarness {
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
                        String[] maze             = {"...",
                            "...",
                            "..."};
                        int startRow              = 0;
                        int startCol              = 1;
                        int[] moveRow             = {1,0,-1,0};
                        int[] moveCol             = {0,1,0,-1};
                        int expected__            = 3;

                        return verifyCase(casenum__, expected__, new MazeMaker().longestPath(maze, startRow, startCol, moveRow, moveCol));
            }
            case 1: {
                        String[] maze             = {"...",
                            "...",
                            "..."};
                        int startRow              = 0;
                        int startCol              = 1;
                        int[] moveRow             = {1, 0, -1, 0, 1, 1, -1, -1};
                        int[] moveCol             = {0, 1, 0, -1, 1, -1, 1, -1};
                        int expected__            = 2;

                        return verifyCase(casenum__, expected__, new MazeMaker().longestPath(maze, startRow, startCol, moveRow, moveCol));
            }
            case 2: {
                        String[] maze             = {"X.X",
                            "...",
                            "XXX",
                            "X.X"};
                        int startRow              = 0;
                        int startCol              = 1;
                        int[] moveRow             = {1, 0, -1, 0};
                        int[] moveCol             = {0, 1, 0, -1};
                        int expected__            = -1;

                        return verifyCase(casenum__, expected__, new MazeMaker().longestPath(maze, startRow, startCol, moveRow, moveCol));
            }
            case 3: {
                        String[] maze             = {".......",
                            "X.X.X..",
                            "XXX...X",
                            "....X..",
                            "X....X.",
                            "......."};
                        int startRow              = 5;
                        int startCol              = 0;
                        int[] moveRow             = {1, 0, -1, 0,-2, 1};
                        int[] moveCol             = {0, -1, 0, 1, 3, 0};
                        int expected__            = 7;

                        return verifyCase(casenum__, expected__, new MazeMaker().longestPath(maze, startRow, startCol, moveRow, moveCol));
            }
            case 4: {
                        String[] maze             = {"......."};
                        int startRow              = 0;
                        int startCol              = 0;
                        int[] moveRow             = {1, 0, 1, 0, 1, 0};
                        int[] moveCol             = {0, 1, 0, 1, 0, 1};
                        int expected__            = 6;

                        return verifyCase(casenum__, expected__, new MazeMaker().longestPath(maze, startRow, startCol, moveRow, moveCol));
            }
            case 5: {
                        String[] maze             = {"..X.X.X.X.X.X."};
                        int startRow              = 0;
                        int startCol              = 0;
                        int[] moveRow             = {2,0,-2,0};
                        int[] moveCol             = {0,2,0,-2};
                        int expected__            = -1;

                        return verifyCase(casenum__, expected__, new MazeMaker().longestPath(maze, startRow, startCol, moveRow, moveCol));
            }

            // custom cases

            /*      case 6: {
                    String[] maze             = ;
                    int startRow              = ;
                    int startCol              = ;
                    int[] moveRow             = ;
                    int[] moveCol             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new MazeMaker().longestPath(maze, startRow, startCol, moveRow, moveCol));
                    }*/
            /*      case 7: {
                    String[] maze             = ;
                    int startRow              = ;
                    int startCol              = ;
                    int[] moveRow             = ;
                    int[] moveCol             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new MazeMaker().longestPath(maze, startRow, startCol, moveRow, moveCol));
                    }*/
            /*      case 8: {
                    String[] maze             = ;
                    int startRow              = ;
                    int startCol              = ;
                    int[] moveRow             = ;
                    int[] moveCol             = ;
                    int expected__            = ;

                    return verifyCase(casenum__, expected__, new MazeMaker().longestPath(maze, startRow, startCol, moveRow, moveCol));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
