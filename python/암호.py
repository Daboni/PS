import sys

s = sys.stdin.readline().strip('\n')

key = sys.stdin.readline().strip('\n')

key_len = len(key)

s_len = len(s)

key = key * (s_len//key_len+1)

res = ""
for i in range(s_len):
    if s[i] == ' ':
        res += s[i]
        continue
    tmp = ord(s[i])-ord(key[i])
    if tmp <= 0:
        res += chr(ord('z')-abs(tmp))
    else:
        res += chr(tmp+ord('a')-1)

print(res)
