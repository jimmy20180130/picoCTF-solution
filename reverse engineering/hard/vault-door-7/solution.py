myBytes = [
    1096770097,
    1952395366,
    1600270708,
    1601398833,
    1716808014,
    1734305081,
    1681274424,
    1700935729
]

flag = ''

for i in myBytes:

    b0 = (i >> 24) & 0xff
    b1 = (i >> 16) & 0xff
    b2 = (i >> 8) & 0xff
    b3 = i & 0xff

    flag += chr(b0)
    flag += chr(b1)
    flag += chr(b2)
    flag += chr(b3)

print(flag)