# 백준 10173번
"""
문제
영어 문장속 숨어있는 니모(Nemo)를 찾아보자.
니모를 찾는데 있어서 대소문자는 중요하지 않다.

입력
여러 문장이 각 줄로 입력되며, 입력의 마지막에는 "EOI" 입력된다.
한 줄은 최대 80개의 글자로 이루어져 있다.

출력
숨겨진 니모를 찾으면 “Found”, 못찾으면 “Missing”를 각 줄에 맞게 출력하면 된다.
"""


while(1):
    s = input()
    if s == 'EOI':
        break
    s = s.lower()
    if s.find('nemo')!= -1:
        print('Found')
        continue
  
    print('Missing')
