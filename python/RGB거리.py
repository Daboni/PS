# 백준 1149 번
"""
문제
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1) 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
2) N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
3) i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

입력
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다.
집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
"""

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
