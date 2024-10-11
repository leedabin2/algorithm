def solution(s):
    
    n =len(s)
    answer = n

    for i in range(1,n//2+1):
        start,end = 0,i
        count = 1
        comp = ''
        
        while end <= n:
            if s[start:start+i] == s[end:end+i]:
                count += 1
            else:
                if count > 1:
                    comp += str(count) + s[start:start+i]
                else:
                    comp += s[start:start+i]
                count = 1
            start = end
            end += i
        
        if count > 1:
            comp += str(count) + s[start:start+i]
        else:
            comp += s[start:start+i]
      
        if end < n:
            comp += s[end:]

        
        answer = min(answer, len(comp))  
   
    return answer