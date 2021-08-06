n =  int(input())

cnt = [ 0 for i in range(n+1)]

for i in range(2,n+1):
    cnt[i] = cnt[i-1] + 1
    if i%3==0 and cnt[i//3] +1 < cnt[i]:
        cnt[i] = cnt[i//3] + 1
    if i%2==0 and cnt[i//2] +1 < cnt[i]:
        cnt[i] = cnt[i//2] + 1

print(cnt[n])
