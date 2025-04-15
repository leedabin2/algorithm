import sys
input = sys.stdin.readline

N, M = map(int, input().split())

r, c, d = map(int, input().split())
rooms = [list(map(int, input().split())) for _ in range(N)]

dist_list = [ [-1,0], [0,1], [1,0], [0,-1]] # 북동남서
res = 0
while True:
    # 1. 현재 칸이 청소되지 않았으면 청소
    if rooms[r][c] == 0:
        rooms[r][c] = 2
        res += 1
    turned = False
    # 2. 왼쪽 방향부터 탐색 (반시계 방향으로 회전하며 최대 4번)
    for _ in range(4):
        d = (d + 3) % 4
        nr = r + dist_list[d][0]
        nc = c + dist_list[d][1]

        # 청소되지 않은 칸이면 이동
        if 0 <= nr < N and 0 <= nc < M and rooms[nr][nc] == 0:
            r, c = nr, nc
            turned = True
            break
    # 3. 4방향 모두 청소 완료 or 벽인 경우 → 후진
    if not turned:
        back_d = (d + 2) % 4
        br = r + dist_list[back_d][0]
        bc = c + dist_list[back_d][1]

        # 뒤가 벽이면 작동 멈춤
        if rooms[br][bc] == 1:
            break
        else:
            r, c = br, bc  # 후진만 함 (방향 유지)

print(res)