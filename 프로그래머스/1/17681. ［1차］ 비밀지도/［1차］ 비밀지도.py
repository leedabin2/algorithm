def solution(n, arr1, arr2):
    answer = []
    binary_list1 = [list(format(value, f'0{n}b')) for value in arr1]
    binary_list2 = [list(format(value, f'0{n}b')) for value in arr2]

    for i in range(n):
        line = ''
        for j in range(n):
            if binary_list1[i][j] == '1' or binary_list2[i][j] == '1':
                line += "#"
            else:
                line += ' '
        answer.append(line)

    return answer