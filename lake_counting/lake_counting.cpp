#include <cstdio>
#include <queue>

// Lake Counting
// POJ No.2386

using namespace std;


int N=6, M=6;
char field[6][7];

char str[]={
    'W','.','.','W','.','.',
    '.','.','W','.','.','W',
    'W','W','W','W','W','W',
    'W','.','W','.','.','.',
    '.','.','W','.','W','.',
    'W','.','.','.','.','W'};
int count = 0;
void set() {
for (int i=0; i<N; i++) {
    for (int j=0; j<M; j++) {
        field[i][j] = str[count];
            count++;
    }
}
}

// 現在位置
void dfs(int x, int y) {
    //現在位置を.に置き換える
    field[x][y] = '.';

    // 移動する8方向をループ
    for (int dx=-1; dx <= 1; dx++) {
        for (int dy = -1; dy <= 1; dy++) {
            // x方向にdx、y方向にdy移動した場所を(nx, ny)とする
            int nx = x + dx, ny = y + dy;

            //nxとnyが庭の範囲内かどうかとfield[nx][ny]が水たまりかどうかを判定
            if (0 <= nx && nx < N && 0 <= ny && ny < M && field[nx][ny] =='W') dfs(nx, ny);
        }
    }
    return ;
}

int main() {
    set();
    int res = 0;
    for (int i=0; i < N; i++) {
        for(int j=0; j < M; j++) {
            if(field[i][j] == 'W') {
                dfs(i , j);
                res++;
            }
        }
    }
    printf("%d\n", res);
    return 0;
}
