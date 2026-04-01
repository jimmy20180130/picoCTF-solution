def hash(secret_bytes):
    h = 5381
    for b in secret_bytes:
        if b == 0:
            break
        # h * 33 + char
        h = ((h << 5) + h) + b

        # 模擬 64-bit 溢位 (unsigned __int64)
        h &= 0xFFFFFFFFFFFFFFFF

    return h

def solve():
    obf_bytes = [
        0xC3, 0xFF, 0xC8, 0xC2, 0x92, 0x9B, 0x8B, 0xC0, 0x80, 0xC2, 0xC4, 0x8B
    ]
    
    # XOR 0xAA
    secret_decrypted = [(b ^ 0xAA) for b in obf_bytes]
    
    print(f"Decrypted string: {''.join(chr(x) for x in secret_decrypted)}")
    
    result = hash(secret_decrypted)
    print(f"Hash (Decimal): {result}")

solve()