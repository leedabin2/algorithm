def solution(friends, gifts):
 
    gift_record = {friend: {} for friend in friends}
    gift_index = {friend: [0, 0] for friend in friends} 
    next_month_gifts = {friend: 0 for friend in friends}
    print(gift_record)

    for gift in gifts:
        giver, receiver = gift.split()
        if receiver not in gift_record[giver]:
            gift_record[giver][receiver] = 0
        gift_record[giver][receiver] += 1
        gift_index[giver][0] += 1  
        gift_index[receiver][1] += 1 
    
    for i, friend1 in enumerate(friends):
        for friend2 in friends[i+1:]:
            give = gift_record[friend1].get(friend2, 0)
            take = gift_record[friend2].get(friend1, 0)
            
            if give > take:
                next_month_gifts[friend1] += 1
            elif give < take:
                next_month_gifts[friend2] += 1
            else:

                index1 = gift_index[friend1][0] - gift_index[friend1][1]
                index2 = gift_index[friend2][0] - gift_index[friend2][1]
                if index1 > index2:
                    next_month_gifts[friend1] += 1
                elif index1 < index2:
                    next_month_gifts[friend2] += 1

    return max(next_month_gifts.values())


