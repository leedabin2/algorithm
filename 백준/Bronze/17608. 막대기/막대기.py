import sys

N = int(sys.stdin.readline().rstrip())
sticks = [ int(sys.stdin.readline().rstrip()) for _ in range(N)]

cnt = 0
height = 0
for stick in sticks[::-1]:
    if stick > height:
        cnt += 1
        height = stick

print(cnt)
