import sys
sys.setrecursionlimit(10**6)
# 부모의 노드를 찾을 때는 전위순회를 이용
N = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(N+1)]
parent = [ 0 for _ in range(N+1)]

for _ in range(N-1):
    a, b = map(int,sys.stdin.readline().split())
    # 양방향
    graph[a].append(b)
    graph[b].append(a)

def dfs(node,prv):

    parent[node] = prv

    for nxt in graph[node]:
        if nxt == prv:
            continue
        dfs(nxt,node)

dfs(1,0)

for i in parent[2:]:
    print(i)