public class Fib {
    static int memo[] = new int[101];

    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        System.out.print(solve(N));
    }
    public static int solve(int n) {
        if (memo[n] > 0)
            return memo[n];
        if(n<=1)
            return 1;

        memo[n] = solve(n-1)+solve(n-2);
        return memo[n];
    }
}
