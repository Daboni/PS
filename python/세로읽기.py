a = []
maxi = 0

for i in range(5):
    s = input()
    a.append(s)
    if len(s)>maxi:
        maxi = len(s)

res = ""

for i in range(maxi):
    for j in range(5):
        if i < len(a[j]):
            res += a[j][i]
        else: continue
