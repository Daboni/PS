import sys

n = int(input())

a = [ int(input()) for _ in range(n) ]

stack = []
out = []

s = ''
j = 1

for i in range(n):

    while j<=a[i]:
        s += '+'
        stack.append(j)
        j+=1
    if stack.pop() == a[i]:
        s += '-'
    else:
        print('NO')
        sys.exit(0)

print('\n'.join(s))
# 3 4
# j=4
# 
