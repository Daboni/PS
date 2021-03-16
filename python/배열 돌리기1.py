n,m,r = map(int,input().split())
a = [ list(map(int,input().split())) for _ in range(n) ]

# 0,0 , 0,1 , 0,2 , 0,3 , 1,3 , 2,3, 3,3 , 3,2 , 3,1 , 3,0 , 2,0 , 1,0
# 1,1 , 1,2 , 2,2 , 2,1

groups = []
Len  = min(n,m)//2
for k in range(Len):
    group = []
    # a[k][j] (k<=j<m-k)
    for j in range(k,m-k):
        group.append(a[k][j])
    # a[i][m-k-1] (k<=i<n-k)
    for i in range(k+1,n-k-1):
        group.append(a[i][m-k-1])
    # a[n-k-1][j] (k<=j<m-k)
    for j in range(m-k-1,k,-1):
        group.append(a[n-k-1][j])
    # a[i][k] (k<=i<n-k)
    for i in range(n-k-1,k,-1):
        group.append(a[i][k])

    groups.append(group)

for k in range(Len):
    group = groups[k]
    l = len(group)
    index = r%l

    for j in range(k,m-k):
        a[k][j] = group[index]
        index = (index+1)%l
    for i in range(k+1,n-k-1):
        a[i][m-k-1] = group[index]
        index = (index+1)%l
    for j in range(m-k-1,k,-1):
        a[n-k-1][j] = group[index]
        index = (index+1)%l
    for i in range(n-k-1,k,-1):
        a[i][k] = group[index]
        index = (index+1)%l

for row in a:
    print(' '.join(map(str,row)))
