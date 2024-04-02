import sys
import heapq

N = int(sys.stdin.readline().rstrip())
cupramen = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
cupramen.sort(key=lambda x : x[0])

q= []
for deadline,cup in cupramen:
    heapq.heappush(q,cup) # 마감일까지 먹을 수 있는 컵라면

    if len(q) > deadline:  # 마감일을 넘어선 컵라면 제거
        heapq.heappop(q)
print(sum(q))