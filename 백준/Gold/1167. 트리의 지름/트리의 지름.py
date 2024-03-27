import sys

def dfs(node, cost):
    global max_cost_node, max_cost

    visited[node] = True

    for next_node, next_cost in tree[node]:
        if not visited[next_node]:
            dfs(next_node, cost + next_cost)

    if cost > max_cost:
        max_cost_node = node
        max_cost = cost


V = int(input())
tree = [[] for _ in range(V + 1)]

for _ in range(V):
    data = list(map(int, input().split()))
    node = data[0]
    for i in range(1, len(data) - 1, 2):
        tree[node].append((data[i], data[i + 1]))

visited = [False] * (V + 1)
max_cost_node = 0
max_cost = 0
dfs(1, 0)

visited = [False] * (V + 1)
max_cost = 0
dfs(max_cost_node, 0)

print(max_cost)