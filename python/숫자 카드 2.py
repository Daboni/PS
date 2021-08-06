n = int(input())
a = list(map(int,input().split()))

d = {}

for i in a:
    if i in d:
        d[i] +=1
    else:
        d[i] = 1
        
m = int(input())
b = list(map(int,input().split()))

'''
for i in b:
    if i in a:
        print(d[i])
    else:
        print(0)
'''

print(' '.join(str(d[i]) if i in d else '0' for i in b))
