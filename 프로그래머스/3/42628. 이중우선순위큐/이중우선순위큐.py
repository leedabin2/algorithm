from heapq import heappush, heappop

def solution(operations):
    min_q = []  
    max_q = []  

    for op in operations:
        command, num_str = op.split()
        num = int(num_str)

        if command == 'I':
            heappush(min_q, num)
            heappush(max_q, -num)
        elif command == 'D':
            if num == 1 and max_q:
                max_val = -heappop(max_q)
                min_q.remove(max_val)
            elif num == -1 and min_q: 
                min_val = heappop(min_q)
                max_q.remove(-min_val)

    if not min_q:
        return [0, 0]

    return [-heappop(max_q), heappop(min_q)]


