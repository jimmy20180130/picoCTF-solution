word = 'vkpfj'.encode('ascii')
big_endian = word.hex()
little_endian = word[::-1].hex()
print(little_endian, big_endian)