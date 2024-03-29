import sys

sic = sys.stdin.readline().rstrip().split('-')

res = []
for su in sic:
    add_sum = 0
    for i in su.split('+'): # +값들은 더해서 res에 넣음
        add_sum += int(i)
    res.append(add_sum)

result_sum = res[0] # 처음값을 제외한 다음 값들의 -값을 출력
for i in res[1:]:
    result_sum -= i
print(result_sum)
