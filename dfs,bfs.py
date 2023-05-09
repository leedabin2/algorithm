from collections import deque
import sys

n,m = map(int,input().split())

graph = [ [False] * (n+1) for _ in range(n+1)]

for _ in range(m):
    a,b = map(int,input().split())
    graph[a][b] = True
    graph[b][a] = True

visitied = [False] * (n+1) # 방문기록

def dfs(v,end):

    visitied[v] = True
    for i in range(1,n+1):
        if not visitied[i] and graph[v][i]:
            dfs(i)

visitied2 = [False] * (n+1) # bfs 방문기록

def bfs(v):
    queue = deque([v])
    visitied2[v] = True
    while queue:
        v = queue.popleft()
        print(v,end=' ')
        for i in range(1,n+1):
            if not visitied2[i] and graph[v][i]:
                queue.append(i)
                visitied2[i] = True
dfs(0,8)
print(count)
print( )
bfs(0)

# 입력 코드
# 9 13
# 0 1
# 0 3
# 1 3
# 1 2
# 2 3
# 2 4
# 2 5
# 3 4
# 3 5
# 5 6
# 5 7
# 6 8
# 7 8