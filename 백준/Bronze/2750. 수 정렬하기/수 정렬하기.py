import sys

n = int(sys.stdin.readline().rstrip())

num = [ int(sys.stdin.readline()) for i in range(n)]
num.sort()
print(*num, sep='\n')