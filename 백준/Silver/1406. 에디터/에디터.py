import sys

moonja = sys.stdin.readline().rstrip()
command_cnt = int(sys.stdin.readline().rstrip())

left_stack = list(moonja)
right_stack = []

for _ in range(command_cnt):
    command_line = list(sys.stdin.readline().split())

    if command_line[0] == 'L' and left_stack:
        right_stack.append(left_stack.pop())
    elif command_line[0] == 'D' and right_stack:
        left_stack.append(right_stack.pop())
    elif command_line[0] == 'B' and left_stack:
        left_stack.pop()
    elif command_line[0] == 'P':
        left_stack.append(command_line[1])

res = left_stack + right_stack[::-1]
print("".join(res))
