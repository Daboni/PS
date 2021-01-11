# dp(n,color) = color1 + color2 + min(dp(n-1,color1) + dp(n-1,color2))


N = int(input())

cost = []
for i in range(N):
	co = list(map(int,input().split()))
	cost.append(co)

for i in range(1,N):
    cost[i][0] = cost[i][0] + min(cost[i-1][1],cost[i-1][2])
    cost[i][1] = cost[i][1] + min(cost[i-1][0],cost[i-1][2])
    cost[i][2] = cost[i][2] + min(cost[i-1][0],cost[i-1][1])

print(min(cost[N-1][0],cost[N-1][1],cost[N-1][2]))
