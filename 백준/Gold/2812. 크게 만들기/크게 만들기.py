import sys

N, K = map(int,sys.stdin.readline().split())

lst = list(sys.stdin.readline().rstrip())
lst_to_int = list(map(int,lst))

stack = []

for i in range(N):
    while stack and stack[-1] < lst_to_int[i] and K > 0:
            # stack의 가장 큰 숫자를 앞쪽에 위치하기 위해
            stack.pop()
            K -= 1
    stack.append(lst_to_int[i])

# k개 만큼 못지웠을 경우
if K > 0:
    print(''.join([str(i) for i in stack[:-K]]))
else:
    print(''.join([str(i) for i in stack]))