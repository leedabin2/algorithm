import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
calender = [[] for _ in range(n+1)]
for i in range(1,n+1):
    t, p = map(int,input().split())
    calender[i] = [t,p]

max_cost = 0
def bfs(start_day,st,sp):
    global max_cost
    queue = deque()
    queue.append((start_day,sp))

    while queue:
        day, profit = queue.popleft()
        max_cost = max(max_cost, profit)
        if day > n:
            continue
        if day <= n:
            t, p = calender[day]

            if day + t <= n + 1:
                queue.append((day+t, profit + p))

            queue.append((day+1,profit))


for i in range(1,n+1):
    t, p = calender[i]
    bfs(i,0,0)

print(max_cost)



