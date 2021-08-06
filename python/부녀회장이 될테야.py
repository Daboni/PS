# 1 3 6
# 1 2 3

# 1 4 10
# 1 3 6
# 1 2 3

a = [ [0]*15 for _ in range(15) ]

for i in range(15):
    for j in range(1,15):
        if j == 1:
            a[i][j] = 1
            continue
        if i == 0:
            a[i][j] = j
            continue

        a[i][j] = a[i][j-1] + a[i-1][j]


t = int(input())

while t:
    k = int(input())
    n = int(input())

    print(a[k][n])
    t -= 1
