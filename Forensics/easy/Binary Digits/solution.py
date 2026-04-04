with open('digits.bin', 'r') as f:
    bit_str = f.read().strip()

byte_data = bytes(int(bit_str[i:i+8], 2) for i in range(0, len(bit_str), 8))

with open('solution.jpg', 'wb') as f_out:
    f_out.write(byte_data)