def solution(gems):
    gems_set = set(gems)
    gems_map = {}
    n =  len(gems)
    start,end = 0, 0
    answer = [0,n-1]

    while end < n:
        
        if gems[end] in gems_map:
            gems_map[gems[end]] += 1
        else:
            gems_map[gems[end]] = 1
        
        while len(gems_map) == len(gems_set):
            if end - start < answer[1] - answer[0]:
                answer = [start,end]
            
            gems_map[gems[start]] -= 1
            if gems_map[gems[start]] == 0:
                del gems_map[gems[start]]
            start += 1
        end += 1
    
    
    return [answer[0]+1,answer[1]+1]