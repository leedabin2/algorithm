import heapq
import sys

M, N, H = map(int, input().split())

graph = []
for depth in range(H):
    box = []
    for _ in range(N):
        tomato_location = list(map(int,sys.stdin.readline().split()))
        box.append(tomato_location)
    graph.append(box)

# 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
directions = [(-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1)]


def search_tomato():
    q = []

    # 익은 토마토 추가
    for h in range(H):
        for i in range(N):
            for j in range(M):
                if graph[h][i][j] == 1:
                    q.append((0,h,i,j))

    while q:

        day, h, x, y = heapq.heappop(q)

        for nh,nx,ny in directions:
            nxt_x = nx + x
            nxt_y = ny + y
            nxt_h = nh + h

            if 0 <= nxt_x < N and 0 <= nxt_y < M and 0 <= nxt_h < H and graph[nxt_h][nxt_x][nxt_y] == 0:
               graph[nxt_h][nxt_x][nxt_y] = day + 1
               q.append((day+1,nxt_h,nxt_x,nxt_y))

    # 익지 않은 상자
    for h in range(H):
        for i in range(N):
            for j in range(M):
                if graph[h][i][j] == 0:
                    return -1

    return day

print(search_tomato())


