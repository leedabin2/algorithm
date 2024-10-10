from itertools import combinations
from collections import Counter
def solution(orders, course):
    answer = []
    for c in course:
        combination_list = []
        for order in orders:
            sorted_order = sorted(order)
            combination_list.extend(combinations(sorted_order, c))
        
        counter = Counter(combination_list)
        if counter:
            max_count = max(counter.values())
            if max_count >= 2:
                for combo, count in counter.items():
                    if count == max_count:
                        answer.append(''.join(combo))
    answer = sorted(answer)
        
    return answer