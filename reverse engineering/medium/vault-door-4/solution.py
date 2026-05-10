myBytes = [
    106 , 85  , 53  , 116 , 95  , 52  , 95  , 98,
    0x55, 0x6e, 0x43, 0x68, 0x5f, 0x30, 0x66, 0x5f,
    0o142, 0o131, 0o164, 0o63, 0o163, 0o137, 0o145, 0o60,
    '2', '1', '3', '8', '7', '2', '1', '3',
]

result = ''

for b in myBytes:
    if isinstance(b, int):
        result += chr(b)
    else:
        result += b

print(result)