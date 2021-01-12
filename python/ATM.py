N = int(input())

a = list(map(int,input().split()))
    
a = sorted(a)

b = [ x  for x in range(N,0,-1)]

res = 0
for i in range(N):
    res += (a[i]*b[i])

print(res)
