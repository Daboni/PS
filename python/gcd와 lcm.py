def gcd(a,b):
    if b == 0:
        return a
    else:
        return gcd(b,a%b)

a,b = map(int,input().split())

Gcd = gcd(a,b)
Lcm = Gcd*(a//Gcd)*(b//Gcd)
print(Gcd)
print(Lcm)
