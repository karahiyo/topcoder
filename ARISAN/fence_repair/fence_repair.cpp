#include <iostream>
#include <stdlib.h>

using namespace std;

typedef long long ll;

// 入力
const int MAX_N = 3;
int  N, L[MAX_N];

void solve() {
    ll ans = 0;
    cout << "N = " << N << "\n";
    cout << "L = ";
    for (int i=0; i<N; i++)
        cout << L[i+2] << " ";
    cout << "\n";

    // いたが1本になるまで適用
    while (N > 1) {
        // 一番短いmii1、mii2を求める
        int mii1 = 0, mii2 = 1;
        if (L[mii1] > L[mii2]) swap(mii1, mii2);

        for (int i = 2; i < N; i++) {
            if (L[i] < L[mii1]) {
                mii2 = mii1;
                mii1 = i;
            }
            else if (L[i] < L[mii2]) {
                mii2 = i;
            }
        }

        // それらを併合
        int t = L[mii1] + L[mii2];
        ans += t;

        if (mii1 == N - 1) swap(mii1, mii2);
        L[mii1] = t;
        L[mii2] = L[N - 1];
        N--;
    }

    printf("%lld\n",ans);
}

int main(int argc, char *argv[]) {
    N = atoi(argv[1]);
    for (int i=0; i<N;i++)
        L[i] = atoi(argv[i+2]);
    solve();
}

