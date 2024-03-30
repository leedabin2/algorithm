import sys

# 최장 공통 문자열

monja1 = [0] + list(str(sys.stdin.readline().rstrip()))
monja2 = [0] + list(str(sys.stdin.readline().rstrip()))

lcs = [[0] * (len(monja2)) for _ in range(len(monja1))]

for i in range(1,len(monja1)):
    for j in range(1,len(monja2)):
        if monja1[i] == monja2[j]:
            lcs[i][j] = lcs[i-1][j-1] + 1
        else:
            lcs[i][j] = max(lcs[i][j-1],lcs[i-1][j])

print(lcs[len(monja1)-1][len(monja2)-1])
