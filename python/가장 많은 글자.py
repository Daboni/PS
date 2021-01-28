import sys

a = {}

for i in range(ord('a'),ord('z')+1):
    a[chr(i)] = 0

s = sys.stdin.read()

for c in s:
    if c.islower():
        a[c] += 1

res = ""

for k in a.keys():
    if a[k] == max(a.values()):
        res += k

print(res)
