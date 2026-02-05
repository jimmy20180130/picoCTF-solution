def decode(ciphertext, key):
    result = []
    key = key.upper()
    keylength = len(key)
    keyposition = 0

    for c in ciphertext.upper():
        if 'A' <= c <= 'Z':
            en = ord(c) - ord('A')
            k = ord(key[keyposition % keylength]) - ord('A')

            de = (en - k) % 26

            result.append(chr(de + ord('A')))
            keyposition += 1
        else:
            result.append(c) #非字母直接保留

    return ''.join(result)

cipher = input()
key = input()
print(decode(cipher, key))