n = int(input())

strings = []
res = []
for i in range(n):
    a = input()
    strings.append(a)

for string in strings:
    s = string.split()
    for i, s1 in enumerate(s):
        s[i] = s1[::-1]
    res.append(' '.join(s))

for s in res:
    print(s)
