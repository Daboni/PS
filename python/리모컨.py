n = int(input())

m = int(input())

broken = [0]*10

if m > 0:
    a = list(map(int,input().split()))
else:
    a = []

for i in a:
    broken[i] = True


def count(c):
    cnt = 0
    if c == 0:
        if broken[0] == True:
            return 0
        else:
            return 1

    while c>0:
        if broken[c%10]:
            return 0
        else:
            cnt += 1
            c //= 10

    return cnt


ans = n - 100

if ans < 0:
    ans = abs(ans)

for i in range(1000000+1):
    cnt = count(i)
    
    if cnt != 0:
        tmp = abs(i-n)
        if tmp + cnt < ans:
            ans = tmp + cnt

print(ans)
