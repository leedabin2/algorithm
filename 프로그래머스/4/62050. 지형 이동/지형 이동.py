from heapq import heappush, heappop

def solution(land, height):
    answer = 0
    n = len(land)
    visited = [[False] * n for _ in range(n)]
    dist = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    hq = []
    heappush(hq,(0,0,0))
    
    while hq:
        cost, x, y = heappop(hq)

        if visited[x][y]:
            continue
        
        visited[x][y] = 1
        answer += cost

        
        for d in dist:
            nx, ny = d[0] + x, d[1] + y
            
                
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                diff = abs(land[x][y]-land[nx][ny])
                if diff > height:
                    heappush(hq,(diff,nx,ny))
                else:
                    heappush(hq,(0,nx,ny))
                
                
    return answer