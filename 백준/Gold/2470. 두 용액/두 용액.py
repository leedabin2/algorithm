import sys

n = int(sys.stdin.readline().rstrip())
arr = list(map(int, input().split()))
arr.sort()

res = float('inf')
result = []

def binary_search(start, end):
    global res, result
    while start < end:
        sum_ = arr[start] + arr[end]
        if abs(sum_) < abs(res):
            res = sum_
            result = [arr[start], arr[end]]
        if sum_ > 0:
            end -= 1
        elif sum_ < 0:
            start += 1
        else:
            return result
    return result

result = binary_search(0, len(arr) - 1)
print(*result, sep='\n')
