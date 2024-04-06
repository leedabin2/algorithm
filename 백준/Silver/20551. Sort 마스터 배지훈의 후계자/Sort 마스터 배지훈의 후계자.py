import sys

N, M = map(int,sys.stdin.readline().split())

B = [int(sys.stdin.readline().rstrip()) for _ in range(N)]
B.sort()

def search_val(arr, target):
    start, end = 0, len(arr) - 1
    
    while start <= end:
        mid = (start + end) // 2
        
        if arr[mid] < target:
            start = mid + 1
        elif arr[mid] > target:
            end = mid - 1
        elif arr[mid] == target:
            if end == mid:
                break
            end = mid
            
    if arr[mid] == target:
        return mid
    else:
        return -1

for i in range(M):
    search = int(sys.stdin.readline().rstrip())
    print(search_val(B, search))

