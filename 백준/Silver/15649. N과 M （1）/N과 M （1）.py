import sys

N, M = map(int,sys.stdin.readline().split())
res = []
visited = [0] * (N+1)
def dfs(idx):
    if idx == M:
        print(' '.join(map(str,res)))
        return

    for i in range(1,N+1):
        if not visited[i]:
            visited[i] = 1
            res.append(i)
            dfs(idx+1)
            res.pop()
            visited[i] = 0
dfs(0)

