import sys

N = int(sys.stdin.readline().rstrip())

seets = sys.stdin.readline().rstrip()
set_seet = seets.count('LL')


if set_seet == 0:
    print(N)
else:
    print(N+1-set_seet)

