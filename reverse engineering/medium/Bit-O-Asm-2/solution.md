# Bit-O-Asm-2

## 題目描述 (Description)

Can you figure out what is in the eax register? Put your answer in the picoCTF flag format: picoCTF{n} where n is the contents of the eax register in the decimal number base. If the answer was 0x11 your flag would be picoCTF{17}.
Download the assembly dump [here](https://artifacts.picoctf.net/c/510/disassembler-dump0_b.txt).

### 提示 (Hints)

1. Hint 1
   PTR's or 'pointers', reference a location in memory where values can be stored.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：整個程式比較重要的地方就是
    ```text
    <+15>:    mov    DWORD PTR [rbp-0x4],0x9fe1a
    <+22>:    mov    eax,DWORD PTR [rbp-0x4]
    ```
    等於eax = 0x9fe1a。


## Flag

```text
picoCTF{654874}
```