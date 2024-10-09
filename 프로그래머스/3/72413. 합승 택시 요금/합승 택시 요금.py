def solution(n, s, a, b, fares):

    graph = [[2000001] * (n+1) for _ in range(n+1)]
    for i in range(1,n+1):
        graph[i][i] = 0
    
    for f in fares:
        u = f[0]
        w = f[1]
        cost = f[2]
        graph[u][w] = cost
        graph[w][u] = cost
        
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                if graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]

    min_cost = 2000001
    for i in range(1,n+1):
        min_cost = min(min_cost, graph[s][i] + graph[i][a] + graph[i][b])
    return min_cost