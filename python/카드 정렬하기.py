import heapq

n= int(input())

heap = []

for _ in range(n):
    i = int(input())
    heapq.heappush(heap,i)

if n == 1:
    res = 0

res = 0

while(1):
    if len(heap) == 1:
        break
    A = heapq.heappop(heap)
    B = heapq.heappop(heap)
    res += (A+B)
    heapq.heappush(heap,A+B)
    

print(res)

# 10 10 20 20 20

# 10 10 20
# 20 20 40
# 40 20 60
# 60 20 80
