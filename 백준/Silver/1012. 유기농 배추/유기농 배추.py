import sys
from  collections import  deque

T = int(sys.stdin.readline().rstrip())


def bfs(x, y, graph, N, M):
    graph[x][y] = 2
    directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

    queue = deque()
    queue.append([x,y])

    while queue:
        cur_x, cur_y = queue.popleft()

        for i in range(4):
            dx, dy = directions[i][0], directions[i][1]
            nx, ny = cur_x + dx, cur_y + dy
            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1:
                graph[nx][ny] = 2
                queue.append([nx,ny])


for _ in range(T):
    M, N, K = map(int, sys.stdin.readline().split())
    graph = [[0] * M for _ in range(N)]
    count = 0
    for _ in range(K):
        x, y = map(int, sys.stdin.readline().split())
        graph[y][x] = 1

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                bfs(i, j, graph, N, M)
                count += 1
    print(count)


