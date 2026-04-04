from pwn import *

BINARY_PATH = "./spellbook"
elf = ELF(BINARY_PATH, checksec=False)

io = remote("green-hill.picoctf.net", 54923) 

for i in range(3):
    io.recvuntil(b"procedure '")
    symbol_name = io.recvuntil(b"'").strip(b"'").decode()
    
    log.info(f"Challenge {i+1}: Finding address for {symbol_name}")
    
    addr = elf.symbols[symbol_name]
    payload = p32(addr)
    
    log.success(f"Sending address: {hex(addr)} -> {payload}")
    
    io.send(payload)

io.interactive()