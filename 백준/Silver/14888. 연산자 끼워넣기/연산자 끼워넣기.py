import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
A = list(map(int,sys.stdin.readline().split()))
plus, minus, mul, div = map(int,sys.stdin.readline().split())

queue = deque()
queue.append([A[0],plus,minus,mul,div,1])

max_res = -10000000000
min_res = 10000000000

while queue:
    num, plus, minus, mul, div, depth = queue.popleft()

    if depth == N:
        max_res = max(max_res,num)
        min_res = min(min_res,num)
        continue

    next_num = A[depth]

    if plus > 0:
        queue.append([num+next_num, plus-1,minus,mul,div,depth+1])
    if minus > 0:
        queue.append([num-next_num,plus,minus-1,mul,div,depth+1])
    if mul > 0:
        queue.append([num * next_num, plus, minus, mul-1, div, depth + 1])
    if div > 0:
        if num < 0 and next_num > 0:
            change_num = -(abs(num) // next_num)
            queue.append([change_num, plus, minus, mul, div-1, depth + 1])
        else:
            queue.append([num // next_num, plus, minus, mul, div-1, depth + 1])

print(max_res)
print(min_res)