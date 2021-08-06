import sys

n = int(sys.stdin.readline().strip('\n'))

a = [ int(input()) for _ in range(n) ]

a.sort()

for i in a:
    sys.stdout.write(str(i)+'\n')
