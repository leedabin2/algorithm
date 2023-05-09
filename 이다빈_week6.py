from collections import deque

graph = { 0: set([1]),
          1: set([2,3]),
          2: set([1,3,4]),
          3: set([1,2,4,5]),
          4: set([2,3]),
          5: set([3,6,7]),
          6: set([5,8]),
          7: set([5]),
          8: set([6])
          }
def bfs(graph,root):
    visitied = [] # 방문한 노드
    # 값을 저장할 변수나 자료형 여기서 선언
    result = []
    queue = deque([root])

    while queue: # 큐가 빌때까지
        current = queue.popleft() # 현재노드를 받음
        if current not in visitied: # 방문이 안 됐다면
            visitied.append(current) # 방문입력
            queue += graph[current] - set(visitied) # 원소겹치는 걸 뺌
            # 여기서 방문된 상태

                # 필요한 처리를 해줌 현재 노드를 가지고 필요한 처리 진행
    return visitied  # 탐색한 결과

def dfs(graph,root):
    visitied = []
    stack = [root]

    while stack:
        current = stack.pop()
        if current not in visitied:
            visitied.append(current)
            stack += graph[current] - set(visitied)
            # 방문된 상태에서 문제가 요구하는 처리를 진행

    return visitied

