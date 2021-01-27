import sys

N = int(sys.stdin.readline().strip('\n'))

for _ in range(N):
    s = sys.stdin.readline().strip('\n')
    tmp = s
    s2 = s[::-1]

    res = 0
    i = 0
    while(1):
        if i >= len(tmp)//2:
            break
        if res == 2:
            break
        if tmp[i] != s2[i]:
            s2=s2.replace(s2[i],'',1)
            tmp = s2[::-1]
            res += 1
            i -= 1
        i += 1

    s2 = s[::-1]
    
    res2 = 0
    i = 0
    while(1):
        if i >= len(s)//2:
            break
        if res2 == 2:
            break
        if s[i] != s2[i]:
            s=s.replace(s[i],'',1)
            s2 = s[::-1]
            res2 += 1
            i -= 1
        i += 1
    
    print(min(res,res2))
