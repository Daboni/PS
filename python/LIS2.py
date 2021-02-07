from bisect import bisect_left

N = int(input())

a = list(map(int,input().split()))

lis = []

for i in a:
    k = bisect_left(lis,i)
    if len(lis) <= k:
        lis.append(i)
    else:
        lis[k] = i
                
print(len(lis))
