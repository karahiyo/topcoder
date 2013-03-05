/*
 * Author: KARAHIYO
 */
import java.util.*;
import java.util.regex.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.lang.Integer;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class BitwiseEquations {
    public static long kthPlusOrSolution(int x,  int k) {

        int i=0;
        int j=0;
        int ans=0;
        long K=k;
        while (k > ans ) {
            long atOne = x&1;
            if (atOne==0) {
                j++;
                long atOne_2 = K&1;
                if (1==atOne_2){
                    ans += pow(2, i);
                }
                K=K>>1;
            }
            x= x>>1;
            i++;
        }
        return ans;
    }
}


