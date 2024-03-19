import sys

N = int(sys.stdin.readline().rstrip())
paper = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

cnt_white,cnt_blue = 0, 0

def dfs(x,y,n):

    global cnt_white,cnt_blue

    for i in range(x,x+n):
        for j in range(y,y+n):
            if paper[i][j] != paper[x][y]:
                dfs(x,y,n//2)
                dfs(x+n//2, y, n // 2)
                dfs(x,y+n//2,n//2)
                dfs(x + n // 2, y+n//2, n // 2)
                return

    if paper[x][y] == 0:
        cnt_white += 1
    else:
        cnt_blue += 1

dfs(0,0,N)
print(cnt_white,cnt_blue,sep='\n')
