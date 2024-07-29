import sys

N = int(sys.stdin.readline().rstrip())
A, B, C = 300,60,10


if N % C != 0:
    print(-1)
else:
    a_count = N // A
    N %= A
    b_count = N // B
    N %= B
    c_count = N // C
    N %= C
    print(a_count,b_count,c_count)