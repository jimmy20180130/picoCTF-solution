import zlib

chunk_type = bytes.fromhex("70 48 59 73")
# x x x x y y y y unit
chunk_data = bytes.fromhex("00 00 16 25 00 00 16 25 01")

target_data = chunk_type + chunk_data
computed_crc = zlib.crc32(target_data) & 0xFFFFFFFF
print(hex(computed_crc))