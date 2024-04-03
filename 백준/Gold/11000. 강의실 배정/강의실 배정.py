import heapq
import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())

classroom = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
classroom.sort(key=lambda x: x[0])

q = []
heapq.heappush(q,classroom[0][1])

for i in range(1,len(classroom)):
    if q[0] > classroom[i][0]: # 끝나는 시간보다 시작시간이 빠르면
        heapq.heappush(q,classroom[i][1]) # 새로운 회의실
    else:
        heapq.heappop(q) # 강의실 안 써도 되는 경우
        heapq.heappush(q,classroom[i][1])
        
print(len(q))