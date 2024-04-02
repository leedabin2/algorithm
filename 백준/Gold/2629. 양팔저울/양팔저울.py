import sys

N = int(sys.stdin.readline().rstrip())
chu = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
balls = list(map(int, sys.stdin.readline().split()))

dp = [[0] * (50001) for _ in range(N + 1)]
dp[0][0] = 1

def recur():
    for i in range(1, N + 1):
        for j in range(50001):
            if dp[i - 1][j]:
                dp[i][j + chu[i - 1]] = 1 # 왼
                dp[i][abs(j - chu[i - 1])] = 1# 오
                dp[i][j] = 1 # 안씀
recur()

for ball in balls:
    if ball <= 50001 and dp[N][ball]:
        print('Y', end=' ')
    else:
        print('N', end=' ')
