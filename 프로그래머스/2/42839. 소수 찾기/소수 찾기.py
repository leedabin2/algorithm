from itertools import permutations

def solution(numbers):
    primes = set()
    number = [int(x) for x in numbers]
    
    for i in range(1,len(number)+1):
        perm_list = list(permutations(number, i))
        for n in perm_list:
            num = int("".join(map(str, n)))
            if is_prime(num):
                primes.add(num)
            
    return len(primes)
    
def is_prime(num):
    if num <= 1:
        return False

    for i in range(2,num):
        if num % i == 0:
            return False

    return True
   