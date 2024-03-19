import sys

N , M = map(int,sys.stdin.readline().split())

wood = list(map(int,sys.stdin.readline().split()))
wood.sort()

def binary_search(wood,start,end):
    while start <= end:
        cut_sum = 0
        mid = (start + end) // 2

        for w in wood:
            if w > mid:
                cut_sum += w-mid

        if cut_sum < M:
            end = mid - 1
        else:
            start = mid + 1

    return end

res = binary_search(wood,0,wood[-1])
print(res)

