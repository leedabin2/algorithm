import sys

N = int(sys.stdin.readline().rstrip())

atm_jul = list(map(int,sys.stdin.readline().split()))
new_atm = [ i for i in enumerate(atm_jul)]
new_atm.sort(key=lambda x : x[1])

res = 0
ans = []
for i in range(len(new_atm)):
    res += new_atm[i][1]
    ans.append(res)

print(sum(ans))
