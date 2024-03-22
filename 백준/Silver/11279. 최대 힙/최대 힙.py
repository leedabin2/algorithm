import sys,heapq

N = int(sys.stdin.readline().rstrip())

h = []
for _ in range(N):
    x = int(sys.stdin.readline().rstrip())
    if x != 0:
        heapq.heappush(h,-x)
    else:
        print(-heapq.heappop(h)) if h else print(0)
