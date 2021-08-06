import sys

n = int(sys.stdin.readline().strip('\n'))

a = list(map(int,sys.stdin.readline().strip('\n').split()))


if max(a) < 0:
    print(max(a))
    
else:

    cache = [0] * n
    
    for i in range(n):
        cache[i] = max(cache[i],cache[i-1]+a[i])
    print(max(cache))
