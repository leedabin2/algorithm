import sys

N, r, c = map(int,sys.stdin.readline().split())

res = 0
def dfs(x,y,n):
    global res

    # 종료 조건
    if x > r or x+n <= r or y > c or y+n <= c:
        res += n**2
        return res

    if n != 1:
        dfs(x, y, n // 2)
        dfs(x, y + (n // 2), n // 2)
        dfs(x + (n // 2), y, n // 2)
        dfs(x + (n // 2), y + (n // 2), n // 2)

    else:
        if x == r and y == c:
            print(res)
        elif x == r and y+1 == c:
            print(res+1)
        elif x+1 == r and y == c:
            print(res + 2)
        else:
            print(res + 3)

dfs(0,0,2**N)