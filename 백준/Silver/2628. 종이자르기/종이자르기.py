import sys
from collections import Counter

a, b = map(int,sys.stdin.readline().split())
cut_num = int(sys.stdin.readline().rstrip())
tag = [[0]*a for _ in range(b)] # 종이

new_cuts = [] #
for i in range(cut_num):
    cut = list(map(int,sys.stdin.readline().split()))
    for j in range(b):
        for k in range(a):
            if cut[0] == 0:
                if j < cut[1]:
                    tag[j][k] += 1
            if cut[0] == 1:
                if k < cut[1]:
                    tag[j][k] += 100

count_list = []
for i in tag:
    for j in i:
        count_list.append(j)
        counter = Counter(count_list).most_common(1)

print(counter[0][1])






































