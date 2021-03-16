n = int(input())
a = list(map(int,input().split()))

d = [0]*n
d2 = [0]*n

for i in range(n):
    d[i] = 1
    for j in range(i):
        if a[i]>a[j] and d[i] < d[j]+1:
            d[i] = d[j]+1

for i in range(n-1,-1,-1):
    d2[i]=1
    for j in range(i+1,n):
        if a[i]>a[j] and d2[i] < d2[j]+1:
            d2[i] = d2[j]+1

d3 = [ d[i]+d2[i]-1 for i in range(n) ]

print(max(d3))
