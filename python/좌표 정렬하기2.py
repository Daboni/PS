import sys

n = int(sys.stdin.readline())

a = []
for i in range(n):
    x,y = map(int,sys.stdin.readline().strip('\n').split())
    a.append((y,x))

a.sort()

for (y,x) in a:
    print(x,y)
