a = input()

N = len(a)

it = len(a)//10

for i in range(it):
    s = a[:10]
    a = a[10:]
    print(s)
    
if len(a) != 0:
    print(a)
