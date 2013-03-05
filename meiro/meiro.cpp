#include <cstdio>
#include <queue>

using namespace std;

const int INF = 100000000;

typedef pair<int, int> P;

//char maze[MAX_N][MAX_M+1];
//int N,M;
//int sx, sy;
//int gx, gy;
//int d[MAX_N][MAX_M+1];

int N=10,M=10;
int d[10][10];
int sx = 1, sy = 0;
int gx = 8, gy=9;

char maze[10][10];
void set(){
char str[100] = {
    '#','S','#','#','#','#','#','#','.','#',
    '.','.','.','.','.','.','#','.','.','#',
    '.','#','.','#','#','.','#','#','.','#',
    '.','#','.','.','.','.','.','.','.','.',
    '#','#','.','#','#','.','#','#','#','#',
    '.','.','.','.','#','.','.','.','.','#',
    '.','#','#','#','#','#','#','#','.','#',
    '.','.','.','.','#','.','.','.','.','.',
    '.','#','#','#','#','.','#','#','#','.',
    '.','.','.','.','#','.','.','.','G','#'};
int count=0;
for (int i=0; i<10; i++){
    for (int j=0; j<10; j++){
        printf("(%d,%d):",j,i);
        maze[j][i] = str[count];
        printf("\tmaze=%c\n",maze[j][i]);
        count++;
    }
}
}
            
int dx[4] = {1, 0, -1, 0}, dy[4] = {0, 1, 0, -1};

int bfs() {
    queue<P> que;
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            d[i][j] = INF;
        }
    }
    que.push(P(sx,sy));
    printf("START=(%d,%d)\n",que.front().first,que.front().second);
    d[sx][sy] = 0;

    //キューが空になるまでループ
    while(que.size()) {
        P p = que.front();
        que.pop();
        if(p.first == gx && p.second == gy) break;

        for (int i =0; i<4; i++) {
            int nx = p.first + dx[i], ny = p.second + dy[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < M && maze[nx][ny] != '#' && d[nx][ny] == INF) {
                que.push(P(nx,ny));
                printf("maze==%c,\t",maze[nx][ny]);
                printf("push=>(%d,%d)\tCOUNT=%d\n",nx,ny,d[p.first][p.second]+1);
                d[nx][ny] = d[p.first][p.second] + 1;
            }
        }
    }
    return d[gx][gy];
}

int main() {
    set();
    int res = bfs();
    printf("Anser=%d\n", res);
}

