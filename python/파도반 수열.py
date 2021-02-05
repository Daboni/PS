# 1
# 1
# 1
# 2
# 2
# 1 + 2 = 3   P(1)+P(5) = P(6)
# 1 + 3 = 4   P(2)+P(6) = P(7)
# 1+ 4 = 5    P(3)+P(7) = P(8)
# 2 + 5 = 7   ...
# 2 + 7 = 9
# 3 + 9 = 12
# 4 + 12 = 16
# 5 + 16 = 21 P(8)+P(12)=P(13)

N = int(input())

P = [0,1,1,1,2,2,3,4,5,7,9,12,16]

for i in range(N):
    n = int(input())
    if n<len(P):
        print(P[n])
        continue
    for j in range(len(P),n+1):
        P.append(P[j-1]+P[j-5])
    print(P[n])
