import sys

number = int(sys.stdin.readline().rstrip())

res = 0

for i in range(number):
    res = i
    str_i = str(i)

    for j in str_i:
        i += int(j)

    if i == number:
        print(res)
        break

else:
    print(0)
