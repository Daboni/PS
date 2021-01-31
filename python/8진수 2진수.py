import sys

n = sys.stdin.readline().strip('\n')

n = list(n)

a = {'0': '000','1':'001','2':'010','3':'011','4':'100','5':'101','6':'110','7':'111'}

res = a[n[0]]
res = str(int(res))

for c in n[1:]:
    res += a[c]

print(res)
