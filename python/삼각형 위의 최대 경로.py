a = [[1],[1,2],[3,7,4],[9,4,1,7],[2,7,5,9,4]]

cache = [[0 for _ in range(5)] for __ in range(5)]

# dp(y,x) = max(dp(y+1,x) dp(y,x+1)) + sum

def dp(y,x):
    if y == 4 :
        return a[y][x]
    if cache[y][x] != 0:
        return cache[y][x]
    cache[y][x] = a[y][x] + max(dp(y+1,x),dp(y+1,x+1))
    return cache[y][x]

