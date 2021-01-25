import sys

enco_low = {}
enco_up={}

for i in range(ord('a'),ord('z')+1):
    if i-ord('a') < 13:
        enco_low[chr(i)] = chr(i+13)
    else:
        enco_low[chr(i)] = chr(i-13)

for i in range(ord('A'),ord('Z')+1):
    if i-ord('A') < 13:
        enco_up[chr(i)] = chr(i+13)
    else:
        enco_up[chr(i)] = chr(i-13)

S = sys.stdin.readline()

res = ""

for c in S:
    if c == ' ':
        res += ' '
    elif ord(c) <= ord('9'):
        res += c
    
    elif ord(c) < ord('a'):
        res += enco_up[c]
    else:
        res += enco_low[c]

print(res)
