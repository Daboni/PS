a = [ 0 for _ in range(26)]

s= input()

for c in s:
    a[ord(c)-97] += 1

for _ in a:
    print(_,end=' ')
