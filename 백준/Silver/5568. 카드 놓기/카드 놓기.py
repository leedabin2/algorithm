import sys
from itertools import permutations

# iterable에서 원소 개수가 k개인 순열 뽑기
n = int(sys.stdin.readline().rstrip())
k = int(sys.stdin.readline().rstrip())

card_list = [sys.stdin.readline().rstrip() for _ in range(n)]

new = [''.join(i) for i in permutations(card_list,k)]

print(len(set(new)))


