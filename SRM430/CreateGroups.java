import java.util.*;
import java.util.regex.*;
import java.math.*;
import java.text.*;
import java.io.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class CreateGroups  {
    public int minChanges(int[] groups,  int minSize,  int maxSize) {
        int mc_a=0, mc_b = 0;

        // 解決可能か判定
        int students_num = 0;
        for (int i=0,j=groups.length;i<j;i++)
            students_num += groups[i];
        // 解決不能の場合は-1をreturn
        if (groups.length * maxSize < students_num)
            return -1;
        if (groups.length * minSize > students_num)
            return -1;

        for (int i=0, j=groups.length;i<j;i++) {
            if (groups[i] < minSize)
                mc_a += minSize - groups[i];
            else if (groups[i] > maxSize)
                mc_b += groups[i] - maxSize;
        }

        return Math.max(mc_a,  mc_b);
    }
}
