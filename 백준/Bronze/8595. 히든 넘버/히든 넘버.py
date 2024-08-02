import sys

n = int(sys.stdin.readline().rstrip())
words = sys.stdin.readline()

ans = ''
total = 0
for i in words:
    if i.isdigit():
        ans += i
    else:
        if ans:
            total += int(ans)
            ans = ''

print(total)