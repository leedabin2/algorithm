import heapq
import sys

n = int(sys.stdin.readline().rstrip())

q = []
for _ in range(n):
    house, office = map(int,sys.stdin.readline().split())
    # if abs(house - office) <= d:  # d 이내인 경우만 고려
    heapq.heappush(q, (min(house, office), max(house, office)))

d = int(sys.stdin.readline().rstrip())

# d, 집 위치를 기준으로 정렬
q.sort(key=lambda x: (x[1], x[0]))

cnt = 0
max_cnt = 0
heap = []

for house, office in q:
    heapq.heappush(heap, house)
    while heap and heap[0] < office - d:
        heapq.heappop(heap)
    max_cnt = max(max_cnt, len(heap))

print(max_cnt)