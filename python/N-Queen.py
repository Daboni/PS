n = int(input())

a = [ [False]*n for _ in range(n) ]
check_col = [False] * n
check_dig = [False] * (2*n-1)
check_dig2 = [False] * (2*n-1)

def check(row,col):
    if check_col[col]:
        return False
    if check_dig[row+col]:
        return False
    if check_dig2[row-col+n-1]:
        return False
    return True

def go(row):
    if row == n:
        return 1
    ans = 0

    for col in range(n):
        if check(row,col):
            check_col[col] = True
            check_dig[row+col] = True
            check_dig2[row-col+n-1] = True
            a[row][col] = True
            ans += go(row+1)
            check_col[col] = False
            check_dig[row+col] = False
            check_dig2[row-col+n-1] = False
            a[row][col] = False

    return ans

print(go(0))
