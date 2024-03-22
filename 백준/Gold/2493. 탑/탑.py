import sys
N = int(sys.stdin.readline().rstrip())

tops = list(map(int,sys.stdin.readline().split()))

stack = []
for i in range(N):
    while len(stack) != 0 and tops[stack[-1]] < tops[i]:
        stack.pop()

    if len(stack) == 0:
        print(0, end=' ')
    else:
        print(stack[-1] + 1, end=' ')

    stack.append(i)