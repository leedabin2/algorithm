def solution(dirs):
    answer = 0
    move = {
        'U' : (-1,0),
        'D' : (1,0),
        'R' : (0, 1),
        'L' : (0, -1)
    }
    
    visited = set()
    x, y = 0, 0
    for d in dirs:
        dx, dy = move[d]
        nx, ny = x + dx, y + dy
        
        if -5 <= nx <= 5 and -5 <= ny <= 5:
            path = ((x,y),(nx, ny))
            reverse_path = ((nx, ny), (x,y))
            
            visited.add(path)
            visited.add(reverse_path)
            
            x, y = nx, ny
    return len(visited) // 2