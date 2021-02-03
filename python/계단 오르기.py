import sys

N = int(sys.stdin.readline().strip('\n'))

a = [ int(sys.stdin.readline().strip('\n')) for _ in range(N) ]

a = [0] + a

cache = [0]*(N+1)
cache[1] = a[1]
for i in range(2,N+1):
    if i == 2:
        cache[i]=a[1]+a[2]
        continue
    cache[i] = max(cache[i-2]+a[i],cache[i-3]+a[i-1]+a[i])
    
print(cache[N])
