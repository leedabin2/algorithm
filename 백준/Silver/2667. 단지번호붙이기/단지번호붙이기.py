from collections import deque

def bfs(x, y, grid, visited, N):
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    queue = deque([(x, y)])
    visited[x][y] = True
    count = 0

    while queue:
        count += 1
        cur_x, cur_y = queue.popleft()
        for dx, dy in directions:
            nx, ny = cur_x + dx, cur_y + dy
            if 0 <= nx < N and 0 <= ny < N and grid[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny))

    return count

def find_complexes(grid):
    N = len(grid)
    visited = [[False] * N for _ in range(N)]
    complexes = []
    for i in range(N):
        for j in range(N):
            if grid[i][j] == 1 and not visited[i][j]:
                size = bfs(i, j, grid, visited, N)
                complexes.append(size)
    return complexes


N = int(input())
grid = []
for _ in range(N):
    row = list(map(int, input().rstrip()))
    grid.append(row)


complexes = find_complexes(grid)

complexes.sort()
print(len(complexes))
for size in complexes:
    print(size)
