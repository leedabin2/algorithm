import sys,heapq

N = int(sys.stdin.readline().rstrip())

max_heap = []
min_heap = []

res = []
for i in range(N):
    value = int(sys.stdin.readline().rstrip())

    # 같은 개수라면 무조건 최대힙으로 넣기
    if len(max_heap) == len(min_heap):
        heapq.heappush(max_heap,(-value,value))
    # 개수가 다르면 이전에 최대합에 넣은 것이기 때문에 개수를 맞추기 위해 최소힙에 넣기
    else:
        heapq.heappush(min_heap,(value,value))

    # 대소 조건을 비교
    # 최소 힙의 root(top)이 최대 힙의 top보다 작다면 두 수를 바꿈
    if min_heap and min_heap[0][1] < max_heap[0][1]:
        change_min = heapq.heappop(min_heap)[1]
        change_max = heapq.heappop(max_heap)[1]
        heapq.heappush(max_heap,(-change_min,change_min))
        heapq.heappush(min_heap,(change_max,change_max))

    # 갯수랑 대소 조건을 만족했으면 최대힙의 root가 중앙값
    res.append(max_heap[0][1])

for i in res:
    print(i)