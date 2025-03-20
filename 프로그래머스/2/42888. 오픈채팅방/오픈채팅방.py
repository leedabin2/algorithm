def solution(record):
    answer = []
    user_info = {}
    actions = []
    
    for r in record:
        parts = r.split()
        command, user_id= parts[0], parts[1]

        
        if command in ("Enter", "Change"):
            nickname = parts[2]
            user_info[user_id] = nickname 
            
        if command in ("Enter", "Leave"):
            actions.append((command,user_id))

    
    
    for cmd,uid in actions:
        if cmd == 'Enter':
            answer.append(f"{user_info[uid]}님이 들어왔습니다.")
        elif cmd == 'Leave':
            answer.append(f"{user_info[uid]}님이 나갔습니다.")
            
    return answer