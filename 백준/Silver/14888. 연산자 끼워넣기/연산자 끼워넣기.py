import sys

N = int(sys.stdin.readline().rstrip())
A = list(map(int,sys.stdin.readline().split()))
plus, minus, mul, div = map(int,sys.stdin.readline().split())

max_res = -10000000000
min_res = 10000000000

def dfs(idx,num,plus,minus,mul,div):
    global max_res,min_res

    if idx == N:
        max_res = max(max_res,num)
        min_res = min(min_res,num)
        return
    nxt_num = A[idx]

    if plus > 0:
        dfs(idx+1,num+nxt_num,plus-1,minus,mul,div)
    if minus > 0:
        dfs(idx+1,num-nxt_num,plus,minus-1,mul,div)
    if mul > 0:
        dfs(idx+1,num*nxt_num,plus,minus,mul-1,div)
    if div > 0:
        if num < 0 and nxt_num > 0:
            change_num = -(abs(num)//nxt_num)
            dfs(idx + 1, change_num, plus, minus, mul, div - 1)
        else:
            dfs(idx+1,num//nxt_num,plus,minus,mul,div-1)


dfs(1,A[0],plus,minus,mul,div)
print(max_res)
print(min_res)