from collections import deque

from collections import deque

def solution(board):
    n = len(board)
    # 방향별로 비용을 따로 저장
    # costs[x][y][direction] 형태로 저장
    costs = [[[float('inf')] * 4 for _ in range(n)] for _ in range(n)]
    for i in range(4):
        costs[0][0][i] = 0
    
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]  # 동남서북
    q = deque([(0, 0, 0, 0), (0, 0, 1, 0)])  # (x, y, direction, cost)
    
    while q:
        x, y, direction, cost = q.popleft()
        
        if cost > costs[x][y][direction]:
            continue
            
        for new_dir, (dx, dy) in enumerate(directions):
            nx, ny = x + dx, y + dy
            
            if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 0:
                new_cost = cost + 100
                if direction != new_dir:
                    new_cost += 500
                

                if new_cost < costs[nx][ny][new_dir]:
                    costs[nx][ny][new_dir] = new_cost
                    q.append((nx, ny, new_dir, new_cost))
    

    return min(costs[n-1][n-1])