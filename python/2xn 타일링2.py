# 1) n % 2 == 1  dp(n) = dp(n-1) + dp(n//2)
# 2) n % 2 == 0  dp(n) = dp(n//2)

n = int(input())

# dp(2) = 3
# dp(3) = 5  
# dp(4) = 11  
# dp(5) = 21 
#    6    43
#    7    85
#    8    171
#    9    341
#    10   683
#    11   1365
#    12   2731

# 1) n % 2 == 0 : dp(n)=dp(n-1)*2+1
# 1) n % 2 == 1 : dp(n)=dp(n-1)*2-1

"""
def dp(n):
    if n == 1:
        return 1
    if n %2 == 0:
        return dp(n-1) * 2 + 1
    if n %2 == 1:
        return dp(n-1) * 2 - 1
"""
res = 1

for i in range(1,n):
    if i %2 == 1:
        res = res * 2 +1
    else:
        res = res * 2 -1


#print(dp(n))

print(res%10007)
