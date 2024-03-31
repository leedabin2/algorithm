import sys

T = int(sys.stdin.readline().rstrip())

for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    deagija = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
    deagija.sort(key=lambda x: x[1])

    compare = deagija[0][0]
    cnt = 1
    for i in range(1,len(deagija)):
        if compare > deagija[i][0]:
            cnt += 1
            compare = deagija[i][0]
    print(cnt)
