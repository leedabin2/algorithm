import sys

N, K = map(int,sys.stdin.readline().split())
nara = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

nara.sort(key=lambda x: (x[1],x[2],x[3]),reverse=True)

for i in range(N):
    if nara[i][0] == K:
        idx = i
for i in range(N): # 만약 메달 개수가 같다면 그 나라의 +1 등
    if nara[idx][1:] == nara[i][1:]:
        print(i+1)
        break









