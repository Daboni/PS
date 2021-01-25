import sys

N = int(sys.stdin.readline())

a = list(map(int,sys.stdin.readline().split()))

a = sorted(a)

b = sorted(a,reverse=True)

min = 1e9

for i in range(N):
    if min > a[i]+b[i]:
        min = a[i]+b[i]

print(min)
