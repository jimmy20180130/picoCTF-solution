enc = bytes.fromhex('F9DFDACFD8F9CFC9DFD8CF')
result = "".join([chr(b ^ 0xAA) for b in enc])
print(result)