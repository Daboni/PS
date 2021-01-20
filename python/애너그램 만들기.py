# 백준 1919 번

s1 = input()
s2 = input()

a = [ 0 for _ in range(26) ]
b = [ 0 for _ in range(26) ]

for c in s1:
    a[ord(c)-ord('a')] += 1

for c in s2:
    b[ord(c)-ord('a')] += 1

res = 0
for i in range(26):
    if a[i] != b[i]:
        mini = min(a[i],b[i])
        maxi = max(a[i],b[i])
        res += maxi -mini

print(res)
