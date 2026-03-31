from hashlib import sha256
import time
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad

def decrypt(ciphertext: str, timestamp: int) -> str:
    key = sha256(str(timestamp).encode()).digest()[:16]
    cipher = AES.new(key, AES.MODE_ECB)
    decrypted = cipher.decrypt(bytes.fromhex(ciphertext))
    return decrypted.decode().rstrip('\x00') # remove padding

result = decrypt("030ea2b59ea3cad39da9dfff761acc2598161c602243e2b0e9e571cee8285b87", 1770242637)
print(result)
