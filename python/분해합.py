a= [0]*1000001

for i in range(1,1000001):
    tmp = i
    j = i
    while j>0:
        tmp += j % 10
        j //= 10
    
    if tmp <= 1000000:
        if a[tmp] == 0:
            a[tmp] = i


n = int(input())
print(a[n])
