import sys

s = sys.stdin.readline().strip('\n')

c = sys.stdin.readline().strip('\n')

stack = []

for i in s:
    stack.append(i)
    if i == c[-1]:
        if ''.join(stack[-len(c):]) == c:
            del stack[-len(c):]

answer = ''.join(stack)

if answer == '':
    print('FRULA')
else:
    print(answer)
