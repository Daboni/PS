import sys

n ,m = map(int,sys.stdin.readline().strip('\n').split())

a = []
for i in range(n):
    a.append(int(sys.stdin.readline().strip('\n')))

l,h = 1, max(a)

while l<=h:
    mid = (l+h)//2
    num = 0
    for i in a:
        num += i//mid

    if num < m:
        h = mid-1
    else:
        l = mid+1
        
print(h)
