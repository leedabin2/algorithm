import heapq
import sys

N = int(sys.stdin.readline().rstrip())

# 양수와 음수, 0과 1을 분리하기
plus = [] # 최대힙
minus = [] # 최소힙
res = 0

for _ in range(N):
    nums = int(sys.stdin.readline().rstrip())

    if nums == 1:
        res += nums
    elif nums > 1:
        heapq.heappush(plus,-nums)
    elif nums <= 0:
        heapq.heappush(minus,nums)

# 양수 누적 합
while len(plus) >= 2:
    a = -heapq.heappop(plus)
    b = -heapq.heappop(plus)
    res += a * b
if plus:
    res += -heapq.heappop(plus)

# 음수 누적 합
while len(minus) >= 2:
    a = heapq.heappop(minus)
    b = heapq.heappop(minus)
    res += a * b
if minus:
    res += heapq.heappop(minus)


print(res)


