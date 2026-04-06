def steplfsr(lfsr):
    b7 = (lfsr >> 7) & 1
    b5 = (lfsr >> 5) & 1
    b4 = (lfsr >> 4) & 1
    b3 = (lfsr >> 3) & 1

    feedback = b7 ^ b5 ^ b4 ^ b3
    lfsr = (feedback << 7) | (lfsr >> 1)
    return lfsr

ct_hex = "21c1b705764e4bfdafd01e0bfdbc38d5eadf92991cdd347064e37444e517d661cea9" 
ct_bytes = bytes.fromhex(ct_hex)

for seed in range(256):
    lfsr = seed
    res = bytearray()
    for c in ct_bytes:
        lfsr = steplfsr(lfsr)
        res.append(c ^ lfsr)
    
    try:
        decoded = res.decode('ascii')
        if decoded.isprintable() and 'pico' in decoded:
            print(f"Seed {seed}: {decoded}")
            break
    except:
        continue