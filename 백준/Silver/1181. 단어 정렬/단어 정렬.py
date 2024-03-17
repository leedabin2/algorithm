import sys 

n = int(sys.stdin.readline().rstrip())

# 중복 제거
alphabet = list(set([sys.stdin.readline().rstrip() for _ in range(n)]))

# 길이가 짧은 것부터 정렬한 뒤, 길이가 같으면 사전 순으로 정렬
alphabet.sort(key=lambda x: (len(x), x))

print(*alphabet,sep='\n')