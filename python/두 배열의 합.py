import sys
from collections import Counter

t = int(sys.stdin.readline().strip('\n'))

n = int(sys.stdin.readline().strip('\n'))
a = list(map(int,sys.stdin.readline().strip('\n').split()))

m = int(sys.stdin.readline().strip('\n'))
b = list(map(int,sys.stdin.readline().strip('\n').split()))

'''
x = [0]*(1<<n)
y = [0]*(1<<m)

for i in range(1<<n):
    for k in range(n):
        if (i&(1<<k)) > 0:
            x[i] += a[k]

for i in range(1<<m):
    for k in range(m):
        if (i&(1<<k)) > 0:
            y[i] += b[k]
'''
x = []
y = []

for i in range(n):
    s = 0
    for j in range(i,n):
        s += a[j]
        x.append(s)

for i in range(m):
    s = 0
    for j in range(i,m):
        s += b[j]
        y.append(s)

x.sort()
y.sort()

c = Counter(y)

ans = 0
for i in x:
    ans += c[t-i]

print(ans)
