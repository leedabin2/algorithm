import sys

N = int(sys.stdin.readline().rstrip())
A, B, C = 300,60,10

a_count,b_count,c_count = 0,0,0

les = N

while les > 0:
    if N >= A:
        les = les-A
        a_count += 1
    elif N % 10 != 0:
        print(-1)
        break
    elif A > les >= B:
        les = les-B
        b_count += 1
    elif B > les >= C:
        les = les-C
        c_count += 1

if a_count or b_count or c_count != 0:
    print(a_count,b_count,c_count)