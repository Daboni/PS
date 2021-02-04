n = int(input())

a = []

for i in range(n):
    a.append(input())

total_rows = 0

for i in range(n):
    cnt = 0
    for j in range(n):
        if a[i][j] == '.':
            cnt += 1                
        if a[i][j] == 'X' or j == n-1:
            if cnt >= 2:
                total_rows += 1
            cnt = 0

print(total_rows,end=' ')       

total_cols = 0

for j in range(n):
    cnt = 0
    for i in range(n):
        if a[i][j] == '.':
            cnt += 1                
        if a[i][j] == 'X' or i == n-1:
            if cnt >= 2:
                total_cols += 1
            cnt = 0

print(total_cols)
