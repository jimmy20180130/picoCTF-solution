# Bit-O-Asm-3

## 題目描述 (Description)

Can you figure out what is in the eax register? Put your answer in the picoCTF flag format: picoCTF{n} where n is the contents of the eax register in the decimal number base. If the answer was 0x11 your flag would be picoCTF{17}.
Download the assembly dump [here](https://artifacts.picoctf.net/c/530/disassembler-dump0_c.txt).

### 提示 (Hints)

1. Hint 1
   PTR's or 'pointers', reference a location in memory where values can be stored.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：整個程式比較重要的地方就是：
    ```text
    <+15>:    mov    DWORD PTR [rbp-0xc],0x9fe1a
    <+22>:    mov    DWORD PTR [rbp-0x8],0x4
    <+29>:    mov    eax,DWORD PTR [rbp-0xc]
    <+32>:    imul   eax,DWORD PTR [rbp-0x8]
    <+36>:    add    eax,0x1f5
    ```
    eax = (0x9fe1a * 0x4) + 0x1f5 = (654874 * 4) + 501 = 2619997


## Flag

```text
picoCTF{2619997}
```