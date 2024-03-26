import sys
from collections import deque

R, S = map(int, sys.stdin.readline().split())
graph = [list(map(str, sys.stdin.readline().rstrip())) for _ in range(R)]

direction = [(-1, 0), (1, 0), (0, 1), (0, -1)]

def to_escape():
    q_flood = deque()
    q_gosum = deque()


    for i in range(R):
        for j in range(S):
            if graph[i][j] == '*':
                q_flood.append((i, j, 0))

    for i in range(R):
        for j in range(S):
            if graph[i][j] == 'S':
                q_gosum.append((i, j, 0))

    while q_gosum:
        # 물의 위치 확장
        for _ in range(len(q_flood)):
            x, y, time = q_flood.popleft()
            for nx, ny in direction:
                next_x, next_y = nx + x, ny + y
                if 0 <= next_x < R and 0 <= next_y < S and graph[next_x][next_y] == '.':
                    graph[next_x][next_y] = '*'
                    q_flood.append((next_x, next_y, time + 1))

        for _ in range(len(q_gosum)):
            go_x, go_y, time = q_gosum.popleft()
            for nx, ny in direction:
                go_next_x, go_next_y = nx + go_x, ny + go_y
                if 0 <= go_next_x < R and 0 <= go_next_y < S and graph[go_next_x][go_next_y] != 'X' and graph[go_next_x][go_next_y] != '*' and graph[go_next_x][go_next_y] != 'S':
                    if graph[go_next_x][go_next_y] == 'D':
                        return time + 1
                    graph[go_next_x][go_next_y] = 'S'
                    q_gosum.append((go_next_x, go_next_y, time + 1))

    return "KAKTUS"  

print(to_escape())
