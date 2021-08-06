n = int(input())

a = list(map(int,input().split()))

cache = [1]*n

track = [-1]*n

for i in range(1,n):
    for j in range(i):
        if a[i]>a[j] and cache[i] < cache[j]+1:
            cache[i] = cache[j]+1
            track[i] = j

ans = max(cache)

lis = []

p = cache.index(ans)

while p != -1:
    lis.append(a[p])    
    p = track[p]

lis.reverse()

print(ans)
print(' '.join(map(str,lis)))
