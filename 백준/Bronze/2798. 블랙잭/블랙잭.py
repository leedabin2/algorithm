import sys
from itertools import combinations

N, M = map(int,sys.stdin.readline().split())

cards = list(map(int,sys.stdin.readline().split()))

max_card = [sum(i) for i in combinations(cards,3) if sum(i) <= M]

print(max(max_card))