def solution(board, h, w):
    answer = 0
    directions = [(-1,0),(0,1),(1,0),(0,-1)] 
    n = len(board)
    
    color = board[h][w]
    x, y = h, w
    count = 0
    for i in range(4):
        nx, ny = x + directions[i][0], y + directions[i][1]
        if 0<= nx < n and 0 <= ny < n:
            if board[nx][ny] == color:
                count += 1
                
        
    return count