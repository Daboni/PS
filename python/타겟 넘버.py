a = list(map(int,input().split()))
t = int(input())

ans = 0

def solution(numbers,target,index,s):
    global ans

    if index == len(numbers):
        if s == target:
            ans += 1
        return 
    solution(numbers,target,index+1,s+numbers[index])
    solution(numbers,target,index+1,s-numbers[index])

solution(a,t,0,0)

print(ans)
