import sys

N = int(sys.stdin.readline().strip('\n'))

a = [ int(sys.stdin.readline().strip('\n')) for i in range(N) ]

a = sorted(a, reverse = True)

max_w = a[0]
for i in range(1,N):

    max_w = max(max_w,a[i]*(i+1))

print(max_w)
