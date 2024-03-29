import sys

T = int(sys.stdin.readline().rstrip())


for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    coin_list = list(map(int,sys.stdin.readline().split()))
    target_money = int(sys.stdin.readline().rstrip())


    dp = [0] * (target_money+1)

    dp[0] = 1 # 0원으로 만드는 방법은 1가지

    for coin in coin_list:
        for i in range(1,target_money+1):
            if i >= coin:
                dp[i] += dp[i-coin]

    print(dp[target_money])


