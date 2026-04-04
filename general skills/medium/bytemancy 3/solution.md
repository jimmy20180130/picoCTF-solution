# bytemancy 3

## 題目描述 (Description)

Can you conjure the right bytes? The program's source code can be downloaded [here](https://challenge-files.picoctf.net/c_green_hill/8d0fda8f9ca0900eadd090803f7995f98300149381781022897b7d0245721010/app.py) and the compiled spellbook binary can be downloaded [here](https://challenge-files.picoctf.net/c_green_hill/8d0fda8f9ca0900eadd090803f7995f98300149381781022897b7d0245721010/spellbook).

### 提示 (Hints)

1. Hint 1  
    `objdump -t spellbook` reveals the symbol table.
2. Hint 2  
    Send the addresses as 4 raw bytes in little-endian order.
3. Hint 3  
    `pwnlib.util.packing.p32()` simplifies crafting the payloads.

## 解題思路 (Solution Walkthrough)

1. **第一步**：先看一下 `app.py` 看他產生 `4 raw bytes in little-endian order` 的邏輯，之後就寫一個腳本成功取得 flag

## Flag

```text
picoCTF{0bjdump_m4g1c_bb59765a}
```
