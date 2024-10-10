def solution(stones, k):
    left, right = 1, max(stones)
    
    while left <= right:
        mid = (left + right) // 2
        count = 0
        max_count = 0
        
        for stone in stones:
            if stone - mid <= 0:
                count += 1
                if count >= k:
                    max_count = count
                    break
            else:
                count = 0
        
        if max_count >= k:
            right = mid - 1
        else:
            left = mid + 1
    
    return left