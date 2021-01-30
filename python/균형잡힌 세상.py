import sys

s = sys.stdin.read()

for line in s.split('\n'):
    stack = []
    
    if line == '.':
        break
    for c in line:
        if c == '.':
            if len(stack) == 0:
                print('yes')
                continue
            else:
                print('no')
                continue
        if c == '(':
            stack.append(c)
            continue
        if c == '[':
            stack.append(c)
            continue
        if c == ')':
            if len(stack)==0 or stack[-1] != '(':
                print('no')
                break
            stack.pop()
            continue
        if c== ']':
            if len(stack)==0 or stack[-1] != '[':
                print('no')
                break
            stack.pop()
            continue
    
