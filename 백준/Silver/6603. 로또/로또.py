import sys
from itertools import combinations


def lotto(n):
    for i in combinations(n,6):
        result = " ".join(map(str,i))
        print(result)



while True:
    test = list(map(int,sys.stdin.readline().split()))
    if test[0] == 0:
        break
    lotto(test[1:])
    print()