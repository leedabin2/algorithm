import sys

a = int(sys.stdin.readline())
b = int(sys.stdin.readline())

c = [int(a) for a in str(b)]

for i in range(len(c)-1,-1,-1):
    res = c[i] * a
    print(res)

print(a*b)









