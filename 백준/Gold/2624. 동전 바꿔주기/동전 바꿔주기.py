import sys

T = int(sys.stdin.readline().rstrip())
K = int(sys.stdin.readline().rstrip())

coin_list = [list(map(int,sys.stdin.readline().split())) for _ in range(K)]

dp = [0 for _ in range(T+1)]
dp[0] = 1

for coin,cnt in coin_list:
    for i in range(T,0,-1):
        j = 1
        while j <= cnt and i - (coin * j) >= 0:
            dp[i] += dp[i - (coin * j)]
            j += 1
        # for j in range(1,cnt+1):
        #     if i - (coin * j) >= 0:
        #         dp[i] += dp[i-(coin * j)]

print(dp[T])

