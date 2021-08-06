T = int(input())

def go(s,n):

    if s == n:
        return 1
    if s>n:
        return 0

    res = 0
    for i in range(1,4):
        res += go(s+i,n)
    return res
    
for _ in range(T):

    n = int(input())
    a = [0]*n

    print(go(0,n))
    
