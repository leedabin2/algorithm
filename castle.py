# 성 지키기
import sys
n,m = map(int,sys.stdin.readline().split())
check = []
for _ in range(n):
    check.append(list(map(str,sys.stdin.readline().rstrip())))

count = 0
for row in check: # 행의 개수
    all = True
    for elm in row:
        if elm != '.':
            all = False
            break
    if all:
        count += 1

col = [] # check의 열을 담을 새로운 리스트
for j in range(m):
    for i in check:
        col.append(i[j])
print(col)
result = [col[i:i+n] for i in range(0, len(col), n)] # col을 n행씩 끊어서

cnt  = 0
for coln in result:
    all = True
    for elm in coln:
        if 'X' in elm:
            all = False
            break
    if all:
        cnt += 1
print(max(count,cnt))