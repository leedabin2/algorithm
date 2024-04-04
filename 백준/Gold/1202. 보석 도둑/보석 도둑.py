import heapq
import sys

N, K = map(int,sys.stdin.readline().split())

q = [ list(map(int,sys.stdin.readline().split())) for _ in range(N)]
q.sort()

bags = [int(sys.stdin.readline()) for _ in range(K)]
bags.sort()

ans = 0
res = []
for bag_weight in bags:
    while q and q[0][0] <= bag_weight:
        heapq.heappush(res, -q[0][1])
        heapq.heappop(q)
    if res:
        ans += -heapq.heappop(res)


print(ans)



