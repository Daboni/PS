# 백준 4458 번
"""
문제
문장을 읽은 뒤, 줄의 첫 글자를 대문자로 바꾸는 프로그램을 작성하시오.
"""

N = int(input())

for i in range(N):
    s = input()
    s = s[0].upper() + s[1:]
    print(s)
