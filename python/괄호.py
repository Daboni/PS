import sys

N = int(sys.stdin.readline().strip())

for _ in range(N):
    s = sys.stdin.readline().strip('\n')
    j = 0
    stack = []
    idx = 0
    while(1):
        if idx >= len(s):
            if len(stack) != 0:
                j = 1
            break
        if s[idx] == '(':
            stack.append(idx)
            idx += 1
        else:
            if len(stack) == 0:
                j = 1
                break
            stack.pop()
            idx += 1
    if j == 1:
        print('NO')
    else:
        print('YES')
