# 3. 2로 계속 나눔 x //2 +1
# 3. 3으로 계속 나눔 x //3 +1
# 4. 3과 2둘다 나누어 떨이지지 않는 경우 : 1을 뺌
from collections import deque
import sys

n = int(sys.stdin.readline())

def bfs(v):
    queue = deque([[v]])
    while queue:
        num = queue.popleft()
        a = num[0]
        if a == 1:  # 1인 경우
            queue.append(num)
            return queue
        if a % 3 == 0:  # n이 3으로 나누어지는 경우
            queue.append([a // 3] + num)
        if a % 2 == 0:  # n이 2로 나누어지는 경우
            queue.append([a // 2] + num)
        queue.append([a - 1] + num)  # 1을 뺌

ans = bfs(n)

new_lst = []
if ans:
    for lst in ans:
        new_lst.append(lst)
def shorts_lst(new_lst):
    shortest = len(new_lst[0])  # 기준 설정
    shortest_lst = []  # 최단 길이를 가진 원소 저장 리스트
    for i in new_lst:
        if len(i) <= shortest and i[0] == 1:
            if len(i) < shortest:
                shortest = len(i) # 기준 재설정
                shortest_lst = [i]
            else:
                shortest_lst.append(i)
    return shortest_lst

shortest_lst = shorts_lst(new_lst)

if shortest_lst:
    print(len(shortest_lst[0]) - 1) # 횟수의 최솟값
    for lst in reversed(shortest_lst[0]): # 길이가 같은 shortest_lst가 있다면 아무거나 하나 출력
        print(lst,end=' ')

# 시간 초과 문제