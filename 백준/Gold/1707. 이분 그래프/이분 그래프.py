import sys
from collections import deque

K = int(sys.stdin.readline().rstrip())

def bfs(node,colors):
    q = deque([node])

    while q:
        node = q.popleft()
        next_color = colors[node] % 2 + 1  # 색칠하기
        for nxt in graph[node]:
            if not colors[nxt]:
                colors[nxt] = next_color # 다음 꺼 색칠하기
                q.append(nxt)
            elif colors[nxt] != next_color:
                return False
    return True

res = []
for _ in range(K):
    V, E = map(int,sys.stdin.readline().split())

    graph = [[] for _ in range(V+1)]
    colors = [0] * (V + 1)
    for _ in range(E):
        a,b = map(int,sys.stdin.readline().split())
        graph[a].append(b)
        graph[b].append(a)

    is_bipartite = True
    for i in range(1,V+1):
        if colors[i]: # 색이 칠해져있으면 넘어가고
            continue
        colors[i] = 1

        if not bfs(i, colors):
            res.append("NO")
            is_bipartite = False
            break
    if is_bipartite:
        res.append("YES")

print(*res,sep='\n')