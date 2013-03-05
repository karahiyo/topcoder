import java.math.*;
import java.util.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class TimeTravellingGardener {
    static void debug(Object... os) {
    }
    double EPS=1e-11;
    public int determineUsage(int[] distance,  int[] height) {
        int n=height.length;
        double[] xs=new double[n];
        for(int i=0;i<n-1;i++)
            xs[i+1] = xs[i] + distance[i];
        int res=n-1;
        for (int i=0; i<n; i++)
            for (int j=i+1;j<n;j++) {
                int cnt = n;
                for (int k=0;k<n;k++) {
                    double tx = height[i]+(xs[k]-xs[i])/(xs[j]-xs[i])*(height[j]-height[i]);
                    if (tx<-EPS)cnt=100;
                    if (tx>height[k]+EPS) cnt =100;
                    if (tx>height[k]-EPS) cnt--;
                }
                res=min(res, cnt);
            }
        return res;
    }
}
