import sys

N = int(sys.stdin.readline().rstrip())
a, b, c, d = map(int, sys.stdin.readline().split())

ingredient = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]


idx_num = ''
min_price = 1e12
def recur(idx, A, B, C, D, price, idx_):
    global min_price, idx_num

    if A >= a and B >= b and C >= c and D >= d:
        if min_price > price:
            min_price = price
            idx_num = idx_
            return
        else:
            return

    if idx >= N:
        return

    # 식재료를 쓰는 경우
    recur(idx + 1, A + ingredient[idx][0], B + ingredient[idx][1], C + ingredient[idx][2], D + ingredient[idx][3], price + ingredient[idx][4], idx_ + ' ' + str(idx + 1))
    # 식재료를 안 쓰는 경우
    recur(idx + 1, A, B, C, D, price, idx_)

recur(0,0,0,0,0,0, '')
if min_price == 1e12:
    print(-1)
else:
    print(min_price)
    print(idx_num.strip())