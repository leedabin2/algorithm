import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())

graph = []
for _ in range(N):
    draw = list(map(str, sys.stdin.readline().rstrip()))
    graph.append(draw)

direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def bfs(x, y, visited, target):
    q = deque()
    q.append([x, y])

    visited[x][y] = 1

    while q:
        x, y = q.popleft()

        for nx, ny in direction:
            next_x , next_y = x + nx, y + ny

            if 0 <= next_x < N and 0 <= next_y < N and not visited[next_x][next_y] and graph[next_x][next_y] == target:

                visited[next_x][next_y] = 1
                q.append([next_x, next_y])

# 적록색약이 아닌 사람이 봤을 때
def cnt():
    visited = [[0] * N for _ in range(N)]
    count = 0

    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                bfs(i, j, visited, graph[i][j])
                count += 1

    return count

# 적록색약인 사람이 봤을 때
def other_cnt():
    visited = [[0] * N for _ in range(N)]
    count = 0

    for i in range(N):
        for j in range(N):
            if graph[i][j] == 'G':
                graph[i][j] = 'R'

    for x in range(N):
        for y in range(N):

            if not visited[x][y]:
                bfs(x, y, visited, graph[x][y])
                count += 1

    return count

result = cnt()
result2 = other_cnt()
print(result,end=' ')
print(result2)