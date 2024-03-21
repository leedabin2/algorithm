import sys

N = int(sys.stdin.readline().rstrip())

stack = []

for _ in range(N):
    a = list(sys.stdin.readline().split())

    if a[0] == 'push':
        stack.append(a[1])
    elif a[0] == 'pop':
        print(-1 ) if len(stack) == 0 else print(stack.pop())
    elif a[0] == 'size':
        print(len(stack))
    elif a[0] == 'empty':
        print(1) if len(stack) == 0 else print(0)
    else:
        print(-1) if len(stack) == 0 else print(stack[-1])