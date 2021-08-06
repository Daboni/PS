x,y = map(int,input().split())

a = [ input() for _ in range(x) ]

check = [ [0]*(y-7) for _ in range(x-7) ]


for i in range(x-7):
    for j in range(y-7):
        cnt1 = 0
        cnt2 = 0
        for dx in range(8):
            for dy in range(8):
                nx = i+dx
                ny = j+dy
                
                if nx % 2 == 0:
                    if ny % 2 ==0:
                        if a[nx][ny] != 'W':
                            cnt1 += 1
                    else:
                        if a[nx][ny] != 'B':
                            cnt1 += 1
                else:
                    if ny % 2 ==0:
                        if a[nx][ny] != 'B':
                            cnt1 += 1
                    else:
                        if a[nx][ny] != 'W':
                            cnt1 += 1

                if nx % 2 == 0:
                    if ny % 2 ==0:
                        if a[nx][ny] != 'B':
                            cnt2 += 1
                    else:
                        if a[nx][ny] != 'W':
                            cnt2 += 1
                else:
                    if ny % 2 ==0:
                        if a[nx][ny] != 'W':
                            cnt2 += 1
                    else:
                        if a[nx][ny] != 'B':
                            cnt2 += 1

        check[i][j] = min(cnt1,cnt2)
        
print(min(map(min,check)))
