def solution(answers):
    answer = []
    n = len(answers)
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5]
    three = [3,3,1,1,2,2,4,4,5,5]
    
    one_ans = 0
    two_ans = 0
    three_ans = 0
    for i in range(n):
        if answers[i] == one[i % len(one)]:
            one_ans += 1
        if answers[i] == two[i % len(two)]:
            two_ans += 1
        if answers[i] == three[i % len(three)]:
            three_ans += 1
        
    max_score = max(one_ans,two_ans,three_ans)
    
    if one_ans == max_score:
        answer.append(1)
    if two_ans == max_score:
        answer.append(2)
    if three_ans == max_score:
        answer.append(3)
        
    
    return answer