import sys

N = int(sys.stdin.readline().rstrip())

def rock_game(n):

    dp = [''] * 100001

    dp[1] = 'SK'
    dp[2] = 'CY'

    for i in range(3,n+1):
        if i % 2 == 1:
            dp[i] = 'SK'
        else:
            dp[i] = 'CY'

    return dp[n]

print(rock_game(N))
