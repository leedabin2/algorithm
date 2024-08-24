from itertools import permutations

def solution(numbers):
    answer = set()
    
    number = [int(i) for i in numbers]
    
    for i in range(1,len(number)+1):
        perm_list = list(permutations(number,i))
        for perm in perm_list:
            num =  int("".join(map(str, perm)))
            if is_prime(num):
                answer.add(num)
                
    return len(answer)

def is_prime(n):
    if n <= 1:
        return False
    for i in range(2,n):
        if n % i == 0:
            return False
    return True

    