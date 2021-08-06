t = int(input())
tc = 1
while tc<=t:
    s = input()
    ans = 0
    while True:
        idx = s.find('1');
        if idx == -1:
            break
        new_s = s[:idx]
        
        for i in range(idx,len(s)):
            if s[i]=='1':
                new_s += '0'
            else:
                new_s += '1'
        s = new_s
        ans += 1
    print('#{} {}'.format(tc,ans))
    tc+=1
