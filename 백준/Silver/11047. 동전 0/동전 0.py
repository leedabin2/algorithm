import sys

N, K = map(int,sys.stdin.readline().split())

dongjeon_lst = [ int(sys.stdin.readline().rstrip()) for _ in range(N)]
dongjeon_lst.sort(reverse=True)

cnt = 0
for dongjeon in dongjeon_lst:
    cnt += K // dongjeon
    K %= dongjeon # 남은 거스름돈

print(cnt)
