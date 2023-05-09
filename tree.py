import sys
# 트리의 부모 찾기
n = int(sys.stdin.readline())
graph = [ [False]*(n+1) for _ in range(n+1)]

for _ in range(1,n):
    a,b = map(int,sys.stdin.readline().split())
    graph[a][b] = True
    graph[b][a] = True

visitied = [False] * (n+1)
node_num = {}
def dfs(v):
    global node_num
    visitied[v] = True # 방문 처리
    for i in range(1,n+1):
        if not visitied[i] and graph[v][i]:
            dfs(i)
            # 노드번호의 부모들을 딕셔너리에 삽입
            node_num[i] = v
            #print(f'노드:{i}번의 부모는 {v}')

dfs(1)

dic = dict(sorted(node_num.items()))

for v in dic.values():
    print(v)