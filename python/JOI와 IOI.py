import sys

s = sys.stdin.readline().strip('\n')

tmp = s

res = 0
while(1):
    idx = tmp.find('JOI')
    if idx == -1:
        print(res)
        break
    res += 1
    tmp = tmp[idx+2:]

res = 0
while(1):
    idx = s.find('IOI')
    if idx == -1:
        print(res)
        break
    res += 1
    s = s[idx+2:]
