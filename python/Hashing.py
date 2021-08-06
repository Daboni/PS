n = int(input())

s = input()

M = 1234567891

ans = 0
for i,c in enumerate(s):

    ans= (ans + ((ord(c)-96)*pow(31,i))%M)%M

print(ans)
