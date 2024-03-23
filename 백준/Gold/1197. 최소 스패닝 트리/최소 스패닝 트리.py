import heapq
import sys

N,M = map(int,sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]
visited = [0] * (N+1)

for _ in range(M):
    A,B,C = map(int,sys.stdin.readline().split())
    graph[A].append([C,B])
    graph[B].append([C,A])

q = [[0,1]]

ans = 0
res = 0
while q:
    
    if res == N:
        break
        
    weight,node = heapq.heappop(q)

    if visited[node] == 0:
        visited[node] = 1
        ans += weight
        res += 1

        for nxt in graph[node]:
            heapq.heappush(q,nxt)

print(ans)