n = int(input())

a = list(map(int,input().split()))

def go(a):

    if len(a) == 2:
        return 0
    ans = 0
    for i in range(1,len(a)-1):
        energy = a[i-1]*a[i+1]
        b = a[:i] + a[i+1:]
        energy += go(b)
        if ans < energy:
            ans = energy
            
    return ans

print(go(a))
