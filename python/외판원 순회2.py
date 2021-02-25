n = int(input())

w = [ list(map(int,input().split())) for _ in range(n) ]
a = [ _ for _ in range(n) ]

def next_permutation(a):

    i = len(a)-1
    while i>0 and a[i-1]>=a[i]:
        i-=1

    if i<=0:
        return False
    
    j = len(a)-1
    while a[j]<=a[i-1]:
        j -= 1

    a[i-1],a[j]=a[j],a[i-1]

    j = len(a)-1
    while i<j:
        a[i],a[j] = a[j],a[i]
        i+=1
        j-=1
    return True

ans = 2147483647
while True:
    ok = True
    s = 0
    for i in range(0,n-1):
        if w[a[i]][a[i+1]] == 0:
            ok = False
            break
        else:
            s += w[a[i]][a[i+1]]
    if ok and w[a[-1]][a[0]] != 0:
        s += w[a[-1]][a[0]]
        ans = min(ans,s)
    if not next_permutation(a):
        break
    if a[0] != 0:
        break
print(ans)
