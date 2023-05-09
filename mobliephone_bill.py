from sys import stdin

call_count = map(int, stdin.readline().split())
call_time = map(int, stdin.readline().split())

Y_sum = 0
M_sum = 0

for i in call_time:
    Y_fee = 10*((i//30)+1)
    M_fee = 15*((i//60)+1)
    Y_sum += Y_fee
    M_sum += M_fee

if Y_sum < M_sum:
    print(f'Y {Y_sum}')
elif Y_sum == M_sum:
    print(f'Y M {Y_sum}')
else:
    print(f'M {M_sum}')