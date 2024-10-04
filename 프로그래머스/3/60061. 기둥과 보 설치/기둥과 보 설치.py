def check(answer):
    # 기둥 설치 조건 -> 아래에 기둥이 있어야하고, 바닥이거나, 보의 한쪽끝에 설치가능
    for x, y, a in answer:
        if a == 0:
            if y == 0 or [x,y-1,0] in answer or [x-1,y,1] in answer or [x,y,1] in answer:
                continue
            return False
        if a == 1: # 보 설치 조건 -> 보의 한쪽끝이 기둥, 양쪽끝이 다른 보랑 연결
            if ([x-1,y,1] in answer and [x+1,y,1] in answer) or [x+1,y-1,0] in answer or [x,y-1,0] in answer:
                continue
            return False
    return True
            
        
        
def solution(n, build_frame):
    answer = []
    # 0 은 기둥 1은 보
    # x y a b [a는 설치구조물, b는 삭제 - 0은삭제]
    # x y a
    for x,y,a,b in build_frame:
        if b == 1:
            answer.append([x,y,a])
            if not check(answer):
                answer.remove([x,y,a])
        if b == 0:
            answer.remove([x,y,a])
            if not check(answer):
                answer.append([x,y,a])
                   
    return sorted(answer)