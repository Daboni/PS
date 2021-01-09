T = int(input())
arr = []
for i in range(T):
    s = input()
    arr.append(s)

for s in arr:
    tmp = s.split(',')
    total = int(tmp[0])+int(tmp[1])
    print(total)
