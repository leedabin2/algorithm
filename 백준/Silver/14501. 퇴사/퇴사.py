import sys

# 모든 경우의 수를 탐색하기

N = int(sys.stdin.readline().rstrip())

sangdam = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

dp = [ -1 for _ in range(N+1)]
def recur(idx):
    global dp

    if idx == N:
        return 0

    if idx > N : # 상담할 수 없음(이익을 음수로 반환하여 최대값을 찾을 때 고려되지 않도록)
        return -999999

    if dp[idx] != -1: # 이미 탐색했으면
        return dp[idx]

    # 상담을 받을 수 있는 날 (상담을 시작하는 날짜, 상담에 걸리는 일수만큼 더한 날짜부터 다시 재귀호출)
    dp[idx] = max(recur(idx + sangdam[idx][0]) + sangdam[idx][1], recur(idx+1))

    return dp[idx]

print(recur(0))