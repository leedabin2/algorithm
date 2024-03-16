from functools import reduce

def solve(a):
    ans = 0
    sum_ans = reduce(lambda i, res: i+res, a, 0)
    return sum_ans

