import sys,heapq

N = int(sys.stdin.readline().rstrip())

h = []
res = []
for _ in range(N):
    x = int(sys.stdin.readline().rstrip())
    if x != 0:
        heapq.heappush(h,-x)
    else:
        if h:
            print(-heapq.heappop(h))
        else:
            print(0)