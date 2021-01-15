n = list(map(int,input().split()))

s = {}
for _ in range(n[0]):
    string = input()
    s[string] = 0

check = []
for _ in range(n[1]):
    check.append(input())

res = 0
for ch in check:
    if ch in s:
        res += 1

print(res)
