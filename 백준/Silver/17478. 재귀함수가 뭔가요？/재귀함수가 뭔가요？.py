
n = int(input())
def recur(n,answer_num):
    # 이야기에서 답 찾기
    print("____" * answer_num + '"재귀함수가 뭔가요?"')
    # 이야기에서 답이 나오면 답을 반환
    if n == answer_num:
        print("____" * answer_num + '"재귀함수는 자기 자신을 호출하는 함수라네"')
    # 답이 나오지 않으면 다시 호출
    else:
        print("____" * answer_num + '"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.')
        print("____" * answer_num + '마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.')
        print("____" * answer_num + '그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."')
        recur(n, answer_num+1)
    print("____" * answer_num + "라고 답변하였지.")


print("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.")
answer_num = 0
recur(n,answer_num)

