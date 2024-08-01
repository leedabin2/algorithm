import sys

N = int(sys.stdin.readline().rstrip())

if N == 1:
    print('')

ans = []
while N != 1:
    for i in range(2,N+1):
        if N % i == 0:
            ans.append(i)
            N //= i
            break
for i in ans:
    print(i)
