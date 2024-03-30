import sys
sys.setrecursionlimit(10**6)

# 동전의 수와 동전의 가치(탑다운)
N, K = map(int, sys.stdin.readline().split())

coin_value = [int(sys.stdin.readline().rstrip()) for _ in range(N)]

dp = [1e9 for _ in range(K + 1)]
dp[0] = 0

for i in range(1,K+1):
    for coin in coin_value:
        if i-coin >= 0:
            dp[i] = min(dp[i-coin]+1,dp[i]) # dp[i]초기값 1e9, dp[i-coin]+1 이 더 작음

if dp[K] == 1e9:
    print(-1)
else:
    print(dp[K])

