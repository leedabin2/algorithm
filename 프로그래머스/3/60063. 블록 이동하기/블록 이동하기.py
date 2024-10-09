from collections import deque

def solution(board):
    answer = 0
    
    n = len(board)
   
    q = deque([((0,0),(0,1),0)]) 

    visited = set([((0,0), (0,1))]) 
  
    move_dist = [(0,1), (0,-1), (1,0), (-1,0)] 
   
    def is_valid(pos1,pos2,board,n):
        if 0 <= pos1[0] < n and  0 <= pos2[0] < n and 0<=pos2[1] < n and 0 <= pos1[1] < n and board[pos1[0]][pos1[1]] == 0 and board[pos2[0]][pos2[1]] == 0:
                return True
        return False
    
    while q:
        curr_left, curr_right, curr_dist = q.popleft()
        
        if curr_left == (n-1,n-1) or curr_right  == (n-1,n-1):
            return curr_dist 
        # 동서남북 이동 거리
        for dx, dy in move_dist: 
            next_pos1 = (curr_left[0] + dx, curr_left[1] + dy)
            next_pos2 = (curr_right[0] + dx, curr_right[1] + dy)
            
            if is_valid(next_pos1, next_pos2, board, n):
                next_pos = (next_pos1, next_pos2)
                if next_pos not in visited and (next_pos2, next_pos1) not in visited:
                    visited.add(next_pos)
                    q.append((next_pos1, next_pos2, curr_dist+1))
        
    
        # 회전하는 경우
        if curr_left[0] == curr_right[0]:
            for d in [-1,1]: # 위, 아래로 회전하는 경우
                if is_valid((curr_left[0] + d, curr_left[1]),(curr_right[0] +d , curr_right[1]),board,n):
                    new_left = (curr_left[0] + d, curr_left[1])
                    new_right = (curr_right[0] + d, curr_right[1])
                    if (new_left, curr_left) not in visited and (curr_left, new_left) not in visited:
                        
                        visited.add((new_left, curr_left))
                        q.append((new_left, curr_left, curr_dist + 1))
                    if (new_right, curr_right) not in visited and (curr_right, new_right) not in visited:
                        
                        visited.add((new_right, curr_right))
                        q.append((new_right, curr_right, curr_dist + 1))
                        
        if curr_left[1] == curr_right[1]:
            for d in [-1,1]: # 위, 아래로 회전하는 경우
                if is_valid((curr_left[0], curr_left[1]+d),(curr_right[0] , curr_right[1]+d),board,n):
                    new_left = (curr_left[0], curr_left[1]+d)
                    new_right = (curr_right[0], curr_right[1]+d)
                    if (new_left, curr_left) not in visited and (curr_left, new_left) not in visited:
                        
                        visited.add((new_left, curr_left))
                        q.append((new_left, curr_left, curr_dist + 1))
                    if (new_right, curr_right) not in visited and (curr_right, new_right) not in visited:
                        
                        visited.add((new_right, curr_right))
                        q.append((new_right, curr_right, curr_dist + 1))
                
        
    return -1
                
    
