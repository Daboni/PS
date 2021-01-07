# 백준 9093
"""
문제

문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.

입력

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있으며, 문장이 하나 주어진다.
단어의 길이는 최대 20, 문장의 길이는 최대 1000이다. 단어와 단어 사이에는 공백이 하나 있다.
"""

n = int(input())

strings = []
res = []
for i in range(n):
    a = input()
    strings.append(a)

for string in strings:
    s = string.split()
    for i, s1 in enumerate(s):
        s[i] = s1[::-1]
    res.append(' '.join(s))

for s in res:
    print(s)
