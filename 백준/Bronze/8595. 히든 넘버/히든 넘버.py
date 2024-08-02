import sys

n = int(sys.stdin.readline().rstrip())
words = sys.stdin.readline().rstrip()

ans = ''
total = 0
for i in words:
    if i.isdigit():
        ans += i
    else:
        if ans:
            total += int(ans)
            ans = ''

if ans:
    total += int(ans)
print(total)