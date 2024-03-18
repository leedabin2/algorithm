import sys
n = int(sys.stdin.readline())

map_city = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]

visited = [False] * n
min_cost = float("INF")

# 모든 depth를 한 번씩만 방문 / 출발도시로 돌아오는 경로 고려
def dfs(city, path, cost):
    global min_cost

    # 모든 도시를 방문했을 경우
    if len(path) == n:
        # 출발 도시로 돌아가는 비용 추가
        return_cost = map_city[city][path[0]]
        if return_cost > 0:
            min_cost = min(min_cost, cost + return_cost)
        return

    for next_city in range(n):
        # 방문하지 않았고, 이동할 수 있는 경우
        if not visited[next_city] and map_city[city][next_city] > 0:
            visited[next_city] = True
            dfs(next_city, path + [next_city], cost + map_city[city][next_city])
            visited[next_city] = False


# 각 도시마다 방문
for i in range(n):
    visited[i] = True
    dfs(i,[i],0)
    visited[i] = False

print(min_cost)