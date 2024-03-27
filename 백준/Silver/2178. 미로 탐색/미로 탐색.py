import sys
from collections import deque

N, M = map(int,sys.stdin.readline().split())

graph = []

for _ in range(N):
    miro = list(map(int,sys.stdin.readline().rstrip()))
    graph.append(miro)

direction = [[-1,0],[1,0],[0,-1],[0,1]]

def miro(i,j):
    q = deque()
    q.append([i, j])
    while q:

        x,y = q.popleft()

        for nx, ny in direction:
            next_x,next_y = nx + x, ny + y

            if 0 <= next_x < N and 0 <= next_y < M and graph[next_x][next_y] == 1:
                graph[next_x][next_y] = graph[x][y] +1
                q.append([next_x,next_y])
    return graph[N-1][M-1]


print(miro(0,0))
