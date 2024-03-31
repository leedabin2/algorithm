import sys

N = int(sys.stdin.readline().rstrip())

meetings = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
meetings.sort(key=lambda x: (x[1],x[0]))

cnt = 0
new_end = 0

for start,end in meetings:
    if start >= new_end:
        cnt += 1
        new_end = end

print(cnt)