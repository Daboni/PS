L = int(input())

s = input()

a = [0 for _ in range(len(s))]
j = 0

for i in range(1,len(s)):
    while j > 0 and s[i] != s[j]:
        j = a[j-1]
    if s[i] == s[j]:
        j += 1
        a[i]=j

res = len(s) - a[len(s)-1]
print(res)
