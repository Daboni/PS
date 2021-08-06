A,B = input().split()

res = 0

def summ(A):
    A = list(A)
    A = map(int,A)

    return sum(A)

res = summ(A)*summ(B)

print(res)
