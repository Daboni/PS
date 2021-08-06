# 55 183
# 58 185
# 88 186
# 60 175
# 46 155

# 88 186
# 60 175 2
# 58 185 2
# 55 183 4

n = int(input())

a = [ list(map(int,input().split())) for _ in range(n) ]

for i in range(n):
    cnt = 1
    for j in range(n):
        if a[i][0] < a[j][0] and a[i][1] < a[j][1]:
            cnt += 1
    print(cnt)
