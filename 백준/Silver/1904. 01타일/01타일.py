import sys

N = int(sys.stdin.readline().rstrip())

# 끝이 00으로 끝나는 경우 (길이가 N-2)
# 끝이 1로 끝나는 경우 (길이가 N-1)
# dp[n] = dp[n-1] + dp[n-2]

def tile_count(n):
    dp = [0] * 10000001

    dp[1] = 1
    dp[2] = 2
    
    for i in range(3, n + 1):
        dp[i] = (dp[i - 1] + dp[i - 2]) % 15746

    return dp[n]

print(tile_count(N))
