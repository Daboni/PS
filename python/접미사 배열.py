s=input()

a = []

for i in range(len(s)):
    a.append(s[i:])

a.sort()

for _ in a:
    print(_)
