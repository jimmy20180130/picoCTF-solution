# Bit-O-Asm-4

## 題目描述 (Description)

Can you figure out what is in the eax register? Put your answer in the picoCTF flag format: picoCTF{n} where n is the contents of the eax register in the decimal number base. If the answer was 0x11 your flag would be picoCTF{17}.
Download the assembly dump [here](https://artifacts.picoctf.net/c/511/disassembler-dump0_d.txt).

### 提示 (Hints)

1. Hint 1
   Don't tell anyone I told you this, but you can solve this problem without understanding the compare/jump relationship.
2. Hint 2
   Of course, if you're really good, you'll only need one attempt to solve this problem.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：整個程式比較重要的地方就是：
    ```text
    <+15>:    mov    DWORD PTR [rbp-0x4],0x9fe1a
    <+22>:    cmp    DWORD PTR [rbp-0x4],0x2710
    <+29>:    jle    0x55555555514e <main+37>
    <+31>:    sub    DWORD PTR [rbp-0x4],0x65
    <+35>:    jmp    0x555555555152 <main+41>
    <+37>:    add    DWORD PTR [rbp-0x4],0x65
    <+41>:    mov    eax,DWORD PTR [rbp-0x4]
    ```
    很明顯0x9fe1a比0x2710大，所以<+29>不執行，減掉0x65，跳到<+41>，輸出eax。
    eax = 0x9fe1a - 0x65 = 654874 - 101 = 654773


## Flag

```text
picoCTF{654773}
```