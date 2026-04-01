def decrypt(hex_input, key):
    encrypted_bytes = bytes.fromhex(hex_input)
    decrypted = ""
    
    for i in range(len(encrypted_bytes)):
        # 對 key 做 XOR
        decrypted += chr(encrypted_bytes[i] ^ ord(key[i % len(key)]))
        
    return decrypted

key = "S3Cr3t"
hex_data = "235a201d702015483b1d412b265d3313501f0c072d135f0d2002302d5011305120100a452e"

print(f"flag: {decrypt(hex_data, key)}")