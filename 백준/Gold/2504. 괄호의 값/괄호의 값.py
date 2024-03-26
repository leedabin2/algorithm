import sys


n = list(map(str,sys.stdin.readline()))

res = 0
stack = []
tmp = 1
for i in range(len(n)):
    if n[i] == "(":
        stack.append("(")
        tmp *= 2
    if n[i] == "[":
        tmp *= 3
        stack.append("[")
    if n[i] == ")":
        if not stack or stack[-1] != "(":
            res = 0
            break
        if n[i-1] == "(":
            res += tmp
        stack.pop()
        tmp //= 2
    if n[i] == "]":
        if not stack or stack[-1] != "[":
            res = 0
            break
        if n[i-1] == "[":
            res += tmp
        stack.pop()
        tmp //= 3

if stack:
  res = 0 

print(res)

