import sys
from bisect import bisect_left, bisect_right

N,M = map(int,sys.stdin.readline().split())
search_target = list(map(int,sys.stdin.readline().split()))
search_target.sort()

def cal_count_by_range(search_taget,left_val,right_val):
    r_i = bisect_right(search_taget,right_val)
    l_i = bisect_left(search_taget,left_val)
    return r_i - l_i

for _ in range(M):
    M_start, M_end, = map(int,sys.stdin.readline().split())

    cnt = cal_count_by_range(search_target,M_start,M_end)

    print(cnt)