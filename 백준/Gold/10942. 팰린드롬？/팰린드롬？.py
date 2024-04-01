import sys


N = int(sys.stdin.readline().rstrip())
board = list(map(int,sys.stdin.readline().split()))
M = int(sys.stdin.readline().rstrip())
question = [list(map(int,sys.stdin.readline().split())) for _ in range(M)]

dp = [[0] * (N+1) for _ in range(N+1)]

# 길이가 1인 경우
for i in range(1,N+1):
    dp[i][i] = 1

# 길이가 2인 경우
for i in range(1,N):
    if board[i-1] == board[i]:
        dp[i][i+1] = 1

# 길이가 3 이상인 경우
for i in range(3,N+1):
    for start in range(1,N-i+2):
        end = start+i-1
        if board[start-1] == board[end-1] and dp[start+1][end-1]:
            dp[start][end] = 1


for start,end in question:
    print(dp[start][end],sep='\n')