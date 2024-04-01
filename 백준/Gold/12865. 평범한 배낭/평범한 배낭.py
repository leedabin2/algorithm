import sys

# 물건의 수와 배낭의 무게(탑다운)
N, K = map(int, sys.stdin.readline().split())

items = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

dp = [ [-1 for _ in range(K+1)] for _ in range(N)]

def recur(idx,weight):

    if weight > K:
        return float('-inf')

    if idx == N:
        return 0

    if dp[idx][weight] != -1:
        return dp[idx][weight]

    # 가방에 넣을 수 있는 경우와 넣지 못하는 것 중 큰 거
    dp[idx][weight] = max(recur(idx+1,weight +items[idx][0])+ items[idx][1],recur(idx+1,weight))
    return dp[idx][weight]

print(recur(0,0))
