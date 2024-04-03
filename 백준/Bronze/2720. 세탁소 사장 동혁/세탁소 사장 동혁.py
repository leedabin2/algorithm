import sys


T = int(sys.stdin.readline().rstrip())
coins = [25,10,5,1]

for _ in range(T):
    C = int(sys.stdin.readline().rstrip())

    cnt = 0
    for coin in coins:
        cnt = C // coin
        print(cnt, end=' ')
        C %= coin# 남은 거스름돈
