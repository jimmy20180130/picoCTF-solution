a = 1854822502

if(a<=100):
    a = 7
else:
    if(a>399):
        a += 115
    else:
        a += 14

print(format(a, 'x'))