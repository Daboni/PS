# 백준 1463 번
"""
문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

(1) X가 3으로 나누어 떨어지면, 3으로 나눈다.
(2) X가 2로 나누어 떨어지면, 2로 나눈다.
(3) 1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
"""

n =  int(input())

cnt = [ 0 for i in range(n+1)]

for i in range(2,n+1):
    cnt[i] = cnt[i-1] + 1
    if i%3==0 and cnt[i//3] +1 < cnt[i]:
        cnt[i] = cnt[i//3] + 1
    if i%2==0 and cnt[i//2] +1 < cnt[i]:
        cnt[i] = cnt[i//2] + 1

print(cnt[n])
