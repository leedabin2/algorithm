from sys import stdin

num_of_parti = int(input())
money = 0

for _ in range(num_of_parti):
    dice_a,dice_b,dice_c = map(int, stdin.readline().split())

    if dice_a == dice_b == dice_c:
        money = max(money,10000 + (dice_a * 1000))
    elif dice_a == dice_b:
        money = max(money, 1000 + (dice_a * 100))
    elif dice_a == dice_c:
        money = max(money, 1000 + (dice_a * 100))
    elif dice_b == dice_c:
        money = max(money, 1000 + (dice_b * 100))
    else:
        money = max(money,max(dice_a,dice_b,dice_c) * 100)
print(money)


