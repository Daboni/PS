import sys

N = int(sys.stdin.readline().strip('\n'))

a = [0]

for _ in range(N):
    a.append(int(sys.stdin.readline().strip('\n')))

cache = [0]

cache.append(a[1])

for i in range(2,N+1):
    if i == 2:
        cache.append(a[1]+a[2])
        continue
    if i == 3:
        cache.append(max(a[i]+a[i-1]+cache[i-3],cache[i-2]+a[i]))
        continue
    cache.append(max(a[i]+a[i-1]+cache[i-3],cache[i-2]+a[i],a[i]+a[i-1]+cache[i-4]))

print(max(cache))
