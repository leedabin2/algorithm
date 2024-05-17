import sys

question = sys.stdin.readline().rstrip()
stack = []
answer = 0

for idx in range(len(question)):
    if question[idx] == '(': # 열린 괄호는 추가
        stack.append('(')
    else: # 닫는 괄호의 경우
        stack.pop()
        if question[idx-1] == '(': # 레이저인 경우
            answer += len(stack)
        else: answer += 1 # 막대의 끝인 경우

print(answer)