# Bit-O-Asm-1

## 題目描述 (Description)

Can you figure out what is in the eax register? Put your answer in the picoCTF flag format: picoCTF{n} where n is the contents of the eax register in the decimal number base. If the answer was 0x11 your flag would be picoCTF{17}.
Download the assembly dump [here](https://artifacts.picoctf.net/c/509/disassembler-dump0_a.txt).

### 提示 (Hints)

1. Hint 1
   As with most assembly, there is a lot of noise in the instruction dump. Find the one line that pertains to this question and don't second guess yourself!

## 解題思路 (Solution Walkthrough)

1.  **第一步**：稍微看了一下整個程式，結果什麼都沒動到，最後給個eax=48就回傳了。


## Flag

```text
picoCTF{48}
```