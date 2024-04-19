import sys

N = int(sys.stdin.readline().rstrip())
mountain = list(map(int,sys.stdin.readline().split()))

max_mountain = 0
cnt = 0
ans = []
for i in mountain:
    if i > max_mountain:
        max_mountain = i
        cnt = 0
    else:
        cnt += 1
    ans.append(cnt)


print(max(ans))
