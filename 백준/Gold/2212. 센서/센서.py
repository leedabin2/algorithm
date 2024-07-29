import sys

N = int(sys.stdin.readline().rstrip())
K = int(sys.stdin.readline().rstrip())
x = list(map(int,sys.stdin.readline().split()))
x.sort()

dist = []

if K >= N:
    print(0)
else:
    for i in range(1,N):
        dist.append(x[i]-x[i-1])
    dist.sort(reverse=True)

    for _ in range(K-1):
        dist.pop(0)
    print(sum(dist))

