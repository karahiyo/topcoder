#include <stack>
#include <cstdio>

int n=4;
int a[4]={1,2,4,7};
int k=4;

using namespace std;

bool dfs(int i, int sum) {
    printf("%d\n",sum);
    if (i == n) return sum == k;

    if (dfs(i + 1, sum)) return true;

    if(dfs(i + 1, sum + a[i])) return true;

    return false;
}

int main() {
    if (dfs(0,0)) printf("Yes\n");
    else printf("No\n");
    return 0;
}
