a = ['a','e','i','o','u']

s = input()

res = 0

for _ in s:
    if _ in a:
        res += 1

print(res)
