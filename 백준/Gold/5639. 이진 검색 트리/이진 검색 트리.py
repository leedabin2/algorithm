import sys
sys.setrecursionlimit(10**6)
nums = []
while 1:
    try:
        num = int(sys.stdin.readline().rstrip())
        nums.append(num)
    except:
        break

def postorder(start,end):
    if start > end:
        return

    mid = end + 1
    for i in range(start+1,end+1):
        if nums[i] > nums[start]:
            mid = i
            break

    postorder(start+1,mid-1)
    postorder(mid,end)
    print(nums[start])

postorder(0,len(nums)-1)