a = list(map(int,input().split()))

coins = []

for i in range(a[0]):
    coins.append(int(input()))

coins.reverse()

price = a[1]

res = 0

for coin in coins:

    if price == 0:
        break
    res += price // coin
    price %= coin

print(res)
