import sys

N = int(sys.stdin.readline().strip('\n'))

for _ in range(N):
    s = sys.stdin.readline().strip('\n')
    print(s[0]+s[-1])
