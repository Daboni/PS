a = list(input().split())


s1 = a[0]
s2 = a[1]
strings = []
for i in range(len(s2)-len(s1)+1):
    s = ""
    s = s2[:i] + s1 + s2[len(s1)+i:]
    strings.append(s)

mini = 99
cnt = 0
for string in strings:
    for i in range(len(string)):
        if string[i] != s2[i]:
            cnt += 1
    if mini>cnt :
        mini = cnt
    cnt = 0

print(mini)
