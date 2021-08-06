# 1 2 3 4 5 6 7
# 1 2 4 5 6 7
# 1 2 4 5 7
# 1 4 5 7
# 1 4 5
# 1 4
# 4

from collections import deque

n ,k = map(int,input().split())

s = deque()

for i in range(1,n+1):
    s.append(i)

print('<',end='')
while s:
    for i in range(k-1):
        s.append(s[0])
        s.popleft()
    print(s.popleft(),end='')
    if s:
        print(', ',end='')
print('>')
