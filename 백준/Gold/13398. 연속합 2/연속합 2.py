import sys

n = int(sys.stdin.readline().rstrip())
number = list(map(int,sys.stdin.readline().split()))

dp1 = [0] * n
dp2 = [0] * n

dp1[0] = number[0]
dp2[0] = float('-inf')

for i in range(1,n):
    dp1[i] = max(dp1[i-1]+ number[i], number[i])
    dp2[i] = max(dp2[i-1]+ number[i], dp1[i-1])

print(max(max(dp1),max(dp2)))