# AI 寫的，假設真的要用 python 的話

import struct

def generate_table():
    e_table = [0] * 256
    d_table = [0] * 0xF10

    for i in range(256):
        count, shift, value = 4, 0, i
        mask, mode = 0, 0
        while count != 0:
            bit_mask = value & 3
            mask_shift = 1 if bit_mask > 1 else 0
            mode_shift = 1 if (bit_mask == 0 or bit_mask == 3) else 0
            mask |= mask_shift << shift
            mode |= mode_shift << shift
            count -= 1
            shift += 1
            value >>= 2
        mask = (mode << 8) | mask
        e_table[i] = mask
        d_table[mask] = i
        mask, mode = 0, 0
    return e_table, d_table

def generate_mask(v):
    mask_val = 0x0101_0101_0101_0101
    vt = v
    bv = 0
    bz = 0x0808_0808_0808_0808
    shift = 8
    while shift != 0:
        bm = mask_val & vt
        bv += bm
        bz -= bm
        vt >>= 1
        shift -= 1
    return (((bz << 4) | bv) ^ ((bv << 4) | bz) ^ v) & 0xFFFFFFFFFFFFFFFF

def build_cipher(key_bytes):
    key_len = len(key_bytes)
    # LCM of key_len and 8
    def gcd(a, b):
        while b:
            a, b = b, a % b
        return a
    rep = (key_len // gcd(key_len, 8)) * 8

    data = bytes([key_bytes[i % key_len] for i in range(rep)])
    cipher_64 = []
    for i in range(0, rep, 8):
        val = struct.unpack_from('<Q', data, i)[0]
        cipher_64.append(generate_mask(val))
    return cipher_64

def decrypt_vec(buffer, key_str):
    key_bytes = key_str.encode()
    e_table, d_table = generate_table()
    cipher = build_cipher(key_bytes)
    cipher_len = len(cipher)

    b_len = len(buffer)
    # Pad to multiple of 8
    pad = (8 - b_len % 8) % 8
    data = bytearray(buffer) + bytearray(pad)

    # Work in 8-byte (usize) chunks
    n_full = b_len // 8
    odd = (b_len % 8) != 0

    result = bytearray(b_len)

    def decrypt_chunk(val, cipher_byte):
        val = (val ^ cipher_byte) & 0xFFFFFFFFFFFFFFFF
        xi = (((val & 0x00FF_00FF_00FF_00FF) << 8) ^ val) & 0xFFFFFFFFFFFFFFFF
        out = (d_table[xi & 0x0F0F]
             | d_table[(xi >> 0x4) & 0x0F0F] << 0x8
             | d_table[(xi >> 0x10) & 0x0F0F] << 0x10
             | d_table[(xi >> 0x14) & 0x0F0F] << 0x18
             | d_table[(xi >> 0x20) & 0x0F0F] << 0x20
             | d_table[(xi >> 0x24) & 0x0F0F] << 0x28
             | d_table[(xi >> 0x30) & 0x0F0F] << 0x30
             | d_table[(xi >> 0x34) & 0x0F0F] << 0x38)
        return out

    for i in range(n_full):
        val = struct.unpack_from('<Q', data, i * 8)[0]
        out = decrypt_chunk(val, cipher[i % cipher_len])
        struct.pack_into('<Q', result, i * 8, out & 0xFFFFFFFFFFFFFFFF)

    if odd:
        byte_count = b_len - 8 * n_full
        val = struct.unpack_from('<Q', data, n_full * 8)[0]
        val = (val ^ cipher[n_full % cipher_len]) & 0xFFFFFFFFFFFFFFFF
        xi = (((val & 0x00FF_00FF_00FF_00FF) << 8) ^ val) & 0xFFFFFFFFFFFFFFFF

        lxi = 0
        shift = 0
        bc = byte_count
        while bc > 1:
            lxi |= (d_table[(xi >> shift) & 0x0F0F] << shift) & 0xFFFFFFFFFFFFFFFF
            lxi |= (d_table[(xi >> shift >> 4) & 0x0F0F] << 8 << shift) & 0xFFFFFFFFFFFFFFFF
            shift += 0x10
            bc -= 2
        if bc == 1:
            mm = (xi >> shift) & 0xFF
            mm ^= mm >> 4
            mm = ((mm & 0xF0) >> 4) | ((mm & 0xF) << 8)
            lxi |= (d_table[mm] << shift) & 0xFFFFFFFFFFFFFFFF

        chunk = struct.pack('<Q', lxi & 0xFFFFFFFFFFFFFFFF)
        for j in range(byte_count):
            result[n_full * 8 + j] = chunk[j]

    return bytes(result)

def main():
    hex_values = ["41","30","20","63","4a","45","54","76","12","90","7e","53","63","e1","01","35","7e","59","60","f6","03","86","7f","56","41","29","30","6f","08","c3","61","f9","35"]
    encrypted = bytes([int(h, 16) for h in hex_values])

    party_foul = "Using memory unsafe languages is a: "
    party_foul += "PARTY FOUL! Here is your flag: "
    decrypted = decrypt_vec(encrypted, "CSUCKS")
    party_foul += decrypted.decode('utf-8', errors='replace')
    print(party_foul)

if __name__ == "__main__":
    main()