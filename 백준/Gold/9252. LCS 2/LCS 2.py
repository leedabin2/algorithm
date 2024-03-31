import sys

# 최장 공통 문자열 (시간초과)

monja1 = [0] + list(str(sys.stdin.readline().rstrip()))
monja2 = [0] + list(str(sys.stdin.readline().rstrip()))

lcs = [[''] * (len(monja2)) for _ in range(len(monja1))]

for i in range(1,len(monja1)):
    for j in range(1,len(monja2)):
        if monja1[i] == monja2[j]: # 문자가 같다면
            lcs[i][j] = lcs[i-1][j-1] + monja1[i] # 두 값을 떼고, 비교값에 + 1을 해줌
        else:
            if len(lcs[i][j-1]) >= len(lcs[i-1][j]):
                lcs[i][j] = lcs[i][j-1]
            else:
                lcs[i][j] = lcs[i-1][j]

print(len(lcs[-1][-1]))
if len(lcs) != 0:
    print(lcs[-1][-1])





