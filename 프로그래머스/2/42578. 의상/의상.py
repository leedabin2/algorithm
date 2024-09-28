def solution(clothes):
    answer = 1
    hashclothes = {}
    for c in clothes:
        if c[1] not in hashclothes:
            hashclothes[c[1]] = set()
        hashclothes[c[1]].add(c[0])
        
    for clothe in hashclothes.values():
        answer *= len(clothe)+1
    return answer-1