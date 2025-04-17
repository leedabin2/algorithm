from itertools import combinations
import sys
input = sys.stdin.readline

while True:
    data = list(map(int, input().split()))
    k = data[0]

    if k == 0:
        break

    nums = data[1:]
    for comb in combinations(nums, 6):
        print(*comb)
    print()

