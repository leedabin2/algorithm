import sys

coin = int(sys.stdin.readline().rstrip())

don = 1000 - coin
cnt = 0

for i in [500,100,50,10,5,1]:
    cnt += don // i
    don %= i

print(cnt)
