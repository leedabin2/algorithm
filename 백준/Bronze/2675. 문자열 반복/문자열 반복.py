import sys

T = int(sys.stdin.readline().rstrip())

for _ in range(T):
    tests = list(sys.stdin.readline().rstrip().split())

    ans = ''
    for i in tests[1]:
        ans += i * int(tests[0])
    print(ans)

