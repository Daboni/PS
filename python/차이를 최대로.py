n = int(input())

a = list(map(int,input().split()))

def next_permutation(a):

    i = len(a) -1
    while i > 0 and a[i-1] >= a[i]:
        i -= 1

    if i <= 0:
        return False

    j = len(a) -1
    while a[j]<= a[i-1]:
        j -= 1

    a[i-1],a[j] = a[j],a[i-1]

    j = len(a) -1

    while i < j:
        a[i],a[j] = a[j],a[i]
        i += 1
        j -= 1
    return True

def go(a):
    ans = 0
    for i in range(n-1):
        ans += abs(a[i]-a[i+1])

    return ans

a.sort()

ans = 0
while True:

    tmp = go(a)
    ans = max(ans,tmp)
    if not next_permutation(a):
        break
print(ans)
