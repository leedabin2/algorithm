import sys
N, L = map(int,sys.stdin.readline().split())

info = []
for _ in range(N):
  a,b = map(int,sys.stdin.readline().split())
  info.append([a,b])

info.sort()

min_cnt = 0
len_co = 0
for start,end in info:
  if len_co < start:
     len_co = start

  if len_co < end:
    nead_co = (end-len_co + L - 1) // L
    min_cnt += nead_co
    len_co += nead_co * L

print(min_cnt)