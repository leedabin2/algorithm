import sys

N = int(sys.stdin.readline())
ans = 0

def dfs(n):
    global ans

    if n == N:
        ans += 1
        return

    for j in range(N):
        if line[j] == right_line[n + j] == left_line[n - j] == 0:
            line[j] = right_line[n + j] = left_line[n - j] = 1
            dfs(n + 1)
            line[j] = right_line[n + j] = left_line[n - j] = 0

line = [0] * N
right_line= [0] * ((2 * N) -1)
left_line= [0] * ((2 * N) -1)
dfs(0)
print(ans)

