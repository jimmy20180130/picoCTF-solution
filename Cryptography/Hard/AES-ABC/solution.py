from PIL import Image

# 讀檔
with open('Cryptography/Hard/AES-ABC/body.enc.ppm', 'rb') as f:
    data = f.read()

# 分header/切成16 bytes的blocks
header_end = data.find(b'\n255\n') + len(b'\n255\n')
header = data[:header_end]
body = data[header_end:]
blocks = [body[i:i+16] for i in range(0, len(body), 16)]

# 逆運算
UMAX = 256 ** 16

recovered = []

for i in range(1, len(blocks)):

    prev = int(blocks[i-1].hex(), 16)
    curr = int(blocks[i].hex(), 16)

    Ci = (curr - prev) % UMAX

    recovered.append(Ci.to_bytes(16, "big"))

# 還原
new_body = b''.join(recovered)

# 匯出明文
with open("Cryptography/Hard/AES-ABC/recovered.ppm", "wb") as f:
    f.write(header)
    f.write(new_body)

# 轉檔(.ppm轉換成.png)
img = Image.open("Cryptography/Hard/AES-ABC/recovered.ppm")
img.save("Cryptography/Hard/AES-ABC/flag.png")
