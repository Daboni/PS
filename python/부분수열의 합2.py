n = int(input())

a = list(map(int,input().split()))

check = [0]*2000001

def go(index,s):

    if index == n:
        check[s] = 1
        return
    go(index+1,s+a[index])
    go(index+1,s)

go(0,0)

a = list(set(a))

for i,j in enumerate(check):
    if j == 0:
        print(i)
        break
