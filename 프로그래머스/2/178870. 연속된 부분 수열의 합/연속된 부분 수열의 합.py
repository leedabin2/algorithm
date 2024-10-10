def solution(sequence, k):
    answer = []
    n = len(sequence)
    start, end = 0, 0
    curr_sum = 0
    min_length = float('inf')

    while end < n:
        curr_sum += sequence[end]
        
        while start <= end and curr_sum > k:
            curr_sum -= sequence[start]
            start += 1
       
        if curr_sum == k:
            curr_length = end - start + 1
            if curr_length < min_length:
                min_length = curr_length
                answer = [start,end]
          
        end += 1
    
    
        
    return answer