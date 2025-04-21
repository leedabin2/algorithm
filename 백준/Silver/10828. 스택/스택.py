import sys

N = int(sys.stdin.readline().rstrip())
stack = []
for _ in range(N):
    cmd = sys.stdin.readline().split()
    if cmd[0] == 'push':
        x = int(cmd[1])
        stack.append(x)
    if cmd[0] == 'pop':
        if not stack:
            print(-1)
        else:
            print(stack.pop())
    if cmd[0] == 'size':
        print(len(stack))
    if cmd[0] == 'empty':
        if not stack:
            print(1)
        else:
            print(0)
    if cmd[0] == 'top':
        if not stack:
            print(-1)
        else:
            print(stack[-1])

