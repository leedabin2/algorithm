import sys

from collections import deque

N, M = map(int,sys.stdin.readline().split())
indegree = [0] * (N+1)

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a,b =map(int,sys.stdin.readline().split())
    graph[a].append(b)
    indegree[b] += 1

def topology_sort():
    res = []
    q = deque()

    for i in range(1,N+1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()
        res.append(now)
        for i in graph[now]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)

    for i in res:
        print(i,end=' ')
        
topology_sort()