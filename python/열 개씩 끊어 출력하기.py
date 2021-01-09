# 백준 11721 번
"""
문제
알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다.
한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오.
"""

a = input()

N = len(a)

it = len(a)//10

for i in range(it):
    s = a[:10]
    a = a[10:]
    print(s)
    
if len(a) != 0:
    print(a)
