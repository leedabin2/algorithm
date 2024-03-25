import heapq
import sys

n = int(sys.stdin.readline().rstrip())

graph = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(n)]


direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def find_min_black_room():

    q = []
    heapq.heappush(q, (0, 0, 0))
    visited = [[0] * n for _ in range(n)]
    broken = [[0] * n for _ in range(n)]

    while q:

        broken_wall, x, y = heapq.heappop(q)

        if x == n-1 and y == n-1:
            return broken_wall

        if not visited[x][y]:
            visited[x][y] = 1

            for dx, dy in direction:
                nx, ny = x + dx, y + dy

                # 미로 범위 내에 있는 경우
                if 0 <= nx < n and 0 <= ny < n:
                    # 벽을 만났을 때
                    if graph[nx][ny] == 0:
                        broken[nx][ny] = 1
                        heapq.heappush(q, (broken_wall+1,nx, ny))

                    else:
                        heapq.heappush(q, (broken_wall,nx, ny))


print(find_min_black_room())
