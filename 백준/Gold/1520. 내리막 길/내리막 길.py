import sys

M,N = map(int,sys.stdin.readline().split())

graph = [list(map(int,sys.stdin.readline().split())) for _ in range(M)]
dp = [[-1 for _ in range(N)]for _ in range(M)]
def recur(x,y):

    if x == M-1 and y == N-1:
        return 1

    if dp[x][y] != -1:
        return dp[x][y]

    route = 0
    for nx,ny in [[-1,0],[1,0],[0,-1],[0,1]]:
        next_x,next_y = nx + x,ny + y

        if 0 <= next_x < M and 0 <= next_y < N:
            if graph[x][y] > graph[next_x][next_y]: # 작은 경우에만
                route += recur(next_x,next_y) # 리턴한 값을 더해서 가져옴
    dp[x][y] = route
    return dp[x][y]

print(recur(0,0))
