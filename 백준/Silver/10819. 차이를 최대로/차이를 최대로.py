import sys
from itertools import permutations

N = int(sys.stdin.readline())
A = list(map(int,sys.stdin.readline().split()))

comp = 0
for i in permutations(A):
    res = 0
    for j in range(N-1):
        res += abs(i[j] - i[j+1])
    comp = max(comp,res)

print(comp)


