import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())

queue = deque()
for _ in range(N):
    command = sys.stdin.readline().split()

    if command[0] == "push":
        queue.append(command[1])
    elif command[0] == "pop":
        print(-1) if not queue else print(queue.popleft())
    elif command[0] == "size":
        print(len(queue))
    elif command[0] == "empty":
        print(1) if not queue else print(0)
    elif command[0] == "front":
        print(-1) if not queue else print(queue[0])
    else:
        print(-1) if not queue else print(queue[-1])