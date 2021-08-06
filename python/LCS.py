a = input()
b = input()

c = [ [ 0 for col in range(len(b)+1)] for row in range(len(a)+1)]

def lcs(x,y):
    for i in range(1,len(a)+1):
        for j in range(1,len(b)+1):
            
            if a[i-1] == b[j-1] :
                c[i][j] = c[i-1][j-1]+1
            else :
                c[i][j] = max(c[i][j-1],c[i-1][j])

    return c[i][j]


print(lcs(a,b))
