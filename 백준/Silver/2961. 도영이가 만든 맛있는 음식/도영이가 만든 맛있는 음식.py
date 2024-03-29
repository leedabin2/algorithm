import sys

N = int(sys.stdin.readline().rstrip())

mat = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

cooks = 1e9

def recur(idx,sin,sson,use):
    global cooks

    if idx == N:
        if use == 0:
            return

        cook = abs(sin - sson)
        cooks = min(cook, cooks)
        return

    recur(idx+1,sin*mat[idx][0],sson+mat[idx][1],use+1)
    recur(idx+1,sin,sson,use)

recur(0,1,0,0)

print(cooks)

