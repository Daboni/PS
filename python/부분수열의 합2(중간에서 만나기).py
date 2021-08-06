import sys

n,s = map(int,sys.stdin.readline().strip('\n').split())

a = list(map(int,sys.stdin.readline().strip('\n').split()))


m = n//2
n = n-m
up = [0]*(1<<n)


down = [0]*(1<<m)

for i in range(1<<n):
    for k in range(n):
        if (i&(1<<k)) > 0:
            up[i] += a[k]

for i in range(1<<m):
    for k in range(m):
        if (i&(1<<k)) > 0:
            down[i] += a[k+n]

up.sort()
down = sorted(down,reverse=True)

n = (1<<n)
m = (1<<m)

i = 0
j = 0
ans = 0

while i<n and j<m:
    if up[i]+down[j] == s:
        c1 = 1
        c2 = 1
        i+= 1
        j+= 1
        while i < n and up[i] == up[i-1]:
            c1 += 1
            i += 1
        while j < m and down[j] == down[j-1]:
            c2 += 1
            j += 1
            
        ans += c1*c2

    elif up[i]+down[j] < s:
        i += 1
    else:
        j += 1

if s == 0:
    ans -= 1
print(ans)
