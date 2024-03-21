import sys

N = int(sys.stdin.readline().rstrip())

list_sum = []
pow_sum2 = []
for i in range(1,N+1):
    list_sum.append(i)
    pow_sum2.append(pow(i,3))

print(sum(list_sum))
print(pow(sum(list_sum),2))
print(sum(pow_sum2))