import sys
N = int(sys.stdin.readline())

nums = list(map(int,sys.stdin.readline().split()))
add, sub, mul, div = map(int,sys.stdin.readline().split())

min_num, max_num = int(1e9), int(-1e9)

def dfs(n,sm,add,sub,mul,div):
    global min_num,max_num

    if n == N:
        min_num = min(min_num, sm)
        max_num = max(max_num, sm)
        return

    if add > 0:
        dfs(n+1,sm + nums[n],add-1,sub,mul,div)
    if sub > 0:
        dfs(n+1,sm - nums[n],add,sub-1,mul,div)
    if mul > 0:
        dfs(n + 1, sm * nums[n], add, sub, mul-1, div)
    if div > 0:
        dfs(n+1,int(sm/nums[n]),add,sub,mul,div-1)


dfs(1,nums[0],add,sub,mul,div)

print(max_num, min_num, sep='\n')
