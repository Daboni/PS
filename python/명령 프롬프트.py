N = int(input())

files = []
for i in range(N):
    file = input()
    files.append(file)

res = ""

for i in range(len(files[0])):
    ch = files[0][i]
    for j,f in enumerate(files):
        if ch == '?' and f[i] != '?':
            ch = f[i]
        if f[i] != '?' and f[i] != ch:
            res += '?'
            break
        else:
            if j == N-1:
                res += ch
            continue

print(res)
