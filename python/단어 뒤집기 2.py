a = input()


res = ""
token = 0
temp = ""
for ch in a:

    if ch == '<':
        if temp != "":
            res += temp[::-1]
            temp = ""
        token = 1
    if ch == '>':
        res += ch
        token = 0
        continue

    if token == 1:
        res += ch
    else :
        if ch != ' ':
            temp += ch
        else :
            res += temp[::-1]
            res += ' '
            temp = ""

if temp != "":
    res += temp[::-1]
print(res)
