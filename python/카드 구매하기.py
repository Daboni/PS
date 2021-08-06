# 1 p1
# 2 p1+ 1, p2
# 3 p1+ 2, p3
# 4 p1+ 3, p4
# 5 p1+ 4
# 6 p1+ 5

import sys

N = int(sys.stdin.readline().strip('\n'))

p = list(map(int,sys.stdin.readline().strip('\n').split()))

p = [0] + p

cache = [0] * (N+1)

for i in range(1,N+1):
    for j in range(1,i+1):
        cache[i] = max(cache[i],cache[i-j]+p[j])

print(cache[N])
