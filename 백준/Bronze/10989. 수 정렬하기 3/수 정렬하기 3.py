import sys 

n = int(sys.stdin.readline().rstrip())

# 정렬하고자 하는 배열의 최댓값
# insert_max_num = max(insert_num)
# 최댓값 크기의 배열에 각 원소를 순회하며 해당값이 몇 개 인지 저장

count_num = [0] * 10001

for i in range(n):
    num = int(sys.stdin.readline())
    count_num[num] += 1

for i in range(len(count_num)):
    for j in range(count_num[i]):
        print(i)
