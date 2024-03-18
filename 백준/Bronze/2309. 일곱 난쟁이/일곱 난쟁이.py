import sys
from itertools import combinations

num = [int(sys.stdin.readline()) for _ in range(9)]

for i in combinations(num,7):
    if sum(i) == 100:
        print(*sorted(i),sep='\n')
        break