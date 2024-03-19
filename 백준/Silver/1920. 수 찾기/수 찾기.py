import sys

N = int(sys.stdin.readline().rstrip())
arr = list(map(int,sys.stdin.readline().split()))
arr.sort()
M = int(sys.stdin.readline().rstrip())
target_list = list(map(int,sys.stdin.readline().split()) )

def binary_search(arr,target,start,end):
    while start <= end:
        mid = (start + end) // 2

        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1

for target in target_list:
    res = binary_search(arr,target,0,N-1)
    res = '1' if res != None else '0'
    print(res)







