import sys

N = int(sys.stdin.readline().rstrip())

score = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

for i in score:
    i.sort()
    if i[3] - i[1] >= 4:
        print("KIN")
    else:
        print(sum(i[1:4]))
