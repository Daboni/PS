import sys

N = int(sys.stdin.readline().strip('\n'))

a = list(map(int,sys.stdin.readline().strip('\n').split()))

cache = [1] * N

for i in range(1,N):
    for j in range(i):
        if a[i]<a[j]:

            cache[i] = max(cache[i],cache[j]+1)

print(max(cache))
