import sys
from collections import deque

N, M = map(int,sys.stdin.readline().split())
graph = []

for _ in range(N):
    num = list(map(int,sys.stdin.readline().rstrip()))
    graph.append(num)


direction = [(-1,0),(1,0),(0,-1),(0,1)]
def bfs(x,y):
    q = deque()
    q.append((x,y))

    while q:
        x,y = q.popleft()

        for i in range(4):
            # 이동할 다음 위치
            next_x = x + direction[i][0]
            next_y = y + direction[i][1]

            if next_x < 0 or next_x >= N or next_y < 0 or next_y >= M:
                continue
            if graph[next_x][next_y] == 0:
                continue
            if graph[next_x][next_y] == 1:
                graph[next_x][next_y] = graph[x][y] + 1
                q.append((next_x,next_y))

    return graph[N-1][M-1]

print(bfs(0,0))