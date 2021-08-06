from collections import deque

dq = deque()

n = int(input())

for i in range(n):
    a = input().split()

    if a[0] == 'push_front':
        dq.appendleft(a[1])
    if a[0] == 'push_back':
        dq.append(a[1])
    if a[0] == 'pop_front':
        if len(dq) == 0:
            print(-1)
        else:
            print(dq.popleft())
    if a[0] == 'pop_back':
        if len(dq) == 0:
            print(-1)
        else:
            print(dq.pop())
    if a[0] == 'size':
        print(len(dq))
    if a[0] == 'empty':
        if len(dq) == 0:
            print(1)
        else:
            print(0)
    if a[0] == 'front':
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[0])
    if a[0] == 'back':
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[-1])

