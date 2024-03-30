import sys

N = int(sys.stdin.readline().rstrip())

sangdam = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

dp = [0 for _ in range(N+1)]

for idx in range(N)[::-1]:
    if idx + sangdam[idx][0] > N:
        dp[idx] = dp[idx+1]
    else:
        dp[idx] = max(dp[idx+sangdam[idx][0]] + sangdam[idx][1],dp[idx+1])

print(max(dp))