import sys

N = int(sys.stdin.readline().rstrip())
search = list(map(int,sys.stdin.readline().split()))

def is_prime(n):
    if n <= 1:
        return False
    for i in range(2,n):
        if n % i == 0:
            return False
    return True

res = 0
for i in search:
    if is_prime(i) == True:
        res += 1

print(res)
