import sys,heapq

N = int(sys.stdin.readline().rstrip())

cards = [int(sys.stdin.readline().rstrip()) for _ in range(N)]

heapq.heapify(cards)

ans = 0
while len(cards) > 1:
    A = heapq.heappop(cards)
    B = heapq.heappop(cards)
    ans += A + B
    heapq.heappush(cards,A+B)

print(ans)