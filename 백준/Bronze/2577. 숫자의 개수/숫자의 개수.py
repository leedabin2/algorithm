import sys
from math import prod

n = [int(sys.stdin.readline()) for _ in range(3)]

# 리스트의 모든 요소를 곱하기
mult = prod(n)

line = list(map(int,str(mult)))

for i in range(10):
    print(line.count(i))
