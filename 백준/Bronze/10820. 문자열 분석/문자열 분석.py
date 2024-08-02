import sys


while True:
    words = sys.stdin.readline()
    if not words:
        break
    ans = [0, 0, 0, -1]
    for i in words:
        if i.isdigit():
            ans[2] += 1
        elif i.isupper():
            ans[1] += 1
        elif i.islower():
            ans[0] += 1
        else:
            ans[3] += 1

    print(*ans)


