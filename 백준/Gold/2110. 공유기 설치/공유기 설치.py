import sys
N, C = map(int,sys.stdin.readline().split())
arr = [int(sys.stdin.readline().rstrip()) for _ in range(N)]
arr.sort()

max_distance = 0
def dfs(start,end):
    global max_distance
    while start <= end:
        mid  = (start +end) //2
        cur = arr[0]
        cnt = 1

        for i in range(1,len(arr)):
            if arr[i] >= cur + mid:
                cur = arr[i]
                cnt += 1
        if cnt >= C:
            max_distance = mid
            start = mid + 1
        else:
            end = mid -1

dfs(1,arr[-1]-arr[0])
print(max_distance)