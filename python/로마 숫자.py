import sys

rom = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}

en_rom = { 1:'I',5:'V',10:'X',50:'L',100:'C',500:'D',1000:'M',4:'IV',9:'IX',
           40:'XL',90:'XC',400:'CD',900:'CM'}

a = sys.stdin.readline().strip('\n')
b = sys.stdin.readline().strip('\n')

def make_val(a):
    val = 0
    for i in range(len(a)):
        cur = a[i]

        if i != len(a)-1:
            nxt = a[i+1]        
            if rom[cur] < rom[nxt]:
                val -= rom[cur]
                continue
        val += rom[cur]
    return val

res_val = make_val(a)+make_val(b)
print(res_val)

t = res_val // 1000; res_val = res_val % 1000
h = res_val // 100; res_val = res_val % 100
d = res_val // 10; res_val = res_val % 10
r = res_val

res = ""

res += en_rom[1000] * t
if h == 4:
    res += 'CD'
elif h == 9:
    res += 'CM'
elif h<4:
    res += en_rom[100] * h
else:
    res += en_rom[500]
    res += en_rom[100] * (h-5)

if d == 4:
    res += 'XL'
elif d == 9:
    res += 'XC'
elif d<4:
    res += en_rom[10] * d
else:
    res += en_rom[50]
    res += en_rom[10] * (d-5)

if r == 4:
    res += 'IV'
elif r == 9:
    res += 'IX'
elif r<4:
    res += en_rom[1] * r
else:
    res += en_rom[5]
    res += en_rom[1] * (r-5)


print(res)
