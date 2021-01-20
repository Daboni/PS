# 백준 2495 번
"""
문제
여덟 자리의 양의 정수가 주어질 때, 그 안에서 연속하여 같은 숫자가 나오는 것이 없으면 1을 출력하고,
있으면 같은 숫자가 연속해서 나오는 구간 중 가장 긴 것의 길이를 출력하는 프로그램을 작성하라. 

예를 들어 세 개의 숫자 12345123, 17772345, 22233331이 주어졌다고 하자. 12345123은 연속하여 같은 숫자가 나오는 것이 없으므로 1을 출력하고,
17772345는 7이 세 개 연속하여 나오므로 3을 출력하며,
22233331의 경우에는 2가 세 개, 3이 네 개 연속해서 나오므로 그 중 큰 값인 4를 출력하여야 한다.  

입력
첫째 줄부터 셋째 줄까지 각 줄에 하나씩 세 개의 여덟 자리 양의 정수가 주어진다.
"""

for i in range(3):
    s = input()
    maxi = 1
    cnt = 1
    ch = s[0]
    for _ in s[1:]:
        if _ == ch:
            cnt += 1
        else:
            ch = _
            cnt = 1
        if maxi < cnt:
            maxi = cnt
            
    print(maxi)
